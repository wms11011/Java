package day0928;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 王旻爽
 * 2020/9/28
 * @ClassName day0928.fileTest.java
 */
public class fileTest {

    public static void main(String[] args) throws IOException {

        String filePath = "E:\\a";
        deleteFile(filePath);

    }

    private static void deleteFile(String filePath) {

        File file = new File(filePath);
        File[] files = file.listFiles();
        for (File file1 : files) {
            if(file1.isDirectory()){
                deleteFile(file1.getAbsolutePath());
            } else if (file1.isFile()){
                file1.delete();
            }
        }

        file.delete();
    }


}
