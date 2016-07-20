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
import java.util.LinkedList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

/**
 *
 * @author danielmonroy
 */
public class FiltroOleo {
        public static Image oleo(Image img) {
        BufferedImage imagen = SwingFXUtils.fromFXImage(img, null);
        /* Creamos una copia, para trabajar con ella. */
        BufferedImage nueva = new BufferedImage(imagen.getWidth(),
                imagen.getHeight(), imagen.getType());
        /* Recorremos la imagen pixel a pixel. */
        for (int i = 0; i < imagen.getWidth(); i++) {
            for (int j = 0; j < imagen.getHeight(); j++) {
                int x = i + 7; // dimensiones de la matriz de conv.
                int y = j + 7; // dimensiones de la matriz de conv.
                int d1 = 7;
                int d2 = 7;
                if (x > imagen.getWidth()) { // si se sale de rango en x.
                    x = imagen.getWidth();
                    d1 = imagen.getWidth() - i;
                }
                if (y > imagen.getHeight()) { // si se sale de rango en y.
                    y = imagen.getHeight();
                    d2 = imagen.getHeight() - j;
                }
                /* Aplica el óleo, para ello revisa qué color se está repitiendo
                 más en en la región o vecindad. Una vez que encuentra este
                 color, se lo aplica al pixel actual (en la copia).*/
                nueva.setRGB(i, j, pintaOleo(imagen, i, j, x, y).getRGB());
            }
        }
        imagen = nueva;
        return SwingFXUtils.toFXImage(imagen, null);
    }

    /* Devuelve el color que le corresponde al pixel de interés */
    private static Color pintaOleo(BufferedImage img, int x, int y, int ancho, int alto) {
        /* Estas listas se recorren simultáneamente. */
        LinkedList<Color> colores = new LinkedList<>(); // histograma de colores
        LinkedList<Integer> veces = new LinkedList<>(); // histograma de repeticiones
        /* Recorremos la región. */
        for (int i = x; i < ancho; i++) {
            for (int j = y; j < alto; j++) {
                /* Obtenemos el color actual. */
                Color aux = new Color(img.getRGB(i, j));
                if (!colores.contains(aux)) { // si no está, lo agrega.
                    colores.add(aux);
                    veces.add(1); // aparece 1 vez.
                } else { // si ya está, actualizamos las repeticiones.
                    actualiza(colores, veces, aux);
                }
            }
        }
        /* Devuelve el color que se repitió más veces. */
        return maximo(colores, veces);
    }

    /* Método auxiliar que aumenta el número de veces que aparece un color. */
    private static void actualiza(LinkedList<Color> list, LinkedList<Integer> list2, 
            Color v) {
        for (int i = 0; i < list.size(); i++) {
            if (v.equals(list.get(i))) { // buscamos el color actual.
                int aux = list2.get(i);
                /* Aumentamos su repetición en la lista correspondiente. */
                aux += 1;
                list2.set(i, aux);
            }
        }
    }

    /* Determina el color que más se repitió en una lista. */
    private static Color maximo(LinkedList<Color> colores, LinkedList<Integer> veces) {
        int indmayor = 0;
        int mayor = 0;
        int x = 0;
        for (Integer i : veces) {
            if (i > mayor) { // si es mayor, actualizamos el índice.
                mayor = i;
                indmayor = x;
            }
            x++;
        }
        /* Devolvemos el color en el índice con mayor número de repeticiones. */
        return colores.get(indmayor);
    }
}
