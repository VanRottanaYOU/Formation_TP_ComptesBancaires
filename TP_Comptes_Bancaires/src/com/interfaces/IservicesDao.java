package com.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import com.clients.CompteClient;

public interface IservicesDao {
	
	ArrayList<CompteClient> listeComptes(Double montant);
	ArrayList<CompteClient> listeComptesAge(int age1, int age2);
	double MoyenneComptes(ArrayList<CompteClient> listeComptesClients);
}
