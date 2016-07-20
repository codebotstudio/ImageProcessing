/*
 * Universidad Nacional Autónoma de México Facultad de Ciencias
 * Licenciatura en Ciencias de la Computación 
 * PROCESO DIGITAL DE IMÁGENES 2016-2 
 * Profesor: Manuel Cristóbal López Michelone 
 * Ayudante: Yessica Martínez Reyes
 *
 * López Monroy Luis Daniel
 * No. Cta.: 311313750
 */
package filtrospdi;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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
    
    // MOSAICO
    @FXML
    private void makeMosaic(ActionEvent mosaic){
        Image result = FiltroMosaico.mosaico(imagePreview.getImage());
        imagePreview.setImage(result);
    }
    
    // BLENDING
    
    // Filtro Blending
    @FXML
    private void blending(ActionEvent blend) throws FileNotFoundException{
        Image a = imagePreview.getImage();
        Image b = openSecondImage();
        if (a.getHeight() != b.getHeight() || a.getWidth() != b.getWidth()){
            return;
        }else{
            Image result = Blending.combinar(a, b);
            imagePreview.setImage(result);
            }
    }
    
    // Método para seleccionar imagen a combinar
    private Image openSecondImage() throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Image Files", "*.png", "*.jpg"));
        File selectedFile = fileChooser.showOpenDialog(null);
            Image image = new Image(new FileInputStream(selectedFile));
            
            return image;
    }
    
    // ROTACIÓN
    
    // Rotar 90 a la derecha
    @FXML 
    private void rota90derecha(ActionEvent rota90der){
        Image result = Rotacion.rotar90derecha(imagePreview.getImage());
        imagePreview.setImage(result);
    } 
    
    // Rotar 90 a la izquierda
    @FXML 
    private void rota90izquierda(ActionEvent rota90izq){
        Image result = Rotacion.rotar90izquierda(imagePreview.getImage());
        imagePreview.setImage(result);
    }
    
    // Rotar 180 a la izquierda
    @FXML 
    private void rota180(ActionEvent rota180){
        Image result = Rotacion.rotar180(imagePreview.getImage());
        imagePreview.setImage(result);
    }
    
    // Espejo vertical
    @FXML 
    private void espejoV(ActionEvent espejoV){
        Image result = Rotacion.espejoV(imagePreview.getImage());
        imagePreview.setImage(result);
    }
    
    // Espejo horizontal
    @FXML 
    private void espejoH(ActionEvent espejoH){
        Image result = Rotacion.espejoH(imagePreview.getImage());
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
    
    // OLEO
    @FXML
    private void showOleo(ActionEvent oleo){
        Image result = FiltroOleo.oleo(imagePreview.getImage());
        imagePreview.setImage(result);
    }
    
    // COMPRIMIR IMAGEN
    
    // Comprimir
    @FXML
    private void compress(ActionEvent compress){
        Comprimir.comprime(imagePreview.getImage());
    }
    
    // Descomprimir
    @FXML
    private void decompress(ActionEvent decompress) throws FileNotFoundException{
        Image result = Comprimir.descomprime(openCompressedImage());
        imagePreview.setImage(result);
    }
    
    // Método para seleccionar archivo
    private File openCompressedImage() throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Data Files", "*.data"));
        File selectedFile = fileChooser.showOpenDialog(null);
            
            return selectedFile;
    }
    
    // FOTOS CON TEXTO
    
    // A color
    @FXML
    private void makeImageOcolor(ActionEvent colorO) throws IOException{
        generaHTML(FiltroTexto.textoColor(imagePreview.getImage()));
    }
    
    // Blanco y negro
    @FXML
    private void makeImageObNw(ActionEvent bNwO) throws IOException{
        generaHTML(FiltroTexto.textoBnW(imagePreview.getImage()));
    }
    
    // Generar HTML
    public void generaHTML(String html) throws IOException{
        FileWriter fw = new FileWriter(new File("Resultados/imagen.html"));
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(html);
            bw.flush();
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
