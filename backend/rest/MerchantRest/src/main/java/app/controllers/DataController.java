package app.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.model.Season;
import app.model.Teams;
import app.repository.SeasonRepository;


@RestController
@RequestMapping("/getData")
public class DataController {
	
	private SeasonRepository seasonRepo;
	

	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public @ResponseBody List<Season> getAll() {

		List<Season> lista = seasonRepo.findAll();
		for (Season ses : lista) {
			
			System.out.println("**************************************");
			System.out.println("Datum je " + ses.getDate());
			for (Teams t : ses.getTeams()) {
				System.out.println();
				System.out.println("Tim : " + t.getName());
			}
			System.out.println("**************************************");
		}
		
		return lista;
	}
}
