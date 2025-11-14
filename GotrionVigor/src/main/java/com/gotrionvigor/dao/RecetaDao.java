package com.gotrionvigor.dao;

import com.gotrionvigor.modelo.Receta;
import com.gotrionvigor.util.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecetaDao {

    public void insertarReceta(Receta receta) {
        String sql = "INSERT INTO receta (nombre, ingredientes, instrucciones) VALUES (?, ?, ?)";

        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, receta.getNombre());
            ps.setString(2, receta.getIngredientes());
            ps.setString(3, receta.getInstrucciones());

            ps.executeUpdate();
            System.out.println("Receta agregada correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al agregar receta: " + e.getMessage());
        }
    }

    public List<Receta> obtenerRecetas() {
        List<Receta> lista = new ArrayList<>();
        String sql = "SELECT * FROM receta";

        try (Connection con = ConexionDB.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Receta r = new Receta(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("ingredientes"),
                        rs.getString("instrucciones")
                );
                lista.add(r);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener recetas: " + e.getMessage());
        }
        return lista;
    }

    // ➤ Actualizar receta
    public void actualizarReceta(Receta receta) {
        String sql = "UPDATE receta SET nombre=?, ingredientes=?, instrucciones=? WHERE id=?";

        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, receta.getNombre());
            ps.setString(2, receta.getIngredientes());
            ps.setString(3, receta.getInstrucciones());
            ps.setInt(4, receta.getId());

            ps.executeUpdate();
            System.out.println("Receta actualizada correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al actualizar receta: " + e.getMessage());
        }
    }

    public void eliminarReceta(int id) {
        String sql = "DELETE FROM receta WHERE id=?";

        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Receta eliminada correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al eliminar receta: " + e.getMessage());
        }
    }
    public Receta obtenerRecetaPorId(int id) {
        String sql = "SELECT * FROM receta WHERE id = ?";
        Receta receta = null;

        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                receta = new Receta(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("ingredientes"),
                        rs.getString("instrucciones")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener receta por ID: " + e.getMessage());
        }

        return receta;
    }
    // ➤ Obtener receta por ID
    public Receta obtenerPorId(int id) {
        String sql = "SELECT * FROM receta WHERE id = ?";
        Receta receta = null;

        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                receta = new Receta(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("ingredientes"),
                        rs.getString("instrucciones")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener receta por ID: " + e.getMessage());
        }

        return receta;
    }

}