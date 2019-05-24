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
import java.sql.Statement;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private String Subtiponombre;
    private String Tiponombre;

   



    public Carta(int Idcarta, double Precio, int Existencias, String Nombre, String Descripcion, String Mana, String Artista, String Imagen, int Lealdad, double Ataque, double Defensa, String Edicion, boolean Foil, String Subtiponombre, String Tiponombre) {
        this.Idcarta = Idcarta;
        this.Precio = Precio;
        this.Existencias = Existencias;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Mana = Mana;
        this.Artista = Artista;
        this.Imagen = Imagen;
        this.Lealdad = Lealdad;
        this.Ataque = Ataque;
        this.Defensa = Defensa;
        this.Edicion = Edicion;
        this.Foil = Foil;
        this.Subtiponombre = Subtiponombre;
        this.Tiponombre = Tiponombre;
    }
    
    
    
    
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

    public void setSubtiponombre(String Subtiponombre) {
        this.Subtiponombre = Subtiponombre;
    }

    public void setTiponombre(String Tiponombre) {
        this.Tiponombre = Tiponombre;
    }

    public String getSubtiponombre() {
        return Subtiponombre;
    }

    public String getTiponombre() {
        return Tiponombre;
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
    
    public static void llenarCartaMod(ObservableList <Carta> lista, String statemententero){
     Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        ResultSet rs;
        ResultSet rs2;
        ResultSet rs3;
        ResultSet rs4;
        PreparedStatement stmt=null;
        PreparedStatement stmt2=null;
        PreparedStatement stmt3=null;
        PreparedStatement stmt4=null;
        Statement stmtt=null;
        String resulsetentero="";
        String edicionentero="";
        String subtipoentero="";
        String tipoentero="";
    try{
        
        /*      stmt= con.prepareStatement("SELECT Nombre, Edicion, Foil, Existencias, Idcarta, Precio from carta where LOWER(Nombre) LIKE \""+'%'+carta+'%'+"\"");
        stmt.executeQuery();
        rs= stmt.executeQuery();*/
        System.out.println(statemententero);
        stmt=con.prepareStatement(statemententero);
        stmt.executeQuery();
        rs=stmt.executeQuery();
        while (rs.next()){
             stmt3=con.prepareStatement("SELECT Nombre from edicion where Idedicion= ?");
           stmt3.setInt(1, rs.getInt(14));
           stmt3.executeQuery();
           rs3=stmt3.executeQuery();
         
           
           if (!rs3.next()){
            edicionentero="NoEdicion";
           }
           else {
               edicionentero=rs3.getString(1);
           }
           
                  stmt4=con.prepareStatement("SELECT Nombre from subtipo where Idsubtipo= ?");
          stmt4.setInt(1, rs.getInt(8));
          rs4=stmt4.executeQuery();
          
          if (!rs4.next()){
              subtipoentero="NoSubtipo";
          }
          else{
              subtipoentero=rs4.getString(1);
          }
          
            stmt2=con.prepareStatement("SELECT Nombre from tipo where Idtipo= ?");
            stmt2.setInt(1, rs.getInt(7));
            stmt2.executeQuery();
            rs2=stmt2.executeQuery();
          
            
            if (!rs2.next()){
            tipoentero="NoTipo";
            }
            
            else{
                tipoentero=rs2.getString(1);
                System.out.println(tipoentero);
                System.out.println("tipoentero");
            }
            
          
           
   
          
          //rs3.getString(1), rs.getBoolean(13), rs4.getString(1), rs2.getString(1)
     //    1                  2       3           4           5            6       7       8   9       10      11      12      13      14      15
	//Idcarta	Precio	Existencias	Nombre	Descripcion	Mana	Tipo	Subtipo	Artista	Imagen	Lealdad	Ataque	Defensa	Edicion	Foil 
       
          lista.add(new Carta (rs.getInt(1), rs.getDouble(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getDouble(12), rs.getDouble(13),  edicionentero , rs.getBoolean(15), subtipoentero, tipoentero ));
          //                    1               2               3               4               5                   6               7               8               9               10              11                  12                  13              14                  15        
                  /* this.Idcarta = Idcarta; 1
                  this.Precio = Precio; 2
                  this.Existencias = Existencias; 3
                  this.Nombre = Nombre; 4
                  this.Descripcion = Descripcion; 5 
                  this.Mana = Mana; 6 
                  this.Artista = Artista;7 
                  this.Imagen = Imagen; 8
                  this.Lealdad = Lealdad; 9 
                  this.Ataque = Ataque; 10
                  this.Defensa = Defensa; 11 
                  this.Edicion = Edicion;12 
                  this.Foil = Foil;13 
                  this.Subtiponombre = Subtiponombre;14
                  this.Tiponombre = Tiponombre;*/ //15
    }
    
                   /*    stmt2= con.prepareStatement("SELECT Nombre from Edicion where Idedicion = ?");
                   stmt2.setInt(1, rs.getInt(2));
                   stmt2.executeQuery();
                   rs2= stmt2.executeQuery();
                   rs2.next();*/
        }
        catch(SQLException exx){
         exx.getMessage();
            System.out.println(exx.getMessage());
     }
          
    }
 
        /*   nombrerow.setCellValueFactory(new PropertyValueFactory<Carta, String>("Nombre"));
        edicionrow.setCellValueFactory(new PropertyValueFactory<Carta, String>("Edicion"));
        existenciasrow.setCellValueFactory(new PropertyValueFactory<Carta, Integer>("Existencias"));
        manarow.setCellValueFactory(new PropertyValueFactory<Carta, String>("Mana"));
        tiporow.setCellValueFactory(new PropertyValueFactory<Carta, String>("Tipo"));
        subtiporow.setCellValueFactory(new PropertyValueFactory<Carta, String>("Subtipo"));
        artistarow.setCellValueFactory(new PropertyValueFactory<Carta, String>("Artista"));
        lealdadrow.setCellValueFactory(new PropertyValueFactory<Carta, Integer>("Lealdad"));
        ataquerow.setCellValueFactory(new PropertyValueFactory<Carta, Double>("Ataque"));
        defensarow.setCellValueFactory(new PropertyValueFactory<Carta, Double>("Defensa"));
        foilrow.setCellValueFactory(new PropertyValueFactory<Carta, Boolean>("Foil"));*/
    
    
}
    

