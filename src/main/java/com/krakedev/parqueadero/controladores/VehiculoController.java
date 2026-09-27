package com.krakedev.parqueadero.controladores;

import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.krakedev.parqueadero.modelo.Auto;
import com.krakedev.parqueadero.modelo.Motocicleta;
import com.krakedev.parqueadero.modelo.Vehiculo;
import com.krakedev.parqueadero.servicios.ServicioVehiculos;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    private final ServicioVehiculos servicioVehiculos;


    public VehiculoController(ServicioVehiculos servicioVehiculos) {
        this.servicioVehiculos = servicioVehiculos;
    }

    @PostMapping("/auto")
    public ResponseEntity<String> ingresarAuto(@RequestBody Auto auto) {
        boolean exito = servicioVehiculos.ingresarVehiculo(auto);
        if (exito) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Auto registrado correctamente.");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Cupo lleno o placa duplicada.");
    }

    @PostMapping("/moto")
    public ResponseEntity<String> ingresarMoto(@RequestBody Motocicleta moto) {
        boolean exito = servicioVehiculos.ingresarVehiculo(moto);
        if (exito) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Motocicleta registrada correctamente.");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Cupo lleno o placa duplicada.");
    }

    @GetMapping
    public ArrayList<Vehiculo> listarTodos() {
        return servicioVehiculos.listarVehiculos();
    }

    @GetMapping("/{placa}")
    public ResponseEntity<Vehiculo> buscarPorPlaca(@PathVariable String placa) {
        Vehiculo vehiculo = servicioVehiculos.buscarPorPlaca(placa);
        if (vehiculo != null) {
            return ResponseEntity.ok(vehiculo);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
