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
public class Criatura extends Carta {
    
    private double Ataque;
    private double Defensa;

    public double getAtaque() {
        return Ataque;
    }

    public double getDefensa() {
        return Defensa;
    }

    public void setAtaque(double Ataque) {
        this.Ataque = Ataque;
    }

    public void setDefensa(double Defensa) {
        this.Defensa = Defensa;
    }

    public Criatura(double Ataque, double Defensa, String Mana, String Tipo, String Subtipo, String Edicion, String Artista, String Imagen, double Precio, double Existencias, int Idproducto, String Nombre, String Descripcion) {
        super(Mana, Tipo, Subtipo, Edicion, Artista, Imagen, Precio, Existencias, Idproducto, Nombre, Descripcion);
        this.Ataque = Ataque;
        this.Defensa = Defensa;
    }
    
    
}
