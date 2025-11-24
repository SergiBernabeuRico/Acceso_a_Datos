import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.Scanner;

/* Programa Java que pide una serie de pares de valores númericos (el primero entero positivo, el segundo real) y almacene el segundo en un fichero de acceso aleatorio, cada real en la posición indicada por el entero. El programa acabará cuando el entero introducido sea cero.
 *
 * Explica en el código fuente cómo queda definido el tamaño final del fichero.
 */
public class ej1b{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        Path ruta = Path.of("datosReales.dat");

        int posicion; double valor;

        try(FileChannel fichero = FileChannel.open(ruta, EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.READ))){

            do{
                System.out.println("introduce un número entero (posición el fichero): ");
                posicion = scanner.nextInt();
                if(posicion < 0){
                    System.out.println("Número negativo, introduce uno positivo.");
                }else if(posicion > 0){
                    System.out.println("Introduce el número real a guardar en fichero: ");
                    valor = scanner.nextDouble();

                    long bytePosicion = (long)(posicion - 1) * 8;

                    ByteBuffer bf = ByteBuffer.allocate(8);

                    bf.putDouble(valor);
                    bf.flip();

                    fichero.position(bytePosicion);
                    while (bf.hasRemaining()){
                        fichero.write(bf);
                    }
                }
            }while(posicion != 0);

            long tam = fichero.size();
            System.out.println("El tamaño del fichero es " + tam + " bytes.");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}