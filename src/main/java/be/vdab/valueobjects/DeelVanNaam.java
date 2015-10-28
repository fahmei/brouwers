package be.vdab.valueobjects;

import org.hibernate.validator.constraints.NotBlank;

//IMMUTABLE
public class DeelVanNaam {
	
	@NotBlank
	private String deelVanNaam;

	public String getDeelVanNaam() {
		return deelVanNaam;
	}

	
}
