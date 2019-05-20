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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author DAW
 */
public class PruebaController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private AnchorPane principal;
    @FXML
    private MenuItem menuitemdentro;
    private RadioMenuItem opc1;
    @FXML
    private TextField cambioid;
    @FXML
    private MenuItem añadirempleado;
    @FXML
    private MenuItem eliminarempleado;
    @FXML
    private MenuItem modempelado;
       Alert alert = new Alert (Alert.AlertType.ERROR);
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    cambioid.setVisible(false);
    
       
    }    

     public void initVariable(String info){
     cambioid.setText(info);
    }

    @FXML
    private void abrirventana(ActionEvent event) {
        try{
            String todo="hola";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu2.fxml"));
            Parent root1 = (Parent)fxmlLoader.load();
            Stage stage = new Stage();
            Menu2Controller controller = fxmlLoader.<Menu2Controller>getController();
            
            controller.initVariable(todo);
            stage.setScene(new Scene(root1));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
            
            
        }
        
        catch(Exception ex){
            ex.getMessage();
        }
        
        
    }

    private void comprobar(ActionEvent event) {
    
        if(opc1.isSelected()){
            System.out.println("Check Marcado");
        }
        else System.out.println("no");
        
        
    }

      @FXML
    private void abrirañadir(ActionEvent event) {
        try{
          
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("añadirmenuu.fxml"));
            Parent root1 = (Parent)fxmlLoader.load();
            Stage stage = new Stage();
            
            AñadirmenuuController controller = fxmlLoader.<AñadirmenuuController>getController();
            
      
          
            stage.setScene(new Scene(root1));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
            
            
        }
        
        catch(Exception ex){
            ex.getMessage();
        }
        
        
    }
    
    /*  @FXML
    private void abrirañadir(ActionEvent event) {
    try{
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("añadirmenu.fxml"));
    Parent root1 = (Parent)fxmlLoader.load();
    Stage stage = new Stage();
    
    }
    }
    
    
    */

    @FXML
    private void abrirañadirpedido(ActionEvent event) {
           try{
            String todo="hola";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("crearpedido.fxml"));
            Parent root1 = (Parent)fxmlLoader.load();
            Stage stage = new Stage();
            CrearpedidoController controller = fxmlLoader.<CrearpedidoController>getController();
            String pasarid="";
            pasarid=cambioid.getText();
           
         
            controller.initVariable(pasarid);
            stage.setScene(new Scene(root1));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
            
            
        }
        
        catch (IOException ex){
                Logger.getLogger(CrearpedidoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    }

    @FXML
    private void abrirañadircliente(ActionEvent event) {
          try{
              //AñadirCliente.fxml
            String todo="hola";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AñadirCliente.fxml"));
            Parent root1 = (Parent)fxmlLoader.load();
            Stage stage = new Stage();
            AñadirClienteController controller = fxmlLoader.<AñadirClienteController>getController();
            String pasarid="";
            pasarid=cambioid.getText();
            int pasarainit=0;
           pasarainit= Integer.parseInt(pasarid);
        
            stage.setScene(new Scene(root1));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
            
            
        }
        
        catch(IOException | NumberFormatException ex){
            ex.getMessage();
        }
        
    }

    /*
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Prueba.fxml"));
    Parent root1 = (Parent)fxmlLoader.load();
    Stage stage = new Stage();
    PruebaController controller = fxmlLoader.<PruebaController>getController();
    controller.initVariable(empleado.getText());
    stage.setScene(new Scene (root1));
    stage.initModality(Modality.APPLICATION_MODAL);
    stage.show();
    */
    @FXML
    private void abrirañadirempelado(ActionEvent event) {
        Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        
        try{
            PreparedStatement stmt2 = con.prepareStatement("Select admin from empleado where Idempleado = ?");
           int idd = Integer.parseInt(cambioid.getText());
           
            stmt2.setInt(1, idd);
            ResultSet rst = stmt2.executeQuery();
           rst.next();
           if (rst.getBoolean(1)==false){
                             
           alert.setTitle("ADMIN ERROR");
                alert.setHeaderText("ADMIN ERROR HEADER");
                alert.setContentText("No eres administrador, no puedes entrar");
                alert.showAndWait();
           }
           else 
              try{
            String todo="hola";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AñadirEmpleado.fxml"));
            Parent root1 = (Parent)fxmlLoader.load();
            Stage stage = new Stage();
            AñadirEmpleadoController controller = fxmlLoader.<AñadirEmpleadoController>getController();
            controller.initVariable(cambioid.getText());
       
          
       
        
            stage.setScene(new Scene(root1));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
            
            
        }
             catch(IOException ex){
            ex.getMessage();
        }
        }
         catch(SQLException exx){
         exx.getMessage();
     }
       
        
        
      
    }

    @FXML
    private void abrireliminarempleado(ActionEvent event) {
    }

    @FXML
    private void abrirmodempleado(ActionEvent event) {
      
         Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        
        try{
            PreparedStatement stmt2 = con.prepareStatement("Select admin from empleado where Idempleado = ?");
           int idd = Integer.parseInt(cambioid.getText());
           
            stmt2.setInt(1, idd);
            ResultSet rst = stmt2.executeQuery();
           rst.next();
           if (rst.getBoolean(1)==false){
                             
           alert.setTitle("ADMIN ERROR");
                alert.setHeaderText("ADMIN ERROR HEADER");
                alert.setContentText("No eres administrador, no puedes entrar");
                alert.showAndWait();
           }
           else 
              try{
            String todo="hola";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Modempelado.fxml"));
            Parent root1 = (Parent)fxmlLoader.load();
            Stage stage = new Stage();
            ModempeladoController controller = fxmlLoader.<ModempeladoController>getController();
        
       
          
       
        
            stage.setScene(new Scene(root1));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
            
            
        }
             catch(IOException ex){
            ex.getMessage();
        }
        }
         catch(SQLException exx){
         exx.getMessage();
     }  
        
    }

    @FXML
    private void abrirputamierda(ActionEvent event) {
    try{
            String todo="hola";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("crearpedido.fxml"));
            Parent root1 = (Parent)fxmlLoader.load();
            Stage stage = new Stage();
            CrearpedidoController controller = fxmlLoader.<CrearpedidoController>getController();
            String pasarid="";
            pasarid=cambioid.getText();
            int pasarainit=0;
         //  pasarainit= Integer.parseInt(pasarid);
          //  controller.initVariable(pasarainit);
            stage.setScene(new Scene(root1));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
            
            
        }
        
        catch(Exception ex){
            ex.getMessage();
        }
        
        
    }
    
    
}
