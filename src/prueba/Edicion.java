/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.util.Date;

/**
 *
 * @author DAW
 */
public class Edicion {
    
    
    public int Idedicion;
    public String Nombre;
    public Date Fechalanzamiento;

    public Edicion(int Idedicion, String Nombre, Date Fechalanzamiento) {
        this.Idedicion = Idedicion;
        this.Nombre = Nombre;
        this.Fechalanzamiento = Fechalanzamiento;
    }
    
    public Edicion(String Nombre){
        this.Nombre = Nombre;
    }

    public int getIdedicion() {
        return Idedicion;
    }

    public String getNombre() {
        return Nombre;
    }

    public Date getFechalanzamiento() {
        return Fechalanzamiento;
    }

    public void setIdedicion(int Idedicion) {
        this.Idedicion = Idedicion;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setFechalanzamiento(Date Fechalanzamiento) {
        this.Fechalanzamiento = Fechalanzamiento;
    }


    @Override
    public String toString() {
        return this.Nombre;
    }
    
    
    //fc.showSabeDialog(stage);
}
