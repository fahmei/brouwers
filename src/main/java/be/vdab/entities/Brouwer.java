package be.vdab.entities;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import be.vdab.valueobjects.Adres;

@Entity
@Table(name = "brouwers")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Brouwer implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@Length(min=1, max=50)
	@SafeHtml
	private String naam;
	
	@Valid
	@Embedded
	private Adres adres;
	
	@NumberFormat(style=Style.NUMBER)
	@Min(0)
	private Integer omzet;
	
	public Brouwer(){}
	
	public Brouwer(long brouwerNr, String naam, Adres adres, Integer omzet) {
		this.id = brouwerNr;
		this.naam = naam;
		this.adres = adres;
		this.omzet = omzet;
	}
	
	//GETTERS
	public long getId() {
		return id;
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

	
	public void setId(long brouwerNr) {
		this.id = brouwerNr;
	}

	
	
}
