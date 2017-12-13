/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import dao.UsuAdmDAO;
import entities.MiError;
import entities.UsuAdm;
import java.util.ArrayList;

/**
 *
 * @author jenni
 */
public class UserBO {

    public boolean registrarUser(UsuAdm u) {
        if (u.getNombre().isEmpty()) {
            throw new MiError("Nombre requerido");
        }
        if (u.getContraseña().isEmpty()) {
            throw new MiError("Contraseña requerida");
        }
        if (u.getDireccion().isEmpty()) {
            throw new MiError("Direccion requerida");
        }
        if (u.getFoto() == null) {
            throw new MiError("Foto requerida");
        }
        if (u.getDireccion_foto() == null) {
            throw new MiError("Foto requerida");
        }
        UsuAdmDAO idao = new UsuAdmDAO();
        return idao.insertar(u);
    }
}
