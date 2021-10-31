package biblioteca;

import biblioteca.controller.exceptions.NiciunRezultatGasit;
import biblioteca.controller.exceptions.UtilizatorInexistent;
import biblioteca.model.Carte;
import biblioteca.model.Client;
import biblioteca.model.GestionareClient;
import biblioteca.controller.Utils;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Utils utils = new Utils();
		Scanner sc = new Scanner(System.in);
		Date today = new Date();
		int counter;

		ArrayList<Client> clienti = new ArrayList<>();
		ArrayList<Carte> carti = new ArrayList<>();
		ArrayList<GestionareClient> gestionareClienti = new ArrayList<>();

		try{
			while (true) {
				System.out.println("Introduceti comanda:");
				String comanda = sc.nextLine();
				String[] arguments = comanda.split(" ");

				switch (arguments[0]){
					case "creare_client":
						Client client = utils.creareClient(arguments[1], arguments[2], Integer.parseInt(arguments[3]));
						clienti.add(client);
						break;
					case "creare_carte":
						Carte carte = utils.creareCarte(Integer.parseInt(arguments[1]), arguments[2], arguments[3], arguments[4], arguments[5]);
						carti.add(carte);
						break;
					case "gestionare_client":
						//GestionareClient gestionareClient = utils.gestionareClient(arguments[1], arguments[2], arguments[3], arguments[4]);
						break;
					case "afisare_clienti":
						if (clienti.size() == 0) throw new NiciunRezultatGasit();
						for (Client c : clienti){
							System.out.println(c);
						}
						break;
					case "afisare_carti":
						if (carti.size() == 0) throw new NiciunRezultatGasit();
						for (Carte c : carti){
							System.out.println(c);
						}
						break;
					case "afisare_carti_dupa_editura":
						counter = 0;
						String editura = arguments[1];
						for (Carte c: carti){
							if (c.getEditura().equals(editura)){
								System.out.println(c);
								counter++;
							}
						}
						if (counter == 0) throw new NiciunRezultatGasit();
						break;
					case "afisare_carti_dupa_autor":
						counter = 0;
						String autor = arguments[1];
						for (Carte c: carti){
							if (c.getAutor().equals(autor)){
								System.out.println(c);
								counter++;
							}
						}
						if (counter == 0) throw new NiciunRezultatGasit();
						break;
					case "afisare_carti_dupa_colectie":
						counter = 0;
						String colectie = arguments[1];
						System.out.println(colectie);
						for (Carte c: carti){
							if (c.getColectie().equals(colectie)){
								System.out.println(c);
								counter++;
							}
						}
						if (counter == 0) throw new NiciunRezultatGasit();
						break;
					case "exit":
						System.exit(0);
						break;
					default:
						System.out.println("Comanda invalida. Reintroduceti comanda!");
				}
			}
		} catch(NullPointerException | NiciunRezultatGasit e){
			e.printStackTrace();
		}
	}
}
