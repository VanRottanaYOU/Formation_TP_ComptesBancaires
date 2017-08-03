package com.clients;

public class Client {

	private String nom;
	private int age;
	
	public Client(String nom, int age) {
		this.nom=nom;
		this.age=age;
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		
		return "Nom client : " + nom+ " "+ "Age : "+ " "+ age;
	}
}
