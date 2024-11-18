package co.edu.uniquindio.poo.model;

public class ClienteYaExisteException extends Exception {
    public ClienteYaExisteException(String mensaje) {
        super(mensaje);
    }
}