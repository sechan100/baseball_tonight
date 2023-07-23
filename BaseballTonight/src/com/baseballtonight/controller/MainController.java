package com.baseballtonight.controller;


import java.io.IOException;
import java.util.HashSet;

import com.baseballtonight.dto.Member;
import com.baseballtonight.self.SelfService;
import com.baseballtonight.service.MainService;
import com.baseballtonight.service.member.LogoutService;
import com.baseballtonight.service.reservation.MyreserveService;
import com.baseballtonight.service.reservation.ReserveService;
import com.baseballtonight.util.console.Coloring;

public class MainController {
	public static Member mem;
	
	public static HashSet<String> main_cmd = new HashSet<>();
	static{
		main_cmd.add("reserve");
		main_cmd.add("myreserve");
		main_cmd.add("stadium");
		main_cmd.add("self");
		main_cmd.add("logout");
		main_cmd.add("exit");
	}
	
	public static void cmdRun(String cmd) throws IOException, InterruptedException {
		switch(cmd){
		case "reserve":
			ReserveService.serviceRun();
			break;
			
		case "myreserve":
			MyreserveService.serviceRun();
			break;
			
		case "stadium":
			StadiumInfoController.showPrfStadiumInfo();
			break;
		
			
		case "self":
			SelfService.serviceRun();
			break;
			
		case "logout":
			LogoutService.serviceRun();
			break;
			
		case "exit":
			Coloring.purpleOut("종료되었습니다.");
			System.exit(0);
			break;
			
		default:
			break;
		}
		MainService.mainMenu();
	}
	
}
