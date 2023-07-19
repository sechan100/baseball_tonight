package com.baseballtonight.data.dto;

import com.baseballtonight.data.Team;

public class MemberDTO {
	private String mem_id;
	private String mem_password;
	private Team prf_team;
	
	
	public MemberDTO(String mem_id, String mem_password, int prf_team_num) {
		this.mem_id = mem_id;
		this.mem_password = mem_password;
		this.prf_team = Team.getTeamByTeamNum(prf_team_num);
	}
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_password() {
		return mem_password;
	}
	public void setMem_password(String mem_password) {
		this.mem_password = mem_password;
	}
	public Team getPrf_team() {
		return prf_team;
	}
	public void setPrf_team(Team prf_team) {
		this.prf_team = prf_team;
	} 
	@Override
	public String toString() {
		return "Member [mem_id=" + mem_id + ", mem_password=" + mem_password + ", prf_team=" + prf_team
			+ "]";
	}
}
