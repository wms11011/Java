package day0921;

import java.text.Collator;
import java.util.Locale;

/**
 * @author 王旻爽
 * 2020/9/21
 * @ClassName Test.java
 */
public class Test {
    public static void main(String[] args) {
        String s1 = new String("aa张三123");
        String s2 = new String("aca李四589");
        Collator collator = Collator.getInstance(Locale.CHINESE);
        Collator collator1 = Collator.getInstance(Locale.JAPANESE);
        String s3 = new String("あ");
        String s4 = new String("ふ");
        int compare = collator.compare(s1, s2);
        System.out.println(compare);
        boolean b = s1.startsWith("a");
        System.out.println(b);
        boolean b1 = s1.endsWith("123");
        System.out.println(b1);
    }
}
