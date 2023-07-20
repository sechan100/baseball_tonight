package com.baseballtonight.controller;

import java.io.IOException;

import com.baseballtonight.module.JoinModule;
import com.baseballtonight.module.LoginModule;

public class GuestController {
	public static void cmdRun(String cmd) throws IOException, InterruptedException {
		switch(cmd){
		case "join":
			JoinModule.doJoin();
			break;
			
		case "login":
			LoginModule.doLogin();
			break;
			
		default:
			System.out.println("없는건디유");
			break;
		}
		// 메인 페이지 실행
		MainController.mainMenu();
	}
	
	
	
}
