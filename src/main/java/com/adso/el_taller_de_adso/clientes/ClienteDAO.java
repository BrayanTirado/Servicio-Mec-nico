/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adso.el_taller_de_adso.clientes;

import com.adso.el_taller_de_adso.ConexionBD;
import com.adso.el_taller_de_adso.clientes.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author axchisan
 */
public class ClienteDAO {
    public void registrarcliente(Cliente cliente){
        String sql = "INSERT INTO clientes (nombre, documento, telefono, correo, rol) VALUES (?, ?, ?, ?, ?)";
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
    
    public List<Cliente> listarClientes(){
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (Connection conn = ConexionBD.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    clientes.add(new Cliente(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("documento"),
                    rs.getString("telefono"),
                    rs.getString("correo"),
                    rs.getInt("rol")
                    ));
                }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar clientes: "+ e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return clientes;
    }
}
