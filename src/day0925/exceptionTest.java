package day0925;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author 王旻爽
 * 2020/9/25
 * @ClassName exceptionTest.java
 */
public class exceptionTest {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String str = "hello";

        convert(str,"GBK");
    }

    private static void convert(String str, String code) {

        byte[] bytes = new byte[0];
        try {
            bytes = str.getBytes(code);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(bytes));
    }


}
