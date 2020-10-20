package day1010;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author 王旻爽
 * 2020/10/10
 * @ClassName Test04.java
 */
public class Test04 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("day1010.Myclass");
        Constructor<?> constructor = aClass.getConstructor(int.class, int.class);
        Object o = constructor.newInstance(777,456);
        Field x = aClass.getField("x");
        Field y = aClass.getDeclaredField("y");
        y.setAccessible(true);
        y.set(o,999);
        x.set(o,123);
        System.out.println(o);
    }

}
