
package PruebasRapidas;

import AlgortimoFuerzaBruta.Algoritmo;
import static Cartas.CrearMazo.CrearMazo;
import Cartas.MazoGeneral;

public class Controlador {
    private static int numRes;
    private static MazoGeneral mazo;
    private static Algoritmo prueba;    // Crea la clase que contiene el algoritmo. Recibe el mazo que debe trabajar
    
    public static String iniciarJuego(String pNumRestri){
        numRes= Integer.parseInt(pNumRestri);   //Obtiene el numero de restricciones indicados en el JSpinner
        mazo = CrearMazo(numRes);               // Recibe el numero de restricciones. Se llevaría a cabo al presionar el boton JUGAR
        prueba = new Algoritmo(mazo);     
        
        //Solucion
        String strSolucion =                        //Esto obtiene la solucion
                "Fue "+mazo.getSolucion().get(0)+
                "con "+mazo.getSolucion().get(1)+
                "por "+mazo.getSolucion().get(2)+
                "en "+mazo.getSolucion().get(3)+
                "dentro de "+mazo.getSolucion().get(4);
        
        //Restricciones
        String lasRestricciones = mazo.salidaRestricciones();
        
        //Fuerza Bruta
        
        String theOutput = "";
        String retrnFb = prueba.FuerzaBruta();      // Llama al de fuerza bruta
        String[] retrnFbArray = retrnFb.split(";"); // Separar el dato del output y tiempo
        String salidaFb = retrnFbArray[0];          // Output
        String tiempoFb = retrnFbArray[1];          // Tiempo
         
        //Finalmente se retorna toda la info
        theOutput = strSolucion+";"+lasRestricciones+";"+salidaFb+";"+tiempoFb;
        return theOutput;
    }
}
