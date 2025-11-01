package com.gotrionvigor.dao;

import com.gotrionvigor.modelo.Dieta;
import com.gotrionvigor.util.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DietaDao {

    public void insertarDieta(Dieta dieta) {
        String sql = "INSERT INTO dieta (nombre, descripcion, tipousuario) VALUES (?, ?, ?)";

        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dieta.getNombre());
            ps.setString(2, dieta.getDescripcion());
            ps.setString(3, dieta.getTipousuario());

            ps.executeUpdate();
            System.out.println("Dieta agregada correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al agregar dieta: " + e.getMessage());
        }
    }

    // ➤ Leer dietas
    public List<Dieta> obtenerDietas() {
        List<Dieta> lista = new ArrayList<>();
        String sql = "SELECT * FROM dieta";

        try (Connection con = ConexionDB.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Dieta d = new Dieta(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getString("tipousuario")
                );
                lista.add(d);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener dietas: " + e.getMessage());
        }
        return lista;
    }

    public void actualizarDieta(Dieta dieta) {
        String sql = "UPDATE dieta SET nombre=?, descripcion=?, tipousuario=? WHERE id=?";

        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dieta.getNombre());
            ps.setString(2, dieta.getDescripcion());
            ps.setString(3, dieta.getTipousuario());
            ps.setInt(4, dieta.getId());

            ps.executeUpdate();
            System.out.println("Dieta actualizada correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al actualizar dieta: " + e.getMessage());
        }
    }

    public void eliminarDieta(int id) {
        String sql = "DELETE FROM dieta WHERE id=?";

        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Dieta eliminada correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al eliminar dieta: " + e.getMessage());
        }
    }
}
