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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DAW
 */
public class FiltrarCartasController implements Initializable {
String filtro="";
    TextInputDialog dialog = new TextInputDialog("Cantidad");
     Alert alertconf = new Alert (Alert.AlertType.CONFIRMATION);
    @FXML
    private ComboBox<subtipo> subtipocombo;
    @FXML
    private ComboBox<Tipo> tipocombo;
    @FXML
    private ComboBox<Edicion> setcombo;
    @FXML
    private CheckBox checkblanco;
    @FXML
    private CheckBox checkazul;
    @FXML
    private CheckBox checknegro;
    @FXML
    private CheckBox checkrojo;
    @FXML
    private CheckBox checkverde;
    @FXML
    private CheckBox checkincoloro;
    @FXML
    private ImageView blancoicon1;
    @FXML
    private ImageView blancoicon11;
    @FXML
    private TextField nombrefield;
  private ObservableList<Edicion> edicionc = FXCollections.observableArrayList();
    private ObservableList<subtipo> subtipoc = FXCollections.observableArrayList();
    private ObservableList<Tipo> tipoc = FXCollections.observableArrayList();
    @FXML
    private CheckBox manaxcheck;
    int numeromanax=0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniciaredicion();
        iniciarsubtipo();
        iniciartipo();

        setcombo.setItems(edicionc);
        subtipocombo.setItems(subtipoc);
        tipocombo.setItems(tipoc);
    }    
  private void iniciartipo() {
        Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        try {
            PreparedStatement stmt5 = con.prepareStatement("Select Idtipo, Nombre from tipo ");

            ResultSet rss = stmt5.executeQuery();

            while (rss.next()) {
                Tipo tipoo = new Tipo(rss.getInt(1), rss.getString(2));

                tipoc.add(tipoo);
            }

            Tipo tipoo = new Tipo("Elige Tipo");
            tipoc.add(tipoo);
            tipocombo.setValue(tipoo);

        } catch (SQLException exx) {
            exx.getMessage();
        }
        //.setTooltip ( new Tooltip("awdinawoidnio"));

    }

    private void iniciarsubtipo() {
        Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        try {
            PreparedStatement stmt5 = con.prepareStatement("Select Idsubtipo, Nombre from subtipo ");

            ResultSet rss = stmt5.executeQuery();

            while (rss.next()) {
                subtipo subtipoo = new subtipo(rss.getInt(1), rss.getString(2));

                subtipoc.add(subtipoo);
            }

            subtipo subtipoo = new subtipo("Elige Subtipo");
            subtipoc.add(subtipoo);
            subtipocombo.setValue(subtipoo);

        } catch (SQLException exx) {
            exx.getMessage();
        }
        //.setTooltip ( new Tooltip("awdinawoidnio"));

    }

    private void iniciaredicion() {

        Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        try {
            PreparedStatement stmt5 = con.prepareStatement("Select Idedicion, Nombre, Fechalanzamiento from edicion ");

            ResultSet rss = stmt5.executeQuery();

            while (rss.next()) {
                Edicion edicion = new Edicion(rss.getInt(1), rss.getString(2), rss.getDate(3));
                System.out.println(rss.getString(2));
                edicionc.add(edicion);
            }

            Edicion edicion = new Edicion("Elige Edicion");
            edicionc.add(edicion);
            setcombo.setValue(edicion);

        } catch (SQLException exx) {
            exx.getMessage();
        }
        //.setTooltip ( new Tooltip("awdinawoidnio"));

        /*      @FXML
        private ComboBox<subtipo> subtipocombo;
        @FXML
        private ComboBox<Tipo> tipocombo;
        @FXML
        private ComboBox<Edicion> setcombo;
        @FXML
        private CheckBox checkblanco;
        @FXML
        private CheckBox checkazul;
        @FXML
        private CheckBox checknegro;
        @FXML
        private CheckBox checkrojo;
        @FXML
        private CheckBox checkverde;
        @FXML
        private CheckBox checkincoloro;
        @FXML
        private ImageView blancoicon1;
        @FXML
        private ImageView blancoicon11;
        @FXML
        private TextField nombrefield;*/
    }
        private void crearfiltro(){
           filtro="SELECT * from carta where 1=1 ";
           
           subtipo sb= subtipocombo.getSelectionModel().getSelectedItem();
           
           
            if (sb.getIdsubtipo()!=0){
                filtro+=" AND Subtipo = " + sb.getIdsubtipo();
                
            }
            Tipo tp = tipocombo.getSelectionModel().getSelectedItem();
            
            if (tp.getIdtipo()!=0){
                filtro+=" AND Tipo = " + tp.getIdtipo();
            }
            Edicion ed = setcombo.getSelectionModel().getSelectedItem();
            
            if (ed.getIdedicion()!=0){
                filtro+=" AND Edicion = " + ed.getIdedicion();
            }
            
            /*            SELECT * FROM Customers
            WHERE CustomerName LIKE 'a%'; */
            
            
            if (checkblanco.isSelected()){
                filtro+=" AND Mana LIKE "+ "'" + '%' +  'B' + '%' +"'"; 
            }
            if (checkazul.isSelected()){
                filtro+=" AND Mana LIKE "+ "'" + '%' +  'A' + '%' +"'"; 
            }
            
            if (checknegro.isSelected()){
                filtro+=" AND Mana LIKE " + "'" + '%' +  'N' + '%' +"'"; 
            }
            
            if (checkverde.isSelected()){
                filtro+=" AND Mana LIKE " + "'" + '%' +  'B' + '%' +"'"; 
            }
            
            if (checkincoloro.isSelected()){
                filtro+=" AND Mana LIKE " +  "'" + '%' +  'I' + '%' +"'"; 
            }
            
            if (checkrojo.isSelected()==true){
                   filtro+=" AND Mana LIKE " +  "'" + '%' +  'R' + '%' +"'"; 
                   System.out.println("hola");
            }
            System.out.println(filtro);
            if (manaxcheck.isSelected()){
                filtro+=" AND Mana LIKE " + "'" + '%' +  numeromanax + '%' +"'"; 
            }
            if (nombrefield.getText().isEmpty()==false){
                filtro+=" AND Nombre = " + nombrefield.getText();
            }
            
            if (sb.getIdsubtipo()==0 && tp.getIdtipo()==0 && ed.getIdedicion()==0 && checkrojo.isSelected()==false && checkblanco.isSelected()==false && checkazul.isSelected()==false && checknegro.isSelected()==false && checkverde.isSelected()==false && checkincoloro.isSelected()==false && manaxcheck.isSelected()==false && nombrefield.getText().isEmpty()){
                filtro="SELECT * from carta";
                System.out.println("wwadwadaw");
            }
        //     if(Nombre.getText().isEmpty()){
            
            /*      private CheckBox checkincoloro;
            @FXML
            private ImageView blancoicon1;
            @FXML
            private ImageView blancoicon11;
            @FXML
            private TextField nombrefield;*/
            
          
        }

    @FXML
    private void clearall(ActionEvent event) {
     
        checkblanco.setSelected(false);
        checkazul.setSelected(false);
        checknegro.setSelected(false);
        checkrojo.setSelected(false);
        checkverde.setSelected(false);
        checkincoloro.setSelected(false);
        nombrefield.clear();
        numeromanax=0;
        alertconf.setTitle("CLEARED");
        alertconf.setHeaderText("TODO CLEARED");
        alertconf.setContentText("TODOS LOS CAMPOS HAN SIDO CLEARED");
       alertconf.showAndWait();
        /*    private ComboBox<subtipo> subtipocombo;
        @FXML
        private ComboBox<Tipo> tipocombo;
        @FXML
        private ComboBox<Edicion> setcombo;
        @FXML
        private CheckBox checkblanco;
        @FXML
        private CheckBox checkazul;
        @FXML
        private CheckBox checknegro;
        @FXML
        private CheckBox checkrojo;
        @FXML
        private CheckBox checkverde;
        @FXML
        private CheckBox checkincoloro;
        @FXML
        private ImageView blancoicon1;
        @FXML
        private ImageView blancoicon11;
        @FXML
        private TextField nombrefield;
        private ObservableList<Edicion> edicionc = FXCollections.observableArrayList();
        private ObservableList<subtipo> subtipoc = FXCollections.observableArrayList();
        private ObservableList<Tipo> tipoc = FXCollections.observableArrayList();
        @FXML
        private CheckBox manaxcheck;
        int numeromanax=0;    */
        
        
    }

    @FXML
    private void buscarcarta(ActionEvent event) {
    try{
        
        crearfiltro();
    
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ConsultarCarta.fxml"));
        Parent root1 = (Parent)fxmlLoader.load();
        Stage stage = new Stage();
        ConsultarCartaController controller = fxmlLoader.<ConsultarCartaController>getController();
        System.out.println(filtro);
        System.out.println("pasado");
        System.out.println(filtro);
        
        controller.initicarvariable(filtro);
        stage.setScene(new Scene((root1)));
         stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        
                }
  catch (IOException exx){
            exx.getMessage();
        }
        
    }

    @FXML
    private void pedirmana(ActionEvent event) {
            dialog.setTitle("CANTIDAD");
            dialog.setHeaderText("INTRODUCE LA CANTIDAD");
            dialog.setContentText("CANTIDAD:");
            Optional<String> result = dialog.showAndWait();
            String   resultadodialogo=result.get();
           numeromanax = Integer.parseInt(resultadodialogo);
          
  
                
        
    }
    
    
    
        
    

  
    
}
