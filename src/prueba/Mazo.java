/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author paco
 */
public class Mazo {
    private int Idmazo;
    private boolean Personalizado;
    private int Idcliente;
    private ArrayList<Carta> carta = new ArrayList<Carta>();
    private ArrayList<Integer> cantidad = new ArrayList<Integer>();

    public Mazo(int Idmazo, boolean Personalizado, int Idcliente) {
        this.Idmazo = Idmazo;
        this.Personalizado = Personalizado;
        this.Idcliente = Idcliente;
    }

    public int getIdmazo() {
        return Idmazo;
    }

    public boolean isPersonalizado() {
        return Personalizado;
    }

    public int getIdcliente() {
        return Idcliente;
    }

    public ArrayList<Carta> getCarta() {
        return carta;
    }

    public ArrayList<Integer> getCantidad() {
        return cantidad;
    }

    public void setIdmazo(int Idmazo) {
        this.Idmazo = Idmazo;
    }

    public void setPersonalizado(boolean Personalizado) {
        this.Personalizado = Personalizado;
    }

    public void setIdcliente(int Idcliente) {
        this.Idcliente = Idcliente;
    }

    public void setCarta(ArrayList<Carta> carta) {
        this.carta = carta;
    }

    public void setCantidad(ArrayList<Integer> cantidad) {
        this.cantidad = cantidad;
    }
    
 private String todos(){
     String todo="";
     Iterator itr = carta.iterator();
     
     while (itr.hasNext()){
         
     }
     return todo;
 }
    
    
}
