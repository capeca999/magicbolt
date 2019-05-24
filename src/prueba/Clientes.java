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
import java.util.ArrayList;
import javafx.collections.ObservableList;
/**
 *
 * @author paco
 */
public class Clientes {
    
   private String Nombre;
   private String Apellido;
   private String Telefono;
   private Date Fecha_nacimiento;
   private Date Fecha_inscripcion;
   private String DNI;
   private boolean Juez;
   private int Idpersona;
   
   
   
    
    
  //  Nombre Apellido Telefono 	Fecha_nacimiento Fecha_inscripcion DNI 	Juez Idpersona 

    public Clientes(String Nombre, String Apellido, String Telefono, Date Fecha_nacimiento, Date Fecha_inscripcion, String DNI, boolean Juez, int Idpersona) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Telefono = Telefono;
        this.Fecha_nacimiento = Fecha_nacimiento;
        this.Fecha_inscripcion = Fecha_inscripcion;
        this.DNI = DNI;
        this.Juez = Juez;
        this.Idpersona = Idpersona;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getTelefono() {
        return Telefono;
    }

  

    public String getDNI() {
        return DNI;
    }

    public boolean isJuez() {
        return Juez;
    }

    public int getIdpersona() {
        return Idpersona;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public Date getFecha_nacimiento() {
        return Fecha_nacimiento;
    }

    public Date getFecha_inscripcion() {
        return Fecha_inscripcion;
    }

    public void setFecha_nacimiento(Date Fecha_nacimiento) {
        this.Fecha_nacimiento = Fecha_nacimiento;
    }

    public void setFecha_inscripcion(Date Fecha_inscripcion) {
        this.Fecha_inscripcion = Fecha_inscripcion;
    }

    public Clientes(String Nombre, String Apellido, String DNI, int Idpersona) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.DNI = DNI;
        this.Idpersona = Idpersona;
    }

   

  

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setJuez(boolean Juez) {
        this.Juez = Juez;
    }

    public void setIdpersona(int Idpersona) {
        this.Idpersona = Idpersona;
    }

    @Override
    public String toString() {
        return "Clientes{" + "Nombre=" + Nombre + '}';
    }
    
    
    
    /*     this.Nombre = Nombre;
    this.Apellido = Apellido;
    this.Telefono = Telefono;
    this.Fnacimiento = Fnacimiento;
    this.Finscripcion = Finscripcion;
    this.DNI = DNI;
    this.Juez = Juez;
    this.Idpersona = Idpersona;*/
    
    public static void llenarClientes(ObservableList <Clientes> lista ){
    Conexion conexion = new Conexion();
    Connection con = conexion.conectar();
    ResultSet rs;
    PreparedStatement stmt=null;
    try{
        stmt= con.prepareStatement("SELECT * from cliente");
        stmt.executeQuery();
        rs=stmt.executeQuery();
    while (rs.next()){
        System.out.println(rs.getDate(4));
        System.out.println(rs.getDate(5));
        lista.add(new Clientes(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getString(6), rs.getBoolean(7), rs.getInt(8)));
 
       
    }
    }
    //Nombre Apellido Telefono Fecha_nacimiento Fecha_inscripcion DNI 	Juez Idpersona 
    
    catch(SQLException exx){
        exx.getMessage();
    }
    
        
    }
    
    public static void llenarJuez(ObservableList <Clientes> lista ){
    Conexion conexion = new Conexion();
    Connection con = conexion.conectar();
    ResultSet rs;
    PreparedStatement stmt=null;
    try{
        stmt= con.prepareStatement("SELECT Nombre, Apellido, DNI, Idpersona from cliente where Juez = 1");
        stmt.executeQuery();
        rs=stmt.executeQuery();
    while (rs.next()){
      
        lista.add(new Clientes(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
        
       
    }
    }
    //Nombre Apellido Telefono Fecha_nacimiento Fecha_inscripcion DNI 	Juez Idpersona 
    
    catch(SQLException exx){
        exx.getMessage();
    }
    
        
    }
}

