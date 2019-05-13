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
public class Producto {
    
    protected double Precio;
    protected double Existencias;
    protected int Idproducto;
    protected String Nombre;
    protected String Descripcion;

    public Producto(double Precio, double Existencias, int Idproducto, String Nombre, String Descripcion) {
        this.Precio = Precio;
        this.Existencias = Existencias;
        this.Idproducto = Idproducto;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
    }

    public double getPrecio() {
        return Precio;
    }

    public double getExistencias() {
        return Existencias;
    }

    public int getIdproducto() {
        return Idproducto;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public void setExistencias(double Existencias) {
        this.Existencias = Existencias;
    }

    public void setIdproducto(int Idproducto) {
        this.Idproducto = Idproducto;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

 
    
    public String todo(){
        String todo="";
        
        todo+="El precio del producto es: " + this.Precio;
        todo+="Existencias del producto: " + this.Existencias;
        todo+="El id es: " + this.Idproducto;
        todo+="Nombre del producto es: " + this.Nombre;
        todo+="Descripción del producto es: " + this.Descripcion;
        return todo;
        
    }
    
}
