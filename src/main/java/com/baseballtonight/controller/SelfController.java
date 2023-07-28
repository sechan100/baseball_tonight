package com.baseballtonight.controller;


import com.baseballtonight.service.MainService;
import com.baseballtonight.service.SelfService;

public class SelfController {
	public static void cmdRun(String cmd) throws InterruptedException {
		switch(cmd){
		case "password":
			SelfService.changePassword();
			break;
			
		case "team":
			SelfService.changePrfTean();
			break;
			
		case "main":
			MainService.mainMenu();
			break;
		}
	}
}
