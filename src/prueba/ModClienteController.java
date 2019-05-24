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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author DAW
 */
public class ModClienteController implements Initializable {
Alert alert = new Alert(AlertType.CONFIRMATION);
Alert alerterror = new Alert (AlertType.ERROR);
private ObservableList <Clientes> clientea = FXCollections.observableArrayList();


    @FXML
    private TextField Nombre;
    @FXML
    private TextField Apellidos;
    @FXML
    private TextField telefono;
    private DatePicker fcontrato;
    @FXML
    private Label fechainsrow;
    @FXML
    private DatePicker fins;
    @FXML
    private TextField DNI;
    @FXML
    private RadioButton nojuez;
    @FXML
    private ToggleGroup juezv;
    @FXML
    private RadioButton juez;
    @FXML
    private TableColumn<Clientes, String> nombrerow;
    @FXML
    private TableColumn<Clientes, String> apellidosrow;
    @FXML
    private TableColumn<Clientes, String> telefonorow;
    @FXML
    private TableColumn<Clientes, Date> fecharow;
        @FXML
    private TableColumn<Clientes, Date> fechainscrow;
    @FXML
    private TableColumn<Clientes, String> dnirow;
    @FXML
    private TableColumn<Clientes, Boolean> juezrow;
    @FXML
    private Button eliminarcliente;
    @FXML
    private Button modificar;
    @FXML
    private TableView<Clientes> clientetabla;
    @FXML
    private DatePicker fnacimiento;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
       llenar();
         final ObservableList<Clientes> tablaClienteSel = clientetabla.getSelectionModel().getSelectedItems();
        tablaClienteSel.addListener(selectorclientetable);
        
    }    
    
    /*    private final ListChangeListener<Clientes>selectorclientetable = new ListChangeListener<Clientes>(){
    @Override
    public void onChanged (ListChangeListener.Change<? extends Cliente> c){
    
    }
    }
    */
    

    @FXML
    private void eliminarcliente(ActionEvent event) {
        
              Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
          PreparedStatement stmt=null;
             PreparedStatement stmt2=null;
          final Clientes cliente = getTablaClientesSeleccionado();
          Integer posicionCliente = clientea.indexOf(cliente);
          try{
           //   stmt2= con.prepareStatement("DELETE FROM lineaspedido where Id")
              stmt= con.prepareStatement("DELETE FROM cliente where Idpersona= ?");
              stmt.setInt(1, cliente.getIdpersona());
              System.out.println(cliente.getIdpersona());
              stmt.executeUpdate();
              clientetabla.getItems().clear();
              llenar();
               alert.setTitle("EXITO");
          alert.setHeaderText("ELIMINACIÓN REALIZADA");
          alert.setContentText("LA ELIMINACIÓN DEL CLIENTE CON ID " + cliente.getIdpersona() + " Y Nombre " + cliente.getNombre() + " HA SIDO UN EXITO ");
         alert.showAndWait();
              
          }
            catch(SQLException exx){
      alerterror.setTitle(exx.getMessage());
      alerterror.setHeaderText("ERROR");
      alerterror.setContentText("ERROR EN LA ELIMINACIÓN DE UN CLIENTE");
      alerterror.showAndWait();
     }
        
    }

    @FXML
    private void modificartable(ActionEvent event) {
         Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        ResultSet rs;
        int juezonov=0;
        String juezboolean="";
        PreparedStatement stmt=null;

// Nombre 	DNI 	Telefono 	Fecha_nacimiento 	Apellido 	Juez 	Idpersona         
        try{
       stmt= con.prepareStatement("UPDATE cliente SET Nombre= ?, DNI= ?, Telefono= ?, Fecha_nacimiento= ?, Fecha_inscripcion= ?, Apellido= ?, Juez= ? WHERE Idpersona= ?;");
       stmt.setString(1, Nombre.getText());
       stmt.setString(2, DNI.getText());
       stmt.setString(3, telefono.getText());
       stmt.setString(4, fnacimiento.getValue().toString());
       stmt.setString(5, fins.getValue().toString());
       stmt.setString(6, Apellidos.getText());
       if (juez.isSelected()){
           juezonov=1; juezboolean=Integer.toString(juezonov);
           stmt.setString(7, juezboolean);
       }
       
       else juezonov=0; juezboolean=Integer.toString(juezonov);
        stmt.setString(7, juezboolean);
        
        final Clientes cliente = getTablaClientesSeleccionado();
        Integer posicionCliente = clientea.indexOf(cliente);
        
        stmt.setInt(8, cliente.getIdpersona());
        
        stmt.executeUpdate();
       clientetabla.getItems().clear();
       llenar();
            alert.setTitle("EXITO");
          alert.setHeaderText("MODIFICACIÓN REALIZADA");
          alert.setContentText("LA MODIFICACION DEL CLIENTE CON ID " + cliente.getIdpersona() + " Y Nombre " + cliente.getNombre() + " HA SIDO UN EXITO");
         alert.showAndWait();
       
       
       // stmt= con.prepareStatement("UPDATE Empleado SET  Apellido= ?, Nombre= ?, Fnacimiento= ?, Fcontrato= ?, Telefono= ?, password= ?, admin= ? WHERE Idempleado = ?; ");
//Nombre 	DNI 	Telefono 	Fecha_nacimiento 	Fecha_inscripcion 	Apellido 	Juez 	Idpersona 
         /*
@FXML
private TextField Nombre;
@FXML
private TextField Apellidos;
@FXML
private TextField telefono;
@FXML
private DatePicker fcontrato;
@FXML
private Label fechainsrow;
@FXML
private DatePicker fins;
@FXML
private TextField DNI;
@FXML
private RadioButton nojuez;
@FXML
private ToggleGroup juezv;
@FXML
private RadioButton juez;*/   
            
            
            
        }
         catch(SQLException exx){
         alerterror.setTitle(exx.getMessage());
      alerterror.setHeaderText("ERROR");
      alerterror.setContentText("ERROR EN LA MODIFICACIÓN DE UN CLIENTE");
      alerterror.showAndWait();
     }
    }
    
    
    private void llenar(){
        Clientes.llenarClientes(clientea);
        clientetabla.setItems(clientea);
     
        nombrerow.setCellValueFactory(new PropertyValueFactory<Clientes, String>("Nombre"));
        apellidosrow.setCellValueFactory(new PropertyValueFactory<Clientes, String>("Apellido"));
        telefonorow.setCellValueFactory(new PropertyValueFactory<Clientes, String>("Telefono"));
        fecharow.setCellValueFactory(new PropertyValueFactory<Clientes, Date>("Fecha_nacimiento"));
        fechainscrow.setCellValueFactory(new PropertyValueFactory<Clientes, Date>("Fecha_inscripcion"));
        dnirow.setCellValueFactory(new PropertyValueFactory<Clientes, String>("DNI"));
        juezrow.setCellValueFactory(new PropertyValueFactory<Clientes, Boolean>("Juez"));
    }
    
    
    private final ListChangeListener<Clientes>selectorclientetable= new ListChangeListener<Clientes>(){
        @Override
        public void onChanged (ListChangeListener.Change<? extends Clientes> c){
            ponerClienteSeleccionado();
        }
    };
    
    
    public Clientes getTablaClientesSeleccionado(){
        if (clientetabla!=null){
            List<Clientes> tabla = clientetabla.getSelectionModel().getSelectedItems();
            if (tabla.size()==1){
                final Clientes ClienteSeleccionado = tabla.get(0);
                return ClienteSeleccionado;
            }
        }
        return null;
    }
    
    
    public void ponerClienteSeleccionado(){
        final Clientes cliente = getTablaClientesSeleccionado();
        Integer posicionCliente = clientea.indexOf(cliente);
        
        
        
        if (cliente!=null){
           
            Nombre.setText(cliente.getNombre());
            Apellidos.setText(cliente.getApellido());
            telefono.setText(cliente.getTelefono());
            fnacimiento.setValue(cliente.getFecha_nacimiento().toLocalDate());
            fins.setValue(cliente.getFecha_inscripcion().toLocalDate());
            DNI.setText(cliente.getDNI());
            
            if (cliente.isJuez()==true){
                juez.setSelected(true);
            }
            else nojuez.setSelected(true);
            
        }
        
        
    }
    
    
 
    
    
    
}

/*
@FXML
private TextField Nombre;
@FXML
private TextField Apellidos;
@FXML
private TextField telefono;
@FXML
private DatePicker fcontrato;
@FXML
private Label fechainsrow;
@FXML
private DatePicker fins;
@FXML
private TextField DNI;
@FXML
private RadioButton nojuez;
@FXML
private ToggleGroup juezv;
@FXML
private RadioButton juez;*/