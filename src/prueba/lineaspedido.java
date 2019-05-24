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
public class lineaspedido {
    private int Idlinea;
    private int Pedido;
    private int Idcarta;
    private double Precio;
    private int Cantidad;

    public lineaspedido(int Idlinea, int Pedido, int Idcarta, double Precio, int Cantidad) {
        this.Idlinea = Idlinea;
        this.Pedido = Pedido;
        this.Idcarta = Idcarta;
        this.Precio = Precio;
        this.Cantidad = Cantidad;
    }

    public int getIdlinea() {
        return Idlinea;
    }

    public int getPedido() {
        return Pedido;
    }

    public int getIdcarta() {
        return Idcarta;
    }

    public double getPrecio() {
        return Precio;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setIdlinea(int Idlinea) {
        this.Idlinea = Idlinea;
    }

    public void setPedido(int Pedido) {
        this.Pedido = Pedido;
    }

    public void setIdcarta(int Idcarta) {
        this.Idcarta = Idcarta;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    /*  this.Idlinea = Idlinea;
    this.Pedido = Pedido;
    this.Idcarta = Idcarta;
    this.Precio = Precio;
    this.Cantidad = Cantidad;*/
    
 public static void llenarlineas(ObservableList <lineaspedido> lista, String pedido){
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
       int numeropedido= Integer.parseInt(pedido);
       
        
     try{
        stmt=con.prepareStatement("SELECT * from lineaspedido where Pedido = ? ");
        stmt.setInt(1, numeropedido);
        stmt.executeQuery();
        rs=stmt.executeQuery();
        rs.next();
        lista.add(new lineaspedido(rs.getInt(1),  rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getInt(5)));
        
        
        
     }
      catch(SQLException exx){
         exx.getMessage();
            System.out.println(exx.getMessage());
     }
 }
    
}
//Idlinea	Pedido	Carta	Precio	Cantidad