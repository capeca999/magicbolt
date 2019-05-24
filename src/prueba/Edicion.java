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
import java.sql.Date;
import javafx.collections.ObservableList;

/**
 *
 * @author DAW
 */
public class Edicion {
    
    
    private int Idedicion;
    private String Nombre;
    private Date Fechalanzamiento;

    public Edicion(int Idedicion, String Nombre, Date Fechalanzamiento) {
        this.Idedicion = Idedicion;
        this.Nombre = Nombre;
        this.Fechalanzamiento = Fechalanzamiento;
    }
    
    public Edicion (String Nombre){
        this.Idedicion =0;
        this.Nombre=Nombre;
    }
        
    /*   public subtipo (String Nombre){
    this.Idsubtipo = 0;
    this.Nombre= Nombre;
    }*/
    
    
 

    public int getIdedicion() {
        return Idedicion;
    }

    public String getNombre() {
        return Nombre;
    }

    public Date getFechalanzamiento() {
        return Fechalanzamiento;
    }

    public void setIdedicion(int Idedicion) {
        this.Idedicion = Idedicion;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setFechalanzamiento(Date Fechalanzamiento) {
        this.Fechalanzamiento = Fechalanzamiento;
    }


    @Override
    public String toString() {
        return this.Nombre;
    }
    
     public static void llenarEdicion(ObservableList <Edicion> lista){
        Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        ResultSet rs;
        ResultSet rs2;
        PreparedStatement stmt=null;
        PreparedStatement stmt2=null;
        boolean fin=false;
        try{
         //   Idtipo	Nombre
        stmt= con.prepareStatement("SELECT * from edicion");
            stmt.executeQuery();
            rs= stmt.executeQuery();
    while (rs.next()){
        lista.add(new Edicion(rs.getInt(1), rs.getString(2), rs.getDate(3)));
        
    }
}
         catch(SQLException exx){
        exx.getMessage();
    }
    //fc.showSabeDialog(stage);
}
}
