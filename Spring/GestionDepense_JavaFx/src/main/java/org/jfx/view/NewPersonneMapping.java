package org.jfx.view;

import java.time.LocalDate;

import org.jfx.mainTest.MainTest;
import org.jfx.model.Personne;
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
import javafx.stage.Stage;

public class NewPersonneMapping {
	
    //Objet servant de référence à notre classe principale
    //afin de pouvoir récupérer le Stage principal.
	//et ainsi fermer l'application
    private Stage stage;
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
    public void setStage(Stage stage, MainTest mainTest) {
        this.stage = stage;
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
		
		
		Personne p = new Personne();
		p.setNom(personne.getNom().get());
		p.setPrenom(personne.getPrenom().get());
		service.addPersonne(p);


	}
	
	
	
}
