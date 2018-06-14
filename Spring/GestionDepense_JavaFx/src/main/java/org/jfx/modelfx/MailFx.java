package org.jfx.modelfx;

import java.time.LocalDate;

import org.jfx.model.Personne;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MailFx {

	private LongProperty id= new SimpleLongProperty();;
	private StringProperty email= new SimpleStringProperty();
	private StringProperty mdp = new SimpleStringProperty();

	private ObjectProperty<Personne> personne  = new SimpleObjectProperty<>();

	// CONSTRUCTEUR	
	public MailFx(String email, String mdp, Personne personne) {
		this.email.set(email);
		this.mdp.set(mdp);
		this.personne.set(personne);
	}
	

	public MailFx() {
	}


	public LongProperty getId() {
		return id;
	}


	public void setId(LongProperty id) {
		this.id = id;
	}


	public StringProperty getEmail() {
		return email;
	}


	public void setEmail(StringProperty email) {
		this.email = email;
	}


	public StringProperty getMdp() {
		return mdp;
	}


	public void setMdp(StringProperty mdp) {
		this.mdp = mdp;
	}


	public ObjectProperty<Personne> getPersonne() {
		return personne;
	}


	public void setPersonne(ObjectProperty<Personne> personne) {
		this.personne = personne;
	}

	// GETTEUR ET SETTEUR
	

}
