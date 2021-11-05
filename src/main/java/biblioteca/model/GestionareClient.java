package biblioteca.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

public class GestionareClient extends Client{
	private ArrayList<Carte> cartiImprumutate;
	private HashMap<Carte, Date> imprumutatDeLa;
	private HashMap<Carte, Date> imprumutatPanaLa;
	Client client = new Client();

	public GestionareClient(){

	}

	public GestionareClient(ArrayList<Carte> cartiImprumutate, HashMap<Carte, Date> imprumutatDeLa, HashMap<Carte, Date> imprumutatPanaLa, Client client) {
		this.cartiImprumutate = cartiImprumutate;
		this.imprumutatDeLa = imprumutatDeLa;
		this.imprumutatPanaLa = imprumutatPanaLa;
		this.client = client;
	}

	public GestionareClient(String cnp, String nume, int varsta, ArrayList<Carte> cartiImprumutate, HashMap<Carte, Date> imprumutatDeLa, HashMap<Carte, Date> imprumutatPanaLa, Client client) {
		super(cnp, nume, varsta);
		this.cartiImprumutate = cartiImprumutate;
		this.imprumutatDeLa = imprumutatDeLa;
		this.imprumutatPanaLa = imprumutatPanaLa;
		this.client = client;
	}

	public GestionareClient(String cnp, String nume, int varsta, ArrayList<Carte> cartiImprumutate, HashMap<Carte, Date> imprumutatDeLa, HashMap<Carte, Date> imprumutatPanaLa) {
		super(cnp, nume, varsta);
		this.cartiImprumutate = cartiImprumutate;
		this.imprumutatDeLa = imprumutatDeLa;
		this.imprumutatPanaLa = imprumutatPanaLa;
	}

	public GestionareClient(Client client, ArrayList<Carte> cartiImprumutate, HashMap<Carte, Date> imprumutatDeLa, HashMap<Carte, Date> imprumutatPanaLa) {
		this.client = client;
		this.cartiImprumutate = cartiImprumutate;
		this.imprumutatDeLa = imprumutatDeLa;
		this.imprumutatPanaLa = imprumutatPanaLa;
	}

	public ArrayList<Carte> getCartiImprumutate() {
		return cartiImprumutate;
	}

	public Client getClient(){
		return client;
	}

	public void setCartiImprumutate(ArrayList<Carte> cartiImprumutate) {
		this.cartiImprumutate = cartiImprumutate;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public HashMap<Carte, Date> getImprumutatDeLa() {
		return imprumutatDeLa;
	}

	public void setImprumutatDeLa(HashMap<Carte, Date> imprumutatDeLa) {
		this.imprumutatDeLa = imprumutatDeLa;
	}

	public HashMap<Carte, Date> getImprumutatPanaLa() {
		return imprumutatPanaLa;
	}

	public void setImprumutatPanaLa(HashMap<Carte, Date> imprumutatPanaLa) {
		this.imprumutatPanaLa = imprumutatPanaLa;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		GestionareClient that = (GestionareClient) o;
		return Objects.equals(cartiImprumutate, that.cartiImprumutate) && Objects.equals(imprumutatDeLa, that.imprumutatDeLa) && Objects.equals(imprumutatPanaLa, that.imprumutatPanaLa);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), cartiImprumutate, imprumutatDeLa, imprumutatPanaLa);
	}

	@Override
	public String toString() {
		return "GestionareClient{" +
				client +
				", cartiImprumutate= " + cartiImprumutate +
				", imprumutatDeLa= " + imprumutatDeLa +
				", imprumutatPanaLa= " + imprumutatPanaLa +
				'}';
	}
}
