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
    
    public long FuerzaBruta(){ 
        
        
        for (int i = 0; i < 5; i++) {
            System.out.println(mazo.getSolucion().get(i));
        }
        ArrayList<Carta> posibleSolucion;
        ArrayList<Carta> solucion = mazo.getSolucion();
        int sospechoso;
        int arma;
        int motivo;
        int parteCuerpo;
        int lugar;
        
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
                            if(posibleSolucion.equals(solucion)){
                                tiempoFinal = System.nanoTime();
                                return tiempoFinal-tiempoInicio;
                            }
                            else
                                mazo.MarcarCartaIncorrecta();
                                
                            
                        }
                    }
                }
            }
        }
        return -1;
    }
    
}
