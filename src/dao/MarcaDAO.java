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

/**
 *
 * @author Kendall
 */
public class MarcaDAO {
    public boolean registroMarca(Marca mar)throws SQLException{
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
}
