package biblioteca.model;

import java.util.Objects;

public class Client{
	public String cnp;
	public String nume;
	public int varsta;

	public Client() {

	}

	public String getCnp() {
		return cnp;
	}

	public Client(String cnp, String nume, int varsta) {
		this.cnp = cnp;
		this.nume = nume;
		this.varsta = varsta;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public int getVarsta() {
		return varsta;
	}

	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Client client = (Client) o;
		return varsta == client.varsta && Objects.equals(cnp, client.cnp) && Objects.equals(nume, client.nume);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnp, nume, varsta);
	}

	@Override
	public String toString() {
		return "Client{" +
				"cnp='" + cnp + '\'' +
				", nume='" + nume + '\'' +
				", varsta=" + varsta +
				'}';
	}
}
