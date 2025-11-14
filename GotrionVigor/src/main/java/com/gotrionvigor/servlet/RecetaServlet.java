package com.gotrionvigor.servlet;

import com.gotrionvigor.dao.RecetaDao;
import com.gotrionvigor.modelo.Receta;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/recetas")
public class RecetaServlet extends HttpServlet {

    private RecetaDao recetaDao = new RecetaDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null) {
            // Mostrar lista de recetas
            List<Receta> recetas = recetaDao.obtenerRecetas();
            request.setAttribute("recetas", recetas);
            RequestDispatcher dispatcher = request.getRequestDispatcher("recetas.jsp");
            dispatcher.forward(request, response);
            return;
        }

        switch (accion) {
            case "editar":
                int idEditar = Integer.parseInt(request.getParameter("id"));
                Receta recetaEditar = recetaDao.obtenerPorId(idEditar);

                request.setAttribute("receta", recetaEditar);
                RequestDispatcher dispatcherEditar = request.getRequestDispatcher("editarReceta.jsp");
                dispatcherEditar.forward(request, response);
                break;

            case "eliminar":
                int idEliminar = Integer.parseInt(request.getParameter("id"));
                recetaDao.eliminarReceta(idEliminar);
                response.sendRedirect("recetas");
                break;

            default:
                response.sendRedirect("recetas");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null) {
            // Insertar nueva receta
            String nombre = request.getParameter("nombre");
            String ingredientes = request.getParameter("ingredientes");
            String instrucciones = request.getParameter("instrucciones");

            Receta nueva = new Receta(0, nombre, ingredientes, instrucciones);
            recetaDao.insertarReceta(nueva);

            response.sendRedirect("recetas");
            return;
        }

        // Actualizar receta
        if (accion.equals("actualizar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String ingredientes = request.getParameter("ingredientes");
            String instrucciones = request.getParameter("instrucciones");

            Receta recetaActualizada = new Receta(id, nombre, ingredientes, instrucciones);
            recetaDao.actualizarReceta(recetaActualizada);

            response.sendRedirect("recetas");
        }
    }
}
