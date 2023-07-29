package com.baseballtonight.service;

import java.util.ArrayList;

import com.baseballtonight.dao.ArticleDAO;
import com.baseballtonight.dto.Article;
import com.baseballtonight.dto.ArticleReply;
import com.baseballtonight.util.Coloring;
import com.baseballtonight.util.UserInput;



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
	
	public String getArticleTitle(int articleId) { // 07/26 시작
		return parkInfoArticleDao.getArticleTitle(articleId);
	} // 07/26 끝
	
	public void showSearchedArticle(String searchKey) {         // 수정함 07/20!!!!!!!!!!!!!!!!!!!!!!!!!
		articles = parkInfoArticleDao.getSearchedArticle(searchKey);
		System.out.println();
		System.out.println("< 검색 결과 >\n");
		System.out.println("\n");
		System.out.printf(
				"-------------------------------------------------------------------------------------------\n");
		System.out.
		printf("|  %s  |                        < %s 검색결과 >                        |   %s  |  \n", Coloring.getCyan("back"), searchKey, Coloring.getCyan("main"));
		System.out.printf(
				"-------------------------------------------------------------------------------------------\n");
		System.out.printf("| 번호 |	작성자	|	등록일   | 조회 | 추천 | 제목	\n");
		System.out.printf(
				"-------------------------------------------------------------------------------------------\n");
        for (Article a : articles) {
			System.out.printf(" %-5d%-10s%-13s%-6d%-6d%s\n",a.id,a.memberId,a.regDate,a.hit,a.recommend,a.title);
		}
		System.out.printf("-------------------------------------------------------------------------------------------\n");
		System.out.printf("| %s |                                                   	 	|  %s  |  	 |  %s  |  \n", Coloring.getCyan("write"), Coloring.getCyan("search"), Coloring.getCyan("open"));
	}
	
	public int showArticleDetail(String articleTitle)	{ // 수정됨 07/20 !!!!!!!!!!!!!!!!!!!!!!!!!!!
		Article article = parkInfoArticleDao.getArticle(articleTitle);
		
		if(article == null) {
			System.out.println();
			System.out.println("번호 입력이 잘못되었습니다."); // 07/26 시작 (제목 -> 번호)
			System.out.println("정확한 번호를 입력해주세요."); // 07/26 끝   (제목 -> 번호)
			System.out.println();
			return -1;
		}
		parkInfoArticleDao.increaseHit(article.id);
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.printf("===========================================================================================\n");
        System.out.printf("| 돌아가기: %s  |                                   | 수정: %s |     | 삭제: %s |        \n", Coloring.getCyan("back"), Coloring.getCyan("modify"), Coloring.getCyan("delete") );
        System.out.printf("-------------------------------------------------------------------------------------------\n");
        System.out.printf(" 작성자: %-10s			제목: "  + Coloring.getWhiteBack(Coloring.getBlack("< %s >"))  + "				%-10s  조회: %-4d 추천: %-4d\n",article.memberId, article.title, article.regDate,article.hit,article.recommend);
        System.out.printf("-------------------------------------------------------------------------------------------\n");
        System.out.printf("  "+ Coloring.getWhiteBack(Coloring.getBlack(" %s \n")), article.body);
        System.out.printf("-------------------------------------------------------------------------------------------\n");
        System.out.printf(" | 추천: %s |  |추천 취소: %s|  \n", Coloring.getCyan("rcmd"), Coloring.getCyan("cancel") );
        System.out.printf("-------------------------------------------------------------------------------------------\n");
        System.out.println("\n\n\n");
		return 0;
	}
	
	public void doArticleWrite(String title, String body, int parkId) throws InterruptedException { // 로그인 옵션 필요
		parkInfoArticleDao.doArticleWrite(title,body,parkId,mem_id);

		Coloring.greenOut("게시글이 작성되었습니다.");
		Thread.sleep(1000);
		
	}
	
	public void doArticleModify(String articleTitle) throws InterruptedException { // 로그인 옵션, id 대조 필요
		Article article = parkInfoArticleDao.getArticle(articleTitle);
		if(article == null) {
			Coloring.redOut("게시글 제목이 없습니다.");
			Coloring.redOut("수정하실 게시글의 제목을 정확히 입력해주세요.");
			System.out.println();
			return;
		}
		
		if(!(article.memberId.equals(mem_id))) {
			Coloring.redOut("게시글 수정 권한이 없습니다.");
			Thread.sleep(1500);
			return;
		}
		System.out.printf("새로운 제목입력");
		String title = UserInput.receiveString();
		
		System.out.printf("새로운 내용입력");
		String body = UserInput.receiveString();
		parkInfoArticleDao.doArticleModify(title, body, article.id);
		System.out.println("게시글 수정이 완료되었습니다.");
		Thread.sleep(1500);
	}
	
	public void doArticleDelete(String articleTitle) throws InterruptedException { // 로그인 옵션,  id 대조 필요
		Article article = parkInfoArticleDao.getArticle(articleTitle);
		if(article == null) {
			System.out.println("게시글 제목이 없습니다.");
			System.out.println("삭제하실 게시글의 제목을 정확히 입력해주세요.");
			System.out.println();
			return;
		}
		
		if(!(article.memberId.equals(mem_id))) {
			Coloring.redOut("게시글 삭제 권한이 없습니다.");
			Thread.sleep(1500);
			return;
		}
		
		
		System.out.print("정말 게시글을 삭제하시겠습니까? (y/n)");
		if(UserInput.receiveYesOrNo()){
			parkInfoArticleDao.doArticleDelete(article.id);
			Coloring.greenOut("게시글이 삭제되었습니다.");
			Thread.sleep(1500);
			
		} else {
			Coloring.redOut("게시글 삭제에 실패했습니다.");
			Thread.sleep(1000);
		}
	}
	
	//  07/26 시작!!!!!
	public void setArticleOrderByRecommend() {
		parkInfoArticleDao.setArticleOrderByRecommend();
	}
	
	public void setArticleOrderByHit() {
		parkInfoArticleDao.setArticleOrderByHit();
	}
	
	public void setArticleOrderById() {
		parkInfoArticleDao.setArticleOrderById();
	}
	//07/26 끝!!!!!!!!!
	
	public void showArticleRecommendList(String articleTitle) {  // 수정됨 07/20 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		this.replys = parkInfoArticleDao.getArticleReplyList(parkInfoArticleDao.getArticle(articleTitle).id);
		System.out.printf("===========================================================================================\n");
        System.out.printf(" 작성자    |    작성일       |     %s                                     | 댓글작성:%s |   \n", Coloring.getWhiteBack(Coloring.getBlack("댓글")), Coloring.getCyan("reply") );
        System.out.printf("-------------------------------------------------------------------------------------------\n");
		for (ArticleReply ar : replys) {
			System.out.printf(" %-8s | %-13s | %s  \n",ar.memberId,ar.regDate,ar.body);
		}
		System.out.println();
		
	}
	
	public void doArticleReplyWrite(String articleTitle, String body) throws InterruptedException {
		parkInfoArticleDao.doArticleReplyWrite(body, parkInfoArticleDao.getArticle(articleTitle).id, mem_id);
		System.out.println();
		Coloring.greenOut("댓글 작성이 완료되었습니다.");
		Thread.sleep(1000);
	
	}
	
	public void doArticleRecommendIncrease(String articleTitle, String mem_id) { // 07/26 mem_id 들 추가됨 if 문 추가됨
		int result = parkInfoArticleDao.increaseRecommend(parkInfoArticleDao.getArticle(articleTitle).id, mem_id);
		
		if( result == -1 ) {
			Coloring.redOut("이미 추천하셨습니다.");;
			System.out.println();
		} else {
			Coloring.greenOut("게시글 추천 완료");
			System.out.println();
		}
	}
	
	public void doArticleRecommendDecrease(String articleTitle, String mem_id) { // 07/26 mem_id 들 추가됨  if 문 추가됨
		int result = parkInfoArticleDao.decreaseRecommend(parkInfoArticleDao.getArticle(articleTitle).id, mem_id);
				
		if( result == -1 ) {
			Coloring.redOut("아직 추천하지 않았습니다.");
			System.out.println();
		} else {
			Coloring.redOut("게시글 추천을 취소했습니다.");
			System.out.println();
		}
	}

}