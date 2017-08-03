package com.services;


import java.util.ArrayList;
import java.util.Collections;
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


public class TriServices  {

	boolean bool;
	private ArrayList<CompteClient> listeComptesClients;
	protected Connection connect = null;
	protected Statement statement = null;
	protected ResultSet resultSet = null;
	static Scanner sc = new Scanner(System.in);
	protected double montantMoyen=0.0;
	
	public TriServices(Connection conn) {
		this.connect = conn;
	}

	public ArrayList<CompteClient> listeComptesDesc() {
		listeComptesClients = new ArrayList<>();
		boolean bool;
		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery("SELECT nom, age, montant,decouvertAutorise, plafondDecouvert FROM comptesclient A , client B" 
				    + " where A.idClient = B.idClient ORDER BY montant DESC"
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
			System.out.println("Liste des comptes clients par ordre décroissant des montants :");
			for (int i=0; i<listeComptesClients.size();i++)
			{
				System.out.println(listeComptesClients.get(i).toString());
//				System.out.println("Client : " + listeComptesClients.get(i).getClient().getNom()+" "+listeComptesClients.get(i).getClient().getAge()+" "+ listeComptesClients.get(i).getMontant()+ " "+
//						listeComptesClients.get(i).isDecouvertAutorise()+ " " +listeComptesClients.get(i).getPlafondDecouvert());			
			}
			resultSet.close();
			statement.close();
		}			
		catch (SQLException e) {
			e.printStackTrace();
		}		
		return listeComptesClients;
	}
	
	public void listeComptesDesc(ArrayList<CompteClient> listeComptesClients) {
	
		//System.out.println(Collections.sort(listeComptesClients, Collections.reverseOrder()));
//		Collections.reverse(listeComptesClients);
//		for (int i=0; i<listeComptesClients.size();i++)
//		{
//			System.out.println("Client : " + listeComptesClients.get(i).getClient().getNom()+" "+listeComptesClients.get(i).getClient().getAge()+" "+ listeComptesClients.get(i).getMontant()+ " "+
//					listeComptesClients.get(i).isDecouvertAutorise()+ " " +listeComptesClients.get(i).getPlafondDecouvert());			
//		}
//		
		}						

}
