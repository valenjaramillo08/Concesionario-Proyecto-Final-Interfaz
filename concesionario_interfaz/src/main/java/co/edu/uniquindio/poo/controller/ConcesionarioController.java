package co.edu.uniquindio.poo.controller;


import co.edu.uniquindio.poo.model.Administrador;
import co.edu.uniquindio.poo.model.Concesionario;

public class ConcesionarioController {
    Concesionario concesionario;

    public ConcesionarioController(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public String getNombre() {
        return concesionario.getNombre();
    }


    public Administrador autenticar(String nombreUsuario, String contrasena) {
        return concesionario.autenticar(nombreUsuario, contrasena);
    }

    public Administrador getAdministrador() {
        return concesionario.getAdministrador();
    }

    public void setAdministrador(Administrador administrador) {
        concesionario.setAdministrador(administrador);
    }

    

    
}
