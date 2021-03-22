/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cartas;

import java.util.ArrayList;

/**
 *
 * @author bryand
 */
public class MazoGeneral {
    ArrayList<MazoCartas> listaMasos;
    ArrayList<Carta> solucion;
    ArrayList<ArrayList<Carta>> listaRestricciones;
    int cantRestricciones;

    public MazoGeneral() {
        this.cantRestricciones = cantRestricciones;
        listaMasos = new ArrayList<MazoCartas>();
        solucion = new ArrayList<Carta>();
        listaRestricciones = new ArrayList<ArrayList<Carta>>();
    }    
    
    public Carta MarcarCartaIncorrecta(){
        int limite = 0;
        int random;
        Carta carta; 
        while(limite <= 1000){
            random = (int) (Math.random() * listaMasos.size()-1);
            carta = listaMasos.get(random).SelecCartaRandom();
            if(carta.isCorrecto() && !carta.isSolucion()){
                carta.setCorrecto(false);
                return carta;
            }
            
            limite++;
        }
        for (int i = 0; i < listaMasos.size(); i++) {
            MazoCartas get = listaMasos.get(i);
            for(int j = 0; i<get.getCartas().size(); j++){
                Carta get2 = get.getCartas().get(j);
                if(get2.isCorrecto() && !get2.isSolucion()){
                get2.setCorrecto(false);
                return get2;
                }
            }
        }
        return null;
    }
    public void SelecSolucion(){
        for (int i = 0; i < listaMasos.size(); i++) {
            MazoCartas get = listaMasos.get(i);
            Carta temp =get.SelecCartaRandom();
            temp.setSolucion(true);
            solucion.add(temp);                 
        }
    
    }
    public void SelecRestriccion(int cantRestricciones){
        Carta carta1; 
        Carta carta2; 
        int random1;
        int random2;
        ArrayList<Carta> temp;
        for (int i = 0; i < cantRestricciones; i++) {
            random1=(int) (Math.random() * listaMasos.size()-1);
            random2=(int) (Math.random() * listaMasos.size()-1);
            while(random1 == random2){
                random1 = (int) (Math.random() * listaMasos.size()-1);
                random2 = (int) (Math.random() * listaMasos.size()-1);
            }
            carta1 = listaMasos.get(random1).SelecCartaRandom();
            carta2 = listaMasos.get(random2).SelecCartaRandom();
            while(carta1.isSolucion() && carta2.isSolucion()){
                carta1 = listaMasos.get(random1).SelecCartaRandom();
                carta2 = listaMasos.get(random2).SelecCartaRandom();
            }
            
            temp = new ArrayList<Carta>();
            temp.add(carta1); 
            temp.add(carta2);
            listaRestricciones.add(temp);
        }        
    }

    public ArrayList<MazoCartas> getListaMasos() {
        return listaMasos;
    }

    public void setListaMasos(ArrayList<MazoCartas> listaMasos) {
        this.listaMasos = listaMasos;
    }

    public ArrayList<Carta> getSolucion() {
        return solucion;
    }

    public void setSolucion(ArrayList<Carta> solucion) {
        this.solucion = solucion;
    }

    public ArrayList<ArrayList<Carta>> getListaRestricciones() {
        return listaRestricciones;
    }

    public void setListaRestricciones(ArrayList<ArrayList<Carta>> listaRestricciones) {
        this.listaRestricciones = listaRestricciones;
    }

    public int getCantRestricciones() {
        return cantRestricciones;
    }

    public void setCantRestricciones(int cantRestricciones) {
        this.cantRestricciones = cantRestricciones;
    }

    @Override
    public String toString() {
        String str = "Mazo General \n";
        
        for (int i = 0; i < listaMasos.size(); i++) {
            MazoCartas get = listaMasos.get(i);
            str += get.toString() + "\n";
        }
        
        str += "Lista de restricciones \n";
        
        for (int i = 0; i < listaRestricciones.size(); i++) {
            ArrayList<Carta> get = listaRestricciones.get(i);
            
            str+= "Restriccion #" +i + "\n";
            str+= get.get(0).toString() + "\n";
            str+= get.get(1).toString() + "\n";
        }
        
        str += "\nSolución \n";
        
        
        for (int i = 0; i < solucion.size(); i++) {
            Carta get = solucion.get(i);
            str += get.toString() + "\n";            
        }
        return str;
    }
    
    
}
