package com.borja.reservas;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ClaseProgramadaServiceTests {

    @Test
    void incluyeLasClasesCuandoAmbasFechasCoincidenConSuDia(){
        ClaseProgramadaService servicio = new ClaseProgramadaService();

        List<ClaseProgramada> resultado = servicio.listarClasesEntre(
                LocalDate.of(2026, 11, 23),
                LocalDate.of(2026, 11, 23)
        );

        assertEquals(3, resultado.size());
    }

    @Test
    void devuelveListaVaciaCuandoNoHayClasesEnElIntervalo(){
        ClaseProgramadaService servicio = new ClaseProgramadaService();

        List<ClaseProgramada> resultado = servicio.listarClasesEntre(
                LocalDate.of(2026, 11, 24),
                LocalDate.of(2026,11,30)
        );

        assertTrue(resultado.isEmpty());
    }

    @Test
    void rechazaUnIntervaloConLaFechaInicialPostereiorALaFinal(){
        ClaseProgramadaService servicio = new ClaseProgramadaService();

        assertThrows(
                IllegalArgumentException.class,
                () -> servicio.listarClasesEntre(
                        LocalDate.of(2026, 11, 24),
                        LocalDate.of(2026, 11, 23)
                )
        );
    }
}
