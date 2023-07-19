package com.baseballtonight.controller;


import java.util.HashSet;

import com.baseballtonight.data.dto.MemberDTO;
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
	
	public static void mainMenu() {
		System.out.println(Message.main_cmd_ls);
		MainController.cmdRun(UserInput.receiveContainedString(MainController.main_cmd));
	}
	
	public static void cmdRun(String cmd) {
		switch(cmd){
		case "reserve":
			break;
			
		case "myreserve":
			break;
			
		case "stadium":
			break;
			
		case "seats":
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
