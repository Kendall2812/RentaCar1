/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.MiError;
import entities.Modelo;
import entities.UsuAdm;
import entities.Vehiculo;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.imageio.ImageIO;

/**
 *
 * @author jenni
 */
public class VehiculoDAO {

    public boolean insertarVehi(Vehiculo v) {
        try (Connection con = Conexion.conexion()) {
            String sql = "insert into vehiculo(placa, marca, modelo,trasmision,año,estilo,precio,foto,estado) "
                    + "values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write((RenderedImage) v.getFoto(), "jpg", os);
            InputStream fis = new ByteArrayInputStream(os.toByteArray());
            stmt.setString(1, v.getPlaca());
            stmt.setString(2, v.getMarca());
            stmt.setString(3, v.getModelo());
            stmt.setString(4, v.getTransmision());
            stmt.setInt(5, v.getAño());
            stmt.setString(6, v.getEstilo());
            stmt.setInt(7, v.getPrecio());
            stmt.setBinaryStream(8, fis);
            stmt.setString(9, v.getEstado());

            return stmt.executeUpdate() > 0;

        } catch (SQLException s) {
            throw new MiError("El usuario ya existe");
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar usuarios");
        }

    }
    public boolean EliminarVehi(Vehiculo vehi) throws SQLException {
        try (Connection con = Conexion.conexion()) {
            String sql = "DELETE FROM vehiculo WHERE placa = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, vehi.getPlaca());

            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            throw new MiError("Falla al eliminar el modelo.");
        }
    }
}
