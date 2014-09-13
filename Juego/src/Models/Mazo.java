package Models;

/**
 * Esta clase permite crear el mazo de 52 cartas que sera utilizado en todo el
 * juego para alimentar las barajas
 *
 * @author esteban
 */
public class Mazo {

    Carta mazo[];

    /**
     * Este metodo retorna una carta pedida en cierta posicion del mazo
     *
     * @param cartaPedida
     * @return
     */
    public Carta getCarta(int cartaPedida) {
        return mazo[cartaPedida];
    }

    /**
     * Este metodo recive como parametro la ubicacion de la carta que se borrara
     * desps de ser sacada del mazo
     *
     * @param numeroCarta
     */
    public void borraCarta(int numeroCarta) {
        mazo[numeroCarta] = null;
    }

    /**
     * El constructor de mazo permite crear un mazo que es un arreglo de cartas
     * de 52 posiciones, creando uno con todas las especificaciones, valores y
     * pintas
     */
    public Mazo() {
        mazo = new Carta[52];
        int count = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                switch (i) {
                    case 0:
                        Carta cartan = new Carta(j, "pica", Integer.toString(j));
                        mazo[count] = cartan;
                        count++;
                        break;

                    case 1:
                        Carta cartan1 = new Carta(j, "diamante", Integer.toString(j));
                        mazo[count] = cartan1;
                        count++;
                        break;

                    case 2:
                        Carta cartan2 = new Carta(j, "trebol", Integer.toString(j));
                        mazo[count] = cartan2;
                        count++;
                        break;

                    case 3:
                        Carta cartan3 = new Carta(j, "corazon", Integer.toString(j));
                        mazo[count] = cartan3;
                        count++;
                        break;

                }

            }
        }
       
        for (int i = 0; i < 52; i++) {

            if (mazo[i].getValor() > 10) {
                mazo[i].setValor(10);
            }
            if (mazo[i].getEspecificacion().equals("11")) {
                mazo[i].setEspecificacion("J");

            }

            if (mazo[i].getEspecificacion().equals("12")) {
                mazo[i].setEspecificacion("Q");

            }

            if (mazo[i].getEspecificacion().equals("13")) {
                mazo[i].setEspecificacion("K");

            }

            if (mazo[i].getEspecificacion().equals("1")) {
                mazo[i].setEspecificacion("As");

            }

            if (mazo[i].getValor() == 1) {
                mazo[i].setValor(11);
            }


        }



    }
}
