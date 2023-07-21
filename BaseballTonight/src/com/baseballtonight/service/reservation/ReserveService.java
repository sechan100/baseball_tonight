package com.baseballtonight.service.reservation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

import com.baseballtonight.dao.reservation.ReserveDAO;
import com.baseballtonight.dto.Member;
import com.baseballtonight.service.MainService;
import com.baseballtonight.util.console.Coloring;
import com.baseballtonight.util.console.UserInput;

public class ReserveService {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static ReserveDAO dao = new ReserveDAO();

	public static void serviceRun() throws IOException, InterruptedException {

		boolean show_preferred_game_schedule = Games.showGameList(dao);
		if(show_preferred_game_schedule){
			Games.choiceGamebyDay();						
		} else {
			Games.choiceGamebyId();			
		}
		
		Seats.choiceSeatType();
		Seats.choiceSeatBlock();

		// 선택한 예매 정보를 종합하여 update 쿼리로 전달.
		dao.addNewReservation(Games.gameId, Seats.seatType, Seats.seatBlock);
		Thread.sleep(300);
		Coloring.cyanOut("예매가 완료되었습니다. 감사합니다.");
		Thread.sleep(1000);

		// 초기화면으로 돌아가기
		MainService.mainMenu();
	}
}

class Games {
	public static HashSet<Integer> gameIdSet;
	public static HashMap<Integer,Integer> game_id_map;
	public static int gameId;

	public static boolean showGameList(ReserveDAO dao) throws IOException, InterruptedException {
		Coloring.greenOut("선호하는 팀의 경기 일정만을 보시겠습니까? (Y/N) (N: 전체 경기일정 보기)");
		boolean user_answer = UserInput.receiveYesOrNo();
		if(user_answer) {
			Coloring.greenOut("선호 팀: " + Member.getPrfTeam().name + "의 경기 정보 불러오는 중..");
			Thread.sleep(1000);
			game_id_map = GameCalendarService.showCalendar();
		} else {
			Coloring.greenOut("예매 가능한 전체 경기 일정 불러오는 중..");
			Thread.sleep(1000);
			
			String select_all_games_SQL = "SELECT id, name, stadium, dateAndTime, premium, `table`, blue, red, navy, green, DAYOFWEEK(dateAndTime) As part, opponent_club_num, home_club_num FROM games ORDER BY dateAndTime ASC";
			gameIdSet = dao.showGameList(select_all_games_SQL);
		}
		// 선호하는 팀의 경기 일정만을 본 경우, true return.
		return user_answer;
	}

	public static void choiceGamebyId() {
		System.out.print(Coloring.getGreen(
			"관람을 원하시는 경기를 선택하시고, 해당 경기의 \'게임번호\'를 입력하여 주십시오.\n") + "게임번호:");
		gameId = UserInput.receiveContainedNum(gameIdSet);

	}
	public static void choiceGamebyDay() {
		System.out.print(Coloring.getGreen(
			"관람을 원하시는 경기의 \'날짜(일)\'를 입력하여 주십시오.\n") + "일:");
		int game_day = UserInput.receiveContainedNum(new HashSet<Integer>(game_id_map.keySet()));
		gameId = game_id_map.get(game_day);
		
	}
}

class Seats {
	public static String seatType;
	public static int seatBlock;
	static HashSet<Integer> seatBlockSeat;
	static ReserveDAO dao = new ReserveDAO();

	public static void choiceSeatType() {
		System.out.println("\n\n\n");
		dao.showSeatList(Games.gameId);
		System.out.print("예매를 원하시는 좌석의 종류를 영문으로 입력하여 주십시오.\n\n>>> ");
		seatType = UserInput.receiveSeatType();
	}

	public static void choiceSeatBlock() {
		seatBlockSeat = dao.showSeatBlock(seatType);
		seatBlock = 0; // premium석 선택한 경우 기본값인 0을 seatBlock번호로 가지고 진입.
		if(!seatType.equals("premium")) {
			Coloring.greenOut(seatType + "석 블럭중, 관람을 원하시는 블럭 번호를 입력하여 주십시오.");
			seatBlock = UserInput.receiveContainedNum(seatBlockSeat);
		}
	}
}
