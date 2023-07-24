package com.baseballtonight.view.block;

import com.baseballtonight.dao.reservation.BlockViewDAO;
import com.baseballtonight.util.console.Coloring;

public class RedBlockView implements BlockView{
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
		String seat_101 = dao.getAvailableSeatNum(101);
		String seat_102 = dao.getAvailableSeatNum(102);
		String seat_103 = dao.getAvailableSeatNum(103);
		String seat_201 = dao.getAvailableSeatNum(201);
		String seat_202 = dao.getAvailableSeatNum(202);
		String seat_203 = dao.getAvailableSeatNum(203);
		String seat_204 = dao.getAvailableSeatNum(204);

		// 출력 view.
		String blockView = String.format("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
				+ "						[경기장 필드 방향]						 \n"
				+ "	(1/4)page\n"
				+ "+============================================================+\n"
				+ "|					|					|					|\n"
				+ "|		103			|		102			|		101			|\n"
				+ "|					|					|					|\n"
				+ "|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|\n"
				+ "|					|					|					|\n"
				+ "+============================================================+==================+\n"
				+ "|					|					|					|					|\n"
				+ "|		204			|		203			|		202			|		201			|\n"
				+ "|					|					|					|					|\n"
				+ "|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|\n"
				+ "|					|					|					|					|\n"
				+ "+================================================================================+",
				seat_103,
				seat_102,
				seat_101,
				seat_204,
				seat_203,
				seat_202,
				seat_201);

		System.out.println(blockView);
	}
	
	public void showSecondPage() {
		crt_page = 2;
		
		// 예약 가능한 좌석 개수 불러오기.
		String seat_104 = dao.getAvailableSeatNum(104);
		String seat_105 = dao.getAvailableSeatNum(105);
		String seat_106 = dao.getAvailableSeatNum(106);
		String seat_205 = dao.getAvailableSeatNum(205);
		String seat_206 = dao.getAvailableSeatNum(206);
		String seat_207 = dao.getAvailableSeatNum(207);
		String seat_208 = dao.getAvailableSeatNum(208);

		// 출력 view.
		String blockView = String.format("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
				+ "						[경기장 필드 방향]						 \n"
				+ "	(2/4)page\n"
				+ "+============================================================+\n"
				+ "|					|					|					|\n"
				+ "|		106			|		105			|		104			|\n"
				+ "|					|					|					|\n"
				+ "|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|\n"
				+ "|					|					|					|\n"
				+ "+============================================================+==================+\n"
				+ "|					|					|					|					|\n"
				+ "|		208			|		207			|		206			|		205			|\n"
				+ "|					|					|					|					|\n"
				+ "|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|\n"
				+ "|					|					|					|					|\n"
				+ "+================================================================================+",
				seat_106,
				seat_105,
				seat_104,
				seat_208,
				seat_207,
				seat_206,
				seat_205);

		System.out.println(blockView);
	}
	
	public void showThirdPage() {
		crt_page = 3;
		
		// 예약 가능한 좌석 개수 불러오기.
		String seat_117 = dao.getAvailableSeatNum(117);
		String seat_118 = dao.getAvailableSeatNum(118);
		String seat_119 = dao.getAvailableSeatNum(119);
		String seat_219 = dao.getAvailableSeatNum(219);
		String seat_220 = dao.getAvailableSeatNum(220);
		String seat_221 = dao.getAvailableSeatNum(221);
		String seat_222 = dao.getAvailableSeatNum(222);

		// 출력 view.
		String blockView = String.format("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
				+ "						[경기장 필드 방향]						 \n"
				+ "	(3/4)page\n"
				+ "+============================================================+\n"
				+ "|					|					|					|\n"
				+ "|		119			|		118			|		117			|\n"
				+ "|					|					|					|\n"
				+ "|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|\n"
				+ "|					|					|					|\n"
				+ "+============================================================+==================+\n"
				+ "|					|					|					|					|\n"
				+ "|		222			|		221			|		220			|		219			|\n"
				+ "|					|					|					|					|\n"
				+ "|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|\n"
				+ "|					|					|					|					|\n"
				+ "+================================================================================+",
				seat_119,
				seat_118,
				seat_117,
				seat_222,
				seat_221,
				seat_220,
				seat_219);

		System.out.println(blockView);
	}
	
	public void showFourthPage() {
		crt_page = 4;
		
		// 예약 가능한 좌석 개수 불러오기.
		String seat_120 = dao.getAvailableSeatNum(120);
		String seat_121 = dao.getAvailableSeatNum(121);
		String seat_122 = dao.getAvailableSeatNum(122);
		String seat_223 = dao.getAvailableSeatNum(223);
		String seat_224 = dao.getAvailableSeatNum(224);
		String seat_225 = dao.getAvailableSeatNum(225);
		String seat_226 = dao.getAvailableSeatNum(226);

		// 출력 view.
		String blockView = String.format("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
				+ "						[경기장 필드 방향]						 \n"
				+ "	(4/4)page\n"
				+ "+============================================================+\n"
				+ "|					|					|					|\n"
				+ "|		122			|		121			|		120			|\n"
				+ "|					|					|					|\n"
				+ "|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|\n"
				+ "|					|					|					|\n"
				+ "+============================================================+==================+\n"
				+ "|					|					|					|					|\n"
				+ "|		226			|		225			|		224			|		223			|\n"
				+ "|					|					|					|					|\n"
				+ "|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|	예매가능: %s		|\n"
				+ "|					|					|					|					|\n"
				+ "+================================================================================+",
				seat_122,
				seat_121,
				seat_120,
				seat_226,
				seat_225,
				seat_224,
				seat_223);

		System.out.println(blockView);
	}
}