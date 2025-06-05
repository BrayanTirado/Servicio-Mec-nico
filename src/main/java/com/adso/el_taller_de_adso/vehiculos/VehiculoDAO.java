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
    
}
