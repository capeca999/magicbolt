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
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author paco
 */
public class AñadirEventoController implements Initializable {
    boolean correcto=true;
    String errortext="";
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    Alert alerterror = new Alert (Alert.AlertType.ERROR);
     private ObservableList <Clientes> clientea = FXCollections.observableArrayList();
     private ObservableList <String> formato = FXCollections.observableArrayList();
    @FXML
    private TextField idjuezfield;
    @FXML
    private TableView<Clientes> jueztable;
    @FXML
    private TableColumn<Clientes, String> nombrerow;
    @FXML
    private TableColumn<Clientes, String> apellidorow;
    @FXML
    private TextArea descripcionfield;
    @FXML
    private TextField ideventofield;
    @FXML
    private TextField diafield;
    @FXML
    private DatePicker fechaevento;
    @FXML
    private TextField premiofield;
    @FXML
    private ComboBox<String> formatocombo;
    @FXML
    private TableColumn<Clientes, String> DNIrow;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         llenar();
        
       final ObservableList<Clientes> tablaJuezSel = jueztable.getSelectionModel().getSelectedItems();
tablaJuezSel.addListener(selectortablajuez); 
        
    formato.add("Standard");
    formato.add("Modern");
    formato.add("Pauper");
    formato.add("Legacy");
    formato.add("Vintage");
    formato.add("Penny Dreadful");
    formato.add("Commander 1v1");
    formato.add("Commander");
    formato.add("Brawl");
    formato.add("Arena Standard");
formatocombo.setItems(formato);
        
    }



private void llenar(){
    Clientes.llenarJuez(clientea);
    jueztable.setItems(clientea);
    
    nombrerow.setCellValueFactory(new PropertyValueFactory<Clientes, String>("Nombre"));
    apellidorow.setCellValueFactory(new PropertyValueFactory<Clientes, String>("Apellido"));
    DNIrow.setCellValueFactory(new PropertyValueFactory<Clientes, String>("DNI"));
}
    
     private final ListChangeListener<Clientes>selectortablajuez= new ListChangeListener<Clientes>(){
        @Override
        public void onChanged (ListChangeListener.Change<? extends Clientes> c){
            ponerJuezSeleccionado();
        }
    };
     
      public Clientes getTablaJuezSeleccionado(){
        if (jueztable!=null){
            List<Clientes> tabla = jueztable.getSelectionModel().getSelectedItems();
            if (tabla.size()==1){
                final Clientes JuezSeleccionado = tabla.get(0);
                return JuezSeleccionado;
            }
        }
        return null;
    }
     public void ponerJuezSeleccionado(){
         final Clientes juez = getTablaJuezSeleccionado();
         Integer posicionjuez = clientea.indexOf(juez);
         
         if (juez!=null){
             idjuezfield.setText(Integer.toString(juez.getIdpersona()));
             
         }
         
     }

    @FXML
    private void añadir(ActionEvent event) {
         Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        correcto=true;
        errortext="";
        try{
            if (premiofield.getText().isEmpty()){
               errortext+="EL CAMPO PREMIO NO SE ENCUENTRA RELLENADO" + "\n"  + "\n";
               correcto=false;
            }
            
            if (formatocombo.getSelectionModel().isEmpty()){
                    errortext+="EL CAMPO FORMATO NO SE ENCUENTRA RELLENADO" + "\n"  + "\n";
                     correcto=false;
            }
            
            if (descripcionfield.getText().isEmpty()){
                    errortext+="EL CAMPO DESCRIPCION NO SE ENCUENTRA RELLENADO" + "\n"  + "\n";
                     correcto=false;
            }
            if (idjuezfield.getText().isEmpty()){
                    errortext+="EL CAMPO JUEZ NO SE ENCUENTRA RELLENADO" + "\n"  + "\n";
                     correcto=false;
            }
            if (correcto==true){
                
            
            PreparedStatement stmt2 = con.prepareStatement("INSERT INTO evento (Fecha_evento, Formato, Idjuez, Descripcion, Premio) VALUES(?,?,?,?,?) ");
            stmt2.setString(1, fechaevento.getValue().toString());
            stmt2.setString(2, formatocombo.getValue());
            stmt2.setInt(3, Integer.parseInt(idjuezfield.getText()));
            stmt2.setString(4, descripcionfield.getText());
            double value = Double.parseDouble(premiofield.getText());
            stmt2.setDouble(5, value);
            stmt2.executeUpdate();
            }
            else {
                alerterror.setTitle("ERROR CAMPOS");
                alerterror.setHeaderText("CAMPOS NO RELLENADOS");
              alerterror.setContentText(errortext);
               alerterror.showAndWait(); 
            }
        }
         catch(SQLException exx){
         exx.getMessage();
     }
        //	Idevento 	Fecha_evento 	Formato 	Idjuez 	Descripcion 	Premio 
        
        
        
        
    }
     
     
     
     
     
     
     
     
}
