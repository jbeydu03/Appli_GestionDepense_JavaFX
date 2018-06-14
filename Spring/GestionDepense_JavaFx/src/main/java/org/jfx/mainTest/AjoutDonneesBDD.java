package org.jfx.mainTest;

import org.jfx.model.Adresse;
import org.jfx.model.Adulte;
import org.jfx.model.Mail;
import org.jfx.model.Personne;
import org.jfx.model.Travail;
import org.jfx.service.IService;
import org.jfx.service.ServiceImpl;

public class AjoutDonneesBDD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IService s = new ServiceImpl();

		
//		Mail m = new Mail("jb@mail.com","1234");
//		Adresse a = new Adresse("1","rue de la Pompe","75017", "Paris", "Cedex 03");
//		Travail t = new Travail("Cap",10000);
//		Personne p = new Adulte("SAVARY","Etienne",a,m,t);
//		s.addPersonne(p);
		
		Personne p2 = new Adulte();
		p2= s.select(5L);
		System.out.println(p2.toString());
		
		
	}

}
