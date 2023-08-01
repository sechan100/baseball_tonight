package com.baseballtonight.resources;

import com.baseballtonight.util.Coloring;

public class AppEnteringLogo {
	
	public static void printLogo() throws InterruptedException {
		String[] rowLogos = new String[27];
		
		rowLogos[0] = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀  ⠀⣀⣠⣤⣴⣶⣾⣿⣿⣿⣿⣿⣿⣿⣷⣶⣦⣤⣄⣀⠀";
		rowLogos[1] = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⢀⣤⣶⣿⡿⠿⠛⠋⠉⠁⠀⠀⠀⠀⠀⠀⠀⠈⠉⠙⠛⠿⢿⣿⣶⣤⡀";
		rowLogos[2] = " ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣾⡿⠟⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠻⢿⣷⣦⡀";
		rowLogos[3] = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⣠⣴⣿⠟⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠻⣿⣦⣄";
		rowLogos[4] = " ⠀⠀⠀⠀⠀⠀⠀⠀⢀⣶⣿⠿⣿⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⣿⠿⣿⣶⡀⠀";
		rowLogos[5]= " ⠀⠀⠀⠀⠀⠀⠀⣴⣿⡟⠁⠀⠙⣿⣷⣤⣶⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣶⣤⣾⣿⠋⠀⠈⢻⣿⣦";
		rowLogos[6]= " ⠀⠀⠀⠀⠀⢀⣼⣿⠋⠀⠀⠀⣴⣿⣿⣿⡉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢉⣿⣿⣿⣦⠀⠀⠀⠙⣿⣧⡀";
		rowLogos[7]= " ⠀⠀⠀⠀⠀⠈⠉⠁⠀⠀⠀⠀⠉⠁⠈⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠁⠈⠉⠀⠀⠀⠀⠈⠉⠁";
		rowLogos[8]= " ⢀⣠⠤⢤⣄⡀⠀⠀⠀⣀⡤⠤⣄⡀⠀⠀⠀⣀⡤⠤⣤⡀⠀⣠⡤⠤⠤⢤⡀⢀⣠⠤⢤⣀⠀⠀⠀⠀⣀⡤⠤⣄⡀⠀⠀⣠⠤⡀⠀⠀⠀⣠⠤⣄⠀⠀⠀⠀";
		rowLogos[9]= " ⡎⠀⠀⣤⠀⠹⣄⢀⠞⠁⠀⠀⠀⠙⢦⣠⠎⠀⠀⠀⠀⠈⣾⠁⠀⠀⠀⠀⣸⡏⠀⠀⣤⠀⢱⣄⢠⠎⠀⠀⠀⠀⠙⣆⢸⠁⠀⢸⣦⠀⢰⠁⠀⠘⣦⠀⠀⠀";
		rowLogos[10]= " ⡇⠀⠀⠉⠀⠀⢿⡟⠀⠀⢠⡄⠀⠀⠈⣿⣆⡀⠀⠀⠶⣤⣿⠀⠀⠀⠋⠛⢿⡇⠀⠀⠉⠀⠘⢿⡏⠀⠀⢠⡄⠀⠀⠘⣿⠀⠀⢸⣿⠀⢸⠀⠀⠀⣿⠀⠀⠀";
		rowLogos[11]= " ⡇⠀⠀⣴⠀⠀⢸⣧⠀⠀⠀⠁⠀⠀⠀⣿⠋⠙⠂⠀⠀⠈⣿⠀⠀⠀⠤⠴⣿⡇⠀⠀⣤⠀⠀⢸⡇⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠘⠛⢢⣼⠀⠀⠀⠛⠣⡀⠀";
		rowLogos[12]= " ⢇⡀⠀⠀⣀⣠⣾⡿⣄⠀⣸⣿⡄⠀⣰⣿⢦⣀⠀⠀⣀⣴⣿⣄⠀⠀⠀⢀⣸⣇⠀⠀⠀⣀⣠⣾⡿⡀⢀⣿⣷⡀⢀⣴⣿⣄⡀⠀⢀⣰⣿⣆⡀⠀⠀⣠⣿⠆";
		rowLogos[13]= " ⠀⠉⠙⢛⣻⣯⣭⣤⣬⡉⠛⠁⣈⣩⣿⣍⣀⠈⠉⠛⣻⣏⡁⢈⣭⣛⠛⣛⣿⣉⠉⠛⠛⣛⣯⣥⣀⡈⠉⢛⣡⣍⡙⣛⣥⣄⠉⣙⣿⣿⣭⣤⣍⡙⠛⠛⠉";
		rowLogos[14]= " ⠀⠀⠀⡃⠀⠀⠀⠀⠀⢸⣦⠞⠁⠀⠀⠀⠈⠱⣄⣾⠀⠀⠱⠇⠀⠸⣶⠁⠀⠈⣦⡤⠊⠀⠀⠀⠀⠈⢢⣾⠀⠀⢹⡇⠀⠀⣿⠁⠀⠀⠀⠀⠀⢹⣄";
		rowLogos[15]= " ⠀⠀⠀⠑⢲⠀⠀⠀⣶⣿⡟⠀⠀⠀⣀⠀⠀⠀⢸⡇⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⣿⠃⠀⠀⣠⣶⣦⣤⣿⣿⠀⠀⠀⠀⠀⠀⣿⡗⣶⠀⠀⢠⣶⡿⠟";
		rowLogos[16]= " ⠀⠀⠀⠀⢸⠀⠀⠀⣿⡇⢧⠀⠀⠀⠉⠀⠀⠀⣸⡇⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⣿⡄⠀⠀⠈⠉⠁⠀⢱⣿⠀⠀⢠⡄⠀⠀⣿⡇⣿⠀⠀⢸⣿⠀⠀";
		rowLogos[17]= " ⠀⠀⠀⠀⠸⡄⠀⢀⣿⡇⠈⠢⣀⠀⠀⠀⣠⣾⡿⢧⡀⠀⣴⣄⠀⢠⣿⡄⠀⢠⣿⡗⢤⡀⠀⠀⠀⠀⣸⣿⠀⠀⣸⣇⠀⢀⣿⡇⢻⡀⠀⣸⣿⠀⠀";
		rowLogos[18]= " ⠀⠀⠀⠀⠀⠈⠉⠛⠛⠀⠀⠀⠈⠉⠛⠛⠛⠋⠀⠀⠉⠙⠛⠉⠉⠛⠋⠉⠉⠛⠋⠀⠀⠈⠙⠛⠛⠛⠛⠋⠉⠙⠛⠋⠉⠛⠛⠁⠀⠉⠙⠛⠋⠀";
		rowLogos[19]= " ⠀⠀⠀⠀⠀⢀⣀⡀⠀⠀⠀⠀⣀⡀⢀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⡀⢀⣀⠀⠀⠀⠀⢀⣀⡀⠀";
		rowLogos[20]= " ⠀⠀⠀⠀⠀⠈⢻⣿⣄⠀⠀⠀⠻⣿⣿⣿⣁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣈⣿⣿⣿⠟⠀⠀⠀⣠⣿⡟⠁";
		rowLogos[21]= " ⠀⠀⠀⠀⠀⠀⠀⠻⣿⣧⡀⠀⣠⣿⡿⠛⠿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⠿⠛⢿⣿⣄⠀⢀⣼⣿⠟⠀";
		rowLogos[22]= " ⠀⠀⠀⠀⠀⠀⠀⠀⠈⠿⣿⣶⣿⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⣿⣶⣿⠿⠁⠀⠀";
		rowLogos[23]= " ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠻⣿⣦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣴⣿⠟⠋⠀⠀";
		rowLogos[24]= " ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⢿⣷⣦⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣴⣿⡿⠟⠁⠀⠀";
		rowLogos[25]= " ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠿⣿⣷⣶⣤⣄⣀⡀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣠⣤⣶⣾⣿⠿⠛⠁";
		rowLogos[26]= " ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠙⠛⠻⠿⢿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠟⠛⠋⠉";


		
		StringBuilder[]	SBuilders = new StringBuilder[27];
		
		for(int i = 0; i<27; i++){
			SBuilders[i] = new StringBuilder();
		}
		Thread.sleep(1000);
		StringBuilder enteringBar = new StringBuilder();
			for(int i = 0; i<=100; i++){
				enteringBar.append(Coloring.getCyan("#"));
				System.out.print(Coloring.getGreen("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n애플리케이션 실행중... ( "+i+" / " + 100 + " )\n"));
				System.out.print(enteringBar);
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				Thread.sleep(80);
			}
			Thread.sleep(1000);
			
			for(int i = 0; i<70; i++){
				for(int j = 0; j<27; j++){
					try {
						SBuilders[j].append(rowLogos[j].charAt(i));
					} catch(Exception e) {
					}
				}
				
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			for(int k = 0; k<27; k++){
				Coloring.cyanOut(String.valueOf(SBuilders[k]));
			}
			Thread.sleep(90);
			}
	}
}
