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
}
