/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import java.sql.SQLException;
import dao.ModeloDAO;
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
    public boolean editarModelo(Modelo mod) throws SQLException {
        if (mod.getNombre().isEmpty()) {
            throw new MiError("");
        }
        if (mod.getNombremodificado().isEmpty()) {
            throw new MiError("");
        }
        ModeloDAO moddao = new ModeloDAO();
        return moddao.modificarMarca(mod);
    }
    public boolean EliminarMarca(Modelo eli) throws SQLException {
        if (eli.getNombre().isEmpty()) {
            throw new MiError("");
        }
        ModeloDAO moddao = new ModeloDAO();
        return moddao.eliminarModelo(eli);
    } 
}
