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
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import javafx.scene.image.Image;
import javafx.embed.swing.SwingFXUtils;

/**
 *
 * @author danielmonroy
 */
public class ATnT {

    static Image filtra(Image src) {
        double f = src.getHeight();
        int N = (int) f/50;
        Image pre = FiltroAltoContraste.altoContraste(src);
        BufferedImage ac = SwingFXUtils.fromFXImage(pre,null);
        
        int w = ac.getWidth();
        int h = ac.getHeight();
        Raster rac = ac.getData();
        BufferedImage nueva = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        WritableRaster wrn = nueva.getRaster();
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h - N; j += N) {
                int puntos = 0;
                for (int y = j; y < j + N; y++) {
                    if (rac.getSample(i, y, 0) == 0) {
                        puntos++;
                    }
                }
                
                boolean[] acomodados = centra(N, puntos);
                for (int y = j; y < j + N; y++) {
                    if (acomodados[y - j]) {
                        wrn.setSample(i, y, 0, 0);
                        wrn.setSample(i, y, 1, 0);
                        wrn.setSample(i, y, 2, 0);
                    } else {
                        wrn.setSample(i, y, 0, 0xff);
                        wrn.setSample(i, y, 1, 0xff);
                        wrn.setSample(i, y, 2, 0xff);
                    }
                }
            }
        }
        lineas(nueva);
        return SwingFXUtils.toFXImage(nueva, null);
    }

  
    private static void lineas(BufferedImage src) {
        double f = src.getHeight();
        int N = (int) f/50;
        WritableRaster wr = src.getRaster();
        for (int i = 0; i < wr.getWidth(); i++) {
            for (int j = 0; j < wr.getHeight() - N; j += N) {
                wr.setSample(i, j, 0, 0xff);
                wr.setSample(i, j, 1, 0xff);
                wr.setSample(i, j, 2, 0xff);
            }
        }
    }

    private static boolean[] centra(int tam, int puntos) {
        boolean[] acomodados = new boolean[tam];
        int n = puntos / 2;
        int m = puntos % 2 == 0 ? n - 1 : n;
        for (int i = (tam / 2) - n; i <= (tam / 2) + m; i++) {
            acomodados[i] = true;
        }
        return acomodados;
    }
}
