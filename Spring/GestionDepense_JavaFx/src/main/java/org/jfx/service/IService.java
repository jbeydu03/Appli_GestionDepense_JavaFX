package org.jfx.service;

import org.jfx.model.Personne;
import java.util.ArrayList;

public interface IService {

	public boolean addPersonne(Personne personne);

	public Personne select(Long personneId);

	public boolean delete(Long personneId);

	public boolean update(Personne personne);

	public ArrayList<Personne> selectAll();
}
