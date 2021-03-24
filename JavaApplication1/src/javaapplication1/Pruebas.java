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
        // TODO code application logic here
        MazoGeneral mazo = CrearMazo(0);
        Algoritmo prueba = new Algoritmo(mazo);
        prueba.FuerzaBruta();
        for (int i = 0; i < prueba.getListaSoluciones().size(); i++) {
            System.out.println(prueba.getListaSoluciones().get(i));
            
        }
        
    }
}
