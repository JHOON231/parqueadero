package com.krakedev.parqueadero.servicios;

import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.krakedev.parqueadero.modelo.Vehiculo;


public class ServicioVehiculos {
    private ArrayList<Vehiculo> parqueadero = new ArrayList<>();
    private final int CAPACIDAD_MAXIMA = 10;

    public Vehiculo buscarPorPlaca(String placa) {
        for (Vehiculo v : parqueadero) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }

    public boolean ingresarVehiculo(Vehiculo vehiculo) {
        if (parqueadero.size() >= CAPACIDAD_MAXIMA) {
            return false;
        }
        if (buscarPorPlaca(vehiculo.getPlaca()) != null) {
            return false;
        }
        return parqueadero.add(vehiculo);
    }

    public Vehiculo retirarVehiculo(String placa) {
        Vehiculo v = buscarPorPlaca(placa);
        if (v != null) {
            parqueadero.remove(v);
            return v;
        }
        return null;
    }

    public ArrayList<Vehiculo> listarVehiculos() {
        return parqueadero;
    }
}
