package org.jfx.view;



import org.jfx.mainTest.MainTest;

import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.stage.Stage;

public class MenuMapping {
	
    //Objet servant de référence à notre classe principale
    //afin de pouvoir récupérer le Stage principal.
	//et ainsi fermer l'application
    private Stage stage;
    private MainTest mainTest;
    
    //Méthode qui sera utilisée dans l'initialisation de l'IHM
    //dans notre classe principale
    public void setStage(Stage stage, MainTest mainTest) {
        this.stage = stage;
        this.mainTest = mainTest;
    }
	
	
	//Fermer l'application
	@FXML
	public void fermer() {
		//On affiche un message car on est poli.
		Alert bye = new Alert(AlertType.INFORMATION);
		bye.setTitle("Au revoir !");
		bye.setHeaderText("See you soon...");
		bye.setContentText("Et merci d'avoir suivi ce cours");
		bye.showAndWait();
		this.stage.close();
		
		//Et on clos le stage principal, donc l'application
	}
	
	
	@FXML
	public void newPersonne() {
		mainTest.newPersonne();
		
	}
	
	@FXML
	public void accueil() {
		mainTest.initialisationContenu();
		
	}
	

}
