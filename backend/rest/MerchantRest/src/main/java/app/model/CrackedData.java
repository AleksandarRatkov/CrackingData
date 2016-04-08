package app.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CrackedData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private Date date;

	private String name;
	private boolean home;
	private int score;
	private int won;
	private int fieldGoalMade;
	private int fieldGoalAtemp;
	private double fieldGoalPercentage;
	private int threePointMade;
	private int threePointAtemp;
	private double threePointPercentage;
	private int freeThrowMade;
	private int freeThrowAtemp;
	private double freeThrowPercentage;
	private int ofensiveRebounds;
	private int defensiveRebounds;
	private int totalRebounds;
	private int asists;
	private int steals;
	private int blocks;
	private int turnovers;
	private int personalFouls;
	private int points;

	public CrackedData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CrackedData(Date date, String name, boolean home, int score, int won, int fieldGoalMade,
			int fieldGoalAtemp, double fieldGoalPercentage, int threePointMade, int threePointAtemp,
			double threePointPercentage, int freeThrowMade, int freeThrowAtemp, double freeThrowPercentage,
			int ofensiveRebounds, int defensiveRebounds, int totalRebounds, int asists, int steals, int blocks,
			int turnovers, int personalFouls, int points) {
		super();
		this.date = date;
		this.name = name;
		this.home = home;
		this.score = score;
		this.won = won;
		this.fieldGoalMade = fieldGoalMade;
		this.fieldGoalAtemp = fieldGoalAtemp;
		this.fieldGoalPercentage = fieldGoalPercentage;
		this.threePointMade = threePointMade;
		this.threePointAtemp = threePointAtemp;
		this.threePointPercentage = threePointPercentage;
		this.freeThrowMade = freeThrowMade;
		this.freeThrowAtemp = freeThrowAtemp;
		this.freeThrowPercentage = freeThrowPercentage;
		this.ofensiveRebounds = ofensiveRebounds;
		this.defensiveRebounds = defensiveRebounds;
		this.totalRebounds = totalRebounds;
		this.asists = asists;
		this.steals = steals;
		this.blocks = blocks;
		this.turnovers = turnovers;
		this.personalFouls = personalFouls;
		this.points = points;
	}

	public CrackedData(String id, Date date, String name, boolean home, int score, int won, int fieldGoalMade,
			int fieldGoalAtemp, double fieldGoalPercentage, int threePointMade, int threePointAtemp,
			double threePointPercentage, int freeThrowMade, int freeThrowAtemp, double freeThrowPercentage,
			int ofensiveRebounds, int defensiveRebounds, int totalRebounds, int asists, int steals, int blocks,
			int turnovers, int personalFouls, int points) {
		super();
		this.id = id;
		this.date = date;
		this.name = name;
		this.home = home;
		this.score = score;
		this.won = won;
		this.fieldGoalMade = fieldGoalMade;
		this.fieldGoalAtemp = fieldGoalAtemp;
		this.fieldGoalPercentage = fieldGoalPercentage;
		this.threePointMade = threePointMade;
		this.threePointAtemp = threePointAtemp;
		this.threePointPercentage = threePointPercentage;
		this.freeThrowMade = freeThrowMade;
		this.freeThrowAtemp = freeThrowAtemp;
		this.freeThrowPercentage = freeThrowPercentage;
		this.ofensiveRebounds = ofensiveRebounds;
		this.defensiveRebounds = defensiveRebounds;
		this.totalRebounds = totalRebounds;
		this.asists = asists;
		this.steals = steals;
		this.blocks = blocks;
		this.turnovers = turnovers;
		this.personalFouls = personalFouls;
		this.points = points;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isHome() {
		return home;
	}

	public void setHome(boolean home) {
		this.home = home;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int isWon() {
		return won;
	}

	public void setWon(int won) {
		this.won = won;
	}

	public int getFieldGoalMade() {
		return fieldGoalMade;
	}

	public void setFieldGoalMade(int fieldGoalMade) {
		this.fieldGoalMade = fieldGoalMade;
	}

	public int getFieldGoalAtemp() {
		return fieldGoalAtemp;
	}

	public void setFieldGoalAtemp(int fieldGoalAtemp) {
		this.fieldGoalAtemp = fieldGoalAtemp;
	}

	public double getFieldGoalPercentage() {
		return fieldGoalPercentage;
	}

	public void setFieldGoalPercentage(double fieldGoalPercentage) {
		this.fieldGoalPercentage = fieldGoalPercentage;
	}

	public int getThreePointMade() {
		return threePointMade;
	}

	public void setThreePointMade(int threePointMade) {
		this.threePointMade = threePointMade;
	}

	public int getThreePointAtemp() {
		return threePointAtemp;
	}

	public void setThreePointAtemp(int threePointAtemp) {
		this.threePointAtemp = threePointAtemp;
	}

	public double getThreePointPercentage() {
		return threePointPercentage;
	}

	public void setThreePointPercentage(double threePointPercentage) {
		this.threePointPercentage = threePointPercentage;
	}

	public int getFreeThrowMade() {
		return freeThrowMade;
	}

	public void setFreeThrowMade(int freeThrowMade) {
		this.freeThrowMade = freeThrowMade;
	}

	public int getFreeThrowAtemp() {
		return freeThrowAtemp;
	}

	public void setFreeThrowAtemp(int freeThrowAtemp) {
		this.freeThrowAtemp = freeThrowAtemp;
	}

	public double getFreeThrowPercentage() {
		return freeThrowPercentage;
	}

	public void setFreeThrowPercentage(double freeThrowPercentage) {
		this.freeThrowPercentage = freeThrowPercentage;
	}

	public int getOfensiveRebounds() {
		return ofensiveRebounds;
	}

	public void setOfensiveRebounds(int ofensiveRebounds) {
		this.ofensiveRebounds = ofensiveRebounds;
	}

	public int getDefensiveRebounds() {
		return defensiveRebounds;
	}

	public void setDefensiveRebounds(int defensiveRebounds) {
		this.defensiveRebounds = defensiveRebounds;
	}

	public int getTotalRebounds() {
		return totalRebounds;
	}

	public void setTotalRebounds(int totalRebounds) {
		this.totalRebounds = totalRebounds;
	}

	public int getAsists() {
		return asists;
	}

	public void setAsists(int asists) {
		this.asists = asists;
	}

	public int getSteals() {
		return steals;
	}

	public void setSteals(int steals) {
		this.steals = steals;
	}

	public int getBlocks() {
		return blocks;
	}

	public void setBlocks(int blocks) {
		this.blocks = blocks;
	}

	public int getTurnovers() {
		return turnovers;
	}

	public void setTurnovers(int turnovers) {
		this.turnovers = turnovers;
	}

	public int getPersonalFouls() {
		return personalFouls;
	}

	public void setPersonalFouls(int personalFouls) {
		this.personalFouls = personalFouls;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

}
