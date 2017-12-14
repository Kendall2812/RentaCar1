/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import java.sql.SQLException;
import dao.OficinaDAO;
import entities.MiError;
import entities.Oficina;

/**
 *
 * @author Kendall
 */
//The methods of this class what they do is verify that each of the variables that are used contain information for then call the method where the information 
//will be stored in the database and otherwise if the variable does not contain information it will be is generate a mistake.
public class OficinaBO {
    public boolean verificarOficina(Oficina ofi) throws SQLException{
        if(ofi.getNombre().isEmpty()){
            throw new MiError("");
        }
        OficinaDAO ofidao = new OficinaDAO();
        return ofidao.registroOficina(ofi);
    }
    public boolean editarOficina(Oficina ofi) throws SQLException {
        if (ofi.getNombre().isEmpty()) {
            throw new MiError("");
        }
        if (ofi.getNombremodificado().isEmpty()) {
            throw new MiError("");
        }
        OficinaDAO ofidao = new OficinaDAO();
        return ofidao.modificarOficina(ofi);
    }
    public boolean EliminarOficina(Oficina ofi) throws SQLException {
        if (ofi.getNombre().isEmpty()) {
            throw new MiError("");
        }
        OficinaDAO ofidao = new OficinaDAO();
        return ofidao.eliminarOficina(ofi);
    } 
}
