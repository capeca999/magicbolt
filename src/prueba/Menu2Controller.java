/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DAW
 */
public class Menu2Controller implements Initializable {

    private Button cerrarboton;
    private TextField textarea1;
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
    private ImageView negroicono;
    private ImageView blancoicono;
    @FXML
    private ImageView azulicono;
    @FXML
    private ImageView verdeicono;
    @FXML
    private ImageView rojoicono;
    @FXML
    private Button blancoboton;
    @FXML
    private Button negroboton;
    @FXML
    private Button azulboton;
    @FXML
    private Button verdeboton;
    @FXML
    private Button rojoboton;
    @FXML
    private ImageView blancoicon;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void cerrar(ActionEvent event) {
        
        Stage stage = (Stage) cerrarboton.getScene().getWindow();
        stage.close();
        
    }
    
    public void initVariable(String info){
        textarea1.setText(info);
    }

    
    private void comprobarmana(){
        if (negrolabel.getText().length()==0){
            negroicono.setVisible(false);
        }
        if (blancolabel.getText().length()==0){
            blancoicono.setVisible(false);
        }
        if (azullabel.getText().length()==0){
            azulicono.setVisible(false);
        }
        
        if (verdelabel.getText().length()==0){
            verdeicono.setVisible(false);
        }
        if (rojolabel.getText().length()==0){
            rojoicono.setVisible(false);
        }
    }
    
    @FXML
    private void sumarmana(KeyEvent event) {
        int blancoo=0;
       String blancot="";
       String negrot="";
       String azult="";
       String verdet="";
       String rojot="";
       
        
        int negro=0;
        int azul=0;
        int verde=0;
       int rojo=0;
        String swap="";
       Button btn = (Button) event.getSource();
       String id = btn.getId();
       
        if (id.equals("blancoboton")){
            blancot=blancolabel.getText();
            
            Integer result = Integer.valueOf(blancot);
            result++;
            swap= String.valueOf(result);
            
         
         
            blancolabel.setText(swap);
        }
        else if (id.equals("negroboton")){
            negrot=negrolabel.getText();
            
           Integer resultn= Integer.valueOf(negrot);
           resultn++;
           swap= String.valueOf(resultn);
           
           
           negrolabel.setText(swap);
        }
        
        else if (id.equals("azulboton")){
            azult= azullabel.getText();
            
            Integer resulta= Integer.valueOf(azult);
            resulta++;
            swap = String.valueOf(resulta);
            azullabel.setText(swap);
            
        }
        
        else if (id.equals("verdeboton")){
            verdet= verdelabel.getText();
            Integer resultv= Integer.valueOf(verdet);
            resultv++;
            swap = String.valueOf(resultv);
            verdelabel.setText(swap);
            
        }
        else if (id.equals("rojoboton")){
        rojot= rojolabel.getText();
        Integer resultr= Integer.valueOf(rojot);
        resultr++;
        swap= String.valueOf(resultr);
        rojolabel.setText(swap);
        
        
        this.comprobarmana();
        
    }
        
    }
    
}
