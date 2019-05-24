/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import DAO.Conexion;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author paco
 */
public class LoginController implements Initializable {

    @FXML
    private TextField empleado;
    private TextField contrasenya;
    @FXML
    private Button reset;
    @FXML
    private Button login;
    @FXML
    private PasswordField contrasenyaa;

    Alert alert = new Alert (AlertType.ERROR);
        Alert info = new Alert (AlertType.INFORMATION);
    @FXML
    private Button siguiente;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

     @FXML
    private void siguiente(ActionEvent event) {
        try{
  
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Prueba.fxml"));
        Parent root1 = (Parent)fxmlLoader.load();
        Stage stage = new Stage();
        PruebaController controller = fxmlLoader.<PruebaController>getController();
        controller.initVariable(empleado.getText());
        stage.setScene(new Scene (root1));
        stage.initModality(Modality.APPLICATION_MODAL);
       stage.show();
       
        
    }
     catch(IOException ex){
            ex.getMessage();
        }
    }
    
    @FXML
    private void resetall(ActionEvent event) {
        contrasenyaa.clear();
       empleado.clear();
       
       alert.setTitle("CLEARED");
       alert.setHeaderText("CLEARED HEADER");
       alert.setContentText("Los campos han sido limpiados");
       alert.showAndWait();
   
    }
    
  
    
private void abrirventana(String id){
    try{
   
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Prueba.fxml"));
          

          Parent root1 = (Parent)fxmlLoader.load();
        Stage stage = new Stage();
        PruebaController controller = fxmlLoader.<PruebaController>getController();
        controller.initVariable(id);
        stage.setScene(new Scene (root1));
        stage.initModality(Modality.APPLICATION_MODAL);
       stage.show();
       
        
    }
     catch(IOException ex){
            ex.getMessage();
        }
}
    @FXML
    private void login(ActionEvent event) {
    
              Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        
        try{
         
   
            PreparedStatement stmt2 = con.prepareStatement("Select count(*) from empleado where password = ? and Idempleado = ?");
            
            String user = empleado.getText(), pass = contrasenyaa.getText();
           
            
            stmt2.setString(1, pass);
            stmt2.setString(2, user);
            
            
            ResultSet rs = stmt2.executeQuery();
            rs.next();
       
            if (rs.getInt(1)==0){
                System.out.println("incorrecto");
                
                       alert.setTitle("INCORRECTO");
       alert.setHeaderText("CAMPO INCORRECTO");
       alert.setContentText("ALGUN CAMPO ES INCORRECTO");
       alert.showAndWait();
                
       
       
            }
            else {
                System.out.println("Correcto");
                     info.setTitle("Correcto");
       info.setHeaderText("CAMPOS CORRECTOS");
       info.setContentText("CAMPOS SON CORRECTOS BIENVENIDO");
       info.showAndWait();
                abrirventana(user);
            }
            
            /*
            
                  PreparedStatement stmt3 = con.prepareStatement("Select count(*) as cantidad from empleado where password = ? and Idempleado = ?");
         stmt3.setString(1, contrasenyaa.getText());
         stmt3.setString(2, empleado.getText());
         ResultSet rss= stmt3.executeQuery();
         
            System.out.println(rs.getInt(1));
            if(rs.next()){
              
           alert.setTitle("ID ERROR");
                alert.setHeaderText("ID ERROR HEADER");
                alert.setContentText("El id introducido esta mal introducido o no existe");
                alert.showAndWait();
              empleado.clear();
                
            }
        
         
   else     if (!rss.next()){
               alert.setTitle("CONTRASENYA ERROR");
                alert.setHeaderText("CONTRASENYA ERROR HEADER");
                alert.setContentText("La contraseña introducida esta mal introducida o no existe");
                alert.showAndWait();
                contrasenyaa.clear();
         } else abrirventana(result);
        
*/
 
         
       
            
        }
                catch(SQLException exx){
         exx.getMessage();
     }
    }

   
    
}
