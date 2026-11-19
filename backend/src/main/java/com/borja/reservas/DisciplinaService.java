package com.borja.reservas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Disciplina> buscarPorId(long id){

        List<Disciplina> disciplinas = listarDisciplinas();
        for(int i=0; i<disciplinas.size();i++){
            Disciplina disciplina = disciplinas.get(i);
            if(disciplina.getId() == id){
                return Optional.of(disciplina);
            }
        }
        return Optional.empty();
    }

}
