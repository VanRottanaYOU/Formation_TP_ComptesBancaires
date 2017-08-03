package com.services;

import com.societe.Societe;

public class Facture {
	
	private Societe societe;
	private double montantHT;
	
	public Facture(Societe societe, double montantHT) {
		super();
		this.societe = societe;
		this.montantHT = montantHT;
	}
	
	public Societe getSociete() {
		return societe;
	}
	
	public void setSociete(Societe societe) {
		this.societe = societe;
	}
	
	public double getMontantHT() {
		return montantHT;
	}
	
	public void setMontantHT(double montantHT) {
		this.montantHT = montantHT;
	}
	
	@Override
	public String toString() {
		return "Facture [societe=" + societe + ", montantHT=" + montantHT + "]";
	}
	
	
	
	
}
