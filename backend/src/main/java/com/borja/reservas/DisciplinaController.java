package com.borja.reservas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @GetMapping("/api/disciplinas")
    public List<Disciplina> listarDisciplinas() {
        return disciplinaService.listarDisciplinas();
    }
}
