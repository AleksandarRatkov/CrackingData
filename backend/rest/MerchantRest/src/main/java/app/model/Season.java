package app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Season implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	private ArrayList<Box> box;
	
	private Date date;
	
	private ArrayList<Teams> teams;

	public Season() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Season(String id, ArrayList<Box> box, Date date, ArrayList<Teams> teams) {
		super();
		this.id = id;
		this.box = box;
		this.date = date;
		this.teams = teams;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Box> getBox() {
		return box;
	}

	public void setBox(ArrayList<Box> box) {
		this.box = box;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ArrayList<Teams> getTeams() {
		return teams;
	}

	public void setTeams(ArrayList<Teams> teams) {
		this.teams = teams;
	}
	
	
}
