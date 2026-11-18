package com.borja.reservas;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {

    public List<Disciplina> listarDisciplinas(){
        List<Disciplina> disciplinas = List.of(
                    new Disciplina(1L, "Boxeo"),
                    new Disciplina(2L, "Muay Thai"),
                    new Disciplina(3L, "BJJ gi"),
                    new Disciplina(4L, "BJJ no gi"),
                    new Disciplina(5L, "MMA")
        );
        return disciplinas;
    }
}
