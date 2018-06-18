package org.jfx.view;

import java.time.LocalDate;

import org.jfx.mainTest.MainTest;
import org.jfx.model.Adresse;
import org.jfx.model.Adulte;
import org.jfx.model.Mail;
import org.jfx.model.Paie;
import org.jfx.model.Personne;
import org.jfx.model.Travail;
import org.jfx.modelfx.PersonneFx;
import org.jfx.service.IService;
import org.jfx.service.ServiceImpl;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;


public class NewPersonneMapping {
    private MainTest mainTest;
    private IService service = new ServiceImpl();
    
    
	@FXML
	private TextField nomValue;
	@FXML
	private TextField prenomValue;
	@FXML
	private DatePicker dateValue;

    
    //Méthode qui sera utilisée dans l'initialisation de l'IHM
    //dans notre classe principale
    public void setStage(MainTest mainTest) {
        this.mainTest = mainTest;
    }
    
	@FXML
	public void retour() {
		mainTest.initialisationContenu();
	}
	
	@FXML
	public void valider() {
		PersonneFx personne = new PersonneFx();
//		this.nomValue.setText(personne.getNom().get());
//		this.prenomValue.setText(personne.getPrenom().get());
//		this.dateValue.setValue(personne.getDateDeNaissance().get());

		personne.setNom(new SimpleStringProperty(nomValue.getText()));
		personne.setPrenom(new SimpleStringProperty(prenomValue.getText()));
		personne.setDateDeNaissance(new SimpleObjectProperty<LocalDate>(LocalDate.of(1950, 3, 3)));
		
		
		Adulte p = new Adulte();
		
		Mail m = new Mail("mail@changer.com","1234");
		Adresse a = new Adresse("18","boulevard du changmenent","03000", "Vichy", "Cedex 03");
		Paie pa1 = new Paie("31/01/2018", 2000.00);
		
		Travail t = new Travail();
		t.setNonSociete("Travailler.com");

		pa1.setTravailPaie(t);

		t.addPaie(pa1);

		
		p.setNom(personne.getNom().get());
		p.setPrenom(personne.getPrenom().get());
		p.setMail(m);
		p.setAdresse(a);
		p.setTravail(t);

		service.addPersonne(p);


	}
	
	
	
}
