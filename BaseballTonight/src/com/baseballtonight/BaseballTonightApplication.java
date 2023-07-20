package com.baseballtonight;

import java.io.IOException;

import com.baseballtonight.statics.console.Message;

public class BaseballTonightApplication {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.out.println(Message.app_starting_msg);
		Thread.sleep(1500);
		
		AppEntering.enteringAsMember();
		
	}
}