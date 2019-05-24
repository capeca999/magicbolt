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
public class AñadirModTipoController implements Initializable {
Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
Alert alerterror = new Alert (Alert.AlertType.ERROR);
private ObservableList <Tipo> tipoa = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Tipo, Integer> Idtiporow;
    @FXML
    private TableColumn<Tipo, String> nombrerow;
    @FXML
    private TextField nombrefield;
    @FXML
    private TextField idtipofield;
    @FXML
    private Button modificar;
    @FXML
    private Button eliminartipo;
    @FXML
    private Button añadirboton;
    @FXML
    private Button aceptarboton;
    @FXML
    private Button cancelarboton;
    @FXML
    private TableView<Tipo> tablatipo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
aceptarboton.setDisable(true);
aceptarboton.setVisible(false);
cancelarboton.setDisable(true);
cancelarboton.setVisible(false);
Idtiporow.setEditable(false);
        llenar();
        final ObservableList<Tipo> tablaTipoSel= tablatipo.getSelectionModel().getSelectedItems();
       tablaTipoSel.addListener(selectortipotable);
        
    }    
    
    
    
    
    private final ListChangeListener<Tipo>selectortipotable= new ListChangeListener<Tipo>(){
            @Override
            public void onChanged (ListChangeListener.Change<? extends Tipo> c){
            ponerTipoSeleccionado();
            
            }
            };
    
    private void ponerTipoSeleccionado(){
        final Tipo tipo = getTablaTiposSeleccionado();
        Integer posicionTipo = tipoa.indexOf(tipo);
        if (tipo!=null){
            idtipofield.setText(Integer.toString(tipo.getIdtipo()));
            nombrefield.setText(tipo.getNombre());
            
            //Integer.toString(int)
        }
    }
    
    public Tipo getTablaTiposSeleccionado(){
        if (tablatipo!=null){
            List<Tipo> tabla = tablatipo.getSelectionModel().getSelectedItems();
            if (tabla.size()==1){
                final Tipo TipoSeleccionado = tabla.get(0);
                return TipoSeleccionado;
            }
        }
        return null;
    }
    
    private void llenar(){
        Tipo.llenarTipo(tipoa);
        tablatipo.setItems(tipoa);
        
        Idtiporow.setCellValueFactory(new PropertyValueFactory<Tipo, Integer>("Idtipo"));
               nombrerow.setCellValueFactory(new PropertyValueFactory<Tipo, String>("Nombre"));

        
        
    }

    @FXML
    private void modificartable(ActionEvent event) {
          Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        ResultSet rs;
        PreparedStatement stmt=null;
        try{
            stmt= con.prepareStatement("UPDATE tipo SET Nombre=? WHERE Idtipo= ?;");
            stmt.setString(1, nombrefield.getText());
            final Tipo tipo = getTablaTiposSeleccionado();
            Integer posicionTipo = tipoa.indexOf(tipo);
           stmt.setInt(2, tipo.getIdtipo());
           stmt.executeUpdate();
           tablatipo.getItems().clear();
           llenar();
              alert.setTitle("EXITO");
          alert.setHeaderText("MODIFICACIÓN REALIZADA");
          alert.setContentText("LA MODIFICACION DEL Tipo CON ID " + tipo.getIdtipo()+ " Y Nombre " + tipo.getNombre() + " HA SIDO UN EXITO");
         alert.showAndWait();
        }
         catch(SQLException exx){
         alerterror.setTitle(exx.getMessage());
      alerterror.setHeaderText("ERROR");
      alerterror.setContentText("ERROR EN LA MODIFICACIÓN DE UN TIPO");
      alerterror.showAndWait();
     }
        tablatipo.getItems().clear();
llenar();
    }

    @FXML
    private void eliminartipo(ActionEvent event) {
           Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
          PreparedStatement stmt=null;
             PreparedStatement stmt2=null; 
             
             final Tipo tipo = getTablaTiposSeleccionado();
             Integer posicionTipo = tipoa.indexOf(tipo);
           
        
    }

    @FXML
    private void invisible(ActionEvent event) {
tablatipo.setDisable(true);
nombrefield.clear();
idtipofield.clear();

modificar.setDisable(true);
modificar.setVisible(false);

eliminartipo.setDisable(true);
eliminartipo.setVisible(false);


añadirboton.setDisable(true);
añadirboton.setVisible(false);

aceptarboton.setDisable(false);
aceptarboton.setVisible(true);

cancelarboton.setDisable(false);
cancelarboton.setVisible(true);

añadirboton.setDisable(true);
añadirboton.setVisible(false);


/*           private Button modificar;
@FXML
private Button eliminartipo;
@FXML
private Button añadirboton;
@FXML
private Button aceptarboton;
@FXML
private Button cancelarboton;
@FXML*/
        
        
    }

    @FXML
    private void añadir(ActionEvent event) {
         Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        ResultSet rs;
        PreparedStatement stmt=null;
        try{
            stmt= con.prepareStatement("INSERT INTO tipo (Nombre) VALUES(?)");
            stmt.setString(1,nombrefield.getText());
            System.out.println(nombrefield.getText());
            
            stmt.executeUpdate();
             tablatipo.setDisable(false);
nombrefield.clear();
idtipofield.clear();

modificar.setDisable(false);
modificar.setVisible(true);

eliminartipo.setDisable(false);
eliminartipo.setVisible(true);


añadirboton.setDisable(false);
añadirboton.setVisible(true);

aceptarboton.setDisable(true);
aceptarboton.setVisible(false);

cancelarboton.setDisable(true);
cancelarboton.setVisible(false);
tablatipo.getItems().clear();
llenar();

            
        }
          catch(SQLException ex){
            ex.getMessage();
        }
        
       alert.setTitle("EXITO");
          alert.setHeaderText("TIPO AÑADIDO");
          alert.setContentText("TIPO AÑADIDO CON EXITO");
         alert.showAndWait();  
        
        
        
    }

    @FXML
    private void cancelar(ActionEvent event) {
        
        tablatipo.setDisable(false);
nombrefield.clear();
idtipofield.clear();

modificar.setDisable(false);
modificar.setVisible(true);

eliminartipo.setDisable(false);
eliminartipo.setVisible(true);


añadirboton.setDisable(false);
añadirboton.setVisible(true);

aceptarboton.setDisable(true);
aceptarboton.setVisible(false);

cancelarboton.setDisable(true);
cancelarboton.setVisible(false);
        
    }
    
}
