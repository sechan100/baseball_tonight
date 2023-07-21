package com.baseballtonight.service.board;

import java.util.ArrayList;
import java.util.Scanner;

import com.baseballtonight.dao.board.ArticleDAO;
import com.baseballtonight.dto.Article;
import com.baseballtonight.dto.ArticleReply;



public class BoardService {
	
	private ArticleDAO parkInfoArticleDao;
	private ArrayList<Article> articles;
	private ArrayList<ArticleReply> replys;
	private String mem_id;
	
	public BoardService(int parkId, String mem_id) {
		this.mem_id = mem_id;
		this.parkInfoArticleDao = new ArticleDAO(parkId);
	}
	
	public void showArticleList() { // 수정됨 07/20!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		articles = parkInfoArticleDao.getArticleList();
				
		for (Article a : articles) {
			System.out.printf(" %-5d%-10s%-13s%-6d%-6d%s\n",a.id,a.memberId,a.regDate,a.hit,a.recommend,a.title);
		}
	}
	
	public void showSearchedArticle(String searchKey) {         // 수정함 07/20!!!!!!!!!!!!!!!!!!!!!!!!!
		articles = parkInfoArticleDao.getSearchedArticle(searchKey);
		System.out.println();
		System.out.println("< 검색 결과 >\n");
		
		System.out.println("\n");
		System.out.printf("-------------------------------------------------------------------------------------------\n");
        System.out.printf(" 9. 뒤로가기                        <"+searchKey+" 검색결과 >                           0. 메인메뉴  \n");
        System.out.printf("-------------------------------------------------------------------------------------------\n");
        System.out.printf(" 번호   작성자         등록일     조회   추천    제목      \n");
        System.out.printf("-------------------------------------------------------------------------------------------\n");
        for (Article a : articles) {
			System.out.printf(" %-5d%-10s%-13s%-6d%-6d%s\n",a.id,a.memberId,a.regDate,a.hit,a.recommend,a.title);
		}
		System.out.printf("-------------------------------------------------------------------------------------------\n");
		System.out.printf(" 3. 글쓰기                                                         1. 검색   2. 게시글 열기     \n");
		
		
		
	}
	
	public int showArticleDetail(String articleTitle,Scanner sc)	{ // 수정됨 07/20 !!!!!!!!!!!!!!!!!!!!!!!!!!!
		Article article = parkInfoArticleDao.getArticle(articleTitle);
		
		if(article == null) {
			System.out.println();
			System.out.println("제목 입력이 잘못되었습니다.");
			System.out.println("정확한 제목을 입력해주세요.");
			System.out.println();
			return -1;
		}
		
		System.out.printf("-------------------------------------------------------------------------------------------\n");
        System.out.printf(" 5. 뒤로가기                                                        3. 수정     4.삭제        \n");
        System.out.printf("-------------------------------------------------------------------------------------------\n");
        System.out.printf(" %-30s        %-24s  조회 : %-6d   추천 : %-6d\n",article.memberId,article.regDate,article.hit,article.recommend);
        System.out.printf("-------------------------------------------------------------------------------------------\n");
        System.out.printf(" %s \n", article.title);
        System.out.println();
        System.out.printf(" %s \n", article.body);
        System.out.printf("-------------------------------------------------------------------------------------------\n");
        System.out.printf(" 1. 추천  2. 추천취소                                                                        \n");
		return 0;
	}
	
	public void doArticleWrite(String title, String body, int parkId) { // 로그인 옵션 필요
		parkInfoArticleDao.doArticleWrite(title,body,parkId,mem_id);

		System.out.println("게시글이 작성되었습니다.");
		System.out.println();
		
	}
	
	public void doArticleModify(String articleTitle, Scanner sc) { // 로그인 옵션, id 대조 필요
		Article article = parkInfoArticleDao.getArticle(articleTitle);
		if(article == null) {
			System.out.println("게시글 제목이 없습니다.");
			System.out.println("수정하실 게시글의 제목을 정확히 입력해주세요.");
			System.out.println();
			return;
		}
		
		if(!(article.memberId.equals(mem_id))) {
			System.out.println("게시글 수정 권한이 없습니다.");
			System.out.println();
			return;
		}
		System.out.printf("새로운 제목입력 >> ");
		String title = sc.nextLine();
		System.out.printf("새로운 내용입력 >> ");
		String body = sc.nextLine();
		parkInfoArticleDao.doArticleModify(title, body, article.id);
		System.out.println("게시글 수정이 완료되었습니다.");
		System.out.println();
	}
	
	public void doArticleDelete(String articleTitle, Scanner sc) { // 로그인 옵션,  id 대조 필요
		Article article = parkInfoArticleDao.getArticle(articleTitle);
		if(article == null) {
			System.out.println("게시글 제목이 없습니다.");
			System.out.println("삭제하실 게시글의 제목을 정확히 입력해주세요.");
			System.out.println();
			return;
		}
		
		if(!(article.memberId.equals(mem_id))) {
			System.out.println("게시글 삭제 권한이 없습니다.");
			System.out.println();
			return;
		}

		while(true) {
			System.out.print("정말 게시글을 삭제하시겠습니까? (y/n) >> ");
			String yesOrNo = sc.nextLine();
			yesOrNo.toLowerCase();
			if (yesOrNo.length() != 1) {
				System.out.println("y 또는 n 을 입력 해주세요.");
				System.out.println();
				continue;
			} else {
				if(yesOrNo.equals("y")) {
					parkInfoArticleDao.doArticleDelete(article.id);
					System.out.println();
					System.out.println("게시글이 삭제되었습니다.");
					System.out.println();
					return;
				} else if (yesOrNo.equals("n")) {
					System.out.println();
					System.out.println("삭제가 취소되었습니다.");
					System.out.println();
					return;
				} else {
					System.out.println("y 또는 n 을 입력해주세요.");
					System.out.println();
					continue;
				}
			}
		}
	}
	
	public void showArticleRecommendList(String articleTitle) {  // 수정됨 07/20 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		this.replys = parkInfoArticleDao.getArticleReplyList(parkInfoArticleDao.getArticle(articleTitle).id);
		System.out.printf("-------------------------------------------------------------------------------------------\n");
        System.out.printf(" 작성자           작성일         댓글                                        6. 댓글작성       \n" );
        System.out.printf("-------------------------------------------------------------------------------------------\n");
		for (ArticleReply ar : replys) {
			System.out.printf(" %-13s %-13s %s\n",ar.memberId,ar.regDate,ar.body);
		}
		System.out.println();
		
	}
	
	public void doArticleReplyWrite(String articleTitle, String body) {
		parkInfoArticleDao.doArticleReplyWrite(body, parkInfoArticleDao.getArticle(articleTitle).id, mem_id);
		System.out.println();
		System.out.println("댓글 작성이 완료되었습니다.");
		System.out.println();
	
	}
	
	public void doArticleRecommendIncrease(String articleTitle) {
		parkInfoArticleDao.increaseRecommend(parkInfoArticleDao.getArticle(articleTitle).id);
		System.out.println("추천완료!");
		System.out.println();
	}
	
	public void doArticleRecommendDecrease(String articleTitle) {
		parkInfoArticleDao.decreaseRecommend(parkInfoArticleDao.getArticle(articleTitle).id);
		System.out.println("추천취소!");
		System.out.println();
	}

}
