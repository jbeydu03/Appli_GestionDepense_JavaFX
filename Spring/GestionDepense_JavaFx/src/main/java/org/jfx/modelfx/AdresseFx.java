package org.jfx.modelfx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AdresseFx {

	private StringProperty ligne1 = new SimpleStringProperty();

	private StringProperty ligne2 = new SimpleStringProperty();

	private StringProperty cp = new SimpleStringProperty();

	private StringProperty ville = new SimpleStringProperty();

	private StringProperty ligne3 = new SimpleStringProperty();

	//CONSTRUCTEUR
	public AdresseFx(StringProperty ligne1, StringProperty ligne2, StringProperty cp, StringProperty ville,
			StringProperty ligne3) {
		super();
		this.ligne1 = ligne1;
		this.ligne2 = ligne2;
		this.cp = cp;
		this.ville = ville;
		this.ligne3 = ligne3;
	}
	
	public AdresseFx() {}
	
	//GETTERS & SETTERS

	public StringProperty getLigne1() {
		return ligne1;
	}

	public void setLigne1(StringProperty ligne1) {
		this.ligne1 = ligne1;
	}

	public StringProperty getLigne2() {
		return ligne2;
	}

	public void setLigne2(StringProperty ligne2) {
		this.ligne2 = ligne2;
	}

	public StringProperty getCp() {
		return cp;
	}

	public void setCp(StringProperty cp) {
		this.cp = cp;
	}

	public StringProperty getVille() {
		return ville;
	}

	public void setVille(StringProperty ville) {
		this.ville = ville;
	}

	public StringProperty getLigne3() {
		return ligne3;
	}

	public void setLigne3(StringProperty ligne3) {
		this.ligne3 = ligne3;
	}

	@Override
	public String toString() {
		return "AdresseFx [ligne1=" + ligne1 + ", ligne2=" + ligne2 + ", cp=" + cp + ", ville=" + ville + ", ligne3="
				+ ligne3 + "]";
	}
	
	//ToString
	
	
	
	
	
	
	
}
