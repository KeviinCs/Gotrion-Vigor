package com.gotrionvigor.dao;

import com.gotrionvigor.modelo.Usuario;
import com.gotrionvigor.util.ConexionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

    public class UsuarioDao {

        public void insertarUsuario(Usuario usuario) {
            String sql = "INSERT INTO usuario (nombre, edad, correo, tipousuario) VALUES (?, ?, ?, ?)";

            try (Connection con = ConexionDB.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, usuario.getNombre());
                ps.setInt(2, usuario.getEdad());
                ps.setString(3, usuario.getCorreo());
                ps.setString(4, usuario.getTipousuario());

                ps.executeUpdate();
                System.out.println("Usuario agregado exitosamente.");

            } catch (SQLException e) {
                System.out.println("Error al agregar usuario: " + e.getMessage());
            }
        }

        public List<Usuario> obtenerUsuarios() {
            List<Usuario> lista = new ArrayList<>();
            String sql = "SELECT * FROM usuario";

            try (Connection con = ConexionDB.getConnection();
                 Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    Usuario u = new Usuario(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getInt("edad"),
                            rs.getString("correo"),
                            rs.getString("tipousuario")
                    );
                    lista.add(u);
                }

            } catch (SQLException e) {
                System.out.println("Error al obtener usuarios: " + e.getMessage());
            }
            return lista;
        }

        public void actualizarUsuario(Usuario usuario) {
            String sql = "UPDATE usuario SET nombre=?, edad=?, correo=?, tipousuario=? WHERE id=?";

            try (Connection con = ConexionDB.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, usuario.getNombre());
                ps.setInt(2, usuario.getEdad());
                ps.setString(3, usuario.getCorreo());
                ps.setString(4, usuario.getTipousuario());
                ps.setInt(5, usuario.getId());

                ps.executeUpdate();
                System.out.println("Usuario actualizado correctamente.");

            } catch (SQLException e) {
                System.out.println("Error al actualizar usuario: " + e.getMessage());
            }
        }

        public void eliminarUsuario(int id) {
            String sql = "DELETE FROM usuario WHERE id=?";

            try (Connection con = ConexionDB.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setInt(1, id);
                ps.executeUpdate();
                System.out.println("Usuario eliminado correctamente.");

            } catch (SQLException e) {
                System.out.println("Error al eliminar usuario: " + e.getMessage());
            }
        }
    }
