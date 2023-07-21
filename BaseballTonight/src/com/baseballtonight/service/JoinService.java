package com.baseballtonight.service;

import java.io.IOException;

import com.baseballtonight.data.Team;
import com.baseballtonight.data.dao.JoinDAO;
import com.baseballtonight.data.dao.LoginDAO;
import com.baseballtonight.data.dto.Member;
import com.baseballtonight.util.console.Coloring;
import com.baseballtonight.util.console.UserInput;

public class JoinService {
	static JoinDAO dao = new JoinDAO();
	
	public static void doJoin() throws IOException, InterruptedException {
		String member_id;
		String member_password;
		int prf_team_num;
		
		while(true){
			// 아이디 입력.
			Coloring.greenOut("\n회원가입: 아이디");
			member_id = UserInput.receiveNoSpaceString();
			
			
			/* 이미 등록된 아이디가 있는지 비밀번호를 한번 불러와본다. 
			 * null이라면 신규 가입가능, 뭔가 존재한다면 이미 존재하는 아이디이므로 아이디 다시 입력.
			 */
			LoginDAO dao = new LoginDAO();
			String registered_password = dao.getUserPasswordByUserId(member_id);
			if(registered_password != null){
				Coloring.greenOut("\n이미 존재하는 아이디입니다. 해당 아이디로 로그인 할까요?(Y/N) (N: 회원가입 재시도)");
				if(UserInput.receiveYesOrNo()){
					Coloring.purpleOut("\n로그인 페이지로 이동합니다.");
					Thread.sleep(1000);
					LoginService.doLoginSincePassword(member_id);
					break;
				} else {
					continue;
				}
			}
			break;
		}
		
		while(true) {
			// 비밀번호 입력.
			Coloring.greenOut("\n회원가입: 비밀번호");
			member_password = UserInput.receiveNoSpaceString();
			
			// 비밀번호 확인
			Coloring.greenOut("\n회원가입: 비밀번호 확인");
			String member_password_confirm = UserInput.receiveNoSpaceString();
			
			// '비밀번호 != 비밀번호 확인'이라면 == 일 때까지 무한 루프.
			if(!member_password.equals(member_password_confirm)){
				Coloring.redOut("\n비밀번호 확인이 일치하지 않습니다. 다시 입력해 주십시오.");
				continue;
			}
			break;
		}
		// 응원하는 팀을 선택.
		System.out.println("\n회원가입: 응원하는 팀을 선택하여 주십시오.");
		System.out.println(Team.team_ls);
		prf_team_num = UserInput.receiveLimitedRangeNum(1, 10);

		
		// DB 전달.
		dao.newJoin(member_id, member_password, prf_team_num);
		
		// MemberDTO 업데이트.
		Member.setAll(member_id, member_password, prf_team_num);
		Coloring.greenOut("회원가입이 완료되었습니다. ID: " + member_id);
		Thread.sleep(1500);
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	
	}
}
