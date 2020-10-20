package day1009;

import org.w3c.dom.ls.LSOutput;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @author 王旻爽
 * 2020/10/9
 * @ClassName Test02.java
 */
public class Test02 {

    // 获取文件的绝对路径的方法
    // 该方式是一种比较通用的方法
    public static void main(String[] args) throws IOException {
//        String path = Thread.currentThread().getContextClassLoader().getResource("Info.proprities").getPath();
//        FileReader fileReader = new FileReader(path);
//        Properties p = new Properties();
//        p.load(fileReader);
//        fileReader.close();
//        String username = p.getProperty("username");
//        System.out.println(username);


        // 或者使用java提供的资源绑定器
        ResourceBundle resourceBundle = ResourceBundle.getBundle("info");
        String username1 = resourceBundle.getString("username");
        System.out.println(username1);
    }
}