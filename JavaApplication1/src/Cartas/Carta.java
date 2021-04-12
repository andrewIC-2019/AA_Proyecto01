/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cartas;

import java.util.Objects;

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
        return nombre + " ";            // Cambio en el return, ahora Solo muestra el nombre
        //return "Carta: "  + nombre + ", tipo: " + tipo + ", posible solucion: " + correcto + ", parte de la solucion: " + solucion;
    }

    @Override
    public int hashCode() {             //Siempre que se aplica un override al equals, se recomienda hacerlo al hash
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.nombre);
        hash = 13 * hash + Objects.hashCode(this.tipo);
        return hash;
    }

    @Override                           //Sobre-escribe al equals, para esta clase
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carta other = (Carta) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        return true;
    }
    
    
}
