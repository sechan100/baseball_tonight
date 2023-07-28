package com.baseballtonight.controller;


import com.baseballtonight.service.JoinService;
import com.baseballtonight.service.LoginService;
import com.baseballtonight.service.MainService;

public class GuestController {
	public static void cmdRun(String cmd) throws InterruptedException {
		switch(cmd){
		case "join":
			JoinService.doJoin();
			break;
			
		case "login":
			LoginService.doLogin();
			
			// 메인 페이지 실행
			MainService.mainMenu();			
			break;
		}
	}
}
