/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cartas;

import static Cartas.Tipo.*;
import java.util.ArrayList;

/**
 *
 * @author bryan
 */
public class CrearMazo {
    public static MazoGeneral CrearMazo(int cantRestricciones){
        MazoGeneral mazoGeneral = new MazoGeneral();
        ArrayList<MazoCartas> listaMasos = mazoGeneral.getListaMasos();
        
        /*----------------------------------------------------------------------*/
        MazoCartas sospechosos = new MazoCartas(Sospechoso);
        
        Carta amigo = new Carta("Mejor amigo(a)", Sospechoso);
        sospechosos.AgregarCarta(amigo);
        
        Carta novio = new Carta("Novio(a)", Sospechoso);
        sospechosos.AgregarCarta(novio);
        
        Carta vecino = new Carta("Vecino(a)", Sospechoso);
        sospechosos.AgregarCarta(vecino);
        
        Carta mensajero = new Carta("Mensajero(a)", Sospechoso);
        sospechosos.AgregarCarta(mensajero);
        
        Carta extraño = new Carta("Extraño(a)", Sospechoso);
        sospechosos.AgregarCarta(extraño);
        
        Carta hermanastro = new Carta("Hermanastro(a)", Sospechoso);
        sospechosos.AgregarCarta(hermanastro);
        
        Carta compañero = new Carta("Compañero(a) de trabajo", Sospechoso);
        sospechosos.AgregarCarta(compañero);
        
        listaMasos.add(sospechosos);
        /*----------------------------------------------------------------------*/
        MazoCartas armas = new MazoCartas(Arma);
        
        Carta pistola = new Carta("Pistola", Arma);
        armas.AgregarCarta(pistola);
        
        Carta cuchillo = new Carta("Cuchillo", Arma);
        armas.AgregarCarta(cuchillo);
        
        Carta Machete = new Carta("Machete", Arma);
        armas.AgregarCarta(Machete);
        
        Carta pala = new Carta("Pala", Arma);
        armas.AgregarCarta(pala);
        
        Carta bate = new Carta("Bate", Arma);
        armas.AgregarCarta(bate);
        
        Carta botella = new Carta("Botella", Arma);
        armas.AgregarCarta(botella);
        
        Carta tubo = new Carta("Tubo", Arma);
        armas.AgregarCarta(tubo);
        
        Carta cuerda = new Carta("Cuerda", Arma);
        armas.AgregarCarta(cuerda);
        
        listaMasos.add(armas);
        /*----------------------------------------------------------------------*/        
        MazoCartas motivos = new MazoCartas(Motivo);
        
        Carta venganza = new Carta("Venganza", Motivo);
        motivos.AgregarCarta(venganza);
        
        Carta celos = new Carta("Celos", Motivo);
        motivos.AgregarCarta(celos);
        
        Carta dinero = new Carta("Dinero", Motivo);
        motivos.AgregarCarta(dinero);
        
        Carta accidente = new Carta("Accidente", Motivo);
        motivos.AgregarCarta(accidente);
        
        Carta drogas = new Carta("Drogas", Motivo);
        motivos.AgregarCarta(drogas);
        
        Carta robo = new Carta("Robo", Motivo);
        motivos.AgregarCarta(robo);
        
        listaMasos.add(motivos);
        /*----------------------------------------------------------------------*/ 
        MazoCartas parteCuerpo = new MazoCartas(ParteCuerpo);
        
        Carta cabeza = new Carta("Cabeza", ParteCuerpo);
        parteCuerpo.AgregarCarta(cabeza);
        
        Carta pecho = new Carta("Pecho", ParteCuerpo);
        parteCuerpo.AgregarCarta(pecho);
        
        Carta abdomen = new Carta("Abdomen", ParteCuerpo);
        parteCuerpo.AgregarCarta(abdomen);
        
        Carta espalda = new Carta("Espalda", ParteCuerpo);
        parteCuerpo.AgregarCarta(espalda);
        
        Carta piernas = new Carta("Piernas", ParteCuerpo);
        parteCuerpo.AgregarCarta(piernas);
        
        Carta brazos = new Carta("Brazos", ParteCuerpo);
        parteCuerpo.AgregarCarta(brazos);
        
        listaMasos.add(parteCuerpo);
        /*----------------------------------------------------------------------*/ 
        MazoCartas lugares = new MazoCartas(Lugar);
        
        Carta sala = new Carta("Sala", Lugar);
        lugares.AgregarCarta(sala);
        
        Carta comedor = new Carta("Comedor", Lugar);
        lugares.AgregarCarta(comedor);
        
        Carta baño = new Carta("Baño", Lugar);
        lugares.AgregarCarta(baño);
        
        Carta terraza = new Carta("Terraza", Lugar);
        lugares.AgregarCarta(terraza);
        
        Carta cuarto = new Carta("Cuarto", Lugar);
        lugares.AgregarCarta(cuarto);
        
        Carta garage = new Carta("Garage", Lugar);
        lugares.AgregarCarta(garage);
        
        Carta patio = new Carta("Patio", Lugar);
        lugares.AgregarCarta(patio);
        
        Carta balcon = new Carta("Balcon", Lugar);
        lugares.AgregarCarta(balcon);
        
        Carta cocina = new Carta("Cocina", Lugar);
        lugares.AgregarCarta(cocina);
        
        listaMasos.add(lugares);
        /*----------------------------------------------------------------------*/ 
        
        mazoGeneral.SelecSolucion();
        mazoGeneral.SelecRestriccion(cantRestricciones);
        
        return mazoGeneral;        
    }
}
