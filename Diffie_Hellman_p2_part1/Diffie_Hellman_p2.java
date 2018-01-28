/*
 * Forma de establecer una clave secreta compartida utilizando un canal no 
 * seguro de comunicación mediante el algoritmo Diffie-Hellman
 */
package Diffie_Hellman_p2_part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 *
 * @author Alba Martinez Alfaro
 */
public class Diffie_Hellman_p2 {

    public static void main(String[] args) throws IOException {
        BufferedReader escribir = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Numero primo: ");
        BigInteger p = new BigInteger(escribir.readLine());

        System.out.print("Generador: ");
        BigInteger n = new BigInteger(escribir.readLine());

        System.out.print("Alice escoge su valor secreto: ");
        BigInteger x = new BigInteger(escribir.readLine());

        BigInteger z1 = null;
        System.out.println("Alice -> z1 = (" + n + "^" + x + ") mod " + p);
        z1 = n.pow(x.intValue());
        z1 = z1.mod(p);
        System.out.println("Envia z1=" + z1 + " a Bob. Puede ser interceptado");

        System.out.print("Bob escoge su valor secreto: ");
        BigInteger y = new BigInteger(escribir.readLine());

        BigInteger z2;
        System.out.println("Bob -> z2 = (" + n + "^" + y + ") mod " + p);
        z2 = n.pow(y.intValue());
        z2 = z2.mod(p);
        System.out.println("Envia z2=" + z2 + " a Alice. Puede ser interceptado");

        BigInteger k1, k2;
        k1 = z2.pow(x.intValue());
        k1 = k1.mod(p);
        k2 = z1.pow(y.intValue());
        k2 = k2.mod(p);
        System.out.println("Alice calcula el valor z=(" + z2 + "^" + x + ") mod " + p + " = " + k1);
        System.out.println("Bob calcula el valor z=(" + z1 + "^" + y + ") mod " + p + " = " + k2);

        if (k1.compareTo(k2) == 0) {
            System.out.println(k1 + " es la clave común, que corresponde al valor z=(" + n + "^" + x + "*" + y + ") mod " + p);
        }
    }
}
