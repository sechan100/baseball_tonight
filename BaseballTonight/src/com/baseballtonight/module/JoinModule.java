package com.baseballtonight.module;

import java.io.IOException;
import java.sql.ResultSet;

import com.baseballtonight.controller.MainController;
import com.baseballtonight.data.Team;
import com.baseballtonight.data.dao.DAO;
import com.baseballtonight.data.dto.MemberDTO;
import com.baseballtonight.statics.console.Coloring;
import com.baseballtonight.statics.console.UserInput;

public class JoinModule {
	static JoinDAO dao = new JoinDAO();
	
	public static void doJoin() throws IOException {
		String member_id;
		String member_password;
		int prf_team_num;
		
		while(true){
			// 아이디 입력.
			System.out.println("아이디를 입력하여 주십시오.");
			member_id = UserInput.receiveNoSpaceString();
			
			
			/* 이미 등록된 아이디가 있는지 비밀번호를 한번 불러와본다. 
			 * null이라면 신규 가입가능, 뭔가 존재한다면 이미 존재하는 아이디이므로 아이디 다시 입력.
			 */
			LoginDAO dao = new LoginDAO();
			String registered_password = dao.getUserPasswordByUserId(member_id);
			if(registered_password != null){
				Coloring.redOut("이미 존재하는 아이디입니다. 다른 아이디를 사용해주세요.");
				continue;
			}
			break;
		}
		
		while(true) {
			// 비밀번호 입력.
			System.out.println("비밀번호를 입력하여 주십시오.");
			member_password = UserInput.receiveNoSpaceString();
			
			// 비밀번호 확인
			System.out.println("비밀번호 확인");
			String member_password_confirm = UserInput.receiveNoSpaceString();
			
			// '비밀번호 != 비밀번호 확인'이라면 == 일 때까지 무한 루프.
			if(!member_password.equals(member_password_confirm)){
				Coloring.redOut("비밀번호 확인이 일치하지 않습니다. 다시 입력해 주십시오.");
				continue;
			}
			break;
		}
		// 응원하는 팀을 선택.
		System.out.println("응원하는 팀을 선택하여 주십시오.");
		System.out.println(Team.team_ls);
		prf_team_num = UserInput.receiveLimitedRangeNum(1, 10);

		
		// DB 전달.
		dao.newJoin(member_id, member_password, prf_team_num);
		
		// member객체 전달.
		MemberDTO mem = new MemberDTO(member_id, member_password, prf_team_num);
		MainController.mem = mem;
		Coloring.greenOut("회원가입이 완료되었습니다. " + member_id + "님, 환영합니다!");
		
		// 메인 페이지 실행
		MainController.mainMenu();
	
	}
}

class JoinDAO {
	ResultSet rs;
	DAO dao = new DAO();
	
	public void newJoin(String user_id, String user_password, int prf_team_num) {
		String register_new_member_SQL = String.format("INSERT INTO members.member (user_id, user_password, preferred_team_num) VALUES ('%s', '%s', %d)", user_id, user_password, prf_team_num);
		dao.update(register_new_member_SQL);
	}


}
