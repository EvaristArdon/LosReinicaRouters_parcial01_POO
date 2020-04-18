package com.EAAA.x00361518;

public class Documento {
    private String nombre="";
    private String número="";

    public Documento(String nombre, String número) {
        this.nombre = nombre;
        this.número = número;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNúmero() {
        return número;
    }
}
