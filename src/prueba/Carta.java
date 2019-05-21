/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import DAO.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.ObservableList;

/**
 *
 * @author paco
 */
public class Carta {
    

    private int Idcarta;
    private double Precio;
    private int Existencias;
    private String Nombre;
    private String Descripcion;
    private String Mana;
    private int Tipo;
    private int Subtipo;
    private String Artista;
    private String Imagen;
    private int Lealdad;
    private double Ataque;
    private double Defensa;
    private String Edicion;
    private boolean Foil;
    private int idedicion;

    public Carta(int Idcarta, double Precio, int Existencias, String Nombre, String Edicion, boolean Foil, int idedicion) {
        this.Idcarta = Idcarta;
        this.Precio = Precio;
        this.Existencias = Existencias;
        this.Nombre = Nombre;
        this.Edicion = Edicion;
        this.Foil = Foil;
        this.idedicion = idedicion;
    }

    /*   public Carta(int Idcarta, double Existencias, String Nombre, String Edicion, boolean Foil, int idedicion, double Precio) {
    this.Idcarta = Idcarta;
    this.Existencias = Existencias;
    this.Nombre = Nombre;
    this.Edicion = Edicion;
    this.Foil = Foil;
    this.idedicion = idedicion;
    this.Precio = Precio;
    
    }*/

    public Carta(int Idcarta, double Precio, int Existencias, String Nombre, String Descripcion, String Mana, int Tipo, int Subtipo, String Artista, String Imagen, int Lealdad, double Ataque, double Defensa, String Edicion, boolean Foil, int idedicion) {
        this.Idcarta = Idcarta;
        this.Precio = Precio;
        this.Existencias = Existencias;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Mana = Mana;
        this.Tipo = Tipo;
        this.Subtipo = Subtipo;
        this.Artista = Artista;
        this.Imagen = Imagen;
        this.Lealdad = Lealdad;
        this.Ataque = Ataque;
        this.Defensa = Defensa;
        this.Edicion = Edicion;
        this.Foil = Foil;
        this.idedicion = idedicion;
    }

    public int getIdedicion() {
        return idedicion;
    }

    public void setIdedicion(int idedicion) {
        this.idedicion = idedicion;
    }

    

    public int getIdcarta() {
        return Idcarta;
    }

    public double getPrecio() {
        return Precio;
    }

    public int getExistencias() {
        return Existencias;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public String getMana() {
        return Mana;
    }

    public int getTipo() {
        return Tipo;
    }

    public int getSubtipo() {
        return Subtipo;
    }

    public String getArtista() {
        return Artista;
    }

    public String getImagen() {
        return Imagen;
    }

    public int getLealdad() {
        return Lealdad;
    }

    public double getAtaque() {
        return Ataque;
    }

    public double getDefensa() {
        return Defensa;
    }

    public String getEdicion() {
        return Edicion;
    }

    public boolean isFoil() {
        return Foil;
    }

    public void setIdcarta(int Idcarta) {
        this.Idcarta = Idcarta;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public void setExistencias(int Existencias) {
        this.Existencias = Existencias;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setMana(String Mana) {
        this.Mana = Mana;
    }

    public void setTipo(int Tipo) {
        this.Tipo = Tipo;
    }

    public void setSubtipo(int Subtipo) {
        this.Subtipo = Subtipo;
    }

    public void setArtista(String Artista) {
        this.Artista = Artista;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }

    public void setLealdad(int Lealdad) {
        this.Lealdad = Lealdad;
    }

    public void setAtaque(double Ataque) {
        this.Ataque = Ataque;
    }

    public void setDefensa(double Defensa) {
        this.Defensa = Defensa;
    }

    public void setEdicion(String Edicion) {
        this.Edicion = Edicion;
    }

    public void setFoil(boolean Foil) {
        this.Foil = Foil;
    }

  
   
    
    
            
    


    @Override
    public String toString(){
     String todo=this.Nombre;
     
      return todo;
      
       
     }
    
  
    
    
    /*    this.Idcarta = Idcarta;
    this.Existencias = Existencias;
    this.Nombre = Nombre;
    this.Edicion = Edicion;
    this.Foil = Foil;
    this.idedicion = idedicion;*/
    
    public static void llenarCarta(ObservableList <Carta> lista, String carta){
        Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        ResultSet rs;
        ResultSet rs2;
        PreparedStatement stmt=null;
        PreparedStatement stmt2=null;
        boolean fin=false;
        try{
         
     
 
             
        
                   stmt= con.prepareStatement("SELECT Nombre, Edicion, Foil, Existencias, Idcarta, Precio from carta where LOWER(Nombre) LIKE \""+'%'+carta+'%'+"\"");
            stmt.executeQuery();
            rs= stmt.executeQuery();
            
            
            /*
            public Carta(int Idcarta, double Precio, double Existencias, String Nombre, String Edicion, boolean Foil, int idedicion) {
            this.Idcarta = Idcarta;
            this.Precio = Precio;
            this.Existencias = Existencias;
            this.Nombre = Nombre;
            this.Edicion = Edicion;
            this.Foil = Foil;
            this.idedicion = idedicion;
            }
            
            */
            
            
            while (rs.next()){
              
                  stmt2= con.prepareStatement("SELECT Nombre from Edicion where Idedicion = ?");
            stmt2.setInt(1, rs.getInt(2));
            stmt2.executeQuery();
            rs2= stmt2.executeQuery();
            rs2.next();
                
                System.out.println(rs.getInt(2));
                lista.add(new Carta (rs.getInt(5), rs.getDouble(6), rs.getInt(4), rs.getString(1), rs2.getString(1), rs.getBoolean(3), rs.getInt(2)));
                
               
            }
            
            
        }
           catch(SQLException exx){
         exx.getMessage();
     }
    }
   
    
    
    
    
}
