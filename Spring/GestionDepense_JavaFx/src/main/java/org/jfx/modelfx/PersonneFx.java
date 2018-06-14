package org.jfx.modelfx;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.jfx.model.Adresse;
import org.jfx.model.Mail;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;




public class PersonneFx {
	
	private ObjectProperty<LocalDate> dateDeNaissance = new SimpleObjectProperty<>();
	private StringProperty nom = new SimpleStringProperty();
	private StringProperty prenom = new SimpleStringProperty();
	private ObjectProperty<Mail> mail= new SimpleObjectProperty<>();
	private ObjectProperty<Adresse> adresse = new SimpleObjectProperty<>();
	// private ObjectProperty<Sexe> sexe = new SimpleObjectProperty<>();

	public PersonneFx() {
		this.nom.set("");
		this.prenom.set("");
		this.dateDeNaissance.set(LocalDate.of(0, 1, 1));
	
	}

	public PersonneFx(String n, String p, LocalDate ddn, Mail mail, Adresse adresse) {
		this.nom.set(n);
		this.prenom.set(p);
		this.dateDeNaissance.set(ddn);
		this.mail.set(mail);
		this.adresse.set(adresse);
	}

	public ObjectProperty<LocalDate> getDateDeNaissance() {
		return this.dateDeNaissance;
	}

	public void setDateDeNaissance(ObjectProperty<LocalDate> dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public StringProperty getNom() {
		return nom;
	}

	public void setNom(StringProperty nom) {
		this.nom = nom;
	}

	public StringProperty getPrenom() {
		return prenom;
	}

	public void setPrenom(StringProperty prenom) {
		this.prenom = prenom;
	}
	

	public ObjectProperty<Mail> getMail() {
		return mail;
	}

	public void setMail(ObjectProperty<Mail> mail) {
		this.mail = mail;
	}
	
	

	public ObjectProperty<Adresse> getAdresse() {
		return adresse;
	}

	public void setAdresse(ObjectProperty<Adresse> adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "PersonneFx [dateDeNaissance=" + dateDeNaissance + ", nom=" + nom + ", prenom=" + prenom + ", mail="
				+ mail + ", adresse=" + adresse + "]";
	}

	//ToString
	


}
