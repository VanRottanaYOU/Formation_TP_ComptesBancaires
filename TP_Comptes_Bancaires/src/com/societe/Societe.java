package com.societe;

public class Societe {
	
	private String nom;
	private double chiffreAffaires;
	
	public Societe(String nom, double chiffreAffaires) {
		super();
		this.nom = nom;
		this.chiffreAffaires = chiffreAffaires;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getChiffreAffaires() {
		return chiffreAffaires;
	}

	public void setChiffreAffaires(double chiffreAffaires) {
		this.chiffreAffaires = chiffreAffaires;
	}

	@Override
	public String toString() {
		return "Societe [nom=" + nom + ", chiffreAffaires=" + chiffreAffaires + "]";
	}

	
}
