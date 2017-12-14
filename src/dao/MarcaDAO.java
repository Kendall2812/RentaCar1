/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import entities.Marca;
import entities.MiError;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Kendall
 */

public class MarcaDAO {
    public boolean registroMarca(Marca mar)throws SQLException{//this method is what does is receiving the information of the graphical interface for then save it in database
        try (Connection con = Conexion.conexion()) {
            String sql = "insert into marca(nombre_marca)"
                    + "values (?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, mar.getNombre());
            return stmt.executeUpdate() > 0;

        } catch (Exception ex) {
            throw new MiError("La marca ya se encuentra registrada.");
        }
    }
    public ArrayList cargarMarcas() {//this method  what does is select every one of the brands it in database for then send them to the graphic interface 
        ArrayList marcas = new ArrayList();
        try (Connection con = Conexion.conexion()) {
            String sql = "select nombre_marca from marca order by nombre_marca";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                marcas.add(rs.getString("nombre_marca"));
            }
        } catch (Exception ex) {
            throw new MiError("Error al extaer las marcas." + ex);
        }
        return marcas;
    }
    public boolean modificarMarca(Marca mod) throws SQLException{//this method is what does is receiving the information edited of the graphical interface for then save it in database
        String nombre = mod.getNombre();
        String modificado = mod.getNombremodificado();
        try(Connection con = Conexion.conexion()){
            String sql = "UPDATE marca SET nombre_marca = ? where nombre_marca = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setString(2, modificado);
            return stmt.executeUpdate() > 0;
            
        }catch(Exception ex){
            throw new MiError("Falla al momento de modificar estilo.");
        }
    }
    public boolean eliminarMarca(Marca eli) throws SQLException {//this method  what does is receiving the brand select in the graphical interface for then delete it in database.
        try (Connection con = Conexion.conexion()) {
            String sql = "DELETE FROM marca WHERE nombre_marca = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, eli.getNombre());

            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            throw new MiError("Falla al eliminar el estilo.");
        }
    }
}
