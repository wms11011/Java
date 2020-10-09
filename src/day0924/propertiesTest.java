package day0924;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @author 王旻爽
 * 2020/9/24
 * @ClassName propertiesTest.java
 */
public class propertiesTest {

    public static void main(String[] args) throws IOException {
        // 创建properties对象
        Properties properties = new Properties();

        // 用properties加载配置文件
        // 方式一
        // 通过当前类的类加载器获得流通道
//    InputStream inputStream = propertiesTest.class.getClassLoader().getResourceAsStream("resources/config.properties");

        // 方式二
        // 还可以用当前线程的上下文类加载器获得流通道
        InputStream inputStream1 = Thread.currentThread().getContextClassLoader().getResourceAsStream("resources/config.properties");

        // 获得流通道后再用properties的load()方法通过字节流加载配置文件
        // 有受检异常需要抛出
        properties.load(inputStream1);

        // 读取配置文件
        System.out.println(properties.getProperty("username"));
        System.out.println(properties.getProperty("password"));


        // ************************************************************************************************

        // 直接用ResourceBundle的静态方法getBundle()可以直接获得ResourceBundle对象，注意：不用扩展名
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resources/config");
        System.out.println(resourceBundle.getString("username"));
        System.out.println(resourceBundle.getString("password"));

    }




}
