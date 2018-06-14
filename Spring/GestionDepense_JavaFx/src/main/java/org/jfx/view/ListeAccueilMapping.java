package org.jfx.view;

import java.util.ArrayList;

import org.jfx.model.Adresse;
import org.jfx.model.Mail;
import org.jfx.model.Personne;
import org.jfx.modelfx.PersonneFx;
import org.jfx.service.IService;
import org.jfx.service.ServiceImpl;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ListeAccueilMapping {
	
	private IService service = new ServiceImpl();
	private ObservableList<PersonneFx> listDePersonne = FXCollections.observableArrayList();

	@FXML
	private TableView<PersonneFx> personneTable;
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

	

	// Un constructeur par défaut
	public ListeAccueilMapping() {
	}
	
    //Méthode qui initialise notre interface graphique
    //avec nos données métier
    @FXML
    private void initialize() {
        // Initialize the Personne table with the two columns.
        nomColonne.setCellValueFactory(cellData -> cellData.getValue().getNom());
        prenomColonne.setCellValueFactory(cellData -> cellData.getValue().getPrenom());
        
        personneTable.getSelectionModel().selectedItemProperty().addListener(
        (observable, oldValue, newValue) -> initializeDescription(newValue));
    }
    
    public void setApp() {
    	ArrayList<Personne> listPersonne = new ArrayList<>();
    	listPersonne = service.selectAll();
    	for (Personne personne : listPersonne) {
    		PersonneFx p = new PersonneFx();

    		p.setNom(new SimpleStringProperty(personne.getNom()));
    		p.setPrenom(new SimpleStringProperty(personne.getPrenom()));
    		p.setMail(new SimpleObjectProperty<Mail>(personne.getMail()));
    		p.setAdresse(new SimpleObjectProperty<Adresse>(personne.getAdresse()));

    		

    

    		listDePersonne.add(p);
    		
		}
    	
    	
        personneTable.setItems(listDePersonne);
    }
    
  //Méthode qui va mettre les valeurs de notre objet dans les composants
    public void initializeDescription(PersonneFx p) {
     	//Si un objet est passé en paramètre, on modifie l'IHM
    	if(p != null) {
    		//ATTENTION : les accesseurs retournent des objets Property Java FX
    		//Pour récupérer leurs vrais valeurs vous devez utiliser la méthode get()
    		nomValue.setText(p.getNom().get());
    		prenomValue.setText(p.getPrenom().get());
    		//Sur les deux champs si dessous, en plus de get()
    		//vous devez utiliser toString() car ce sont des objets particuliers
    		dateValue.setText(p.getDateDeNaissance().get().toString());
    		mailValue.setText(p.getMail().get().getEmail());
    		numeroValue.setText(p.getAdresse().get().getLigne1());
    		rueValue.setText(p.getAdresse().get().getLigne2());
    		codePostalValue.setText(p.getAdresse().get().getCp());
    		villeValue.setText(p.getAdresse().get().getVille());

    	}
    	else {
        	nomValue.setText("");
        	prenomValue.setText("");
        	dateValue.setText("");
        	mailValue.setText("");
    	}
    }
    
    
    
    
    

}
