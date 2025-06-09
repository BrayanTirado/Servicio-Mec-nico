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
        // Añadir listeners a los botones
        create.addActionListener(e -> registrarVehiculo());
        edit.addActionListener(e -> editarVehiculo());
        delete.addActionListener(e -> eliminarVehiculo());
        btnLimpiar.addActionListener(e -> limpiarFormulario());
        btnBuscarPorId.addActionListener(e -> buscarVehiculoPorId());
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        delete = new javax.swing.JButton();
        cmbClientes = new javax.swing.JComboBox<>();
        txtPlaca = new javax.swing.JTextField();
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
        jLabel7 = new javax.swing.JLabel();
        txtIdVehiculo = new javax.swing.JTextField();
        btnBuscarPorId = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel6.setText("Tipo");

        delete.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        delete.setForeground(new java.awt.Color(51, 51, 255));
        delete.setText("Eliminar Vehículo");
        delete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        cmbClientes.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        cmbClientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));

        txtPlaca.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtPlaca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));

        txtTipo.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtTipo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));

        txtModelo.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtModelo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));

        txtAnio.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtAnio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));

        txtMarca.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtMarca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestión de Vehículos");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setText("Placa");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel3.setText("Modelo");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel4.setText("Marca");

        create.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        create.setForeground(new java.awt.Color(51, 51, 255));
        create.setText("Registrar Vehículo");
        create.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel5.setText("Año");

        edit.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        edit.setForeground(new java.awt.Color(51, 51, 255));
        edit.setText("Editar Vehículo");
        edit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel9.setText("Usuario ");

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel7.setText("ID");

        txtIdVehiculo.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtIdVehiculo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));

        btnBuscarPorId.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnBuscarPorId.setForeground(new java.awt.Color(51, 51, 255));
        btnBuscarPorId.setText("Buscar Vehiculo");
        btnBuscarPorId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));

        btnLimpiar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(0, 51, 255));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbClientes, 0, 132, Short.MAX_VALUE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPlaca, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtModelo, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtIdVehiculo)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(create, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(18, 18, 18))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(33, 33, 33)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(32, 32, 32)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                        .addComponent(txtAnio))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(152, 152, 152)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnBuscarPorId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                                .addGap(43, 43, 43)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(create)
                    .addComponent(btnBuscarPorId))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edit)
                    .addComponent(delete))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

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

   private void actualizarComboClientes() {
        cmbClientes.removeAllItems();
        List<String> clientes = vehiculoDAO.listarClientes();
        for (String cliente : clientes) {
            cmbClientes.addItem(cliente);
        }
    }

    private void registrarVehiculo() {
        try {
            String placa = txtPlaca.getText().trim();
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
            limpiarFormulario();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El año debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editarVehiculo() {
        try {
            int id = Integer.parseInt(txtIdVehiculo.getText().trim());
            String placa = txtPlaca.getText().trim();
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
            Vehiculo vehiculo = new Vehiculo(id, placa, marca, modelo, anio, tipo, clienteId);
            vehiculoDAO.actualizarVehiculo(vehiculo);
            JOptionPane.showMessageDialog(this, "Vehículo actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarFormulario();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID y el año deben ser números válidos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarVehiculo() {
        try {
            int id = Integer.parseInt(txtIdVehiculo.getText().trim());
            int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar el vehículo con ID " + id + "?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                vehiculoDAO.eliminarVehiculo(id);
                JOptionPane.showMessageDialog(this, "Vehículo eliminado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                limpiarFormulario();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarVehiculoPorId() {
        try {
            int id = Integer.parseInt(txtIdVehiculo.getText().trim());
            Vehiculo vehiculo = vehiculoDAO.buscarVehiculoPorId(id);
            if (vehiculo != null) {
                txtPlaca.setText(vehiculo.getPlaca());
                txtMarca.setText(vehiculo.getMarca());
                txtModelo.setText(vehiculo.getModelo());
                txtAnio.setText(String.valueOf(vehiculo.getAnio()));
                txtTipo.setText(vehiculo.getTipo());
                // Seleccionar el cliente correspondiente en el combo
                for (int i = 0; i < cmbClientes.getItemCount(); i++) {
                    String cliente = (String) cmbClientes.getItemAt(i);
                    if (cliente.startsWith(vehiculo.getClienteId() + " - ")) {
                        cmbClientes.setSelectedIndex(i);
                        break;
                    }
                }
                JOptionPane.showMessageDialog(this, "Vehículo encontrado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró un vehículo con ID " + id, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarFormulario() {
        txtPlaca.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtAnio.setText("");
        txtTipo.setText("");
        txtIdVehiculo.setText("");
        if (cmbClientes.getItemCount() > 0) {
            cmbClientes.setSelectedIndex(0);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarPorId;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtIdVehiculo;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}

