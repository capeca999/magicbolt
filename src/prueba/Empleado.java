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
public class Empleado {
    public Integer Idempleado;
    public String Apellido;
    public String Nombre;
    public Date Fnacimiento;
    public Date Fcontrato;
    public String Telefono;
    public String password;
    public Boolean admin;

    public Empleado(Integer Idempleado, String Apellido, String Nombre, Date Fnacimiento, Date Fcontrato, String Telefono, String password, Boolean admin) {
        this.Idempleado = Idempleado;
        this.Apellido = Apellido;
        this.Nombre = Nombre;
        this.Fnacimiento = Fnacimiento;
        this.Fcontrato = Fcontrato;
        this.Telefono = Telefono;
        this.password = password;
        this.admin = admin;
    }

    public Integer getIdempleado() {
        return Idempleado;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getNombre() {
        return Nombre;
    }

    public Date getFnacimiento() {
        return Fnacimiento;
    }

    public Date getFcontrato() {
        return Fcontrato;
    }

    public String getTelefono() {
        return Telefono;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setIdempleado(Integer Idempleado) {
        this.Idempleado = Idempleado;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setFnacimiento(Date Fnacimiento) {
        this.Fnacimiento = Fnacimiento;
    }

    public void setFcontrato(Date Fcontrato) {
        this.Fcontrato = Fcontrato;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

  
    @Override
    public String toString() {
        return "Empleado{" + "Nombre=" + Nombre + '}';
    }
     public static void llenarEmpleados(ObservableList <Empleado> lista){
        Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        ResultSet rs;
        PreparedStatement stmt=null;
        try{
            stmt= con.prepareStatement("SELECT * from Empleado");
            stmt.executeQuery();
            rs= stmt.executeQuery();
            
            while (rs.next()){
                lista.add(new Empleado(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getBoolean(8)));
            }
        }
         catch(SQLException exx){
         exx.getMessage();
     }
    }
}
