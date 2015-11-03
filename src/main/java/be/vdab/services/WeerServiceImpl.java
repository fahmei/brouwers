package be.vdab.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.vdab.restclients.WeerClient;

@Service
public class WeerServiceImpl implements WeerService{

	private final WeerClient weerClient;
	
	@Autowired
	public WeerServiceImpl(WeerClient weerClient) {
		this.weerClient = weerClient;
	}


	@Override
	public BigDecimal getTemperature(String gemeente, String temperatuurEenheid) {
		return weerClient.getTemperature(gemeente, temperatuurEenheid);
	}

}
