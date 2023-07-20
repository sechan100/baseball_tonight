package com.baseballtonight.statics.console;

public class Message {
	public static String app_starting_msg = Coloring.getCyan(""
		+ " ___   _   __  ___  ___   _   _    _     ___   _   _  _  _   __  _ _  ___ \n"
		+ "| o ) / \\ / _|| __|| o ) / \\ | |  | |   |_ _| / \\ | \\| || | / _|| U ||_ _|\n"
		+ "| o \\| o |\\_ \\| _| | o \\| o || |_ | |_   | | ( o )| \\\\ || |( |_n|   | | | \n"
		+ "|___/|_n_||__/|___||___/|_n_||___||___|  |_|  \\_/ |_|\\_||_| \\__/|_n_| |_| \n"
		+ "                                                                          ");
	
	public static String main_cmd_ls = ""
		+"-------------------------------\n"
		+ Coloring.getCyan("경기 예매하기:	reserve \n")
		+"-------------------------------\n"
		+ Coloring.getCyan("예매내역 조회:	myreserve \n")
		+"-------------------------------\n"
		+ Coloring.getCyan("경기장 정보:	stadium \n")
		+"-------------------------------\n"
		+ Coloring.getCyan("좌석 정보:		seats \n")
		+"-------------------------------\n"
		+ Coloring.getCyan("회원정보:		self \n")
		+"-------------------------------\n"
		+ Coloring.getCyan("애플리케이션 종료:	exit \n")
		+"-------------------------------";
	
//	public static String reservation_cmd_ls = ""
//		+ Coloring.getCyan("회원가입:		join\n")
//		+"-------------------------------\n"
//		+ Coloring.getCyan("로그인:		login\n")
//		+"-------------------------------\n"
//		+ Coloring.getCyan("로그아웃:		logout\n")
//		+"-------------------------------\n"
//		+ Coloring.getCyan("회원정보 수정:	modify\n")
//		+"-------------------------------\n"
//		+ Coloring.getCyan("회원 탈퇴:		delete\n")
//		+"-------------------------------\n"
//		+ Coloring.getCyan("회원정보 조회:	detail\n")
//		+"-------------------------------\n"
//		+ Coloring.getCyan("애플리케이션 종료:	exit\n")
//		+"-------------------------------\n";

	public static String reservation_commands = Coloring.cyan
	+ "좌석 예매:		reserve\n"
	+ Coloring.exit
	+ "-----------------------------------------\n"
	+ Coloring.cyan
	+ "내 예매정보 확인:	myreserve\n"
	+ Coloring.exit
	+ "-----------------------------------------\n"
	+ Coloring.cyan
	+ "좌석 예매 취소:	myreserve -> 취소 페이지로 이동\n"
	+ Coloring.exit
	+ "-----------------------------------------\n"
	+ Coloring.cyan
	+ "선호구단 정보 변경:	myclub\n"
	+ Coloring.exit
	+ "-----------------------------------------\n"
	+ Coloring.cyan
	+ "좌석 정보:		info\n"
	+ Coloring.exit
	+ "-----------------------------------------\n"
	+ Coloring.cyan
	+ "명령어 리스트: 	command.ls\n"
	+ Coloring.exit
	+ "-----------------------------------------\n"
	+ Coloring.red
	+ "프로그램 종료:	exit"
	+ Coloring.exit;

	
	
	
	
	
	
	public static void showReservationCommands() {
		System.out.println("\n\n" + reservation_commands);
		System.out.print("\n>>> ");
	}

	public static void showMemberCommands() {
		System.out.println("\n\n" + main_cmd_ls);
		System.out.print("\n>>> ");
	}
}