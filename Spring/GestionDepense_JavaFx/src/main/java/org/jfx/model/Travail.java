package org.jfx.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Travail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String nonSociete;
	private double salaire;
	
	@OneToOne(mappedBy="travail")
	Adulte adulte;

	// CONSTRUCTEUR
	public Travail(String nonSociete, double salaire) {
		super();
		this.nonSociete = nonSociete;
		this.salaire = salaire;
	}

	public Travail() {
	}

	// GETTERS ET SETTERS

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNonSociete() {
		return nonSociete;
	}

	public void setNonSociete(String nonSociete) {
		this.nonSociete = nonSociete;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	
	//toString
	@Override
	public String toString() {
		return "Travail [id=" + id + ", nonSociete=" + nonSociete + ", salaire=" + salaire + "]";
	}
	
}
