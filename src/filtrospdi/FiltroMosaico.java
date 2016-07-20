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
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

/**
 *
 * @author danielmonroy
 */
public class FiltroMosaico {
    
    public static Image mosaico(Image img) {
        
        double f = img.getHeight();
        int N = (int) f/150;
        BufferedImage imagen = SwingFXUtils.fromFXImage(img,null);
        /* Recorremos la imagen pixel a pixel. */
        for (int i = 0; i < imagen.getWidth(); i += N) {
            for (int j = 0; j < imagen.getHeight(); j += N) {
                int x = i + N; 
                int y = j + N; 
                int d1 = N;
                int d2 = N;
                /* Revisamos que no se salga del marco. */
                if (x > imagen.getWidth()) {
                    x = imagen.getWidth();
                    d1 = imagen.getWidth() - i;
                }
                if (y > imagen.getHeight()) {
                    y = imagen.getHeight();
                    d2 = imagen.getHeight() - j;
                }
                /* Pintamos la región. */
                pinta(imagen, i, j, x, y, d1 * d2);
            }
        }
        return SwingFXUtils.toFXImage(imagen, null);
    }

    private static void pinta(BufferedImage img, int x, int y, int ancho, int alto, 
            int tot) {
        int r = 0;
        int g = 0;
        int b = 0;
        /* Revisamos cada pixel de la región. */
        for (int i = x; i < ancho; i++) {
            for (int j = y; j < alto; j++) {
                java.awt.Color aux = new java.awt.Color(img.getRGB(i, j));
                /* Sumamos las componentes r, g y b de TODA la región. */
                r += aux.getRed();
                g += aux.getGreen();
                b += aux.getBlue();
            }
        }
        /* Dividimos para obtener el color promedio. */
        r /= tot;
        g /= tot;
        b /= tot;
        /* Aplicamos dicho color promedio a toda la región. */
        for (int i = x; i < ancho; i++) {
            for (int j = y; j < alto; j++) {
                img.setRGB(i, j, new java.awt.Color(r, g, b).getRGB());
            }
        }
    }
}
