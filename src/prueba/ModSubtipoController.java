/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import DAO.Conexion;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 * FXML Controller class
 *
 * @author DAW
 */
public class ModSubtipoController implements Initializable {
Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
Alert alerterror = new Alert (Alert.AlertType.ERROR);
private ObservableList <subtipo> suba = FXCollections.observableArrayList();
    @FXML
    private TableView<subtipo> tablasubtipo;
    @FXML
    private TableColumn<subtipo, Integer> Idsubtiporow;
    @FXML
    private TableColumn<subtipo, String> nombrerow;
    @FXML
    private Button cancelarboton;
    @FXML
    private Button aceptarboton;
    @FXML
    private Button añadirboton;
    @FXML
    private Button eliminarsubtipo;
    @FXML
    private Button modificar;
    @FXML
    private TextField idsubtipofield;
    @FXML
    private TextField nombrefield;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   aceptarboton.setDisable(true);
aceptarboton.setVisible(false);
cancelarboton.setDisable(true);
cancelarboton.setVisible(false);
Idsubtiporow.setEditable(false);
        llenar();
        final ObservableList<subtipo> tablaSubTipoSel= tablasubtipo.getSelectionModel().getSelectedItems();
       tablaSubTipoSel.addListener(selectorsubtipotable);
    }   
    
     private final ListChangeListener<subtipo>selectorsubtipotable= new ListChangeListener<subtipo>(){
            @Override
            public void onChanged (ListChangeListener.Change<? extends subtipo> c){
            ponerSubTipoSeleccionado();
            
            }
            };
     
      private void ponerSubTipoSeleccionado(){
        final subtipo subtipo = getTablaSubTiposSeleccionado();
        Integer posicionSubTipo = suba.indexOf(subtipo);
        if (subtipo!=null){
            Idsubtiporow.setText(Integer.toString(subtipo.getIdsubtipo()));
            nombrefield.setText(subtipo.getNombre());
            
            //Integer.toString(int)
        }
    }
      
        public subtipo getTablaSubTiposSeleccionado(){
        if (tablasubtipo!=null){
            List<subtipo> tabla = tablasubtipo.getSelectionModel().getSelectedItems();
            if (tabla.size()==1){
                final subtipo SubTipoSeleccionado = tabla.get(0);
                return SubTipoSeleccionado;
            }
        }
        return null;
    }
      
      private void llenar(){
        subtipo.llenarSubtipo(suba);
        tablasubtipo.setItems(suba);
        
        Idsubtiporow.setCellValueFactory(new PropertyValueFactory<subtipo, Integer>("Idsubtipo"));
               nombrerow.setCellValueFactory(new PropertyValueFactory<subtipo, String>("Nombre"));

        
        
    }


    @FXML
    private void cancelar(ActionEvent event) {
                
        tablasubtipo.setDisable(false);
nombrefield.clear();
idsubtipofield.clear();

modificar.setDisable(false);
modificar.setVisible(true);

eliminarsubtipo.setDisable(false);
eliminarsubtipo.setVisible(true);


añadirboton.setDisable(false);
añadirboton.setVisible(true);

aceptarboton.setDisable(true);
aceptarboton.setVisible(false);

cancelarboton.setDisable(true);
cancelarboton.setVisible(false);
    }

    @FXML
    private void añadir(ActionEvent event) {
                Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        ResultSet rs;
        PreparedStatement stmt=null;
        try{
            stmt= con.prepareStatement("INSERT INTO subtipo (Nombre) VALUES(?)");
            stmt.setString(1,nombrefield.getText());
            
            
            stmt.executeUpdate();
             tablasubtipo.setDisable(false);
nombrefield.clear();
idsubtipofield.clear();

modificar.setDisable(false);
modificar.setVisible(true);

eliminarsubtipo.setDisable(false);
eliminarsubtipo.setVisible(true);


añadirboton.setDisable(false);
añadirboton.setVisible(true);

aceptarboton.setDisable(true);
aceptarboton.setVisible(false);

cancelarboton.setDisable(true);
cancelarboton.setVisible(false);
tablasubtipo.getItems().clear();
llenar();

            
        }
          catch(SQLException ex){
            ex.getMessage();
        }
        
       alert.setTitle("EXITO");
          alert.setHeaderText("SUBTIPO AÑADIDO");
          alert.setContentText("SUBTIPO AÑADIDO CON EXITO");
         alert.showAndWait();  
        
        
        
    }

    @FXML
    private void invisible(ActionEvent event) {
        tablasubtipo.setDisable(true);
nombrefield.clear();
idsubtipofield.clear();

modificar.setDisable(true);
modificar.setVisible(false);

eliminarsubtipo.setDisable(true);
eliminarsubtipo.setVisible(false);


añadirboton.setDisable(true);
añadirboton.setVisible(false);

aceptarboton.setDisable(false);
aceptarboton.setVisible(true);

cancelarboton.setDisable(false);
cancelarboton.setVisible(true);

añadirboton.setDisable(true);
añadirboton.setVisible(false);
    }

    @FXML
    private void eliminarsubtipo(ActionEvent event) {
    }

    @FXML
    private void modificartable(ActionEvent event) {
         Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        ResultSet rs;
        PreparedStatement stmt=null;
        try{
            stmt= con.prepareStatement("UPDATE subtipo SET Nombre=? WHERE Idsubtipo= ?;");
            stmt.setString(1, nombrefield.getText());
            final subtipo subtipoo = getTablaSubTiposSeleccionado();
            Integer posicionSubTipo = suba.indexOf(subtipoo);
           stmt.setInt(2, subtipoo.getIdsubtipo());
           stmt.executeUpdate();
          tablasubtipo.getItems().clear();
           llenar();
              alert.setTitle("EXITO");
          alert.setHeaderText("MODIFICACIÓN REALIZADA");
          alert.setContentText("LA MODIFICACION DEL SUBTIPO CON ID " + subtipoo.getIdsubtipo()+ " Y Nombre " + subtipoo.getNombre() + " HA SIDO UN EXITO");
         alert.showAndWait();
        }
         catch(SQLException exx){
         alerterror.setTitle(exx.getMessage());
      alerterror.setHeaderText("ERROR");
      alerterror.setContentText("ERROR EN LA MODIFICACIÓN DE UN SUBTIPO");
      alerterror.showAndWait();
     }
        tablasubtipo.getItems().clear();
llenar();
        
    }
    
}
