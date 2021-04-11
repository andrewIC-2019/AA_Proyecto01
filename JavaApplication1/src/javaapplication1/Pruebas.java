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
        
        System.out.println(prueba.BacktrackingRecursivo());

        MazoGeneral mazo2 = CrearMazo(0);
        mazo2.setListaRestricciones(mazo.getListaRestricciones());
        mazo2.setSolucion(mazo.getSolucion());
        
        
    }
}
