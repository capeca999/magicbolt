/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

/**
 *
 * @author paco
 */
public class Persona {
    
    protected String Nombre;
    protected String DNI;
    protected String Telefono;
    protected Fecha Fecha_nacimiento;
    protected int Idpersona;

    public Persona(String Nombre, String DNI, String Telefono, Fecha Fecha_nacimiento, int Idpersona) {
        this.Nombre = Nombre;
        this.DNI = DNI;
        this.Telefono = Telefono;
        this.Fecha_nacimiento = Fecha_nacimiento;
        this.Idpersona = Idpersona;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public String getTelefono() {
        return Telefono;
    }

    public Fecha getFecha_nacimiento() {
        return Fecha_nacimiento;
    }

    public int getIdpersona() {
        return Idpersona;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public void setFecha_nacimiento(Fecha Fecha_nacimiento) {
        this.Fecha_nacimiento = Fecha_nacimiento;
    }

    public void setIdpersona(int Idpersona) {
        this.Idpersona = Idpersona;
    }
    
    public String todo(){
        String todo="";
        
        todo="El nombre de la persona es:  " + this.Nombre;
        todo+="El DNI de la persona es: " + this.DNI;
        todo+="El telefono de la persona: " + this.Telefono;
        todo+="La fecha de nacimiento es: " + this.Fecha_nacimiento.corta();
        
        return todo;
        
    }
    
    
}
