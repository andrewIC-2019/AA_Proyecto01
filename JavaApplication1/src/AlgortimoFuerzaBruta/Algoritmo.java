/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgortimoFuerzaBruta;

import Cartas.*;
import java.util.ArrayList;

/**
 *
 * @author bryan
 */
public class Algoritmo {
    MazoGeneral mazo;
    ArrayList<ArrayList<Carta>> listaSoluciones;
    ArrayList<Carta> cartasSaltadas;

    public Algoritmo(MazoGeneral mazo) {
        this.mazo = mazo;
        listaSoluciones = new ArrayList<>();
        cartasSaltadas = new ArrayList<>();
    }
    
    public long FuerzaBruta(){                                      // long: Retorna el tiempo tardado
        
        ArrayList<Carta> posibleSolucion;
        ArrayList<Carta> solucion = mazo.getSolucion();
        
        Carta temp = new Carta("Temporal", Tipo.Arma);
        posibleSolucion= new ArrayList<>();
        posibleSolucion.add(temp);
        posibleSolucion.add(temp);
        posibleSolucion.add(temp);
        posibleSolucion.add(temp);
        posibleSolucion.add(temp);
        
        ArrayList<Carta> mazoSospechoso = mazo.getListaMasos().get(0).getCartas();
        ArrayList<Carta> mazoArma = mazo.getListaMasos().get(1).getCartas();
        ArrayList<Carta> mazoMotivo = mazo.getListaMasos().get(2).getCartas();
        ArrayList<Carta> mazoParteCuerpo = mazo.getListaMasos().get(3).getCartas();
        ArrayList<Carta> mazoLugar = mazo.getListaMasos().get(4).getCartas();
        
        ArrayList<ArrayList<Carta>> mazos= new ArrayList<>();
        mazos.add(mazoSospechoso);
        mazos.add(mazoArma);
        mazos.add(mazoMotivo);
        mazos.add(mazoParteCuerpo);
        mazos.add(mazoLugar);
        
        long tiempoInicio = System.nanoTime();
        long tiempoFinal = auxiliar(posibleSolucion, mazos, 0, solucion);
        if(tiempoFinal >-1)
            return tiempoFinal-tiempoInicio;
        return -1;
    }

    public ArrayList<ArrayList<Carta>> getListaSoluciones() {
        return listaSoluciones;
    }
    
    private boolean Poda(ArrayList<Carta> posibleSolucion){
        
        ArrayList<ArrayList<Carta>> listaRestricciones = mazo.getListaRestricciones();
        for (int i = 0; i < listaRestricciones.size(); i++) {
            ArrayList<Carta> get = listaRestricciones.get(i);
            if(posibleSolucion.indexOf(get.get(0)) != -1 && posibleSolucion.indexOf(get.get(1)) != -1){
                return true;                                                                            //Retorna indicando que si hay restriccion
            }   
        }
        return false;
    }
    
    public long BacktrackingRecursivo(){
        ArrayList<Carta> posibleSolucion;
        ArrayList<Carta> solucion = mazo.getSolucion();
        
        Carta temp = new Carta("Temporal", Tipo.Arma);
        posibleSolucion= new ArrayList<>();
        posibleSolucion.add(temp);
        posibleSolucion.add(temp);
        posibleSolucion.add(temp);
        posibleSolucion.add(temp);
        posibleSolucion.add(temp);
        
        ArrayList<Carta> mazoSospechoso = mazo.getListaMasos().get(0).getCartas();
        ArrayList<Carta> mazoArma = mazo.getListaMasos().get(1).getCartas();
        ArrayList<Carta> mazoMotivo = mazo.getListaMasos().get(2).getCartas();
        ArrayList<Carta> mazoParteCuerpo = mazo.getListaMasos().get(3).getCartas();
        ArrayList<Carta> mazoLugar = mazo.getListaMasos().get(4).getCartas();
        
        ArrayList<ArrayList<Carta>> mazos= new ArrayList<>();
        mazos.add(mazoSospechoso);
        mazos.add(mazoArma);
        mazos.add(mazoMotivo);
        mazos.add(mazoParteCuerpo);
        mazos.add(mazoLugar);
        
        long tiempoInicio = System.nanoTime();
        long tiempoFinal = auxiliarB(posibleSolucion, mazos, 0, solucion);
        if(tiempoFinal >-1)
            return tiempoFinal-tiempoInicio;
        return -1;
    }
    
    private long auxiliar(ArrayList<Carta> posibleSolucion, ArrayList<ArrayList<Carta>> mazos, int i
            ,ArrayList<Carta> solucion){
        
        ArrayList<Carta> mazoActual = mazos.get(i);
        for (int j = 0; j < mazoActual.size(); j++) {
            Carta get = mazoActual.get(j);
            while(!get.isCorrecto() && j < mazoActual.size()-1){
                j++;
                get = mazoActual.get(j);                
                             
            }
            posibleSolucion.set(i,get);
            ArrayList<Carta> tempS = (ArrayList<Carta>) posibleSolucion.clone();
            listaSoluciones.add(tempS);
            if(posibleSolucion.equals(solucion)){

                long tiempoFinal = System.nanoTime();                
                return tiempoFinal;                   
            }
            else{
                mazo.MarcarCartaIncorrecta();
                if(i<mazos.size()-1){                    
                    long tiempo = auxiliar(posibleSolucion,mazos,i+1,solucion);  
                    if (tiempo != -1) {
                        return tiempo;                        
                    }
                }
                
            }
        }
        return -1;
    }
    
    private long auxiliarB(ArrayList<Carta> posibleSolucion, ArrayList<ArrayList<Carta>> mazos, int i
            ,ArrayList<Carta> solucion){
        Carta get;
        ArrayList<Carta> mazoActual = mazos.get(i);
        for (int j = 0; j < mazoActual.size(); j++) {
            get = mazoActual.get(j);
            posibleSolucion.set(i,get);
            while(j < mazoActual.size()-1 && (!get.isCorrecto() || Poda(posibleSolucion)))   {
                j++;
                get = mazoActual.get(j);                
                posibleSolucion.set(i,get);             
            }
            ArrayList<Carta> tempS = (ArrayList<Carta>) posibleSolucion.clone();
            listaSoluciones.add(tempS);
            if(posibleSolucion.equals(solucion)){

                long tiempoFinal = System.nanoTime();                
                return tiempoFinal;                   
            }
            else{
                mazo.MarcarCartaIncorrecta();
                if(i<mazos.size()-1){                    
                    long tiempo = auxiliar(posibleSolucion,mazos,i+1,solucion);  
                    if (tiempo != -1) {
                        return tiempo;                        
                    }
                }
                
            }
        }
        get = mazoActual.get(0);
        posibleSolucion.set(i,get);
        return -1;
    }
    
}
