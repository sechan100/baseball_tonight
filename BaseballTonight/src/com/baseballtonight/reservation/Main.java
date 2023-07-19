package com.baseballtonight.reservation;

import java.io.*;

import com.baseballtonight.reservation.console.CLI;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		try {
			CLI.CLIrun();
		} catch(IOException e) {
			System.out.println("main method throw IOException: " + e);
		}
	}
}
