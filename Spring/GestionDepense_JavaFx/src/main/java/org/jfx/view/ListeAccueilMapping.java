package org.jfx.view;

import java.util.ArrayList;

import org.jfx.mainTest.MainTest;
import org.jfx.model.Adresse;
import org.jfx.model.Mail;
import org.jfx.model.Personne;
import org.jfx.modelfx.PersonneFx;
import org.jfx.service.IService;
import org.jfx.service.ServiceImpl;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ListeAccueilMapping {

	private IService service = new ServiceImpl();
	private ObservableList<PersonneFx> listDePersonne = FXCollections.observableArrayList();

	@FXML
	private TableView<PersonneFx> personneTable;
	@FXML
	private TableColumn<PersonneFx, Long> idColonne;
	@FXML
	private TableColumn<PersonneFx, String> nomColonne;
	@FXML
	private TableColumn<PersonneFx, String> prenomColonne;
	@FXML
	private Label nomValue;
	@FXML
	private Label prenomValue;
	@FXML
	private Label dateValue;
	@FXML
	private Label mailValue;
	@FXML
	private Label numeroValue;
	@FXML
	private Label rueValue;
	@FXML
	private Label codePostalValue;
	@FXML
	private Label villeValue;

	private MainTest mainTest;

	// Méthode qui sera utilisée dans l'initialisation de l'IHM
	// dans notre classe principale
	public void setStage(MainTest mainTest) {
		this.mainTest = mainTest;
	}

	// Un constructeur par défaut
	public ListeAccueilMapping() {
	}

	// Méthode qui initialise notre interface graphique avec nos données métier
	@FXML
	private void initialize() {
		// Initialize the Personne table.

		nomColonne.setCellValueFactory(cellData -> cellData.getValue().getNom());
		prenomColonne.setCellValueFactory(cellData -> cellData.getValue().getPrenom());

		personneTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> initializeDescription(newValue));
	}

	public void setApp() {
		ArrayList<Personne> listPersonne = new ArrayList<>();
		listPersonne = service.selectAll();
		for (Personne personne : listPersonne) {
			PersonneFx p = new PersonneFx();
			p.setId(new SimpleLongProperty(personne.getId()));
			p.setNom(new SimpleStringProperty(personne.getNom()));
			p.setPrenom(new SimpleStringProperty(personne.getPrenom()));
			p.setMail(new SimpleObjectProperty<Mail>(personne.getMail()));
			p.setAdresse(new SimpleObjectProperty<Adresse>(personne.getAdresse()));

			listDePersonne.add(p);
		}

		personneTable.setItems(listDePersonne);
	}

	// Méthode qui va mettre les valeurs de notre objet dans les composants
	public void initializeDescription(PersonneFx p) {
		// Si un objet est passé en paramètre, on modifie l'IHM
		if (p != null) {

			// ATTENTION : les accesseurs retournent des objets Property Java FX
			// Pour récupérer leurs vrais valeurs vous devez utiliser la méthode get()

			nomValue.setText(p.getNom().get());
			prenomValue.setText(p.getPrenom().get());
			// Sur les deux champs si dessous, en plus de get()
			// vous devez utiliser toString() car ce sont des objets particuliers
			dateValue.setText(p.getDateDeNaissance().get().toString());
			mailValue.setText(p.getMail().get().getEmail());
			numeroValue.setText(p.getAdresse().get().getLigne1());
			rueValue.setText(p.getAdresse().get().getLigne2());
			codePostalValue.setText(p.getAdresse().get().getCp());
			villeValue.setText(p.getAdresse().get().getVille());

		} else {
			nomValue.setText("");
			prenomValue.setText("");
			dateValue.setText("");
			mailValue.setText("");
		}
	}

	@FXML
	public void details() {
		int index = personneTable.getSelectionModel().getSelectedIndex();
		if (index > -1) {

			mainTest.DetailsPersoPersonne((personneTable.getSelectionModel().getSelectedItem().getId().get()));
		}

	}

	@FXML
	public void delete() {
		int index = personneTable.getSelectionModel().getSelectedIndex();
		// Si aucune ligne n'est sélectionnée, index vaudra -1
		if (index > -1) {
			personneTable.getItems().remove(index);
			service.delete((long) index + 1);

		} else {
			Alert probleme = new Alert(AlertType.ERROR);
			probleme.setTitle("Erreur");
			probleme.setHeaderText("Veuillez sélectionnez une ligne dans le tableau");
			probleme.showAndWait();
		}
	}

}
