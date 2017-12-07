/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import dao.RentaDAO;
import entities.MiError;
import entities.Renta;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Kendall
 */
public class RentaBO {
    public ArrayList extraerPorRangoFechas(Renta r){
        if (r.getFechaDevolu().isEmpty()){
            throw new MiError("");
        }
        if (r.getFechaRetiro().isEmpty()){
            throw new MiError("");
        }
        RentaDAO idao = new RentaDAO();
        return idao.reporteDeRangoFechasRenta(r);
    }
}
