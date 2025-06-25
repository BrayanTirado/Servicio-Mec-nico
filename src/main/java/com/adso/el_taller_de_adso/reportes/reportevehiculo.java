
package com.adso.el_taller_de_adso.reportes;

import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import com.adso.el_taller_de_adso.ConexionBD;

public class reportevehiculo {
    public void reporte_vehiculo_id(Integer vehiculo_id) {
        try (Connection conn = ConexionBD.conectar()) {
            String archivo ="reportes/reporte_vehiculo_id.jasper";
            System.out.println("Cargando desde: " + archivo);

            File reportFile = new File(archivo);
            if (!reportFile.exists()) {
                System.out.println("Reporte no encontrado en: " + archivo);
                return; 
            }

            JasperReport masterReport = (JasperReport) JRLoader.loadObject(reportFile);
            Map<String, Object> parametro = new HashMap<>();
            parametro.put("vehiculo_id", vehiculo_id);
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, conn);

            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.setTitle("Servicios de Vehículos");
            jviewer.setVisible(true);
        } catch (JRException e) {
            System.out.println("Error cargando el reporte maestro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Mensaje de error: " + e.getMessage());
        }
    }
}

