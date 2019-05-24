/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import DAO.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;
import javafx.collections.ObservableList;

/**
 *
 * @author paco
 */
public class Pedidos {
    //Idpedido	Idcliente	empleado	Fecha
    
    private int Idpedido;
    private String cliente;
    private String empleado;
    private Date Fecha;
    private int idcliente;
    private int idempleado;

    public Pedidos(int Idpedido, String cliente, String empleado, Date Fecha, int idcliente, int idempleado) {
        this.Idpedido = Idpedido;
        this.cliente = cliente;
        this.empleado = empleado;
        this.Fecha = Fecha;
        this.idcliente = idcliente;
        this.idempleado = idempleado;
    }
    
    
    

    public int getIdpedido() {
        return Idpedido;
    }

    public String getCliente() {
        return cliente;
    }

    public String getEmpleado() {
        return empleado;
    }

    public Date getFecha() {
        return Fecha;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdpedido(int Idpedido) {
        this.Idpedido = Idpedido;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }
    
    public static void llenarPedidos(ObservableList <Pedidos> lista){
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
try{
    stmt=con.prepareStatement("SELECT * from pedidos");
    stmt.executeQuery();
    rs=stmt.executeQuery();
    
    while (rs.next()){
       stmt2=con.prepareStatement("SELECT Nombre from cliente where Idpersona = ?");
       stmt2.setInt(1, rs.getInt(2));
       stmt2.executeQuery();
       rs2=stmt2.executeQuery();
       rs2.next();
       stmt3=con.prepareStatement("SELECT Nombre from empleado where Idempleado = ?");
       stmt3.setInt(1, rs.getInt(3));
       stmt3.executeQuery();
       rs3=stmt3.executeQuery();
       rs3.next();
       lista.add(new Pedidos(rs.getInt(1), rs2.getString(1), rs3.getString(1), rs.getDate(4), rs.getInt(2), rs.getInt(3)));
       
               /*          this.Idpedido = Idpedido;
               this.cliente = cliente;
               this.empleado = empleado;
               this.Fecha = Fecha;
               this.idcliente = idcliente;
               this.idempleado = idempleado;*/
       
       
    }
    
    
}
 catch(SQLException exx){
         exx.getMessage();
            System.out.println(exx.getMessage());
     }
    }
}
