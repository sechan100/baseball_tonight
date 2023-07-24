package com.baseballtonight.service.reservation;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

import com.baseballtonight.controller.BlockViewController;
import com.baseballtonight.dao.reservation.ReserveDAO;
import com.baseballtonight.dto.Member;
import com.baseballtonight.util.console.Coloring;
import com.baseballtonight.util.console.UserInput;

public class ReserveService {
	static ReserveDAO dao = new ReserveDAO();
	
	// 예매에 필요한 필드들.
	public static int game_id;
	public static String seatType;
	public static int seatBlock;
	public static int seatColumn;
	public static int seatRow;
	//
	
	public static void serviceRun() throws IOException, InterruptedException {

		// 응원팀 경기만을 조회했다면 true.
		boolean showPrfTeamGameOnly = Games.showGameList(dao);
		
		if(showPrfTeamGameOnly){
			
			// 응원팀 경기만을 조회했을시. -> 달력 날짜를 기반으로 선택.
			game_id = Games.choiceGamebyDay();		
			
		} else {
			
			// 전체 경기를 조회했을 경우. -> game 번호로 선택.
			game_id = Games.choiceGamebyId();		
			
		}
		
		// 좌석 타입 정하기.
		seatType = SeatType.choiceSeatType();
		
		// 좌석 블록 선택하기.
		BlockViewController.showSeatBlocks(seatType);
		seatBlock = SeatType.choiceSeatBlock();
		
		
		// 좌석 선택.
		int seat_id = SeatChoiceService.choiceSeat();

		
		// 선택한 예매 정보를 종합하여 update 쿼리로 전달.
		dao.addNewReservation(game_id, seatType, seatBlock, seat_id);
		Thread.sleep(400);
		Coloring.cyanOut("예매가 완료되었습니다. 감사합니다.");
		Thread.sleep(1000);
	}
}

class Games {
	public static HashSet<Integer> gameIdSet;
	public static HashMap<Integer,Integer> game_id_map;
	public static int gameId;

	public static boolean showGameList(ReserveDAO dao) throws IOException, InterruptedException {
		Coloring.greenOut("응원 팀의 경기 일정만을 보시겠습니까? (Y/N) (N: 전체 경기일정 보기)");
		boolean user_answer = UserInput.receiveYesOrNo();
		if(user_answer) {
			Coloring.greenOut("응원 팀: " + Member.getPrfTeam().name + "의 경기 정보 불러오는 중..");
			Thread.sleep(1000);
			game_id_map = GameCalendarService.showCalendar();
			System.out.println(Coloring.getPurple("보라색: ") + "응원 팀 홈 경기");
		} else {
			Coloring.greenOut("예매 가능한 전체 경기 일정 불러오는 중..");
			Thread.sleep(1000);
			
			String select_all_games_SQL = "SELECT id, name, stadium, dateAndTime, premium, `table`, blue, red, navy, green, DAYOFWEEK(dateAndTime) As part, opponent_club_num, home_club_num FROM games ORDER BY dateAndTime ASC";
			gameIdSet = dao.showGameList(select_all_games_SQL);
		}
		// 선호하는 팀의 경기 일정만을 본 경우, true return.
		return user_answer;
	}

	public static int choiceGamebyId() {
		System.out.print(Coloring.getGreen(
			"관람을 원하시는 경기를 선택하시고, 해당 경기의 \'게임번호\'를 입력하여 주십시오.\n") + "게임번호:");
		gameId = UserInput.receiveContainedNum(gameIdSet);
		return gameId;
	}
	public static int choiceGamebyDay() {
		System.out.print(Coloring.getGreen(
			"관람을 원하시는 경기의 \'날짜(일)\'를 입력하여 주십시오.\n") + "일:");
		int game_day = UserInput.receiveContainedNum(new HashSet<Integer>(game_id_map.keySet()));
		gameId = game_id_map.get(game_day);
		return gameId;
	}
}

class SeatType {
	public static String seatType;
	public static int seatBlock;
	static HashSet<Integer> seatBlock_set;
	static ReserveDAO dao = new ReserveDAO();

	public static String choiceSeatType() {
		System.out.println("\n\n\n");
		
		// 좌석 타입 리스트 출력, 입력 받기.
		dao.showSeatList(Games.gameId);
		System.out.print("예매를 원하시는 좌석의 종류를 영문으로 입력하여 주십시오.\n\n>>> ");
		seatType = UserInput.receiveSeatType();
		return seatType;
	}
	

	public static int choiceSeatBlock() throws InterruptedException {
		
		// 블록 리스트 보이기.
		seatBlock_set = dao.seatBlockScope(seatType);
		
		// premium석 선택한 경우 기본값인 0을 seatBlock번호로 가진다.
		seatBlock = 1;
		
		// premium석이 아닌 경우는 블럭 번호를 받는다.
		if(!seatType.equals("premium")) {
			Coloring.greenOut(seatType + "석 블럭중, 관람을 원하시는 블럭 번호를 입력하여 주십시오.");
			seatBlock = UserInput.receiveContainedNum(seatBlock_set);
		}
		return seatBlock;
	}
	
}
