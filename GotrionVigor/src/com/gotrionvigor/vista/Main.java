package com.gotrionvigor.vista;

import com.gotrionvigor.dao.UsuarioDao;
import com.gotrionvigor.dao.DietaDao;
import com.gotrionvigor.dao.RecetaDao;
import com.gotrionvigor.modelo.Usuario;
import com.gotrionvigor.modelo.Dieta;
import com.gotrionvigor.modelo.Receta;

public class Main {
    public static void main(String[] args) {

        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario usuario = new Usuario(0, "Carlos", 25, "carlos@mail.com", "adulto");
        usuarioDao.insertarUsuario(usuario);

        System.out.println("Usuarios:");
        usuarioDao.obtenerUsuarios().forEach(u ->
                System.out.println(u.getId() + " - " + u.getNombre() + " - " + u.getTipousuario())
        );

        DietaDao dietaDao = new DietaDao();
        Dieta dieta = new Dieta(0, "Dieta Equilibrada", "Frutas, verduras y proteínas", "adulto");
        dietaDao.insertarDieta(dieta);

        System.out.println("\nDietas:");
        dietaDao.obtenerDietas().forEach(d ->
                System.out.println(d.getId() + " - " + d.getNombre() + " - " + d.getTipousuario())
        );

        RecetaDao recetaDao = new RecetaDao();
        Receta receta = new Receta(0, "Ensalada Saludable", "Lechuga, tomate, zanahoria", "Mezclar todos los ingredientes");
        recetaDao.insertarReceta(receta);

        System.out.println("\nRecetas:");
        recetaDao.obtenerRecetas().forEach(r ->
                System.out.println(r.getId() + " - " + r.getNombre())
        );

        System.out.println("\nDatos cargados correctamente en la base de datos.");
    }
}
