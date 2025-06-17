/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.adso.el_taller_de_adso.vehiculos;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

public class MarcoVehiculo extends javax.swing.JInternalFrame {
    private VehiculoDAO vehiculoDAO;

    public MarcoVehiculo() {
        initComponents();
        vehiculoDAO = new VehiculoDAO();
        actualizarComboClientes();
        create.addActionListener(e -> registrarVehiculo());
        edit.addActionListener(e -> editarVehiculo());
        delete.addActionListener(e -> eliminarVehiculo());
        btnLimpiar.addActionListener(e -> limpiarFormulario());
        btnBuscarPorPlaca.addActionListener(e -> buscarVehiculoPorPlaca());
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        delete = new javax.swing.JButton();
        cmbClientes = new javax.swing.JComboBox<>();
        txtTipo = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtAnio = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        create = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        edit = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtPlacaVehiculo = new javax.swing.JTextField();
        btnBuscarPorPlaca = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel6.setText("Tipo");

        delete.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        delete.setForeground(new java.awt.Color(0, 102, 255));
        delete.setText("Eliminar Vehículo");
        delete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        cmbClientes.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        cmbClientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));
        cmbClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClientesActionPerformed(evt);
            }
        });

        txtTipo.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtTipo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTipo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));

        txtModelo.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtModelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtModelo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));

        txtAnio.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtAnio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAnio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));

        txtMarca.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtMarca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMarca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestión de Vehículos");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel2.setText("Placa");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel3.setText("Modelo");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel4.setText("Marca");

        create.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        create.setForeground(new java.awt.Color(0, 102, 255));
        create.setText("Registrar Vehículo");
        create.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));
        create.setOpaque(true);
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel5.setText("Año");

        edit.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        edit.setForeground(new java.awt.Color(0, 102, 255));
        edit.setText("Editar Vehículo");
        edit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));
        edit.setOpaque(true);
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel9.setText("Usuario");

        txtPlacaVehiculo.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtPlacaVehiculo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPlacaVehiculo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));

        btnBuscarPorPlaca.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        btnBuscarPorPlaca.setForeground(new java.awt.Color(0, 102, 255));
        btnBuscarPorPlaca.setText("Buscar Vehiculo");
        btnBuscarPorPlaca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));
        btnBuscarPorPlaca.setOpaque(true);
        btnBuscarPorPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPorPlacaActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(0, 102, 255));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cmbClientes, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAnio, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMarca, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtModelo)
                            .addComponent(txtTipo)
                            .addComponent(txtPlacaVehiculo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarPorPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(74, 74, 74)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(create, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(112, 112, 112))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(256, 256, 256))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarPorPlaca)
                    .addComponent(edit))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(create)
                    .addComponent(delete))
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtPlacaVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(btnLimpiar)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        editarVehiculo();
    }//GEN-LAST:event_editActionPerformed

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
        registrarVehiculo();
    }//GEN-LAST:event_createActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        eliminarVehiculo();
    }//GEN-LAST:event_deleteActionPerformed

    private void cmbClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClientesActionPerformed
        
    }//GEN-LAST:event_cmbClientesActionPerformed

    private void btnBuscarPorPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPorPlacaActionPerformed
        buscarVehiculoPorPlaca();
    }//GEN-LAST:event_btnBuscarPorPlacaActionPerformed

   private void actualizarComboClientes() {
        cmbClientes.removeAllItems();
        List<String> clientes = vehiculoDAO.listarClientes();
        for (String cliente : clientes) {
            cmbClientes.addItem(cliente);
        }
    }

    private void registrarVehiculo() {
        try {
            String placa = txtPlacaVehiculo.getText().trim();
            String marca = txtMarca.getText().trim();
            String modelo = txtModelo.getText().trim();
            int anio = Integer.parseInt(txtAnio.getText().trim());
            String tipo = txtTipo.getText().trim();
            String clienteSeleccionado = (String) cmbClientes.getSelectedItem();

            if (placa.isEmpty() || marca.isEmpty() || modelo.isEmpty() || tipo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (clienteSeleccionado == null) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int clienteId = Integer.parseInt(clienteSeleccionado.split(" - ")[0]);
            Vehiculo vehiculo = new Vehiculo(0, placa, marca, modelo, anio, tipo, clienteId);
            vehiculoDAO.registrarVehiculo(vehiculo);
            JOptionPane.showMessageDialog(this, "Vehículo registrado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El año debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editarVehiculo() {
        try {
            String placa = txtPlacaVehiculo.getText().trim().toUpperCase();
            Vehiculo vehiculoExistente = vehiculoDAO.buscarVehiculoPorPlaca(placa);
            if (vehiculoExistente == null) {
                JOptionPane.showMessageDialog(this, "No se encontró un vehículo con placa " + placa, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String placaNueva = txtPlacaVehiculo.getText().trim();
            String marca = txtMarca.getText().trim();
            String modelo = txtModelo.getText().trim();
            int anio = Integer.parseInt(txtAnio.getText().trim());
            String tipo = txtTipo.getText().trim();
            String clienteSeleccionado = (String) cmbClientes.getSelectedItem();

            if (placaNueva.isEmpty() || marca.isEmpty() || modelo.isEmpty() || tipo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (clienteSeleccionado == null) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int clienteId = Integer.parseInt(clienteSeleccionado.split(" - ")[0]);
            Vehiculo vehiculo = new Vehiculo(vehiculoExistente.getId(), placaNueva, marca, modelo, anio, tipo, clienteId);
            vehiculoDAO.actualizarVehiculo(vehiculo);
            JOptionPane.showMessageDialog(this, "Vehículo actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El año debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarVehiculo() {
        try {
            String placa = txtPlacaVehiculo.getText().trim().toUpperCase();
            Vehiculo vehiculoExistente = vehiculoDAO.buscarVehiculoPorPlaca(placa);
            if (vehiculoExistente == null) {
                JOptionPane.showMessageDialog(this, "No se encontró un vehículo con placa " + placa, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar el vehículo con placa " + placa + "?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                vehiculoDAO.eliminarVehiculo(vehiculoExistente.getId());
                JOptionPane.showMessageDialog(this, "Vehículo eliminado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar vehículo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarVehiculoPorPlaca() {
        try {
            String placa = txtPlacaVehiculo.getText().trim().toUpperCase();
            if (placa.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese una placa", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Vehiculo vehiculo = vehiculoDAO.buscarVehiculoPorPlaca(placa);
            if (vehiculo != null) {
                txtPlacaVehiculo.setText(vehiculo.getPlaca());
                txtMarca.setText(vehiculo.getMarca());
                txtModelo.setText(vehiculo.getModelo());
                txtAnio.setText(String.valueOf(vehiculo.getAnio()));
                txtTipo.setText(vehiculo.getTipo());
                for (int i = 0; i < cmbClientes.getItemCount(); i++) {
                    String cliente = (String) cmbClientes.getItemAt(i);
                    if (cliente.startsWith(vehiculo.getClienteId() + " - ")) {
                        cmbClientes.setSelectedIndex(i);
                        break;
                    }
                }
                JOptionPane.showMessageDialog(this, "Vehículo encontrado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró un vehículo con placa " + placa, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar vehículo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarFormulario() {
        txtPlacaVehiculo.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtAnio.setText("");
        txtTipo.setText("");
        if (cmbClientes.getItemCount() > 0) {
            cmbClientes.setSelectedIndex(0);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarPorPlaca;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cmbClientes;
    private javax.swing.JButton create;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPlacaVehiculo;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}

