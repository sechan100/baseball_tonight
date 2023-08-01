package com.baseballtonight;

import java.util.HashSet;

import com.baseballtonight.controller.GuestController;
import com.baseballtonight.resources.Message;
import com.baseballtonight.util.Coloring;
import com.baseballtonight.util.UserInput;

public class AppEntering {
	public static void enteringAsGuest() throws InterruptedException {
		while(true){
			System.out.println(Message.app_logo);
			Thread.sleep(1000);
			Coloring.greenOut("로그인 후 이용가능합니다. 계정이 없으시다면 회원가입을 해주세요.");
			System.out.println(""
				+ "---------------------\n"
				+ Coloring.getCyan("회원가입: join \n")
				+ "---------------------\n"
				+ Coloring.getCyan("로그인: login \n")
				+ "---------------------");
			
			/// - 명령어 집합(회원가입 또는 로그인 중에 하나 실행) - 
			HashSet<String> cmd_set = new HashSet<>();
			cmd_set.add("join");	
			cmd_set.add("login");
			///
			
			// only join OR login.
			String userCmd = UserInput.receiveContainedString(cmd_set);
			GuestController.cmdRun(userCmd);
		}
	}
}
