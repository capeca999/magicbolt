/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

/**
 *
 * @author paco
 */
public class Tipo {
    private int Idtipo;
    private String Nombre;

    public Tipo(int Idtipo, String Nombre) {
        this.Idtipo = Idtipo;
        this.Nombre = Nombre;
    }
    
    public Tipo(String Nombre){
        this.Nombre=Nombre;
    }

    public int getIdtipo() {
        return Idtipo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setIdtipo(int Idtipo) {
        this.Idtipo = Idtipo;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
          @Override
    public String toString() {
        return this.Nombre;
    }
    
}
