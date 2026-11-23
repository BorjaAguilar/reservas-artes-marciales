package com.borja.reservas;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClaseProgramadaController {

    private final ClaseProgramadaService claseProgramadaService;

    public ClaseProgramadaController(ClaseProgramadaService claseProgramadaService){
        this.claseProgramadaService = claseProgramadaService;
    }

    @GetMapping("/api/clases")
    public List<ClaseProgramada> listarClases(){
        return claseProgramadaService.listarClases();
    }
}
