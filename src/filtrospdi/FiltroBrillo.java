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
 * @author danielmonroy
 */
public class FiltroBrillo {
    public static Image subirBrillo(Image img){
        WritableImage resultImg = new WritableImage((int)img.getWidth(),(int)img.getHeight());
        PixelReader pixelr = img.getPixelReader();
        PixelWriter pixelw = resultImg.getPixelWriter();
        
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                Color color = pixelr.getColor(j, i);
                int red, green, blue;
                red = (int) ((color.getRed() * 255) + 15);
                green = (int) ((color.getGreen() * 255) + 15);
                blue = (int) ((color.getBlue() * 255) + 15);
                red = restringir(red);
                green = restringir(green);
                blue = restringir(blue);
                pixelw.setColor(j, i, Color.rgb((int)red, (int)green, (int)blue));
            }
        }
        
        return resultImg;
    }
    
    public static Image bajarBrillo(Image img){
        WritableImage resultImg = new WritableImage((int)img.getWidth(),(int)img.getHeight());
        PixelReader pixelr = img.getPixelReader();
        PixelWriter pixelw = resultImg.getPixelWriter();
        
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                Color color = pixelr.getColor(j, i);
                int red, green, blue;
                red = (int) ((color.getRed() * 255) - 15);
                green = (int) ((color.getGreen() * 255) - 15);
                blue = (int) ((color.getBlue() * 255) - 15);
                red = restringir(red);
                green = restringir(green);
                blue = restringir(blue);
                pixelw.setColor(j, i, Color.rgb((int)red, (int)green, (int)blue));
            }
        }
        
        return resultImg;
    }
    
    public static int restringir(int valor){
        if(valor < 0){
            return 0;
        }
        else if(valor > 255){
            return 255;
        }
        else {
            return valor;
        }
        
    }
}
