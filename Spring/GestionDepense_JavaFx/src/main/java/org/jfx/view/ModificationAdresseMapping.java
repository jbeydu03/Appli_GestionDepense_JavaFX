package org.jfx.view;

import org.jfx.model.Adresse;
import org.jfx.model.Personne;
import org.jfx.service.IService;
import org.jfx.service.ServiceImpl;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ModificationAdresseMapping {

	private IService service = new ServiceImpl();
	private Personne a = new Personne();

	@FXML
	private TextField numeroValue;

	@FXML
	private TextField rueValue;

	@FXML
	private TextField cpValue;

	@FXML
	private TextField villeValue;

	public void initialize(Long personneId) {

		this.a = service.select(personneId);

		this.numeroValue.setText(a.getAdresse().getLigne1());
		this.rueValue.setText(a.getAdresse().getLigne2());
		this.cpValue.setText(a.getAdresse().getCp());
		this.villeValue.setText(a.getAdresse().getVille());
	}

	@FXML
	public void enregistrer() {
		Adresse adresse = new Adresse();
		adresse.setLigne1(numeroValue.getText());
		adresse.setLigne2(rueValue.getText());
		adresse.setCp(cpValue.getText());
		adresse.setVille(villeValue.getText());

		a.setAdresse(adresse);

		service.update(a);

	}

	@FXML
	public void retour() {
		Alert bye = new Alert(AlertType.INFORMATION);
		bye.setTitle("Au revoir !");
		bye.setHeaderText("See you soon...");
		bye.setContentText("Et merci d'avoir suivi ce cours");
		bye.showAndWait();

	}
}
