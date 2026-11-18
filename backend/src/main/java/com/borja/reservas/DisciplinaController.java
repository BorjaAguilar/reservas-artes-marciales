package com.borja.reservas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DisciplinaController {

    @GetMapping("/api/disciplinas")
    public List<String> listarDisciplinas(){
        List<String> disciplinas = List.of("Boxeo", "Muay Thai", "BJJ gi", "BJJ no gi", "MMA");
        return disciplinas;
    }
}
