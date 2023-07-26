package com.baseballtonight.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

import com.baseballtonight.dto.Team;
import com.baseballtonight.service.MainService;
import com.baseballtonight.service.board.BoardService;
import com.baseballtonight.util.Coloring;
import com.baseballtonight.util.UserInput;

public class BoardController { // 새로 추가된 Controller class
	private Scanner sc;
	@SuppressWarnings("unused")
	private int parkId;
	@SuppressWarnings("unused")
	private String mem_id;
	private String parkName;
	private BoardService parkInfoArticleService; // service 패키지 ParkInfoArticleSerive 추가.
	
	

	@SuppressWarnings("unused")
	public BoardController(int parkId, String parkName, String mem_id) throws IOException, InterruptedException {
		HashSet<String> boardCmdSet = new HashSet<>();
		boardCmdSet.add("back");
		boardCmdSet.add("main");
		boardCmdSet.add("write");
		boardCmdSet.add("search");
		boardCmdSet.add("open");
		
		HashSet<String> boardCmd2Set = new HashSet<>();
		boardCmd2Set.add("rcmd");
		boardCmd2Set.add("cancel");
		boardCmd2Set.add("modify");
		boardCmd2Set.add("delete");
		boardCmd2Set.add("back");
		boardCmd2Set.add("reply");
		
		this.parkName = parkName;
		this.parkId = parkId;
		this.mem_id = mem_id;
		this.parkInfoArticleService = new BoardService(parkId, mem_id);
		this.sc = new Scanner(System.in);
		showParkInfoArticleMenu(); // 수정됨 07/20 while밖으로 뺀거.!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		while1: while (true) {

			System.out.println();
			// 원하는 메뉴를 입력하세요 없어짐 07/20!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

			String command = UserInput.receiveContainedString(boardCmdSet);

			if (command.equals("main")) {
				MainService.mainMenu();
				break;
			} else if (command.equals("back")) {
				StadiumInfoController.cmdRun(Team.getTeamByTeamNum(parkId));
				break;
			} else {
				if (command.equals("search")) {
					System.out.println();
					System.out.println("<게시글 검색>");
					System.out.println();
					System.out.printf("검색 내용 입력 >> ");
					String searchKey = sc.nextLine();
					parkInfoArticleService.showSearchedArticle(searchKey);// 게시글 검색
				}
				if (command.equals("open")) { //// 수정됨 07/20!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
					System.out.println();
					System.out.println("<게시글 열기>");
					System.out.println();
					System.out.printf("게시글 제목 입력 >> ");
					String articleTitle = sc.nextLine();
					if (parkInfoArticleService.showArticleDetail(articleTitle, sc) == 0) {
						parkInfoArticleService.showArticleRecommendList(articleTitle); // recommend 여기로 나옴
						// detailmenu 였던것. 07/20
						while (true) { // while문 추가 07/20!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
							String command2 = UserInput.receiveContainedString(boardCmd2Set);
							
							if (command2.equals("rcmd")) {
								parkInfoArticleService.doArticleRecommendIncrease(articleTitle);
								continue;
							} else if (command2.equals("cancel")) {
								parkInfoArticleService.doArticleRecommendDecrease(articleTitle);
								continue;
							} else if (command2.equals("modify")) { // 함수 내용 바뀜. 07/20
								parkInfoArticleService.doArticleModify(articleTitle, sc);
								showParkInfoArticleMenu(); // 요거 추가됨 07/20!!!!!!!!!!!!!!!!!!!!!!!
								break;
							} else if (command2.equals("delete")) { // command2 == 바뀜. 함수내용 바뀜 07/20
								parkInfoArticleService.doArticleDelete(articleTitle, sc);
								showParkInfoArticleMenu(); // 요거 추가됨 07/20!!!!!!!!!!!!!!!!!!!!!!!
								break;
							} else if (command2.equals("back")) { // command2 5번 추가됨. 07/20
								showParkInfoArticleMenu(); // 요거 추가됨 07/20!!!!!!!!!!!!!!!!!!!!!!!
								break;
							} else if (command2.equals("reply")) { // 6으로 바뀜 07/20!!!!!!!!
								System.out.println();
								System.out.println("< 댓글 쓰기 >");
								System.out.println();
								System.out.print("댓글 입력 >> ");
								String body = sc.nextLine();
								parkInfoArticleService.doArticleReplyWrite(articleTitle, body);
								parkInfoArticleService.showArticleDetail(articleTitle, sc);
								parkInfoArticleService.showArticleRecommendList(articleTitle);
								continue;
							} else
								showParkInfoArticleMenu(); // 요기 바뀜 07/20!!!!!!!!!!!
								break;
						}
					} // 여기까지 while문

				}
				if (command.equals("write")) {
					System.out.println();
					System.out.println("<게시글 작성>");
					System.out.printf("제목입력 >> ");
					String title = sc.nextLine();
					System.out.printf("내용입력 >> ");
					String body = sc.nextLine();
					parkInfoArticleService.doArticleWrite(title, body, parkId); // 게시글 작성 (로그인 옵션 추가 필요)
					showParkInfoArticleMenu(); // 요거 추가됨 07/20!!!!!!!!!!!!!!!!!!!!!!!
				}
//				if (command == 4) {    // 이제 안씀 필요없음 07/20!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//					System.out.println();
//					System.out.println("<게시글 수정>");
//					System.out.println();
//					System.out.printf("게시글 제목 입력 >> ");
//					String articleTitle = sc.nextLine();
//					System.out.println();
//					parkInfoArticleService.doArticleModify(articleTitle, sc); // 게시글 수정 ( 로그인 옵션 추가 필요 // memberId 와 대조
//																				// 권한 확인)
//				}
//				if (command == 5) {
//					System.out.println();
//					System.out.println("<게시글 삭제>");
//					System.out.println();
//					System.out.printf("게시글 제목 입력 >> ");
//					String articleTitle = sc.nextLine();
//					System.out.println();
//					parkInfoArticleService.doArticleDelete(articleTitle, sc); // 게시글 삭제 ( 로그인 옵션 추가 필요 // memberId 와 대조
//																				// 권한 확)
//				}

			} // else
		} // while 끝
	} // constructor 끝

	private void showParkInfoArticleMenu() { // 수정됨 07/20!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! (조회,수정,삭제)
		System.out.println("\n");
		System.out.printf(
				"-------------------------------------------------------------------------------------------\n");
		System.out.
		printf("|  %s  |                        < %s 자유게시판 >                        |   %s  |  \n", Coloring.getCyan("back"), parkName, Coloring.getCyan("main"));
		System.out.printf(
				"-------------------------------------------------------------------------------------------\n");
		System.out.printf("| 번호 |	작성자	|	등록일   | 조회 | 추천 | 제목	\n");
		System.out.printf(
				"-------------------------------------------------------------------------------------------\n");
		parkInfoArticleService.showArticleList(); // 게시글 목록
		System.out.printf(
				"-------------------------------------------------------------------------------------------\n");
		System.out.printf("| %s |                                                   	 	|  %s  |  	 |  %s  |  \n", Coloring.getCyan("write"), Coloring.getCyan("search"), Coloring.getCyan("open"));
	}

//	private void showArticleDetailMenu() { // 이제 안씀 필요없음 07/20!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//		System.out.println("1. 추천하기"); // 추천기능 너무 막 만들었다. 빼버리던가 업그레이드 하는것이 좋겠다.
//		System.out.println("2. 추천취소");
//		System.out.println("3. 댓글보기");
//		System.out.println("4. 댓글작성");
//		System.out.println("5. 뒤로가기");
//	}

}
