package com.baseballtonight.dao.reservation;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.baseballtonight.dao.DAO;
import com.baseballtonight.service.reservation.ReserveService;
import com.baseballtonight.util.console.Coloring;

public class BlockViewDAO {
	static DAO dao = new DAO();
	
	
	
	public String getAvailableSeatNum(int block_num) {
		try {
			String loadAvailableSeatNum_sql = String.format(""
				+ "SELECT COUNT(*) AS availableSeat_num "
				+ "FROM seats "
				+ "WHERE game_id = %d AND seat_block = %d AND status = 0;", ReserveService.game_id, block_num);
			ResultSet rs =  dao.select(loadAvailableSeatNum_sql);
			rs.next();
			
			
			// 예매 가능한 좌석이 0석이라면 "n석" 대신 "매진" return.
			if(rs.getInt(1) != 0){
				return Coloring.getGreen(String.valueOf(rs.getInt(1))) + "석";				
			} else {
				return Coloring.getRed("매진");
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
