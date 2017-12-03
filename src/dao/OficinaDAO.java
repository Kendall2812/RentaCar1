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
import java.sql.ResultSet;
import java.util.ArrayList;

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
    public ArrayList cargarOficina() {
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
    public boolean modificarOficina(Oficina ofi) throws SQLException{
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
    public boolean eliminarOficina(Oficina ofi) throws SQLException {
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
