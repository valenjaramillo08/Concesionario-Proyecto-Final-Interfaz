package co.edu.uniquindio.poo.model;

public class VehiculoElectrico extends Vehiculo {
    private double autonomia; // Autonomía en km
    private String tiempoRecarga;
    public VehiculoElectrico(String placa, String marca, String modelo, boolean nuevo, double autonomia, String tiempoRecarga, boolean tecnomecanica) {
        super(placa, marca, modelo, nuevo, TipoCombustible.ELECTRICO, TipoTransmision.AUTOMATICA, tecnomecanica);
        this.autonomia = autonomia;
        this.tiempoRecarga = tiempoRecarga;
    }
    public double getAutonomia() {
        return autonomia;
    }
    public void setAutonomia(double autonomia) {
        this.autonomia = autonomia;
    }
    public String getTiempoRecarga() {
        return tiempoRecarga;
    }
    public void setTiempoRecarga(String tiempoRecarga) {
        this.tiempoRecarga = tiempoRecarga;
    }
}