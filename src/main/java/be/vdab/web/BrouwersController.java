package be.vdab.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Brouwer;
import be.vdab.services.BrouwerService;
import be.vdab.valueobjects.DeelVanNaam;

@Controller
@RequestMapping(path = "/brouwers", produces = MediaType.TEXT_HTML_VALUE)
class BrouwersController {

	private static final String BROUWERS_VIEW = "brouwers/brouwers";
	private static final String BROUWERS_OP_NAAM_VIEW = "brouwers/opnaam";
	private static final String BROUWERS_TOEVOEGEN_VIEW = "brouwers/toevoegen";
	private static final String BROUWERS_ALFABETISCH = "brouwers/beginnaam";
	private static final String BROUWERS_TERUG_NAAR_VIEW = "redirect:/brouwers";
	
	private final BrouwerService brouwerService;

	private char[] alfabet = new char['Z' - 'A'];

	@Autowired
	public BrouwersController(BrouwerService brouwerService) {
		this.brouwerService = brouwerService;

		for (int i = 0; i < alfabet.length; i++) {
			alfabet[i] = (char) (i + 'A');
		}
	}

	// ALLE BROUWERS
	@RequestMapping(method = RequestMethod.GET)
	ModelAndView alleBrouwers(Pageable pageable) {
		return new ModelAndView(BROUWERS_VIEW, "page", brouwerService.findAll(pageable));
	}

	
	// ALFABETISCH
	@RequestMapping(path = "beginnaam", method = RequestMethod.GET)
	ModelAndView findByFirstLetter() {
		return new ModelAndView(BROUWERS_ALFABETISCH, "letters", alfabet);
	}

	@RequestMapping(path = "beginnaam/{gekozenLetter}", method = RequestMethod.GET)
	ModelAndView findByFirstLetter(@PathVariable Character gekozenLetter) {
		return new ModelAndView(BROUWERS_ALFABETISCH, "brouwers", brouwerService.findByFirstLetter(gekozenLetter))
				.addObject("letters", alfabet);
	}

	// OP DEEL VAN DE NAAM
	@RequestMapping(path = "opnaam", method = RequestMethod.GET)
	ModelAndView opstartPaginaOpnaam() {
		return new ModelAndView(BROUWERS_OP_NAAM_VIEW).addObject(new DeelVanNaam());
	}

	@RequestMapping(path = "opnaam", method = RequestMethod.GET, params = { "deelVanNaam" })
	ModelAndView opNaamZoeken(DeelVanNaam deelVanNaam, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView(BROUWERS_OP_NAAM_VIEW);
		if (!bindingResult.hasErrors()) {
			modelAndView.addObject("brouwers", brouwerService.findByNaam(deelVanNaam.getDeelVanNaam()));
		}
		return modelAndView;
	}

	@InitBinder("deelVanNaam")
	void initBinderDeelVanNaam(DataBinder dataBinder) {
		dataBinder.initDirectFieldAccess();
	}
	
	@InitBinder("brouwer")
	void initBinderBrouwer(DataBinder dataBinder) {
		dataBinder.initDirectFieldAccess();
	}
	
	
	// TOEVOEGEN
	@RequestMapping(path = "toevoegen", method = RequestMethod.GET)
	ModelAndView createForm() {
		return new ModelAndView(BROUWERS_TOEVOEGEN_VIEW, "brouwer", new Brouwer());
	}
	
	@RequestMapping(path= "toevoegen", method = RequestMethod.POST)
	String create(@Valid Brouwer brouwer, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return BROUWERS_TOEVOEGEN_VIEW;
		}
		brouwerService.create(brouwer);
		return BROUWERS_TERUG_NAAR_VIEW;
	}

}
