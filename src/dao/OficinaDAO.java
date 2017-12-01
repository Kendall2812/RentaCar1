/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import entities.MiError;
import entities.Oficina;
import entities.UsuAdm;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.util.LinkedList;
import javax.imageio.ImageIO;

/**
 *
 * @author Kendall
 */
public class OficinaDAO {
    public boolean registroOficina(Oficina ofi) throws SQLException{
        try (Connection con = Conexion.conexion()) {
            String sql = "insert into oficina(nombre_oficina)"
                    + "values (?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, ofi.getNombre());
            return stmt.executeUpdate() > 0;

        } catch (Exception ex) {
            throw new MiError("La oficina ya se encuentra registrada.");
        }
    }
    
    public LinkedList<Oficina> cargarTodo() {
        LinkedList<Oficina> oficinas = new LinkedList<>();
        try (Connection con = Conexion.conexion()) {
            String sql = "select nombre_oficina from oficina";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                oficinas.add(cargarOficinas(rs));
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar las oficinas");
        }
        return oficinas;
    }
    
    public Oficina cargarOficinas(ResultSet rs) throws SQLException, IOException {
        Oficina o = new Oficina();  
        o.setNombre(rs.getString("nombre_oficina"));
        return o;

    }
}
