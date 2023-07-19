package com.baseballtonight.reservation;

import java.io.*;

import com.baseballtonight.controller.ReservationController;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		try {
			ReservationController.CLIrun();
		} catch(IOException e) {
			System.out.println("main method throw IOException: " + e);
		}
	}
}
