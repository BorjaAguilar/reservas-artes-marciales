package com.borja.reservas;

public class Disciplina {

    private long id;
    private String nombre;

    public Disciplina(long id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public long getId() {
        return this.id;
    }

    public String getNombre(){
        return this.nombre;
    }
}
