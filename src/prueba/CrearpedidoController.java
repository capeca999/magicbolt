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
import javafx.scene.control.TextField;

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
     public void initVariable(int id){
        String idempleadoo = Integer.toString(id);
        idempleado.setText(idempleadoo);
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
                alert.setHeaderText("DNI ERROR HEADER");
                alert.setContentText("El DNI introducido esta mal o no esta como cliente");
                alert.showAndWait();
            }
            else idreal.setText(rs.getString(1));
            
        }
         catch(SQLException exx){
         exx.getMessage();
     }
    }
    
}
