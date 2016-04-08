package app.model;

import java.util.Date;
import java.util.LinkedList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Standings {

	@Id
	private String id;

	private String name;
	private Date date;
	private int numberOfPlayedGames;
	private int won;
	private int lost;
	private double percentige;
	private int homeWin;
	private int homeLost;
	private int roadWin;
	private int roadLost;
	private int divisonWin;
	private int divisonLost;
	private int conferenceWin;
	private int conferenceLost;
	private int last10Win;
	private int last10Lost;
	private LinkedList<Boolean> last10Games = new LinkedList<>();

	public Standings() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Standings(String name, Date date, int numberOfPlayedGames, int won, int lost, double percentige, int homeWin,
			int homeLost, int roadWin, int roadLost, int divisonWin, int divisonLost, int conferenceWin,
			int conferenceLost, int last10Win, int last10Lost, LinkedList<Boolean> last10Games) {
		super();
		this.name = name;
		this.date = date;
		this.numberOfPlayedGames = numberOfPlayedGames;
		this.won = won;
		this.lost = lost;
		this.percentige = percentige;
		this.homeWin = homeWin;
		this.homeLost = homeLost;
		this.roadWin = roadWin;
		this.roadLost = roadLost;
		this.divisonWin = divisonWin;
		this.divisonLost = divisonLost;
		this.conferenceWin = conferenceWin;
		this.conferenceLost = conferenceLost;
		this.last10Win = last10Win;
		this.last10Lost = last10Lost;
		this.last10Games = last10Games;
	}

	public Standings(String id, String name, Date date, int numberOfPlayedGames, int won, int lost, double percentige,
			int homeWin, int homeLost, int roadWin, int roadLost, int divisonWin, int divisonLost, int conferenceWin,
			int conferenceLost, int last10Win, int last10Lost, LinkedList<Boolean> last10Games) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.numberOfPlayedGames = numberOfPlayedGames;
		this.won = won;
		this.lost = lost;
		this.percentige = percentige;
		this.homeWin = homeWin;
		this.homeLost = homeLost;
		this.roadWin = roadWin;
		this.roadLost = roadLost;
		this.divisonWin = divisonWin;
		this.divisonLost = divisonLost;
		this.conferenceWin = conferenceWin;
		this.conferenceLost = conferenceLost;
		this.last10Win = last10Win;
		this.last10Lost = last10Lost;
		this.last10Games = last10Games;
	}

	public Standings(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getWon() {
		return won;
	}

	public void setWon(int won) {
		this.won = won;
	}

	public int getLost() {
		return lost;
	}

	public int getNumberOfPlayedGames() {
		return numberOfPlayedGames;
	}

	public void setNumberOfPlayedGames(int numberOfPlayedGames) {
		this.numberOfPlayedGames = numberOfPlayedGames;
	}

	public void setLost(int lost) {
		this.lost = lost;
	}

	public double getPercentige() {
		return percentige;
	}

	public void setPercentige(double percentige) {
		this.percentige = percentige;
	}

	public int getHomeWin() {
		return homeWin;
	}

	public void setHomeWin(int homeWin) {
		this.homeWin = homeWin;
	}

	public int getHomeLost() {
		return homeLost;
	}

	public void setHomeLost(int homeLost) {
		this.homeLost = homeLost;
	}

	public int getRoadWin() {
		return roadWin;
	}

	public void setRoadWin(int roadWin) {
		this.roadWin = roadWin;
	}

	public int getRoadLost() {
		return roadLost;
	}

	public void setRoadLost(int roadLost) {
		this.roadLost = roadLost;
	}

	public int getDivisonWin() {
		return divisonWin;
	}

	public void setDivisonWin(int divisonWin) {
		this.divisonWin = divisonWin;
	}

	public int getDivisonLost() {
		return divisonLost;
	}

	public void setDivisonLost(int divisonLost) {
		this.divisonLost = divisonLost;
	}

	public int getConferenceWin() {
		return conferenceWin;
	}

	public void setConferenceWin(int conferenceWin) {
		this.conferenceWin = conferenceWin;
	}

	public int getConferenceLost() {
		return conferenceLost;
	}

	public void setConferenceLost(int conferenceLost) {
		this.conferenceLost = conferenceLost;
	}

	public int getLast10Win() {
		return last10Win;
	}

	public void setLast10Win(int last10Win) {
		this.last10Win = last10Win;
	}

	public LinkedList<Boolean> getLast10Games() {
		return last10Games;
	}

	public void setLast10Games(LinkedList<Boolean> last10Games) {
		this.last10Games = last10Games;
	}

	public int getLast10Lost() {
		return last10Lost;
	}

	public void setLast10Lost(int last10Lost) {
		this.last10Lost = last10Lost;
	}

}
