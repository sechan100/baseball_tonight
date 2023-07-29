package com.baseballtonight.controller;

import java.util.HashSet;

import com.baseballtonight.dto.Team;
import com.baseballtonight.service.MainService;
import com.baseballtonight.service.BoardService;
import com.baseballtonight.util.Coloring;
import com.baseballtonight.util.UserInput;

public class BoardController { // 새로 추가된 Controller class
	@SuppressWarnings("unused")
	private int parkId;
	@SuppressWarnings("unused")
	private String mem_id;
	private String parkName;
	private BoardService parkInfoArticleService; // service 패키지 ParkInfoArticleSerive 추가.
	
	
	

	@SuppressWarnings("unused")
	public BoardController(int parkId, String parkName, String mem_id) throws InterruptedException {
		HashSet<String> boardCmdSet = new HashSet<>();
		boardCmdSet.add("back");
		boardCmdSet.add("main");
		boardCmdSet.add("write");
		boardCmdSet.add("search");
		boardCmdSet.add("read");
		boardCmdSet.add("filter"); // 07/26 추가됨.
		
		HashSet<String> boardCmd2Set = new HashSet<>();
		boardCmd2Set.add("rcmd");
		boardCmd2Set.add("cancel");
		boardCmd2Set.add("modify");
		boardCmd2Set.add("delete");
		boardCmd2Set.add("back");
		boardCmd2Set.add("reply");
		
		HashSet<String> boardCmd3Set = new HashSet<>(); // 07/26 시작.
		boardCmd3Set.add("추천");
		boardCmd3Set.add("조회");
		boardCmd3Set.add("기본"); // 07/26 끝.
		
		this.parkName = parkName;
		this.parkId = parkId;
		this.mem_id = mem_id;
		this.parkInfoArticleService = new BoardService(parkId, mem_id);
		
		showParkInfoArticleMenu(); 
		
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
					System.out.printf("검색 내용 입력");
					String searchKey = UserInput.receiveString();
					parkInfoArticleService.showSearchedArticle(searchKey);// 게시글 검색
				}
				if (command.equals("read")) { //// 수정됨 07/20!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
					System.out.println();
					System.out.println("<게시글 열기>");
					System.out.println();
					System.out.printf("게시글 번호 입력"); // 07/26 시작
					int articleId = UserInput.receiveNaturalNumber();
					
					String articleTitle = parkInfoArticleService.getArticleTitle(articleId);
					/// 07/26 끝
					
					if (parkInfoArticleService.showArticleDetail(articleTitle) == 0) {
						parkInfoArticleService.showArticleRecommendList(articleTitle); // recommend 여기로 나옴
						// detailmenu 였던것. 07/20
						while (true) { // while문 추가 07/20!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
							
							String command2 = UserInput.receiveContainedString(boardCmd2Set);
							
							if (command2.equals("rcmd")) {
								parkInfoArticleService.doArticleRecommendIncrease(articleTitle,mem_id); // 07/26 인자에 mem_id 추가
								continue;
								// 07/26 끝.
								
							} else if (command2.equals("cancel")) {
								parkInfoArticleService.doArticleRecommendDecrease(articleTitle,mem_id); // 07/26 인자에 mem_id 추가
								continue;
								// 07/26 끝.
								
							} else if (command2.equals("modify")) { // 함수 내용 바뀜. 07/20
								parkInfoArticleService.doArticleModify(articleTitle);
								showParkInfoArticleMenu(); // 요거 추가됨 07/20!!!!!!!!!!!!!!!!!!!!!!!
								break;
							} else if (command2.equals("delete")) { // command2 == 바뀜. 함수내용 바뀜 07/20
								parkInfoArticleService.doArticleDelete(articleTitle);
								showParkInfoArticleMenu(); // 요거 추가됨 07/20!!!!!!!!!!!!!!!!!!!!!!!
								break;
							} else if (command2.equals("back")) { // command2 5번 추가됨. 07/20
								showParkInfoArticleMenu(); 
								break;
							} else if (command2.equals("reply")) { // 6으로 바뀜 07/20!!!!!!!!
								System.out.println();
								System.out.println("< 댓글 쓰기 >");
								System.out.println();
								System.out.print("댓글 입력");
								String body = UserInput.receiveString();
								parkInfoArticleService.doArticleReplyWrite(articleTitle, body);
								parkInfoArticleService.showArticleDetail(articleTitle);
								parkInfoArticleService.showArticleRecommendList(articleTitle);
								continue;
							} else
								showParkInfoArticleMenu(); // 요기 바뀜 07/20!!!!!!!!!!!
								break;
						}
					} // 여기까지 while문

				}
				
				if(command.equals("filter")) { // 07/26 시작
					System.out.println();
					System.out.println("<게시글 정렬>");
					System.out.println();
					System.out.println("정렬을 원하는 기준을 입력해주세요. (추천/조회/기본)");
					
					String command3 = UserInput.receiveContainedString(boardCmd3Set);
					
					switch (command3) { 
					case "추천" : parkInfoArticleService.setArticleOrderByRecommend();
					break;
					case "조회" : parkInfoArticleService.setArticleOrderByHit();
					break;
					case "기본" : parkInfoArticleService.setArticleOrderById();
					break;
					}
					
					showParkInfoArticleMenu();
				} // 07/26 끝
				
				if (command.equals("write")) {
					System.out.println();
					System.out.println("<게시글 작성>");
					System.out.printf("제목입력");
					String title = UserInput.receiveString();
					System.out.printf("내용입력");
					String body = UserInput.receiveString();
					parkInfoArticleService.doArticleWrite(title, body, parkId); // 게시글 작성 (로그인 옵션 추가 필요)
					showParkInfoArticleMenu(); // 요거 추가됨 07/20!!!!!!!!!!!!!!!!!!!!!!!
				}

			}
		} 
	} 

	private int showParkInfoArticleMenu() { // 07/26 void -> int 맨밑에 return 0;
		System.out.println("\n");
		System.out.printf(
				"-------------------------------------------------------------------------------------------\n");
		System.out.
		printf("|  %s  |                        < %s 자유게시판 >                        |   %s  |  \n", Coloring.getCyan("back"), parkName, Coloring.getCyan("main"));
		System.out.printf(
				"-------------------------------------------------------------------------------------------\n");
		System.out.printf("| 번호 |	작성자	|	등록일   | 조회 | 추천 | 제목	                              |  %s  |  \n", Coloring.getCyan("filter")); // 07/26 filter 추가
		System.out.printf(
				"-------------------------------------------------------------------------------------------\n");
		parkInfoArticleService.showArticleList(); // 게시글 목록
		System.out.printf(
				"-------------------------------------------------------------------------------------------\n");
		System.out.printf("| %s |                                                   	 	|  %s  |  	 |  %s  |  \n", Coloring.getCyan("write"), Coloring.getCyan("search"), Coloring.getCyan("read"));
		
		return 0;
	}


}