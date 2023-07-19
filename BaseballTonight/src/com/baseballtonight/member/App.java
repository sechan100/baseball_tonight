package com.baseballtonight.member;

import java.util.Scanner;

import com.baseballtonight.member.controller.ArticleController;
import com.baseballtonight.member.controller.Controller;
import com.baseballtonight.member.controller.MemberController;


public class App {
	public void start() {
		System.out.println("== 프로그램 시작 ==");
		System.out.println("명령어 조회는 0번을 눌러주세요.");
		Scanner sc = new Scanner(System.in);
		MemberController memberController = new MemberController(sc);
		ArticleController articleController = new ArticleController(sc);
		while(true) {
			String command = sc.nextLine();
			if (command.equals("0")) {
				System.out.println("member join   >(회원가입하기)");
				System.out.println("member login  >(로그인하기)");
				System.out.println("member logout >(로그아웃하기)");
				System.out.println("member modify >(정보수정하기)");
				System.out.println("member delete >(회원탈퇴하기)");
				System.out.println("member detail >(회원정보조회하기)");
				System.out.println("system exit   >(프로그램 종료)");
				System.out.println();
			}
			break;
		}
		while (true) {
			System.out.printf("명령어>>");
			String command = sc.nextLine();
			command = command.trim();

			if (command.equals("system exit")) {
				break;
			} 
			String[] commandBits = command.split(" ");
			if(commandBits.length==1) {
				System.out.println("존재하지 않는 명령어입니다.");
				continue;
			}
			String actionMethodName = commandBits[1]; 
			
			Controller controller = null;
			controller = memberController;
			controller.doAction(command, actionMethodName);
		}
		sc.close();
		System.out.println("== 프로그램 종료 ==");
	}

}

	

