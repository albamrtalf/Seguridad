/*
 * Elaborar un simulador, mediante funciones java, que admita una codificación 
 * en forma de clave.
 */
package Enigma_part1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alba Martinez Alfaro
 */
public class p1_enigma {

    public static void main(String[] args) {
        
        Scanner escribir = new Scanner(System.in);
        char letra;
        int cont = 0, aux;
        ArrayList<Character> reflector = new ArrayList();
        ArrayList<Character> resultados = new ArrayList();
        
        System.out.print("Introduce la clave: ");
        String clave = escribir.next();
        System.out.print("Introduce el texto que deseas cifrar: ");
        String cifrar = escribir.next();

        /* Reflector */
        String reflector_dic = "YRUHQSLDPXNGOKMIEBFZCWVJAT";
        for (int i = 0; i < reflector_dic.length(); i++) {
            reflector.add(reflector_dic.charAt(i));
        }

        /* Rotores */
        String rotor3 = "BDFHJLCPRTXVZNYEIWGAKMUSQO";
        String rotor2 = "AJDKSIRUXBLHWTMCQGZNPYFVOE";
        String rotor1 = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
        Rotor r1 = new Rotor(rotor1, 'R', clave.charAt(0));
        Rotor r2 = new Rotor(rotor2, 'F', clave.charAt(1));
        Rotor r3 = new Rotor(rotor3, 'W', clave.charAt(2));

        /* Enigma */
        for (int i = 0; i < cifrar.length(); i++) {
            r3.rotar(); //rotar rotor3
            if (r3.aguja_rotor == r3.cont) {
                r2.rotar();
            }
            if (r2.aguja_rotor == r2.cont) {
                r1.rotar();
            }
            if (r3.cont > 24) {
                r2.rotar();
                r3.cont = 0;
            }
            if (r2.cont > 24) {
                r1.rotar();
                r2.cont = 0;
            }
            if (r1.cont > 24) {
                r1.cont = 0;
            }
            aux = Math.abs(r3.rotor.get(cifrar.charAt(i) - 65) - r3.posicion_rotor);
            aux = Math.abs(r2.rotor.get(aux) - r2.posicion_rotor);
            aux = Math.abs(r1.rotor.get(aux) - r1.posicion_rotor);
            aux = reflector.get(aux) + 0;
            for (int j = 0; j < r1.rotor.size(); j++) {
                if ((r1.rotor.get(j) + 0) == (aux + r1.cont)) {
                    cont = j;
                }
            }
            for (int j = 0; j < r2.rotor.size(); j++) {
                if ((r2.rotor.get(j) + 0) == (cont + 65 + r2.cont)) {
                    aux = j;
                }
            }
            for (int j = 0; j < r3.rotor.size(); j++) {
                if ((r3.rotor.get(j) + 0) == (aux + 65 + r3.cont)) {
                    cont = j;
                }
            }
            letra = (char) (cont + 65);
            resultados.add(letra);
        }

        /* Mostrar resultados */
        System.out.print("RESULTADO: ");
        for (int i = 0; i < resultados.size(); i++) {
            System.out.print(resultados.get(i));
        }
        System.out.println(); //Salto de linea
    }
}
