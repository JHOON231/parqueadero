package com.krakedev.parqueadero.controladores;

import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.krakedev.parqueadero.modelo.TicketCobro;
import com.krakedev.parqueadero.servicios.ServicioCobro;

@RestController
@RequestMapping("/cobros")
public class CobroController {

    private final ServicioCobro servicioCobro;

    
    public CobroController(ServicioCobro servicioCobro) {
        this.servicioCobro = servicioCobro;
    }

    @PostMapping("/procesar/{placa}/{horas}")
    public ResponseEntity<TicketCobro> procesarSalida(@PathVariable String placa, @PathVariable int horas) {
        TicketCobro ticket = servicioCobro.procesarSalida(placa, horas);
        if (ticket != null) {
            return ResponseEntity.ok(ticket);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/total")
    public ResponseEntity<Double> getTotalRecaudado() {
        return ResponseEntity.ok(servicioCobro.calcularTotalRecaudado());
    }

    @GetMapping("/historial")
    public ArrayList<TicketCobro> getHistorial() {
        return servicioCobro.listarTickets();
    }
}
