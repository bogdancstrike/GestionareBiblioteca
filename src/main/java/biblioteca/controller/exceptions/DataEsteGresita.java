package biblioteca.controller.exceptions;

import javax.xml.crypto.Data;

public class DataEsteGresita extends Exception{
    public DataEsteGresita(){super("Data imprumutarii trebuie sa fie inainte de data inapoierii");}
}
