package com.baseballtonight.view.block;

import com.baseballtonight.dao.reservation.BlockViewDAO;
import com.baseballtonight.util.console.Coloring;

public class GreenBlockView implements BlockView {
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
					
				} else if(crt_page == 3){
					
					showSecondPage();
					
				} else if(crt_page == 4){
					
					showThirdPage();
					
				}
				
				break;

				
			case "d":
				
				if(crt_page == 1){
					showSecondPage();
					
				} else if(crt_page == 2){
					
					showThirdPage();
					
				} else if(crt_page == 3){
					
					showFourthPage();
					
				} else if(crt_page == 4){
					
					Coloring.purpleOut("다음 페이지가 없습니다.");
					
				}
				
				break;
		}
	}
	
	@Override
	public void showFirstPage() {
		crt_page = 1;
		
		// 예약 가능한 좌석 개수 불러오기.
		String seat_401 = dao.getAvailableSeatNum(401);
		String seat_402 = dao.getAvailableSeatNum(402);
		String seat_403 = dao.getAvailableSeatNum(403);
		String seat_404 = dao.getAvailableSeatNum(404);
		String seat_405 = dao.getAvailableSeatNum(405);
		String seat_406 = dao.getAvailableSeatNum(406);

		// 출력 view.
		String blockView = String.format("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
				+ "		  				 								 [경기장 필드 방향]						 \n"
				+ "	(1/4)page														 \n"
				+ "+========================================================================================================================+\n"
				+ "|					|					|					|					|					|					|\n"
				+ "|		401			|		402			|		403			|		404			|		405			|		406			|\n"
				+ "|					|					|					|					|					|					|\n"
				+ "|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|\n"
				+ "|					|					|					|					|					|					|\n"
				+ "+========================================================================================================================+\n",
			seat_401,
			seat_402,
			seat_403,
			seat_404,
			seat_405,
			seat_406);

		System.out.println(blockView);
	}
	
	public void showSecondPage() {
		crt_page = 2;
		
		// 예약 가능한 좌석 개수 불러오기.
		String seat_407 = dao.getAvailableSeatNum(407);
		String seat_408 = dao.getAvailableSeatNum(408);
		String seat_409 = dao.getAvailableSeatNum(409);
		String seat_410 = dao.getAvailableSeatNum(410);
		String seat_411 = dao.getAvailableSeatNum(411);
		String seat_412 = dao.getAvailableSeatNum(412);

		// 출력 view.
		String blockView = String.format("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
				+ "		  				 								 [경기장 필드 방향]						 \n"
				+ "	(2/4)page														 \n"
				+ "+========================================================================================================================+\n"
				+ "|					|					|					|					|					|					|\n"
				+ "|		407			|		408			|		409			|		410			|		411			|		412			|\n"
				+ "|					|					|					|					|					|					|\n"
				+ "|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|\n"
				+ "|					|					|					|					|					|					|\n"
				+ "+========================================================================================================================+\n",
			seat_407,
			seat_408,
			seat_409,
			seat_410,
			seat_411,
			seat_412);

		System.out.println(blockView);
	}
	
	public void showThirdPage() {
		crt_page = 3;
		
		// 예약 가능한 좌석 개수 불러오기.
		String seat_413 = dao.getAvailableSeatNum(413);
		String seat_414 = dao.getAvailableSeatNum(414);
		String seat_415 = dao.getAvailableSeatNum(415);
		String seat_416 = dao.getAvailableSeatNum(416);
		String seat_417 = dao.getAvailableSeatNum(417);
		String seat_418 = dao.getAvailableSeatNum(418);

		// 출력 view.
		String blockView = String.format("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
				+ "		  				 								 [경기장 필드 방향]						 \n"
				+ "	(3/4)page																 \n"
				+ "+========================================================================================================================+\n"
				+ "|					|					|					|					|					|					|\n"
				+ "|		413			|		414			|		415			|		416			|		417			|		418			|\n"
				+ "|					|					|					|					|					|					|\n"
				+ "|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|	예매가능: %s 		|	예매가능: %s		|	예매가능: %s		|\n"
				+ "|					|					|					|					|					|					|\n"
				+ "+========================================================================================================================+\n",
			seat_413,
			seat_414,
			seat_415,
			seat_416,
			seat_417,
			seat_418);

		System.out.println(blockView);
	}
	
	public void showFourthPage() {
		crt_page = 4;
		
		// 예약 가능한 좌석 개수 불러오기.
		String seat_419 = dao.getAvailableSeatNum(419);
		String seat_420 = dao.getAvailableSeatNum(420);
		String seat_421 = dao.getAvailableSeatNum(421);
		String seat_422 = dao.getAvailableSeatNum(422);

		// 출력 view.
		String blockView = String.format("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
				+ "		  				 			  [경기장 필드 방향]						 \n"
				+ "	(4/4)page																 \n"
				+ "+================================================================================+\n"
				+ "|					|					|					|					|\n"
				+ "|		419			|		420			|		421			|		422			|\n"
				+ "|					|					|					|					|\n"
				+ "|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|\n"
				+ "|					|					|					|					|\n"
				+ "+================================================================================+\n",
			seat_419,
			seat_420,
			seat_421,
			seat_422);

		System.out.println(blockView);
	}
	
}
