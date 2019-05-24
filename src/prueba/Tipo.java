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
public class Tipo {
    private int Idtipo;
    private String Nombre;

    public Tipo(int Idtipo, String Nombre) {
        this.Idtipo = Idtipo;
        this.Nombre = Nombre;
    }
    
    public Tipo (String Nombre){
        this.Idtipo=0;
        this.Nombre=Nombre;
    }
    
 
    public int getIdtipo() {
        return Idtipo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setIdtipo(int Idtipo) {
        this.Idtipo = Idtipo;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
          @Override
    public String toString() {
        return this.Nombre;
    }
    
    
     public static void llenarTipo(ObservableList <Tipo> lista){
        Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        ResultSet rs;
        ResultSet rs2;
        PreparedStatement stmt=null;
        PreparedStatement stmt2=null;
        boolean fin=false;
        try{
         //   Idtipo	Nombre
        stmt= con.prepareStatement("SELECT * from tipo");
            stmt.executeQuery();
            rs= stmt.executeQuery();
    while (rs.next()){
        lista.add(new Tipo(rs.getInt(1), rs.getString(2)));
        
    }
}
         catch(SQLException exx){
        exx.getMessage();
    }
        
     }
     
}


