package com.krakedev.parqueadero.modelo;

public class Motocicleta extends Vehiculo {
    private int cilindraje;

    public Motocicleta(String placa, String propietario, int cilindraje) {
        super(placa, propietario);
        this.cilindraje = cilindraje;
    }

    @Override
    public double calcularTarifa(int horasPermanencia) {
        double tarifaPorHora = (this.cilindraje > 250) ? 1.00 : 0.75;
        return horasPermanencia * tarifaPorHora;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }
}
