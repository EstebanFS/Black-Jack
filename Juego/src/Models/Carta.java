package Models;

import javax.swing.ImageIcon;
/**
 * La clase carta permite crear los objetos mas importantes que vamos a utilizar
 * durante todo el juego
 *
 * @author esteban
 */
public class Carta {

   private int valor;

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setEspecificacion(String especificacion) {
        this.especificacion = especificacion;
    }

    public void setPinta(String pinta) {
        this.pinta = pinta;
    }

    public void setGetImagen(ImageIcon getImagen) {
        this.getImagen = getImagen;
    }
   private String especificacion;

    public int getValor() {
        return valor;
    }

    public String getEspecificacion() {
        return especificacion;
    }

    public String getPinta() {
        return pinta;
    }

    public ImageIcon getImagen() {
        return getImagen;
    }
   private String pinta;
   private ImageIcon getImagen;

    /**
     * el contructor de carta recive como parametro el valor, la pinta, y la
     * especificacion para con estas crear la carta que va a ser utilizada en el
     * juego y a su vez la getImagen que sera utilizada para la interfaz
     *
     * @param nvalor
     * @param npinta
     * @param nespecificacion
     */
    public Carta(int nvalor, String npinta, String nespecificacion) {
        valor = nvalor;
        especificacion = nespecificacion;
        pinta = npinta;
        getImagen = new ImageIcon(npinta + nespecificacion + ".gif");
    }
}
