package sbs_first.member;

public class Member {

	public int id;
	public String loginId;
	public String loginPw;
	public String name;
	public int team;

	public Member(int id, String loginId, String loginPw, String name, int team) {
		this.id = id;
		this.loginId = loginId;
		this.loginPw = loginPw;
		this.name = name;
		this.team = team;
	}
}
