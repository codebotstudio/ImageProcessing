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

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

/**
 *
 * @author daniel
 */
public class EscalaGrises {
    
    
    /*
    *   Escala de grises
    */
    public static Image filtroGris(Image img){
        WritableImage resultImg = new WritableImage((int)img.getWidth(),(int)img.getHeight());
        PixelReader pixelr = img.getPixelReader();
        PixelWriter pixelw = resultImg.getPixelWriter();
        
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                Color color = pixelr.getColor(j, i);
                double red, green, blue;
                red = color.getRed();
                green = color.getGreen();
                blue = color.getBlue();
                red *= 255;
                green *= 255;
                blue *= 255;
                double gris = (red + green + blue)/3;
                pixelw.setColor(j, i, Color.rgb((int)gris, (int)gris, (int)gris));
            }
        }
        
        return resultImg;
    }
    
    /*
    *   Escala de grises con rojo
    */
    public static Image filtroGrisRojo(Image img){
        WritableImage resultImg = new WritableImage((int)img.getWidth(),(int)img.getHeight());
        PixelReader pixelr = img.getPixelReader();
        PixelWriter pixelw = resultImg.getPixelWriter();
        
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                Color color = pixelr.getColor(j, i);
                double red;
                red = color.getRed();
                red *= 255;
                pixelw.setColor(j, i, Color.rgb((int)red, (int)red, (int)red));
            }
        }
        
        return resultImg;
    }
    
    /*
    *   Escala de grises con verde
    */
    public static Image filtroGrisVerde(Image img){
        WritableImage resultImg = new WritableImage((int)img.getWidth(),(int)img.getHeight());
        PixelReader pixelr = img.getPixelReader();
        PixelWriter pixelw = resultImg.getPixelWriter();
        
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                Color color = pixelr.getColor(j, i);
                double green;
                green = color.getGreen();
                green *= 255;
                pixelw.setColor(j, i, Color.rgb((int)green, (int)green, (int)green));
            }
        }
        
        return resultImg;
    }
    
    /*
    *   Escala de grises con azul
    */
    public static Image filtroGrisAzul(Image img){
        WritableImage resultImg = new WritableImage((int)img.getWidth(),(int)img.getHeight());
        PixelReader pixelr = img.getPixelReader();
        PixelWriter pixelw = resultImg.getPixelWriter();
        
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                Color color = pixelr.getColor(j, i);
                double blue;
                blue = color.getBlue();
                blue *= 255;
                pixelw.setColor(j, i, Color.rgb((int)blue, (int)blue, (int)blue));
            }
        }
        
        return resultImg;
    }
}
