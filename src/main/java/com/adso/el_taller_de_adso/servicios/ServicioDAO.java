package com.adso.el_taller_de_adso.servicios;

/**
 *
 * @author USUARIO
 */

import com.adso.el_taller_de_adso.ConexionBD;
import com.adso.el_taller_de_adso.servicios.Servicio;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicioDAO {

    private Connection getConnection() throws SQLException {
        return ConexionBD.conectar(); // Use the ConexionBD class for connection
    }

    public List<Servicio> getServiciosByVehiculo(int vehicleId) throws SQLException {
    List<Servicio> servicios = new ArrayList<>();
    Connection conn = getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
        String sql = "SELECT id, fecha, tipo, costo FROM servicios WHERE vehiculo_id = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, vehicleId);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            Servicio servicio = new Servicio();
            servicio.setId(rs.getInt("id"));
            servicio.setFecha(rs.getDate("fecha"));
            servicio.setTipo(rs.getString("tipo"));
            servicio.setCosto(rs.getDouble("costo"));
            servicios.add(servicio);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw e; // Re-lanzar para manejo en el caller
    } 
    return servicios;
}
    public List<String> getAllClientes() {
        List<String> clientes = new ArrayList<>();
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT nombre FROM clientes");
            while (rs.next()) {
                clientes.add(rs.getString("nombre"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexionBD.cerrar(conn); // Use ConexionBD to close the connection
        }
        return clientes;
    }

    public List<String> getAllVehiculos() {
        List<String> vehiculos = new ArrayList<>();
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT placa FROM vehiculos");
            while (rs.next()) {
                vehiculos.add(rs.getString("placa"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexionBD.cerrar(conn);
        }
        return vehiculos;
    }

    public List<String> getAllProductos() {
        List<String> productos = new ArrayList<>();
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT nombre FROM productos");
            while (rs.next()) {
                productos.add(rs.getString("nombre"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexionBD.cerrar(conn);
        }
        return productos;
    }

    public double getPrecioProducto(String nombre) {
        Connection conn = null;
        try {
            conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT precio FROM productos WHERE nombre = ?");
            pstmt.setString(1, nombre);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("precio");
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexionBD.cerrar(conn);
        }
        return 0.0;
    }
    public String getProductoDescription(String nombre) {
    Connection conn = null;
    try {
        conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement("SELECT descripcion FROM productos WHERE nombre = ?");
        pstmt.setString(1, nombre);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getString("descripcion");
        }
        rs.close();
        pstmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        ConexionBD.cerrar(conn);
    }
    return null;
}

    public int getClienteId(String nombre) {
        Connection conn = null;
        try {
            conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT id FROM clientes WHERE nombre = ?");
            pstmt.setString(1, nombre);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexionBD.cerrar(conn);
        }
        return -1;
    }

    public int getVehiculoId(String placa) {
        Connection conn = null;
        try {
            conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT id FROM vehiculos WHERE placa = ?");
            pstmt.setString(1, placa);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexionBD.cerrar(conn);
        }
        return -1;
    }

    public int getProductoId(String nombre) {
        Connection conn = null;
        try {
            conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT id FROM productos WHERE nombre = ?");
            pstmt.setString(1, nombre);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexionBD.cerrar(conn);
        }
        return -1;
    }

public void addServicio(Servicio servicio, DefaultTableModel tableModel) throws SQLException {
    Connection conn = getConnection();
    try {
        conn.setAutoCommit(false); // Start transaction

        // Insert into servicios
        String sqlServicio = "INSERT INTO servicios (fecha, tipo, costo, pagado, vehiculo_id, cliente_id) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmtServicio = conn.prepareStatement(sqlServicio, Statement.RETURN_GENERATED_KEYS);
        pstmtServicio.setDate(1, servicio.getFecha());
        pstmtServicio.setString(2, servicio.getTipo());
        pstmtServicio.setDouble(3, servicio.getCosto());
        pstmtServicio.setBoolean(4, servicio.isPagado());
        pstmtServicio.setInt(5, servicio.getVehiculoId());
        pstmtServicio.setInt(6, servicio.getClienteId());
        pstmtServicio.executeUpdate();

        // Get the generated servicio ID
        ResultSet generatedKeys = pstmtServicio.getGeneratedKeys();
        int servicioId = -1;
        if (generatedKeys.next()) {
            servicioId = generatedKeys.getInt(1);
        }
        generatedKeys.close();
        pstmtServicio.close();

        // Insert into servicio_productos
        String sqlProducto = "INSERT INTO servicio_productos (servicio_id, producto_id, cantidad) VALUES (?, ?, ?)";
        PreparedStatement pstmtProducto = conn.prepareStatement(sqlProducto);
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String productoNombre = (String) tableModel.getValueAt(i, 0);
            Object quantityObj = tableModel.getValueAt(i, 3); // Get quantity as Object
            if (productoNombre != null && quantityObj != null) {
                int cantidad = (quantityObj instanceof Number) ? ((Number) quantityObj).intValue() : 0;
                if (cantidad > 0) {
                    int productoId = getProductoId(productoNombre);
                    if (productoId != -1) {
                        pstmtProducto.setInt(1, servicioId);
                        pstmtProducto.setInt(2, productoId);
                        pstmtProducto.setInt(3, cantidad);
                        pstmtProducto.executeUpdate();

                        // Update stock
                        updateStock(productoId, cantidad, conn);
                    }
                }
            }
        }
        pstmtProducto.close();

        conn.commit();
        System.out.println("✅ Servicio y repuestos guardados exitosamente.");
    } catch (SQLException e) {
        conn.rollback(); // Rollback on error
        System.err.println("❌ Error al guardar el servicio: " + e.getMessage());
        throw e; // Re-throw to be handled by the caller
    } finally {
        conn.setAutoCommit(true); // Reset auto-commit
        ConexionBD.cerrar(conn); // Close the connection
    }
}
  public int getProductoStock(String nombre) {
    Connection conn = null;
    try {
        conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement("SELECT stock FROM productos WHERE nombre = ?");
        pstmt.setString(1, nombre);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("stock");
        }
        rs.close();
        pstmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        ConexionBD.cerrar(conn);
    }
    return 0;
}

    private void updateStock(int productoId, int cantidad, Connection conn) throws SQLException {
        String sql = "UPDATE productos SET stock = stock - ? WHERE id = ? AND stock >= ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        try {
            pstmt.setInt(1, cantidad);
            pstmt.setInt(2, productoId);
            pstmt.setInt(3, cantidad);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("Stock insuficiente para el producto ID: " + productoId);
            }
        } finally {
            pstmt.close();
        }
    }
}