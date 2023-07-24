package com.baseballtonight.view.block;

import com.baseballtonight.dao.reservation.BlockViewDAO;
import com.baseballtonight.util.console.Coloring;

public class BlueBlockView implements BlockView{
	public static int crt_page = 1;
	
	static BlockViewDAO dao = new BlockViewDAO();

	
	@Override
	public void showBlock(String pageLocation) {
			switch(pageLocation) {
			case "a":
				
				if(crt_page == 1){
					Coloring.purpleOut("이전 페이지가 없습니다.");
				} else if(crt_page == 2){
					showFirstPage();
				}
				
				break;

				
			case "d":
				
				if(crt_page == 1){
					showSecondPage();
				} else if(crt_page == 2){
					Coloring.purpleOut("다음 페이지가 없습니다.");
				}
				
				break;
		}
	}
	
	@Override
	public void showFirstPage() {
		crt_page = 1;
		
		// 예약 가능한 좌석 개수 불러오기.
		String seat_107 = dao.getAvailableSeatNum(107);
		String seat_108 = dao.getAvailableSeatNum(108);
		String seat_109 = dao.getAvailableSeatNum(109);
		String seat_209 = dao.getAvailableSeatNum(209);
		String seat_210 = dao.getAvailableSeatNum(210);
		String seat_211 = dao.getAvailableSeatNum(211);

		// 출력 view.
		String blockView = String.format("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
				+ "						[경기장 필드 방향]						 \n"
				+ "	(1/2)page\n"
				+ "+============================================================+\n"
				+ "|					|					|					|\n"
				+ "|		109			|		108			|		107			|\n"
				+ "|					|					|					|\n"
				+ "|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|\n"
				+ "|					|					|					|\n"
				+ "+============================================================+\n"
				+ "|					|					|					|\n"
				+ "|		211			|		210			|		209			|\n"
				+ "|					|					|					|\n"
				+ "|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|\n"
				+ "|					|					|					|\n"
				+ "+============================================================+",
			seat_109,
			seat_108,
			seat_107,
			seat_211,
			seat_210,
			seat_209);

		System.out.println(blockView);
	}
	
	public void showSecondPage() {
		crt_page = 2;
		
		// 예약 가능한 좌석 개수 불러오기.
		String seat_114 = dao.getAvailableSeatNum(114);
		String seat_115 = dao.getAvailableSeatNum(115);
		String seat_116 = dao.getAvailableSeatNum(116);
		String seat_216 = dao.getAvailableSeatNum(216);
		String seat_217 = dao.getAvailableSeatNum(217);
		String seat_218 = dao.getAvailableSeatNum(218);

		// 출력 view.
		String blockView = String.format("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
				+ "						  [경기장 필드 방향]						 \n"
				+ "	(2/2)page\n"
				+ "+============================================================+\n"
				+ "|					|					|					|\n"
				+ "|		116			|		115			|		114			|\n"
				+ "|					|					|					|\n"
				+ "|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|\n"
				+ "|					|					|					|\n"
				+ "+============================================================+\n"
				+ "|					|					|					|\n"
				+ "|		218			|		217			|		216			|\n"
				+ "|					|					|					|\n"
				+ "|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|\n"
				+ "|					|					|					|\n"
				+ "+============================================================+",
			seat_116,
			seat_115,
			seat_114,
			seat_218,
			seat_217,
			seat_216);

		System.out.println(blockView);
	}
}