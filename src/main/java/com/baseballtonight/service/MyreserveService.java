package com.baseballtonight.service;

import com.baseballtonight.dao.MyreserveDAO;
import com.baseballtonight.dto.Member;
import com.baseballtonight.util.Coloring;
import com.baseballtonight.util.UserInput;

public class MyreserveService {
	static MyreserveDAO dao = new MyreserveDAO();

	public static void serviceRun() throws InterruptedException {
		// 예매 정보 리스트 보이기.
		boolean emptyReservation = dao.showReservationList(Member.getId());

		// 예매 정보가 없다면 예매 페이지 이동을 추천, 아니라면 commandList 보이기.
		if(emptyReservation) {
			Coloring.redOut("예매 정보가 없습니다. 예매 페이지로 이동하시겠습니까? (Y/N)");
			if(UserInput.receiveYesOrNo()) {
				ReserveService.serviceRun();
			} else {

			}
		} else {
			Coloring.greenOut("예매 취소 페이지로 이동하시겠습니까? (Y/N)");
			if(UserInput.receiveYesOrNo()) {
				CancelServer.serverRun();
			} else {
				Coloring.redOut("취소페이지로 이동하지 못했습니다. 메인으로 이동합니다.");
				Thread.sleep(1500);
			}
		}
	}
}
