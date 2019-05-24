/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import DAO.Conexion;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author DAW
 */
public class ModEdicionController implements Initializable {
Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
Alert alerterror = new Alert (Alert.AlertType.ERROR);
private ObservableList <Edicion> ediciona = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Edicion, String> nombrerow;
    @FXML
    private TableColumn<Edicion, Date> fecharow;
    @FXML
    private Button modificar;
    private Button eliminarsubtipo;
    @FXML
    private Button añadirboton;
    @FXML
    private Button aceptarboton;
    @FXML
    private Button cancelarboton;
    @FXML
    private TableView<Edicion> tablaedicion;
    @FXML
    private TextField nombreedicion;
    @FXML
    private TextField idedicion;
    @FXML
    private DatePicker fechalanza;
    @FXML
    private TableColumn<Edicion, Integer> Idedicionrow;
    @FXML
    private Button eliminaredicion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       aceptarboton.setDisable(true);
aceptarboton.setVisible(false);
cancelarboton.setDisable(true);
cancelarboton.setVisible(false);
idedicion.setEditable(false);

 llenar();
        final ObservableList<Edicion> tablaEdicionSel= tablaedicion.getSelectionModel().getSelectedItems();
       tablaEdicionSel.addListener(selectorediciontable);
    }


 private final ListChangeListener<Edicion>selectorediciontable= new ListChangeListener<Edicion>(){
            @Override
            public void onChanged (ListChangeListener.Change<? extends Edicion> c){
            ponerEdicionSeleccionado();
            
            }
            };

 private void ponerEdicionSeleccionado(){
        final Edicion edicion = getEdicionSeleccionado();
        Integer posicionEdicion = ediciona.indexOf(edicion);
        if (edicion!=null){
            idedicion.setText(Integer.toString(edicion.getIdedicion()));
            
            nombreedicion.setText(edicion.getNombre());
            fechalanza.setValue(edicion.getFechalanzamiento().toLocalDate());
            
            //Integer.toString(int)
        }
    }
      public Edicion getEdicionSeleccionado(){
        if (tablaedicion!=null){
            List<Edicion> tabla = tablaedicion.getSelectionModel().getSelectedItems();
            if (tabla.size()==1){
                final Edicion EdicionSeleccionado = tabla.get(0);
                return EdicionSeleccionado;
            }
        }
        return null;
    }
      
      private void llenar(){
        Edicion.llenarEdicion(ediciona);
          tablaedicion.setItems(ediciona);
          Idedicionrow.setCellValueFactory(new PropertyValueFactory<Edicion, Integer>("Idedicion"));
          nombrerow.setCellValueFactory(new PropertyValueFactory<Edicion, String>("Nombre"));
          fecharow.setCellValueFactory(new PropertyValueFactory<Edicion, Date>("Fechalanzamiento"));

 
        /*         private TableColumn<Edicion, String> nombrerow;
        @FXML
        private TableColumn<Edicion, Date> fecharow;
        @FXML*/
       // private TableColumn<Edicion, Integer> Idedicionrow;
        
      }
      
      

    @FXML
    private void modificartable(ActionEvent event) {
       Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        ResultSet rs;
        PreparedStatement stmt=null;
        try{
            stmt= con.prepareStatement("UPDATE Edicion SET Nombre=?, Fechalanzamiento=?  WHERE Idsubtipo= ?;");
            stmt.setString(1, nombreedicion.getText());
            stmt.setString(2, fechalanza.getValue().toString());
            
            final Edicion edicion = getEdicionSeleccionado();
            Integer posicionEdicion = ediciona.indexOf(edicion);
           stmt.setInt(3, edicion.getIdedicion());
           stmt.executeUpdate();
          tablaedicion.getItems().clear();
           llenar();
              alert.setTitle("EXITO");
          alert.setHeaderText("MODIFICACIÓN REALIZADA");
          alert.setContentText("LA MODIFICACION DE LA EDICIÓN CON ID " + edicion.getIdedicion()+ " Y Nombre " + edicion.getNombre() + " HA SIDO UN EXITO");
         alert.showAndWait();
        }
         catch(SQLException exx){
         alerterror.setTitle(exx.getMessage());
      alerterror.setHeaderText("ERROR");
      alerterror.setContentText("ERROR EN LA MODIFICACIÓN DE UNA EDICIÓN");
      alerterror.showAndWait();
     }
        tablaedicion.getItems().clear();
llenar();
           
        
        
        
    }


    @FXML
    private void invisible(ActionEvent event) {
          tablaedicion.setDisable(true);
nombreedicion.clear();
idedicion.clear();
fechalanza.setValue(null);

modificar.setDisable(true);
modificar.setVisible(false);

eliminaredicion.setDisable(true);
eliminaredicion.setVisible(false);


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
    private void añadir(ActionEvent event) {
        
            Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        ResultSet rs;
        PreparedStatement stmt=null;
        try{
            stmt= con.prepareStatement("INSERT INTO edicion (Nombre, Fechalanzamiento ) VALUES(?,?)");
            stmt.setString(1,nombreedicion.getText());
            stmt.setString(2, fechalanza.getValue().toString());
            
            
            
            stmt.executeUpdate();
             tablaedicion.setDisable(false);
nombreedicion.clear();
idedicion.clear();
fechalanza.setValue(null);

modificar.setDisable(false);
modificar.setVisible(true);

eliminaredicion.setDisable(false);
eliminaredicion.setVisible(true);




añadirboton.setDisable(false);
añadirboton.setVisible(true);

aceptarboton.setDisable(true);
aceptarboton.setVisible(false);

cancelarboton.setDisable(true);
cancelarboton.setVisible(false);
tablaedicion.getItems().clear();
llenar();

            
        }
          catch(SQLException ex){
            ex.getMessage();
        }
        
       alert.setTitle("EXITO");
          alert.setHeaderText("EDICION AÑADIDA");
          alert.setContentText("EDICION AÑADIDA CON EXITO");
         alert.showAndWait();  
        
        
        
    }

    @FXML
    private void cancelar(ActionEvent event) {
            tablaedicion.setDisable(false);
nombreedicion.clear();
idedicion.clear();
fechalanza.setValue(null);
modificar.setDisable(false);
modificar.setVisible(true);

eliminaredicion.setDisable(false);
eliminaredicion.setVisible(true);


añadirboton.setDisable(false);
añadirboton.setVisible(true);

aceptarboton.setDisable(true);
aceptarboton.setVisible(false);

cancelarboton.setDisable(true);
cancelarboton.setVisible(false);
    }

    @FXML
    private void eliminaredicion(ActionEvent event) {
    }
    
}
/*  private TextField nombreedicion;
@FXML
private TextField idedicion;
@FXML
private DatePicker fechalanza;*/