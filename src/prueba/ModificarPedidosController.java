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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author paco
 */
public class ModificarPedidosController implements Initializable {
 Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    Alert alerterror = new Alert (Alert.AlertType.ERROR);
   private ObservableList <Pedidos> pedidoa = FXCollections.observableArrayList();  
    
    @FXML
    private TableView<Pedidos> tablapedido;
    @FXML
    private TableColumn<Pedidos, Integer> Idpedidorow;
    @FXML
    private TableColumn<Pedidos, Integer> Idclienterow;
    @FXML
    private TableColumn<Pedidos, Integer> empleadorow;
    @FXML
    private TableColumn<Pedidos, Date> Fecharow;
    @FXML
    private TextField Idcliente;
    @FXML
    private TextField Idempleado;
    @FXML
    private DatePicker fechapedido;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         llenar();
        
final ObservableList<Pedidos> tablaPedidoSel = tablapedido.getSelectionModel().getSelectedItems();
tablaPedidoSel.addListener(selectorpedidotable);        
        
        
    }

private void llenar(){
    Pedidos.llenarPedidos(pedidoa);
    tablapedido.setItems(pedidoa);
    Idpedidorow.setCellValueFactory(new PropertyValueFactory<Pedidos, Integer>("Idpedido"));
        Idclienterow.setCellValueFactory(new PropertyValueFactory<Pedidos, Integer>("Idcliente"));
    empleadorow.setCellValueFactory(new PropertyValueFactory<Pedidos, Integer>("Empleado"));
        Fecharow.setCellValueFactory(new PropertyValueFactory<Pedidos, Date>("Fecha"));


    
    
}
 private final ListChangeListener<Pedidos>selectorpedidotable= new ListChangeListener<Pedidos>(){
        @Override
          public void onChanged (ListChangeListener.Change<? extends Pedidos> c){
             ponerPedidoSeleccionado();
          }    
          };
    public Pedidos getPedidoSeleccionado(){
      if (tablapedido!=null){
          List<Pedidos> tabla = tablapedido.getSelectionModel().getSelectedItems();
          if (tabla.size()==1){
              final Pedidos PedidoSeleccionado = tabla.get(0);
              return PedidoSeleccionado;
          }
      }
      return null;
     
  
    
    
    
    }  
    
    
    
    public void ponerPedidoSeleccionado(){
      final Pedidos pedidoss = getPedidoSeleccionado();
   Integer   posicionPedidoss = pedidoa.indexOf(pedidoss);
 
   if (pedidoss!=null){
       
       Idcliente.setText(pedidoss.getCliente());
       Idempleado.setText(pedidoss.getEmpleado());
       fechapedido.setValue(pedidoss.getFecha().toLocalDate());
       
       
       
     
     
       
       
       
       
       
       
   }
   
  }
    
    
    
    
    
    

    @FXML
    private void modlineas(ActionEvent event) {
           final Pedidos pedidoss = getPedidoSeleccionado();
   Integer   posicionPedidoss = pedidoa.indexOf(pedidoss);
      try{
           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ModLineasPedido.fxml"));
            Parent root1 = (Parent)fxmlLoader.load();
            Stage stage = new Stage();
            ModLineasPedidoController controller = fxmlLoader.<ModLineasPedidoController>getController();
            controller.initVariable(pedidoss.getIdpedido());
          stage.setScene(new Scene(root1));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
      } 
       catch (IOException ex){
                Logger.getLogger(ModLineasPedidoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    }

    @FXML
    private void eliminarpedido(ActionEvent event) {
         Conexion conexion = new Conexion();
            Connection con = conexion.conectar(); 
         PreparedStatement stmt=null;
             PreparedStatement stmt2=null;
             
              final Pedidos pedidoss = getPedidoSeleccionado();
   Integer   posicionPedidoss = pedidoa.indexOf(pedidoss);
   
   try{
       
       stmt = con.prepareStatement("DELETE FROM lieneaspedido where Pedido = ?");
       stmt.setInt(1, pedidoss.getIdpedido());
       stmt= con.prepareStatement("DELETE FROM pedidos where IdPedido = ?");
       stmt.setInt(1, pedidoss.getIdpedido());
       stmt.executeUpdate();
       
       alert.setTitle("PEDIDO ELIMINADO CORRECTAMENTE");
       alert.setHeaderText("PEDIDO ELIMINADO");
       alert.setContentText("ELIIMINACION REALIZADA CORRECTAMENTE");
       alert.showAndWait();
       
     
  //     stmt2.setInt(1, pedidoss);

//UPDATE `members` SET `contact_number` = '0759 253 542' WHERE `membership_number` = 1;


       tablapedido.getItems().clear();
       llenar();
       
       
   }
    catch(SQLException exx){
      alerterror.setTitle(exx.getMessage());
      alerterror.setHeaderText("ERROR");
      alerterror.setContentText("ERROR EN LA ELIMINACIÓN DE UN PEDIDO");
      alerterror.showAndWait();
     }
        
        
    }
    
}
