package com.baseballtonight.view.block;

import com.baseballtonight.dao.reservation.BlockViewDAO;
import com.baseballtonight.util.console.Coloring;

public class NavyBlockView implements BlockView {
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
					
				}  else if(crt_page == 5){
					
					showFourthPage();
					
				}  else if(crt_page == 6){
					
					showFifthPage();
					
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
					
					showFifthPage();
					
				}  else if(crt_page == 5){
					
					showSixthPage();
					
				}  else if(crt_page == 6){
					
					Coloring.purpleOut("다음 페이지가 없습니다.");
					
				}
				
				break;
		}
	}
	
	@Override
	public void showFirstPage() {
		crt_page = 1;
		
		// 예약 가능한 좌석 개수 불러오기.
		String seat_301 = dao.getAvailableSeatNum(301);
		String seat_302 = dao.getAvailableSeatNum(402);
		String seat_303 = dao.getAvailableSeatNum(303);
		String seat_304 = dao.getAvailableSeatNum(304);
		String seat_305 = dao.getAvailableSeatNum(305);
		String seat_306 = dao.getAvailableSeatNum(306);

		// 출력 view.
		String blockView = String.format("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
				+ "		  				 								 [경기장 필드 방향]						 \n"
				+ "	(1/6)page														 \n"
				+ "+========================================================================================================================+\n"
				+ "|					|					|					|					|					|					|\n"
				+ "|		306			|		305			|		304			|		303			|		302			|		301			|\n"
				+ "|					|					|					|					|					|					|\n"
				+ "|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|\n"
				+ "|					|					|					|					|					|					|\n"
				+ "+========================================================================================================================+\n",
				seat_306,
				seat_305,
				seat_304,
				seat_303,
				seat_302,
				seat_301);

		System.out.println(blockView);
	}
	
	public void showSecondPage() {
		crt_page = 2;
		
		// 예약 가능한 좌석 개수 불러오기.
		String seat_307 = dao.getAvailableSeatNum(307);
		String seat_308 = dao.getAvailableSeatNum(308);
		String seat_309 = dao.getAvailableSeatNum(309);
		String seat_310 = dao.getAvailableSeatNum(310);
		String seat_311 = dao.getAvailableSeatNum(311);
		String seat_312 = dao.getAvailableSeatNum(312);

		// 출력 view.
		String blockView = String.format("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
				+ "		  				 								 [경기장 필드 방향]						 \n"
				+ "	(2/6)page														 \n"
				+ "+========================================================================================================================+\n"
				+ "|					|					|					|					|					|					|\n"
				+ "|		312			|		311			|		310			|		309			|		308			|		307			|\n"
				+ "|					|					|					|					|					|					|\n"
				+ "|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|\n"
				+ "|					|					|					|					|					|					|\n"
				+ "+========================================================================================================================+\n",
				seat_312,
				seat_311,
				seat_310,
				seat_309,
				seat_308,
				seat_307
			);

		System.out.println(blockView);
	}
	
	public void showThirdPage() {
		crt_page = 3;
		
		// 예약 가능한 좌석 개수 불러오기.
		String seat_313 = dao.getAvailableSeatNum(313);
		String seat_314 = dao.getAvailableSeatNum(314);
		String seat_315 = dao.getAvailableSeatNum(315);
		String seat_316 = dao.getAvailableSeatNum(316);
		String seat_317 = dao.getAvailableSeatNum(317);
		String seat_318 = dao.getAvailableSeatNum(318);

		// 출력 view.
		String blockView = String.format("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
				+ "		  				 								 [경기장 필드 방향]						 \n"
				+ "	(3/6)page																 \n"
				+ "+========================================================================================================================+\n"
				+ "|					|					|					|					|					|					|\n"
				+ "|		318			|		317			|		316			|		315			|		314			|		313			|\n"
				+ "|					|					|					|					|					|					|\n"
				+ "|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|	예매가능: %s 		|	예매가능: %s		|	예매가능: %s		|\n"
				+ "|					|					|					|					|					|					|\n"
				+ "+========================================================================================================================+\n",
				seat_318,
				seat_317,
				seat_316,
				seat_315,
				seat_314,
				seat_313
			);

		System.out.println(blockView);
	}
	
	public void showFourthPage() {
		crt_page = 4;
		
		// 예약 가능한 좌석 개수 불러오기.
		String seat_319 = dao.getAvailableSeatNum(319);
		String seat_320 = dao.getAvailableSeatNum(320);
		String seat_321 = dao.getAvailableSeatNum(321);
		String seat_322 = dao.getAvailableSeatNum(322);
		String seat_323 = dao.getAvailableSeatNum(323);
		String seat_324 = dao.getAvailableSeatNum(324);
		
		// 출력 view.
		String blockView = String.format("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
			+ "		  				 								 [경기장 필드 방향]						 \n"
			+ "	(4/6)page																 \n"
			+ "+========================================================================================================================+\n"
			+ "|					|					|					|					|					|					|\n"
			+ "|		324			|		323			|		322			|		321			|		320			|		319			|\n"
			+ "|					|					|					|					|					|					|\n"
			+ "|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|	예매가능: %s 		|	예매가능: %s		|	예매가능: %s		|\n"
			+ "|					|					|					|					|					|					|\n"
			+ "+========================================================================================================================+\n",
			seat_324,
			seat_323,
			seat_322,
			seat_321,
			seat_320,
			seat_319
			);
		
		System.out.println(blockView);
	}
	
	public void showFifthPage() {
		crt_page = 5;
		
		// 예약 가능한 좌석 개수 불러오기.
		String seat_325 = dao.getAvailableSeatNum(325);
		String seat_326 = dao.getAvailableSeatNum(326);
		String seat_327 = dao.getAvailableSeatNum(327);
		String seat_328 = dao.getAvailableSeatNum(328);
		String seat_329 = dao.getAvailableSeatNum(329);
		String seat_330 = dao.getAvailableSeatNum(330);
		
		// 출력 view.
		String blockView = String.format("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
			+ "		  				 								 [경기장 필드 방향]						 \n"
			+ "	(5/6)page																 \n"
			+ "+========================================================================================================================+\n"
			+ "|					|					|					|					|					|					|\n"
			+ "|		330			|		329			|		328			|		327			|		326			|		325			|\n"
			+ "|					|					|					|					|					|					|\n"
			+ "|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|	예매가능: %s 		|	예매가능: %s		|	예매가능: %s		|\n"
			+ "|					|					|					|					|					|					|\n"
			+ "+========================================================================================================================+\n",
			seat_330,
			seat_329,
			seat_328,
			seat_327,
			seat_326,
			seat_325
			);
		
		System.out.println(blockView);
	}
	
	public void showSixthPage() {
		crt_page = 6;
		
		// 예약 가능한 좌석 개수 불러오기.
		String seat_331 = dao.getAvailableSeatNum(331);
		String seat_332 = dao.getAvailableSeatNum(332);
		String seat_333 = dao.getAvailableSeatNum(333);
		String seat_334 = dao.getAvailableSeatNum(334);

		// 출력 view.
		String blockView = String.format("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
				+ "		  				 			  [경기장 필드 방향]						 \n"
				+ "	(6/6)page																 \n"
				+ "+================================================================================+\n"
				+ "|					|					|					|					|\n"
				+ "|		334			|		333			|		332			|		331			|\n"
				+ "|					|					|					|					|\n"
				+ "|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|\n"
				+ "|					|					|					|					|\n"
				+ "+================================================================================+\n",
				seat_334,
				seat_333,
				seat_332,
				seat_331
			);

		System.out.println(blockView);
	}
	
}
