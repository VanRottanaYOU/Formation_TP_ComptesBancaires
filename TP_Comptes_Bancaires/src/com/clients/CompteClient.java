package com.clients;

public class CompteClient {

	private Client client;
	private double montant;
	private boolean decouvertAutorise;
	private double plafondDecouvert;
	
	public CompteClient(Client client,double montant,boolean decouvertAutorise,double plafondDecouvert) {
		this.client=client;
		this.montant=montant;
		this.decouvertAutorise=decouvertAutorise;
		this.plafondDecouvert=plafondDecouvert;
		
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public void ajoutMontant(double montant) {
		this.montant += montant;	
	}
	
	public void retirerMontant(double montant) {
		
		if (decouvertAutorise && (this.montant - montant < plafondDecouvert))
		{
			this.montant -= montant;					
		}
	}
	
	public boolean isDecouvertAutorise() {
		return decouvertAutorise;
	}

	public void setDecouvertAutorise(boolean decouvertAutorise) {
		this.decouvertAutorise = decouvertAutorise;
	}

	public double getPlafondDecouvert() {
		return plafondDecouvert;
	}

	public void setPlafondDecouvert(double plafondDecouvert) {
		this.plafondDecouvert = plafondDecouvert;
	}
	
	public String toString() {
		
		return "Client : " + client.toString()+ " "+ "montant : "+ " "+ montant +" "+ "decouvertAutorise : "+ " "+
				decouvertAutorise + " "+ "plafondDecouvert : "+" "+plafondDecouvert;
	}
}
