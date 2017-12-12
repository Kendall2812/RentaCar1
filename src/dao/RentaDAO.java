/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.MiError;
import entities.Renta;
import entities.UsuAdm;
import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import javax.imageio.ImageIO;
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

    public boolean insertarRenta(Renta r) {

        
        Date fecha1, fecha2; 
        java.sql.Date fechaIncio = null;
        java.sql.Date fechaFinal = null;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            fecha1 = dateFormat.parse(r.getFechaRetiro());
            fechaIncio = new java.sql.Date(fecha1.getTime());
            fecha2 = dateFormat.parse(r.getFechaDevolu());
            fechaFinal = new java.sql.Date(fecha2.getTime());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error a la hora de comvertir las fechas. " + e);
        }
        
        try (Connection con = Conexion.conexion()) {

            String sql = "insert into renta (placa, cedula, nombreusuario, ofiretiro, ofidevolu, fecharetiro, horaretiro,"
                    + "fechadevo, horadevolu, preciofinal) "
                    + "values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, r.getPlaca());
            stmt.setInt(2, r.getCedula());
            stmt.setString(3, r.getNombre());
            stmt.setString(4, r.getOfiRetiro());
            stmt.setString(5, r.getOfiDevolu());
            stmt.setDate(6, fechaIncio);
            stmt.setString(7, r.getHoraRetiro());
            stmt.setDate(8, fechaFinal);
            stmt.setString(9, r.getHoraDevolu());
            stmt.setInt(10, r.getPrecio());

            return stmt.executeUpdate() > 0;

        } catch (SQLException s) {
            throw new MiError("");
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar renta");
        }

    }
}
