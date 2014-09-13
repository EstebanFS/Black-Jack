package Views;

import Controller.Juego;
import Models.Carta;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Interfaz extends JFrame{
    private JLabel prueba[][];
    private JLabel condicion[];
    private JLabel fondo;
    private JLabel estadoJugador[];
    private Carta  crupier[];
    private JLabel turnoJugador;
    private JLabel sumaJugador;
    private JLabel sumaCroupier;
    private JLabel puntuacionJugadores[];
    private JLabel imagenEstado[];
    private JLabel imagenGanar[];
    private JLabel resultadoCroupier;
    private JLabel posicionJugador[];
    public Interfaz(){
        
    }

    public void setEstadoJugador(int posicionEstadoJugador, String text) {
        this.estadoJugador[posicionEstadoJugador].setText(text);
    }
    /**
     * El crear interfaz crea todo lo relacionado ocn la pantalla de inicio y lo
     * que se va a mostrar dentro de la misma lo JLabel que contienen las
     * imagenes de las cartas entr otros.
     */
    
    public void crearInterfaz() {
        fondo = new JLabel();
        crupier = new Carta[10];
        turnoJugador = new JLabel();
        sumaJugador = new JLabel();
        sumaCroupier = new JLabel();
        resultadoCroupier = new JLabel();
        setTitle("EFS...BlackJack");
        setSize(1290, 800);
        setLayout(null);
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.GRAY);
        sumaJugador.setBounds(1185, 200, 130, 180);
        turnoJugador.setBounds(1185, 40, 130, 180);
        sumaCroupier.setBounds(1185, 250, 130, 180);
        sumaJugador.setForeground(Color.green);
        resultadoCroupier.setBounds(1185, 270, 130, 180);
        resultadoCroupier.setForeground(Color.green);
        resultadoCroupier.setFont(new Font("Serif", Font.BOLD, 20));
        getContentPane().add(resultadoCroupier);
        sumaCroupier.setForeground(Color.green);
        sumaJugador.setFont(new Font("Serif", Font.BOLD, 20));
        turnoJugador.setForeground(Color.green);
        turnoJugador.setFont(new Font("Serif", Font.BOLD, 25));
        sumaCroupier.setFont(new Font("Serif", Font.BOLD, 20));
        getContentPane().add(turnoJugador);
        getContentPane().add(sumaJugador);
        getContentPane().add(sumaCroupier);
        sumaJugador.setText("");
        turnoJugador.setText("");
        sumaCroupier.setText("");
        resultadoCroupier.setText("");
        resultadoCroupier.setText("");
        // Carta cartaf = new Carta(1,"mesa","1");
    }
    /**
     * Esta funcion recive como parametro el numero de jugadores y permite
     * iniciar las partes que van encima de la interfaz como los JLabel donde
     * iran futuramente las cartas
     *
     * @param numeroJugadores
     */
     public void tapar(int numeroJugadores) {
        Carta carta = new Carta(1, "Invertida", "1");
        ImageIcon imagenInvertida = carta.getImagen();
        ImageIcon imagenPierdeGana = new ImageIcon("chulo.gif");
        ImageIcon imagenJugadorActual = new ImageIcon("personaje.gif");
        resultadoCroupier.setText("");
        for (int i = 0; i <= numeroJugadores; i++) {
            for (int j = 0; j < 10; j++) {
                prueba[i][j] = new JLabel();
                imagenEstado[i] = new JLabel();
                imagenGanar[i] = new JLabel();
                posicionJugador[i] = new JLabel();
                posicionJugador[i].setBounds(45 + (150 * i), 660, 120, 160);
                prueba[i][j].setBounds(150 * i, 10 + (60 * j), 120, 160);
                imagenEstado[i].setBounds(90 + (150 * i), 640, 120, 160);
                imagenGanar[i].setBounds(107 + (150 * i), 670, 120, 160);
                getContentPane().add(prueba[i][j]);
                getContentPane().add(posicionJugador[i]);
                getContentPane().add(imagenEstado[i]);
                getContentPane().add(imagenGanar[i]);
                //prueba[i][j].setIcon(esta);
                prueba[i][j].setIcon(new ImageIcon(getClass()
                        .getResource("/Sources/" + imagenInvertida)));
                prueba[i][j].setVisible(true);
                //ganaimg[i].setIcon(pierdeGanaImg);
                posicionJugador[i].setIcon(new ImageIcon(getClass()
                        .getResource("/Sources/" + imagenJugadorActual)));
                posicionJugador[i].setVisible(false);
                sumaJugador.setText("");
                turnoJugador.setText("");
                sumaCroupier.setText("");
                resultadoCroupier.setText("");
            }
        }
    }

    public void setSumaJugadorText(String text) {
        this.sumaJugador.setText(text);
    }

    public void setPosjugadorVisible(int posicionJugador, Boolean valor) {
        this.posicionJugador[posicionJugador].setVisible(valor);
    }
    
    
    
     /**
     * Este metodo permite reestablecer Toda la interfaz a como estaba en el
     * inicio del juego para asi crear una nueva ronda, recive como parametro el
     * numero de jugadores
     *
     * @param numeroJugadores
     */
    public void iniciar(int numeroJugadores) {
        Carta carta = new Carta(1, "Invertida", "1");
        ImageIcon imagen = carta.getImagen();
        ImageIcon sinImagen = new ImageIcon("");
        resultadoCroupier.setText("");
        for (int i = 0; i <= numeroJugadores; i++) {
            for (int j = 0; j < 10; j++) {
                //prueba[i][j].setIcon(esta);
                prueba[i][j].setIcon(new ImageIcon(getClass()
                        .getResource("/Sources/" + imagen)));
                prueba[i][j].setVisible(true);
                condicion[i].setText("");
                estadoJugador[i].setText("");
                //estadoimg[i].setIcon(nd);
                imagenEstado[i].setIcon(new ImageIcon(getClass()
                        .getResource("/Sources/" + sinImagen)));
                //ganaimg[i].setIcon(nd);
                imagenGanar[i].setIcon(new ImageIcon(getClass()
                        .getResource("/Sources/" + sinImagen)));
                //posjugador[i].setIcon(new ImageIcon(getClass()
                                //.getResource("/cartas/"+nd)));
                posicionJugador[i].setVisible(false);
            }
        }
    }
    
    public void inicializarAtributos(int numeroJugadores){
        prueba = new JLabel[numeroJugadores][10];
        condicion = new JLabel[numeroJugadores];
        estadoJugador = new JLabel[numeroJugadores];
        puntuacionJugadores = new JLabel[numeroJugadores];
        imagenEstado = new JLabel[numeroJugadores];
        imagenGanar = new JLabel[numeroJugadores];
        posicionJugador = new JLabel[numeroJugadores];
        
        for (int j = 0; j < numeroJugadores; j++) {
            puntuacionJugadores[j] = new JLabel();
            puntuacionJugadores[j].setBounds(1185, 300 + (50 * j), 140, 180);
            puntuacionJugadores[j].setForeground(Color.green);
            puntuacionJugadores[j].setFont(new Font("Serif", Font.BOLD, 20));
            puntuacionJugadores[j].setText("");
            getContentPane().add(puntuacionJugadores[j]);
        }
        for (int i = 0; i < numeroJugadores; i++) {
            condicion[i] = new JLabel();
            estadoJugador[i] = new JLabel();
            estadoJugador[i].setBounds(10 + (150 * i), 650, 130, 180);
            condicion[i].setBounds(10 + (150 * i), 625, 130, 180);
            getContentPane().add(condicion[i]);
            getContentPane().add(estadoJugador[i]);
            Font auxFont = condicion[i].getFont();
            condicion[i].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 15));
            condicion[i].setForeground(Color.green);
            Font auxFont1 = estadoJugador[i].getFont();
            estadoJugador[i].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 15));
            condicion[i].setForeground(Color.green);
            estadoJugador[i].setText("este es el estado");
            condicion[i].setText("este es la condicion");
            //estado[i].setText("HOLAAAAA");
        }
    }
    
    public void fondo(){
        ImageIcon imagenFondo = new ImageIcon("copia.jpg");
        fondo.setBounds(0, -90, 1290, 900);
        getContentPane().add(fondo);
        fondo.setIcon(new ImageIcon(getClass().getResource("/Sources/" + imagenFondo)));
        fondo.setOpaque(false);    
    }

    public void setTurnoJugadorText(String text) {
        this.turnoJugador.setText(text);
    }
    
    public void repartirInterfaz(ImageIcon cartaMazo, int jugador, int posicion){
         prueba[jugador][posicion].setIcon(new ImageIcon(getClass()
                          .getResource("/Sources/" + cartaMazo)));
         prueba[jugador][posicion].setVisible(true);
    }
    
    public void plantar(int posicion){
        condicion[posicion].setText("Planto");
        ImageIcon imagen = new ImageIcon("chulo.gif");                
        imagenEstado[posicion].setIcon(new ImageIcon(getClass().
                        getResource("/Sources/" + imagen)));
    }
    
    public void blackJack(int posicion){
           Font auxFont = condicion[posicion].getFont();
           condicion[posicion].setFont(new Font(auxFont.
                        getFontName(), auxFont.getStyle(), 20));
           condicion[posicion].setText("B...J");
           ImageIcon imagen = new ImageIcon("chulo.gif");
           imagenEstado[posicion].setIcon(new ImageIcon(getClass().
                       getResource("/Sources/" + imagen)));    
    }
    
    public void perderPaso(int posicion){
         condicion[posicion].setText("Te Pasaste");
         ImageIcon perder = new ImageIcon("stop.gif");                 
         imagenEstado[posicion].setIcon(new ImageIcon(getClass().getResource("/Sources/" + perder)));
    }

    public void setSumaCroupierText(String text) {
        this.sumaCroupier.setText(text);
    }

    public void setResultadoCroupierText(String text) {
        this.resultadoCroupier.setText(text);
    }
    
    public void ganar(int posicion){
        ImageIcon gano = new ImageIcon("bn.gif");     
        imagenGanar[posicion].setIcon(new ImageIcon(getClass().getResource("/Sources/" + gano)));
        estadoJugador[posicion].setText("GANASTE");
    }
    
    public void perder(int posicion){
        estadoJugador[posicion].setText("PERDISTE");
        ImageIcon pierde = new ImageIcon("mal.gif");                                   
        imagenGanar[posicion].setIcon(new ImageIcon(getClass().getResource("/Sources/" + pierde)));    
    }
    
    public void empate(int posicion){
        estadoJugador[posicion].setText("EMPATE");
        ImageIcon empate = new ImageIcon("para.gif");                                  
        imagenGanar[posicion].setIcon(new ImageIcon(getClass().getResource("/Sources/" + empate)));   
    }
    
    public void setCartasCroupier(int posicion, ImageIcon imagen){
         prueba[0][posicion].setIcon(new ImageIcon(getClass().getResource("/Sources/" + imagen)));
         prueba[0][posicion].setVisible(true);
    }

    public void setPuntuacionJugadoresText(int posicion,String text) {
        this.puntuacionJugadores[posicion].setText(text);
    }
    
    
    public static void main(String[] args){
        Juego juego = new Juego();
    }    
}
