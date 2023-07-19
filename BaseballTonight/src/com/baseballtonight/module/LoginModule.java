package com.baseballtonight.module;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.baseballtonight.controller.MainController;
import com.baseballtonight.data.dao.DAO;
import com.baseballtonight.statics.console.Coloring;
import com.baseballtonight.statics.console.UserInput;

public class LoginModule {
	static String user_id;
	static String user_password;
	static LoginDAO dao = new LoginDAO();
	
	
	public static void doLogin() throws IOException {
		try {
			System.out.println("아이디");
			user_id = UserInput.receiveNoSpaceString();
			String user_password_confirm = dao.getUserPasswordByUserId(user_id);
			
			// DB에서 아이디로 긁어온 비밀번호가 존재하지 않는다면, 유저정보가 없는 것이다.
			if(user_password_confirm == null){
				throw new NullPointerException();
			}
			while(true){
				System.out.println("비밀번호");
				user_password = UserInput.receiveNoSpaceString();
				
				// DB 비밀번호와 입력한 비밀번호가 일치한다면 로그인 성공.
				if(user_password.equals(user_password_confirm)){
					Coloring.greenOut("로그인 되셨습니다. " + user_id + "님, 환영합니다.");
					break;
				}
			}
		} catch(NullPointerException e) {
			Coloring.redOut("회원정보가 없습니다. 회원가입 페이지로 이동합니다.");
			JoinModule.doJoin();
		} 
		
		// 메인 페이지 실행
		MainController.mainMenu();
		
	}
}

class LoginDAO {
	DAO dao = new DAO();
	
	/**
	 * 
	 * @param user_id
	 * @return If user data is registered, return user_password, not null.
	 */
	public String getUserPasswordByUserId(String user_id) {
		String select_user_id_SQL = String.format("SELECT user_password FROM members.member WHERE user_id = '%s';", user_id);
		ResultSet rs = dao.select(select_user_id_SQL);
		try {
			rs.next();
			return rs.getString(1);
		} catch(SQLException e) {
			return null;
		}
	}
	
	
	
	
	
	
	
	
}
