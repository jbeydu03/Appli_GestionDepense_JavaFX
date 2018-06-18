package org.jfx.view;

import java.util.ArrayList;

import org.jfx.mainTest.MainTest;
import org.jfx.model.Personne;
import org.jfx.service.IService;
import org.jfx.service.ServiceImpl;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DonneesPersoMapping {

	private IService service = new ServiceImpl();
	private MainTest mainTest;

	// Méthode qui sera utilisée dans l'initialisation de l'IHM
	// dans notre classe principale
	public void setStage(MainTest mainTest) {
		this.mainTest = mainTest;
	}

	private Long idPersonne;

	@FXML
	private Label numeroValue;
	@FXML
	private Label rueValue;
	@FXML
	private Label cpValue;
	@FXML
	private Label villeValue;

	public void initialize(Long personneId) {
		this.idPersonne = personneId;
		Personne a = service.select(personneId);

		this.numeroValue.setText(a.getAdresse().getLigne1());
		this.rueValue.setText(a.getAdresse().getLigne2());
		this.cpValue.setText(a.getAdresse().getCp());
		this.villeValue.setText(a.getAdresse().getVille());
	}

	public void modifierAdresse() {
		mainTest.afficherModifierAdresse(this.idPersonne);
	}

}
