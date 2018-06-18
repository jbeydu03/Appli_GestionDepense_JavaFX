package org.jfx.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;





@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Personne {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private LocalDate dateDeNaissance;
	private String nom;
	private String prenom;
	
	@Embedded
	private Adresse adresse;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mail_id")
	private Mail mail;
	

	//CONSTRUCTEUR

	public Personne(){};
	
	public Personne(String nom,String prenom, Adresse adresse, Mail mail){
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.mail = mail;
	}
	
	//GETTERS SETTERS

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public Adresse getAdresse() {
		return adresse;
	}
	
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	public Mail getMail() {
		return mail;
	}
	
	public void setMail(Mail mail) {
		this.mail = mail;
	}
	
	//ToString
	@Override
	public String toString() {
		return "Personne [id=" + id + ", dateDeNaissance=" + dateDeNaissance + ", nom=" + nom + ", prenom=" + prenom
				+ ", adresse=" + adresse + ", mail=" + mail + "]";
	}
	

	
	

}
