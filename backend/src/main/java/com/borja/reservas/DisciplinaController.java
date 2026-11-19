package com.borja.reservas;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/api/disciplinas/{id}")
    public ResponseEntity<Disciplina> buscarPorId(@PathVariable("id") long id){

        Optional<Disciplina> resultado = disciplinaService.buscarPorId(id);
        if(resultado.isPresent()){
            return ResponseEntity.ok(resultado.get());
        }
        return ResponseEntity.notFound().build();
    }

}
