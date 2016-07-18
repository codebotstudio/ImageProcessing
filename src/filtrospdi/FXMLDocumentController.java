/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtrospdi;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javax.imageio.ImageIO;

/**
 *
 * @author daniel
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ImageView imagePreview;
    
    @FXML
    private ImageView originalImage;

    @FXML
    private void openImage(ActionEvent openImg) throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Image Files", "*.png", "*.jpg"));
        File selectedFile = fileChooser.showOpenDialog(null); //Aqui debo poner el Stage
        if (selectedFile != null) {
            Image image = new Image(new FileInputStream(selectedFile));
            originalImage.setImage(image);
            imagePreview.setImage(image);
        }
    }
    
    //  Limpiar Imagen
    @FXML
    private void clearImage(ActionEvent clearImage){
        if (originalImage != null) {
            Image original = originalImage.getImage();
            imagePreview.setImage(original);
        }
    }
    
    //  Terminar programa
    @FXML
    private void closeWindow(ActionEvent close) {
        System.exit(0);
    }
    
    // Filtro gris
    @FXML
    private void showGrayImage(ActionEvent grayImg){
        Image result = EscalaGrises.filtroGris(imagePreview.getImage());
        imagePreview.setImage(result);
    }
    
    // Filtro gris con Rojos
    @FXML
    private void showGrayRed(ActionEvent grayRed){
        Image result = EscalaGrises.filtroGrisRojo(imagePreview.getImage());
        imagePreview.setImage(result);
    }
    
    //Filtro gris con Verdes
    @FXML
    private void showGrayGreen(ActionEvent grayGreen){
        Image result = EscalaGrises.filtroGrisVerde(imagePreview.getImage());
        imagePreview.setImage(result);
    }
    
    // Filtro gris con Azules
    @FXML
    private void showGrayBlue(ActionEvent grayBlue){
        Image result = EscalaGrises.filtroGrisAzul(imagePreview.getImage());
        imagePreview.setImage(result);
    }
    
    // Filtro con Rojo
    @FXML
    private void showRed(ActionEvent red){
        Image result = FiltrosColor.filtroRojo(imagePreview.getImage());
        imagePreview.setImage(result);
    }
    
    // Filtro con Verde
    @FXML
    private void showGreen(ActionEvent green){
        Image result = FiltrosColor.filtroVerde(imagePreview.getImage());
        imagePreview.setImage(result);
    }
    
    // Filtro con Azul
    @FXML
    private void showBlue(ActionEvent blue){
        Image result = FiltrosColor.filtroAzul(imagePreview.getImage());
        imagePreview.setImage(result);
    }
    
    // Filtro combinacion RGB
    @FXML
    private void showRGBCombination(ActionEvent combination){
        Image result = FiltrosColor.filtroCombinado(imagePreview.getImage());
        imagePreview.setImage(result);
    }
    
    // Filtro Luz negra
    @FXML
    private void showBlacklight(ActionEvent blacklight){
        Image result = FiltrosColor.blacklight(imagePreview.getImage());
        imagePreview.setImage(result);
    }
    
    // Filtro Negativo
    @FXML
    private void showNegative(ActionEvent negative){
        Image result = FiltroNegativo.filtroNegativo(imagePreview.getImage());
        imagePreview.setImage(result);
    }
    
    //Filtro Alto Contraste
    @FXML
    private void showHighContrast(ActionEvent negative){
        Image result = FiltroAltoContraste.altoContraste(imagePreview.getImage());
        imagePreview.setImage(result);
    }
    
    // Filtro ATnT
    @FXML
    private void showAtnt(ActionEvent atnt){
        Image result = ATnT.filtra(imagePreview.getImage());
        imagePreview.setImage(result);
    }
    
    // BRILLO
    
    // Aumenta brillo
    @FXML
    private void increaseBrightness(ActionEvent upB){
        Image result = FiltroBrillo.subirBrillo(imagePreview.getImage());
        imagePreview.setImage(result);
    }
    
    // Disminuye brillo
    @FXML
    private void decreaseBrightness(ActionEvent downB){
        Image result = FiltroBrillo.bajarBrillo(imagePreview.getImage());
        imagePreview.setImage(result);
    }
    
    // FILTROS CONVOLUSION
    
    // Blur
    @FXML
    private void showBlur(ActionEvent blur){
        Image result = FiltroConvolucion.blur(imagePreview.getImage());
        imagePreview.setImage(result);
    }
    
    // Motion Blur
    @FXML
    private void showMotionBlur(ActionEvent motionBlur){
        Image result = FiltroConvolucion.motionBlur(imagePreview.getImage());
        imagePreview.setImage(result);
    }
    
    // Find Edges
    @FXML
    private void showFindEdges(ActionEvent findEdges){
        Image result = FiltroConvolucion.findEdges(imagePreview.getImage());
        imagePreview.setImage(result);
    }
    
    // Sharpen
    @FXML
    private void showSharpen(ActionEvent sharpen){
        Image result = FiltroConvolucion.sharpen(imagePreview.getImage());
        imagePreview.setImage(result);
    }
    
    // Emboss
    @FXML
    private void showEmboss(ActionEvent emboss){
        Image result = FiltroConvolucion.emboss(imagePreview.getImage());
        imagePreview.setImage(result);
    }
    
    // Mean
    @FXML
    private void showMean(ActionEvent mean){
        Image result = FiltroConvolucion.mean(imagePreview.getImage());
        imagePreview.setImage(result);
    }
    
    // Guardar imagen
    @FXML
    private void saveImageFiltered(ActionEvent save){
        saveImage(imagePreview.getImage());
    }
    
    public static void saveImage(Image image) {
    File outputFile = new File("Resultados/Nueva_Imagen.png");
    BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
    try {
      ImageIO.write(bImage, "png", outputFile);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
