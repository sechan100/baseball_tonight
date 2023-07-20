package com.baseballtonight.controller;


import java.io.IOException;
import java.util.HashSet;

import com.baseballtonight.data.dto.MemberDTO;
import com.baseballtonight.reservation.myreserve.MyreserveModule;
import com.baseballtonight.reservation.reserve.ReserveModule;
import com.baseballtonight.statics.console.Message;
import com.baseballtonight.statics.console.UserInput;

public class MainController {
	public static MemberDTO mem;
	
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
			System.out.println("아직 안 붙엿어여ㅕ");
			break;
			
		case "seats":
			System.out.println("아직 업성요");
			break;
			
		case "self":
			
			break;
			
		case "exit":
			break;
			
		default:
			break;
		}
	}
	
}
