package org.jfx.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Adulte extends Personne {

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "travail_id")
	Travail travail;

	// CONSTRUCTEUR

	public Adulte(String nom, String prenom, Adresse adresse, Mail mail, Travail travail) {
		super(nom, prenom, adresse, mail);
		this.travail = travail;
	}

	public Adulte() {
	}

	// GETTERS ET SETTERS
	public Travail getTravail() {
		return travail;
	}

	public void setTravail(Travail travail) {
		this.travail = travail;
	}

	
	//toString
	@Override
	public String toString() {
		return "Adulte toString()=" + super.toString() + "[travail=" + travail + "]";
	}
	

}
