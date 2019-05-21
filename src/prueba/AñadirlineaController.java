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
import java.sql.SQLException;
import java.util.ArrayList;
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
import javafx.scene.control.Alert.AlertType;
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
public class AñadirlineaController implements Initializable {

    private ObservableList <Carta> cartaa = FXCollections.observableArrayList();
    TextInputDialog dialog = new TextInputDialog("Cantidad");
  
    @FXML
    private TextField nombrecarta;
    @FXML
    private TableColumn<Carta, String> nombrecartarow;
    @FXML
    private TableColumn<Carta, String> edicionrow;
    @FXML
    private TableColumn<Carta, Boolean> foilrow;
    @FXML
    private TextArea textcomun;
    @FXML
    private Button añadircarta;
    @FXML
    private TableView<Carta> tablacarta;
String area="";
String cartabuscar="";
    @FXML
    private Button buscarcarta;
    @FXML
    private TableColumn<Carta, Integer> existenciasrow;
    @FXML
    private TableColumn<Carta, Integer> idedicionrow;
    @FXML
    private TextField idclientefield;
    @FXML
    private TextField idempleadofield;
    @FXML
    private TextField idpedidofield;
    @FXML
    private TableColumn<Carta, Double> preciorow;
    ArrayList<Integer> list = new ArrayList<Integer>();
    
 Alert alertaerror = new Alert (Alert.AlertType.ERROR);
    @FXML
    private Label textoswitch;
    @FXML
    private Label texto2switch;
    int cont=0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
           final ObservableList<Carta> tablaCartaSel = tablacarta.getSelectionModel().getSelectedItems();
        tablaCartaSel.addListener(selectorcartatable);
        
    
    }    

  
    
    
  public void initVariable(String idemp, String idcli, int idpedido){
     String swapp= Integer.toString(idpedido);
     idempleadofield.setText(idemp);
     idclientefield.setText(idcli);
     idpedidofield.setText(swapp);
     
    }
  
      private final ListChangeListener<Carta>selectorcartatable= new ListChangeListener<Carta>(){
        @Override
          public void onChanged (ListChangeListener.Change<? extends Carta> c){
         
          }    
          };
    @FXML
    private void añadircartaatext(ActionEvent event) {
        boolean fin=false;
        final Carta carta = getTablaCartaSeleccionado();
        Integer posicionCarta = cartaa.indexOf(carta);
        String resultadodialogo="";
        if (carta!=null){
            dialog.setTitle("CANTIDAD");
            dialog.setHeaderText("INTRODUCE LA CANTIDAD");
            dialog.setContentText("CANTIDAD:");
            Optional<String> result = dialog.showAndWait();
   
                
            
            if (result.isPresent()){
                if (Integer.parseInt(result.get())>carta.getExistencias()){
                    alertaerror.setTitle("CANTIDAD ERROR");
                    alertaerror.setHeaderText("CANTIDAD INTRODUCIDA");
                    alertaerror.setContentText("La cantidad introducida es mas grande que las existencias");
                    alertaerror.showAndWait();
                }
             
                else{
                    if (list.contains(carta.getIdcarta())){
                        
                    }
                
                
                 resultadodialogo=result.get();
                  area+="ID CARTA: ";
            area+=carta.getIdcarta();
            area+=" ";
            area+="\n";
            
            area+="NOMBRE CARTA: ";
            area+=carta.getNombre();
            area+=" ";
                  area+="\n"; 
                  area+="ID EDICION";
            area+=carta.getIdedicion();
            area+=" ";
            area+="\n";
            area+="NOMBRE EDICION: ";
            area+=carta.getEdicion();
            area+="\n";
            area+="PRECIO: " + Double.parseDouble(resultadodialogo)*carta.getPrecio();
            
            //Double.parseDouble()
           list.add(carta.getIdedicion());
            
          //  area+= carta.getPrecio()*Double.parseDouble();
            area+="\n";
            area+="-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-";
            textcomun.setText(area);
            
            try{
               Conexion conexion = new Conexion();
               Connection con = conexion.conectar();
              // Idlinea 	Pedido 	Carta 	Precio 	Cantidad 
               PreparedStatement stmt2 = con.prepareStatement("INSERT INTO lineaspedido (Pedido, Carta, Precio, Cantidad) VALUES(?,?,?,?)");
               stmt2.setInt(1, Integer.parseInt(idpedidofield.getText()));
               stmt2.setInt(2, carta.getIdcarta());
               stmt2.setDouble(3, Double.parseDouble(resultadodialogo)*carta.getPrecio());
               stmt2.setInt(4, carta.getExistencias());
               stmt2.executeUpdate();
               
              // stmt2.
               
            }
            
            catch(SQLException exx){
                exx.getMessage();
            }
            
            /*
            try{
            PreparedStatement
            Conexion conexion = new Conexion();
            Connection con = conexion.conectar();
            boolean error=false;
            if (!contrasenyap.getText().equals(contrasenyas.getText())){
            
            alert.setTitle("CONTRASENYA ERROR");
            alert.setHeaderText("CONTRASENYA ERROR");
            alert.setContentText("La contrasenya no son las mismas, introducela de nuevo");
            alert.showAndWait();
            contrasenyap.clear();
            contrasenyas.clear();
            
            }
            else{
            try{
            PreparedStatement stmt2 = con.prepareStatement("INSERT INTO empleado (Apellido, Nombre, Fnacimiento, Fcontrato, Telefono, password, admin) VALUES(?,?,?,?,?,?,?)");
            if (Apellidos.getText().isEmpty()){
            
            errortext+="EL CAMPO APELLIDOS NO SE ENCUENTRA RELLENADO" + "\n"  + "\n";
            error=true;
            // alert.showAndWait();
            }
            if(Nombre.getText().isEmpty()){
            errortext+="EL CAMPO NOMBRE NO SE ENCUENTRA RELLENADO" + "\n"  + "\n";
            error=true;
            }
            
            if (fnacimiento.getValue() == null){
            errortext+="EL CAMPO FECHA DE NACIMIENTO NO SE ENCUENTRA RELLENADO" + "\n"  + "\n";
            error=true;
            }
            
            if (fcontrato.getValue() == null){
            errortext+="EL CAMPO DE FECHA DE CONTRATO NO SE ENCUENTRA RELLENADO" + "\n"  + "\n";
            error=true;
            }
            
            if (contrasenyap.getText().isEmpty()){
            errortext+="EL CAMPO DE CONTRASEÑA NO SE ENCUENTRA RELLENADO" + "\n"  + "\n";
            error=true;
            }
            
            
            }*/
            
            /*
            else{
            try{
            PreparedStatement stmt2 = con.prepareStatement("INSERT INTO empleado (Apellido, Nombre, Fnacimiento, Fcontrato, Telefono, password, admin) VALUES(?,?,?,?,?,?,?)");
            if (Apellidos.getText().isEmpty()){
            
            errortext+="EL CAMPO APELLIDOS NO SE ENCUENTRA RELLENADO" + "\n"  + "\n";
            error=true;
            // alert.showAndWait();
            }
            if(Nombre.getText().isEmpty()){
            errortext+="EL CAMPO NOMBRE NO SE ENCUENTRA RELLENADO" + "\n"  + "\n";
            error=true;
            }
            
            if (fnacimiento.getValue() == null){
            errortext+="EL CAMPO FECHA DE NACIMIENTO NO SE ENCUENTRA RELLENADO" + "\n"  + "\n";
            error=true;
            }
            
            if (fcontrato.getValue() == null){
            errortext+="EL CAMPO DE FECHA DE CONTRATO NO SE ENCUENTRA RELLENADO" + "\n"  + "\n";
            error=true;
            }
            
            if (contrasenyap.getText().isEmpty()){
            errortext+="EL CAMPO DE CONTRASEÑA NO SE ENCUENTRA RELLENADO" + "\n"  + "\n";
            error=true;
            }
            */
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
        }
    }
              else {
                 alertaerror.setTitle("DIALOGO ERROR");
                    alertaerror.setHeaderText("NADA INTRODUCIDO");
                    alertaerror.setContentText("La cantidad no ha sido introducida, cancela o introduce una");
                    alertaerror.showAndWait();
            }
    
                 
                 
                }
            }
          
            
        
           
    
  

    
    public Carta getTablaCartaSeleccionado(){
        if (tablacarta!=null){
           
         
            List<Carta> tabla = tablacarta.getSelectionModel().getSelectedItems();
            if(tabla.size()==1){
                final Carta CartaSeleccionado = tabla.get(0);
                return CartaSeleccionado;
            }
        }
        return null;
    }
    
    
    
    /*  public void ponerCartaSeleccionado(){
    final Carta cartae = getTablaCartaSeleccionado();
    Integer posicionCarta = cartaa.indexOf(cartae);
    
    if (cartae!=null){
    
    }
    
    }*/

    @FXML
    private void buscarcartanombre(ActionEvent event) {
        Carta.llenarCarta(cartaa, nombrecarta.getText());
        cartabuscar=nombrecarta.getText();
        tablacarta.setItems(cartaa);
        nombrecartarow.setCellValueFactory(new PropertyValueFactory<Carta, String> ("Nombre"));
          edicionrow.setCellValueFactory(new PropertyValueFactory<Carta, String> ("Edicion"));
          foilrow.setCellValueFactory(new PropertyValueFactory<Carta, Boolean> ("Foil"));
                 existenciasrow.setCellValueFactory(new PropertyValueFactory<Carta, Integer> ("Existencias"));
                   idedicionrow.setCellValueFactory(new PropertyValueFactory<Carta, Integer> ("IdEdicion"));
                   preciorow.setCellValueFactory(new PropertyValueFactory<Carta, Double> ("Precio") );
                   
        
        /*        private TableColumn<Carta, String> nombrecartarow;
        @FXML
        private TableColumn<Carta, String> edicionrow;
        @FXML
        private TableColumn<Carta, Boolean> foilrow;
        */
    }

    @FXML
    private void buscar(KeyEvent event) {
        tablacarta.getItems().clear();
        Carta.llenarCarta(cartaa, nombrecarta.getText());
        tablacarta.setItems(cartaa);
        nombrecartarow.setCellValueFactory(new PropertyValueFactory<Carta, String> ("Nombre"));
          edicionrow.setCellValueFactory(new PropertyValueFactory<Carta, String> ("Edicion"));
          foilrow.setCellValueFactory(new PropertyValueFactory<Carta, Boolean> ("Foil"));
                 existenciasrow.setCellValueFactory(new PropertyValueFactory<Carta, Integer> ("Existencias"));
                   idedicionrow.setCellValueFactory(new PropertyValueFactory<Carta, Integer> ("IdEdicion"));
                   preciorow.setCellValueFactory(new PropertyValueFactory<Carta, Double> ("Precio") );
                   

    }

    @FXML
    private void crearpedido(ActionEvent event) {
        FileChooser filechooser = new FileChooser();
  
        File file = filechooser.showSaveDialog(((Node)event.getSource()).getScene().getWindow());
        if (file!=null){
            FileWriter fw = null;
            BufferedWriter bw = null;
            
            try{
                fw = new FileWriter (file, false);
                bw = new BufferedWriter(fw);
                bw.write(area, 0, area.length());
                
            }
            catch(IOException ex){
                ex.getMessage();
            }
            
            finally{
               try {
	bw.close();
	} catch (Exception e2) {
	
} 
            }
        }
        
        
        
        
    }

    
  
        
        /*
        
        private ObservableList <Carta> cartaa = FXCollections.observableArrayList();
        TextInputDialog dialog = new TextInputDialog("Cantidad");
        
        @FXML
        private TextField nombrecarta;
        @FXML
        private TableColumn<Carta, String> nombrecartarow;
        @FXML
        private TableColumn<Carta, String> edicionrow;
        @FXML
        private TableColumn<Carta, Boolean> foilrow;
        @FXML
        private TextArea textcomun;
        @FXML
        private Button añadircarta;
        @FXML
        private TableView<Carta> tablacarta;
        String area="";
        String cartabuscar="";
        @FXML
        private Button buscarcarta;
        @FXML
        private TableColumn<Carta, Integer> existenciasrow;
        @FXML
        private TableColumn<Carta, Integer> idedicionrow;
        @FXML
        private TextField idclientefield;
        @FXML
        private TextField idempleadofield;
        @FXML
        private TextField idpedidofield;
        @FXML
        private TableColumn<Carta, Double> preciorow;
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        Alert alertaerror = new Alert (Alert.AlertType.ERROR);
        @FXML
        private Button switchto;
        @FXML
        private Label textoswitch;
        @FXML
        private Label texto2switch;
        @FXML
        private Button añadirmerchbutton;
        /**
        
        
        */
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    

    
    

