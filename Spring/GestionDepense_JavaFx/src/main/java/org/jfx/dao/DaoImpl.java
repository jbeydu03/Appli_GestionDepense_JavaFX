package org.jfx.dao;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jfx.model.Personne;
import org.jfx.modelfx.PersonneFx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class DaoImpl implements IDao {

	private static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("my-pu");

	@Override
	public void addPersonne(Personne personne) {
		EntityManager em = EMF.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		try {
			// D�but transaction
			txn.begin();

			// PERSIST
			em.persist(personne);

			// Fin transaction
			txn.commit();
		} catch (Exception e) {

			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
			// return false;
		} finally {
			if (em != null) {
				em.close();
			}
		}

		// return true;
	}

	@Override
	public ArrayList<Personne> selectAll() {

		EntityManager em = EMF.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		ArrayList<Personne> personne2List = new ArrayList<>();

		try {
			txn.begin();

			Query jQuery = em.createQuery("Select personne From Personne personne");
			personne2List = (ArrayList<Personne>) jQuery.getResultList();

			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}

		}

		return personne2List;

	}

	@Override
	public Personne select(Long personneId) {
		EntityManager em = EMF.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		Personne personne = null;

		try {
			// D�but transaction
			txn.begin();

			// FIND
			personne = em.find(Personne.class, personneId);

			// Fin transaction
			txn.commit();
		} catch (Exception e) {

			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return personne;
	}

}
