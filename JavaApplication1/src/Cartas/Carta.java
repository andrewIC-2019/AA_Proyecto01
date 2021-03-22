/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cartas;

/**
 *
 * @author bryand
 */
public class Carta {
    String nombre;
    Tipo tipo;
    boolean correcto;
    boolean solucion;

    public Carta(String nombre, Tipo tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        correcto = true;
        solucion = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public boolean isCorrecto() {
        return correcto;
    }

    public void setCorrecto(boolean correcto) {
        this.correcto = correcto;
    }

    public boolean isSolucion() {
        return solucion;
    }

    public void setSolucion(boolean solucion) {
        this.solucion = solucion;
    }

    @Override
    public String toString() {
        return "Carta: "  + nombre + ", tipo: " + tipo + ", posible solucion: " + correcto + ", parte de la solucion: " + solucion;
    }
    
    
}
