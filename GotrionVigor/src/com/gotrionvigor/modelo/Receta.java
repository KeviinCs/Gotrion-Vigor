package com.gotrionvigor.modelo;

public class Receta {
    private int id;
    private String nombre;
    private String ingredientes;
    private String instrucciones;

    public Receta(int id, String nombre, String ingredientes, String instrucciones ){
        this.id = id;
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.instrucciones = instrucciones;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getIngredientes() { return ingredientes; }
    public String getInstrucciones() { return instrucciones; }

    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setIngredientes(String ingredientes) { this.ingredientes = ingredientes; }
    public void setInstrucciones(String instrucciones) { this.instrucciones = instrucciones; }
 }
