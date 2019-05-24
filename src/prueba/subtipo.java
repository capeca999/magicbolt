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
public class subtipo {
    
    private int  Idsubtipo;
    private String Nombre;

    public subtipo(int Idsubtipo, String Nombre) {
        this.Idsubtipo = Idsubtipo;
        this.Nombre = Nombre;
    }
    
    public subtipo (String Nombre){
        this.Idsubtipo = 0;
        this.Nombre= Nombre;
    }

    public int getIdsubtipo() {
        return Idsubtipo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setIdsubtipo(int Idsubtipo) {
        this.Idsubtipo = Idsubtipo;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
      @Override
    public String toString() {
        return this.Nombre;
    }
    
      public static void llenarSubtipo(ObservableList <subtipo> lista){
        Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        ResultSet rs;
        ResultSet rs2;
        PreparedStatement stmt=null;
        PreparedStatement stmt2=null;
        boolean fin=false;
        try{
         //   Idtipo	Nombre
        stmt= con.prepareStatement("SELECT * from subtipo");
            stmt.executeQuery();
            rs= stmt.executeQuery();
    while (rs.next()){
        lista.add(new subtipo(rs.getInt(1), rs.getString(2)));
        
    }
}
         catch(SQLException exx){
        exx.getMessage();
    }
        
     }
     
    
    
    
}
