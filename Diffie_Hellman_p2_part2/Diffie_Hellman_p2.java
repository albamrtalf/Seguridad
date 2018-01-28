/*
 * Forma de establecer una clave secreta compartida utilizando un canal no 
 * seguro de comunicación mediante el algoritmo Diffie-Hellman
 */
package Diffie_Hellman_p2_part2;

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

        System.out.print("Escoge tu valor secreto: ");
        BigInteger x = new BigInteger(escribir.readLine());

        BigInteger z = null;
        z = n.pow(x.intValue());
        z = z.mod(p);
        System.out.println("z = (" + n + "^" + x + ") mod " + p + " = " + z);
        
        System.out.print("z del colaborador: ");
        BigInteger zz = new BigInteger(escribir.readLine());
        BigInteger k;
        k = zz.pow(x.intValue());
        k = k.mod(p);
        System.out.println("z comun = (" + zz + "^" + x + ") mod " + p + " = " + k);
    }
}
