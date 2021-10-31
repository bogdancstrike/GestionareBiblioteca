package biblioteca.controller;


import biblioteca.model.Carte;
import biblioteca.model.Client;
import biblioteca.model.GestionareClient;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Utils {
	public Utils(){

	}

	public Client creareClient(String cnp, String nume, int varsta){
		Client client = new Client(cnp, nume, varsta);
		return client;
	}

	public Carte creareCarte(int idCarte, String nume, String autor, String colectie, String editura){
		Carte carte = new Carte(idCarte, nume, autor, colectie, editura);
		return carte;
	}

	public GestionareClient gestionareClient(Client client, Carte carteImprumutata, Date imprumutatDeLa, Date imprumutatPanaLa){
		ArrayList<Carte> carti = new ArrayList<>();
		carti.add(carteImprumutata);

		HashMap<Carte, Date> deLa = new HashMap<>();
		deLa.put(carteImprumutata, imprumutatDeLa);

		HashMap<Carte, Date> panaLa = new HashMap<>();
		panaLa.put(carteImprumutata, imprumutatPanaLa);

		GestionareClient gestionareClient = new GestionareClient(client, carti, deLa, panaLa);
		return gestionareClient;
	}

}