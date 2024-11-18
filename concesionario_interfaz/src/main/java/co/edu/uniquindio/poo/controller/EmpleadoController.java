package co.edu.uniquindio.poo.controller;

import java.time.LocalDate;
import java.util.Collection;

import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.ClienteYaExisteException;
import co.edu.uniquindio.poo.model.Empleado;
import co.edu.uniquindio.poo.model.Transaccion;
import co.edu.uniquindio.poo.model.TransaccionInvalidaException;
import co.edu.uniquindio.poo.model.Vehiculo;
import co.edu.uniquindio.poo.model.VehiculoNoEncontradoException;
import co.edu.uniquindio.poo.model.VehiculoYaExisteException;

public class EmpleadoController {
    Empleado empleado;

    

    public EmpleadoController(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getNombre() {
        return empleado.getNombre();
    }

    public String getClave() {
        return empleado.getClave();
    }

    public boolean isActivo() {
        return empleado.isActivo();
    }

    public String getPreguntaSeguridad() {
        return empleado.getPreguntaSeguridad();
    }

    public int getIdEmpleado() {
        return empleado.getIdEmpleado();
    }

    public String getRespuestaSeguridad() {
        return empleado.getRespuestaSeguridad();
    }

    public String getTipoUsuario() {
        return empleado.getTipoUsuario();
    }

    public Collection<Vehiculo> getVehiculos() {
        return empleado.getVehiculos();
    }

    public double getSalario() {
        return empleado.getSalario();
    }

    public Collection<Cliente> getClientes() {
        return empleado.getClientes();
    }

    public Collection<Transaccion> getTransacciones() {
        return empleado.getTransacciones();
    }

    public String toString() {
        return empleado.toString();
    }

    public boolean verificarVehiculo(String placa) {
        return empleado.verificarVehiculo(placa);
    }

    public void agregarVehiculo(Vehiculo vehiculo) throws VehiculoYaExisteException {
        empleado.agregarVehiculo(vehiculo);
    }

    public boolean verificarCliente(String idCliente) {
        return empleado.verificarCliente(idCliente);
    }

    public boolean agregarCliente(Cliente cliente) throws ClienteYaExisteException {
        return empleado.agregarCliente(cliente);
    }

    public boolean realizarVenta(Vehiculo vehiculo, LocalDate fechaTransaccion, Cliente cliente)
            throws VehiculoNoEncontradoException, TransaccionInvalidaException {
        return empleado.realizarVenta(vehiculo, fechaTransaccion, cliente);
    }

    public boolean realizarCompra(Vehiculo vehiculo, LocalDate fechaTransaccion, Cliente cliente)
            throws VehiculoYaExisteException, TransaccionInvalidaException {
        return empleado.realizarCompra(vehiculo, fechaTransaccion, cliente);
    }

    public boolean realizarAlquiler(Vehiculo vehiculo, LocalDate fechaTransaccion, LocalDate fechaFinal,
            Cliente cliente) throws VehiculoNoEncontradoException, TransaccionInvalidaException {
        return empleado.realizarAlquiler(vehiculo, fechaTransaccion, fechaFinal, cliente);
    }

    public boolean verificarCredenciales(String nombreUsuario, String contrasena) {
        return empleado.verificarCredenciales(nombreUsuario, contrasena);
    }

    public boolean cambiarClave(String claveActual, String nuevaClave) {
        return empleado.cambiarClave(claveActual, nuevaClave);
    }

    public String recuperarClave(String respuesta) {
        return empleado.recuperarClave(respuesta);
    }

    public boolean actualizarCliente(String cedula, Cliente actualizado) {
        return empleado.actualizarCliente(cedula, actualizado);
    }

    public boolean eliminarCliente(String cedula) {
        return empleado.eliminarCliente(cedula);
    }

    
    
}
