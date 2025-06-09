/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adso.el_taller_de_adso.clientes;

import com.adso.el_taller_de_adso.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author axchisan
 */
public class ClienteDAO {
    public void registrarcliente(Cliente cliente){
        String sql = "INSERT INTO clientes (nombre, documento, tlefono, correo, rol) VALUES (?, ?, ?, ?, ?)";
        try(Connection conn = ConexionBD.conectar();
           PreparedStatement stmt = conn.prepareStatement(sql)){
           stmt.setString(1, cliente.getNombre());
           stmt.setString(2, cliente.getDocumento());
           stmt.setString(3, cliente.getTelefono());
           stmt.setString(4, cliente.getCorreo());
           stmt.setInt(5, cliente.getRol());
           stmt.executeUpdate();
           JOptionPane.showMessageDialog(null, "Usuario registrado con exito");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al registrar cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            
        }
    }
}
