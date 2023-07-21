package com.baseballtonight.self;

import java.io.IOException;
import java.util.HashSet;

import com.baseballtonight.dao.member.LoginDAO;
import com.baseballtonight.dao.member.MemberDAO;
import com.baseballtonight.dto.Member;
import com.baseballtonight.util.console.Coloring;
import com.baseballtonight.util.console.Message;
import com.baseballtonight.util.console.UserInput;

public class SelfService {
	static MemberDAO dao = new MemberDAO();
	
	//// cmd List
	static HashSet<String> self_cmd = new HashSet<>();
	static {
		self_cmd.add("password");
		self_cmd.add("team");
		self_cmd.add("main");
	}
	////
	
	public static void serviceRun() throws IOException, InterruptedException {
		SelfService.showMe();
		System.out.println(Message.self_cmd_ls);
		String cmd = UserInput.receiveContainedString(self_cmd);
		SelfController.cmdRun(cmd);
	}

	
	
	
	
	////// utils
	public static void showMe() {
		String info = String.format(""
			+ "				<나의 정보 페이지 입니다>\n"
			+ "-------------------------------------------------\n"
			+ "|  아이디: %s  |  응원구단: %s  |  유저번호: %d  \n"
			+ "-------------------------------------------------\n",
			Member.getId(), Member.getPrfTeam().name, dao.getMemberPK());
		System.out.println(info);
	}
	

	public static void changePassword() throws IOException, InterruptedException {
		LoginDAO loginDAO = new LoginDAO();
		while(true){
			Coloring.greenOut("현재 비밀번호\n");
			String input_password = UserInput.receiveNoSpaceString();
			String confirm_password = loginDAO.getUserPasswordByUserId(Member.getId());
			
			// 비밀번호 불일치시 -> continue;
			if(!input_password.equals(confirm_password)){
				Coloring.redOut("비밀번호가 일치하지 않습니다. 다시 입력해주십시오.");
				continue;
			}
			break;
		}
		// 비밀번호 일치시 이후 코드 실행.
		String new_password;
		while(true) {
			// 비밀번호 입력.
			Coloring.greenOut("변경하실 비밀번호를 입력해주십시오.\n");
			new_password = UserInput.receiveNoSpaceString();
			
			// 비밀번호 확인
			Coloring.greenOut("\n다시한번 입력해주십시오.");
			String password_confirm = UserInput.receiveNoSpaceString();
			
			// '비밀번호 != 비밀번호 확인'이라면 == 일 때까지 무한 루프.
			if(!new_password.equals(password_confirm)){
				Coloring.redOut("\n비밀번호가 일치하지 않습니다. 다시한번 입력해주십시오.\n\n\n");
				Thread.sleep(1000);
				continue;
			}
			break;
		}
		Coloring.greenOut("정말로 비밀번호를 변경하시겠습니까? (Y/N)");
		if(UserInput.receiveYesOrNo()){
			MemberDAO.updateNewPassword(new_password);
			System.out.println("변경 하려면 위에 메소드를 정의를 해야지!");
		} else {
			Coloring.purpleOut("비밀번호를 변경하지 못했습니다. 내정보 페이지로 돌아갑니다.");
			Thread.sleep(1000);
			SelfService.showMe();
		}
		
		
		
		
		
	}
	
	

}
