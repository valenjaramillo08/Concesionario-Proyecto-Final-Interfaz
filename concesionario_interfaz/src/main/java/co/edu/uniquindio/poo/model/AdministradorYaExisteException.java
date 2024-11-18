package co.edu.uniquindio.poo.model;

public class AdministradorYaExisteException extends Exception {
    public AdministradorYaExisteException(String mensaje) {
        super(mensaje);
    }
}