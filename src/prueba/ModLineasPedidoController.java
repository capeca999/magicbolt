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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author paco
 */
public class ModLineasPedidoController implements Initializable {
Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    Alert alerterror = new Alert (Alert.AlertType.ERROR);
      private ObservableList <lineaspedido> lineaa = FXCollections.observableArrayList();
    @FXML
    private TableView<lineaspedido> tablalinea;
    @FXML
    private TableColumn<lineaspedido, Integer> Idlinearow;
    @FXML
    private TableColumn<lineaspedido, Integer> Pedidorow;
    @FXML
    private TableColumn<lineaspedido, Integer> Cartarow;
    @FXML
    private TableColumn<lineaspedido, Double> Preciorow;
    @FXML
    private TableColumn<lineaspedido, Integer> Cantidadrow;
    @FXML
    private TextField Idlinea;
    @FXML
    private TextField Idpedido;
    @FXML
    private TextField Cartalinea;
    @FXML
    private TextField Preciolinea;
    @FXML
    private TextField Cantidadlinea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     
          
                 final ObservableList<lineaspedido> tablaLineasSel = tablalinea.getSelectionModel().getSelectedItems();
tablaLineasSel.addListener(selectorlienaspedido);

    }    
    
    public void initVariable(int iddelpedido){

        Idpedido.setText(Integer.toString(iddelpedido)); 
             llenar();
    
        
    }
    
    private void llenar(){
        System.out.println(Idpedido.getText());
        lineaspedido.llenarlineas(lineaa, Idpedido.getText());
        tablalinea.setItems(lineaa);
        Idlinearow.setCellValueFactory(new PropertyValueFactory<lineaspedido, Integer> ("Idlinea"));
         Pedidorow.setCellValueFactory(new PropertyValueFactory<lineaspedido, Integer> ("Pedido"));
          Cartarow.setCellValueFactory(new PropertyValueFactory<lineaspedido, Integer> ("Carta"));
           Preciorow.setCellValueFactory(new PropertyValueFactory<lineaspedido, Double> ("Precio"));
            Cantidadrow.setCellValueFactory(new PropertyValueFactory<lineaspedido, Integer> ("Cantidad"));
        
        
    }
    
     private final ListChangeListener<lineaspedido>selectorlienaspedido= new ListChangeListener<lineaspedido>(){
        @Override
          public void onChanged (ListChangeListener.Change<? extends lineaspedido> c){
             ponerLineasSeleccionado();
          }    
          };
     
     
       public lineaspedido getTablaLineasSeleccionado(){
      if (tablalinea!=null){
          List<lineaspedido> tabla = tablalinea.getSelectionModel().getSelectedItems();
          if (tabla.size()==1){
              final lineaspedido LineasSeleccionado = tabla.get(0);
              return LineasSeleccionado;
          }
      }
      return null;
     
  }  
       /*    private TextField Idlinea;
       @FXML
       private TextField Idpedido;
       @FXML
       private TextField Cartalinea;
       @FXML
       private TextField Preciolinea;
       @FXML
       private TextField Cantidadlinea;*/
       
        public void ponerLineasSeleccionado(){
      final lineaspedido lineaspedidoo = getTablaLineasSeleccionado();
   Integer   posicionLineas = lineaa.indexOf(lineaspedidoo);
 
           ResultSet rs;
   
   
   if (lineaspedidoo!=null){
       
        Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
         PreparedStatement stmt=null;
  
        try{
            stmt=con.prepareStatement("SELECT Nombre from carta where Idcarta = ?");
            stmt.setInt(1, lineaspedidoo.getIdcarta());
            stmt.executeQuery();
            rs = stmt.executeQuery();
            rs.next();
        
        
    //   Double.toString(double)
       Idlinea.setText(Integer.toString(lineaspedidoo.getIdlinea()));
       Cartalinea.setText(rs.getString(1));
       Preciolinea.setText(Double.toString(lineaspedidoo.getPrecio()));
       Cantidadlinea.setText(Integer.toString(lineaspedidoo.getCantidad()));
       
  
     
       
       
        }
        catch(SQLException exx){
         exx.getMessage();
            System.out.println(exx.getMessage());
     }
       
       
   }
   
  }
  
    

    @FXML
    private void eliminarlinea(ActionEvent event) {
       Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
          PreparedStatement stmt=null;
          final lineaspedido lineaspedidoo = getTablaLineasSeleccionado();
          Integer posicionLinea = lineaa.indexOf(lineaspedidoo);
          
          try{
              stmt = con.prepareStatement("UPDATE carta SET Existencias= ? where Idcarta = ?");
              stmt.setInt(1, Integer.parseInt(Cantidadlinea.getText()));
              stmt.setInt(2, lineaspedidoo.getIdcarta());
              stmt.executeUpdate();
              
              stmt = con.prepareStatement("DELETE FROM lineaspedido where Idlinea = ?");
              stmt.setInt(1, lineaspedidoo.getIdlinea());
              stmt.executeUpdate();
              
               alert.setTitle("LINEAPEDIDO ELIMINADO CORRECTAMENTE");
       alert.setHeaderText("LINEAPEDIDO ELIMINADO");
       alert.setContentText("ELIMINACION REALIZADA CORRECTAMENTE");
       alert.showAndWait();
              tablalinea.getItems().clear();
              llenar();
              
              
          }
             catch(SQLException exx){
      alerterror.setTitle(exx.getMessage());
      alerterror.setHeaderText("ERROR");
      alerterror.setContentText("ERROR EN LA ELIMINACIÓN DE UNA LINEA");
      alerterror.showAndWait();
     }
        
        
        
    }


    
}
