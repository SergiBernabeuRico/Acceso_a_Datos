/* Programa NIO que genere 100 números de lotería aleatorios (entre 0 y 99999), los guarde en un buffer, muestre el contenido del buffer y lo escriba en un fichero "loteria.dat". */

package  com.dam2;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ej2 {
    public static void main(String args[]){
        int numRam; //  variable donde se guardará cada número aleatorio

        try (RandomAccessFile raf = new RandomAccessFile("loteria.dat", "rw");
        FileChannel fc = raf.getChannel()) //   Abrimos el canal Nio a partir del RandomAccessFile
        {
            //  Creamos un buffer capaz de almacenar 100 enteros (cada int ocupa 4 bytes -> 100 * 4)
            ByteBuffer bf = ByteBuffer.allocate(100 * Integer.BYTES);

            for (int i = 0; i < 100; i++) {
                numRam = (int) (Math.random() * 100000); // genera un número aleatorio entre 0 y 99999 en cada pasada por el for

                bf.putInt(numRam); //   Guarda el número entero en el buffer en formato binario (4 bytes por número)
            }
            bf.flip(); //   Cambia el buffer de modo escritura a modo lectura

            fc.write(bf); //    Escribe el contenido del buffer al completo en el fichero "loteria.dat

            bf.flip(); //   Volvemos a poner el buffer en modo lectura. Ahora queremos leer el contenido para mostrarlo

            System.out.println("Números de lotería generados.");
            while(bf.hasRemaining()) { //   hasRemaining( controla que queden datos pendientes
                System.out.println(bf.getInt()); // getInt() lee de 4 en 4 bytes del buffer y los convierte a int
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}