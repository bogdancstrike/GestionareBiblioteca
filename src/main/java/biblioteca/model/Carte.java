package biblioteca.model;

import java.util.Objects;

public class Carte {
	private int idCarte;
	private String nume;
	private String autor;
	private String colectie;
	private String editura;

	public Carte(){

	}
	public Carte(int idCarte, String nume, String autor, String colectie, String editura) {
		this.idCarte = idCarte;
		this.nume = nume;
		this.autor = autor;
		this.colectie = colectie;
		this.editura = editura;
	}

	public int getIdCarte() {
		return idCarte;
	}

	public void setIdCarte(int idCarte) {
		this.idCarte = idCarte;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getColectie() {
		return colectie;
	}

	public void setColectie(String colectie) {
		this.colectie = colectie;
	}

	public String getEditura() {
		return editura;
	}

	public void setEditura(String editura) {
		this.editura = editura;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Carte carte = (Carte) o;
		return idCarte == carte.idCarte && Objects.equals(nume, carte.nume) && Objects.equals(autor, carte.autor) && Objects.equals(colectie, carte.colectie) && Objects.equals(editura, carte.editura);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCarte, nume, autor, colectie, editura);
	}

	@Override
	public String toString() {
		return "Carte{" +
				"idCarte=" + idCarte +
				", nume='" + nume + '\'' +
				", autor='" + autor + '\'' +
				", colectie='" + colectie + '\'' +
				", editura='" + editura + '\'' +
				'}';
	}
}

