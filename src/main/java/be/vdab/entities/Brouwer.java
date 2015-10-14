package be.vdab.entities;

import be.vdab.valueobjects.Adres;

public class Brouwer {
	
	private final long brouwerNr;
	private final String naam;
	private Adres adres;
	private Integer omzet;
	
	public Brouwer(long brouwerNr, String naam, Adres adres, Integer omzet) {
		this.brouwerNr = brouwerNr;
		this.naam = naam;
		this.adres = adres;
		this.omzet = omzet;
	}

	//GETTERS
	public long getBrouwerNr() {
		return brouwerNr;
	}

	public String getNaam() {
		return naam;
	}

	public Adres getAdres() {
		return adres;
	}

	public Integer getOmzet() {
		return omzet;
	}

	//SETTERS
	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	public void setOmzet(Integer omzet) {
		this.omzet = omzet;
	}

}
