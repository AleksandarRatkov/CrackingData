package app.model;

import org.springframework.data.annotation.Id;

public class Teams {

	@Id
	private String id;
	
	private String name;
	private String abbreviation ;
	private int score ;
	private boolean home ;
	private int won ;
	public Teams() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teams(String name, String abbreviation, int score, boolean home, int won) {
		super();
		this.name = name;
		this.abbreviation = abbreviation;
		this.score = score;
		this.home = home;
		this.won = won;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public boolean isHome() {
		return home;
	}
	public void setHome(boolean home) {
		this.home = home;
	}
	public int getWon() {
		return won;
	}
	public void setWon(int won) {
		this.won = won;
	}
	
	
}
