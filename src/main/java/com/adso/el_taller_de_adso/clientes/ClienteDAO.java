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
    
    public List<Cliente> buscarCliente(String criterio, String valor){
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes WHERE " + (criterio.equals("documento") ? "documento" : "nombre") +" ILIKE ?";
        try (Connection conn = ConexionBD.conectar();
                PreparedStatement stmt = conn.prepareCall(sql)){
               stmt.setString(1, "%" + valor + "%");
               ResultSet rs = stmt.executeQuery();
               while (rs.next()){
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
            JOptionPane.showMessageDialog(null, "Error al buscar cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return clientes;
    }
    
    public void actualizarCliente(Cliente cliente){
        String sql = "UPDATE clientes SET nombre = ?, telefono = ?, correo = ?, rol = ? WHERE documento = ?";
        try (Connection conn = ConexionBD.conectar();
              PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getTelefono());
            stmt.setString(3, cliente.getCorreo());
            stmt.setInt(4, cliente.getRol());
            stmt.setString(5, cliente.getDocumento());
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "cliente actualizado con exito");  
            }else{
                JOptionPane.showMessageDialog(null, "Cliente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar cliente" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
