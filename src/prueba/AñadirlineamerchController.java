/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author DAW
 */
public class AñadirlineamerchController implements Initializable {
  private ObservableList <Merchandasing> merchaa = FXCollections.observableArrayList();
    TextInputDialog dialog = new TextInputDialog("Cantidad");
    @FXML
    private Label textoswitch;
    @FXML
    private TextField idclientefield;
    @FXML
    private TextField idempleadofield;
    @FXML
    private TextField idpedidofield;
    @FXML
    private Button buscarcarta;
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
    /**
     * Initializes the controller class.
     */

  public void initVariable(String idemp, String idcli, int idpedido){
     String swapp= Integer.toString(idpedido);
     idempleadofield.setText(idemp);
     idclientefield.setText(idcli);
     idpedidofield.setText(swapp);
     
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
    }

    @FXML
    private void buscarcartanombre(ActionEvent event) {
    }

    @FXML
    private void añadircartaatext(ActionEvent event) {
    }

    @FXML
    private void buscar(KeyEvent event) {
    }
    
}
