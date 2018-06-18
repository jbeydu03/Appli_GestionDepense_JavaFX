package org.jfx.service;

import org.jfx.dao.IDao;

import java.util.ArrayList;

import org.jfx.dao.DaoImpl;
import org.jfx.model.Personne;

public class ServiceImpl implements IService {

	private IDao dao = new DaoImpl();

	@Override
	public boolean addPersonne(Personne personne) {
		boolean reponse = dao.addPersonne(personne);
		if (reponse == false) {
			return false;
		} else
			return true;
	}

	@Override
	public ArrayList<Personne> selectAll() {
		return dao.selectAll();

	}

	@Override
	public Personne select(Long personneId) {
		return dao.select(personneId);
	}

	@Override
	public boolean delete(Long personneId) {
		boolean reponse = dao.delete(personneId);
		if (reponse == false) {
			return false;
		} else
			return true;

	}

	@Override
	public boolean update(Personne personne) {
		boolean reponse = dao.update(personne);
		if (reponse == false) {
			return false;
		} else
			return true;
	}

}
