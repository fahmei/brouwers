package be.vdab.restclients;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import be.vdab.exceptions.KanTemperatuurNietLezenException;

@Component
class TemperatureClient implements WeerClient {

	private final Logger logger = Logger.getLogger(TemperatureClient.class.getName());
	private final String temperatureURL;
	private final RestTemplate restTemplate;
	
	
	@Autowired
	public TemperatureClient(@Value("${temperatuurUrl}") String temperatureURL, RestTemplate restTemplate) {
		this.temperatureURL = temperatureURL;
		this.restTemplate = restTemplate;
	}


	@Override
	public BigDecimal getTemperature(String gemeente, String temperatuurEenheid) {
		try{
			return restTemplate.getForObject(temperatureURL, Current.class, gemeente, temperatuurEenheid).temperature.value;
			
		}catch(Exception ex){
			logger.log(Level.SEVERE, "kan temperatuur niet lezen", ex);
			throw new KanTemperatuurNietLezenException();
		}
	}

}
