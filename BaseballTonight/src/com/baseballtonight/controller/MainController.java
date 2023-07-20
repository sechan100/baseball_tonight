package com.baseballtonight.controller;


import java.io.IOException;
import java.util.HashSet;

import com.baseballtonight.data.dto.Member;
import com.baseballtonight.service.MyreserveModule;
import com.baseballtonight.service.ReserveModule;
import com.baseballtonight.util.console.Coloring;
import com.baseballtonight.util.console.Message;
import com.baseballtonight.util.console.UserInput;

public class MainController {
	public static Member mem;
	
	public static HashSet<String> main_cmd = new HashSet<>();
	static{
		main_cmd.add("reserve");
		main_cmd.add("myreserve");
		main_cmd.add("stadium");
		main_cmd.add("seats");
		main_cmd.add("self");
		main_cmd.add("exit");
	}
	
	public static void mainMenu() throws IOException, InterruptedException {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println(Message.main_cmd_ls);
		MainController.cmdRun(UserInput.receiveContainedString(MainController.main_cmd));
	}
	
	public static void cmdRun(String cmd) throws IOException, InterruptedException {
		switch(cmd){
		case "reserve":
			ReserveModule.moduleRun();
			break;
			
		case "myreserve":
			MyreserveModule.serverRun();
			break;
			
		case "stadium":
			StadiumInfoController.showPrfStadiumInfo();
			break;
			
		case "seats":
			System.out.println("아직 업성요");
			break;
			
		case "self":
			
			break;
			
		case "exit":
			Coloring.purpleOut("종료되었습니다.");
			System.exit(0);
			break;
			
		default:
			break;
		}
	}
	
}
