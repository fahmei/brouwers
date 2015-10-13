package be.vdab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/brouwers")
class BrouwersController {

	private static final String BROUWERS_VIEW = "brouwers/brouwers";
	private static final String BROUWERS_OP_NAAM_VIEW = "brouwers/beginnaam";
	private static final String BROUWERS_TOEVOEGEN_VIEW = "brouwers/toevoegen";
	
	@RequestMapping(method = RequestMethod.GET)
	String findAll(){
		return BROUWERS_VIEW;
	}
	
	@RequestMapping(path = "beginnaam",method = RequestMethod.GET)
	String findByName(){
		return BROUWERS_OP_NAAM_VIEW;
	}
	
	@RequestMapping(path = "toevoegen", method = RequestMethod.GET)
	String createForm(){
		return BROUWERS_TOEVOEGEN_VIEW;
	}
	
}
