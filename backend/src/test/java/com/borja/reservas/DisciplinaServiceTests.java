package com.borja.reservas;

import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DisciplinaServiceTests {

    @Test
    public void devuelveMmaCuandoBuscaElIdCinco(){
        DisciplinaService servicio = new DisciplinaService();

        Optional<Disciplina> resultado = servicio.buscarPorId(5L);

        assertTrue(resultado.isPresent());
        assertEquals(5L, resultado.get().getId());
        assertEquals("MMA", resultado.get().getNombre());
    }

    @Test
    public void devuelveVacioCuandoElIdNoExiste(){
        DisciplinaService servicio = new DisciplinaService();

        Optional<Disciplina> resultado = servicio.buscarPorId(999L);

        assertTrue(resultado.isEmpty());
    }
}
