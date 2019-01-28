package fr.insa.soa.RestProjectSalles;

import javax.xml.bind.annotation.XmlRootElement;

/*@XmlRootElement*/
public class Temperature {
	private String nom;
	private String value;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
