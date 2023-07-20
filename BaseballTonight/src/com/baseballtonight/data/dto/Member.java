package com.baseballtonight.data.dto;

import com.baseballtonight.data.Team;

public class Member { // getter로 가져다쓰면 됩니다.
	
	private static String id;
	private static String mem_password;
	private static Team prf_team;
	
	public static void setAll(String mem_id, String mem_password, int prf_team_num){
		Member.id = mem_id;
		Member.mem_password = mem_password;
		Member.prf_team = Team.getTeamByTeamNum(prf_team_num);
	}
	public static String getMem_id() {
		return id;
	}
	public static void setMem_id(String mem_id) {
		 Member.id = mem_id;
	}
	public static String getMem_password() {
		return mem_password;
	}
	public static void setMem_password(String mem_password) {
		Member.mem_password = mem_password;
	}
	public static Team getPrf_team() {
		return prf_team;
	}
	public static void setPrf_team(Team prf_team) {
		Member.prf_team = prf_team;
	} 
	@Override
	public String toString() {
		return "Member [mem_id=" + id + ", mem_password=" + mem_password + ", prf_team=" + prf_team
			+ "]";
	}
}
