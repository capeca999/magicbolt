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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author DAW
 */
public class AñadirEmpleadoController implements Initializable {

    @FXML
    private TextField Nombre;
    @FXML
    private TextField Apellidos;
    @FXML
    private TextField telefono;
    @FXML
    private DatePicker fcontrato;
    @FXML
    private DatePicker fnacimiento;
    @FXML
    private RadioButton noadmin;
    @FXML
    private ToggleGroup adminv;
    @FXML
    private RadioButton admin;
    @FXML
    private TextField idauto;
    @FXML
    private PasswordField contrasenyap;
    @FXML
    private PasswordField contrasenyas;
    String errortext="";
   Alert alert = new Alert (Alert.AlertType.ERROR);
   Alert alertcampo = new Alert (Alert.AlertType.ERROR);
    Alert alertconf = new Alert (Alert.AlertType.CONFIRMATION);
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     alertcampo.setTitle("CAMPO ERROR");
                alertcampo.setHeaderText("FALTA CAMPO ERROR");
    }    
     public void initVariable(String info){
   //  cambioid.setText(info);
    }

    @FXML
    private void añadirempleado(ActionEvent event) {
        Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        boolean error=false;
        if (!contrasenyap.getText().equals(contrasenyas.getText())){
           
               alert.setTitle("CONTRASENYA ERROR");
                alert.setHeaderText("CONTRASENYA ERROR");
                alert.setContentText("La contrasenya no son las mismas, introducela de nuevo");
                alert.showAndWait();
                contrasenyap.clear();
                contrasenyas.clear();
               
        }
        else{
            try{
                PreparedStatement stmt2 = con.prepareStatement("INSERT INTO empleado (Apellido, Nombre, Fnacimiento, Fcontrato, Telefono, password, admin) VALUES(?,?,?,?,?,?,?)");
                if (Apellidos.getText().isEmpty()){
                     
                errortext+="EL CAMPO APELLIDOS NO SE ENCUENTRA RELLENADO" + "\n"  + "\n";
                error=true;
               // alert.showAndWait();
                }
                if(Nombre.getText().isEmpty()){
                    errortext+="EL CAMPO NOMBRE NO SE ENCUENTRA RELLENADO" + "\n"  + "\n";
                                error=true;
                }
                
                if (fnacimiento.getValue() == null){
                    errortext+="EL CAMPO FECHA DE NACIMIENTO NO SE ENCUENTRA RELLENADO" + "\n"  + "\n";
                                error=true;
                }
                
                if (fcontrato.getValue() == null){
                    errortext+="EL CAMPO DE FECHA DE CONTRATO NO SE ENCUENTRA RELLENADO" + "\n"  + "\n";
                                error=true;
                }
                
                if (contrasenyap.getText().isEmpty()){
                    errortext+="EL CAMPO DE CONTRASEÑA NO SE ENCUENTRA RELLENADO" + "\n"  + "\n";
                                error=true;
                }
                
                if (error==false){
                    
                
                stmt2.setString(1, Apellidos.getText());
                stmt2.setString(2, Nombre.getText());
               
                stmt2.setString(3, fnacimiento.getValue().toString());
                stmt2.setString(4, fcontrato.getValue().toString());
               stmt2.setString(5, telefono.getText());
               stmt2.setString(6, contrasenyap.getText());
               if (noadmin.isSelected()){
                   stmt2.setBoolean(7, false);
               }
               else{
                   stmt2.setBoolean(7, true);
               }
          stmt2.executeUpdate();
          
   alertconf.setTitle("EXITO");
              alertconf.setHeaderText("Empleado Insertado Con EXITO");
              alertconf.setContentText("El empleado ha sido añadido con exito a la base de datos");
               alertconf.showAndWait();
                
          PreparedStatement stmt3 = con.prepareStatement("SELECT Idempleado from empleado ORDER BY Idempleado DESC LIMIT 0, 1");
    
          ResultSet rs = stmt3.executeQuery();
          rs.next();
          String idemp = Integer.toString(rs.getInt(1));
          
                }
                else {
                    alert.setContentText(errortext);
                alert.showAndWait();
                errortext="";
                }
            }
             catch(SQLException exx){
        alert.setTitle(exx.getMessage());
                alert.setHeaderText("ERROR");
                alert.setContentText("EL PROCESO DE AÑADIR UN EMPLEADO HA SIDO UN ERROR");
                alert.showAndWait();
     }
        }
    }
     
     
     
     
}
