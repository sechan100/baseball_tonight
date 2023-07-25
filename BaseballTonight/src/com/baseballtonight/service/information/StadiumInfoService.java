package com.baseballtonight.service.information;

import com.baseballtonight.dao.information.StadiumInfoDAO;
import com.baseballtonight.dto.Team;
import com.baseballtonight.util.Coloring;


public class StadiumInfoService {
    private static StadiumInfoDAO dao;
    
    // StadiumInfoDAO 객체를 생성하고, 파라미터로 출력할 팀 id 번호를 넣어줌.
    public static void setShowTargetTeam(Team team) {
    	 try {
			dao = new StadiumInfoDAO(team.num);
			StadiumInfoService.showStadiumBasicInfo();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    
    // 경기장 기본 정보(이름, 주소 출력)
    public static void showStadiumBasicInfo() {
        String name = dao.getParkName();
        String address = dao.getParkAddress();
        Coloring.yellowOut("<" + name + ">");
        System.out.println("----------------------------");
        System.out.println("주소: " + address);
        System.out.println("----------------------------");
    }

    public static void showParkFood() {
        String food = dao.getParkFood();
        System.out.println("< 식음료 정보 >");
        System.out.println(food);
    }

    public static void showParkBus() {
        String busstop = dao.getParkBusstop();
        String bus = dao.getParkBus();
        System.out.println("<버스정류장>");
        System.out.println(busstop);
        System.out.println("<버스>");
        System.out.println(bus);
    }

    public static void showParkSub() {
    	String sub = dao.getParkSub();
        System.out.println("< 지하철 정보 >");
        System.out.println(sub);
    }

    public static void showParkParking() {
    	String parking = dao.getParkParking();
        System.out.println("< 주차장 정보 >");
        System.out.println(parking);
    }




}
