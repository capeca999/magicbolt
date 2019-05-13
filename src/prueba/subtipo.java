/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

/**
 *
 * @author DAW
 */
public class subtipo {
    
    public int  Idsubtipo;
    public String Nombre;

    public subtipo(int Idsubtipo, String Nombre) {
        this.Idsubtipo = Idsubtipo;
        this.Nombre = Nombre;
    }
    
    public subtipo (String Nombre){
        this.Nombre= Nombre;
    }

    public int getIdsubtipo() {
        return Idsubtipo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setIdsubtipo(int Idsubtipo) {
        this.Idsubtipo = Idsubtipo;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
      @Override
    public String toString() {
        return this.Nombre;
    }
    
}
