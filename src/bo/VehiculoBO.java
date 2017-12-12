/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import dao.VehiculoDAO;
import entities.MiError;
import entities.Vehiculo;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jenni
 */
public class VehiculoBO {

    public boolean registrarVehi(Vehiculo vehi) {
        if (vehi.getEstado().isEmpty()) {
            throw new MiError("Requiere el estado");
        }
        if (vehi.getFoto() == null) {
            throw new MiError("Requiere la foto");
        }
        if (vehi.getMarca().isEmpty()) {
            throw new MiError("Requiere la marca");
        }
        if (vehi.getPlaca().isEmpty()) {
            throw new MiError("Requiere la placa");
        }
        if (vehi.getModelo().isEmpty()) {
            throw new MiError("Requiere el modelo");
        }
        if (vehi.getTransmision().isEmpty()) {
            throw new MiError("Requiere la transmision");
        }
        if (vehi.getAño() == 0) {
            throw new MiError("Requiere el año");
        }
        if (vehi.getPrecio() == 0) {
            throw new MiError("Requiere el precio");
        }
        if (vehi.getEstilo().isEmpty()) {
            throw new MiError("Requiere el estilo");
        }
        if (vehi.getDireccion_foto().isEmpty()) {
            throw new MiError("Requiere la foto");
        }
        VehiculoDAO veDao = new VehiculoDAO();
        return veDao.insertarVehi(vehi);

    }

    public boolean EliminarVehiculo(Vehiculo vehi) throws SQLException {
        if (vehi.getPlaca().isEmpty()) {
            throw new MiError("Se requiere la placa");
        }
        VehiculoDAO veDao = new VehiculoDAO();
        return veDao.EliminarVehi(vehi);
    }
    public ArrayList reporteConsultaPorEstado(Vehiculo vehi){
        if(vehi.getEstado().isEmpty()){
            throw new MiError("Requiere el estado.");
        }
        VehiculoDAO veDao = new VehiculoDAO();
        return veDao.cargarVehiculoEstado(vehi);
    }
      public boolean ModificarVehi(Vehiculo vehi, String plaOri) {
        if (vehi.getEstado().isEmpty()) {
            throw new MiError("Requiere el estado");
        }
        if (vehi.getFoto() == null) {
            throw new MiError("Requiere la foto");
        }
        if (vehi.getMarca().isEmpty()) {
            throw new MiError("Requiere la marca");
        }
        if (vehi.getPlaca().isEmpty()) {
            throw new MiError("Requiere la placa");
        }
        if (vehi.getModelo().isEmpty()) {
            throw new MiError("Requiere el modelo");
        }
        if (vehi.getTransmision().isEmpty()) {
            throw new MiError("Requiere la transmision");
        }
        if (vehi.getAño() == 0) {
            throw new MiError("Requiere el año");
        }
        if (vehi.getPrecio() == 0) {
            throw new MiError("Requiere el precio");
        }
        if (vehi.getEstilo().isEmpty()) {
            throw new MiError("Requiere el estilo");
        }
        VehiculoDAO veDao = new VehiculoDAO();
        return veDao.modiVehi(vehi, plaOri);

    }
      public String imagenes3(Vehiculo vehi){
        if (vehi.getPlaca().isEmpty()) {
            throw new MiError("Requiere foto");
        }
        
        VehiculoDAO veDao = new VehiculoDAO();
        return veDao.fotoVehiculo(vehi); 
      }
}
