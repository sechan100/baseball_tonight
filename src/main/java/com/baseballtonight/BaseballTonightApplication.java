package com.baseballtonight;

import java.io.IOException;

import com.baseballtonight.resources.AppEnteringLogo;
import com.baseballtonight.util.Coloring;
import com.baseballtonight.util.UserInput;


public class BaseballTonightApplication {

	public static void main(String[] args) throws InterruptedException, IOException {
		AppEnteringLogo.printLogo();
		Coloring.greenOut("\nBaseball - Tonight에 오신 것을 환영합니다! \n\nEnter를 눌러주세요!");
		UserInput.receiveYesOrNo();
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
		AppEntering.enteringAsGuest();
		
	}
}