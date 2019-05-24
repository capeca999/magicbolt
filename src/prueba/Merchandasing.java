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
 * @author DAW
 */
public class Merchandasing {
    private int Idmerch;
    private double Precio;
    private Double Existencias;
    private String Nombre;
    private String Descripcion;

    public Merchandasing(int Idmerch, double Precio, Double Existencias, String Nombre, String Descripcion) {
        this.Idmerch = Idmerch;
        this.Precio = Precio;
        this.Existencias = Existencias;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
    }

    public int getIdmerch() {
        return Idmerch;
    }

    public double getPrecio() {
        return Precio;
    }

    public double getExistencias() {
        return Existencias;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setIdmerch(int Idmerch) {
        this.Idmerch = Idmerch;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public void setExistencias(double Existencias) {
        this.Existencias = Existencias;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    @Override
    public String toString() {
        return this.Nombre;
    }
    
    
    
    public static void llenarMerch(ObservableList <Merchandasing> lista, String Merchandasingg ){
       Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        ResultSet rs;
        ResultSet rs2;
        PreparedStatement stmt=null;
        PreparedStatement stmt2=null;
        boolean fin=false;  
        System.out.println(Merchandasingg);
        
        /*           this.Idmerch = Idmerch;
        this.Precio = Precio;
        this.Existencias = Existencias;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;*/
        
        
        
        
        
        	//Idmerch 	Precio 	Existencias 	Nombre 	Descripcion
        
        try{
                //               stmt= con.prepareStatement("SELECT Nombre, Edicion, Foil, Existencias, Idcarta, Precio from carta where LOWER(Nombre) LIKE \""+'%'+carta+'%'+"\"");

            stmt= con.prepareStatement("SELECT Idmerch, Precio, Existencias, Nombre, Descripcion from merchandising where LOWER(Nombre) LIKE \""+'%'+Merchandasingg+'%'+"\"");
            stmt.executeQuery();
            rs2=stmt.executeQuery();
            
            
            /*             while (rs.next()){
            
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
            */
            /*
            this.Idmerch = Idmerch;
            this.Precio = Precio;
            this.Existencias = Existencias;
            this.Nombre = Nombre;
            this.Descripcion = Descripcion;
                     stmt= con.prepareStatement("SELECT Idmerch, Precio, Existencias, Nombre, Descripcion from merchandising where LOWER(Nombre) LIKE \""+'%'+Merchandasingg+'%'+"\"");
   
            */
    while (rs2.next()){
        System.out.println("dwoflawoflwaoflowa");
        System.out.println(rs2.getString(4));
        System.out.println("wdawdwadwadawdawdawdawdwa");
        lista.add(new Merchandasing (rs2.getInt(1), rs2.getDouble(2), rs2.getDouble(3), rs2.getString(4), rs2.getString(5)));
    
        
      
     
        
    }
            
        }
         /*           this.Idmerch = Idmerch;
        this.Precio = Precio;
        this.Existencias = Existencias;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;*/
        
        catch(SQLException ex){
          ex.getMessage();
        }
        
        
        
        
        
    }
      public static void llenarMerchh(ObservableList <Merchandasing> lista ){
       Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        ResultSet rs;
        ResultSet rs2;
        PreparedStatement stmt=null;
        PreparedStatement stmt2=null;
        boolean fin=false;  
      
        
        /*           this.Idmerch = Idmerch;
        this.Precio = Precio;
        this.Existencias = Existencias;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;*/
        
        
        
        
        
        	//Idmerch 	Precio 	Existencias 	Nombre 	Descripcion
        
        try{
                //               stmt= con.prepareStatement("SELECT Nombre, Edicion, Foil, Existencias, Idcarta, Precio from carta where LOWER(Nombre) LIKE \""+'%'+carta+'%'+"\"");

            stmt= con.prepareStatement("SELECT Idmerch, Precio, Existencias, Nombre, Descripcion from merchandising ");
            
            stmt.executeQuery();
            rs2=stmt.executeQuery();
            
            
            /*             while (rs.next()){
            
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
            */
            /*
            this.Idmerch = Idmerch;
            this.Precio = Precio;
            this.Existencias = Existencias;
            this.Nombre = Nombre;
            this.Descripcion = Descripcion;
                     stmt= con.prepareStatement("SELECT Idmerch, Precio, Existencias, Nombre, Descripcion from merchandising where LOWER(Nombre) LIKE \""+'%'+Merchandasingg+'%'+"\"");
   
            */
    while (rs2.next()){
  
        lista.add(new Merchandasing (rs2.getInt(1), rs2.getDouble(2), rs2.getDouble(3), rs2.getString(4), rs2.getString(5)));
    
        
      
     
        
    }
            
        }
         /*           this.Idmerch = Idmerch;
        this.Precio = Precio;
        this.Existencias = Existencias;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;*/
        
        catch(SQLException ex){
          ex.getMessage();
        }
        
        
        
        
        
    }
    
}
