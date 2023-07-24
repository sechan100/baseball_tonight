package com.baseballtonight.dao.reservation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import com.baseballtonight.dao.DAO;
import com.baseballtonight.dto.Member;
import com.baseballtonight.service.reservation.ReserveService;
import com.baseballtonight.util.console.Coloring;

public class ReserveDAO {
	DAO dao = new DAO();

	public HashSet<Integer> showGameList(String SQL) {
		try {
			HashSet<Integer> gameIdSet = new HashSet<>();
			ResultSet rs = dao.select(SQL);
			System.out
				.println("--------------------------------------------------------------------------------------");
			while(rs.next()) {
				String name = Coloring.cyan + rs.getString(2) + Coloring.exit;
				String stadium = Coloring.yellow + rs.getString(3) + Coloring.exit;
				String dateAndTime = rs.getString(4);
				System.out.printf("게임번호: %d | %-20s | 경기장: %-12s | %s \n", rs.getInt(1), name, stadium, String
					.valueOf(MyreserveDAO.trimDateAndTime(dateAndTime, MyreserveDAO.getDayOfWeek(rs.getInt(11)))));
				System.out
					.println("--------------------------------------------------------------------------------------");
				gameIdSet.add(rs.getInt(1));
			}
			rs.close();
			return gameIdSet;
		} catch(SQLException e) {
			System.out.println("SQLException!: " + e);
		}
		return null;
	}

	public void showSeatList(int game_id) {
		String loadSeatStatus = "SELECT *, DAYOFWEEK(dateAndTime) As part FROM games WHERE id = " + game_id;
		try {
			ResultSet rs = dao.select(loadSeatStatus);
			rs.next();

			int[] priceData = loadPriceData(MyreserveDAO.getDayOfWeek(rs.getInt("part")));
			String seatList = Coloring.getPurple(
				"-------------------------------------------\n"
					+ "PREMIUM석: 최고의 자리, 후회없는 경기 직관\n")
				+ getNumberOfAvailableSeat("premium") + " | 가격: " + priceData[0] + "\n\n"
				+ Coloring.getYellow(
					"-------------------------------------------\n"
						+ "TABLE석: 편안한 테이블과 함께 입이 즐거운 관람\n")
				+ getNumberOfAvailableSeat("table") + " | 가격: " + priceData[1] + "\n\n"
				+ Coloring.getBlue(
					"-------------------------------------------\n"
						+ "BLUE석: 쾌적한 자리, 중앙에서 외야를 조망\n")
				+ getNumberOfAvailableSeat("blue") + " | 가격: " + priceData[2] + "\n\n"
				+ Coloring.getRed(
					"-------------------------------------------\n"
						+ "RED석: 일반석, 합리적인 가격에 경기를 관람\n")
				+ getNumberOfAvailableSeat("red") + " | 가격: " + priceData[3] + "\n\n"
				+ Coloring.getCyan(
					"-------------------------------------------\n"
						+ "NAVY석: 안락한 위층에서 경기를 한눈에 조망\n")
				+ getNumberOfAvailableSeat("navy") + " | 가격: " + priceData[4] + "\n\n"
				+ Coloring.getGreen(
					"-------------------------------------------\n"
						+ "GREEN석: 가족과 함께 경기를 즐기고 홈런볼의 주인이 되세요!\n")
				+ getNumberOfAvailableSeat("green") + " | 가격: " + priceData[5] + "\n\n"
				+ "-------------------------------------------\n";
			System.out.print(seatList);
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	public int[] loadPriceData(String dayOfWeek) throws SQLException {
		ResultSet priceData = dao.select(
			"SELECT seatType, block_scope, weekdayPrice, weekendPrice FROM seatType ORDER BY weekdayPrice DESC");
		int[] price = new int[6];
		int ColumnNumberByDayOfWeek;
		if(dayOfWeek.equals("월요일") ||
			dayOfWeek.equals("화요일") ||
			dayOfWeek.equals("수요일") ||
			dayOfWeek.equals("목요일") ||
			dayOfWeek.equals("금요일")) {
			ColumnNumberByDayOfWeek = 3;
		} else {
			ColumnNumberByDayOfWeek = 4;
		}
		int i = 0;
		while(priceData.next()) {
			price[i] = priceData.getInt(ColumnNumberByDayOfWeek);
			i++;
		}
		priceData.close();
		return price;
	}

	public String getNumberOfAvailableSeat(String seat_type) {
		int number_of_available_seat = new SeatDAO().getNumberOfAvailableSeatBySeatType(ReserveService.game_id,
			seat_type);
		if(number_of_available_seat != 0) {
			return "예매 가능한 좌석: " + number_of_available_seat + "석";
		} else {
			return "예약 가능한 좌석이 없습니다.";
		}
	}

	public HashSet<Integer> seatBlockScope(String seatType) throws InterruptedException {
		try {
			HashSet<Integer> seatBlockSet = new HashSet<>();
			String loadSeatBlockScope_sql = String.format(
				"SELECT block_scope FROM seatType WHERE seatType = '%s'", seatType);
			ResultSet rs = dao.select(loadSeatBlockScope_sql);

			rs.next();

			// 공백 제거.
			String noSpace_scope = rs.getString(1).replace(" ", "");

			// 블록 번호 하나씩 배열에 담기.
			String[] blocks = noSpace_scope.split(",");

			// 블록 번호를 int로 바꿔서 set에 담기.
			for(String b : blocks) {
				seatBlockSet.add(Integer.parseInt(b));
			}

			rs.close();
			return seatBlockSet;
		} catch(NullPointerException NPE) { // premium석 선택한 경우.
			Coloring.greenOut("\n" + seatType + "석은 단일 블록입니다. 바로 좌석도 페이지로 이동합니다.");
			Thread.sleep(1000);
		} catch(SQLException e) {
			System.out.println("ReserveDAO.showSeatBlock method throw SQLE!");
		}
		return null;
	}

	public void addNewReservation(int game_id, String seatType, int seatBlock, int seat_id) {
		String addReservationSQL = String.format(
			"INSERT INTO reservations (gameID, seatType, seatBlock, userID, seat_id) "
				+ "VALUES (%d, '%s', %d, '%s', %d)",
			game_id, seatType, seatBlock, Member.getId(), seat_id);

		String updateSeatStatus_sql = String.format(
			"UPDATE seats SET `status` = 1 WHERE seat_id = %d;",
			seat_id);

		dao.update(addReservationSQL);
		Statement st = dao.getState();
		try {
			st.executeUpdate(updateSeatStatus_sql);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
