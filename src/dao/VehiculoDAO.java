/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.MiError;
import entities.UsuAdm;
import entities.Vehiculo;
import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.imageio.ImageIO;

/**
 *
 * @author jenni
 */
public class VehiculoDAO {

    public boolean insertarVehi(Vehiculo v) {
        try (Connection con = Conexion.conexion()) {//It is the method in charge of registering the vehicles in the database
            
            String sql = "insert into vehiculo(placa,marca,modelo,transmision,año,estilo,precio,foto,estado,direccion_foto) "
                    + "values (?,?,?,?,?,?,?,?,?,?)";
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
            stmt.setString(10, v.getDireccion_foto());
            return stmt.executeUpdate() > 0;

        } catch (SQLException s) {
            throw new MiError("El vehiculo ya se encuentra registrado");
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar vehiculos");
        }

    }
    public boolean EliminarVehi(Vehiculo vehi) throws SQLException {//It is the method in charge of eliminating the vehicle according to the plate that is passing from the graphic interface
        try (Connection con = Conexion.conexion()) {
            String sql = "DELETE FROM vehiculo WHERE placa = ? AND estado = 'Disponible'";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, vehi.getPlaca());

            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            throw new MiError("Falla al eliminar el vehiculo.");
        }
    }
    public ArrayList cargarVehiculoEstado(Vehiculo vehi) {//It is the method in charge of consulting in the database which are the vehicles that are in the state that are asked from the graphical interface so that they are then shown on the screen
        ArrayList estado = new ArrayList();
        Image imgdb = null;
        try (Connection con = Conexion.conexion()) {
            String sql = "SELECT placa, marca, modelo, estilo FROM vehiculo WHERE estado = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, vehi.getEstado());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                estado.add(rs.getString("placa"));
                estado.add(rs.getString("marca"));
                estado.add(rs.getString("modelo"));
                estado.add(rs.getString("estilo"));
            }
        } catch (Exception ex) {
            throw new MiError("Error al extaer la informacion de los vehiculos." + ex);
        }
        return estado;
    }
    public LinkedList<Vehiculo> cargarTodo1() {//this method the than does is select the information of the vehicles in the database for then show it in the graphic interface
        LinkedList<Vehiculo> vehiculo = new LinkedList<>();
        try (Connection con = Conexion.conexion()) {
            String sql = "select * from vehiculo";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                vehiculo.add(cargarVehiculo(rs));
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar los vehiculos");
        }
        return vehiculo;
    }
     public Vehiculo cargarVehiculo(ResultSet rs) throws SQLException, IOException {//This method is to extract all the information of the vehicles for then be used in the method of cargarTodo1
        Vehiculo u = new Vehiculo();
        u.setPlaca(rs.getString("placa"));
        u.setEstado(rs.getString("estado"));
        u.setModelo(rs.getString("modelo"));
        u.setEstilo(rs.getString("estilo"));
        u.setAño(rs.getInt("año"));
        u.setMarca(rs.getString("marca"));
        u.setTransmision(rs.getString("transmision"));
        u.setPrecio(rs.getInt("precio"));
        Image imgdb = null;
        InputStream fis = rs.getBinaryStream("foto");
        imgdb = ImageIO.read(fis);
        u.setFoto(imgdb);
        u.setDireccion_foto(rs.getString("direccion_foto"));
        return u;

    }
     
      public boolean modiVehi(Vehiculo v, String placa) {
        try (Connection con = Conexion.conexion()) {
            String sql = "update vehiculo SET placa = ?, marca = ?, modelo = ?, transmision = ?, año = ?, estilo = ?,"
                    + " precio = ?, foto = ?, estado = ?, direccion_foto = ? where placa = ?";
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
            stmt.setString(10, v.getDireccion_foto());
            stmt.setString(11, placa);
            return stmt.executeUpdate() > 0;

        } catch (SQLException s) {
            throw new MiError("El vehiculo ya se encuentra registrado");
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar vehiculos");
        }

    }
      
      public boolean modificarEstado (String placa){
          try (Connection con = Conexion.conexion()) {
            String sql = "update vehiculo SET estado = ? where placa = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(2,placa);
            stmt.setString(1, "Ocupado");
            
            return stmt.executeUpdate() > 0;

        } catch (SQLException s) {
            throw new MiError("Error al modificar");
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar vehiculos");
        }

      }
}
