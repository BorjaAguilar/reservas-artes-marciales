package com.borja.reservas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DisciplinaController {

    @GetMapping("/api/disciplinas")
    public List<Disciplina> listarDisciplinas(){
        List<Disciplina> disciplinas = List.of(
                new Disciplina(1L, "Boxeo"),
                new Disciplina(2L, "Muay Thai"),
                new Disciplina(3L, "BJJ gi"),
                new Disciplina(4L, "BJJ no gi"),
                new Disciplina(5L, "MMA"));
        return disciplinas;
    }
}
