package sbs_first.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import sbs_first.member.Member;

public class MemberController extends Controller {

	private Scanner sc;
	private List<Member> members;
	private String command;
	private String actionMethodName;
	private Member loginedMember;

	public MemberController(Scanner sc) {
		this.sc = sc;
		this.members = new ArrayList<Member>();
	}

	public void doAction(String command, String actionMethodName) {
		this.command = command;
		this.actionMethodName = actionMethodName;

		switch (actionMethodName) {
		case "join":
			doJoin();
			break;
		case "login":
			doLogin();
			break;
		case "logout":
			doLogout();
			break;
		case "modify":
			doModify();
			break;
		case "delete":
			doDelete();
			break;
		case "detail":
			showDetail();
			break;
		default:
			System.out.println("존재하지 않는 명령어 입니다.");
			break;
		}
	}

	public void doJoin() {
		int id = members.size() + 1;
		String loginId = null;

		while (true) {
			System.out.printf("로그인 아이디 : ");
			loginId = sc.nextLine();
			if (loginId.length() == 0) {
				System.out.println("공백은 아이디로 불가합니다.");
				continue;
			}
			if (isJoinableLoginId(loginId) == false) {
				System.out.printf("%s(은)는 이미 사용중인 아이디입니다.\n", loginId);
				continue;
			}

			break;
		}

		String loginPw = null;
		String loginPwConfirm = null;

		while (true) {
			System.out.printf("로그인 비밀번호 : ");
			loginPw = sc.nextLine();
			if (loginPw.length() == 0) {
				System.out.println("공백은 비밀번호로 불가합니다.");
				continue;
			}
			System.out.printf("로그인 비밀번호 확인 : ");
			loginPwConfirm = sc.nextLine();

			if (loginPw.equals(loginPwConfirm) == false) {
				System.out.println("비밀번호를 다시 입력해주세요.");
				continue;
			}

			break;
		}
		int team = 0;
		while (true) {
			System.out.printf("선호하는 팀 : ");
			String teamName = sc.nextLine();
			switch (teamName) {
			case "한화":
				team = 1;
				break;
			case "LG":
			case "lg":
				team = 2;
				break;
			case "SSG":
			case "ssg":
				team = 3;
				break;
			case "두산":
				team = 4;
				break;
			case "NC":
			case "nc":
				team = 5;
				break;
			case "KIA":
			case "kia":
			case "기아":
				team = 6;
				break;
			case "KT":
			case "kt":
				team = 7;
				break;
			case "키움":
				team = 8;
				break;
			case "삼성":
				team = 9;
				break;
			case "롯데":
				team = 10;
				break;
			default:
				System.out.println("입력할 수 없습니다.");
				continue;
			}
			break;
		}
		System.out.printf("이름 : ");
		String name = sc.nextLine();

		Member member = new Member(id, loginId, loginPw, name, team);
		members.add(member);
		loginedMember = member;
		System.out.printf("\n회원가입되었습니다.\n%s님 환영합니다!\n\n", name);

	}

	private void doLogin() {
		if (isLogined()) {
			System.out.println("이미 로그인 되어있습니다.");
			return;
		}
		System.out.printf("로그인 아이디 : ");
		String loginId = sc.nextLine();
		System.out.printf("로그인 비번 : ");
		String loginPw = sc.nextLine();

		Member member = getMemberByLoginId(loginId);

		if (member == null) {
			System.out.println("해당 회원은 존재하지 않습니다.");
			return;
		}

		if (member.loginPw.equals(loginPw) == false) {
			System.out.println("비밀번호가 맞지 않습니다.");
			return;
		}

		loginedMember = member;

		System.out.printf("로그인 성공! %s님 환영합니다!\n회원번호는 %d번 입니다.\n", loginedMember.name, loginedMember.id);
	}

	public void doLogout() {
		if (isLogined() == false) {
			System.out.println("로그인 상태가 아닙니다.");
			return;
		}

		loginedMember = null;

		System.out.println("로그아웃 되었습니다.");
	}

	public void doModify() {
		if (isLogined() == false) {
			System.out.println("로그인 상태가 아닙니다.");
			return;
		}
		while (true) {
			System.out.println("\n회원정보를 변경합니다.");
			System.out.printf("어떤 정보를 변경하시겠습니까?");
			String choose = sc.nextLine();
			switch (choose) {
			case "아이디":
			case "id":
			case "ID":
			case "1":
				System.out.printf("새로운 아이디를 입력하세요>>");
				String loginId = sc.nextLine();
				loginedMember.loginId = loginId;
				System.out.println("아이디가 변경되었습니다.\n");
				break;

			case "비밀번호":
			case "pw":
			case "PW":
			case"2":
				System.out.printf("새로운 비밀번호를 입력하세요>>");
				String loginPw = sc.nextLine();
				System.out.printf("다시 한번 입력해주세요>>");
				String loginPwConfirm =sc.nextLine();
				if (loginPw.equals(loginPwConfirm) == false) {
					System.out.println("비밀번호가 맞지 않습니다.");
					continue;
				}
				loginedMember.loginPw = loginPw;
				System.out.println("비밀번호가 변경되었습니다.\n");
				break;

			case "이름":
			case "name":
			case "3":
				System.out.printf("새로운 이름을 입력하세요>>");
				String name = sc.nextLine();
				loginedMember.name = name;
				System.out.println("이름이 변경되었습니다.\n");
				break;

			case "team":
			case "팀":
			case "4":
				System.out.printf("변경할 팀을 입력해주세요>>");
				String teamName = sc.nextLine();
				int team = 0;
				switch (teamName) {
				case "한화":
					team = 1;
					break;
				case "LG":
				case "lg":
					team = 2;
					break;
				case "SSG":
				case "ssg":
					team = 3;
					break;
				case "두산":
					team = 4;
					break;
				case "NC":
				case "nc":
					team = 5;
					break;
				case "KIA":
				case "kia":
				case "기아":
					team = 6;
					break;
				case "KT":
				case "kt":
					team = 7;
					break;
				case "키움":
					team = 8;
					break;
				case "삼성":
					team = 9;
					break;
				case "롯데":
					team = 10;
					break;
				default:
					System.out.println("존재하지 않는 팀입니다.");
					continue;
				}
				loginedMember.team = team;
				System.out.println("선호하는 팀이 변경되었습니다.\n");
				break;

			default:
				System.out.println("다시 입력해주세요.\n");
				continue;
			}
			break;
		}

	}

	public void doDelete() {
		if (isLogined() == false) {
			System.out.println("로그인 상태가 아닙니다.");
			return;
		}
		loginedMember = null;
		System.out.println("회원탈퇴 되었습니다.");
	}

	public void showDetail() {
		if (isLogined() == false) {
			System.out.println("로그인 상태가 아닙니다.");
			return;
		}
		String teamName = "선호하는 팀 없음";
		int teamId = loginedMember.team;
		switch (teamId) {
		case 1:
			teamName = "한화";
			break;
		case 2:
			teamName = "LG";
			break;
		case 3:
			teamName = "SSG";
			break;
		case 4:
			teamName = "두산";
			break;
		case 5:
			teamName = "NC";
			break;
		case 6:
			teamName = "KIA";
			break;
		case 7:
			teamName = "KT";
			break;
		case 8:
			teamName = "키움";
			break;
		case 9:
			teamName = "삼성";
			break;
		case 10:
			teamName = "롯데";
			break;
		default:
			System.out.println("존재하지 않습니다.");
			break;
		}

		System.out.printf("이름          :%s\n", loginedMember.name);
		System.out.printf("회원번호      :%d\n", loginedMember.id);
		System.out.printf("아이디        :%s\n", loginedMember.loginId);
		System.out.println("비밀번호      :****");
		System.out.printf("좋아하는 구단 :%s\n\n", teamName);

	}

	private int getMemberIndexByLoginId(String loginId) {
		int i = 0;

		for (Member member : members) {
			if (member.loginId.equals(loginId)) {
				return i;
			}

			i++;
		}

		return -1;
	}

	private Member getMemberByLoginId(String loginId) {
		int index = getMemberIndexByLoginId(loginId);

		if (index == -1) {
			return null;
		}

		return members.get(index);
	}

	private boolean isJoinableLoginId(String loginId) {
		int index = getMemberIndexByLoginId(loginId);

		if (index == -1) {
			return true;
		}

		return false;
	}

	private boolean isLogined() {
		return loginedMember != null;
	}
}