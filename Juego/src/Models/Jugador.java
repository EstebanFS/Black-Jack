/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import javax.swing.ImageIcon;
/**
 *
 * @author Chucho
 */
public class Jugador {
    Carta mano[];
    
    public Jugador(){
        this.mano = new Carta[10];
    }
    
    public void setCarta(Carta carta, int posCarta) {
        mano[posCarta] = carta;
    }
    
    
    public void borrar() {
        for (int j = 0; j < 10; j++) {
            mano[j] = null;
        }
    }
    
    public int ValorMano(int jugador) {
        int cuenta = 0;
        int numeroAs = 0;
        for (int i = 0; i < 10; i++) {

            if (mano[i] != null) {
                if (mano[i].getEspecificacion().equals("As")) {
                    numeroAs++;
                } 
                    cuenta = cuenta + mano[i].getValor();
                    if(jugador!=0){
                        System.out.println("La carta  # " + (i + 1) + "  es : " 
                                + mano[i].getEspecificacion() + " de " 
                                + mano[i].getPinta());
                    }
            }
        }
        if (numeroAs != 0) {
            for (int j = 1; j <= numeroAs; j++) {
                if (cuenta > 21) {
                    cuenta = cuenta - 10;
                }
            }
        }
        return cuenta;
    }
    
    
    public ImageIcon getCartaCroupier(int posicion) {
        ImageIcon cartaImagen;
        if (mano[posicion] != null) {
            cartaImagen = mano[posicion].getImagen();
            System.out.println(mano[posicion].getImagen());
            return cartaImagen;
        }else{
        cartaImagen = new ImageIcon("Invertida1.gif");
        return cartaImagen;
        }

    }
    /**
     * Este metodo da un valor de la mano del Croupier y dice cuales son sus
     * cartas y retorna este mismo valor
     *
     * @return
     */
    public void ManoCroupier() {
        for (int i = 0; i < 10; i++) {
            if (mano[i] == null) {
            } else {
                System.out.println("La carta  # " + (i + 1) + "  es : " 
                        + mano[i].getValor() + " de " 
                        + mano[i].getPinta());
                /*
                 * ImageIcon estaac= jugadores[0][i].imagen;
                 * prueba[0][i].setIcon(estaac); prueba[0][i].setVisible(true);
                 *
                 */
            }
        }
    }
}
    
    

