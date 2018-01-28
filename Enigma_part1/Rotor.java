package Enigma_part1;

import java.util.ArrayList;

/**
 *
 * @author Alba Martinez Alfaro
 */
public class Rotor {

    int posicion_rotor, rotacion_rotor, aguja_rotor;
    int cont = 0;

    ArrayList<Character> rotor = new ArrayList();
    
    public Rotor(String codificacion, char rotacion, char pos_rotor) {
        posicion_rotor = pos_rotor;
        rotacion_rotor = posicion_rotor - 65;
        aguja_rotor = rotacion - posicion_rotor;
        for (int i = 0; i < codificacion.length(); i++) {
            rotor.add(codificacion.charAt(i));
        }
        for (int i = 0; i < rotacion_rotor; i++) {
            rotor.add(rotor.get(rotor.size() - 1));
            rotor.remove(rotor.size() - 1);
        }
    }

    public void rotar() {
        rotor.add(rotor.get(0));
        rotor.remove(0);
        if (posicion_rotor == 90) {
            posicion_rotor = 65;
        } else {
            posicion_rotor++;
        }
        cont++;
    }
}
