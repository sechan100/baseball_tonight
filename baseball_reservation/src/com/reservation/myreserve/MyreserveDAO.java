package com.reservation.myreserve;

import java.io.*;
import java.sql.*;

import com.reservation.console.Coloring;

public class MyreserveDAO {
	// field
	Connection con;
	Statement state;
	ResultSet rs;
	BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

	public MyreserveDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/?user=root";
			con = DriverManager.getConnection(url, "root", "dlqhfka");
			state = con.createStatement();
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	public static String getDayOfWeek(int dowNum) {
		switch(dowNum) {
		case 1:
			return "일요일";
		case 2:
			return "월요일";
		case 3:
			return "화요일";
		case 4:
			return "수요일";
		case 5:
			return "목요일";
		case 6:
			return "금요일";
		case 7:
			return "토요일";
		default:
			return "null요일";
		}
	}

	public static StringBuilder trimDateAndTime(String dat, String dow) {
		StringBuilder DAT = new StringBuilder();
		DAT.append(dat.substring(0, 4) + "년 ");
		DAT.append((dat.substring(5, 6).equals("0") ? dat.substring(6, 7) : dat.substring(5, 7)) + "월 ");
		DAT.append((dat.substring(8, 9).equals("0") ? dat.substring(9, 10) : dat.substring(8, 10)) + "일 ");
		DAT.append(dow + " ");
		DAT.append(dat.substring(11, 16).replace(":", "시 ") + "분 ");
		return DAT;
	}

	public boolean showReservationList(int userID) throws IOException, InterruptedException {
		try {
			String sql = "SELECT reservationID,\n"
				+ " seatType,\n"
				+ " seatBlock,\n"
				+ " userID,\n"
				+ " name,\n"
				+ " stadium,\n"
				+ " dateAndTime,\n"
				+ " DAYOFWEEK(dateAndTime) As part \n"
				+ " FROM reservation.reservations\n"
				+ "JOIN reservation.games\n"
				+ "on gameID = id\n"
				+ "WHERE userID =" + userID;
			rs = state.executeQuery(sql);
			System.out.println();
			Coloring.greenOut(userID + "번 회원님의 예매 정보입니다.");
			System.out.println("---------------------------------------------------------------------------------------");
			boolean emptyReservation = true;
			while(rs.next()) {
				int reservationID = rs.getInt(1);
				String gameName = rs.getString(5);
				String stadium = rs.getString(6);
				String DayOfWeek = MyreserveDAO.getDayOfWeek(rs.getInt(8));
				StringBuilder startWhen = MyreserveDAO.trimDateAndTime(rs.getString(7), DayOfWeek);
				String seatType = rs.getString(2);
				int seatBlock = rs.getInt(3);
				System.out.print("예매번호: " + reservationID + " | ");
				System.out.print(Coloring.cyan + gameName + Coloring.exit);
				System.out.print(" | ");
				System.out.print(Coloring.yellow + stadium + Coloring.exit);
				System.out.print(" | ");
				System.out.print(seatType+"석 " + seatBlock + "블록 ");
				System.out.print(" | ");
				System.out.print(startWhen);
				System.out.print("---------------------------------------------------------------------------------------\n");
				emptyReservation = false;
			}
			return emptyReservation;
		} catch(SQLException e) {
			System.out.println("showReservationList SQLE!");
			return false;
		}
	}
}