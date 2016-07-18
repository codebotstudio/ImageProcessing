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
public class FiltrosColor {
    
    public static Image filtroRojo(Image img){
        WritableImage resultImg = new WritableImage((int)img.getWidth(),(int)img.getHeight());
        PixelReader pixelr = img.getPixelReader();
        PixelWriter pixelw = resultImg.getPixelWriter();
        
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                Color color = pixelr.getColor(j, i);
                double red;
                red = color.getRed();
                red *= 255;
                pixelw.setColor(j, i, Color.rgb((int)red, 0, 0));
            }
        }
        
        return resultImg;
    }
    
    public static Image filtroVerde(Image img){
        WritableImage resultImg = new WritableImage((int)img.getWidth(),(int)img.getHeight());
        PixelReader pixelr = img.getPixelReader();
        PixelWriter pixelw = resultImg.getPixelWriter();
        
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                Color color = pixelr.getColor(j, i);
                double green;
                green = color.getGreen();
                green *= 255;
                pixelw.setColor(j, i, Color.rgb(0, (int)green, 0));
            }
        }
        
        return resultImg;
    }
    
    public static Image filtroAzul(Image img){
        WritableImage resultImg = new WritableImage((int)img.getWidth(),(int)img.getHeight());
        PixelReader pixelr = img.getPixelReader();
        PixelWriter pixelw = resultImg.getPixelWriter();
        
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                Color color = pixelr.getColor(j, i);
                double blue;
                blue = color.getBlue();
                blue *= 255;
                pixelw.setColor(j, i, Color.rgb(0, 0, (int)blue));
            }
        }
        
        return resultImg;
    }
    
    public static Image filtroCombinado(Image img){
        WritableImage resultImg = new WritableImage((int)img.getWidth(),(int)img.getHeight());
        PixelReader pixelr = img.getPixelReader();
        PixelWriter pixelw = resultImg.getPixelWriter();
        
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                Color color = pixelr.getColor(j, i);
                double blue;
                double green;
                double red;
                blue = color.getBlue();
                green = color.getGreen();
                red = color.getRed();
                blue *= 255;
                green *= 255;
                red *= 255;
                pixelw.setColor(j, i, Color.rgb((int)green, (int)blue, (int)red));
            }
        }
        
        return resultImg;
    }
    
    public static Image blacklight(Image img){
        WritableImage resultImg = new WritableImage((int)img.getWidth(),(int)img.getHeight());
        PixelReader pixelr = img.getPixelReader();
        PixelWriter pixelw = resultImg.getPixelWriter();
        
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                Color color = pixelr.getColor(j, i);
                
                int blue = (int) (color.getBlue()*255);
                int green = (int) (color.getGreen()*255);
                int red = (int) (color.getRed()*255);
                
                int l = (int) ((red + green + blue) / 3);
                
                int r = (Math.abs(red - l) * 2);
                int g = (Math.abs(green - l) * 2);
                int b = (Math.abs(blue - l) * 2);
                
                restringir(r);
                restringir(g);
                restringir(b);
                
                pixelw.setColor(j, i, Color.rgb(r, g, b));
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
