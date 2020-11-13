package day1113;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 王旻爽
 * 2020/11/13
 * @ClassName Test.java
 */
public class Test {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        Date[] ds = new Date[]{
                new Date(),
                sm.parse("2020-11-12"),
                sm.parse("1990-01-02"),
                sm.parse("1993-11-02"),
                sm.parse("1999-10-22"),
                sm.parse("2020-01-02"),
        };

        compare<Date> compare = comparator.calculate(ds);
        System.out.println("min:"+sm.format(compare.getMin())+","+"max:"+sm.format(compare.getMax()));
    }
}
