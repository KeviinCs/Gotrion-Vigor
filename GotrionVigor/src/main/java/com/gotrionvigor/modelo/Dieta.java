package com.gotrionvigor.modelo;

public class Dieta {
    private int id;
    private String nombre;
    private String descripcion;
    private String tipousuario;

    public Dieta(int id, String nombre, String descripcion, String tipousuario){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipousuario = tipousuario;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public String getTipousuario() { return tipousuario; }

    public void setId(int id) {this.id = id;}
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setTipousuario(String tipousuario) { this.tipousuario = tipousuario; }
}