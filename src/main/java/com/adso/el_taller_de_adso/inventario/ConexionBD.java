/*
 * Click nfs://netbeans/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nfs://netbeans/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adso.el_taller_de_adso.inventario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.adso.el_taller_de_adso.inventario.ConexionBD;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.util.Locale;
import com.adso.el_taller_de_adso.inventario.Producto;
import com.adso.el_taller_de_adso.inventario.ProductoDAO;
import java.util.logging.Logger;

public class ConexionBD {
    private static final String URL = "jdbc:postgresql://setviciomecanico-leftyrancuentabot-144a.g.aivencloud.com:14583/tallermecanico";
    private static final String USER = "avnadmin";
    private static final String PASSWORD = "AVNS_7iy_JMEraYJqRxquMqF";

    public static Connection conectar() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Error: No se encontró el driver PostgreSQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar a PostgreSQL:");
            e.printStackTrace();
        }
        return conn;
    }

    public static void cerrar(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("✅ Conexión cerrada exitosamente.");
            } catch (SQLException e) {
                System.out.println("❌ Error al cerrar la conexión:");
                e.printStackTrace();
            }
        }
    }
}
