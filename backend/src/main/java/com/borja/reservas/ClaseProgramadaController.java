package com.borja.reservas;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ClaseProgramadaController {

    private final ClaseProgramadaService claseProgramadaService;

    public ClaseProgramadaController(ClaseProgramadaService claseProgramadaService){
        this.claseProgramadaService = claseProgramadaService;
    }

    @GetMapping("/api/clases")
    public ResponseEntity<List<ClaseProgramada>> listarClases(
            @RequestParam(name = "desde", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate desde,

            @RequestParam(name = "hasta", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate hasta
    ){

        if(desde == null && hasta == null){
            return ResponseEntity.ok(claseProgramadaService.listarClases());
        }

        if(desde == null || hasta == null){
            return ResponseEntity.badRequest().build();
        }

        if(desde.isAfter(hasta)){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(
                claseProgramadaService.listarClasesEntre(desde, hasta)
        );
    }
}
