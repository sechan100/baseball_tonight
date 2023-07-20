package com.baseballtonight.controller;

import java.io.IOException;
import java.util.Scanner;

import com.baseballtonight.data.Team;
import com.baseballtonight.service.BoardService;
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
		this.parkInfoArticleService = new BoardService(parkId,mem_id);
		this.sc = new Scanner(System.in);
		while1: while (true) {
			showParkInfoArticleMenu();
			System.out.println();
			System.out.printf("원하는 메뉴를 입력하세요 >> ");

			int command = UserInput.receiveLimitedRangeNum(0, 9);

			if ((command > 5 && command != 9) || command < 0) {
				System.out.println("없는 메뉴 입니다. 메뉴번호를 다시 입력하세요.\n");
				System.out.println();
				continue;
			} else if (command == 0) {
				MainController.mainMenu();
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
				if (command == 2) {
					System.out.println();
					System.out.println("<게시글 열기>");
					System.out.println();
					System.out.printf("게시글 제목 입력 >> ");
					String articleTitle = sc.nextLine();
					if (parkInfoArticleService.showArticleDetail(articleTitle, sc) == 0) {
						showArticleDetailMenu();
						int command2 = sc.nextInt();
						sc.nextLine();
						if (command2 == 1) {
							parkInfoArticleService.doArticleRecommendIncrease(articleTitle);

						} else if (command2 == 2) {
							parkInfoArticleService.doArticleRecommendDecrease(articleTitle);

						} else if (command2 == 3) {
							parkInfoArticleService.showArticleRecommendList(articleTitle);

						} else if (command2 == 4) {
							System.out.println();
							System.out.println("< 댓글 쓰기 >");
							System.out.println();
							System.out.print("댓글 입력 >> ");
							String body = sc.nextLine();
							parkInfoArticleService.doArticleReplyWrite(articleTitle, body);
						} else
							continue;
					}

				}
				if (command == 3) {
					System.out.println();
					System.out.println("<게시글 작성>");
					System.out.printf("제목입력 >> ");
					String title = sc.nextLine();
					System.out.printf("내용입력 >> ");
					String body = sc.nextLine();
					parkInfoArticleService.doArticleWrite(title, body, parkId); // 게시글 작성 (로그인 옵션 추가 필요)

				}
				if (command == 4) {
					System.out.println();
					System.out.println("<게시글 수정>");
					System.out.println();
					System.out.printf("게시글 제목 입력 >> ");
					String articleTitle = sc.nextLine();
					System.out.println();
					parkInfoArticleService.doArticleModify(articleTitle, sc); // 게시글 수정 ( 로그인 옵션 추가 필요 // memberId 와 대조
																				// 권한 확인)
				}
				if (command == 5) {
					System.out.println();
					System.out.println("<게시글 삭제>");
					System.out.println();
					System.out.printf("게시글 제목 입력 >> ");
					String articleTitle = sc.nextLine();
					System.out.println();
					parkInfoArticleService.doArticleDelete(articleTitle, sc); // 게시글 삭제 ( 로그인 옵션 추가 필요 // memberId 와 대조
																				// 권한 확)
				}

			} // else
		} // while 끝
	} // constructor 끝

	private void showParkInfoArticleMenu() {
		System.out.println("\n");
		System.out.println("< " + parkName + " 자유게시판 >");
		System.out.println();
		System.out.println("--------------------------");
		parkInfoArticleService.showArticleList(); // 게시글 목록
		System.out.println("--------------------------");
		System.out.println();
		System.out.println("1. 게시글 검색");
		System.out.println("2. 게시글 조회");
		System.out.println("3. 게시글 작성");
		System.out.println("4. 게시글 수정");
		System.out.println("5. 게시글 삭제");
		System.out.println("9. 경기장 정보 페이지로 돌아가기");
		System.out.println("0. 메인 메뉴\n");
	}

	private void showArticleDetailMenu() {
		System.out.println("1. 추천하기"); // 추천기능 너무 막 만들었다. 빼버리던가 업그레이드 하는것이 좋겠다.
		System.out.println("2. 추천취소");
		System.out.println("3. 댓글보기");
		System.out.println("4. 댓글작성");
		System.out.println("5. 뒤로가기");
	}

}
