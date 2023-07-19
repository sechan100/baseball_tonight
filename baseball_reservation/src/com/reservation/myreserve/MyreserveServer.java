package com.reservation.myreserve;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.reservation.cancel.CancelServer;
import com.reservation.console.Coloring;
import com.reservation.console.ConsoleUtil;
import com.reservation.data.user.User;
import com.reservation.reserve.ReserveModule;

public class MyreserveServer {
	static MyreserveDAO dao = new MyreserveDAO();

	public static void serverRun() {
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

			// 예매 정보 리스트 보이기.
			boolean emptyReservation = dao.showReservationList(User.getID());

			// 예매 정보가 없다면 예매 페이지 이동을 추천, 아니라면 commandList 보이기.
			if(emptyReservation) {
				Coloring.purpleOut("예매 정보가 없습니다. 예매 페이지로 이동하시겠습니까? (Y/N)");
				while(true) {
					System.out.print(">>>");
					String userAnswer = rd.readLine().toLowerCase();
					if(userAnswer.equals("y")) {
						ReserveModule.moduleRun();
						break;
					} else if(userAnswer.equals("n")) {
						ConsoleUtil.showCommand();
						break;
					} else {
						Coloring.redOut("유효하지 않은 답변입니다. 다시 입력해주십시오.\n");
					}
				}
			} else {
				System.out.println("예매 취소 페이지로 이동하시겠습니까? (Y/N)");
				while(true) {
					System.out.print(">>>");
					String userAnswer = rd.readLine().toLowerCase();
					if(userAnswer.equals("y")) {
						CancelServer.serverRun();
						break;
					} else if(userAnswer.equals("n")) {
						Coloring.purpleOut("취소페이지로 이동하지 못했습니다. 메인으로 이동합니다.");
						Thread.sleep(1500);
						ConsoleUtil.showCommand();
						break;
					} else {
						Coloring.redOut("유효하지 않은 답변입니다. 다시 입력해주십시오.\n");
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
