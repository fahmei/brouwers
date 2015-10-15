package be.vdab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.services.BrouwerService;

@Controller
@RequestMapping("/brouwers")
class BrouwersController {

	private static final String BROUWERS_VIEW = "brouwers/brouwers";
	private static final String BROUWERS_OP_NAAM_VIEW = "brouwers/beginnaam";
	private static final String BROUWERS_TOEVOEGEN_VIEW = "brouwers/toevoegen";
	
	private final BrouwerService brouwerService;
	
	private char[] alfabet= new char['Z' - 'A'];
	
	@Autowired
	public BrouwersController(BrouwerService brouwerService) {
		this.brouwerService = brouwerService;
		
		for(int i = 0; i < alfabet.length; i++){
			alfabet[i] = (char)(i + 'A');
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	ModelAndView alleBrouwers(){
		return new ModelAndView(BROUWERS_VIEW, "brouwers", brouwerService.findAll());
	}
	
	@RequestMapping(path = "beginnaam",method = RequestMethod.GET)
	ModelAndView findByNaam(){
		return new ModelAndView(BROUWERS_OP_NAAM_VIEW, "letters", alfabet);
	}
	
	@RequestMapping(path = "toevoegen", method = RequestMethod.GET)
	String createForm(){
		return BROUWERS_TOEVOEGEN_VIEW;
	}
	
	@RequestMapping(path = "beginnaam/{gekozenLetter}", method = RequestMethod.GET)
	ModelAndView findByFirstLetter(@PathVariable Character gekozenLetter){
		return new ModelAndView(BROUWERS_OP_NAAM_VIEW, "brouwers", brouwerService.findByFirstLetter(gekozenLetter))
				.addObject("letters", alfabet);
	}
	
}
