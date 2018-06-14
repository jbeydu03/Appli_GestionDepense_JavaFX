package org.jfx.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable

public class Adresse {

	@Column(name = "ligne1_adr", nullable = false)
	private String ligne1;

	@Column(name = "ligne2_adr")
	private String ligne2;

	@Column(name = "cp_adr")
	private String cp;

	@Column(name = "ville_adr")
	private String ville;

	@Column(name = "ligne3_adr")
	private String ligne3;
	

	public Adresse(String ligne1, String ligne2, String cp, String ville, String ligne3) {
		super();
		this.ligne1 = ligne1;
		this.ligne2 = ligne2;
		this.cp = cp;
		this.ville = ville;
		this.ligne3 = ligne3;

	}

	public Adresse() {

	}

	public String getLigne1() {
		return ligne1;
	}

	public void setLigne1(String ligne1) {
		this.ligne1 = ligne1;
	}

	public String getLigne2() {
		return ligne2;
	}

	public void setLigne2(String ligne2) {
		this.ligne2 = ligne2;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getLigne3() {
		return ligne3;
	}

	public void setLigne3(String ligne3) {
		this.ligne3 = ligne3;
	}

	//toString
	@Override
	public String toString() {
		return "Adresse [ligne1=" + ligne1 + ", ligne2=" + ligne2 + ", cp=" + cp + ", ville=" + ville + ", ligne3="
				+ ligne3 + "]";
	}
	
	

}
