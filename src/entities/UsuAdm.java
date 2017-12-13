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
public class UsuAdm {

    private int cedula;
    private int telefono;
    private String nombre;
    private String direccion;
    private String contraseña;
    private boolean tipo;
    private Image foto;
    private String direccion_foto;

    public UsuAdm(int cedula, String nombre, int telefono, String direccion, String contraseña, boolean tipo, Image foto,String direccion_foto) {

        this.cedula = cedula;
        this.telefono = telefono;
        this.nombre = nombre;
        this.direccion = direccion;
        this.contraseña = contraseña;
        this.tipo = tipo;
        this.foto = foto;
        this.direccion_foto = direccion_foto;

    }

    public UsuAdm() {

    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
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

    @Override
    public String toString() {
        return "users{" + "cedula=" + cedula + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + ", contraseña=" + contraseña + ", tipo=" + tipo + ", foto=" + foto + ", direccion_foto=" + direccion_foto + '}';
    }

}
