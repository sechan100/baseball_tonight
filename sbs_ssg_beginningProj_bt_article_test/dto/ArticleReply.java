package dto;

public class ArticleReply {
	public int id;
	public String regDate;
	public String body;
	public int memberId; // memberId 가 String 으로 바뀌어야 함

	public ArticleReply(int id, String regDate, String body, int memberId) {
		this.id = id;
		this.regDate = regDate;
		this.body = body;
		this.memberId = memberId;
	}
}


