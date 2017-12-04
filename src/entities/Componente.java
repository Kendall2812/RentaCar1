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
public class Componente {

    private int id;
    private String nombre;
    private String nombremodificado;

    public Componente(int id, String nombre, String nombremodificado) {
        this.id = id;
        this.nombre = nombre;
        this.nombremodificado = nombremodificado;
    }

    public Componente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombremodificado() {
        return nombremodificado;
    }

    public void setNombremodificado(String nombremodificado) {
        this.nombremodificado = nombremodificado;
    }
}
