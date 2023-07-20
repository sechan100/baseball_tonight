package com.baseballtonight.controller;

import java.io.*;

import com.baseballtonight.reservation.data.users.User;
import com.baseballtonight.reservation.myreserve.MyreserveModule;
import com.baseballtonight.reservation.reserve.*;
import com.baseballtonight.statics.console.Coloring;
import com.baseballtonight.statics.console.Message;

public class ReservationController {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static String userCommand;

	public static void CLIrun() throws IOException, InterruptedException {
		User.setLogin();
		Thread.sleep(1500);
		System.out.print("[예매 및 좌석 페이지입니다]");
		Message.showReservationCommands();
		while(!(userCommand = rd.readLine()).equals("exit")) {
			switch(userCommand) {
			case "reserve":
				ReserveModule.moduleRun();
				break;

			case "myreserve":
				MyreserveModule.serverRun();
				break;

			case "myclub":
				User.changePreferredClub();
				break;
				
			case "info":
				break;

			case "command.ls":
				Message.showReservationCommands();
				break;

			default:
				Coloring.redOut("Exception: 실행 가능한 명령어가 아닙니다.");
				break;
			}
		}
		Coloring.redOut("프로세스가 종료되었습니다.");
	}
}
