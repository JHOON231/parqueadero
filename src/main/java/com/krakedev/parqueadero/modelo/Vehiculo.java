package com.krakedev.parqueadero.modelo;

import java.time.LocalDateTime;

public abstract class Vehiculo {
    private String placa;
    private String propietario;
    private LocalDateTime horaIngreso;

    // Asegúrate de que este constructor exista:
    public Vehiculo(String placa, String propietario) {
        this.placa = placa;
        this.propietario = propietario;
        this.horaIngreso = LocalDateTime.now();
    }

    public abstract double calcularTarifa(int horasPermanencia);

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public LocalDateTime getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(LocalDateTime horaIngreso) {
        this.horaIngreso = horaIngreso;
    }
}
