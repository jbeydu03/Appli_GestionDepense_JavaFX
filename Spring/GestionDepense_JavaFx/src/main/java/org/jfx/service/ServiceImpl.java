package org.jfx.service;

import org.jfx.dao.IDao;

import java.util.ArrayList;

import org.jfx.dao.DaoImpl;
import org.jfx.model.Personne;
import org.jfx.modelfx.PersonneFx;

import javafx.collections.ObservableList;

public class ServiceImpl implements IService {

	private IDao dao = new DaoImpl();

	@Override
	public void addPersonne(Personne personne) {
		dao.addPersonne(personne);

	}

	@Override
	public ArrayList<Personne> selectAll() {
		return dao.selectAll();

	}

	@Override
	public Personne select(Long personneId) {
		return dao.select(personneId);
	}

}
