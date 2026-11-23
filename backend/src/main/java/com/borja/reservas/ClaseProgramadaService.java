package com.borja.reservas;


import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
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

}
