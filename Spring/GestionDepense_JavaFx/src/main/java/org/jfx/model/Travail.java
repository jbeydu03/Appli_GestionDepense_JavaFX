package org.jfx.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Travail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String nonSociete;
	
	@OneToMany(mappedBy="travail", cascade={CascadeType.PERSIST})
	private Set<Paie> paies = new HashSet<>();
	
	


	@OneToOne(mappedBy = "travail")
	Adulte adulte;

	// CONSTRUCTEUR

	public Travail(String nonSociete, Set<Paie> paies) {
		this.nonSociete = nonSociete;
		this.paies = paies;

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

	public Adulte getAdulte() {
		return adulte;
	}

	public void setAdulte(Adulte adulte) {
		this.adulte = adulte;
	}

	public Set<Paie> getPaies() {
		return paies;
	}

	public void setPaies(Set<Paie> paies) {
		this.paies = paies;
	}
	
	public void addPaie(Paie paie) {
		this.paies.add(paie);
	}

	// toString
	@Override
	public String toString() {
		return "Travail [id=" + id + ", nonSociete=" + nonSociete + ", paies=" + paies + ", adulte=" + adulte + "]";
	}

}
