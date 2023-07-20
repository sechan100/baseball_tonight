package com.baseballtonight.statics.console;

import java.io.*;
import java.util.HashSet;

public class UserInput {
	
	public static boolean receiveYesOrNo() throws IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.print(">>>");
			String userAnswer = rd.readLine().toLowerCase();
			if(userAnswer.equals("y")) {
				return true;
			} else if(userAnswer.equals("n")) {
				return false;
			} else {
				Coloring.redOut("유효하지 않은 답변입니다. 다시 입력해주십시오.\n");
			}
		}
	}

	public static String receiveSeatType() {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> seatTypeSet = new HashSet<>();
		seatTypeSet.add("premium");
		seatTypeSet.add("table");
		seatTypeSet.add("blue");
		seatTypeSet.add("red");
		seatTypeSet.add("navy");
		seatTypeSet.add("green");
		while(true) {
			try {
				String seatType = rd.readLine().toLowerCase();
				if(!seatTypeSet.contains(seatType)) {
					throw new NumberFormatException();
				}
				return seatType;
			} catch(Exception e) {
				Coloring.redOut("올바른 좌석 유형을 입력해 주십시오.");
			}
		}
	}

	public static int receiveContainedNum(HashSet<Integer> set) {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				int num = Integer.parseInt(rd.readLine());
				if(!set.contains(num)) {
					throw new NumberFormatException();
				}
				return num;
			} catch(NumberFormatException e) {
				Coloring.redOut("올바른 범위의 수를 입력하여 주십시오.");
			} catch(IOException e) {
				System.out.println("ConsoleUtil.receiveCustomRangeNum throw IOException!: " + e);
			}
		}
	}

	public static String receiveContainedString(HashSet<String> set) {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				System.out.print(">>>");
				String userInput = rd.readLine().toLowerCase();
				if(!set.contains(userInput)) {
					throw new NullPointerException();
				}
				return userInput;
			} catch(NullPointerException e) {
				Coloring.redOut("올바른 문자를 입력하여 주십시오.");
			} catch(IOException e) {
				System.out.println("ConsoleUtil.receiveContainedString throw IOException!: " + e);
			}
		}
	}

	public static int receiveLimitedRangeNum(int start, int end) {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				System.out.print(">>>");
				int num = Integer.parseInt(rd.readLine());
				if(num < start || num > end) {
					throw new NumberFormatException();
				}
				return num;
			} catch(NumberFormatException e) {
				Coloring.redOut("올바른 범위의 수를 입력하여 주십시오.");
			} catch(IOException e) {
				System.out.println("ConsoleUtil.receiveCustomRangeNum throw IOException!: " + e);
			}
		}
	}

	public static int receiveNaturalNumber() {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				int num = Integer.parseInt(rd.readLine());
				if(num <= 0) {
					throw new NumberFormatException();
				}
				return num;
			} catch(NumberFormatException e) {
				Coloring.redOut("0보다 큰 정수를 입력하여 주십시오.");
			} catch(IOException e) {
				System.out.println("ConsoleUtil.receiveNaturalNumber throw IOException!");
			}
		}
	}

	public static String receiveNoSpaceString() throws IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			try {
				System.out.print(">>>");
				String input = rd.readLine();
				if(input.contains(" ")){
					throw new IOException();
				}
				return input;
			} catch(IOException e) {
				Coloring.redOut("공백이 포함될 수 없습니다. 다시 입력해주세요.");
			}
		}
	}
}
