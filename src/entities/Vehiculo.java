/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.awt.Image;

/**
 *
 * @author jenni
 */
public class Vehiculo {

    private String placa;
    private String marca;
    private String estilo;
    private String transmision;
    private String estado;
    private String modelo;
    private int año;
    private int precio;
    private Image foto;
    private String direccion_foto;

    public Vehiculo(String placa, String marca, String estilo, String transmision, String estado, String modelo, int año, int precio, Image foto, String direccion_foto) {
        this.placa = placa;
        this.marca = marca;
        this.estilo = estilo;
        this.transmision = transmision;
        this.estado = estado;
        this.modelo = modelo;
        this.año = año;
        this.precio = precio;
        this.foto = foto;
        this.direccion_foto = direccion_foto;
    }

    public Vehiculo() {

    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public String getDireccion_foto() {
        return direccion_foto;
    }

    public void setDireccion_foto(String direccion_foto) {
        this.direccion_foto = direccion_foto;
    }

}
