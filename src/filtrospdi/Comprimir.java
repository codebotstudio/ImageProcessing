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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

/**
 *
 * @author danielmonroy
 */
public class Comprimir {
    
    public static void comprime(Image img) {
        BufferedImage imagen = SwingFXUtils.fromFXImage(img,null);
        try {
            FileWriter fw = new FileWriter(new File("Resultados/imagen_comprimida.data"));
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(imagen.getWidth() + " " + imagen.getHeight() + "\n");
            bw.flush();
            for (int i = 0; i < imagen.getWidth(); i++) {
                for (int j = 0; j < imagen.getHeight(); j++) {
                    Color aux = new Color(imagen.getRGB(i, j));
                    int promedio = (int)((aux.getRed() + aux.getGreen() + aux.getBlue()) / 3);
                    bw.write(Integer.toHexString(promedio) + " ");
                    bw.flush();
                }
                bw.write("\n");
                bw.flush();
            }
            
        } catch (IOException e) { }
    }

    public static Image descomprime(File archivo) {
        if (archivo == null)
            return null;
        BufferedImage nueva = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int ancho = Integer.parseInt(tk.nextToken());
            int alto = Integer.parseInt(tk.nextToken());
            nueva = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
            int j = 1;
            for (int i = 0; i < ancho; i++) {
                String linea = br.readLine();
                if (linea == null)
                    continue;
                tk = new StringTokenizer(linea);
                int contador = 0;
                while (tk.hasMoreTokens()) {
                    int color = Integer.parseInt(tk.nextToken(), 16);
                    nueva.setRGB(i, contador++, new Color(color, color, color).getRGB());
                }
                System.out.println(j++);
            }
        } catch(FileNotFoundException e) { 
        } catch(IOException e) { }
        return SwingFXUtils.toFXImage(nueva, null);
    }
}
