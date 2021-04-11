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

    public Algoritmo(MazoGeneral mazo) {
        this.mazo = mazo;
        listaSoluciones = new ArrayList<>();
    }
    
    public long FuerzaBruta(){                                      // long: Retorna el tiempo tardado
        
        ArrayList<Carta> posibleSolucion;
        ArrayList<Carta> solucion = mazo.getSolucion();
        int sospechoso;
        int arma;
        int motivo;
        int parteCuerpo;
        int lugar;
        //String salida = "";                   // Almacena el texto que se mostrara al usuario
        //String tiempoFb;                      // Para retornar el tiempo junto a la salida
        
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
        
        long tiempoInicio = System.nanoTime();
        long tiempoFinal = 0;
        for (sospechoso = 0; sospechoso < mazoSospechoso.size(); sospechoso++) {
            
            Carta getSospechoso = mazoSospechoso.get(sospechoso);
            while(!getSospechoso.isCorrecto()&& sospechoso < mazoSospechoso.size()-1){
                sospechoso++;
                getSospechoso = mazoSospechoso.get(sospechoso);                
            }
            posibleSolucion.set(0,getSospechoso);
            
            for (arma = 0; arma < mazoArma.size(); arma++){
                Carta getArma = mazoArma.get(arma);
                while(!getArma.isCorrecto()&& arma < mazoArma.size()-1){
                    arma++;
                    getArma = mazoArma.get(arma);                
                }
                posibleSolucion.set(1,getArma);
                
                for (motivo = 0; motivo < mazoMotivo.size(); motivo++){
                    Carta getMotivo = mazoMotivo.get(motivo);
                    while(!getMotivo.isCorrecto()&& motivo < mazoMotivo.size()-1){
                        motivo++;
                        getMotivo = mazoMotivo.get(motivo);                
                    }
                    posibleSolucion.set(2,getMotivo);
                    
                    for (parteCuerpo = 0; parteCuerpo < mazoParteCuerpo.size(); parteCuerpo++){
                        Carta getParteCuerpo = mazoParteCuerpo.get(parteCuerpo);
                        while(!getParteCuerpo.isCorrecto()&& parteCuerpo < mazoParteCuerpo.size()-1){
                            parteCuerpo++;
                            getParteCuerpo = mazoParteCuerpo.get(parteCuerpo);                
                        }
                        posibleSolucion.set(3,getParteCuerpo);
                        
                        for (lugar = 0; lugar < mazoLugar.size(); lugar++){
                            Carta getLugar = mazoLugar.get(lugar);
                            while(!getLugar.isCorrecto()&& lugar < mazoLugar.size()-1){
                                lugar++;
                                getLugar = mazoLugar.get(lugar);                
                            }
                            posibleSolucion.set(4,getLugar); 
                            ArrayList<Carta> tempS = (ArrayList<Carta>) posibleSolucion.clone();
                            listaSoluciones.add(tempS);
                            
                            //salida += posibleSolucion.toString()+"\n";               //Para mostrar en la interfaz
                            if(posibleSolucion.equals(solucion)){

                                tiempoFinal = System.nanoTime();                
                                //tiempoFb = String.valueOf(tiempoFinal-tiempoInicio); //Convierte el tiempo a string para poder hacer un solo return
                                //salida += ";"+tiempoFb;                              //Para este punto, ya tenemos toda la salida
                                //return tiempoFb;
                                return tiempoFinal-tiempoInicio;                   //Antiguo return long
                            }
                            else{
                                mazo.MarcarCartaIncorrecta();
                            }
                                
                            
                        }
                    }
                }
            }
        }
        //tiempoFb = "-";
        //return tiempoFb;
        return -1;
    }

    public ArrayList<ArrayList<Carta>> getListaSoluciones() {
        return listaSoluciones;
    }
    public long Backtracking(){
        ArrayList<Carta> posibleSolucion;
        ArrayList<Carta> solucion = mazo.getSolucion();
        int sospechoso;
        int arma;
        int motivo;
        int parteCuerpo;
        int lugar;
        //String salida = "";                   // Almacena el texto que se mostrara al usuario
        //String tiempoFb;                      // Para retornar el tiempo junto a la salida
        
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
        
        long tiempoInicio = System.nanoTime();
        long tiempoFinal = 0;
        for (sospechoso = 0; sospechoso < mazoSospechoso.size(); sospechoso++) {
            
            Carta getSospechoso = mazoSospechoso.get(sospechoso);
            while(!getSospechoso.isCorrecto()&& sospechoso < mazoSospechoso.size()-1 || Poda(posibleSolucion)){
                sospechoso++;
                getSospechoso = mazoSospechoso.get(sospechoso);                
            }
            posibleSolucion.set(0,getSospechoso);
            
            for (arma = 0; arma < mazoArma.size(); arma++){
                Carta getArma = mazoArma.get(arma);
                while(!getArma.isCorrecto()&& arma < mazoArma.size()-1 || Poda(posibleSolucion)){
                    arma++;
                    getArma = mazoArma.get(arma);                
                }
                posibleSolucion.set(1,getArma);
                
                for (motivo = 0; motivo < mazoMotivo.size(); motivo++){
                    Carta getMotivo = mazoMotivo.get(motivo);
                    while(!getMotivo.isCorrecto()&& motivo < mazoMotivo.size()-1 || Poda(posibleSolucion)){
                        motivo++;
                        getMotivo = mazoMotivo.get(motivo);                
                    }
                    posibleSolucion.set(2,getMotivo);
                    
                    for (parteCuerpo = 0; parteCuerpo < mazoParteCuerpo.size(); parteCuerpo++){
                        Carta getParteCuerpo = mazoParteCuerpo.get(parteCuerpo);
                        while(!getParteCuerpo.isCorrecto()&& parteCuerpo < mazoParteCuerpo.size()-1 || Poda(posibleSolucion)){
                            parteCuerpo++;
                            getParteCuerpo = mazoParteCuerpo.get(parteCuerpo);                
                        }
                        posibleSolucion.set(3,getParteCuerpo);
                        
                        for (lugar = 0; lugar < mazoLugar.size(); lugar++){
                            Carta getLugar = mazoLugar.get(lugar);
                            while(!getLugar.isCorrecto()&& lugar < mazoLugar.size()-1 || Poda(posibleSolucion)){
                                lugar++;
                                getLugar = mazoLugar.get(lugar);                
                            }
                            posibleSolucion.set(4,getLugar); 
                            ArrayList<Carta> tempS = (ArrayList<Carta>) posibleSolucion.clone();
                            listaSoluciones.add(tempS);
                            
                            //salida += posibleSolucion.toString()+"\n";               //Para mostrar en la interfaz
                            if(posibleSolucion.equals(solucion)){

                                tiempoFinal = System.nanoTime();                
                                //tiempoFb = String.valueOf(tiempoFinal-tiempoInicio); //Convierte el tiempo a string para poder hacer un solo return
                                //salida += ";"+tiempoFb;                              //Para este punto, ya tenemos toda la salida
                                //return tiempoFb;
                                return tiempoFinal-tiempoInicio;                   //Antiguo return long
                            }
                            else{
                                mazo.MarcarCartaIncorrecta();
                            }
                                
                            
                        }
                    }
                }
            }
        }
        //tiempoFb = "-";
        //return tiempoFb;
        return -1;
    }
    private boolean Poda(ArrayList<Carta> posibleSolucion){
        
        ArrayList<ArrayList<Carta>> listaRestricciones = mazo.getListaRestricciones();
        for (int i = 0; i < listaRestricciones.size(); i++) {
            ArrayList<Carta> get = listaRestricciones.get(i);
            if(posibleSolucion.indexOf(get.get(0))!=-1 && posibleSolucion.indexOf(get.get(1)) !=-1){
                return true;
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
        long tiempoFinal = auxiliar(posibleSolucion, mazos, 0, solucion);
        if(tiempoFinal >-1)
            return tiempoFinal-tiempoInicio;
        return -1;
    }
    
    private long auxiliar(ArrayList<Carta> posibleSolucion, ArrayList<ArrayList<Carta>> mazos, int i
            ,ArrayList<Carta> solucion){
        
        ArrayList<Carta> mazoActual = mazos.get(i);
        for (int j = 0; j < mazoActual.size(); j++) {
            Carta get = mazoActual.get(j);
            while(!get.isCorrecto() || Poda(posibleSolucion)){
                j++;
                if(j > mazoActual.size()-1){
                    return -1;
                }
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
                if(i<4){                    
                    long tiempo = auxiliar(posibleSolucion,mazos,i+1,solucion);  
                    if (tiempo != -1) {
                        return tiempo;                        
                    }
                }
                
            }
        }
        return -1;
    }
}
