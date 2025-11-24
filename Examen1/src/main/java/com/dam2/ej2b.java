/* Programa NIO que genere 100 números de lotería aleatorios (entre 0 y 99999), los guarde en un buffer, muestre el contenido del buffer y lo escriba en un fichero "loteria.dat". */
package com.dam2;

import javax.imageio.IIOException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ej2b{
    public static void main(String args[]){

        int numAleatorio;

        try(RandomAccessFile raf = new RandomAccessFile("loteriaAleatorio", "rw"); FileChannel fc = raf.getChannel()){

            ByteBuffer bf = ByteBuffer.allocate(100 * Integer.BYTES);

            for(int i = 0; i < 100; i++){
                numAleatorio = (int)(Math.random() * 100000);

                bf.putInt(numAleatorio);
            }
            bf.flip();
            fc.write(bf);
            bf.flip();

            while(bf.hasRemaining()){
                System.out.println(bf.getInt());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}