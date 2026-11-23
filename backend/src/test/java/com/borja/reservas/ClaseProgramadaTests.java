package com.borja.reservas;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClaseProgramadaTests {

    @Test
    public void calculaElFinalSinModificarElPrincipio(){
        ClaseProgramada clase = new ClaseProgramada(
                101L, 1L, LocalDate.of(2026, 11, 23), LocalTime.of(19, 45)
        );

        LocalTime horaFin = clase.getHoraFin();

        assertEquals(LocalTime.of(21, 15), horaFin);
        assertEquals(LocalTime.of(19, 45), clase.getHoraInicio());
    }

    @Test
    public void tieneCapacidadDeTreintaPlazas(){
        ClaseProgramada clase = new ClaseProgramada(
                101L, 1L, LocalDate.of(2026, 11, 23), LocalTime.of(19, 45)
        );

        assertEquals(30, clase.getCapacidad());
    }

}
