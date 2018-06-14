package org.jfx.dao;

import java.util.ArrayList;

import org.jfx.model.Personne;
import org.jfx.modelfx.PersonneFx;

import javafx.collections.ObservableList;

public interface IDao {

	
	public void addPersonne(Personne personne);
	
	public ArrayList<Personne> selectAll();
	
	public Personne select(Long personneId);
}
