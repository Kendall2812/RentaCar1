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

    public boolean editarMarca(Marca mar) throws SQLException {
        if (mar.getNombre().isEmpty()) {
            throw new MiError("");
        }
        if (mar.getNombremodificado().isEmpty()) {
            throw new MiError("");
        }
        MarcaDAO mardao = new MarcaDAO();
        return mardao.modificarMarca(mar);
    }

    public boolean EliminarMarca(Marca eli) throws SQLException {
        if (eli.getNombre().isEmpty()) {
            throw new MiError("");
        }
        MarcaDAO mardao = new MarcaDAO();
        return mardao.eliminarMarca(eli);
    } 
}
