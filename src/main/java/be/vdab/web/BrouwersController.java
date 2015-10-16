package be.vdab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.services.BrouwerService;
import be.vdab.valueobjects.DeelVanNaam;

@Controller
@RequestMapping("/brouwers")
class BrouwersController {

	private static final String BROUWERS_VIEW = "brouwers/brouwers";
	private static final String BROUWERS_OP_NAAM_VIEW = "brouwers/opnaam";
	private static final String BROUWERS_TOEVOEGEN_VIEW = "brouwers/toevoegen";
	private static final String BROUWERS_ALFABETISCH = "brouwers/beginnaam";
	
	private final BrouwerService brouwerService;
	
	private char[] alfabet= new char['Z' - 'A'];
	
	@Autowired
	public BrouwersController(BrouwerService brouwerService) {
		this.brouwerService = brouwerService;
		
		for(int i = 0; i < alfabet.length; i++){
			alfabet[i] = (char)(i + 'A');
		}
	}

	//ALLE BRUOWERS
	@RequestMapping(method = RequestMethod.GET)
	ModelAndView alleBrouwers(){
		return new ModelAndView(BROUWERS_VIEW, "brouwers", brouwerService.findAll());
	}
	
	
	//ALFABETISCH
	@RequestMapping(path = "beginnaam",method = RequestMethod.GET)
	ModelAndView findByFirstLetter(){
		return new ModelAndView(BROUWERS_ALFABETISCH, "letters", alfabet);
	}
	
	@RequestMapping(path = "beginnaam/{gekozenLetter}", method = RequestMethod.GET)
	ModelAndView findByFirstLetter(@PathVariable Character gekozenLetter){
		return new ModelAndView(BROUWERS_ALFABETISCH, "brouwers", brouwerService.findByFirstLetter(gekozenLetter))
				.addObject("letters", alfabet);
	}
	
	
	//OP DEEL VAN DE NAAM
	@RequestMapping(path = "opnaam", method = RequestMethod.GET)
	ModelAndView opstartPaginaOpnaam(){
		return new ModelAndView(BROUWERS_OP_NAAM_VIEW).addObject(new DeelVanNaam());
	}
	
	@RequestMapping(method=RequestMethod.GET, params={"deelVanNaam"})
	ModelAndView opNaamZoeken(DeelVanNaam deelVanNaam){
		System.out.println(deelVanNaam.getDeelVanNaam());
		return new ModelAndView(BROUWERS_OP_NAAM_VIEW, "brouwers", brouwerService.findByNaam(deelVanNaam.getDeelVanNaam()));
	}
	
	@InitBinder("deelVanNaam")
	void initBinderDeelVanNaam(DataBinder dataBinder){
		dataBinder.setRequiredFields("naam");
	}
	
	
	//TOEVOEGEN
	@RequestMapping(path = "toevoegen", method = RequestMethod.GET)
	String createForm(){
		return BROUWERS_TOEVOEGEN_VIEW;
	}
	
	
	
	
	
	
	
}
