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

import java.awt.Color;
import java.awt.image.BufferedImage;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

/**
 *
 * @author danielmonroy
 */
public class Blending {
    
    public static Image combinar(Image primera, Image segunda) {
        double alpha = 0.5;
        BufferedImage imagen = SwingFXUtils.fromFXImage(primera,null);
        BufferedImage otra = SwingFXUtils.fromFXImage(segunda,null);
        /* Recorremos la imagen pixel por pixel */
        for (int i = 0; i < imagen.getWidth(); i++) {
            for (int j = 0; j < imagen.getHeight(); j++) {
                /* Obtiene el color del pixel actual de cada imagen */
                Color aux1 = new Color(imagen.getRGB(i, j));
                Color aux2 = new Color(otra.getRGB(i, j));
                /* Color en rojo. */
                int br = 
                    (int) ((aux1.getRed() * alpha) 
                        + (aux2.getRed() * (1.0 - alpha)));
                /* Color en verde. */
                int bg = 
                    (int) ((aux1.getGreen() * alpha) 
                        + (aux2.getGreen() * (1.0 - alpha)));
                /* Color en azul. */
                int bb = 
                    (int) ((aux1.getBlue() * alpha) 
                        + (aux2.getBlue() * (1.0 - alpha)));
                Color nuevo = new Color(br, bg, bb);
                /* Establece el nuevo color al pixe */
                imagen.setRGB(i, j, nuevo.getRGB());
            }
        }
        return SwingFXUtils.toFXImage(imagen, null);
    }
}
