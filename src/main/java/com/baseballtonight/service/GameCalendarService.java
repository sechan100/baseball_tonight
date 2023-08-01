package com.baseballtonight.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.baseballtonight.dao.DAO;
import com.baseballtonight.dto.Member;
import com.baseballtonight.util.Coloring;

public class GameCalendarService {
		public String[] home_game = new String[11];
		public String[] away_game = new String[11];
		public HashMap<Integer, String> day_schedule_club = new HashMap<>();
		public HashMap<Integer, String> day_schedule_time = new HashMap<>();
		
		GameCalendarService(){
			home_game[0] = ("         ");
			home_game[1] = Coloring.getCyanBack(Coloring.getBlack("   SSG   "));
			home_game[2] = Coloring.getCyanBack(Coloring.getBlack(" KIWOOM  "));
			home_game[3] = Coloring.getCyanBack(Coloring.getBlack("   LG    "));
			home_game[4] = Coloring.getCyanBack(Coloring.getBlack("   KT    "));
			home_game[5] = Coloring.getCyanBack(Coloring.getBlack("   KIA   "));
			home_game[6] = Coloring.getCyanBack(Coloring.getBlack("   NC    "));
			home_game[7] = Coloring.getCyanBack(Coloring.getBlack(" SAMSUNG "));
			home_game[8] = Coloring.getCyanBack(Coloring.getBlack("  LOTTE  "));
			home_game[9] = Coloring.getCyanBack(Coloring.getBlack(" DOOSAN  "));
			home_game[10] = Coloring.getCyanBack(Coloring.getBlack(" HANWHA  "));
			///////////
			away_game[0] = ("         ");
			away_game[1] = ("   SSG   ");
			away_game[2] = (" KIWOOM  ");
			away_game[3] = ("   LG    ");
			away_game[4] = ("   KT    ");
			away_game[5] = ("   KIA   ");
			away_game[6] = ("   NC    ");
			away_game[7] = (" SAMSUNG ");
			away_game[8] = ("  LOTTE  ");
			away_game[9] = (" DOOSAN  ");
			away_game[10] = (" HANWHA  ");
			
			for(int i = 1; i<32; i++){
				day_schedule_club.put(i, away_game[0]);
				day_schedule_time.put(i, away_game[0]);
			}
		}

		public HashMap<Integer, Integer> showCalendar(GameCalendarService gameCalendar) {
			GameCalendarDAO dao = new GameCalendarDAO();
			HashMap<Integer, Integer> game_id_map = dao.loadSchedule(gameCalendar);
			
			String calendar = String.format(""
				+ "=====================================================================\n"
				+ "   SUN   |   MON   |   TUE   |   WED   |   THU   |   FRI   |   SAT\n"
				+ "---------------------------------------------------------------------\n"
				+ "         |         |  1      |  2      |  3      |  4      |  5    \n"
				+ "         |         |%s|%s|%s|%s|%s\n"
				+ "         |         |%s|%s|%s|%s|%s\n"
				+ "---------------------------------------------------------------------\n"
				+ "  6      |  7      |  8      |  9      |  10     |  11     |  12   \n"
				+ "%s|%s|%s|%s|%s|%s|%s\n"
				+ "%s|%s|%s|%s|%s|%s|%s\n"
				+ "---------------------------------------------------------------------\n"
				+ "  13     |  14     |  15     |  16     |  17     |  18     |  19   \n"
				+ "%s|%s|%s|%s|%s|%s|%s\n"
				+ "%s|%s|%s|%s|%s|%s|%s\n"
				+ "---------------------------------------------------------------------\n"
				+ "  20     |  21     |  22     |  23     |  24     |  25     |  26   \n"
				+ "%s|%s|%s|%s|%s|%s|%s\n"
				+ "%s|%s|%s|%s|%s|%s|%s\n"
				+ "---------------------------------------------------------------------\n"
				+ "  27     |  28     |  29     |  30     |  31     |         |       \n"
				+ "%s|%s|%s|%s|%s|         |         \n"
				+ "%s|%s|%s|%s|%s|         |         \n",
				day_schedule_club.get(1), 
				day_schedule_club.get(2),
				day_schedule_club.get(3),
				day_schedule_club.get(4),
				day_schedule_club.get(5),
				
				day_schedule_time.get(1),
				day_schedule_time.get(2),
				day_schedule_time.get(3),
				day_schedule_time.get(4),
				day_schedule_time.get(5),
				
				day_schedule_club.get(6),
				day_schedule_club.get(7),
				day_schedule_club.get(8),
				day_schedule_club.get(9),
				day_schedule_club.get(10),
				day_schedule_club.get(11),
				day_schedule_club.get(12),

				day_schedule_time.get(6),
				day_schedule_time.get(7),
				day_schedule_time.get(8),
				day_schedule_time.get(9),
				day_schedule_time.get(10),
				day_schedule_time.get(11),
				day_schedule_time.get(12),
				
				day_schedule_club.get(13),
				day_schedule_club.get(14),
				day_schedule_club.get(15),
				day_schedule_club.get(16),
				day_schedule_club.get(17),
				day_schedule_club.get(18),
				day_schedule_club.get(19),
				
				day_schedule_time.get(13),
				day_schedule_time.get(14),
				day_schedule_time.get(15),
				day_schedule_time.get(16),
				day_schedule_time.get(17),
				day_schedule_time.get(18),
				day_schedule_time.get(19),

				
				day_schedule_club.get(20),
				day_schedule_club.get(21),
				day_schedule_club.get(22),
				day_schedule_club.get(23),
				day_schedule_club.get(24),
				day_schedule_club.get(25),
				day_schedule_club.get(26),
				
				day_schedule_time.get(20),
				day_schedule_time.get(21),
				day_schedule_time.get(22),
				day_schedule_time.get(23),
				day_schedule_time.get(24),
				day_schedule_time.get(25),
				day_schedule_time.get(26),
				
				
				day_schedule_club.get(27),
				day_schedule_club.get(28),
				day_schedule_club.get(29),
				day_schedule_club.get(30),
				day_schedule_club.get(31),
				
				day_schedule_time.get(27),
				day_schedule_time.get(28),
				day_schedule_time.get(29),
				day_schedule_time.get(30),
				day_schedule_time.get(31)
				);
			System.out.println(calendar);
			return game_id_map;
		}
}

class GameCalendarDAO {
	DAO dao = new DAO();
	
	public HashMap<Integer, Integer> loadSchedule(GameCalendarService gameCalendar) {
		try {
			HashMap<Integer, Integer> game_id_map = new HashMap<>();
			
			String select_preferred_games_SQL = String.format(
				"SELECT id, "
				+ "name, "
				+ "stadium, "
				+ "dateAndTime, "
				+ "DAYOFWEEK(dateAndTime) As part, " 
				+ "opponent_club_num, "  
				+ "home_club_num " 
				+ "FROM games "
				+ "WHERE name "
				+ "LIKE '%%%s%%' "
				+ "ORDER BY dateAndTime ASC",
				Member.getPrfTeam().name);
			
			ResultSet rs = dao.select(select_preferred_games_SQL);
			
			while(rs.next()){
				String time = rs.getString(4).substring(11, 16).replace(":", "시 ") + "분";
				int day = Integer.parseInt((rs.getString(4).substring(8, 9).equals("0") ? rs.getString(4).substring(9, 10) : rs.getString(4).substring(8, 10)));
				
				// 홈 경기인 경우, 100을 더해서 홈 경기임을 표시.
				int opponent_club_num = (rs.getInt(6) == Member.getPrfTeam().num ? rs.getInt(7) : rs.getInt(6) + 100);
				
				// 홈 경기인 경우.
				if(opponent_club_num > 100){
					opponent_club_num -= 100;
					gameCalendar.day_schedule_club.put(day, gameCalendar.home_game[opponent_club_num]);
					gameCalendar.day_schedule_time.put(day, time);
				
				// 어웨이 경기인 경우.
				} else {
					gameCalendar.day_schedule_club.put(day, gameCalendar.away_game[opponent_club_num]);
					gameCalendar.day_schedule_time.put(day, time);
				}
				game_id_map.put(day, rs.getInt(1));
			}
			return game_id_map;
		} catch(SQLException e) {
			System.out.println(e);
		}
		return null;
	}
}





