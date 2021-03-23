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
public class MazoCartas {
    private ArrayList<Carta> cartas;
    private Tipo tipo;

    public MazoCartas(Tipo tipo) {
        this.tipo = tipo;
        cartas = new ArrayList<Carta>();
    }
    
    public void AgregarCarta(Carta carta){
        cartas.add(carta);
    }
    public Carta SelecCartaRandom(){
        int random;
        random = (int) (Math.random() * cartas.size());
        
        return cartas.get(random);
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public Tipo getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        String str ="MazoCartas " + "tipo: " + tipo + "\n";
        
        for (int i = 0; i < cartas.size(); i++) {
            Carta get = cartas.get(i);
            str += get.toString() + "\n";
        }
        return str;
    }
    
    
}
