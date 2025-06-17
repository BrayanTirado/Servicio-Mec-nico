package com.adso.el_taller_de_adso.inventario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.List;

public class BuscarProducto extends javax.swing.JInternalFrame {
    private ProductoDAO dao = new ProductoDAO();
    private Producto producto = new Producto();
    private DefaultTableModel modeloTabla;
    private List<Producto> listaProductos;
    private NumberFormat formatoPeso = NumberFormat.getCurrencyInstance();
    private javax.swing.JTextField txtBuscarId;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel lblBuscar;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(BuscarProducto.class.getName());

    public BuscarProducto() {
        initComponents();
        modeloTabla = new DefaultTableModel(new String[]{"ID", "Nombre", "Descripción", "Precio", "Stock"}, 0);
        tablaProductos.setModel(modeloTabla);
        cargarProductos(); 
        tablaProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
        tablaProductos.setSelectionBackground(new java.awt.Color(200, 255, 200)); 
        tablaProductos.setSelectionForeground(new java.awt.Color(0, 0, 0)); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        btnbuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createEtchedBorder());

        tablaProductos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProductos);

        btnbuscar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnbuscar.setForeground(new java.awt.Color(0, 102, 255));
        btnbuscar.setText("Buscar");
        btnbuscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        txtBuscar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel6.setText("Buscar por ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnbuscar)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(241, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(122, 122, 122)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked

    }//GEN-LAST:event_tablaProductosMouseClicked

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        try {
            String nombre = txtBuscar.getText().trim();
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un nombre para buscar.");
                return;
            }
            
            Producto productoEncontrado = dao.buscarPorNombre(nombre);
            if (productoEncontrado != null) {
                listaProductos.remove(productoEncontrado);
                listaProductos.add(0, productoEncontrado);
                actualizarTabla();
                resaltarProductoEnTabla(productoEncontrado.getId());
                JOptionPane.showMessageDialog(this, "Producto encontrado: " + productoEncontrado.getNombre());
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró ningún producto con ese nombre: " + nombre);
                txtBuscar.setText("");
            }
        } catch (SQLException ex) {
            logger.log(java.util.logging.Level.SEVERE, "Error al buscar producto", ex);
            JOptionPane.showMessageDialog(this, "Error al buscar en la base de datos.");
        }
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed
 private void resaltarProductoEnTabla(int id) {
        for (int i = 0; i < tablaProductos.getRowCount(); i++) {
            Object valorId = tablaProductos.getValueAt(i, 0);
            if (valorId != null && Integer.parseInt(valorId.toString()) == id) {
                tablaProductos.setRowSelectionInterval(i, i);
                tablaProductos.scrollRectToVisible(tablaProductos.getCellRect(i, 0, true));
                break;
            }
        }
    }

    private void cargarProductos() {
        try {
            listaProductos = dao.obtenerTodos();
            actualizarTabla();
        } catch (SQLException ex) {
            logger.log(java.util.logging.Level.SEVERE, "Error al cargar productos", ex);
            JOptionPane.showMessageDialog(this, "Error al cargar los productos.");
        }
    }

    private void actualizarTabla() {
        modeloTabla.setRowCount(0);
        for (Producto p : listaProductos) {
            modeloTabla.addRow(new Object[]{
                p.getId(),
                p.getNombre(),
                p.getDescripcion(),
                formatoPeso.format(p.getPrecio()),
                p.getStock()
            });
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}

