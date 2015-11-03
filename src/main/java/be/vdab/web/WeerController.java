package be.vdab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.services.WeerService;

@Controller
@RequestMapping("/temperatuur")
public class WeerController {

	private final static String VIEW = "temperatuur/huidigetemperatuur";
	private final WeerService weerService;
	
	private final MessageSource messageSource;

	
	@Autowired
	WeerController(WeerService weerService, MessageSource messageSource) {
		this.weerService = weerService;
		this.messageSource=messageSource;

	}
	
	@RequestMapping(path = "huidigetemperatuur/{gemeente}", method = RequestMethod.GET)
	ModelAndView temperatuurPerGemeente(@PathVariable String gemeente){
		ModelAndView modelAndView = new ModelAndView(VIEW);
		modelAndView.addObject("gemeente", gemeente);
		
		modelAndView.addObject("temperatuur", weerService.getTemperature(gemeente, messageSource.getMessage("temperatuurEenheid", null, "temperatuurEenheid", LocaleContextHolder.getLocale())));
		return modelAndView;
	}
	
}
