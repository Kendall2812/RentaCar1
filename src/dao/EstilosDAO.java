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

/**
 *
 * @author Kendall
 */
public class EstilosDAO {
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
}
