/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.adso.el_taller_de_adso.inventario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacturacionProductos extends javax.swing.JInternalFrame {

    private JComboBox<String> comboProductos;
    private JTextField txtCantidad, txtPrecio, txtStock;
    private JTable tablaFactura;
    private DefaultTableModel modeloTabla;
    private JLabel lblTotal;
    private ProductoDAO productoDAO;
    private List<Producto> productosSeleccionados;
    private Map<Producto, Integer> cantidades;
    private double total = 0;
    
 public FacturacionProductos() {
        super("Generar Factura", true, true, true, true);
        setSize(700, 500);
        setLayout(new BorderLayout());

        productoDAO = new ProductoDAO();
        productosSeleccionados = new ArrayList<>();
        cantidades = new HashMap<>();

        JPanel panelSuperior = new JPanel();
        comboProductos = new JComboBox<>();
        txtCantidad = new JTextField(5);
        txtPrecio = new JTextField(7);
        txtStock = new JTextField(5);
        txtPrecio.setEditable(false);
        txtStock.setEditable(false);

        JButton btnAgregar = new JButton("Agregar");
        JButton btnGuardar = new JButton("Guardar Factura");

        panelSuperior.add(new JLabel("Producto:"));
        panelSuperior.add(comboProductos);
        panelSuperior.add(new JLabel("Cantidad:"));
        panelSuperior.add(txtCantidad);
        panelSuperior.add(new JLabel("Precio:"));
        panelSuperior.add(txtPrecio);
        panelSuperior.add(new JLabel("Stock:"));
        panelSuperior.add(txtStock);
        panelSuperior.add(btnAgregar);

        add(panelSuperior, BorderLayout.NORTH);

        modeloTabla = new DefaultTableModel(new String[]{"Producto", "Cantidad", "Precio", "Subtotal"}, 0);
        tablaFactura = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaFactura);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        lblTotal = new JLabel("Total: $0.0");
        panelInferior.add(lblTotal);
        panelInferior.add(btnGuardar);
        add(panelInferior, BorderLayout.SOUTH);

        cargarProductos();

        comboProductos.addActionListener(e -> mostrarInfoProducto());

        btnAgregar.addActionListener(e -> agregarProducto());
        btnGuardar.addActionListener(e -> guardarFactura());
    }
 
  private void cargarProductos() {
        try {
            List<Producto> productos = productoDAO.obtenerTodos();
            comboProductos.removeAllItems();
            for (Producto p : productos) {
                comboProductos.addItem(p.getId() + ": " + p.getNombre());
            }
            if (!productos.isEmpty()) {
                mostrarInfoProducto();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error cargando productos: " + e.getMessage());
        }
    }
  
   private void mostrarInfoProducto() {
        try {
            if (comboProductos.getSelectedItem() == null) return;
            String seleccion = (String) comboProductos.getSelectedItem();
            int id = Integer.parseInt(seleccion.split(":")[0]);
            Producto p = productoDAO.buscarPorId(id);
            if (p != null) {
                txtPrecio.setText(String.valueOf(p.getPrecio()));
                txtStock.setText(String.valueOf(p.getStock()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
     private void agregarProducto() {
        try {
            if (comboProductos.getSelectedItem() == null) return;
            String seleccion = (String) comboProductos.getSelectedItem();
            int id = Integer.parseInt(seleccion.split(":")[0]);
            Producto producto = productoDAO.buscarPorId(id);

            int cantidad = Integer.parseInt(txtCantidad.getText());
            if (cantidad > producto.getStock()) {
                JOptionPane.showMessageDialog(this, "Stock insuficiente.");
                return;
            }

            double subtotal = producto.getPrecio() * cantidad;
            modeloTabla.addRow(new Object[]{producto.getNombre(), cantidad, producto.getPrecio(), subtotal});
            total += subtotal;
            lblTotal.setText("Total: $" + total);

            productosSeleccionados.add(producto);
            cantidades.put(producto, cantidad);

            producto.setStock(producto.getStock() - cantidad);
            productoDAO.editarProducto(producto);

            if (producto.getStock() <= producto.getUmbralBajoStock()) {
                JOptionPane.showMessageDialog(this, "El producto \"" + producto.getNombre() + "\" tiene stock bajo.");
            }

            txtCantidad.setText("");
            txtPrecio.setText("");
            txtStock.setText("");
            cargarProductos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al agregar producto: " + e.getMessage());
        }
    }
     
      private void guardarFactura() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar Factura");
        fileChooser.setSelectedFile(new File("factura.txt"));

        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File archivoFactura = fileChooser.getSelectedFile();
            try (PrintWriter writer = new PrintWriter(archivoFactura)) {
                writer.println("FACTURA:");
                writer.println("==========================");
                for (Producto producto : productosSeleccionados) {
                    writer.printf("Producto: %s\nPrecio: %.2f\nCantidad: %d\nSubtotal: %.2f\n\n",
                        producto.getNombre(),
                        producto.getPrecio(),
                        cantidades.get(producto),
                        producto.getPrecio() * cantidades.get(producto));
                }
                writer.println("--------------------------");
                writer.printf("TOTAL: %.2f\n", total);
                writer.println("==========================");
                JOptionPane.showMessageDialog(this, "Factura guardada correctamente en: " + archivoFactura.getAbsolutePath());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al guardar la factura: " + e.getMessage());
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
