package com.habib.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {

	String rue,ville,payes,codepostale;

	/**
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * @return the payes
	 */
	public String getPayes() {
		return payes;
	}

	/**
	 * @param payes the payes to set
	 */
	public void setPayes(String payes) {
		this.payes = payes;
	}

	/**
	 * @return the codepostale
	 */
	public String getCodepostale() {
		return codepostale;
	}

	/**
	 * @param codepostale the codepostale to set
	 */
	public void setCodepostale(String codepostale) {
		this.codepostale = codepostale;
	}
	
	
}
