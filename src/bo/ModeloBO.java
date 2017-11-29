/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import java.sql.SQLException;
import dao.ModeloDAO;
import dao.UsuAdmDAO;
import entities.MiError;
import entities.Modelo;


/**
 *
 * @author Kendall
 */
public class ModeloBO {

    public boolean verificarModelo(Modelo r) throws SQLException {
        if (r.getNombre().isEmpty()){
            throw new MiError("");
        }
        ModeloDAO idao = new ModeloDAO();
        return idao.insertarModelo(r);
    }

}
