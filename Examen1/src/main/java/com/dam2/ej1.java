/* Programa Java que pide una serie de pares de valores númericos (el primero entero positivo, el segundo real) y almacene el segundo en un fichero de acceso aleatorio, cada real en la posición indicada por el entero. El programa acabará cuando el entero introducido sea cero.
 *
 * Explica en el código fuente cómo queda definido el tamaño final del fichero.
 */

package com.dam2;

import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.Scanner;

public class ej1{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        Path ruta = Path.of("numeros1");

        int posicion;
        double valor;

        try(FileChannel fichero = FileChannel.open(ruta, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.READ);){
            do{
                System.out.println("Introduce un número entero (posición donde guardar valor), introduce '0' para terminar: ");
                posicion = scanner.nextInt();

                if(posicion < 0){
                    System.out.println("Número negativo, introduce uno positivo.");
                }else if(posicion > 0){
                    System.out.println("Introduce el valor a guardar en el fichero: ");
                    valor = scanner.nextDouble();

                    long bytePosicion = (long)(posicion - 1) * 8;

                    ByteBuffer buffer = ByteBuffer.allocate(8);

                    buffer.putDouble(valor);
                    buffer.flip();

                    fichero.position(bytePosicion);
                    while(buffer.hasRemaining()){
                        fichero.write(buffer);
                    }
                }

            }while(posicion != 0);

            long tam = fichero.size();
            System.out.println("El tamñao del fichero es " + tam + " bytes.");

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}