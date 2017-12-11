/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import dao.RentaDAO;
import dao.UsuAdmDAO;
import entities.MiError;
import entities.Renta;
import entities.UsuAdm;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Kendall
 */
public class RentaBO {

    public ArrayList extraerPorRangoFechas(Renta r) {
        if (r.getFechaDevolu()== null) {
            throw new MiError("");
        }
        if (r.getFechaRetiro()== null) {
            throw new MiError("");
        }
        RentaDAO idao = new RentaDAO();
        return idao.reporteDeRangoFechasRenta(r);
    }

    public boolean registrarRenta(Renta u) {
        if (u.getNombre().isEmpty()) {
            throw new MiError("Nombre requerido");
        }
        if (u.getCedula() == 0) {
            throw new MiError("Cedula requerida");
        }
        if (u.getFechaDevolu()== null) {
            throw new MiError("Fecha de devolucion requerida");
        }
        if (u.getFechaRetiro()== null) {
            throw new MiError("Fecha de retiro requerida");
        }
        if (u.getHoraDevolu().isEmpty()) {
            throw new MiError("Hora de devolucion requerida");
        }
        if (u.getHoraRetiro().isEmpty()) {
            throw new MiError("Hora de retiro requerida");
        }
        if (u.getOfiDevolu().isEmpty()) {
            throw new MiError("Oficina de devolucion requerida");
        }
        if (u.getOfiRetiro().isEmpty()) {
            throw new MiError("Oficina de retiro requerida");
        }
        if (u.getPlaca().isEmpty()) {
            throw new MiError("Placa requerida");
        }
        if (u.getPrecio() == 0) {
            throw new MiError("Precio requerido");
        }

        RentaDAO idao = new RentaDAO();
        return idao.insertarRenta(u);
    }
}
