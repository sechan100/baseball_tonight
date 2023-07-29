package com.baseballtonight.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

import com.baseballtonight.dto.Member;
import com.baseballtonight.service.MainService;

public class UserInput {

	public static String receiveString() throws InterruptedException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.print(">>>");
			String input;
			try {
				input = rd.readLine();
				
				boolean isLogined = ( Member.getId() == null ? false : true );
				
				if(input.equals("main") && isLogined) {
					MainService.mainMenu();
				}
				return input;

			} catch(IOException e) {
				e.printStackTrace();
				return null;
			}
		}
	}

	public static boolean receiveYesOrNo() {
		while(true) {
			String userAnswer;
			try {
				userAnswer = UserInput.receiveString().toLowerCase();
				if(userAnswer.equals("y") || userAnswer.equals("")) {
					return true;
				} else if(userAnswer.equals("n")) {
					return false;
				} else {
					Coloring.redOut("유효하지 않은 답변입니다. 다시 입력해주십시오.\n");
				}
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static String receiveSeatType() throws InterruptedException {
		HashSet<String> seatType_set = new HashSet<>();
		seatType_set.add("premium");
		seatType_set.add("table");
		seatType_set.add("blue");
		seatType_set.add("red");
		seatType_set.add("navy");
		seatType_set.add("green");

		String seatType = UserInput.receiveContainedString(seatType_set);

		return seatType;
	}

	public static int receiveContainedNum(HashSet<Integer> set) throws InterruptedException {
		while(true) {
			try {
				int num = Integer.parseInt(UserInput.receiveString());
				if(!set.contains(num)) {
					throw new NumberFormatException();
				}
				return num;
			} catch(NumberFormatException e) {
				Coloring.redOut("올바른 범위의 수를 입력하여 주십시오.");
			}
		}
	}

	public static String receiveRestrictedString(String first) throws InterruptedException {
		while(true) {
			String input = UserInput.receiveNoSpacingString();
			if(input.equals(first)) {
				return input;
			} else {
				Coloring.redOut("유효한 입력이 아닙니다.");
			}
		}
	}

	public static String receiveRestrictedString(String first, String second) throws InterruptedException {
		while(true) {
			String input = UserInput.receiveNoSpacingString();
			if(input.equals(first)) {
				return input;
			} else if(input.equals(second)) {
				return input;
			} else {
				Coloring.redOut("유효한 입력이 아닙니다.");
			}
		}
	}

	public static String receiveContainedString(HashSet<String> set) throws InterruptedException {
		while(true) {
			try {
				String userInput = UserInput.receiveString().toLowerCase();
				if(!set.contains(userInput)) {
					throw new NullPointerException();
				}
				return userInput;
			} catch(NullPointerException e) {
				Coloring.redOut("유효한 입력이 아닙니다.");
			}
		}
	}

	public static int receiveLimitedRangeNum(int start, int end) throws InterruptedException {
		while(true) {
			try {
				int num = Integer.parseInt(UserInput.receiveString());
				if(num < start || num > end) {
					throw new NumberFormatException();
				}
				return num;
			} catch(NumberFormatException e) {
				Coloring.redOut("올바른 범위의 수를 입력하여 주십시오.");
			}
		}
	}

	public static int receiveNaturalNumber() throws InterruptedException {
		while(true) {
			try {
				int num = Integer.parseInt(UserInput.receiveString());
				if(num <= 0) {
					throw new NumberFormatException();
				}
				return num;
			} catch(NumberFormatException e) {
				Coloring.redOut("0보다 큰 정수를 입력하여 주십시오.");
			}
		}
	}

	public static String receiveNoSpacingString() throws InterruptedException {
		while(true) {
			try {
				String input = UserInput.receiveString();
				if(input.contains(" ")) {
					throw new IOException();
				}
				return input;
			} catch(IOException e) {
				Coloring.redOut("공백이 포함될 수 없습니다. 다시 입력해주세요.");
			}
		}
	}
}
