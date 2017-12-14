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
//The methods of this class what they do is verify that each of the variables that are used contain information for then call the method where the information 
//will be stored in the database and otherwise if the variable does not contain information it will be is generate a mistake.
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
        return moddao.modificarModelo(mod);
    }
    public boolean EliminarModelo(Modelo eli) throws SQLException {
        if (eli.getNombre().isEmpty()) {
            throw new MiError("");
        }
        ModeloDAO moddao = new ModeloDAO();
        return moddao.eliminarModelo(eli);
    } 
}
