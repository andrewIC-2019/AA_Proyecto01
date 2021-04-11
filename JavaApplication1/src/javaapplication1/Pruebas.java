/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;


import AlgortimoFuerzaBruta.Algoritmo;
import Cartas.Carta;
import static Cartas.CrearMazo.CrearMazo;
import Cartas.MazoGeneral;
import static Cartas.Tipo.*;
import java.util.ArrayList;

/**
 *
 * @author bryan
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MazoGeneral mazo = CrearMazo(1000);            // Recibe el numero de restricciones. Se llevaría a cabo al presionar el boton JUGAR
        Algoritmo prueba = new Algoritmo(mazo);     

        System.out.println(prueba.Backtracking());
 
        MazoGeneral mazo2 = CrearMazo(0);            // Crea mazo 2   
        mazo2.setListaRestricciones(mazo.getListaRestricciones());  // Setea las mismas restricciones del mazo1
        mazo2.setSolucion(mazo.getSolucion());                      // Setea la misma solucion
        Algoritmo prueba2 = new Algoritmo(mazo2);                   // Crea otra instancia de Algoritmo

        System.out.println(prueba2.FuerzaBruta());        //Hago la llamada
        
        
    }
}
