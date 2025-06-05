/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adso.el_taller_de_adso.vehiculos;

import com.adso.el_taller_de_adso.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class VehiculoDAO {
    

    
    // Registrar un vehículo (ya implementado)
    public void registrarVehiculo(Vehiculo vehiculo) {
        String sql = "INSERT INTO vehiculos (placa, marca, modelo, anio, tipo, cliente_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, vehiculo.getPlaca());
            stmt.setString(2, vehiculo.getMarca());
            stmt.setString(3, vehiculo.getModelo());
            stmt.setInt(4, vehiculo.getAnio());
            stmt.setString(5, vehiculo.getTipo());
            stmt.setInt(6, vehiculo.getClienteId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Vehículo registrado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar vehículo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Listar todos los vehículos
    public List<Vehiculo> listarVehiculos() {
        List<Vehiculo> vehiculos = new ArrayList<>();
        String sql = "SELECT * FROM vehiculos";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Vehiculo vehiculo = new Vehiculo(
                    rs.getInt("id"),
                    rs.getString("placa"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getInt("anio"),
                    rs.getString("tipo"),
                    rs.getInt("cliente_id")
                );
                vehiculos.add(vehiculo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar vehículos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return vehiculos;
    }

    // Actualizar un vehículo
    public void actualizarVehiculo(Vehiculo vehiculo) {
        String sql = "UPDATE vehiculos SET placa = ?, marca = ?, modelo = ?, anio = ?, tipo = ?, cliente_id = ? WHERE id = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, vehiculo.getPlaca());
            stmt.setString(2, vehiculo.getMarca());
            stmt.setString(3, vehiculo.getModelo());
            stmt.setInt(4, vehiculo.getAnio());
            stmt.setString(5, vehiculo.getTipo());
            stmt.setInt(6, vehiculo.getClienteId());
            stmt.setInt(7, vehiculo.getId());
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Vehículo actualizado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el vehículo con ID: " + vehiculo.getId(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar vehículo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Eliminar un vehículo
    public void eliminarVehiculo(int id) {
        String sql = "DELETE FROM vehiculos WHERE id = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Vehículo eliminado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el vehículo con ID: " + id, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar vehículo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Listar historial de servicios de un vehículo
    public List<String> listarHistorialServicios(int vehiculoId) {
        List<String> historial = new ArrayList<>();
        String sql = "SELECT fecha, tipo, costo, pagado FROM servicios WHERE vehiculo_id = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, vehiculoId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String servicio = String.format("Fecha: %s, Tipo: %s, Costo: %.2f, Pagado: %s",
                    rs.getDate("fecha"), rs.getString("tipo"), rs.getDouble("costo"), rs.getBoolean("pagado") ? "Sí" : "No");
                historial.add(servicio);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener historial: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return historial;
    }

    // Listar clientes para el JComboBox
    public List<String> listarClientes() {
        List<String> clientes = new ArrayList<>();
        String sql = "SELECT id, nombre, documento FROM clientes";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                clientes.add(rs.getInt("id") + " - " + rs.getString("nombre") + " (" + rs.getString("documento") + ")");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar clientes: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return clientes;
    }
}
