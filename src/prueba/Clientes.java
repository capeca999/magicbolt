/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;
import java.util.ArrayList;
/**
 *
 * @author paco
 */
public class Clientes extends Persona {
    
    private boolean juez;
    private ArrayList<Mazo> mazos = new ArrayList<Mazo>();

    public Clientes(boolean juez, String Nombre, String DNI, String Telefono, Fecha Fecha_nacimiento, int Idpersona) {
        super(Nombre, DNI, Telefono, Fecha_nacimiento, Idpersona);
        this.juez = juez;
    }

    public boolean isJuez() {
        return juez;
    }

    public ArrayList<Mazo> getMazos() {
        return mazos;
    }

    public void setJuez(boolean juez) {
        this.juez = juez;
    }

    public void setMazos(ArrayList<Mazo> mazos) {
        this.mazos = mazos;
    }

   
    
    @Override
     public String todo(){
         String todo=super.todo();
         if (this.juez==false){
             todo+="El cliente es juez";
         }
         else todo+="El cliente no es juez";
         
         
         return todo;
         
     }
    
    
    
}
