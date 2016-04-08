package app.services;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.commons.CustomComparator;
import app.model.CrackedData;
import app.model.Season;
import app.model.Standings;
import app.model.SumStandings;
import app.repository.CrackedDataRepository;
import app.repository.SeasonRepository;
import app.repository.StandingsRepository;
import app.repository.SumStandingsRepository;

@Service
public class SeasonService {

	@Autowired
	private SeasonRepository seasonRepository;

	@Autowired
	private CrackedDataRepository crackedDataRepository;

	@Autowired
	StandingsRepository standingsRepository;

	@Autowired
	SumStandingsRepository sumStandingsRepository;

	private List<String> eastConference = Arrays.asList("Boston Celtics", "Philadelphia 76ers", "New Jersey Nets",
			"Toronto Raptors", "New York Knicks", "Cleveland Cavaliers", "Chicago Bulls", "Detroit Pistons",
			"Indiana Pacers", "Milwaukee Bucks", "Orlando Magic", "Atlanta Hawks", "Miami Heat", "Charlotte Bobcats",
			"Washington Wizards");

	private List<String> westConference = Arrays.asList("Los Angeles Lakers", "Phoenix Suns", "Golden State Warriors",
			"Los Angeles Clippers", "Sacramento Kings", "San Antonio Spurs", "Houston Rockets", "Dallas Mavericks",
			"New Orleans Hornets", "Memphis Grizzlies", "Denver Nuggets", "Portland Trail Blazers", "Utah Jazz",
			"Minnesota Timberwolves", "Oklahoma City Thunder");

	private List<String> atlanticDivison = Arrays.asList("Boston Celtics", "Philadelphia 76ers", "New Jersey Nets",
			"Toronto Raptors", "New York Knicks");

	private List<String> centralDivison = Arrays.asList("Cleveland Cavaliers", "Chicago Bulls", "Detroit Pistons",
			"Indiana Pacers", "Milwaukee Bucks");

	private List<String> southEastDivison = Arrays.asList("Orlando Magic", "Atlanta Hawks", "Miami Heat",
			"Charlotte Bobcats", "Washington Wizards");

	private List<String> pacificDivison = Arrays.asList("Los Angeles Lakers", "Phoenix Suns", "Golden State Warriors",
			"Los Angeles Clippers", "Sacramento Kings");

	private List<String> southWestDivison = Arrays.asList("San Antonio Spurs", "Houston Rockets", "Dallas Mavericks",
			"New Orleans Hornets", "Memphis Grizzlies");

	private List<String> northWestDivison = Arrays.asList("Denver Nuggets", "Portland Trail Blazers", "Utah Jazz",
			"Minnesota Timberwolves", "Oklahoma City Thunder");

	public List<Season> getAll() {

		List<Season> lista = seasonRepository.findAll();

		Collections.sort(lista, new CustomComparator());

		for (Season ses : lista) {

			CrackedData cr1 = new CrackedData(ses.getDate(), ses.getTeams().get(0).getName(),
					ses.getTeams().get(0).isHome(), ses.getBox().get(0).getTeam().getPts(),
					ses.getTeams().get(0).getWon(), ses.getBox().get(0).getTeam().getFg(),
					ses.getBox().get(0).getTeam().getFga(), ses.getBox().get(0).getTeam().getFg_pct(),
					ses.getBox().get(0).getTeam().getFg3(), ses.getBox().get(0).getTeam().getFg3a(),
					ses.getBox().get(0).getTeam().getFg3_pct(), ses.getBox().get(0).getTeam().getFt(),
					ses.getBox().get(0).getTeam().getFta(), ses.getBox().get(0).getTeam().getFt_pct(),
					ses.getBox().get(0).getTeam().getOrb(), ses.getBox().get(0).getTeam().getDrb(),
					ses.getBox().get(0).getTeam().getTrb(), ses.getBox().get(0).getTeam().getAst(),
					ses.getBox().get(0).getTeam().getStl(), ses.getBox().get(0).getTeam().getBlk(),
					ses.getBox().get(0).getTeam().getTov(), ses.getBox().get(0).getTeam().getPf(),
					ses.getBox().get(0).getTeam().getPts());
			CrackedData cr2 = new CrackedData(ses.getDate(), ses.getTeams().get(1).getName(),
					ses.getTeams().get(1).isHome(), ses.getBox().get(1).getTeam().getPts(),
					ses.getTeams().get(1).getWon(), ses.getBox().get(1).getTeam().getFg(),
					ses.getBox().get(1).getTeam().getFga(), ses.getBox().get(1).getTeam().getFg_pct(),
					ses.getBox().get(1).getTeam().getFg3(), ses.getBox().get(1).getTeam().getFg3a(),
					ses.getBox().get(1).getTeam().getFg3_pct(), ses.getBox().get(1).getTeam().getFt(),
					ses.getBox().get(1).getTeam().getFta(), ses.getBox().get(1).getTeam().getFt_pct(),
					ses.getBox().get(1).getTeam().getOrb(), ses.getBox().get(1).getTeam().getDrb(),
					ses.getBox().get(1).getTeam().getTrb(), ses.getBox().get(1).getTeam().getAst(),
					ses.getBox().get(1).getTeam().getStl(), ses.getBox().get(1).getTeam().getBlk(),
					ses.getBox().get(1).getTeam().getTov(), ses.getBox().get(1).getTeam().getPf(),
					ses.getBox().get(1).getTeam().getPts());

			crackedDataRepository.save(cr1);
			crackedDataRepository.save(cr2);

			// svaki put napravis nove entitete
			Standings s1 = new Standings(cr1.getName());
			Standings s2 = new Standings(cr2.getName());

			// ako postoje sa tim imenom preuzmes ih iz baze
			SumStandings existing1 = sumStandingsRepository.findSumStandingsByName(cr1.getName());
			SumStandings existing2 = sumStandingsRepository.findSumStandingsByName(cr2.getName());

			boolean inDivison = sameDivisons(cr1.getName(), cr2.getName());
			boolean inConference = sameConference(cr1.getName(), cr2.getName());

			s1.setDate(cr1.getDate());
			s2.setDate(cr2.getDate());

			boolean win = firstTeamWon(cr1.getPoints(), cr2.getPoints());


			if (existing1 != null && existing2 != null) {

				addNumberOfPlayedGames(existing1, existing2);
				if (win) {

					
					ifBothInBase(cr1, s1, s2, existing1, existing2, inDivison, inConference);
					calculateForSumStandings(cr1, existing1, existing2, inDivison, inConference);

				} else {

					ifBothInBase(cr2, s2, s1, existing2, existing1, inDivison, inConference);
					calculateForSumStandings(cr2, existing2, existing1, inDivison, inConference);
				}

			}

			if (existing1 == null && existing2 == null) {

				existing1 = new SumStandings(cr1.getName());
				existing2 = new SumStandings(cr2.getName());
				addNumberOfPlayedGames(existing1, existing2);
				

				if (win) {

					ifIsNotInBase(cr1, s1, s2, inDivison, inConference);
					calculateForSumStandings(cr1, existing1, existing2, inDivison, inConference);

				} else {

					ifIsNotInBase(cr2, s2, s1, inDivison, inConference);
					calculateForSumStandings(cr2, existing2, existing1, inDivison, inConference);
				}
			}

			if (existing1 != null && existing2 == null) {

				existing2 = new SumStandings(cr2.getName());
				addNumberOfPlayedGames(existing1, existing2);
				
				if (win) {

					ifFirstInBase(cr1, s1, s2, existing1, inDivison, inConference);
					calculateForSumStandings(cr1, existing1, existing2, inDivison, inConference);
				} else {

					ifFirstInBase(cr2, s2, s1, existing2, inDivison, inConference);
					calculateForSumStandings(cr2, existing2, existing1, inDivison, inConference);
				}

			}

			if (existing1 == null && existing2 != null) {

				existing1 = new SumStandings(cr1.getName());
				addNumberOfPlayedGames(existing1, existing2);
				
				if (win) {

					ifSecondAndInBase(cr1, s1, s2, existing2, inDivison, inConference);
					calculateForSumStandings(cr1, existing1, existing2, inDivison, inConference);

				} else {

					ifSecondAndInBase(cr2, s2, s1, existing1, inDivison, inConference);
					calculateForSumStandings(cr2, existing2, existing1, inDivison, inConference);
				}

			}

			s1.setNumberOfPlayedGames(existing1.getNumberOfPlayedGames());
			s2.setNumberOfPlayedGames(existing2.getNumberOfPlayedGames());

			addToLast10GamesEx(existing1, existing2, win);
			
			double percentigeS1 = ((double) s1.getWon()) / s1.getNumberOfPlayedGames();
			double percentigeS2 = ((double) s2.getWon()) / s2.getNumberOfPlayedGames();
			double percentigeE1 = ((double) existing1.getWon()) / existing1.getNumberOfPlayedGames();
			double percentigeE2 = ((double) existing2.getWon()) / existing2.getNumberOfPlayedGames();

			s1.setPercentige(percentigeS1);
			s2.setPercentige(percentigeS2);
			existing1.setPercentige(percentigeE1);
			existing2.setPercentige(percentigeE2);
			
			countLast10WinAndLoseEx(existing1, existing2);
			
			s1.setLast10Games(existing1.getLast10Games());
			s2.setLast10Games(existing2.getLast10Games());
			
			s1.setLast10Win(existing1.getLast10Win());
			s1.setLast10Lost(existing1.getLast10Lost());
			
			s2.setLast10Win(existing2.getLast10Win());
			s2.setLast10Lost(existing2.getLast10Lost());

			standingsRepository.save(s1);
			standingsRepository.save(s2);

			sumStandingsRepository.save(existing1);
			sumStandingsRepository.save(existing2);
		}

		return lista;
	}

	

	private void addToLast10GamesEx(SumStandings s1, SumStandings s2, boolean win) {
		if (win) {

			if (s1.getLast10Games().size() != 10) {

				LinkedList<Boolean> s1Last10 = (LinkedList<Boolean>) s1.getLast10Games();
				s1Last10.addLast(true);
				s1.setLast10Games(s1Last10);

			} else {

				LinkedList<Boolean> s1Last10 = (LinkedList<Boolean>) s1.getLast10Games();
				s1Last10.addLast(true);
				s1Last10.removeFirst();
				s1.setLast10Games(s1Last10);
			}

			if (s2.getLast10Games().size() != 10) {

				LinkedList<Boolean> s2Last10 = (LinkedList<Boolean>) s2.getLast10Games();
				s2Last10.addLast(false);
				s2.setLast10Games(s2Last10);

			} else {

				LinkedList<Boolean> s2Last10 = (LinkedList<Boolean>) s2.getLast10Games();
				s2Last10.addLast(false);
				s2Last10.removeFirst();
				s2.setLast10Games(s2Last10);
			}

		} else {

			if (s1.getLast10Games().size() != 10) {

				LinkedList<Boolean> s1Last10 = (LinkedList<Boolean>) s1.getLast10Games();
				s1Last10.addLast(false);
				s1.setLast10Games(s1Last10);

			} else {

				LinkedList<Boolean> s1Last10 = (LinkedList<Boolean>) s1.getLast10Games();
				s1Last10.addLast(false);
				s1Last10.removeFirst();
				s1.setLast10Games(s1Last10);
			}

			if (s2.getLast10Games().size() != 10) {

				LinkedList<Boolean> s2Last10 = (LinkedList<Boolean>) s2.getLast10Games();
				s2Last10.addLast(true);
				s2.setLast10Games(s2Last10);

			} else {

				LinkedList<Boolean> s2Last10 = (LinkedList<Boolean>) s2.getLast10Games();
				s2Last10.addLast(true);
				s2Last10.removeFirst();
				s2.setLast10Games(s2Last10);
			}
		}
	}

	private void addNumberOfPlayedGames(SumStandings existing1, SumStandings existing2) {
		existing1.setNumberOfPlayedGames(existing1.getNumberOfPlayedGames() + 1);
		existing2.setNumberOfPlayedGames(existing2.getNumberOfPlayedGames() + 1);
	}

	private void ifIsNotInBase(CrackedData cr1, Standings s1, Standings s2, boolean inDivison, boolean inConference) {

		s1.setWon(s1.getWon() + 1);
		s2.setLost(s2.getLost() + 1);

		if (cr1.isHome()) { // domacin pobedio

			s1.setHomeWin(s1.getHomeWin() + 1);
			s2.setRoadLost(s2.getRoadLost() + 1);

		} else { // ako nije domacin

			s1.setRoadWin(s1.getRoadWin() + 1);
			s2.setHomeLost(s2.getHomeLost() + 1);
		}

		if (inConference) { // konferencija

			s1.setConferenceWin(s1.getConferenceWin() + 1);
			s2.setConferenceLost(s2.getConferenceLost() + 1);
		}

		if (inDivison) { // divizija

			s1.setDivisonWin(s1.getDivisonWin() + 1);
			s2.setDivisonLost(s2.getDivisonLost() + 1);
		}

	}

	private void countLast10WinAndLoseEx(SumStandings s1, SumStandings s2) {
		
		int brPobedaS1 = 0;
		int brPorazaS1 = 0;
		int brPobedaS2 = 0;
		int brPorazaS2 = 0;
		
		for (Boolean pobeda : s1.getLast10Games()) {

			if (pobeda == true) {

				brPobedaS1++;
			} else if( pobeda == false ) {

				brPorazaS1++;
			}
		}

		for (Boolean pobeda : s2.getLast10Games()) {

			if (pobeda) {

				 brPobedaS2++;
			} else if( pobeda == false ){

				brPorazaS2++;
			}
		}
		
		s1.setLast10Win(brPobedaS1);
		s1.setLast10Lost(brPorazaS1);
		
		s2.setLast10Win(brPobedaS2);
		s2.setLast10Lost(brPorazaS2);
		
	}
	
	

	private void calculateForSumStandings(CrackedData cr1, SumStandings s1, SumStandings s2, boolean inDivison,
			boolean inConference) {

		s1.setWon(s1.getWon() + 1);
		s2.setLost(s2.getLost() + 1);

		if (cr1.isHome()) { // domacin pobedio

			s1.setHomeWin(s1.getHomeWin() + 1);
			s2.setRoadLost(s2.getRoadLost() + 1);

		} else { // ako nije domacin

			s1.setRoadWin(s1.getRoadWin() + 1);
			s2.setHomeLost(s2.getHomeLost() + 1);
		}

		if (inConference) { // konferencija

			s1.setConferenceWin(s1.getConferenceWin() + 1);
			s2.setConferenceLost(s2.getConferenceLost() + 1);
		}

		if (inDivison) { // divizija

			s1.setDivisonWin(s1.getDivisonWin() + 1);
			s2.setDivisonLost(s2.getDivisonLost() + 1);
		}

		

	}

	private void ifFirstInBase(CrackedData cr1, Standings s1, Standings s2, SumStandings existed1, boolean inDivison,
			boolean inConference) {

		s1.setWon(existed1.getWon() + 1);
		s1.setLost(existed1.getLost());
		s2.setLost(s2.getLost() + 1);

		if (cr1.isHome()) { // domacin pobedio

			s1.setHomeWin(existed1.getHomeWin() + 1);
			s1.setHomeLost(existed1.getHomeLost());
			s2.setRoadLost(s2.getRoadLost() + 1);

		} else { // ako nije domacin

			s1.setRoadWin(existed1.getRoadWin() + 1);
			s1.setRoadLost(existed1.getRoadLost());
			s2.setHomeLost(s2.getHomeLost() + 1);
		}

		if (inConference) { // konferencija

			s1.setConferenceWin(existed1.getConferenceWin() + 1);
			s1.setConferenceLost(existed1.getConferenceLost());
			s2.setConferenceLost(s2.getConferenceLost() + 1);
		}

		if (inDivison) { // divizija

			s1.setDivisonWin(existed1.getDivisonWin() + 1);
			s1.setDivisonLost(existed1.getDivisonLost());
			s2.setDivisonLost(s2.getDivisonLost() + 1);
		}

		s1.setLast10Win(existed1.getLast10Win());
		s1.setLast10Lost(existed1.getLast10Lost());

	}

	private void ifSecondAndInBase(CrackedData cr1, Standings s1, Standings s2, SumStandings existed2,
			boolean inDivison, boolean inConference) {

		s1.setWon(s1.getWon() + 1);
		s2.setLost(existed2.getLost() + 1);
		s2.setWon(existed2.getWon());

		if (cr1.isHome()) { // domacin pobedio

			s1.setHomeWin(s1.getHomeWin() + 1);
			s2.setRoadLost(existed2.getRoadLost() + 1);
			s2.setRoadWin(existed2.getRoadWin());

		} else { // ako nije domacin

			s1.setRoadWin(s1.getRoadWin() + 1);
			s2.setHomeLost(existed2.getHomeLost() + 1);
			s2.setHomeWin(existed2.getHomeWin());
		}

		if (inConference) { // konferencija

			s1.setConferenceWin(s1.getConferenceWin() + 1);
			s2.setConferenceLost(existed2.getConferenceLost() + 1);
			s2.setConferenceWin(existed2.getConferenceWin());
		}

		if (inDivison) { // divizija

			s1.setDivisonWin(s1.getDivisonWin() + 1);
			s2.setDivisonLost(existed2.getDivisonLost() + 1);
			s2.setDivisonWin(existed2.getDivisonWin());
		}

		s2.setLast10Win(existed2.getLast10Win());
		s2.setLast10Lost(existed2.getLast10Lost());

		if (s1.getLast10Win() + s1.getLast10Lost() == 10) {

			if (s1.getLast10Win() != 10 && s1.getLast10Lost() != 0) {
				s1.setLast10Win(s1.getLast10Win() + 1);
				s1.setLast10Lost(s1.getLast10Lost() - 1);
			}

		} else {

			s1.setLast10Win(s1.getLast10Win() + 1);
		}

		if (existed2.getLast10Win() + existed2.getLast10Lost() == 10) {

			if (existed2.getLast10Win() != 0 && existed2.getLast10Lost() != 10) {
				s2.setLast10Lost(existed2.getLast10Lost() + 1);
				s2.setLast10Win(existed2.getLast10Win() - 1);
			}

		} else {

			s2.setLast10Lost(existed2.getLast10Lost() + 1);
		}

	}

	private void ifBothInBase(CrackedData cr1, Standings s1, Standings s2, SumStandings existed1, SumStandings existed2,
			boolean inDivison, boolean inConference) {

		s1.setWon(existed1.getWon() + 1);
		s2.setLost(existed2.getLost() + 1);

		s2.setWon(existed2.getWon());
		s1.setLost(existed1.getLost());

		if (cr1.isHome()) { // domacin pobedio

			s1.setHomeWin(existed1.getHomeWin() + 1);
			s2.setRoadLost(existed2.getRoadLost() + 1);

			s2.setHomeWin(existed2.getHomeWin());
			s1.setRoadLost(existed1.getRoadLost());

		} else { // ako nije domacin

			s1.setRoadWin(existed1.getRoadWin() + 1);
			s2.setHomeLost(existed2.getHomeLost() + 1);

			s2.setRoadWin(existed2.getRoadWin());
			s1.setHomeLost(existed1.getHomeLost());
		}

		if (inConference) { // konferencija

			s1.setConferenceWin(existed1.getConferenceWin() + 1);
			s2.setConferenceLost(existed2.getConferenceLost() + 1);

			s2.setConferenceWin(existed2.getConferenceWin());
			s1.setConferenceLost(existed1.getConferenceLost());
		}

		if (inDivison) { // divizija

			s1.setDivisonWin(existed1.getDivisonWin() + 1);
			s2.setDivisonLost(existed2.getDivisonLost() + 1);

			s2.setDivisonWin(existed2.getDivisonWin());
			s1.setDivisonLost(existed1.getDivisonLost());
		}

		s1.setLast10Win(existed1.getLast10Win());
		s1.setLast10Lost(existed1.getLast10Lost());

		s2.setLast10Win(existed2.getLast10Win());
		s2.setLast10Lost(existed2.getLast10Lost());

	}

	public boolean sameConference(String teamName1, String teamName2) {

		if ((eastConference.contains(teamName1) && eastConference.contains(teamName2))
				|| (westConference.contains(teamName1) && westConference.contains(teamName2))) {

			return true;
		} else {

			return false;
		}

	}

	public boolean sameDivisons(String teamName1, String teamName2) {

		return ((atlanticDivison.contains(teamName1) && atlanticDivison.contains(teamName2))
				|| (centralDivison.contains(teamName1) && centralDivison.contains(teamName2))
				|| (southEastDivison.contains(teamName1) && southEastDivison.contains(teamName2))
				|| (pacificDivison.contains(teamName1) && pacificDivison.contains(teamName2))
				|| (southWestDivison.contains(teamName1) && southWestDivison.contains(teamName2))
				|| (northWestDivison.contains(teamName1) && northWestDivison.contains(teamName2)))

						? true : false;

	}

	public boolean firstTeamWon(int score1, int score2) {

		return (score1 > score2) ? true : false;

	}

}
