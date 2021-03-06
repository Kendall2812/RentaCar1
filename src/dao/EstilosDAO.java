/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import entities.Estilo;
import entities.MiError;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Kendall
 */
public class EstilosDAO {//this method is what does is receiving the information of the graphical interface for then save it in database
    public boolean insertarEstilo(Estilo es) throws SQLException{
        try(Connection con = Conexion.conexion()){
            String sql = "insert into estilo(nombre_estilo)"
                    + "values (?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, es.getNombre());
            return stmt.executeUpdate() > 0;
            
        }catch(Exception ex){
            throw new MiError("El estilo de vehiculo ya se encuentra registrado.");
        } 
    }
    public ArrayList cargarEstilos() {//this method  what does is select every one of the styles it in database for then send them to the graphic interface 
        ArrayList estilos = new ArrayList();
        try (Connection con = Conexion.conexion()) {
            String sql = "select nombre_estilo from estilo order by nombre_estilo";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                estilos.add(rs.getString("nombre_estilo"));
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar los usuarios");
        }
        return estilos;

    }

    public boolean modificarEstilo(Estilo mod) throws SQLException{//this method is what does is receiving the information edited of the graphical interface for then save it in database
        String nombre = mod.getNombre();
        String modificado = mod.getNombremodificado();
        try(Connection con = Conexion.conexion()){
            String sql = "UPDATE estilo SET nombre_estilo = ? where nombre_estilo = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setString(2, modificado);
            return stmt.executeUpdate() > 0;
            
        }catch(Exception ex){
            throw new MiError("Falla al momento de modificar estilo.");
        }
    }
    public boolean eliminarEstilo(Estilo eli) throws SQLException{//this method  what does is receiving the style select in the graphical interface for then delete it in database.
        try(Connection con = Conexion.conexion()){
            String sql = "DELETE FROM estilo WHERE nombre_estilo = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, eli.getNombre());
        
            return stmt.executeUpdate() > 0;
        }catch(Exception ex){
            throw new MiError("Falla al eliminar el estilo.");
        }
    }
}
