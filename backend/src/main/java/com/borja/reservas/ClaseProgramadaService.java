package com.borja.reservas;


import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClaseProgramadaService {

    public List<ClaseProgramada> listarClases(){
        return List.of(
                new ClaseProgramada(
                        101L,
                        1L,
                        LocalDate.of(2026, 11, 23),
                        LocalTime.of(18,0)
                ),
                new ClaseProgramada(
                        102,
                        2L,
                        LocalDate.of(2026, 11, 23),
                        LocalTime.of(18, 0)
                ),
                new ClaseProgramada(
                        103,
                        3L,
                        LocalDate.of(2026, 11, 23),
                        LocalTime.of(19, 30)
                )
        );

    }

    public List<ClaseProgramada> listarClasesEntre(LocalDate desde, LocalDate hasta){

        if(desde.isAfter(hasta)){
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin");
        }

        List<ClaseProgramada> resultado = new ArrayList<>();
        List<ClaseProgramada> clases = listarClases();

        for(int i = 0; i < clases.size(); i++){
            ClaseProgramada clase = clases.get(i);
            LocalDate fecha = clase.getFecha();

            if(!fecha.isBefore(desde) && !fecha.isAfter(hasta)){
                resultado.add(clase);
            }
        }

        return resultado;
    }

}
