package app.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.model.Insurance;
import app.model.Season;
import app.model.transferData.JmbgResponse;
import app.services.InsuranceService;
import app.services.SeasonService;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {

	@Autowired
	private InsuranceService insuranceService;
	
	@Autowired
	private SeasonService seasonService;

	@RequestMapping(method = RequestMethod.POST)
	@CrossOrigin

	public Map<String, Object> createInsurance(@Validated @RequestBody Insurance insurance) {	
		return insuranceService.create(insurance);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{userId}")
	public Insurance getInsuranceById(@PathVariable("userId") String insId) {

		return insuranceService.findById(insId);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Insurance> getAll() {

		return (List<Insurance>) insuranceService.findAll();
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "games")
	@ResponseBody
	public List<Season> getAllGames() {

		return (List<Season>) seasonService.getAll();
	}
	
	

	@RequestMapping(method = RequestMethod.DELETE, value = "/{insuranceId}")
	public String removeInsurance(@PathVariable("insuranceId") String insId) {

		return insuranceService.remove(insId);

	}

	@RequestMapping(method = RequestMethod.PUT)
	public Map<String, Object> editInsurance(@Validated @RequestBody  Insurance insurance) {	
		
		return insuranceService.edit(insurance);
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/jmbg/{jmbg}")
	public JmbgResponse validateJmbg(@PathVariable("jmbg") String jmbg) {
		JmbgResponse response = new JmbgResponse();
		response.setResult(insuranceService.checkJmbg(jmbg, true));
		return response;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/calculate")
	public Insurance calculatePrice(@RequestBody Insurance insurance) {

		return insuranceService.calculateInsurance(insurance);
	}

}
