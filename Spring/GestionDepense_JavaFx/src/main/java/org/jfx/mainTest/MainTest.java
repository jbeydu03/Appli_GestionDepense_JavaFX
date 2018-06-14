package org.jfx.mainTest;

import java.io.IOException;
import java.time.LocalDate;


import org.jfx.view.ListeAccueilMapping;
import org.jfx.view.MenuMapping;
import org.jfx.view.NewPersonneMapping;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainTest extends Application {

	private Stage stagePrincipal;
	public static BorderPane conteneurPrincipal;

	@Override
	public void start(Stage primaryStage) {
		stagePrincipal = primaryStage;
		// Ca ne vous rappelle pas une JFrame ?
		stagePrincipal.setTitle("Application de gestion de dépenses");

		// Nous allons utiliser nos fichier FXML dans ces deux méthodes
		accueil();
	}
	
	public void accueil() {
		initialisationMenu();
		initialisationContenu();
		
	}

	private void initialisationMenu() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/org/jfx/view/menu.fxml"));

		try {
			// Le chargement nous donne notre conteneur
			conteneurPrincipal = (BorderPane) loader.load();
			System.out.println(conteneurPrincipal);
			// On définit une scène principale avec notre conteneur
			Scene scene = new Scene(conteneurPrincipal);
			// Que nous affectons à notre Stage
			stagePrincipal.setScene(scene);

			// Initialisation de notre contrôleur
			MenuMapping controleur = loader.getController();

			// Et ainsi fermer l'application
			controleur.setStage(this.stagePrincipal, this);

			// Pour l'afficher
			stagePrincipal.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initialisationContenu() {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/org/jfx/view/listeAccueil.fxml"));

		try {
			// Nous récupérons notre conteneur qui contiendra les données
			// Pour rappel, c'est un AnchorPane...
			AnchorPane conteneurPersonne = (AnchorPane) loader.load();

			conteneurPrincipal.setCenter(conteneurPersonne);

			// Pour l'afficher

			// Nous récupérons notre mappeur via l'objet FXMLLoader
			ListeAccueilMapping controleur = loader.getController();
			// Nous lui passons notre instance de classe
			// pour qu'il puisse récupérer notre liste observable
			controleur.setApp();

		
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void newPersonne() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/org/jfx/view/newPersonne.fxml"));

				AnchorPane conteneurNewPersonne = (AnchorPane) loader.load();
				conteneurPrincipal.setCenter(conteneurNewPersonne);
				
				NewPersonneMapping controleur = loader.getController();
				controleur.setStage(this.stagePrincipal, this);
				
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	public static void main(String[] args) {
		launch(args);
	}
}
