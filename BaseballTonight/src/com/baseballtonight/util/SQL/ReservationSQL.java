package com.baseballtonight.statics.SQL;

import com.baseballtonight.data.dto.Member;

public class ReservationSQL {
	public static String select_preferred_games_SQL = String.format(
		"SELECT id, name, stadium, dateAndTime, premium, `table`, blue, red, navy, green, DAYOFWEEK(dateAndTime) As part, opponent_club_num, home_club_num FROM games WHERE name LIKE '%%%s%%' ORDER BY dateAndTime ASC",
		Member.getPrf_team().name);
	public static String select_all_games_SQL = "SELECT id, name, stadium, dateAndTime, premium, `table`, blue, red, navy, green, DAYOFWEEK(dateAndTime) As part, opponent_club_num, home_club_num FROM games ORDER BY dateAndTime ASC";
}
