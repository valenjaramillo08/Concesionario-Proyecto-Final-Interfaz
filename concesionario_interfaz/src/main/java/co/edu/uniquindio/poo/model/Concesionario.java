package co.edu.uniquindio.poo.model;


public class Concesionario {
    public String nombre;
    public Administrador administrador;

    public Concesionario(String nombre, Administrador administrador) {
        this.nombre = nombre;
        this.administrador = administrador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Administrador autenticar(String nombreUsuario, String contrasena) {

        if (administrador.verificarCredenciales(nombreUsuario, contrasena)) {
            return administrador;
        }

        return null; // Si no se encuentra el usuario
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

}
