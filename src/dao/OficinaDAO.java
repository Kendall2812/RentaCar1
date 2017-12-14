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
import java.io.IOException;
import java.util.LinkedList;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author Kendall
 */

public class OficinaDAO {
    public boolean registroOficina(Oficina ofi) throws SQLException{//this method is what does is receiving the information of the graphical interface for then save it in database
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
    
    public LinkedList<Oficina> cargarTodo() {//this method  what does is select every one of the offices it in database for then send them to the graphic interface 
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
    
    public Oficina cargarOficinas(ResultSet rs) throws SQLException, IOException {//this method  what does is select every one of the offices it in database for then send them to the graphic interface
        Oficina o = new Oficina();  
        o.setNombre(rs.getString("nombre_oficina"));
        return o;
    }
    public ArrayList cargarOficina() {//this method  what does is select every one of the offices it in database for then send them to the graphic interface
        ArrayList oficina = new ArrayList();
        try (Connection con = Conexion.conexion()) {
            String sql = "select nombre_oficina from oficina order by nombre_oficina";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                oficina.add(rs.getString("nombre_oficina"));
            }
        } catch (Exception ex) {
            throw new MiError("Error al extaer las modelo." + ex);
        }
        return oficina;
    }
    public boolean modificarOficina(Oficina ofi) throws SQLException{//this method is what does is receiving the information edited of the graphical interface for then save it in database
        String nombre = ofi.getNombre();
        String modificado = ofi.getNombremodificado();
        try(Connection con = Conexion.conexion()){
            String sql = "UPDATE oficina SET nombre_oficina = ? where nombre_oficina = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setString(2, modificado);
            return stmt.executeUpdate() > 0;
            
        }catch(Exception ex){
            throw new MiError("Falla al momento de modificar oficina.");
        }
    }
    public boolean eliminarOficina(Oficina ofi) throws SQLException {//this method  what does is receiving the office select in the graphical interface for then delete it in database.
        try (Connection con = Conexion.conexion()) {
            String sql = "DELETE FROM oficina WHERE nombre_oficina = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, ofi.getNombre());

            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            throw new MiError("Falla al eliminar el modelo.");
        }
    }
}
