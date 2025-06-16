package com.adso.el_taller_de_adso.reportes;

import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import com.adso.el_taller_de_adso.ConexionBD;

public class ingresosgenerados {

    public void ingresos_generados(Date fecha_inicio, Date fecha_fin) {
        if (fecha_inicio == null || fecha_fin == null) {
            System.out.println("Una o ambas fechas son nulas.");
            return;
        }

        if (fecha_inicio.after(fecha_fin)) {
            System.out.println("La fecha de inicio no puede ser posterior a la fecha final.");
            return;
        }

        try (Connection conn = ConexionBD.conectar()) {
            String archivo = "reportes/ingresos_generados.jasper";
            System.out.println("Cargando desde: " + archivo);

            File reportFile = new File(archivo);
            if (!reportFile.exists()) {
                System.out.println("Reporte no encontrado en: " + archivo);
                return;
            }

            JasperReport masterReport = (JasperReport) JRLoader.loadObject(reportFile);

            Map<String, Object> parametro = new HashMap<>();
            parametro.put("fecha_inicio", fecha_inicio);
            parametro.put("fecha_fin", fecha_fin);       

            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, conn);

            if (jasperPrint.getPages().isEmpty()) {
                System.out.println("No se encontraron resultados entre las fechas: " + fecha_inicio + " y " + fecha_fin);
                return;
            }

            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.setTitle("Servicios entre fechas");
            jviewer.setVisible(true);

        } catch (JRException e) {
            System.out.println("Error cargando el reporte maestro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Mensaje de error: " + e.getMessage());
        }
    }
}


