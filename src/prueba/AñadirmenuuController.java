/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import DAO.Conexion;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author paco
 */
public class AñadirmenuuController implements Initializable {

    String blancoos = "";
    String azull = "";
    String negroo = "";
    String rojoo = "";
    String verdee = "";
    String incoloroo = "";
    int manaxv;
    String rutaimagen = "";

    @FXML
    private Button blancoboton;
    @FXML
    private ImageView blancoicon;
    @FXML
    private Button negroboton;
    @FXML
    private ImageView negroicono;
    @FXML
    private Button azulboton;
    @FXML
    private ImageView azulicono;
    @FXML
    private Button verdeboton;
    @FXML
    private ImageView verdeicono;
    @FXML
    private Button rojoboton;
    @FXML
    private ImageView rojoicono;
    @FXML
    private Label blancolabel;
    @FXML
    private Label negrolabel;
    @FXML
    private Label azullabel;
    @FXML
    private Label verdelabel;
    @FXML
    private Label rojolabel;
    @FXML
    private Button volver;
    @FXML
    private Button imagenopen;
    @FXML
    private ImageView imagencarta;
    @FXML
    private TextArea descripcioncarta;
    @FXML
    private Button incoloroboton;
    @FXML
    private ImageView blancoicon1;
    @FXML
    private Button incoloroxboton;
    @FXML
    private ImageView blancoicon11;
    @FXML
    private ComboBox<Tipo> tipo;
    @FXML
    private ComboBox<subtipo> subtipo;
    @FXML
    private ComboBox<Edicion> Edicion;
    @FXML
    private TextField artista;

    /**
     * Initializes the controller class.
     */
    @FXML
    private ImageView manablanco;
    @FXML
    private ImageView mananegro;
    @FXML
    private ImageView manaazul;
    @FXML
    private ImageView manaverde;
    @FXML
    private ImageView manarojo;
    @FXML
    private ImageView manaincoloro;
    @FXML
    private Label manaincolorolabel;
    @FXML
    private ImageView manax;
    @FXML
    private Label manaxlabel;
    @FXML
    private TextField loyalidad;
    @FXML
    private ToggleGroup tipocarta;
    @FXML
    private RadioButton criaturaradio;
    @FXML
    private RadioButton tierraradio;
    @FXML
    private RadioButton planeradio;
    @FXML
    private TextField ataque;
    @FXML
    private TextField defensa;
    @FXML
    private ToolBar menumana;
    @FXML
    private VBox menuañadirmana;
    private ObservableList<Edicion> edicionc = FXCollections.observableArrayList();
    private ObservableList<subtipo> subtipoc = FXCollections.observableArrayList();
    private ObservableList<Tipo> tipoc = FXCollections.observableArrayList();

    private ObservableList<String> options = FXCollections.observableArrayList("");
    private ObservableList<String> subtype = FXCollections.observableArrayList("");
    private ObservableList<String> edicionob = FXCollections.observableArrayList("");
    @FXML
    private TextField preciocarta;
    @FXML
    private TextField Existenciascarta;
    @FXML
    private VBox menuañadirmana1;
    @FXML
    private Button blancobotonmenos;
    @FXML
    private Button negrobotonmenos;
    @FXML
    private ImageView negroicono1;
    @FXML
    private Button azulbotonmenos;
    @FXML
    private ImageView azulicono1;
    @FXML
    private Button verdebotonmenos;
    @FXML
    private ImageView verdeicono1;
    @FXML
    private Button rojobotonmenos;
    @FXML
    private ImageView rojoicono1;
    @FXML
    private Button incolorobotonmenos;
    @FXML
    private Button incoloroxbotonmenos;
    @FXML
    private ImageView blancoicon111;
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private TextField nombrecarta;
    @FXML
    private Button añadirboton;
    // pones el tipo edicion   combobox.add(null) combobox.setitems(lista)
    @FXML
    private CheckBox foiltick;
    @FXML
    private TextField preciofoil;
    @FXML
    private TextField existenciasfoil;

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

        } catch (SQLException exx) {
            exx.getMessage();
        }
        //.setTooltip ( new Tooltip("awdinawoidnio"));

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comprobarmana();
        iniciaredicion();
        iniciarsubtipo();
        iniciartipo();

        Edicion.setItems(edicionc);
        subtipo.setItems(subtipoc);
        tipo.setItems(tipoc);

        /*         try{
           PreparedStatement edicioncon = con.prepareStatement("Select Nombre from edicion");
           
           edicioncon.executeQuery();
           ResultSet rss = edicioncon.executeQuery();
           
           while (rss.next()){
           edicionob.add(rss.getString(1));
           }
          
           
           
           }
           
           catch(SQLException exx){
           exx.getMessage();
           }*/
    }

    @FXML
    private void eliminarmana(ActionEvent event) {
        info();

        int blancoo = 0;
        String blancot = "";
        String negrot = "";
        String azult = "";
        String verdet = "";
        String rojot = "";
        String incolorot = "";
        String manaxxt = "";

        int negro = 0;
        int azul = 0;
        int verde = 0;
        int rojo = 0;
        int incoloro = 0;
        int manaxx = 0;

        String swap = "";
        Button btn = (Button) event.getSource();
        String id = btn.getId();

        if (id.equals("blancobotonmenos")) {
            blancot = blancolabel.getText();

            Integer result = Integer.valueOf(blancot);
            if (result > 0) {

                result--;
                swap = String.valueOf(result);

                blancolabel.setText(swap);
            }
        } else if (id.equals("negrobotonmenos")) {
            negrot = negrolabel.getText();

            Integer resultn = Integer.valueOf(negrot);
            if (resultn > 0) {

                resultn--;
                swap = String.valueOf(resultn);

                negrolabel.setText(swap);
            }
        } else if (id.equals("azulbotonmenos")) {
            azult = azullabel.getText();

            Integer resulta = Integer.valueOf(azult);
            if (resulta > 0) {
                resulta--;
                swap = String.valueOf(resulta);
                azullabel.setText(swap);
            }

        } else if (id.equals("verdebotonmenos")) {
            verdet = verdelabel.getText();
            Integer resultv = Integer.valueOf(verdet);
            if (resultv > 0) {
                resultv--;
                swap = String.valueOf(resultv);
                verdelabel.setText(swap);
            }

        } else if (id.equals("rojobotonmenos")) {
            rojot = rojolabel.getText();
            Integer resultr = Integer.valueOf(rojot);
            if (resultr > 0) {
                resultr--;
                swap = String.valueOf(resultr);
                rojolabel.setText(swap);

            }

        } else if (id.equals("incolorobotonmenos")) {
            incolorot = manaincolorolabel.getText();
            Integer resultii = Integer.valueOf(incolorot);
            if (resultii > 0) {
                resultii--;
                swap = String.valueOf(resultii);
                manaincolorolabel.setText(swap);
            }
        } else if (id.equals("incoloroxbotonmenos")) {
            manaxxt = manaxlabel.getText();
            Integer resultinc = Integer.valueOf(manaxxt);
            if (resultinc > 0) {
                resultinc--;
                swap = String.valueOf(resultinc);
                manaxlabel.setText(swap);

            }
        }

        this.comprobarmana();

    }

    private void comprobarmana() {

        String negro = negrolabel.getText();
        int result = Integer.parseInt(negro);

        System.out.println("hola");
        System.out.println(result);
        if (result == 0) {
            mananegro.setVisible(false);
            loyalidad.setVisible(false);
        } else {
            mananegro.setVisible(true);
        }

        String blanco = blancolabel.getText();
        result = Integer.parseInt(blanco);

        if (result == 0) {
            manablanco.setVisible(false);
        } else {
            manablanco.setVisible(true);
        }

        String azul = azullabel.getText();
        result = Integer.parseInt(azul);

        if (result == 0) {
            manaazul.setVisible(false);
        } else {
            manaazul.setVisible(true);
        }

        String verde = verdelabel.getText();
        result = Integer.parseInt(verde);

        if (result == 0) {
            manaverde.setVisible(false);
        } else {
            manaverde.setVisible(true);
        }

        String rojo = rojolabel.getText();
        result = Integer.parseInt(rojo);

        if (result == 0) {
            manarojo.setVisible(false);
        } else {
            manarojo.setVisible(true);
        }

    }

    public void info() {

        TextInputDialog dialog = new TextInputDialog("Pepe");
        dialog.setTitle("Entrada de texto");
        dialog.setHeaderText("Cabecera");
        dialog.setContentText("Introduce tu nombre");

        /* Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        
        alert.setTitle("Dialogo de información");
        alert.setHeaderText("Esta es la cabecera");
        alert.setContentText("Aqui va el texto del mensaje a mostrar");
        Optional<ButtonType> result = alert.showAndWait();
        
        if (result.isPresent() && result.get()==ButtonType.OK){
        System.out.println("OK");
        }
        else{
        System.out.println("CANCEL");
        }
         */
    }

    @FXML
    private void sumarmana(ActionEvent event) {
        // info();

        int blancoo = 0;
        String blancot = "";
        String negrot = "";
        String azult = "";
        String verdet = "";
        String rojot = "";
        String incolorot = "";
        String manaxxt = "";

        int negro = 0;
        int azul = 0;
        int verde = 0;
        int rojo = 0;
        int incoloro = 0;
        int manaxx = 0;

        String swap = "";
        Button btn = (Button) event.getSource();
        String id = btn.getId();

        if (id.equals("blancoboton")) {
            blancot = blancolabel.getText();

            Integer result = Integer.valueOf(blancot);
            result++;
            swap = String.valueOf(result);

            blancolabel.setText(swap);
        } else if (id.equals("negroboton")) {
            negrot = negrolabel.getText();

            Integer resultn = Integer.valueOf(negrot);
            resultn++;
            swap = String.valueOf(resultn);

            negrolabel.setText(swap);
        } else if (id.equals("azulboton")) {
            azult = azullabel.getText();

            Integer resulta = Integer.valueOf(azult);
            resulta++;
            swap = String.valueOf(resulta);
            azullabel.setText(swap);

        } else if (id.equals("verdeboton")) {
            verdet = verdelabel.getText();
            Integer resultv = Integer.valueOf(verdet);
            resultv++;
            swap = String.valueOf(resultv);
            verdelabel.setText(swap);

        } else if (id.equals("rojoboton")) {
            rojot = rojolabel.getText();
            Integer resultr = Integer.valueOf(rojot);
            resultr++;
            swap = String.valueOf(resultr);
            rojolabel.setText(swap);

        } else if (id.equals("incoloroboton")) {
            incolorot = manaincolorolabel.getText();
            Integer resultii = Integer.valueOf(incolorot);
            resultii++;
            swap = String.valueOf(resultii);
            manaincolorolabel.setText(swap);
        } else if (id.equals("incoloroxboton")) {
            manaxxt = manaxlabel.getText();
            Integer resultinc = Integer.valueOf(manaxxt);
            resultinc++;
            swap = String.valueOf(resultinc);
            manaxlabel.setText(swap);

        }

        this.comprobarmana();

    }

    @FXML
    private void volveratras(ActionEvent event) {

        Stage stage = (Stage) volver.getScene().getWindow();
        stage.close();

    }

    @FXML
    private void onOpen(ActionEvent event) throws FileNotFoundException {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir fichero");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(((Node) event.getSource()).getScene().getWindow());
        if (selectedFile != null) {

            Image image = new Image(new FileInputStream(selectedFile.getAbsolutePath()));
            String ruta = "";
            rutaimagen = selectedFile.getAbsolutePath();

            //   FileInputStream inputstream = new FileInputStream(selectedFile.getAbsolutePath());
            //   Path path = Paths.get(selectedFile.getAbsolutePath());
            //       Image image = new Image(new FileInputStream(inputstream));
            imagencarta.setImage(image);
            System.out.println("Conseguido");

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

    @FXML
    private void comprobartipocarta(ActionEvent event) {
        if (criaturaradio.isSelected()) {
//             AnchorPane.getChildren().clear();

            nombrecarta.clear();
            tipo.setValue(null);
            subtipo.setValue(null);
            Edicion.setValue(null);
            artista.clear();
            loyalidad.clear();
            ataque.clear();
            defensa.clear();
            blancolabel.setText("0");
            negrolabel.setText("0");
            azullabel.setText("0");

            loyalidad.setVisible(false);
            ataque.setVisible(true);
            defensa.setVisible(true);
            menumana.setVisible(true);
            menuañadirmana.setVisible(true);
            menuañadirmana1.setVisible(true);

        } else if (tierraradio.isSelected()) {
            //    AnchorPane.getChildren().clear();
            loyalidad.setVisible(false);
            ataque.setVisible(false);
            defensa.setVisible(false);
            menumana.setVisible(false);
            menuañadirmana.setVisible(false);
            menuañadirmana1.setVisible(false);
        } else {
            //    AnchorPane.getChildren().clear();
            loyalidad.setVisible(true);
            menuañadirmana1.setVisible(true);
            menumana.setVisible(true);
            menuañadirmana.setVisible(true);
            ataque.setVisible(false);
            defensa.setVisible(false);
        }
    }

    private String obtenermanatotal() {

        //    info();
        String blancot = "";
        String negrot = "";
        String azult = "";
        String verdet = "";
        String rojot = "";
        String incolorot = "";
        String manaxxt = "";

        String swap = "";
        blancot = blancolabel.getText();
        Integer result = Integer.valueOf(blancot);

        while (result > 0) {
            blancoos += "B";
            result--;
        }

        negrot = negrolabel.getText();
        Integer resultn = Integer.valueOf(negrot);
        while (resultn > 0) {
            negroo += "N";
            resultn--;
        }

        azult = azullabel.getText();
        Integer resulta = Integer.valueOf(azult);
        while (resulta > 0) {
            azull += "A";
            resulta--;
        }

        verdet = verdelabel.getText();
        Integer resultv = Integer.valueOf(verdet);

        while (resultv > 0) {
            verdee += "V";
            resultv--;
        }

        rojot = rojolabel.getText();
        Integer resultr = Integer.valueOf(rojot);

        while (resultr > 0) {
            rojoo += "R";
            resultr--;
        }

        incolorot = manaincolorolabel.getText();
        Integer resultii = Integer.valueOf(incolorot);

        while (resultii > 0) {
            incoloroo += "I";
            resultii--;
        }

        manaxxt = manaxlabel.getText();
        Integer resultinc = Integer.valueOf(manaxxt);

        while (resultinc > 0) {
            manaxv++;
            resultinc--;
        }

        String valorx = Integer.toString(manaxv);

        String todo = "";

        todo += valorx + azull + negroo + rojoo + verdee + incoloroo;
        System.out.println(todo);

        result = 0;
        resultn = 0;
        resulta = 0;
        resultv = 0;
        resultr = 0;
        resultii = 0;
        resultinc = 0;
        manaxv = 0;
        valorx = "";
        todo = "";
        return todo;

    }

    /*
    private void añadirtipo(){
    
    Conexion conexion = new Conexion();
    Connection con = conexion.conectar();
    try{
    
    
    PreparedStatement stmt2 = con.prepareStatement("INSERT INTO tipo (Nombre) VALUES(?)");
    stmt2.setString(1, tipo.get);
    }
    catch(SQLException exx){
    exx.getMessage();
    }
    }
    
     */
    @FXML
    private void añadircarta(ActionEvent event) {
        Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        String ataquei;
        int ataqueint;

        String defensai;
        int defensaint;

        // id precio existencias nombres descripcion mana tipo subtipo artista imagen lealdad ataque defensa edicion
        //   1          2           3           4       5     6       7       8       9      10      11      12      13      14
        // (Precio, Existencias, Nombre, Descripcion, Mana, Tipo, Subtipo, Artista, Imagen, Lealdad, Ataque, Defensa, Edicion, Foil) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");  
        // 1          
        //   PreparedStatement stmt2 = con.prepareStatement("INSERT INTO carta (Precio,
        //  2         // 3                                                                
        //Existencias, Nombre,
        //   Descripcion, Mana, Tipo, Artista, Imagen, Ataque, Defensa, Edicion) VALUES(?,?,?,?,?,?,?,?,?,?,?)");  
        //                4       5        6      7       8       9       10      11
        //
        //    String subtipoo="subtipo";
        //      if (subtipo.Selected){
        try {
            PreparedStatement stmt2 = con.prepareStatement("INSERT INTO carta (Precio, Existencias, Nombre, Descripcion, Mana, Tipo, Subtipo, Artista, Imagen, Lealdad, Ataque, Defensa, Edicion, Foil) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            String precio = preciocarta.getText();
            double precioo = Double.parseDouble(precio);
            stmt2.setDouble(1, precioo);

            precio = Existenciascarta.getText();
            precioo = Double.parseDouble(precio);
            stmt2.setDouble(2, precioo);

            stmt2.setString(3, nombrecarta.getText());
            stmt2.setString(4, descripcioncarta.getText());
            stmt2.setString(5, obtenermanatotal());

            PreparedStatement stmt3 = con.prepareStatement("Select Idtipo from tipo where Nombre = ?");
            stmt3.setString(1, tipo.getSelectionModel().getSelectedItem().getNombre());
            ResultSet rs = stmt3.executeQuery();
            rs.next();
            stmt2.setInt(6, rs.getInt(1));
            if (subtipo.getSelectionModel().getSelectedItem().Nombre.equals("No subtipo") || subtipo.getSelectionModel().getSelectedItem().Nombre.equals("Subtipo")) {
                stmt2.setNull(7, java.sql.Types.INTEGER);
            } else {

                stmt3 = con.prepareStatement("Select Idsubtipo from subtipo where Nombre = ?");
                stmt3.setString(1, subtipo.getSelectionModel().getSelectedItem().getNombre());
                rs = stmt3.executeQuery();
                rs.next();
                stmt2.setInt(7, rs.getInt(1));
            }

            stmt2.setString(8, artista.getText());
            stmt2.setString(9, rutaimagen);
            System.out.println(loyalidad.getText());

            if (loyalidad.getText().isEmpty()) {

            } else {

                int loyalidadd = Integer.parseInt(loyalidad.getText());
                stmt2.setInt(10, loyalidadd);
            }

            if (ataque.getText().isEmpty()) {

            } else {

                ataquei = ataque.getText();
                ataqueint = Integer.parseInt(ataquei);

                stmt2.setInt(11, ataqueint);
            }

            if (defensa.getText().isEmpty()) {

            } else {

                defensai = defensa.getText();
                defensaint = Integer.parseInt(defensai);
                stmt2.setInt(12, defensaint);
            }
            PreparedStatement stmt4 = con.prepareStatement("Select Idedicion from edicion where Nombre = ?");

            stmt4.setString(1, Edicion.getSelectionModel().getSelectedItem().Nombre);
            rs = stmt4.executeQuery();
            rs.next();
            stmt2.setInt(13, rs.getInt(1));

            if (foiltick.isSelected()) {
                stmt2.setInt(14, 0);
                stmt2.executeUpdate();

                /*            @FXML
private CheckBox foiltick;
@FXML
private TextField preciofoil;
@FXML
private TextField existenciasfoil;
                 */
                stmt2 = con.prepareStatement("INSERT INTO carta (Precio, Existencias, Nombre, Descripcion, Mana, Tipo, Subtipo, Artista, Imagen, Lealdad, Ataque, Defensa, Edicion, Foil) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                precio = preciofoil.getText();
                precioo = Double.parseDouble(precio);
                stmt2.setDouble(1, precioo);

                precio = existenciasfoil.getText();
                precioo = Double.parseDouble(precio);
                stmt2.setDouble(2, precioo);

                stmt2.setString(3, nombrecarta.getText());
                stmt2.setString(4, descripcioncarta.getText());
                stmt2.setString(5, obtenermanatotal());

                stmt3 = con.prepareStatement("Select Idtipo from tipo where Nombre = ?");
                stmt3.setString(1, tipo.getSelectionModel().getSelectedItem().getNombre());
                rs = stmt3.executeQuery();
                rs.next();
                stmt2.setInt(6, rs.getInt(1));
                if (subtipo.getSelectionModel().getSelectedItem().Nombre.equals("No subtipo") || subtipo.getSelectionModel().getSelectedItem().Nombre.equals("Subtipo")) {

                } else {
                    stmt3 = con.prepareStatement("Select Idsubtipo from subtipo where Nombre = ?");
                    stmt3.setString(1, subtipo.getSelectionModel().getSelectedItem().getNombre());
                    rs = stmt3.executeQuery();
                    rs.next();
                    stmt2.setInt(7, rs.getInt(1));
                }

                stmt2.setString(8, artista.getText());
                stmt2.setString(9, rutaimagen);

                if (loyalidad.getText().isEmpty()) {

                } else {

                    int loyalidadd = Integer.parseInt(loyalidad.getText());
                    stmt2.setInt(10, loyalidadd);
                }
                if (ataque.getText().isEmpty()) {

                } else {

                    ataquei = ataque.getText();
                    ataqueint = Integer.parseInt(ataquei);

                    stmt2.setInt(11, ataqueint);
                }
                if (defensa.getText().isEmpty()) {

                } else {

                    defensai = defensa.getText();
                    defensaint = Integer.parseInt(defensai);
                    stmt2.setInt(12, defensaint);
                }
                stmt4 = con.prepareStatement("Select Idedicion from edicion where Nombre = ?");

                stmt4.setString(1, Edicion.getSelectionModel().getSelectedItem().Nombre);
                rs = stmt4.executeQuery();
                rs.next();
                stmt2.setInt(13, rs.getInt(1));
                stmt2.setInt(14, 1);
                stmt2.executeUpdate();

            }
            // stmt2.executeUpdate();

            //
            //   Image image = new Image ( new FileInputStream(selectedFile.getAbsolutePath()));
            imagencarta.getImage();

        } catch (SQLException exx) {
            Logger.getLogger(AñadirmenuuController.class.getName()).log(Level.SEVERE, null, exx);
        }

        /*                catch (IOException ex){
                Logger.getLogger(VerViajesController.class.getName()).log(Level.SEVERE, null, ex);
                }
         */
    }

    //    PreparedStatement stmt2 = con.prepareStatement("INSERT INTO carta (Idcarta")
    //    PreparedStatement stmt2 = con.prepareStatement("INSERT INTO carta")
    @FXML
    private void showfoil(ActionEvent event) {

        if (foiltick.isSelected()) {
            preciofoil.setVisible(true);
            existenciasfoil.setVisible(true);
        } else {
            preciofoil.setVisible(false);
            existenciasfoil.setVisible(false);
            preciofoil.clear();
            existenciasfoil.clear();
        }

    }

    @FXML
    private void sumarmana(KeyEvent event) {
    }

}
