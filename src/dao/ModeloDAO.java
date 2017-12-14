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
import entities.Modelo;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author jenni
 */

public class ModeloDAO {

    public boolean insertarModelo(Modelo r) throws SQLException {
        try (Connection con = Conexion.conexion()) {
            String sql = "insert into modelo(nombre_modelo)"
                    + "values (?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, r.getNombre());           
            return stmt.executeUpdate() > 0;

        } catch (Exception ex) {
            throw new MiError("El modelo de vehiculo ya se encuentra registrado.");
        }

    }
    public ArrayList cargarModelo() {
        ArrayList modelo = new ArrayList();
        try (Connection con = Conexion.conexion()) {
            String sql = "select nombre_modelo from modelo order by nombre_modelo";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                modelo.add(rs.getString("nombre_modelo"));
            }
        } catch (Exception ex) {
            throw new MiError("Error al extaer las modelo." + ex);
        }
        return modelo;
    }
    public boolean modificarMarca(Modelo mod) throws SQLException{
        String nombre = mod.getNombre();
        String modificado = mod.getNombremodificado();
        try(Connection con = Conexion.conexion()){
            String sql = "UPDATE modelo SET nombre_modelo = ? where nombre_modelo = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setString(2, modificado);
            return stmt.executeUpdate() > 0;
            
        }catch(Exception ex){
            throw new MiError("Falla al momento de modificar modelo.");
        }
    }
    public boolean eliminarModelo(Modelo eli) throws SQLException {
        try (Connection con = Conexion.conexion()) {
            String sql = "DELETE FROM modelo WHERE nombre_modelo = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, eli.getNombre());

            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            throw new MiError("Falla al eliminar el modelo.");
        }
    }
}
