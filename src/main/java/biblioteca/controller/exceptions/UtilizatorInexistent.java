package biblioteca.controller.exceptions;

public class UtilizatorInexistent extends Exception {
	public UtilizatorInexistent(){
		super("Acest utilizator nu exista in baza de date!");
	}
}
