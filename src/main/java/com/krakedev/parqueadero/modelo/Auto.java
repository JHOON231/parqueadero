package com.krakedev.parqueadero.modelo;

public class Auto extends Vehiculo {
    private int numeroPuertas;

    public Auto(String placa, String propietario, int numeroPuertas) {
        super(placa, propietario);
        this.numeroPuertas = numeroPuertas;
    }

    @Override
    public double calcularTarifa(int horasPermanencia) {
        double tarifa = horasPermanencia * 1.50;
        if (horasPermanencia > 4) {
            tarifa += 2.00;
        }
        return tarifa;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }
}