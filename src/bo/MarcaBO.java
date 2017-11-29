/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import java.sql.SQLException;
import dao.MarcaDAO;
import entities.Marca;
import entities.MiError;

/**
 *
 * @author Kendall
 */
public class MarcaBO {

    public boolean verificarMarca(Marca mar) throws SQLException {
        if (mar.getNombre().isEmpty()) {
            throw new MiError("");
        }
        MarcaDAO mardao = new MarcaDAO();
        return mardao.registroMarca(mar);
    }
}
