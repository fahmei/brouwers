package be.vdab.restservices;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import be.vdab.entities.Brouwer;
import be.vdab.exceptions.BrouwerNietGevondenException;
import be.vdab.services.BrouwerService;

@RestController
@RequestMapping("/brouwers")	//TODO Opgelet mogelijks problemen bij /brouwers, is eignelijk /brouwers/brouwers
@ExposesResourceFor(Brouwer.class)
class BrouwerRestController {

	private final BrouwerService brouwerService;
	
	private final EntityLinks entityLinks;

	@Autowired
	public BrouwerRestController(BrouwerService brouwerService, EntityLinks entityLinks) {
		this.brouwerService = brouwerService;
		this.entityLinks = entityLinks;
	}
	
	
	//GET
	@RequestMapping(path = "{brouwer}", method = RequestMethod.GET)
	BrouwerResource read(@PathVariable Brouwer brouwer){
		if(brouwer == null) throw new BrouwerNietGevondenException();
		return new BrouwerResource(brouwer, entityLinks);
	}
	
	@RequestMapping(path = "beginnaam/{gekozenLetter}", method = RequestMethod.GET)
	BrouwersResource findByFirstLetter(@PathVariable Character gekozenLetter){
		return new BrouwersResource(brouwerService.findByFirstLetter(gekozenLetter), entityLinks);
	}
	
	@RequestMapping(path = "opnaam/{deelVanNaam}", method = RequestMethod.GET)
	BrouwersResource opNaamZoeken(@PathVariable String deelVanNaam){
		return new BrouwersResource(brouwerService.findByNaam(deelVanNaam), entityLinks);
	}
	
	
	//OPTIONS
	@RequestMapping(path = "{brouwer}", method = RequestMethod.OPTIONS)
	HttpHeaders options(@PathVariable Brouwer brouwer){
		if(brouwer == null) throw new BrouwerNietGevondenException();
		
		Set<HttpMethod> allowedMethods = new HashSet<>();
		
		allowedMethods.add(HttpMethod.GET);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAllow(allowedMethods);
		return headers;
	}
	
	//EXCEPTIONS
	@ExceptionHandler(BrouwerNietGevondenException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	void brouwerNietGevonden(){}
}
