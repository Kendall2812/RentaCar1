/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author jenni
 */
public class Renta {

    private String placa;
    private String nombre;
    private String ofiRetiro;
    private String ofiDevolu;
    private String fechaRetiro;
    private String horaRetiro;
    private String fechaDevolu;
    private String horaDevolu;
    private int cedula;
    private int precio;

    public Renta(String placa, String nombre, String ofiRetiro, String ofiDevolu, String fechaRetiro, String horaRetiro, String fechaDevolu, String horaDevolu, int cedula, int precio) {
        this.placa = placa;
        this.nombre = nombre;
        this.ofiRetiro = ofiRetiro;
        this.ofiDevolu = ofiDevolu;
        this.fechaRetiro = fechaRetiro;
        this.horaRetiro = horaRetiro;
        this.fechaDevolu = fechaDevolu;
        this.horaDevolu = horaDevolu;
        this.cedula = cedula;
        this.precio = precio;
    }

    public Renta() {

    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOfiRetiro() {
        return ofiRetiro;
    }

    public void setOfiRetiro(String ofiRetiro) {
        this.ofiRetiro = ofiRetiro;
    }

    public String getOfiDevolu() {
        return ofiDevolu;
    }

    public void setOfiDevolu(String ofiDevolu) {
        this.ofiDevolu = ofiDevolu;
    }

    public String getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(String fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public String getHoraRetiro() {
        return horaRetiro;
    }

    public void setHoraRetiro(String horaRetiro) {
        this.horaRetiro = horaRetiro;
    }

    public String getFechaDevolu() {
        return fechaDevolu;
    }

    public void setFechaDevolu(String fechaDevolu) {
        this.fechaDevolu = fechaDevolu;
    }

    public String getHoraDevolu() {
        return horaDevolu;
    }

    public void setHoraDevolu(String horaDevolu) {
        this.horaDevolu = horaDevolu;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

}
