/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import DAO.Conexion;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author paco
 */
public class AñadirClienteController implements Initializable {

    @FXML
    private TextField Nombre;
    @FXML
    private TextField Apellidos;
    @FXML
    private TextField Dni;
    @FXML
    private DatePicker fnacimiento;
    @FXML
    private RadioButton juez;
    @FXML
    private Button añadir;
    @FXML
    private RadioButton nojuez;
    @FXML
    private ToggleGroup juezv;
    @FXML
    private TextField telefono;
    @FXML
    private DatePicker finscri;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
       
        
        
        
        
    }    
    
    

    @FXML
    private void añadircliente(ActionEvent event) {
        Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
      // PreparedStatement stmt2 = con.prepareStatement("INSERT INTO carta (Precio, Existencias, Nombre, Descripcion, Mana, Tipo, Artista, Imagen, Ataque, Defensa, Edicion) VALUES(?,?,?,?,?,?,?,?,?,?,?)");  

        //Nombre DNI telefono fecha_nacimiento apellido jeuz idpersona
        try{
            PreparedStatement stmt2 = con.prepareStatement("INSERT INTO cliente (Nombre, Apellido, Telefono, Fecha_nacimiento, Fecha_inscripcion, DNI, juez) VALUES(?,?,?,?,?,?,?)");
            stmt2.setString(1, Nombre.getText());
                        stmt2.setString(2, Apellidos.getText());
                          stmt2.setString(3, telefono.getText());
                               stmt2.setString(4, fnacimiento.getValue().toString());
                               stmt2.setString(5, finscri.getValue().toString());
                               
            stmt2.setString(6, Dni.getText());
            
          
       

            int juezono=0;
            String juezboolean="";
            if(nojuez.isSelected()){
                juezono=0;
                juezboolean=Integer.toString(juezono);
                  stmt2.setString(7, juezboolean);
            }
            else juezono=1;          juezboolean=Integer.toString(juezono);    
       
            stmt2.setString(7, juezboolean);
            stmt2.executeUpdate();

          //  stmt2.setDate(4,fnacimiento.getValue());
        }
          catch(SQLException exx){
         exx.getMessage();
     }
    }
    
    
    
    
    
}
