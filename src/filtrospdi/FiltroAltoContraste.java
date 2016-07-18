/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class FiltroAltoContraste {
    public static Image altoContraste(Image img){
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
                if(gris > 128){
                    gris = 255;
                } else {
                    gris = 0;
                }
                pixelw.setColor(j, i, Color.rgb((int)gris, (int)gris, (int)gris));
            }
        }
        
        return resultImg;
    }
}
