/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtrospdi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 *
 * @author daniel
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ImageView imagePreview;

    @FXML
    private void openImage(ActionEvent openImg) throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Image Files", "*.png", "*.jpg"));
        File selectedFile = fileChooser.showOpenDialog(null); //Aqui debo poner el Stage
        if (selectedFile != null) {
            Image image = new Image(new FileInputStream(selectedFile));
            imagePreview.setImage(image);
        }
    }

    @FXML
    private void closeWindow(ActionEvent close) {
        System.exit(0);
    }
    
    @FXML
    private void showGrayImage(ActionEvent grayImg){
        Image result = EscalaGrises.filtroGris(imagePreview.getImage());
        imagePreview.setImage(result);
    }
    
    @FXML
    private void showGrayRed(ActionEvent grayRed){
        Image result = EscalaGrises.filtroGrisRojo(imagePreview.getImage());
        imagePreview.setImage(result);
    }
    
    @FXML
    private void showGrayGreen(ActionEvent grayGreen){
        Image result = EscalaGrises.filtroGrisVerde(imagePreview.getImage());
        imagePreview.setImage(result);
    }
    
    @FXML
    private void showGrayBlue(ActionEvent grayBlue){
        Image result = EscalaGrises.filtroGrisAzul(imagePreview.getImage());
        imagePreview.setImage(result);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
