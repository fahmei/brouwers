package be.vdab.services;

import java.math.BigDecimal;

public interface WeerService {
	
	BigDecimal getTemperature(String gemeente, String temperatuurEenheid);

}
