package com.normapp.Entidades;

public class Preguntas {
    private String nombre;
    private String descripcion;
    private int imagenid;


    public  Preguntas (){}
    public Preguntas(String nombre, String descripcion, int imagenid) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenid = imagenid;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getImagenid() {
        return imagenid;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setImagenid(int imagenid) {
        this.imagenid = imagenid;
    }
}
