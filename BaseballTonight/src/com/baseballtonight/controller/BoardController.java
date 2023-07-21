package com.baseballtonight.controller;

import java.io.IOException;
import java.util.Scanner;

import com.baseballtonight.dto.Team;
import com.baseballtonight.service.MainService;
import com.baseballtonight.service.board.BoardService;
import com.baseballtonight.util.console.UserInput;

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
		this.parkName = parkName;
		this.parkId = parkId;
		this.mem_id = mem_id;
		this.parkInfoArticleService = new BoardService(parkId, mem_id);
		this.sc = new Scanner(System.in);
		showParkInfoArticleMenu(); // 수정됨 07/20 while밖으로 뺀거.!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		while1: while (true) {

			System.out.println();
			// 원하는 메뉴를 입력하세요 없어짐 07/20!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

			int command = UserInput.receiveLimitedRangeNum(0, 9);

			if ((command > 3 && command != 9) || command < 0) { // 수정됨 07/20!!!!!!!!!!!!!!!!!!!!!! 5였던거 3으로 바뀜
				System.out.println("없는 메뉴 입니다. 메뉴번호를 다시 입력하세요.\n");
				System.out.println();
				continue;
			} else if (command == 0) {
				MainService.mainMenu();
				break;
			} else if (command == 9) {
				StadiumInfoController.cmdRun(Team.getTeamByTeamNum(parkId));
				break;
			} else {
				if (command == 1) {
					System.out.println();
					System.out.println("<게시글 검색>");
					System.out.println();
					System.out.printf("검색 내용 입력 >> ");
					String searchKey = sc.nextLine();
					parkInfoArticleService.showSearchedArticle(searchKey);// 게시글 검색
				}
				if (command == 2) { //// 수정됨 07/20!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
					System.out.println();
					System.out.println("<게시글 열기>");
					System.out.println();
					System.out.printf("게시글 제목 입력 >> ");
					String articleTitle = sc.nextLine();
					if (parkInfoArticleService.showArticleDetail(articleTitle, sc) == 0) {
						parkInfoArticleService.showArticleRecommendList(articleTitle); // recommend 여기로 나옴
						// detailmenu 였던것. 07/20
						while (true) { // while문 추가 07/20!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
							int command2 = sc.nextInt();
							sc.nextLine();
							if (command2 == 1) {
								parkInfoArticleService.doArticleRecommendIncrease(articleTitle);
								continue;
							} else if (command2 == 2) {
								parkInfoArticleService.doArticleRecommendDecrease(articleTitle);
								continue;
							} else if (command2 == 3) { // 함수 내용 바뀜. 07/20
								parkInfoArticleService.doArticleModify(articleTitle, sc);
								showParkInfoArticleMenu(); // 요거 추가됨 07/20!!!!!!!!!!!!!!!!!!!!!!!
								break;
							} else if (command2 == 4) { // command2 == 바뀜. 함수내용 바뀜 07/20
								parkInfoArticleService.doArticleDelete(articleTitle, sc);
								showParkInfoArticleMenu(); // 요거 추가됨 07/20!!!!!!!!!!!!!!!!!!!!!!!
								break;
							} else if (command2 == 5) { // command2 5번 추가됨. 07/20
								showParkInfoArticleMenu(); // 요거 추가됨 07/20!!!!!!!!!!!!!!!!!!!!!!!
								break;
							} else if (command2 == 6) { // 6으로 바뀜 07/20!!!!!!!!
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
				if (command == 3) {
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
		System.out
				.printf(" 9. 뒤로가기                        <" + parkName + " 자유게시판 >                        0. 메인메뉴  \n");
		System.out.printf(
				"-------------------------------------------------------------------------------------------\n");
		System.out.printf(" 번호   작성자         등록일     조회   추천    제목      \n");
		System.out.printf(
				"-------------------------------------------------------------------------------------------\n");
		parkInfoArticleService.showArticleList(); // 게시글 목록
		System.out.printf(
				"-------------------------------------------------------------------------------------------\n");
		System.out.printf(" 3. 글쓰기                                                         1. 검색   2. 게시글 열기     \n");
	}

//	private void showArticleDetailMenu() { // 이제 안씀 필요없음 07/20!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//		System.out.println("1. 추천하기"); // 추천기능 너무 막 만들었다. 빼버리던가 업그레이드 하는것이 좋겠다.
//		System.out.println("2. 추천취소");
//		System.out.println("3. 댓글보기");
//		System.out.println("4. 댓글작성");
//		System.out.println("5. 뒤로가기");
//	}

}
