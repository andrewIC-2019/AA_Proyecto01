
package PruebasRapidas;

import AlgortimoFuerzaBruta.Algoritmo;
import static Cartas.CrearMazo.CrearMazo;
import Cartas.MazoGeneral;

public class Controlador {
    private static int numRes;
    private static MazoGeneral mazo;
    private static Algoritmo prueba;    // Crea la clase que contiene el algoritmo. Recibe el mazo que debe trabajar
    private static MazoGeneral mazo2;
    private static Algoritmo prueba2;
    
    public static String iniciarJuego(String pNumRestri){
        numRes= Integer.parseInt(pNumRestri);   //Obtiene el numero de restricciones indicados en el JSpinner
        mazo = CrearMazo(numRes);               // Recibe el numero de restricciones. Se llevaría a cabo al presionar el boton JUGAR
        prueba = new Algoritmo(mazo);           //Inicar FB
        mazo2 = CrearMazo(0);                   // Crea mazo 2   
        mazo2.setListaRestricciones(mazo.getListaRestricciones());  // Setea las mismas restricciones del mazo1
        mazo2.setSolucion(mazo.getSolucion());                      // Setea la misma solucion
        prueba2 = new Algoritmo(mazo2);         // Crea otra instancia de Algoritmo
        
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
        
        String theOutput = "";                                      //Almacena la salida
        String retrnFb = String.valueOf(prueba.FuerzaBruta());      // Llama al de fuerza bruta, retorna long y convierte
        /**
        String[] retrnFbArray = retrnFb.split(";"); // Separar el dato del output y tiempo
        String salidaFb = retrnFbArray[0];          // Output
        **/
        String salidaFb = "";       //ahora las posibles soluciones las saca de ListaSoluciones
        int ips;                    //iterador posible solucion
        for (ips=0; ips<prueba.getListaSoluciones().size(); ips++){
            salidaFb += prueba.getListaSoluciones().get(ips).toString()+"\n";
        }
        salidaFb += String.valueOf(ips);
        String tiempoFb = retrnFb;          // Tiempo FB (aignacion con el fin de mayor orden en los nombres)
        
        
        String retrnBt = String.valueOf(prueba2.BacktrackingRecursivo());
        
        String salidaBt = "";               // Soluciones que propuso el backtracking
        int ibt;
        for (ibt=4; ibt<prueba2.getListaSoluciones().size(); ibt++){            //las 4 primeras tienen un Temporal
            salidaBt += prueba2.getListaSoluciones().get(ibt).toString()+"\n";
        }
        salidaBt += String.valueOf(ibt-4);                                      //le quito los 4 del temporal
        String tiempoBt = retrnBt;
        
        //Finalmente se retorna toda la info
        theOutput = strSolucion+";"+lasRestricciones+";"+salidaFb+";"+tiempoFb+";"+salidaBt+";"+tiempoBt;
        return theOutput;
    }
}
