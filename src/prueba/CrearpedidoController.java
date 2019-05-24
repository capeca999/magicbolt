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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author paco
 */
public class CrearpedidoController implements Initializable {
  Alert alert = new Alert (Alert.AlertType.ERROR);
    @FXML
    private TextField empleadodni;
    @FXML
    private DatePicker fechapedido;
    @FXML
    private TextField idreal;
    @FXML
    private TextField idempleado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void initVariable(String id){
    
        idempleado.setText(id);
        
    }
  @FXML
    public void findid(ActionEvent event){
        Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        
        try{
            PreparedStatement stmt2 = con.prepareStatement("Select Idpersona from cliente where DNI = ?");
            stmt2.setString(1, empleadodni.getText());
            
            
            ResultSet rs = stmt2.executeQuery();
            if(!rs.next()){
                   alert.setTitle("DNI ERROR");
                alert.setHeaderText("DNI ERROR INTRODUCIDO");
                alert.setContentText("El DNI introducido esta mal o no esta como cliente");
                alert.showAndWait();
            }
            else idreal.setText(rs.getString(1));
            
        }
         catch(SQLException exx){
         exx.getMessage();
     }
    }

    @FXML
    private void crearpedido(ActionEvent event) {
        try{
         
            /*          private TextField empleadodni;
            @FXML
            private DatePicker fechapedido;
            @FXML
            private TextField idreal;
            @FXML
            private TextField idempleado;*/

            
           Conexion conexion = new Conexion();
            Connection con = conexion.conectar();
          // Idlinea 	Pedido 	Carta 	Precio 	Cantidad
            PreparedStatement stmt2 = con.prepareStatement("INSERT INTO pedidos (Idcliente, empleado, Fecha) VALUES(?,?,?)");
           stmt2.setInt(1, Integer.parseInt(idreal.getText()));
           stmt2.setInt(2, Integer.parseInt(idempleado.getText()));
           stmt2.setString(3, fechapedido.getValue().toString());
                      stmt2.executeUpdate();
             
                      PreparedStatement stmt3 = con.prepareStatement("SELECT Idpedido from pedidos");
                   ResultSet   rs =stmt3.executeQuery();
                   rs.last();
                      
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Añadirlinea.fxml"));
            Parent root1 = (Parent)fxmlLoader.load();
            Stage stage = new Stage();
            AñadirlineaController controller = fxmlLoader.<AñadirlineaController>getController();
            String pasarid="";
            pasarid=idempleado.getText();
            String pasaridcliente=idreal.getText();
            controller.initVariable(pasarid, pasaridcliente, rs.getInt(1));
            stage.setScene(new Scene(root1));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
            
            
            
            
            
                    }
        
        
      
           catch(SQLException ex){
            ex.getMessage();
        }
        catch (IOException exx){
            exx.getMessage();
        }
        
        
        /*
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
        
        catch(Exception ex){
        ex.getMessage();
        }
        
        }
        
        */
        
        
        
        
        
        
        
        
    }
    
}
