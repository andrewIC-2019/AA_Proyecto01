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
        MazoGeneral mazo = CrearMazo(0);            // Recibe el numero de restricciones. Se llevaría a cabo al presionar el boton JUGAR
        Algoritmo prueba = new Algoritmo(mazo);     // Crea la clase que contiene el algoritmo. Recibe el mazo que debe trabajar
        
        String retrnFb = prueba.FuerzaBruta();      // Llama al de fuerza bruta
        String[] retrnFbArray = retrnFb.split(";"); // Separar el dato del output y tiempo
        String salidaFb = retrnFbArray[0];          // Output
        String tiempoFb = retrnFbArray[1];          // Tiempo
        System.out.println("Ok entonces tenemos la salida: "+salidaFb+"Con un tiempo de: "+tiempoFb);
        
        String strSolucion =                        //Esto obtiene la solucion
                "Fue "+mazo.getSolucion().get(0)+
                "con "+mazo.getSolucion().get(1)+
                "por "+mazo.getSolucion().get(2)+
                "en "+mazo.getSolucion().get(3)+
                "dentro de "+mazo.getSolucion().get(4);
        System.out.println(strSolucion);
        
        System.out.println("Y las restricciones...\n"+mazo.salidaRestricciones());
        
        
    }
}
