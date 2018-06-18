package org.jfx.mainTest;

import java.io.IOException;

import org.jfx.view.DonneesPersoMapping;
import org.jfx.view.ListeAccueilMapping;
import org.jfx.view.MenuMapping;
import org.jfx.view.ModificationAdresseMapping;
import org.jfx.view.NewPersonneMapping;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

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
		// stagePrincipal.setScene(scene);
		stagePrincipal.show();
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
			// On définit une scène principale avec notre conteneur
			Scene scene = new Scene(conteneurPrincipal);
			// Que nous affectons à notre Stage
			stagePrincipal.setScene(scene);

			// Initialisation de notre contrôleur
			MenuMapping controleur = loader.getController();

			// Et ainsi fermer l'application
			controleur.setStage(this.stagePrincipal, this);

			// Pour l'afficher
			// stagePrincipal.show();
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
			// Nous lui passons notre instance de classe pour qu'il puisse récupérer notre
			// liste observable
			controleur.setStage(this);
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
			controleur.setStage(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void DetailsPersoPersonne(Long idPersonne) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/org/jfx/view/donneesPerso.fxml"));

			AnchorPane donneesPerso = (AnchorPane) loader.load();
			conteneurPrincipal.setCenter(donneesPerso);

			DonneesPersoMapping controleur = loader.getController();
			controleur.setStage(this);
			controleur.initialize(idPersonne);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void afficherModifierAdresse(Long idPersonne) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/org/jfx/view/modificationAdresse.fxml"));

			AnchorPane modificationAdresse = (AnchorPane) loader.load();
			conteneurPrincipal.setCenter(modificationAdresse);

			ModificationAdresseMapping controleur = loader.getController();
			controleur.initialize(idPersonne);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
