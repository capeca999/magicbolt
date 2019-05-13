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
public class Planeswalker extends Carta {
    
    
    private int Lealdad;

    public int getLealdad() {
        return Lealdad;
    }

    public void setLealdad(int Lealdad) {
        this.Lealdad = Lealdad;
    }

    public Planeswalker(int Lealdad, String Mana, String Tipo, String Subtipo, String Edicion, String Artista, String Imagen, double Precio, double Existencias, int Idproducto, String Nombre, String Descripcion) {
        super(Mana, Tipo, Subtipo, Edicion, Artista, Imagen, Precio, Existencias, Idproducto, Nombre, Descripcion);
        this.Lealdad = Lealdad;
    }
    
    @Override
    public String todo(){
       String todo=super.todo();
       todo+= this.Lealdad;
       return todo;
       
    }
    
    
    
}
