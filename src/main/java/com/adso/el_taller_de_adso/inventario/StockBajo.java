
package com.adso.el_taller_de_adso.inventario;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import com.adso.el_taller_de_adso.inventario.*;
public class StockBajo extends javax.swing.JInternalFrame {
    

    private JTable tabla;
    private ProductoDAO productoDAO;





    public StockBajo() {
        super("Productos con Stock Bajo", true, true, true, true);
        setSize(600, 300);
        setLayout(new BorderLayout());

        productoDAO = new ProductoDAO();
        tabla = new JTable();

        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);

        cargarProductosBajoStock();
    }

    private void cargarProductosBajoStock() {
        try {
            List<Producto> productos = productoDAO.obtenerTodos();
            
            DefaultTableModel modelo = new DefaultTableModel(new String[]{"ID", "Nombre", "Stock"}, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // Hacer la tabla no editable
                }
            };

            for (Producto p : productos) {
                if (p.getStock() <= p.getUmbralBajoStock()) {
                    modelo.addRow(new Object[]{p.getId(), p.getNombre(), p.getStock()});
                }
            }

            tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar productos: " + e.getMessage());
        }
    }

    // Si quieres agregar componentes adicionales, puedes hacerlo aquí
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible) {
            cargarProductosBajoStock(); // Refrescar al abrir
        }
    }


  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 706, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
