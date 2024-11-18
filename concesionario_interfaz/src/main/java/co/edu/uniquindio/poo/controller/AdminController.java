package co.edu.uniquindio.poo.controller;

import java.time.LocalDate;
import java.util.Collection;

import co.edu.uniquindio.poo.model.Administrador;
import co.edu.uniquindio.poo.model.Empleado;
import co.edu.uniquindio.poo.model.Transaccion;

public class AdminController {
    Administrador administrador;

    public AdminController(Administrador administrador) {
        this.administrador = administrador;
    }

    public String getTipoUsuario() {
        return administrador.getTipoUsuario();
    }

    public String toString() {
        return administrador.toString();
    }

    public String getNombre() {
        return administrador.getNombre();
    }

    public Collection<Empleado> getEmpleados() {
        return administrador.getEmpleados();
    }

    public String getClave() {
        return administrador.getClave();
    }

    public String getPreguntaSeguridad() {
        return administrador.getPreguntaSeguridad();
    }

    public boolean verificarEmpleado(int idEmpleado) {
        return administrador.verificarEmpleado(idEmpleado);
    }

    public String getRespuestaSeguridad() {
        return administrador.getRespuestaSeguridad();
    }

    public double getSalario() {
        return administrador.getSalario();
    }

    public void agregarEmpleado(Empleado empleado) {
        administrador.agregarEmpleado(empleado);
    }

    public Collection<Transaccion> reportePorEmpleado(LocalDate fechaReporteInicial, LocalDate fechaReporteFinal,
            Empleado miEmpleado) {
        return administrador.reportePorEmpleado(fechaReporteInicial, fechaReporteFinal, miEmpleado);
    }

    public boolean editarEmpleado(Empleado empleado) {
        return administrador.editarEmpleado(empleado);
    }

    public boolean bloqueoCuenta(int idEmpleado) {
        return administrador.bloqueoCuenta(idEmpleado);
    }

    public boolean verificarCredenciales(String nombreUsuario, String contrasena) {
        return administrador.verificarCredenciales(nombreUsuario, contrasena);
    }

    public boolean cambiarClave(String claveActual, String nuevaClave) {
        return administrador.cambiarClave(claveActual, nuevaClave);
    }

    public String recuperarClave(String respuesta) {
        return administrador.recuperarClave(respuesta);
    }

    public String obtenerPreguntaSeguridad() {
        return administrador.obtenerPreguntaSeguridad();
    }

    public Empleado autenticar(String nombreUsuario, String contrasena) {
        return administrador.autenticar(nombreUsuario, contrasena);
    }
    
    
}
