package day0927;

import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 王旻爽
 * 2020/9/27
 * @ClassName ioTest.java
 */
public class ioTest {

    public static void main(String[] args) {

        bytesToStr();
        writeBytes();
        bytesToStr();
    }

    private static void writeBytes() {

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("E:\\abc.txt",true);

            byte[] bytes = "Hello World!!".getBytes();

            fos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void bytesToString() {

        try(FileInputStream fis = new FileInputStream("E:\\abc.txt")){
            int bytes = fis.read();
            while(bytes != -1){
                System.out.println((char)bytes);
                bytes = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void bytesToStr() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("E:\\abc.txt");

            int bytes = fis.read();

            while (bytes != -1) {
                System.out.print((char) bytes);
                bytes = fis.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


