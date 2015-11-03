package be.vdab.restclients;

import java.math.BigDecimal;

public interface WeerClient {

	BigDecimal getTemperature(String gemeente, String temperatuurEenheid);
}
