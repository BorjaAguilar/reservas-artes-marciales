package com.borja.reservas;

import java.time.LocalDate;
import java.time.LocalTime;

public class ClaseProgramada {
    private static final int DURACION_MINUTOS = 90;
    private static final int CAPACIDAD = 30;

    private long id;
    private long disciplinaId;
    private LocalDate fecha;
    private LocalTime horaInicio;


    public ClaseProgramada(long id, long disciplinaId, LocalDate fecha, LocalTime horaInicio){
        this.id = id;
        this.disciplinaId = disciplinaId;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
    }

    public long getId(){
        return this.id;
    }

    public long getDisciplinaId(){
        return this.disciplinaId;
    }

    public LocalDate getFecha(){
        return this.fecha;
    }

    public LocalTime getHoraInicio(){
        return this.horaInicio;
    }

    public int getCapacidad(){
        return CAPACIDAD;
    }

    //Devuelve una nueva hora con los minutos sumados
    public LocalTime getHoraFin(){
        return this.horaInicio.plusMinutes(DURACION_MINUTOS);
    }
}
