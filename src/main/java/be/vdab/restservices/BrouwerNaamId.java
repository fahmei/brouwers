package be.vdab.restservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import be.vdab.entities.Brouwer;

@XmlAccessorType(XmlAccessType.FIELD)
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
class BrouwerNaamId {
	
	@XmlAttribute
	private long id;
	
	@XmlAttribute
	private String naam;
	
	BrouwerNaamId() {}

	BrouwerNaamId(Brouwer brouwer){
		this.id = brouwer.getId();
		this.naam = brouwer.getNaam();
	}
}
