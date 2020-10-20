package day1010;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author 王旻爽
 * 2020/10/10
 * @ClassName Test05.java
 */
public class Test05 {

    public static void main(String[] args) throws Exception {
        Class aClass = Class.forName("java.lang.String");
        Constructor constructor = aClass.getConstructor(byte[].class);
        Object o = constructor.newInstance((Object) new byte[]{65, 66, 67, 68});
        // 反射无参数方法
        Method length = aClass.getMethod("length");
        Object invoke = length.invoke(o);
        System.out.println(invoke);
        // 反射有参数方法
        Method equals = aClass.getMethod("equals", Object.class);
        Object sdf = equals.invoke(o, "sdf");
        System.out.println(sdf);
        // 反射静态方法
        Method valueOf = aClass.getMethod("valueOf", int.class);
        Object invoke1 = valueOf.invoke(null, 444);
        System.out.println(invoke1 instanceof String);
    }
}
