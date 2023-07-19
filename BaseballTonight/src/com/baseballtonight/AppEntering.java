package com.baseballtonight;

import java.io.IOException;
import java.util.HashSet;

import com.baseballtonight.controller.GuestController;
import com.baseballtonight.statics.console.Coloring;
import com.baseballtonight.statics.console.UserInput;

public class AppEntering {
	public static void enteringAsMember() throws InterruptedException, IOException {
		Coloring.greenOut("회원가입 후 이용 가능합니다. 이미 계정이 있으시다면 로그인 해주세요.");
		System.out.println(""
			+ "-------------\n"
			+ Coloring.getCyan("회원가입: join \n")
			+ "-------------\n"
			+ Coloring.getCyan("로그인: login \n")
			+ "-------------");
		
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
