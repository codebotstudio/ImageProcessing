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

import static filtrospdi.FiltroBrillo.restringir;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

/**
 *
 * @author danielmonroy
 */
public class Rotacion {
    public static Image rotar90izquierda(Image img){
        WritableImage resultImg = new WritableImage((int)img.getHeight(), (int)img.getWidth());
        PixelReader pixelr = img.getPixelReader();
        PixelWriter pixelw = resultImg.getPixelWriter();
        
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                Color color = pixelr.getColor(j, i);
                int red = (int) (color.getRed() * 255);
                int green = (int) (color.getGreen() * 255);
                int blue = (int) (color.getBlue() * 255);
                pixelw.setColor(i, ((int)resultImg.getHeight() - (j+1)), Color.rgb(red, green, blue));

            }
        }
        
        return resultImg;
    }
    
    public static Image rotar90derecha(Image img){
        WritableImage resultImg = new WritableImage((int)img.getHeight(), (int)img.getWidth());
        PixelReader pixelr = img.getPixelReader();
        PixelWriter pixelw = resultImg.getPixelWriter();
        
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                Color color = pixelr.getColor(j, i);
                int red = (int) (color.getRed() * 255);
                int green = (int) (color.getGreen() * 255);
                int blue = (int) (color.getBlue() * 255);
                pixelw.setColor(((int)resultImg.getWidth() - (i+1)), j, Color.rgb(red, green, blue));

            }
        }
        
        return resultImg;
    }
    
    public static Image rotar180(Image img){
        WritableImage resultImg = new WritableImage((int)img.getWidth(), (int)img.getHeight());
        PixelReader pixelr = img.getPixelReader();
        PixelWriter pixelw = resultImg.getPixelWriter();
        
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                Color color = pixelr.getColor(j, i);
                int red = (int) (color.getRed() * 255);
                int green = (int) (color.getGreen() * 255);
                int blue = (int) (color.getBlue() * 255);
                pixelw.setColor(((int)resultImg.getWidth() - (j+1)), ((int)resultImg.getHeight() - (i+1)), Color.rgb(red, green, blue));

            }
        }
        
        return resultImg;
    }
    
    public static Image espejoV(Image img){
        WritableImage resultImg = new WritableImage((int)img.getWidth(), (int)img.getHeight());
        PixelReader pixelr = img.getPixelReader();
        PixelWriter pixelw = resultImg.getPixelWriter();
        
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                Color color = pixelr.getColor(j, i);
                int red = (int) (color.getRed() * 255);
                int green = (int) (color.getGreen() * 255);
                int blue = (int) (color.getBlue() * 255);
                pixelw.setColor(((int)resultImg.getWidth() - (j+1)), i, Color.rgb(red, green, blue));

            }
        }
        
        return resultImg;
    }
    
    public static Image espejoH(Image img){
        WritableImage resultImg = new WritableImage((int)img.getWidth(), (int)img.getHeight());
        PixelReader pixelr = img.getPixelReader();
        PixelWriter pixelw = resultImg.getPixelWriter();
        
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                Color color = pixelr.getColor(j, i);
                int red = (int) (color.getRed() * 255);
                int green = (int) (color.getGreen() * 255);
                int blue = (int) (color.getBlue() * 255);
                pixelw.setColor(j, (int)resultImg.getHeight() - (i+1), Color.rgb(red, green, blue));

            }
        }
        
        return resultImg;
    }
}
