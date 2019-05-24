/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import DAO.Conexion;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author paco
 */
public class ConsultarCartaController implements Initializable {
    
    private ObservableList<Carta> cartaa = FXCollections.observableArrayList();
    String rutaimagen = "";
    Alert alertaerror = new Alert(Alert.AlertType.ERROR);
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    Alert alerterror = new Alert(Alert.AlertType.ERROR);
    private ObservableList<Edicion> edicionc = FXCollections.observableArrayList();
    private ObservableList<subtipo> subtipoc = FXCollections.observableArrayList();
    private ObservableList<Tipo> tipoc = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Carta, String> nombrerow;
    @FXML
    private TableColumn<Carta, String> edicionrow;
    @FXML
    private TableColumn<Carta, Integer> existenciasrow;
    @FXML
    private TableColumn<Carta, String> manarow;
    @FXML
    private TableColumn<Carta, String> tiporow;
    @FXML
    private TableColumn<Carta, String> subtiporow;
    @FXML
    private TableColumn<Carta, String> artistarow;
    @FXML
    private TableColumn<Carta, Integer> lealdadrow;
    @FXML
    private TableColumn<Carta, Double> ataquerow;
    @FXML
    private TableColumn<Carta, Double> defensarow;
    @FXML
    private TableColumn<Carta, Boolean> foilrow;
    @FXML
    private TextField idcartafield;
    @FXML
    private TextField nombrefield;
    
    @FXML
    private TextField existenciasfield;
    @FXML
    private TextField manafield;
    @FXML
    private TextField ataquefield;
    @FXML
    private TextField lealdadfield;
    @FXML
    private TextField artistafield;
    @FXML
    private ComboBox<subtipo> subtipofield;
    @FXML
    private ComboBox<Tipo> tipofield;
    @FXML
    private ComboBox<Edicion> edicionfield;
    @FXML
    private TextField defensafield;
    @FXML
    private ImageView imagencarta;
    @FXML
    private TextArea descriparea;
    @FXML
    private RadioButton sifoil;
    @FXML
    private ToggleGroup foilono;
    @FXML
    private RadioButton nofoil;
    @FXML
    private TextField preciofield;
    ArrayList<Integer> list = new ArrayList<Integer>();
    
    public String statemententero = "prueba";    
    
    @FXML
    private TableView<Carta> tablacarta;
    @FXML
    private TableColumn<Carta, Integer> idcartarow;
    @FXML
    private TableColumn<Carta, Double> preciorow;
    
    @FXML
    private TableColumn<Carta, String> descrow;
    @FXML
    private TextField statementanterior;
    
    public void initicarvariable(String informacion) {
        this.statementanterior.setText(informacion);
        
        this.statemententero = informacion;
        
        System.out.println(this.statemententero);
        buscar();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        idcartafield.setEditable(false);
        iniciarsubtipo();
        iniciartipo();
        iniciaredicion();
        tipofield.setItems(tipoc);
        subtipofield.setItems(subtipoc);
        edicionfield.setItems(edicionc);
        final ObservableList<Carta> tablaCartaSel = tablacarta.getSelectionModel().getSelectedItems();
        tablaCartaSel.addListener(selectorcartatable);

        // buscar();
    }    
    
    private final ListChangeListener<Carta> selectorcartatable = new ListChangeListener<Carta>() {
        @Override
        public void onChanged(ListChangeListener.Change<? extends Carta> c) {
            ponerCartaSeleccionado();
        }        
    };
    
    public Carta getTablaCartaSeleccionado() {
        if (tablacarta != null) {
            
            List<Carta> tabla = tablacarta.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Carta CartaSeleccionado = tabla.get(0);
                return CartaSeleccionado;
            }
        }
        return null;
    }
    
    private void buscar() {
        System.out.println(statemententero);
        System.out.println(statementanterior.getText());
        
        tablacarta.getItems().clear();
        Carta.llenarCartaMod(cartaa, statementanterior.getText());
        tablacarta.setItems(cartaa);
        
        descrow.setCellValueFactory(new PropertyValueFactory<Carta, String>("Descripcion"));
        idcartarow.setCellValueFactory(new PropertyValueFactory<Carta, Integer>("IdCarta"));
        nombrerow.setCellValueFactory(new PropertyValueFactory<Carta, String>("Nombre"));
        edicionrow.setCellValueFactory(new PropertyValueFactory<Carta, String>("Edicion"));
        existenciasrow.setCellValueFactory(new PropertyValueFactory<Carta, Integer>("Existencias"));
        manarow.setCellValueFactory(new PropertyValueFactory<Carta, String>("Mana"));
        tiporow.setCellValueFactory(new PropertyValueFactory<Carta, String>("Tipo"));
        subtiporow.setCellValueFactory(new PropertyValueFactory<Carta, String>("Subtipo"));
        artistarow.setCellValueFactory(new PropertyValueFactory<Carta, String>("Artista"));
        lealdadrow.setCellValueFactory(new PropertyValueFactory<Carta, Integer>("Lealdad"));
        ataquerow.setCellValueFactory(new PropertyValueFactory<Carta, Double>("Ataque"));
        defensarow.setCellValueFactory(new PropertyValueFactory<Carta, Double>("Defensa"));
        foilrow.setCellValueFactory(new PropertyValueFactory<Carta, Boolean>("Foil"));
        preciorow.setCellValueFactory(new PropertyValueFactory<Carta, Double>("Precio"));

        //   nombrecartarow.setCellValueFactory(new PropertyValueFactory<Carta, String> ("Nombre")); 
        /*   @FXML
       private TableColumn<Carta, String> nombrerow;
       @FXML
       private TableColumn<Carta, String> edicionrow;
       @FXML
       private TableColumn<Carta, String> existenciasrow;
       @FXML
       private TableColumn<Carta, String> manarow;
       @FXML
       private TableColumn<Carta, String> tiporow;
       @FXML
       private TableColumn<Carta, String> subtiporow;
       @FXML
       private TableColumn<Carta, String> artistarow;
       @FXML
       private TableColumn<Carta, Integer> lealdadrow;
       @FXML
       private TableColumn<Carta, Integer> ataquerow;
       @FXML
       private TableColumn<Carta, Integer> defensarow;
       @FXML
       private TableColumn<Carta, Boolean> foilrow;*/
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
            
            Tipo tipoo = new Tipo("No tipo");
            tipoc.add(tipoo);
            
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
            
            subtipo subtipoo = new subtipo("No subtipo");
            subtipoc.add(subtipoo);
            subtipofield.setValue(subtipoo);
            
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
            
            Edicion edicion = new Edicion("No edición");
            edicionc.add(edicion);
            edicionfield.setValue(edicion);
            
        } catch (SQLException exx) {
            exx.getMessage();
        }
        /*  Conexion conexion = new Conexion();
            Connection con = conexion.conectar();
            
            try {
            PreparedStatement stmt5 = con.prepareStatement("Select Idedicion, Nombre, Fechalanzamiento from edicion");
            stmt5.setString(1, nombre);
            ResultSet rss = stmt5.executeQuery();
            
            while (rss.next()){
            Edicion edicion = new Edicion(rss.getInt(1), rss.getString(2), rss.getDate(3));
            edicionc.add(edicion);
            
            }
            
            Edicion edicion = new Edicion("No edicion");
            edicionc.add(edicion);
            
            PreparedStatement stmt6 = con.prepareStatement("Select Idedicion, Nombre, Fechalanzamiento from edicion where Nombre= ?");
            stmt6.setString(1, nombre);
            ResultSet rs2 = stmt6.executeQuery();
            rs2.next();
            Edicion edicionnn = new Edicion(nombre);
            edicionfield.setValue(edicionnn);
            
            } catch (SQLException exx) {
            exx.getMessage();
            }*/
        //.setTooltip ( new Tooltip("awdinawoidnio"));

    }

    /*    private ObservableList<Edicion> edicionc = FXCollections.observableArrayList();
        private ObservableList<subtipo> subtipoc = FXCollections.observableArrayList();
        private ObservableList<Tipo> tipoc = FXCollections.observableArrayList();*/
    public void ponerCartaSeleccionado() {
        Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        try {
            
            final Carta carta = getTablaCartaSeleccionado();
            Integer posicionCarta = cartaa.indexOf(carta);
            
            if (carta != null) {
                idcartafield.setText(Integer.toString(carta.getIdcarta()));
                nombrefield.setText(carta.getNombre());
                
                existenciasfield.setText(Integer.toString(carta.getExistencias()));
                manafield.setText(carta.getMana());
                ataquefield.setText(Double.toString(carta.getAtaque()));
                lealdadfield.setText(Integer.toString(carta.getLealdad()));
                artistafield.setText(carta.getArtista());
                defensafield.setText(Double.toString(carta.getDefensa()));
                System.out.println(carta.getImagen());
                //     Image image = new Image (carta.getImagen());
                //    imagencarta.setImage(image);
                descriparea.setText(carta.getDescripcion());
                if (carta.isFoil() == true) {
                    sifoil.setSelected(true);
                    
                } else {
                    nofoil.setSelected(true);
                }
                preciofield.setText(Double.toString(carta.getPrecio()));
                System.out.println(carta.getTiponombre());
                System.out.println(carta.getSubtiponombre());
                System.out.println(carta.getEdicion());

                //  iniciartipo(carta.getTiponombre());
                //   iniciarsubtipo(carta.getSubtiponombre());
//              iniciaredicion(carta.getEdicion());
                subtipofield.setItems(subtipoc);
                PreparedStatement stmt5 = con.prepareStatement("Select Idtipo, Nombre from tipo where Idtipo = ?");
                stmt5.setInt(1, carta.getTipo());
                
                System.out.println(carta.getTipo());
                ResultSet rss = stmt5.executeQuery();
                rss.next();
                Tipo tipo = new Tipo(rss.getInt(1), rss.getString(2));
                tipoc.add(tipo);
                tipofield.setValue(tipo);
                
                edicionfield.setItems(edicionc);

                /*           private ComboBox<subtipo> subtipofield;
              @FXML
              private ComboBox<Tipo> tipofield;
              @FXML
              private ComboBox<Edicion> edicionfield;*/
                //    Integer.toString(int)
                //   Double.toString(double)
                /*           @FXML
              private TextField idcartafield;
              @FXML
              private TextField nombrefield;
              @FXML
              private TextField edicionfield;
              @FXML
              private TextField existenciasfield;
              @FXML
              private TextField manafield;
              @FXML
              private TextField ataquefield;
              @FXML
              private TextField lealdadfield;
              @FXML
              private TextField artistafield;
              @FXML
              private TextField subtipofield;
              @FXML
              private TextField tipofield;
              @FXML
              private TextField defensafield;
              @FXML
              private ImageView imagencarta;
              @FXML
              private TextArea descriparea;
              @FXML
              private RadioButton sifoil;
              @FXML
              private ToggleGroup foilono;
              @FXML
              private RadioButton nofoil;
              @FXML
              private TextField preciofield;*/
            }
        } catch (SQLException exx) {
            exx.getMessage();
        }
    }
    
    @FXML
    private void modificar(ActionEvent event) {
        
        Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        ResultSet rs;
        int juezonov = 0;
        String juezboolean = "";
        PreparedStatement stmt = null;
        //    double d=Double.parseDouble("23.6");  
//Idcarta	Precio	Existencias	Nombre	Descripcion	Mana	Tipo	Subtipo	Artista	Imagen	Lealdad	Ataque	Defensa	Edicion	Foil
        try {
            //  Double.toString
            //                                            1           2               3           4               5       6       7               8       9       10          11          12          13          14              15
            stmt = con.prepareStatement("UPDATE carta SET Precio= ?, Existencias= ?, Nombre= ?, Descripcion= ?, Mana= ?, Tipo= ?, Subtipo= ?, Artista= ?, Imagen= ?, Lealdad= ?, Ataque= ?, Defensa= ?, Edicion= ?, Foil= ? where Idcarta= ?");
            double d = Double.parseDouble(preciofield.getText());
            
            stmt.setDouble(1, d);
            //  d = Double.parseDouble(juezboolean)
            d = Double.parseDouble(existenciasfield.getText());
            stmt.setDouble(2, d);
            stmt.setString(3, nombrefield.getText());
            stmt.setString(4, descriparea.getText());
            stmt.setString(5, manafield.getText());
            Tipo tp = tipofield.getSelectionModel().getSelectedItem();
            int pruebaa = tp.getIdtipo();
            
            stmt.setInt(6, pruebaa);
            subtipo sb = subtipofield.getSelectionModel().getSelectedItem();
            stmt.setInt(7, sb.getIdsubtipo());
            stmt.setString(8, artistafield.getText());
            double ddd = Double.parseDouble(ataquefield.getText());
            stmt.setDouble(12, ddd);
            ddd = Double.parseDouble(defensafield.getText());
            stmt.setInt(10, Integer.parseInt(lealdadfield.getText()));
            
            stmt.setDouble(13, ddd);
            Edicion edi = edicionfield.getSelectionModel().getSelectedItem();
            
            stmt.setString(9, rutaimagen);
            if (sifoil.isSelected()) {
                stmt.setInt(14, 1);
                
            } else {
                stmt.setInt(14, 0);
            }
            
            final Carta carta = getTablaCartaSeleccionado();
            Integer posicionCarta = cartaa.indexOf(carta);
            
            stmt.setInt(15, carta.getIdcarta());
            
            stmt.executeUpdate();

            //  double d=Double.parseDouble("23.6");
        } catch (SQLException exx) {
            alerterror.setTitle(exx.getMessage());
            alerterror.setHeaderText("ERROR");
            alerterror.setContentText("ERROR EN LA MODIFICACIÓN DE UNA CARTA");
            alerterror.showAndWait();
        }
        
    }
    
    @FXML
    private void eliminarcarta(ActionEvent event) {
    }
    
    @FXML
    private void search(ActionEvent event) {
        try {
            
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Abrir fichero");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.gif"));
            File selectedFile = fileChooser.showOpenDialog(((Node) event.getSource()).getScene().getWindow());
            if (selectedFile != null) {
                
                Image image = new Image(new FileInputStream(selectedFile.getAbsolutePath()));
                String ruta = "";
                rutaimagen = selectedFile.getAbsolutePath();

                //   FileInputStream inputstream = new FileInputStream(selectedFile.getAbsolutePath());
                //   Path path = Paths.get(selectedFile.getAbsolutePath());
                //       Image image = new Image(new FileInputStream(inputstream));
                imagencarta.setImage(image);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("CONSEGUIDO");
                alert.setHeaderText("CONSEGUIDO IMAGEN");
                alert.setContentText("CONSEGUIDO LA INSERCIÓN DE IMAGEN");
                
            }
            
        } catch (FileNotFoundException exx) {
            alerterror.setTitle(exx.getMessage());
            alerterror.setHeaderText("ERROR");
            alerterror.setContentText("ERROR EN LA BUSQUEDA");
            alerterror.showAndWait();
        }

        /*    String path="";
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir Imagen");
        File seletedFile = fileChooser.showOpenDialog(null);
        
        
        if (seletedFile != null){
        
        
        
        }
        else{
        
        }    */
        //   fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.gif"));
        //  fileChooser.showOpenDialog(stage);
    }
    
}
