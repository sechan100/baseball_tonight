package com.baseballtonight.service;

import java.io.IOException;
import java.sql.SQLException;

import com.baseballtonight.dao.CancelDAO;

public class CancelServer {

	public static void serverRun() throws IOException {
		CancelDAO dao = new CancelDAO();
		try {
			dao.cancelReservation();
			
		} catch(SQLException e) {
			
			e.getMessage();
			
		} catch(Exception e) {
			
			e.getMessage();
			
		}
	}
}

