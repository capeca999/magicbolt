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
import java.time.ZoneId;
import java.util.Date;
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
import javafx.scene.control.PasswordField;
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
public class ModempeladoController implements Initializable {
    
    Alert alert = new Alert(AlertType.CONFIRMATION);
    Alert alerterror = new Alert (AlertType.ERROR);
    
    private ObservableList <Empleado> empleadoa = FXCollections.observableArrayList();
    @FXML
    private TableView<Empleado> empleadotable;
    @FXML
    private TableColumn<Empleado, Integer> TId;
    @FXML
    private TableColumn<Empleado, String> TAp;
    @FXML
    private TableColumn<Empleado, String> TNo;
    @FXML
    private TableColumn<Empleado, Date> FNa;
    @FXML
    private TableColumn<Empleado, Date> FCo;
    @FXML
    private TableColumn<Empleado, String> TEl;
    @FXML
    private TableColumn<Empleado, String> PAs;
    @FXML
    private TableColumn<Empleado, Boolean> ADm;
    @FXML
    private TextField Nombre;
    @FXML
    private TextField Apellidos;
    @FXML
    private TextField telefono;
    @FXML
    private PasswordField contrasenyap;
    @FXML
    private PasswordField contrasenyas;
    @FXML
    private DatePicker fcontrato;
    @FXML
    private DatePicker fnacimiento;
    @FXML
    private RadioButton noadmin;
    @FXML
    private ToggleGroup adminv;
    @FXML
    private RadioButton admin;
    @FXML
    private Button modificar;
    @FXML
    private Button eliminarempleado;
      
            
    /*   @FXML
    private empleadotable<Empleado, int> EmpleadoId;
    */
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       llenar();
final ObservableList<Empleado> tablaEmpleadoSel = empleadotable.getSelectionModel().getSelectedItems();
tablaEmpleadoSel.addListener(selectorempleadotable);
    }    
    
  private void llenarcolumnas(){
      
  }
    
    private void llenar (){
     Empleado.llenarEmpleados(empleadoa);
     empleadotable.setItems(empleadoa);
 TId.setCellValueFactory(new PropertyValueFactory<Empleado, Integer>("Idempleado"));
 TAp.setCellValueFactory(new PropertyValueFactory<Empleado, String>("Apellido"));
  TNo.setCellValueFactory(new PropertyValueFactory<Empleado, String>("Nombre"));
   FNa.setCellValueFactory(new PropertyValueFactory<Empleado, Date>("Fnacimiento"));
    FCo.setCellValueFactory(new PropertyValueFactory<Empleado, Date>("Fcontrato"));
     TEl.setCellValueFactory(new PropertyValueFactory<Empleado, String>("Telefono"));
      PAs.setCellValueFactory(new PropertyValueFactory<Empleado, String>("password"));
       ADm.setCellValueFactory(new PropertyValueFactory<Empleado, Boolean>("admin"));
    }
    
  private final ListChangeListener<Empleado>selectorempleadotable= new ListChangeListener<Empleado>(){
        @Override
          public void onChanged (ListChangeListener.Change<? extends Empleado> c){
             ponerEmpleadoSeleccionado();
          }    
          };
          
  public Empleado getTablaEmpleadoSeleccionado(){
      if (empleadotable!=null){
          List<Empleado> tabla = empleadotable.getSelectionModel().getSelectedItems();
          if (tabla.size()==1){
              final Empleado EmpleadoSeleccionado = tabla.get(0);
              return EmpleadoSeleccionado;
          }
      }
      return null;
     
  }  
  
  
  
  public void ponerEmpleadoSeleccionado(){
      final Empleado empleado = getTablaEmpleadoSeleccionado();
   Integer   posicionEmpleado = empleadoa.indexOf(empleado);
 
   if (empleado!=null){
       
       Nombre.setText(empleado.getNombre());
       System.out.println(Nombre);
       Apellidos.setText(empleado.getApellido());
       telefono.setText(empleado.getTelefono());
       contrasenyap.setText(empleado.getPassword());
     
       fcontrato.setValue(empleado.getFcontrato().toLocalDate());
       fnacimiento.setValue(empleado.getFnacimiento().toLocalDate());
       if (empleado.admin==true){
    
           admin.setSelected(true);
           
       }
       else noadmin.setSelected(true);
           //admin.isSelected();
     
       
       
       
       
       
       
   }
   
  }

    @FXML
    private void modificartable(ActionEvent event) {
        
        /* Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        ResultSet rs;
        PreparedStatement stmt=null;
        Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        ResultSet rs;
        PreparedStatement stmt=null;
        try{
        stmt= con.prepareStatement("SELECT * from Empleado");
        stmt.executeQuery();
        rs= stmt.executeQuery();
        
        while (rs.next()){
        lista.add(new Empleado(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getBoolean(8)));
        }
        }
        catch(SQLException exx){
        exx.getMessage();*/
        
        Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        ResultSet rs;
        int   adminonov=0;
        String adminboolean="";
        PreparedStatement stmt=null;
        try{
            stmt= con.prepareStatement("UPDATE Empleado SET  Apellido= ?, Nombre= ?, Fnacimiento= ?, Fcontrato= ?, Telefono= ?, password= ?, admin= ? WHERE Idempleado = ?; ");
            stmt.setString(1, Apellidos.getText());
            stmt.setString(2, Nombre.getText());
            
            stmt.setString(3, fnacimiento.getValue().toString());
            stmt.setString(4, fcontrato.getValue().toString());
            stmt.setString(5, telefono.getText());
            stmt.setString(6, contrasenyap.getText());
            if (admin.isSelected()){
             adminonov=1; adminboolean=Integer.toString(adminonov);
            stmt.setString(7, adminboolean);
              
            }
           
            else adminonov=0;  adminboolean=Integer.toString(adminonov);
                stmt.setString(7, adminboolean);
             final Empleado empleado = getTablaEmpleadoSeleccionado();
   Integer   posicionEmpleado = empleadoa.indexOf(empleado);
    stmt.setInt(8, empleado.getIdempleado());
            stmt.executeUpdate();
     empleadotable.getItems().clear();
            llenar();
             alert.setTitle("EXITO");
          alert.setHeaderText("MODIFICACIÓN REALIZADA");
          alert.setContentText("LA MODIFICACION DEL EMPLEADO CON ID " + empleado.Idempleado + " Y Nombre " + empleado.Nombre + " HA SIDO UN EXITO");
         alert.showAndWait();
         }
         catch(SQLException exx){
         alerterror.setTitle(exx.getMessage());
      alerterror.setHeaderText("ERROR");
      alerterror.setContentText("ERROR EN LA MODIFICACIÓN DE UN EMPLEADO");
      alerterror.showAndWait();
     }
          /*       private TextField Apellidos;
       @FXML
       private TextField telefono;
       @FXML
       private PasswordField contrasenyap;
       @FXML
       private PasswordField contrasenyas;
       @FXML
       private DatePicker fcontrato;
       @FXML
       private DatePicker fnacimiento;
       @FXML
       private RadioButton noadmin;
       @FXML
       private ToggleGroup adminv;
       @FXML
       private RadioButton admin;
       */
       
       
        
    }

    @FXML
    private void eliminarempleado(ActionEvent event) {
           Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
          PreparedStatement stmt=null;
           final Empleado empleado = getTablaEmpleadoSeleccionado();
   Integer   posicionEmpleado = empleadoa.indexOf(empleado);
          try{
              stmt= con.prepareStatement("DELETE FROM empleado where Idempleado = ?");
              stmt.setInt(1, empleado.Idempleado);
              stmt.executeUpdate();
              
               empleadotable.getItems().clear();
            llenar();
          alert.setTitle("EXITO");
          alert.setHeaderText("ELIMINACIÓN REALIZADA");
          alert.setContentText("LA ELIMINACIÓN DEL EMPLEADO CON ID " + empleado.Idempleado + " Y Nombre " + empleado.Nombre + " HA SIDO UN EXITO ");
         alert.showAndWait();
          }
          
           catch(SQLException exx){
      alerterror.setTitle(exx.getMessage());
      alerterror.setHeaderText("ERROR");
      alerterror.setContentText("ERROR EN LA ELIMINACIÓN DE UN EMPLEADO");
      alerterror.showAndWait();
     }
          
          /*
          try{
          stmt= con.prepareStatement("UPDATE Empleado SET  Apellido= ?, Nombre= ?, Fnacimiento= ?, Fcontrato= ?, Telefono= ?, password= ?, admin= ? WHERE Idempleado = ?; ");
          stmt.setString(1, Apellidos.getText());
          stmt.setString(2, Nombre.getText());
          
          stmt.setString(3, fnacimiento.getValue().toString());
          stmt.setString(4, fcontrato.getValue().toString());
          stmt.setString(5, telefono.getText());
          stmt.setString(6, contrasenyap.getText());
          if (admin.isSelected()){
          adminonov=1; adminboolean=Integer.toString(adminonov);
          stmt.setString(7, adminboolean);
          
          }
          
          else adminonov=0;  adminboolean=Integer.toString(adminonov);
          stmt.setString(7, adminboolean);
          final Empleado empleado = getTablaEmpleadoSeleccionado();
          Integer   posicionEmpleado = empleadoa.indexOf(empleado);
          stmt.setInt(8, empleado.getIdempleado());
          stmt.executeUpdate();
          
          */
          
          
          
          
          
          
          
          
          
          
          
          
    }
  
  
  
    }

