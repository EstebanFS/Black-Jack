package Controller;

import Models.Jugador;
import Models.Mazo;
import Views.Interfaz;
import java.util.Random;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Aca se declaran y se instancian las partes utilizadas para el desarrollo de
 * la interfaz y algunos de los objetos que se van a utilizar en el mismo
 *
 * @author esteban
 */
public class Juego {
    private Mazo mazo;
    private Jugador jugadores[];
    private Interfaz interfaz;
    /**
     * Este metodo permite conocer la carta del jugador que recive como
     * parametro y returna el valor total de la misma
     *
     * @param jugador
     * @return
     */
    public int LlamarValorMano(int jugador) {
        int answer = jugadores[jugador].ValorMano(jugador);
        System.out.print("La suma de Las cartas del Jugador " + jugador + " es: ");
        System.out.println(answer);
        System.out.println("");
        return answer;
    }

    /**
     * En esta clase permite repartir una carta aleatoria del mazo al jugador y
     * a la posicion de su baraja que recive como parametro
     *
     * @param jugador
     * @param posicion
     */
    public void Repartir(int jugador, int posicion) {

        Random azar = new Random();
        for (int i = 1; i <= 1; i++) {
            int posicionCartaMazo = azar.nextInt(52);
            if (mazo.getCarta(posicionCartaMazo) == null) {
                i--;
            } else {
                    jugadores[jugador].setCarta(mazo.getCarta(posicionCartaMazo), posicion);
                    interfaz.repartirInterfaz(mazo.getCarta(posicionCartaMazo).getImagen(), jugador, posicion);
                    mazo.borraCarta(posicionCartaMazo);   
            }
        }
    }

    /**
     * Esta Funcion permite retrasar el proceso siguiente como sean los
     * milisegundos ingresados por parametro
     *
     * @param milliSegundos
     */
    public void sleep(int milliSegundos) {
        long inicio = new Date().getTime();
        while ((new Date().getTime() - inicio) < milliSegundos) {
        }
    }

    /**
     * En el constructor del juego se lleva a cavo todas las operaciones
     * necesarias para el funcionamiento del juego desde el uso de los repartir
     * y los distintos metodos, las validaciones y el transcurso normal del
     * juego
     */
    
    public void instanciarJugadores(int numeroJugadores){
        jugadores = new Jugador[numeroJugadores+1];    
        for(int i=0; i<=numeroJugadores; i++){
            jugadores[i] = new Jugador();
        }
    }
    
    public Juego() {
        int ultimoJugador = 0;
        int numeroJugadores;
        interfaz = new Interfaz();
        interfaz.crearInterfaz();
        int victorias[] = new int[10];
        System.out.println("Bienvenido a EFS Black Jack");
        System.out.println("-------------------------------------"
                + "---------------------------------------------");
        for (int i = 1; i <= 1; i++) {
            System.out.println("Digite la cantidad usuarios que van a "
            + "Jugar Recuerde que el Juego solo permite un -->Maximo de 7<--");
            System.out.println("-----------------------------"
            + "----------------------------------------------"
                    + "--------------------------------");
            String stringNumeroJugador = JOptionPane.showInputDialog(null, "Digite La cantidad de "
                    + "Jugadores");
            if (stringNumeroJugador == null || stringNumeroJugador.equals(JOptionPane.CANCEL_OPTION)) {
                System.exit(0);
            }
            if (stringNumeroJugador.length() == 0 || !Character.isDigit(stringNumeroJugador.charAt(0)) 
                    || stringNumeroJugador.length() > 1) {
                JOptionPane.showMessageDialog(null, "Numero Invalido Digite "
                        + "de nuevo");
                i--;
                continue;
            }
            numeroJugadores = Integer.parseInt(stringNumeroJugador);
            if (numeroJugadores > 7 || numeroJugadores < 1) {
                System.out.println("Numero Invalido Por favor digite de "
                        + "nuevo:");
                System.out.println("----------------------------------"
                        + "-------------------------");
                i--;
            } else {
                interfaz.inicializarAtributos(numeroJugadores+1);
                int estadoPartida = 1;
                interfaz.tapar(numeroJugadores);
                while (estadoPartida != 0) {
                    instanciarJugadores(numeroJugadores);
                    mazo = new Mazo();
                    interfaz.iniciar(numeroJugadores);
                    System.out.println("EL juego comenzara ahora");
                    System.out.println("-----------------------------"
                            + "-------------------------------");
                    interfaz.fondo();
                    for(int x=0; x<2; x++){
                        Repartir(0, x);
                    }
                    interfaz.setEstadoJugador(0,"Mano Croupier");
                    for (int j = 1; j <= numeroJugadores; j++) {
                        Repartir(j, 0);
                        Repartir(j, 1);
                        LlamarValorMano(j);
                    }
                    if ((jugadores[0].ValorMano(0)) <= 16) {
                        Repartir(0, 2);
                    }
                    int cartasRepartidas = 2;
                    int valorManoTemp = 1;
                    for (int b = 1; b <= numeroJugadores; b++) {
                        System.out.println("------------------------------------------------------------");
                        interfaz.setPosjugadorVisible(b, true);
                        interfaz.setPosjugadorVisible(b-1, false);
                        valorManoTemp = LlamarValorMano(b);
                        interfaz.setSumaJugadorText("Suma=" + valorManoTemp);
                        if (valorManoTemp < 21) {
                            System.out.println("El Juegador #: " + b + "� "
                                    + "Desea Plantarse o PedirCarta:?(Plantarse"
                                    + " ingrese 0 / PedirCarta ingrese 1");
                            interfaz.setTurnoJugadorText("T=J" + b);
                            String desicionPlantarse = JOptionPane.showInputDialog(null, "El "
                                    + "Jugador #: " + b + "� Desea Plantarse "
                                    + "o PedirCarta:?(Plantarse ingrese "
                                    + "0 / PedirCarta ingrese 1");
                            if (desicionPlantarse == null || desicionPlantarse.equals
                                    (JOptionPane.CANCEL_OPTION)) {
                                JOptionPane.showMessageDialog(null, "Opcion inva"
                                        + "lida, Digite de nuevo");
                                b--;
                                continue;
                            }
                            if (desicionPlantarse.length() == 0 || 
                                    !Character.isDigit(desicionPlantarse.charAt(0)) || 
                                    desicionPlantarse.length() > 1) {
                                JOptionPane.showMessageDialog(null, "Numero "
                                        + "Invalido Digite de nuevo");
                                b--;
                                continue;
                            }
                            int desicion = Integer.parseInt(desicionPlantarse);
                            if (desicion < 0 || desicion > 7) {
                                b--;
                            }
                            if (desicion == 1) {
                                Repartir(b, cartasRepartidas);
                                cartasRepartidas++;
                                b--;
                            }
                           
                            if (desicion == 0) {
                                cartasRepartidas=2;
                                valorManoTemp=1;
                                interfaz.plantar(b);
                            }
                        } else {
                            cartasRepartidas=2;
                            if (valorManoTemp == 21) {
                                System.out.println("El Jugador ha conseguido "
                                        + "BlackJack");
                                interfaz.blackJack(b);
                            }
                            if (valorManoTemp > 21) {
                                System.out.println("El jugador se ha pasado de 21"
                                        + " y ha perdido");
                                interfaz.perderPaso(b);
                            }
                        }
                        ultimoJugador=b;
                    }
                    interfaz.setPosjugadorVisible(ultimoJugador, false);
                    System.out.println("------------------------------------------------------------" + "\n");
                    jugadores[0].ManoCroupier();
                    interfaz.setSumaCroupierText("SumaCrou:");
                    interfaz.setResultadoCroupierText(jugadores[0].ValorMano(0) + "");
                    LlamarValorMano(0);
                    for (int j = 1; j <= numeroJugadores; j++) {
                        valorManoTemp = LlamarValorMano(j);
                        if (valorManoTemp == 21) {
                            System.out.println("GANASTE");
                            interfaz.ganar(j);
                            victorias[j]++;
                            System.out.println("");
                        } else {
                            if (jugadores[0].ValorMano(0) <= 21) {
                                if (valorManoTemp == jugadores[0].ValorMano(0)) {
                                    System.out.println("EMPATE");
                                    interfaz.empate(j);
                                }
                                if ((valorManoTemp < jugadores[0].ValorMano(0)) || (valorManoTemp > 21)) {
                                    System.out.println("PERDISTE");
                                    interfaz.perder(j);
                                }
                                if ((valorManoTemp > jugadores[0].ValorMano(0)) && (valorManoTemp <= 21)) {
                                    System.out.println("GANASTE" + "\n");
                                    interfaz.ganar(j);
                                    victorias[j]++;
                                }
                            } else {
                                if (valorManoTemp <= 21) {
                                    System.out.println("GANASTE" + "\n");
                                    interfaz.ganar(j);
                                    victorias[j]++;
                                }
                                if (valorManoTemp > 21) {
                                    System.out.println("PERDISTE");
                                    interfaz.perder(j);
                                }
                            }
                        }
                    }
                    for (int h = 1; h < 10; h++) {
                        ImageIcon cartaCroupier = jugadores[0].getCartaCroupier(h);                       
                        interfaz.setCartasCroupier(h, cartaCroupier);
                    }
                    for (int j = 1; j <= numeroJugadores; j++) {
                        System.out.println("La Puntuacion del Jugador " + j + "es:");
                        System.out.println(victorias[j]);
                        interfaz.setPuntuacionJugadoresText(j, "Jug " + j + " =" + victorias[j]);
                        JOptionPane.showMessageDialog(null, "La Puntuacion del Jugador " + (j) + " es:" + victorias[j]);
                        sleep(200);
                    }
                    for (int a = 0; a < 1; a++) {
                        System.out.println("Desea volver a Jugar?(Digite 0 Para salir)");
                        String volverjugar = JOptionPane.showInputDialog(null, "Desea volver a Jugar?(Digite 0 Para salir/Cualquier Numero para continuar)");
                        if (volverjugar == null || volverjugar.equals(JOptionPane.CANCEL_OPTION)) {
                            System.exit(0);
                        }
                        if (volverjugar.length() == 0 || !Character.isDigit(volverjugar.charAt(0)) || volverjugar.length() > 1) {
                            JOptionPane.showMessageDialog(null, "Numero Invalido Digite de nuevo");
                            a--;
                            continue;
                        }
                        estadoPartida = Integer.parseInt(volverjugar);
                        if (estadoPartida == 0) {
                            System.exit(estadoPartida);
                        }
                    }
                }
            } 
        }   
    }  
}
