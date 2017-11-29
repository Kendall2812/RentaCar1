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

/**
 *
 * @author jenni
 */
public class ModeloDAO {

    public boolean insertarModelo(Modelo r) throws SQLException {
        try (Connection con = Conexion.conexion()) {
            String sql = "insert into modelo(nombremodelo)"
                    + "values (?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, r.getNombre());           
            return stmt.executeUpdate() > 0;

        } catch (Exception ex) {
            throw new MiError("El modelo de vehiculo ya se encuentra registrado.");
        }

    }
}
