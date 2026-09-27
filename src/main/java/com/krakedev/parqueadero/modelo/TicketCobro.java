package com.krakedev.parqueadero.modelo;

import java.time.LocalDate;

public class TicketCobro {
    private String codigoTicket;
    private Vehiculo vehiculo;
    private int horas;
    private double totalPagar;
    private LocalDate fechaSalida;

    public TicketCobro(String codigoTicket, Vehiculo vehiculo, int horas, double totalPagar) {
        this.codigoTicket = codigoTicket;
        this.vehiculo = vehiculo;
        this.horas = horas;
        this.totalPagar = totalPagar;
        this.fechaSalida = LocalDate.now();
    }

    public String getCodigoTicket() {
        return codigoTicket;
    }

    public void setCodigoTicket(String codigoTicket) {
        this.codigoTicket = codigoTicket;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
}
