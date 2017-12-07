/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.MiError;
import entities.Renta;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
//import java.sql.Date;

/**
 *
 * @author Kendall
 */
public class RentaDAO {
    public ArrayList reporteDeRangoFechasRenta(Renta rent) {
        ArrayList fechas = new ArrayList();
        Date fecha1, fecha2;
        java.sql.Date fechaIncio = null;
        java.sql.Date fechaFinal = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            fecha1 = dateFormat.parse(rent.getFechaRetiro());
            fechaIncio = new java.sql.Date(fecha1.getTime());
            fecha2 = dateFormat.parse(rent.getFechaDevolu());
            fechaFinal = new java.sql.Date(fecha2.getTime());
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error a la hora de comvertir las fechas. " + e);
        }

        try (Connection con = Conexion.conexion()) {
            String sql = "SELECT placa, cedula, nombreusuario, fecharetiro, fechadevo FROM renta WHERE fecharetiro BETWEEN ? and ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setDate(1, fechaIncio);
            stmt.setDate(2, fechaFinal);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                fechas.add(rs.getString("placa"));
                fechas.add(rs.getString("cedula"));
                fechas.add(rs.getString("nombreusuario"));
                fechas.add(rs.getString("fecharetiro"));
                fechas.add(rs.getString("fechadevo"));

            }
        } catch (Exception ex) {
            throw new MiError("Error al extaer la informacion de los vehiculos." + ex);
        }
        return fechas;
    }
}
