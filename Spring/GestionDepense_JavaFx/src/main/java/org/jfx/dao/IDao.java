package org.jfx.dao;

import java.util.ArrayList;

import org.jfx.model.Personne;

public interface IDao {

	public boolean addPersonne(Personne personne);

	public ArrayList<Personne> selectAll();

	public Personne select(Long personneId);

	public boolean delete(Long personneId);

	public boolean update(Personne personne);
}
