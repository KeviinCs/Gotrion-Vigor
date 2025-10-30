package com.gotrionvigor.modelo;

public class Usuario {
    private int id;
    private String nombre;
    private int edad;
    private String correo;
    private String tipousuario;

    public Usuario(int id, String nombre, int edad, String correo, String tipousuario){
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.tipousuario = tipousuario;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getEdad () { return edad; }
    public String getCorreo() { return correo; }
    public String getTipousuario() { return tipousuario; }

    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEdad(int edad) { this.edad = edad;}
    public void setCorreo(String correo) { this.correo = correo;}
    public void setTipousuario(String tipousuario) { this.tipousuario = tipousuario;}
}
