/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
import java.util.LinkedList;
import javax.imageio.ImageIO;
import entities.MiError;
import entities.UsuAdm;

/**
 *
 * @author jenni
 */
public class UsuAdmDAO {

    public boolean insertar(UsuAdm u) {
        try (Connection con = Conexion.conexion()) {
            String sql = "insert into users(cedula, nombre, telefono,direccion,contraseña,tipo,foto,direccion_foto) "
                    + "values (?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write((RenderedImage) u.getFoto(), "jpg", os);
            InputStream fis = new ByteArrayInputStream(os.toByteArray());
            stmt.setInt(1, u.getCedula());
            stmt.setString(2, u.getNombre());
            stmt.setInt(3, u.getTelefono());
            stmt.setString(4, u.getDireccion());
            stmt.setString(5, u.getContraseña());
            stmt.setBoolean(6, u.isTipo());
            stmt.setBinaryStream(7, fis);
            stmt.setString(8, u.getDireccion_foto());
            return stmt.executeUpdate() > 0;

        } catch (SQLException s) {
            throw new MiError("El usuario ya existe");
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar usuarios");
        }

    }

    public LinkedList<UsuAdm> cargarTodo1() {
        LinkedList<UsuAdm> usuarios = new LinkedList<>();
        try (Connection con = Conexion.conexion()) {
            String sql = "select * from users";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                usuarios.add(cargarUsuario(rs));
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar los usuarios");
        }
        return usuarios;
    }

    public UsuAdm filtro(int cedu, String contras) throws SQLException {
        UsuAdm a = new UsuAdm();
        try (Connection con = Conexion.conexion()) {
            String sql = "select * from users where cedula = ? and contraseña = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, cedu);
            stmt.setString(2, contras);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                a.setTipo(rs.getBoolean("tipo"));
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar los usuarios");
        }
        return a;
    }

    public UsuAdm cargarUsuario(ResultSet rs) throws SQLException, IOException {
        UsuAdm u = new UsuAdm();
        u.setCedula(rs.getInt("cedula"));
        u.setNombre(rs.getString("nombre"));
        u.setContraseña(rs.getString("contraseña"));
        u.setDireccion(rs.getString("direccion"));
        u.setTelefono(rs.getInt("telefono"));
        u.setTipo(rs.getBoolean("tipo"));
        Image imgdb = null;
        InputStream fis = rs.getBinaryStream("foto");
        imgdb = ImageIO.read(fis);
        u.setFoto(imgdb);
        return u;

    }

}
