package app.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;

public class Box {

	@Id
	private String id;
	private Team team;

	public Box() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Box(String id, Team team) {
		super();
		this.id = id;
		this.team = team;
	}


	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	
}
