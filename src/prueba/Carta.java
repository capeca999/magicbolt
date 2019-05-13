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
public class Carta extends Producto {
    
protected String Mana;
protected String Tipo;
protected String Subtipo;
protected String Edicion;
protected String Artista;
protected String Imagen;

    public Carta(String Mana, String Tipo, String Subtipo, String Edicion, String Artista, String Imagen, double Precio, double Existencias, int Idproducto, String Nombre, String Descripcion) {
        super(Precio, Existencias, Idproducto, Nombre, Descripcion);
        this.Mana = Mana;
        this.Tipo = Tipo;
        this.Subtipo = Subtipo;
        this.Edicion = Edicion;
        this.Artista = Artista;
        this.Imagen = Imagen;
    }

    public String getMana() {
        return Mana;
    }

    public String getTipo() {
        return Tipo;
    }

    public String getSubtipo() {
        return Subtipo;
    }

    public String getEdicion() {
        return Edicion;
    }

    public String getArtista() {
        return Artista;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setMana(String Mana) {
        this.Mana = Mana;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public void setSubtipo(String Subtipo) {
        this.Subtipo = Subtipo;
    }

    public void setEdicion(String Edicion) {
        this.Edicion = Edicion;
    }

    public void setArtista(String Artista) {
        this.Artista = Artista;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }

@Override
    public String todo(){
       String todo=super.todo();
       
       
       
       todo+="El coste de maná es: " + this.Mana;
       todo+="El tipo de carta es: " + this.Tipo;
       todo+="El subtipo de carta es:  " + this.Subtipo;
       todo+="La edición de esta carta es: " + this.Edicion;
       todo+="El artista de la carta es: " + this.Artista;
      return todo;
      
       
     }
    
    
    
    
}
