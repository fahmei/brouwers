package be.vdab.valueobjects;

public class Adres {

	private String straat, huisNr, gemeente;
	private int postcode;

	//CONSTRUCTORS
	public Adres(String straat, String huisNr, int postcode, String gemeente) {
		this.straat = straat;
		this.huisNr = huisNr;
		this.postcode = postcode;
		this.gemeente = gemeente;
	}

	//GETTERS
	public String getStraat() {
		return straat;
	}

	public String getHuisNr() {
		return huisNr;
	}

	public String getGemeente() {
		return gemeente;
	}

	public int getPostcode() {
		return postcode;
	}

	//SETTERS
	public void setStraat(String straat) {
		this.straat = straat;
	}

	public void setHuisNr(String huisNr) {
		this.huisNr = huisNr;
	}

	public void setGemeente(String gemeente) {
		this.gemeente = gemeente;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
	
	
}
