package org.jfx.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Paie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String date;
	private Double salaire;
	
	@ManyToOne (cascade= {CascadeType.PERSIST})
	@JoinColumn(name="travail_id")
	Travail travail;
	
	


	// CONSTRUCTEUR
	public Paie(String date, Double salaire ) {
		super();
		this.date = date;
		this.salaire = salaire;
	
	}
	
	public Paie() {};
	

	// GETTERS & SETTERS

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getSalaire() {
		return salaire;
	}

	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}

	public Travail getTravail() {
		return travail;
	}

	public void setTravailPaie(Travail travail) {
		this.travail = travail;
	}

	
	// ToString
	@Override
	public String toString() {
		return "Paie [id=" + id + ", date=" + date + ", salaire=" + salaire + "]";
	}
	

	



}
