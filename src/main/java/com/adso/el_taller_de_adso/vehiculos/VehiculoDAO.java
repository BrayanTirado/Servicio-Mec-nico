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

public class VehiculoDAO {
    private static final String INSERT_VEHICULO = "INSERT INTO vehiculos (placa, marca, modelo, anio, tipo, cliente_id) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_VEHICULO = "UPDATE vehiculos SET placa = ?, marca = ?, modelo = ?, anio = ?, tipo = ?, cliente_id = ? WHERE id = ?";
    private static final String DELETE_VEHICULO = "DELETE FROM vehiculos WHERE id = ?";
    private static final String SELECT_VEHICULOS = "SELECT * FROM vehiculos";
    private static final String SELECT_CLIENTES = "SELECT id, nombre FROM clientes";
    private static final String SELECT_HISTORIAL = "SELECT fecha, tipo, costo, pagado FROM servicios WHERE vehiculo_id = ?";

    public void registrarVehiculo(Vehiculo vehiculo) {
        try (Connection conn = ConexionBD.conectar(); PreparedStatement stmt = conn.prepareStatement(INSERT_VEHICULO)) {
            stmt.setString(1, vehiculo.getPlaca());
            stmt.setString(2, vehiculo.getMarca());
            stmt.setString(3, vehiculo.getModelo());
            stmt.setInt(4, vehiculo.getAnio());
            stmt.setString(5, vehiculo.getTipo());
            stmt.setInt(6, vehiculo.getClienteId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al registrar vehículo: " + e.getMessage());
        }
    }

    public void actualizarVehiculo(Vehiculo vehiculo) {
        try (Connection conn = ConexionBD.conectar(); PreparedStatement stmt = conn.prepareStatement(UPDATE_VEHICULO)) {
            stmt.setString(1, vehiculo.getPlaca());
            stmt.setString(2, vehiculo.getMarca());
            stmt.setString(3, vehiculo.getModelo());
            stmt.setInt(4, vehiculo.getAnio());
            stmt.setString(5, vehiculo.getTipo());
            stmt.setInt(6, vehiculo.getClienteId());
            stmt.setInt(7, vehiculo.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar vehículo: " + e.getMessage());
        }
    }

    public void eliminarVehiculo(int id) {
        try (Connection conn = ConexionBD.conectar(); PreparedStatement stmt = conn.prepareStatement(DELETE_VEHICULO)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar vehículo: " + e.getMessage());
        }
    }

    public List<Vehiculo> listarVehiculos() {
        List<Vehiculo> vehiculos = new ArrayList<>();
        try (Connection conn = ConexionBD.conectar(); PreparedStatement stmt = conn.prepareStatement(SELECT_VEHICULOS); ResultSet rs = stmt.executeQuery()) {
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
            throw new RuntimeException("Error al listar vehículos: " + e.getMessage());
        }
        return vehiculos;
    }

    public List<String> listarClientes() {
        List<String> clientes = new ArrayList<>();
        try (Connection conn = ConexionBD.conectar(); PreparedStatement stmt = conn.prepareStatement(SELECT_CLIENTES); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                clientes.add(rs.getInt("id") + " - " + rs.getString("nombre"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar clientes: " + e.getMessage());
        }
        return clientes;
    }

    public List<String> listarHistorialServicios(int vehiculoId) {
        List<String> historial = new ArrayList<>();
        try (Connection conn = ConexionBD.conectar(); PreparedStatement stmt = conn.prepareStatement(SELECT_HISTORIAL)) {
            stmt.setInt(1, vehiculoId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String servicio = String.format("Fecha: %s, Tipo: %s, Costo: %.2f, Pagado: %b",
                        rs.getDate("fecha"), rs.getString("tipo"), rs.getDouble("costo"), rs.getBoolean("pagado"));
                    historial.add(servicio);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar historial de servicios: " + e.getMessage());
        }
        return historial;
    }

     public Vehiculo buscarVehiculoPorPlaca(String placa) {
    try (Connection conn = ConexionBD.conectar(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM vehiculos WHERE placa = ?")) {
        stmt.setString(1, placa);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return new Vehiculo(
                    rs.getInt("id"),
                    rs.getString("placa"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getInt("anio"),
                    rs.getString("tipo"),
                    rs.getInt("cliente_id")
                );
            }
        }
    } catch (SQLException e) {
        throw new RuntimeException("Error al buscar vehículo por placa: " + e.getMessage());
    }
    return null; 
}
}