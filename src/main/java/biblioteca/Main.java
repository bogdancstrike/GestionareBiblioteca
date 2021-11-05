package biblioteca;

import biblioteca.controller.exceptions.DataEsteGresita;
import biblioteca.controller.exceptions.NiciunRezultatGasit;
import biblioteca.controller.exceptions.UtilizatorInexistent;
import biblioteca.model.Carte;
import biblioteca.model.Client;
import biblioteca.model.GestionareClient;
import biblioteca.controller.Utils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Utils utils = new Utils();
		Scanner sc = new Scanner(System.in);
		Date today = new Date();
		int counter;

		ArrayList<Client> clienti = new ArrayList<>();
		ArrayList<Carte> carti = new ArrayList<>();
		ArrayList<GestionareClient> gestionareClienti = new ArrayList<>();

		ObjectMapper objectMapper = new ObjectMapper();
		clienti = objectMapper.readValue(new File("clientiFile.txt"), new TypeReference<ArrayList<Client>>(){});
		carti = objectMapper.readValue(new File("cartiFile.txt"), new TypeReference<ArrayList<Carte>>(){});
		//gestionareClienti = objectMapper.readValue(new File("gestiuneClientiFile.txt"), new TypeReference<ArrayList<GestionareClient>>(){});

		while(true){
			try {
				System.out.println("Introduceti comanda:");
				String comanda = sc.nextLine();
				String[] arguments = comanda.split(" ");

				switch (arguments[0]) {
					case "afisare_comenzi":
						System.out.println("creare_client cnp nume varsta");
						System.out.println("creare_carte idCarte nume autor colectie editura");

						System.out.println("\n");

						System.out.println("afisare_clienti");
						System.out.println("afisare_carti");

						System.out.println("\n");

						System.out.println("gestionare_client cnp idCarte dataDeCand dataPanaCand");
						System.out.println("afisare_gestionare");
						System.out.println("afisare_gestionare_client cnp");

						System.out.println("\n");

						System.out.println("afisare_carti_dupa_autor autor");
						System.out.println("afisare_carti_dupa_editura editura");
						System.out.println("afisare_carti_dupa_colectie colectie");

						System.out.println("\n");

						System.out.println("carti_imprumutate_de_la data");
						System.out.println("carti_imprumutate_pana_la data");

						System.out.println("\n");

						System.out.println("sterge_carte idCarte");
						System.out.println("sterge_client cnp");

						System.out.println("\n");
						break;
					case "creare_client":
						Client client = utils.creareClient(arguments[1], arguments[2], Integer.parseInt(arguments[3]));
						clienti.add(client);
						break;

					case "creare_carte":
						Carte carte = utils.creareCarte(Integer.parseInt(arguments[1]), arguments[2], arguments[3], arguments[4], arguments[5]);
						carti.add(carte);
						break;

					case "gestionare_client":
						Carte carteImprumutata = null;
						Client clientImprumuta = null;
						Date imprumutatDeLa=new SimpleDateFormat("dd/MM/yyyy").parse(arguments[3]);
						Date imprumutatPanaLa=new SimpleDateFormat("dd/MM/yyyy").parse(arguments[4]);

						if (imprumutatPanaLa.before(imprumutatDeLa)){
							throw new DataEsteGresita();
						}

						for (Client c : clienti){
							if (c.getCnp().equals(arguments[1])){
								clientImprumuta = c;
							}
						}

						for (Carte c : carti){
							if (c.getIdCarte() == Integer.parseInt(arguments[2])){
								carteImprumutata = c;
							}
						}

						GestionareClient gestionareClient = utils.gestionareClient(clientImprumuta, carteImprumutata, imprumutatDeLa, imprumutatPanaLa);
						gestionareClienti.add(gestionareClient);
						break;

					case "afisare_clienti":
						if (clienti.size() == 0) throw new NiciunRezultatGasit();
						for (Client c : clienti) {
							System.out.println(c);
						}
						break;

					case "afisare_carti":
						if (carti.size() == 0) throw new NiciunRezultatGasit();
						for (Carte c : carti) {
							System.out.println(c);
						}
						break;

					case "afisare_carti_dupa_editura":
						counter = 0;
						String editura = arguments[1];
						for (Carte c : carti) {
							if (c.getEditura().equals(editura)) {
								System.out.println(c);
								counter++;
							}
						}
						if (counter == 0) throw new NiciunRezultatGasit();
						break;

					case "afisare_carti_dupa_autor":
						counter = 0;
						String autor = arguments[1];
						for (Carte c : carti) {
							if (c.getAutor().equals(autor)) {
								System.out.println(c);
								counter++;
							}
						}
						if (counter == 0) throw new NiciunRezultatGasit();
						break;

					case "afisare_carti_dupa_colectie":
						counter = 0;
						String colectie = arguments[1];
						for (Carte c : carti) {
							if (c.getColectie().equals(colectie)) {
								System.out.println(c);
								counter++;
							}
						}
						if (counter == 0) throw new NiciunRezultatGasit();
						break;

					case "afisare_gestionare_client":
						counter = 0;
						for (GestionareClient gc : gestionareClienti){
							if (gc.getClient().getCnp().equals(arguments[1])){
								System.out.println(gc);
								counter++;
							}
						}
						if (counter == 0) throw new NiciunRezultatGasit();
						break;

					case "afisare_gestionare":
						counter = 0;
						for (GestionareClient gc : gestionareClienti){
							System.out.println(gc);
							counter++;
						}
						if (counter == 0) throw new NiciunRezultatGasit();
						break;

					case "carti_imprumutate_de_la": //BUG: NPE
						counter = 0;
						for (GestionareClient gc : gestionareClienti){
							for (Carte carteCurenta : carti){
								if (gc.getImprumutatDeLa().get(carteCurenta).after(new SimpleDateFormat("dd/MM/yyyy").parse(arguments[1]))){
									System.out.println(gc);
									counter++;
								}
							}
						}
						if (counter == 0) throw new NiciunRezultatGasit();
						break;

					case "carti_imprumutate_pana_la": //BUG: NPE
						counter = 0;
						for (GestionareClient gc : gestionareClienti){
							for (Carte carteCurenta : carti){
								if (gc.getImprumutatDeLa().get(carteCurenta).before(new SimpleDateFormat("dd/MM/yyyy").parse(arguments[1]))){
									System.out.println(gc);
									counter++;
								}
							}
						}
						if (counter == 0) throw new NiciunRezultatGasit();
						break;

					case "sterge_client":
						for (Iterator<Client> iterator = clienti.iterator(); iterator.hasNext();) {
							Client c = iterator.next();
							if(c.getCnp().equals(arguments[1])) {
								iterator.remove();
							}
						}
						break;

					case "sterge_carte":
						for (Iterator<Carte> iterator = carti.iterator(); iterator.hasNext();) {
							Carte c = iterator.next();
							 if (c.getIdCarte() == Integer.parseInt(arguments[1])){
							 	iterator.remove();
							 }
						}
						break;

					case "exit":
						FileWriter clientiFile = new FileWriter("clientiFile.txt");
						clientiFile.write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(clienti));
						clientiFile.close();

						FileWriter cartiFile = new FileWriter("cartiFile.txt");
						cartiFile.write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(carti));
						cartiFile.close();

						FileWriter gestiuneClientiFile = new FileWriter("gestiuneClientiFile.txt");
						gestiuneClientiFile.write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(gestionareClienti));
						gestiuneClientiFile.close();

						System.out.println("\n\nDatele au fost salvate");
						System.exit(0);
						break;

					default:
						System.out.println("Comanda invalida. Reintroduceti comanda!");
				}
			} catch (NullPointerException | NiciunRezultatGasit | NumberFormatException | ParseException | ArrayIndexOutOfBoundsException | DataEsteGresita | IOException e) {
				e.printStackTrace();
			}
		}
	}
}
