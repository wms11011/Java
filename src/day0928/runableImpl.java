package day0928;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 王旻爽
 * 2020/9/28
 * @ClassName runableImpl.java
 */
public class runableImpl {

    public static void main(String[] args) {
        Thread t1 = new Thread(new runable());

        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
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
        });

        t2.start();
    }
}


class runable implements Runnable {

    @Override
    public void run() {
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