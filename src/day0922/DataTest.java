package day0922;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 王旻爽
 * 2020/9/22
 * @ClassName DataTest.java
 */
public class DataTest {

    public static void main(String[] args) throws ParseException {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        System.out.println(format);

        String ss = "2019年12月30日 10时30分12秒";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年M月dd日 HH时mm分ss秒");
        Date parse = sdf1.parse(ss);
        System.out.println(parse);

    }

}
