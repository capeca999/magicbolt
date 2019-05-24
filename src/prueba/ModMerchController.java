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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author paco
 */
public class ModMerchController implements Initializable {
Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
Alert alerterror = new Alert (Alert.AlertType.ERROR);
private ObservableList <Merchandasing> mercha  = FXCollections.observableArrayList();
    @FXML
    private TextField Nombre;
    @FXML
    private TextField Descripcion;
    @FXML
    private TextField precio;
    @FXML
    private TextField existencias;
    @FXML
    private TableColumn<Merchandasing, Integer> Idmerchrow;
    @FXML
    private TableColumn<Merchandasing, Double> preciorow;
    @FXML
    private TableColumn<Merchandasing, Double> existenciasrow;
    @FXML
    private TableColumn<Merchandasing, String> nombrerow;
    @FXML
    private TableColumn<Merchandasing, String> descripcionrow;
   
    @FXML
    private TableView<Merchandasing> merchtable;
    @FXML
    private Button añadir;
    @FXML
    private Button mod;
    @FXML
    private Button eliminar;
    @FXML
    private Button aceptar;
    @FXML
    private Button cancelar;
    @FXML
    private TextField idfield;
    @FXML
    private Label existenciaslabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        llenar();
        añadir.setDisable(false);
        añadir.setVisible(true);
        aceptar.setDisable(true);
        aceptar.setVisible(false);
        cancelar.setDisable(true);
        cancelar.setVisible(false);
        Idmerchrow.setEditable(false);
        //llenar();
        
       final ObservableList<Merchandasing> tablaMerchSel = merchtable.getSelectionModel().getSelectedItems();
        tablaMerchSel.addListener(selectormerchtable);    
    }    
  private final ListChangeListener<Merchandasing>selectormerchtable= new ListChangeListener<Merchandasing>(){
            @Override
            public void onChanged (ListChangeListener.Change<? extends Merchandasing> c){
            ponerMerchSeleccionado();
            
            }
            };
  
  
   private void ponerMerchSeleccionado(){
        final Merchandasing Merch = getTablaMerchSeleccionado();
        Integer posicionMerch = mercha.indexOf(Merch);
        if (Merch!=null){
           idfield.setText(Integer.toString(Merch.getIdmerch()));
           
            Nombre.setText(Merch.getNombre());
            Descripcion.setText(Merch.getDescripcion());
            precio.setText(Double.toString(Merch.getPrecio()));
            existencias.setText(Double.toString(Merch.getExistencias()));
            
         //   Integer.toString(int)
          //  Double.toString(double)
            //Integer.toString(int)
        }
    }
   
    public Merchandasing getTablaMerchSeleccionado(){
        if (merchtable!=null){
            List<Merchandasing> tabla = merchtable.getSelectionModel().getSelectedItems();
            if (tabla.size()==1){
                final Merchandasing MerchTipo = tabla.get(0);
                return MerchTipo;
            }
        }
        return null;
    }
   
   
    private void llenar(){
        Merchandasing.llenarMerchh(mercha);
        
        merchtable.setItems(mercha);
        
        Idmerchrow.setCellValueFactory(new PropertyValueFactory<Merchandasing, Integer>("Idmerch"));
         preciorow.setCellValueFactory(new PropertyValueFactory<Merchandasing, Double>("Precio"));
              existenciasrow.setCellValueFactory(new PropertyValueFactory<Merchandasing, Double>("Existencias"));
 nombrerow.setCellValueFactory(new PropertyValueFactory<Merchandasing, String>("Nombre"));
  descripcionrow.setCellValueFactory(new PropertyValueFactory<Merchandasing, String>("Descripcion"));
               /* private TableColumn<Merchandasing, Integer> Idmerchrow;
               @FXML
               private TableColumn<Merchandasing, Double> preciorow;
               @FXML
               private TableColumn<Merchandasing, Double> existenciasrow;
               @FXML
               private TableColumn<Merchandasing, String> nombrerow;
               @FXML
               private TableColumn<Merchandasing, String> descripcionrow;*/
        
    }
  
  
  
    @FXML
    private void añadirmerch(ActionEvent event) {
           // private TextField idfield;*/
        /*      private Button añadir;
        /*      private TextField Nombre;
        @FXML
        private TextField Descripcion;
        @FXML
        private TextField precio;
        @FXML
        private Label existencias;
              @FXML
        private TextField existenciasfield;
        @FXML
        private TableColumn<Merchandasing, Integer> Idmerchrow;
        @FXML
        private TableColumn<Merchandasing, Double> preciorow;
        @FXML
        private TableColumn<Merchandasing, Double> existenciasrow;
        @FXML
        private TableColumn<Merchandasing, String> nombrerow;
        @FXML
        private TableColumn<Merchandasing, String> descripcionrow;
        @FXML
        private TextField existenciasfield;
        @FXML
        private TableView<Merchandasing> merchtable;
        @FXML
        private Button añadir;
        @FXML
        private Button mod;
        @FXML
        private Button eliminar;
        @FXML
        private Button aceptar;
        @FXML
        private Button cancelar;
        @FXML
    
        @FXML
        private Button mod;
        @FXML
        private Button eliminar;
        @FXML
        private Button aceptar;
        @FXML
        private Button cancelar;*/
        
        merchtable.setDisable(true);
Nombre.clear();
idfield.clear();

mod.setDisable(true);
mod.setVisible(false);

eliminar.setDisable(true);
eliminar.setVisible(false);


añadir.setDisable(true);
añadir.setVisible(false);

aceptar.setDisable(false);
aceptar.setVisible(true);

cancelar.setDisable(false);
cancelar.setVisible(true);

añadir.setDisable(true);
añadir.setVisible(false);
        
        
        
    }

    @FXML
    private void modmerch(ActionEvent event) {
        
            Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        ResultSet rs;
        PreparedStatement stmt=null;
        try{
            stmt= con.prepareStatement("UPDATE merchandising SET Nombre=?, Descripcion=?, Existencias=?, Precio=?   WHERE Idmerch= ?;"); 
              
              final Merchandasing Merch = getTablaMerchSeleccionado();
              
            Integer posicionTipo = mercha.indexOf(mercha);
            
            stmt.setString(1, Nombre.getText());
            stmt.setString(2, Descripcion.getText());
            System.out.println(existencias.getText());
            stmt.setDouble(3, Double.parseDouble(existencias.getText()));
            stmt.setDouble(4, Double.parseDouble(precio.getText()));
            stmt.setInt(5, Merch.getIdmerch());
       //     Integer.parseInt()
            
            System.out.println("");
           stmt.executeUpdate();
           merchtable.getItems().clear();
           llenar();
              alert.setTitle("EXITO");
          alert.setHeaderText("MODIFICACIÓN REALIZADA");
          alert.setContentText("LA MODIFICACION DEL MERCHANDASING CON ID " + Merch.getIdmerch()+ " Y Nombre " + Merch.getNombre() + " HA SIDO UN EXITO");
         alert.showAndWait();
        }
         catch(SQLException exx){
         alerterror.setTitle(exx.getMessage());
      alerterror.setHeaderText("ERROR");
      alerterror.setContentText("ERROR EN LA MODIFICACIÓN DE UN MERCHANDASING");
      alerterror.showAndWait();
     }
        merchtable.getItems().clear();
llenar();
    }
        
    

    @FXML
    private void eliminarmerch(ActionEvent event) {
        
        
    }

    @FXML
    private void aceptar(ActionEvent event) {
        
          Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        ResultSet rs;
        PreparedStatement stmt=null;
        try{
            stmt= con.prepareStatement("INSERT INTO merchandising ( Precio, Existencias, Nombre, Descripcion) VALUES(?,?,?,?,?)");
            
            
            
            
            
                  // private TextField idfield;*/
         //     private Button añadir;
          //    private TextField Nombre;
      //  @FXML
    //    private TextField Descripcion;
     //   @FXML
    //    private TextField precio;
     //   @FXML
     //   private Label existencias;
     //         @FXML
    //    private TextField existenciasfield;
            
            
            
            stmt.setInt(1, Integer.parseInt(precio.getText()));
            stmt.setInt(2, Integer.parseInt(existencias.getText()));
            stmt.setString(3, Nombre.getText());
            stmt.setString(4, Descripcion.getText());
            
            
       
            
            stmt.executeUpdate();
            
            
            
            
            
             merchtable.setDisable(false);
Nombre.clear();
idfield.clear();

mod.setDisable(false);
mod.setVisible(true);

eliminar.setDisable(false);
eliminar.setVisible(true);


añadir.setDisable(false);
añadir.setVisible(true);

aceptar.setDisable(true);
aceptar.setVisible(false);

cancelar.setDisable(true);
cancelar.setVisible(false);





merchtable.getItems().clear();
llenar();

            
        }
          catch(SQLException ex){
            ex.getMessage();
        }
        
       alert.setTitle("EXITO");
          alert.setHeaderText("MERCHANDASING AÑADIDO");
          alert.setContentText("MERCHANDASING AÑADIDO CON EXITO");
         alert.showAndWait();  
        
        
        merchtable.getItems().clear();
llenar();
        
        
        
        
    }

    @FXML
    private void cancelar(ActionEvent event) {
        merchtable.setDisable(false);
        Nombre.clear();
idfield.clear();

mod.setDisable(false);
mod.setVisible(true);

eliminar.setDisable(false);
eliminar.setVisible(true);


añadir.setDisable(false);
añadir.setVisible(true);

aceptar.setDisable(true);
aceptar.setVisible(false);

cancelar.setDisable(true);
cancelar.setVisible(false);
    }
    
}
