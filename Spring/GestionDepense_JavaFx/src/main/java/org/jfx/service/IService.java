package org.jfx.service;

import org.jfx.model.Personne;
import org.jfx.modelfx.PersonneFx;

import java.util.ArrayList;

import javafx.collections.ObservableList;

public interface IService {
	

	
	public void addPersonne(Personne personne);
	
	public Personne select(Long personneId);
	
	public ArrayList<Personne> selectAll();
}
