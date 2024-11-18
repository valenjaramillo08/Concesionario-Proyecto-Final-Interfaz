package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Alquiler extends Transaccion{
    public LocalDate fechaFinal;

    

    public Alquiler(int idTransaccion, LocalDate fechaTransaccion, Vehiculo vehiculo, Cliente cliente, LocalDate fechaFinal) {
        super(idTransaccion, fechaTransaccion, vehiculo, cliente);
        this.fechaFinal = fechaFinal;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
}
