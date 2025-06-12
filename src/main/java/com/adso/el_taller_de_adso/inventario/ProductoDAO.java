package com.adso.el_taller_de_adso.inventario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    // Guardar producto
    public void guardarProducto(Producto producto) throws SQLException {
        Connection conn = ConexionBD.conectar();
        String sql = "INSERT INTO productos (nombre, cantidad, precio) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getDescripcion());
            stmt.setDouble(3, producto.getPrecio());
            stmt.setDouble(4, producto.getStock());
            stmt.executeUpdate();
        } finally {
            ConexionBD.cerrar(conn);
        }
    }

    // Editar producto (todos los campos)
    public void editarProducto(Producto producto) {
        Connection conn = ConexionBD.conectar();
        String sql = "UPDATE productos SET nombre = ?, cantidad = ?, precio = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getDescripcion());
            stmt.setDouble(3, producto.getPrecio());
            stmt.setDouble(4, producto.getStock());
            stmt.setInt(5, producto.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("❌ Error al editar producto:");
            e.printStackTrace();
        } finally {
            ConexionBD.cerrar(conn);
        }
    }

    // Eliminar producto por ID
    public void eliminarProducto(int id) throws SQLException {
        Connection conn = ConexionBD.conectar();
        String sql = "DELETE FROM productos WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } finally {
            ConexionBD.cerrar(conn);
        }
    }

    // Obtener todos los productos (por si deseas mostrar en una tabla más adelante)
    public List<Producto> obtenerTodos() throws SQLException {
        List<Producto> lista = new ArrayList<>();
        Connection conn = ConexionBD.conectar();
        String sql = "SELECT * FROM productos";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Producto p = new Producto(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getDouble("precio")
                    rs.getDouble("stock")
                );
                lista.add(p);
            }
        } finally {
            ConexionBD.cerrar(conn);
        }
        return lista;
    }
}
