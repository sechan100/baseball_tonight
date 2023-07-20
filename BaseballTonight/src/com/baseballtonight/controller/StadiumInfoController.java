package com.baseballtonight.controller;

import java.io.IOException;
import java.util.HashSet;

import com.baseballtonight.data.Team;
import com.baseballtonight.data.dto.Member;
import com.baseballtonight.service.StadiumInfoService;
import com.baseballtonight.statics.console.Coloring;
import com.baseballtonight.statics.console.Message;
import com.baseballtonight.statics.console.UserInput;

public class StadiumInfoController {
	// 해당 컨트롤러에서 입력 가능한 명령어 리스트.
	static HashSet<String> stadium_info_cmd_set = new HashSet<>();
	static {
		stadium_info_cmd_set.add("eat");
		stadium_info_cmd_set.add("bus");
		stadium_info_cmd_set.add("subway");
		stadium_info_cmd_set.add("parking");
		stadium_info_cmd_set.add("board");
		stadium_info_cmd_set.add("other");
		stadium_info_cmd_set.add("main");
	}

	public static void cmdRun(Team team) throws IOException, InterruptedException {
		// StadiumInfoDAO 객체에 팀 id정보 전
		StadiumInfoService.setShowTargetTeam(team);
		
		// 정보 페이지 명령어 리스트 출력과 명령어 입력 받기.
		System.out.println(Message.stadium_info_cmd_ls);
		String user_cmd = UserInput.receiveContainedString(stadium_info_cmd_set);
		
		
		switch(user_cmd) {
		case "eat":
			StadiumInfoService.showParkFood();
			StadiumInfoController.cmdRun(team);			
			break;
			
		case "bus":
			StadiumInfoService.showParkBus();
			StadiumInfoController.cmdRun(team);
			break;

		case "subway":
			StadiumInfoService.showParkSub();
			StadiumInfoController.cmdRun(team);
			break;

		case "parking":
			StadiumInfoService.showParkParking();
			StadiumInfoController.cmdRun(team);
			break;

		case "board":
			new BoardController(team.num, team.name, Member.getMem_id());
			break;

		case "other":
			System.out.println(Team.team_ls);
			System.out.println("조회를 원하는 구단을 입력하여 주십시오.");
			int prf_team_num = UserInput.receiveLimitedRangeNum(1, 10); // 1에서 10중에만 입력을 받음..
			Team prf_team = Team.getTeamByTeamNum(prf_team_num); //선호팀 번호 -> 선호팀 enum.
			StadiumInfoController.showOtherStadiumInfo(prf_team);
			break;

		case "main":
			MainController.mainMenu();
			break;
		}
	}
	
	// (기본값) 선호하는 팀의 경기장 정보 보기.
	public static void showPrfStadiumInfo() throws IOException, InterruptedException{
		// ex) "회원님의 응원 구단인 한화이글스의 홈구장, 대전 한화생명 이글스파크의 정보 페이지입니다."처럼 출력.
		System.out.println("회원님의 응원 구단인 " + Coloring.getPurple(Member.getPrf_team().name) + "의 홈구장, '"
			+ Coloring.getYellow(Member.getPrf_team().stadium) + "'의 정보 페이지 입니다.\n\n");
		StadiumInfoController.cmdRun(Member.getPrf_team());
	}
	
	// 선호하는 팀이 아닌 다른 구단의 경기장 정보 보기. (other 명령어의 응답 함수)
	public static void showOtherStadiumInfo(Team other_team) throws IOException, InterruptedException{
		Coloring.greenOut(Coloring.getCyan(other_team.name) + "의 홈구장, '"
			+ Coloring.getYellow(other_team.stadium) + "'의 정보 페이지 입니다.");
		StadiumInfoController.cmdRun(other_team);
	}
}
