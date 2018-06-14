package org.jfx.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Mail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String email;

	private String mdp;

	@OneToOne(mappedBy="mail")
	private Personne personne;

	
	//CONSTRUCTEUR
	public Mail(String email, String mdp) {
		this.email = email;
		this.mdp = mdp;
	}
	
	public Mail() {
	}
	
	
	
	//GETTEUR ET SETTEUR
	public long getId() {
		return id;
	}

	

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	//toString
	@Override
	public String toString() {
		return "Mail [id=" + id + ", email=" + email + ", mdp=" + mdp +"]";
	}
	
	

}
