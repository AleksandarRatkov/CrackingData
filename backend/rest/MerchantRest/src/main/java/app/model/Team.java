package app.model;

import org.springframework.data.annotation.Id;

public class Team {

	@Id
	private String id;
	
	private int fg;
	private int fga ;
	private double fg_pct ;
	private int fg3 ;
	private int fg3a ;
	private double fg3_pct ;
	private int ft ;
	private int fta ;
	private double ft_pct ;
	private int orb ;
	private int drb ;
	private int trb ;
	private int ast ;
	private int stl ;
	private int  blk ;
	private int tov ;
	private int  pf ;
	private int pts ;
	
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Team(int fg, int fga, double fg_pct, int fg3, int fg3a, double fg3_pct, int ft, int fta, double fta_pct,
			int orb, int drb, int trb, int ast, int stl, int blk, int tov, int pf, int pts) {
		super();
		this.fg = fg;
		this.fga = fga;
		this.fg_pct = fg_pct;
		this.fg3 = fg3;
		this.fg3a = fg3a;
		this.fg3_pct = fg3_pct;
		this.ft = ft;
		this.fta = fta;
		this.ft_pct = fta_pct;
		this.orb = orb;
		this.drb = drb;
		this.trb = trb;
		this.ast = ast;
		this.stl = stl;
		this.blk = blk;
		this.tov = tov;
		this.pf = pf;
		this.pts = pts;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getFg() {
		return fg;
	}

	public void setFg(int fg) {
		this.fg = fg;
	}

	public int getFga() {
		return fga;
	}

	public void setFga(int fga) {
		this.fga = fga;
	}

	public double getFg_pct() {
		return fg_pct;
	}

	public void setFg_pct(double fg_pct) {
		this.fg_pct = fg_pct;
	}

	public int getFg3() {
		return fg3;
	}

	public void setFg3(int fg3) {
		this.fg3 = fg3;
	}

	public int getFg3a() {
		return fg3a;
	}

	public void setFg3a(int fg3a) {
		this.fg3a = fg3a;
	}

	public double getFg3_pct() {
		return fg3_pct;
	}

	public void setFg3_pct(double fg3_pct) {
		this.fg3_pct = fg3_pct;
	}

	public int getFt() {
		return ft;
	}

	public void setFt(int ft) {
		this.ft = ft;
	}

	public int getFta() {
		return fta;
	}

	public void setFta(int fta) {
		this.fta = fta;
	}

	public double getFt_pct() {
		return ft_pct;
	}

	public void setFt_pct(double fta_pct) {
		this.ft_pct = fta_pct;
	}

	public int getOrb() {
		return orb;
	}

	public void setOrb(int orb) {
		this.orb = orb;
	}

	public int getDrb() {
		return drb;
	}

	public void setDrb(int drb) {
		this.drb = drb;
	}

	public int getTrb() {
		return trb;
	}

	public void setTrb(int trb) {
		this.trb = trb;
	}

	public int getAst() {
		return ast;
	}

	public void setAst(int ast) {
		this.ast = ast;
	}

	public int getStl() {
		return stl;
	}

	public void setStl(int stl) {
		this.stl = stl;
	}

	public int getBlk() {
		return blk;
	}

	public void setBlk(int blk) {
		this.blk = blk;
	}

	public int getTov() {
		return tov;
	}

	public void setTov(int tov) {
		this.tov = tov;
	}

	public int getPf() {
		return pf;
	}

	public void setPf(int pf) {
		this.pf = pf;
	}

	public int getPts() {
		return pts;
	}

	public void setPts(int pts) {
		this.pts = pts;
	}
	
	
	
}
