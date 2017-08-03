package com.clients;


import java.util.ArrayList;

import com.connection.MySqlConnection;
import com.services.ExtractionServicesDao;
import com.services.TriServices;

public class ApplicationCompte {

	public static void main(String[] args) {
		MySqlConnection conn = new MySqlConnection();
		ExtractionServicesDao monExtractionServicesDao = new ExtractionServicesDao(conn.getInstance());
//		monExtractionServicesDao.listeComptes(1500.0);
//		monExtractionServicesDao.listeComptesAge(20,58);
		System.out.println(monExtractionServicesDao.MoyenneComptes(monExtractionServicesDao.listeComptes(9000.0)));
		monExtractionServicesDao.listeComptes(5000.0);
		System.out.println("dddddd");
		monExtractionServicesDao.listeComptesAge(monExtractionServicesDao.listeComptes(5000.0),30,50);
		TriServices monTriService = new TriServices(conn.getInstance());
		System.out.println("eeeeee");
		//monTriService.listeComptesDesc(monExtractionServicesDao.listeComptes(5000.0));
		monTriService.listeComptesDesc();
	}

}
