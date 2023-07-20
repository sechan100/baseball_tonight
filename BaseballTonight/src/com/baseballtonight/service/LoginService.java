package com.baseballtonight.service;

import java.io.IOException;

import com.baseballtonight.data.dao.LoginDAO;
import com.baseballtonight.data.dto.Member;
import com.baseballtonight.util.console.Coloring;
import com.baseballtonight.util.console.UserInput;

public class LoginService {
	static String user_id;
	static String user_password;
	static LoginDAO dao = new LoginDAO();
	
	
	public static void doLogin() throws IOException, InterruptedException {
		try {
			System.out.println("\n아이디");
			user_id = UserInput.receiveNoSpaceString();
			String user_password_confirm = dao.getUserPasswordByUserId(user_id);
			
			// DB에서 아이디로 긁어온 비밀번호가 존재하지 않는다면, 유저정보가 없는 것이다.
			if(user_password_confirm == null){
				throw new NullPointerException();
			}
			while(true){
				System.out.println("\n비밀번호");
				user_password = UserInput.receiveNoSpaceString();
				
				// DB 비밀번호와 입력한 비밀번호가 일치한다면 로그인 성공.
				if(user_password.equals(user_password_confirm)){
					int prf_team_num = dao.getPreferredTeamNumById(user_id);
					Member.setAll(user_id, user_password, prf_team_num);
					Coloring.greenOut("로그인 되셨습니다. " + user_id + "님, 환영합니다.");
					Thread.sleep(1000);
					break;
				}
				Coloring.redOut("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
			}
		} catch(NullPointerException e) {
			Coloring.redOut("회원정보가 없습니다. 회원가입 페이지로 이동합니다.");
			JoinService.doJoin();
		} 
		
	}
}
