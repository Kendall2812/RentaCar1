/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import java.sql.SQLException;
import dao.EstilosDAO;
import entities.Estilo;
import entities.MiError;

/**
 *
 * @author Kendall
 */
public class EstiloBO {

    public boolean verificarEstilo(Estilo es) throws SQLException {
        if (es.getNombre().isEmpty()) {
            throw new MiError("");
        }
        EstilosDAO esdao = new EstilosDAO();
        return esdao.insertarEstilo(es);
    }
}
