package be.vdab.web;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
class IndexController {

	private static final String VIEW = "index";
	
	@RequestMapping(method = RequestMethod.GET)
	ModelAndView index(){
		return new ModelAndView(VIEW, "welkomBericht", welkomBerichtBepalen());
	}

	private String welkomBerichtBepalen() {
		
		int bereik = Calendar.getInstance().get(Calendar.HOUR_OF_DAY) / 6;
		
		switch (bereik) {
		case 0:
			return "GoedeNacht";
		case 1:
			return "GoedeMorgen";
		case 2:
			return "GoedeMiddag";
		default:
			return "GoedeAvond";
		}
	}
}