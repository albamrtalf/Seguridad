/*
 * Forma de establecer una clave secreta compartida utilizando un canal no 
 * seguro de comunicación mediante el algoritmo Diffie-Hellman
 */
package Diffie_Hellman_p2_part3;

import java.io.IOException;
import java.math.BigInteger;

/**
 *
 * @author Alba Martinez Alfaro
 */
public class Diffie_Hellman_p2 {

    public static void main(String[] args) throws IOException {
        BigInteger p = new BigInteger("16519894");
        BigInteger n = new BigInteger("212156");
        BigInteger z1 = new BigInteger("7259682");
        BigInteger z2 = new BigInteger("1547798");
        BigInteger z = null, k, zz;
        int x = 0;

        System.out.println("Numero primo: " + p);
        System.out.println("Generador: " + n);
        System.out.println("Marcos z: " + z1);
        System.out.println("Kike z: " + z2);

        System.out.println("-- Busqueda de numero secreto --");
        while (!z1.equals(z) && !z2.equals(z)) {
            z = n.pow(x);
            z = z.mod(p);
            x++;
        }
        x = x - 1; // Dado que nos suma 1 al terminar el bucle, hay que restarselo para dar el resultado real
                if (z1.equals(z)) {
            System.out.println("Marcos numero secreto x = " + x);
            zz = z2;
        } else {
            System.out.println("Kike numero secreto y = " + x);
            zz = z1;
        }

        System.out.println("-- Busqueda de la clave comun --");
        BigInteger k1;
        k1 = zz.pow(x);
        k1 = k1.mod(p);
        System.out.println("Clave comun z=(" + zz + "^" + x + ") mod " + p + " = " + k1);
    }
}
