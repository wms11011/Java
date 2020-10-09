package homework0921;

/**
 * @author 王旻爽
 * 2020/9/21
 * @ClassName ReverseStr.java
 */
public class ReverseStr {

    public static void main(String[] args) {
        String str = "abcdef";

        reverse(str);
    }

    private static void reverse(String str) {
        StringBuilder sb = new StringBuilder();
        String s1;
        for (int i = str.length()-1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        System.out.println(sb);
    }


}
