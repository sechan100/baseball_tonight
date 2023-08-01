package com.baseballtonight.service;


import com.baseballtonight.controller.MainController;
import com.baseballtonight.resources.Message;
import com.baseballtonight.util.UserInput;

public class MainService {
	public static void mainMenu() throws InterruptedException {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println(Message.app_logo);
		System.out.println(Message.main_menu_cmd_ls);
		MainController.cmdRun(UserInput.receiveContainedString(MainController.main_cmd_set));
	}
}
