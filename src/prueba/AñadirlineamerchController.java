/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import DAO.Conexion;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author DAW
 */
public class AñadirlineamerchController implements Initializable {
  private ObservableList <Merchandasing> merchaa = FXCollections.observableArrayList();
    TextInputDialog dialog = new TextInputDialog("Cantidad");
     Alert alertaerror = new Alert (Alert.AlertType.ERROR);
    @FXML
    private Label textoswitch;
    @FXML
    private TextField idclientefield;
    @FXML
    private TextField idempleadofield;
    @FXML
    private TextField idpedidofield;
    @FXML
    private Button añadirmerch;
    @FXML
    private TextArea textcomun;
    @FXML
    private TableView<Merchandasing> tablamerch;
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
    private Label texto2switch;
    @FXML
    private TextField nombremerch;
String area="";
String merchbuscar="";
    @FXML
    private Button buscarmerch;
    /**
     * Initializes the controller class.
     */

  public void initVariable(String idemp, String idcli, int idpedido, String area){
     String swapp= Integer.toString(idpedido);
     idempleadofield.setText(idemp);
     idclientefield.setText(idcli);
     idpedidofield.setText(swapp);
     textcomun.setText(area);
     
     
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
          final ObservableList<Merchandasing> tablaCartaSel = tablamerch.getSelectionModel().getSelectedItems();
        tablaCartaSel.addListener(selectormerchtable); 
        
        
    }

 private final ListChangeListener<Merchandasing>selectormerchtable= new ListChangeListener<Merchandasing>(){
        @Override
          public void onChanged (ListChangeListener.Change<? extends Merchandasing> c){
         
          }    
          };
    

    @FXML
    private void crearpedido(ActionEvent event) {
        FileChooser filechooser = new FileChooser();
        
            File file = filechooser.showSaveDialog(((Node)event.getSource()).getScene().getWindow());
            if (file!=null){
                FileWriter fw = null;
                BufferedWriter bw =null;
                
                try{
                fw = new FileWriter (file, false);
                bw = new BufferedWriter(fw);
                bw.write(area, 0,  area.length());
            }
                catch(IOException ex){
                    ex.getMessage();
                }
                
                finally{
                    try{
                        bw.close();
                    } catch(Exception e2){
                        
                    }
                }
                
            }
    }


    @FXML
    private void añadircartaatext(ActionEvent event) {
    boolean fin = false;
    final Merchandasing merch = getTablaMerchandasingSeleccionado();
    Integer posicionCarta = merchaa.indexOf(merch);
    ResultSet rs2;
    
    String resultadodialogo="";
    area+=textcomun.getText();
    if (merch!=null){
      dialog.setTitle("CANTIDAD");
            dialog.setHeaderText("INTRODUCE LA CANTIDAD");
            dialog.setContentText("CANTIDAD:");
            Optional<String> result = dialog.showAndWait();
  
            if (result.isPresent()){
                if (Double.parseDouble(result.get())>merch.getExistencias()){
                    alertaerror.setTitle("CANTIDAD ERROR");
                    alertaerror.setTitle("CANTIDAD INTRODUCIDA");
                    alertaerror.setContentText("La cantidad introducida es mas grande que las existencias");
                    alertaerror.showAndWait();
                    
                }
            
            else{
                resultadodialogo=result.get();
                area+="ID MERCH: ";
                area+=merch.getIdmerch();
                area+=" ";
                area+="\n";
                area+="NOMBRE MERCH: ";
                area+=merch.getNombre();
                area+=" ";
                area+="\n";
                area+="ID MERCH: ";
                area+=merch.getIdmerch();
                area+=" ";
                area+="\n";
                area+="DESCRIPCIÓN: ";
                area+=merch.getDescripcion();
                area+="\n";
                area+="PRECIO: " + Double.parseDouble(resultadodialogo)*merch.getPrecio();
                area+="\n";
                    area+="-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-";
                    textcomun.setText(area);
                
            
            
            try{
                 Conexion conexion = new Conexion();
               Connection con = conexion.conectar(); 
               
               PreparedStatement stmt2 = con.prepareStatement("INSERT INTO lineaspedidomerch ( Pedido, Merch, Precio, Cantidad) VALUES (?,?,?,?)");
           //    	Idlineasmerch 	Pedido 	Merch 	Precio 	Cantidad
           stmt2.setInt(1, Integer.parseInt(idpedidofield.getText()));
           stmt2.setInt(2, merch.getIdmerch());
           stmt2.setDouble(3, Double.parseDouble(resultadodialogo)*merch.getPrecio());
           stmt2.setDouble(4, merch.getExistencias());
           stmt2.executeUpdate();
        
         
           

          
           
            }
            
             catch(SQLException exx){
                exx.getMessage();
            }
                }
            
        
          
    }
            else{
                alertaerror.setTitle("DIALOGO ERROR");
                alertaerror.setHeaderText("NADA INTRODUCIDO");
                alertaerror.setContentText("La cantidad no ha sido introducida, cancela o introduce una");
                alertaerror.showAndWait();
                
            }
    }
    }
    /*  private TableColumn<Merchandasing, Integer> Idmerchrow;
    @FXML
    private TableColumn<Merchandasing, Double> preciorow;
    @FXML
    private TableColumn<Merchandasing, Double> existenciasrow;
    @FXML
    private TableColumn<Merchandasing, String> nombrerow;
    @FXML
    private TableColumn<Merchandasing, String> descripcionrow;
    @FXML*/
    
    
    
    
    @FXML
    private void buscar(KeyEvent event) {
        tablamerch.getItems().clear();
        Merchandasing.llenarMerch(merchaa, nombremerch.getText());
        tablamerch.setItems(merchaa);
           Idmerchrow.setCellValueFactory(new PropertyValueFactory<Merchandasing, Integer> ("Idmerch"));
           preciorow.setCellValueFactory(new PropertyValueFactory<Merchandasing, Double> ("Precio"));
            existenciasrow.setCellValueFactory(new PropertyValueFactory<Merchandasing, Double> ("Existencias"));
          nombrerow.setCellValueFactory(new PropertyValueFactory<Merchandasing, String> ("Nombre"));

       
          
                descripcionrow.setCellValueFactory(new PropertyValueFactory<Merchandasing, String> ("Descripcion"));
        
        
    }
    
    public Merchandasing getTablaMerchandasingSeleccionado(){
        if (tablamerch!=null){
            List<Merchandasing> tabla = tablamerch.getSelectionModel().getSelectedItems();
            if (tabla.size()==1){
                final Merchandasing  MerchSeleccionado = tabla.get(0);
                return MerchSeleccionado;
                
            }
        }
        return null;
    }

    @FXML
    private void buscarmerchnombre(ActionEvent event) {
        Merchandasing.llenarMerch(merchaa, nombremerch.getText());
        tablamerch.setItems(merchaa);
                     Idmerchrow.setCellValueFactory(new PropertyValueFactory<Merchandasing, Integer> ("Idmerch"));
           preciorow.setCellValueFactory(new PropertyValueFactory<Merchandasing, Double> ("Preciorow"));
                 existenciasrow.setCellValueFactory(new PropertyValueFactory<Merchandasing, Double> ("Existencias"));

          nombrerow.setCellValueFactory(new PropertyValueFactory<Merchandasing, String> ("nombrerow"));

       
          
                descripcionrow.setCellValueFactory(new PropertyValueFactory<Merchandasing, String> ("Preciorow"));
        
           //     nombrecartarow.setCellValueFactory(new PropertyValueFactory<Carta, String> ("Nombre"));

           /*        private TableColumn<Merchandasing, Integer> Idmerchrow;
           @FXML
           private TableColumn<Merchandasing, Double> preciorow;
           @FXML
           private TableColumn<Merchandasing, Double> existenciasrow;
           @FXML
           private TableColumn<Merchandasing, String> nombrerow;
           @FXML
           private TableColumn<Merchandasing, String> descripcionrow;*/
        
    }
    
}
