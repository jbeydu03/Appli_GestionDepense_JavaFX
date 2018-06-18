package org.jfx.mainTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

import org.jfx.model.Adresse;
import org.jfx.model.Adulte;
import org.jfx.model.Mail;
import org.jfx.model.Paie;
import org.jfx.model.Personne;
import org.jfx.model.Travail;
import org.jfx.service.IService;
import org.jfx.service.ServiceImpl;

public class AjoutDonneesBDD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		IService s = new ServiceImpl();
//
//		
//		Mail m = new Mail("jbblanc@mail.com","1234");
//		Adresse a = new Adresse("18","boulevard du Pape","03000", "Vichy", "Cedex 03");
//		Paie pa1 = new Paie("31/01/2018", 2000.00);
//		Paie pa2 = new Paie("28/02/2018", 1900.00);
//
//
//		
//		Travail t = new Travail();
//		t.setNonSociete("Cap");
//		
//
//		pa1.setTravailPaie(t);
//		pa2.setTravailPaie(t);
//		t.addPaie(pa1);
//		t.addPaie(pa2);
//		System.out.println(t.toString());
//		
//		Personne p = new Adulte("LE-MENTEC","Sandrine",a,m,t);
//		s.addPersonne(p);
//		
//		Personne p2 = new Adulte();
//		p2= s.select(1L);
//		System.out.println(p2.toString());
		
	    ScriptEngineManager manager = new ScriptEngineManager(); 
	    List<ScriptEngineFactory> factories = manager.getEngineFactories(); 
	    
	    for (ScriptEngineFactory factory : factories) { 
	      System.out.println("Name : " + factory.getEngineName()); 
	      System.out.println("Version : " + factory.getEngineVersion()); 
	      System.out.println("Language name : " + factory.getLanguageName()); 
	      System.out.println("Language version : " + factory.getLanguageVersion()); 
	      System.out.println("Extensions : " + factory.getExtensions()); 
	      System.out.println("Mime types : " + factory.getMimeTypes()); 
	      System.out.println("Names : " + factory.getNames()); 
	    }
	  } 
}
		

