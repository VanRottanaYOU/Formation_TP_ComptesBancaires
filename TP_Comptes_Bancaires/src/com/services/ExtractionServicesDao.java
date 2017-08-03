package com.services;


import java.util.ArrayList;
import java.util.Scanner;

import com.clients.Client;
import com.clients.CompteClient;
import com.interfaces.IservicesDao;
import com.connection.MySqlConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ExtractionServicesDao  implements IservicesDao{

	boolean bool;
	private ArrayList<CompteClient> listeComptesClients;
	protected Connection connect = null;
	protected Statement statement = null;
	protected ResultSet resultSet = null;
	static Scanner sc = new Scanner(System.in);
	protected double montantMoyen=0.0;
	
	public ExtractionServicesDao(Connection conn) {
		this.connect = conn;
	}

	public ArrayList<CompteClient> listeComptes(Double montant)   {
		listeComptesClients = new ArrayList<>();
		boolean bool;
		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery("SELECT nom, age, montant,decouvertAutorise, plafondDecouvert FROM comptesclient A , client B where montant >= '"+montant+
				    "' and "+ " A.idClient = B.idClient"
			);
			while (resultSet.next()) {
				int age = Integer.parseInt(resultSet.getString("age"));
				Client newClient = new Client(resultSet.getString("nom"),age);
				double montant1 = Double.parseDouble(resultSet.getString("montant"));
				if (resultSet.getString("decouvertAutorise").equals("0"))
				{
					bool=false;
				}else {
					bool=true;
				}
				double plafond = Double.parseDouble(resultSet.getString("plafondDecouvert"));
				CompteClient comptesClients = new CompteClient(newClient, montant1,bool,plafond);
				listeComptesClients.add(comptesClients);
			}
			System.out.println("Liste des comptes clients dont le montant est supérieur à "+montant + ": ");			
			for (int i=0; i<listeComptesClients.size();i++)
			{
				System.out.println(listeComptesClients.get(i).toString());
			}
			resultSet.close();
     		statement.close();
			System.out.println();
		}			
		catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
//			resultSet.close();
//			statement.close();
		}
		return listeComptesClients;
	}
	
	public ArrayList<CompteClient> listeComptes(ArrayList<CompteClient> listeComptesClients, Double montant) {
		this.listeComptesClients = listeComptesClients;

		    System.out.println("Liste des comptes clients dont le montant est supérieur à "+montant + ": ");
			for (int i=0; i<listeComptesClients.size();i++)
			{
				if (listeComptesClients.get(i).getMontant() >= montant)
				{
					Client newClient = new Client(listeComptesClients.get(i).getClient().getNom(),listeComptesClients.get(i).getClient().getAge());
					double montant1 = listeComptesClients.get(i).getMontant();
					double plafond = listeComptesClients.get(i).getPlafondDecouvert();
					CompteClient comptesClients = new CompteClient(newClient, montant1,bool,plafond);
					this.listeComptesClients.add(comptesClients);
				}
				
			}
			System.out.println();
		return listeComptesClients;
		
		}			
			
	public ArrayList<CompteClient> listeComptesAge(int age1, int age2) {
		listeComptesClients = new ArrayList<>();
		boolean bool;
		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery("SELECT nom, age, montant,decouvertAutorise, plafondDecouvert FROM comptesclient A , client B where age >= '"+age1+
				    "' and age <= '"+age2+"' and A.idClient = B.idClient "
			);
			while (resultSet.next()) {
				int age3 = Integer.parseInt(resultSet.getString("age"));
				Client newClient = new Client(resultSet.getString("nom"),age3);
				double montant1 = Double.parseDouble(resultSet.getString("montant"));
				if (resultSet.getString("decouvertAutorise").equals("0"))
				{
					bool=false;
				}else {
					bool=true;
				}
				double plafond = Double.parseDouble(resultSet.getString("plafondDecouvert"));
				CompteClient comptesClients = new CompteClient(newClient, montant1,bool,plafond);
				listeComptesClients.add(comptesClients);
			}
			System.out.println("Liste des comptes clients dont l'age est compris entre "+age1 + " et "+age2);
			for (int i=0; i<listeComptesClients.size();i++)
			{
				System.out.println(listeComptesClients.get(i).toString());
			}
			resultSet.close();
			statement.close();
			System.out.println();
		}			
		catch (SQLException e) {
			e.printStackTrace();
		}		
		return listeComptesClients;
	}
	
	public ArrayList<CompteClient> listeComptesAge(ArrayList<CompteClient> listeComptesClients, int age1, int age2) {
			ArrayList<CompteClient> listeComptesClientsLocal = new ArrayList<>();

			System.out.println("Liste des comptes clients dont l'age est compris entre "+age1 + " et "+age2);
			for (int i=0; i<listeComptesClients.size();i++)
			{
				if (listeComptesClients.get(i).getClient().getAge() >= age1 && listeComptesClients.get(i).getClient().getAge() <= age2)
				{
					Client newClient = new Client(listeComptesClients.get(i).getClient().getNom(),listeComptesClients.get(i).getClient().getAge());
					double montant1 = listeComptesClients.get(i).getMontant();
					double plafond = listeComptesClients.get(i).getPlafondDecouvert();
					CompteClient comptesClients = new CompteClient(newClient, montant1,bool,plafond);
					listeComptesClientsLocal .add(comptesClients);
				}
				
			}
			for (int i=0; i<listeComptesClientsLocal .size();i++)
			{
				System.out.println(listeComptesClients.get(i).toString());
			}
			System.out.println();
		return listeComptesClientsLocal ;
		}	

	public double MoyenneComptes(ArrayList<CompteClient> listeComptesClients) {
		
		for (int i=0; i<listeComptesClients.size();i++)
		{
			montantMoyen += listeComptesClients.get(i).getMontant();							
		}
		return montantMoyen/(listeComptesClients.size());
			
		
	}

}
