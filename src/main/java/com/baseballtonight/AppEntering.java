package com.baseballtonight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

import com.baseballtonight.controller.GuestController;
import com.baseballtonight.util.Coloring;
import com.baseballtonight.util.Message;

public class AppEntering {
	public static void enteringAsGuest() throws InterruptedException {
		while(true){
			System.out.println(Message.app_logo);
			Thread.sleep(1000);
			Coloring.greenOut("로그인 후 이용가능합니다. 계정이 없으시다면 회원가입을 해주세요.");
			System.out.println(""
				+ "---------------------\n"
				+ Coloring.getCyan("회원가입: join \n")
				+ "---------------------\n"
				+ Coloring.getCyan("로그인: login \n")
				+ "---------------------");
			
			/// - 명령어 집합(회원가입 또는 로그인 중에 하나 실행) - 
			HashSet<String> cmd_set = new HashSet<>();
			cmd_set.add("join");	
			cmd_set.add("login");
			///
			
			// only join OR login.
			String userCmd;
			BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
				while(true) {
				try {
					System.out.print(">>>");
					userCmd = rd.readLine().toLowerCase();
					if(!cmd_set.contains(userCmd)) {
						throw new NullPointerException();
					}
					break;
				} catch(NullPointerException e) {
					Coloring.redOut("유효한 입력이 아닙니다.");
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			GuestController.cmdRun(userCmd);
		}
	}
}
