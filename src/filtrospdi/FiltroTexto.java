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
import javafx.scene.image.PixelReader;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 *
 * @author danielmonroy
 */
public class FiltroTexto {
    
    public static String textoColor(Image img) {
        BufferedImage imagen = SwingFXUtils.fromFXImage(img,null);
        int height = imagen.getHeight() / 10;
        int width = imagen.getWidth() / 10;
        String[][] tabla = new String[height][width];
        String cadena = "<table border = \"0\" cellspacing=\"0\" cellpadding=\"0\"\n";
        int l = 0;
        for (int i = 0; i < imagen.getWidth(); i += 10) {
            int k = 0;
            for (int j = 0; j < imagen.getHeight(); j += 10) {
                int x = i + 10;
                int y = j + 10;
                int d1 = 10;
                int d2 = 10;
                if (x > imagen.getWidth()) {
                    x = imagen.getWidth();
                    d1 = imagen.getWidth() - i;
                }
                if (y > imagen.getHeight()) {
                    y = imagen.getHeight();
                    d2 = imagen.getHeight() - j;
                }
                if (k >= height || l >= width) {
                    break;
                }
                tabla[k++][l] = construyeLetras(imagen, i, j, x, y, d1 * d2);
            }
            l++;
        }
        for (int i = 0; i < height; i++) {
            cadena += "\t<tr>\n";
            for (int j = 0; j < width; j++) {
                cadena += tabla[i][j];
            }
            cadena += "</tr>";
        }
        cadena += "</table>";
        return cadena;
    }
    
    public static String textoBnW(Image img) {
        Image bnw = EscalaGrises.filtroGris(img);
        BufferedImage imagen = SwingFXUtils.fromFXImage(bnw,null);
        int height = imagen.getHeight() / 10;
        int width = imagen.getWidth() / 10;
        String[][] tabla = new String[height][width];
        String cadena = "<table border = \"0\" cellspacing=\"0\" cellpadding=\"0\"\n";
        int l = 0;
        for (int i = 0; i < imagen.getWidth(); i += 10) {
            int k = 0;
            for (int j = 0; j < imagen.getHeight(); j += 10) {
                int x = i + 10;
                int y = j + 10;
                int d1 = 10;
                int d2 = 10;
                if (x > imagen.getWidth()) {
                    x = imagen.getWidth();
                    d1 = imagen.getWidth() - i;
                }
                if (y > imagen.getHeight()) {
                    y = imagen.getHeight();
                    d2 = imagen.getHeight() - j;
                }
                if (k >= height || l >= width) {
                    break;
                }
                tabla[k++][l] = construyeLetras(imagen, i, j, x, y, d1 * d2);
            }
            l++;
        }
        for (int i = 0; i < height; i++) {
            cadena += "\t<tr>\n";
            for (int j = 0; j < width; j++) {
                cadena += tabla[i][j];
            }
            cadena += "</tr>";
        }
        cadena += "</table>";
        return cadena;
    }

    private static String construyeLetras(BufferedImage img, int x, int y, 
            int ancho, int alto, int tot) {
        int r = 0;
        int g = 0;
        int b = 0;
        for (int i = x; i < ancho; i++) {
            for (int j = y; j < alto; j++) {
                java.awt.Color aux = new java.awt.Color(img.getRGB(i, j));
                r += aux.getRed();
                g += aux.getGreen();
                b += aux.getBlue();
            }
        }
        r /= tot;
        g /= tot;
        b /= tot;
        /* CREAMOS EL COLOR DE LA LETRA EN HEXADECIMAL. */
        String hex = String.format("#%02x%02x%02x", r, g, b); // convierte el color a hexadecimal
        return String.format("\t\t<nobr><td><b><font size=\"1\" color=\"%s\">M</font></b></td></nobr>\n", 
                hex);
    }
}
