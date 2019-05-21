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
import javafx.collections.ObservableList;

/**
 *
 * @author DAW
 */
public class Merchandasing {
    private int Idmerch;
    private double Precio;
    private double Existencias;
    private String Nombre;
    private String Descripcion;

    public Merchandasing(int Idmerch, double Precio, double Existencias, String Nombre, String Descripcion) {
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
    
    
    
    public static void llenarMerch(ObservableList <Merchandasing> lista, String Merchandasing ){
       Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        ResultSet rs;
        ResultSet rs2;
        PreparedStatement stmt=null;
        PreparedStatement stmt2=null;
        boolean fin=false;  
        
        try{
                //               stmt= con.prepareStatement("SELECT Nombre, Edicion, Foil, Existencias, Idcarta, Precio from carta where LOWER(Nombre) LIKE \""+'%'+carta+'%'+"\"");

            stmt= con.prepareStatement("SELECT")
            
            
        }
        
        
        
        
        
        
    }
    
}
