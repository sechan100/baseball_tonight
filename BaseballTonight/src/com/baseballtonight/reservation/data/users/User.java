package com.baseballtonight.reservation.data.users;

import java.io.IOException;

import com.baseballtonight.reservation.data.club.Club;
import com.baseballtonight.statics.console.Coloring;
import com.baseballtonight.statics.console.Message;
import com.baseballtonight.statics.console.UserInput;

public class User {
	private static int id;
	public static Club preferredClub;

	public static void setId(int id) {
		User.id = id;
	}

	public static int getId() {
		return User.id;
	}

	public static void setLogin() throws IOException, InterruptedException {
		UserDAO dao = new UserDAO();
		Coloring.greenOut("User ID를 입력하여 주십시오.");
		System.out.print("ID: ");
		int userId = UserInput.receiveNaturalNumber();
		setId(userId);

		// 로그인 정보가 있다면, 선호하는 구단 정보를 가져오기.
		boolean canLogin = dao.isRegistered(userId);
		while(true) {
			if(canLogin) {
				Club preferred = Club.clubs.get(dao.getPreferredClubNum(userId) - 1);
				User.preferredClub = preferred;
				Thread.sleep(800);
				System.out.println("-------------------------------\n"
					+ Coloring.getGreen("로그인 성공, " + userId + "번 회원님, 환영합니다.")
					+ "\n선호하는 구단: " + preferred.name + "\n\n\n\n\n\n\n");
				break;
				// 로그인 정보가 없다면, 선호하는 구단을 등록하기.
			} else {
				Coloring.redOut("유저 정보가 존재하지 않습니다. 선호 구단 정보를 등록해주세요.");
				Thread.sleep(1000);
				int clubId = UserDAO.receivePreferredClubNum();
				Thread.sleep(700);
				dao.registerNewUser(userId, clubId);
				canLogin = true;
			}
		}
	}

	public static void changePreferredClub() throws IOException, InterruptedException {
		UserDAO dao = new UserDAO();
		Coloring.greenOut("현재 등록된 선호구단: " + dao.getPreferredClubName(User.id));
		Thread.sleep(1000);
		//
		Coloring.cyanOut("선호 구단을 변경하시겠습니까? (Y/N)");
		if(UserInput.receiveYesOrNo()) {
			int newPreferredClubNum = UserDAO.receivePreferredClubNum();
			dao.changePreferredClub(newPreferredClubNum);
			User.preferredClub = Club.getClubByNum(newPreferredClubNum);
			Thread.sleep(1500);
			Message.showReservationCommands();
		} else {
			Coloring.purpleOut("선호구단을 변경하지 못했습니다. 메인 페이지로 이동합니다.");
			Thread.sleep(1000);
			Message.showReservationCommands();
		}
	}
}
