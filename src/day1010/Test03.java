package day1010;

import day0923.Student;

import java.lang.reflect.*;
import java.util.ResourceBundle;

/**
 * @author 王旻爽
 * 2020/10/10
 * @ClassName Test03.java
 */
public class Test03 {
    public static void main(String[] args) throws ClassNotFoundException {
        ResourceBundle r = ResourceBundle.getBundle("info");
        String className = r.getString("className");
        Class<?> aClass = Class.forName(className);
        // 反射类的信息
        // 权限
        int modifiers = aClass.getModifiers();
        String s = Modifier.toString(modifiers);
        System.out.println(s);
        // 类名
        String name = aClass.getName();
        String simpleName = aClass.getSimpleName();
        System.out.println(name);
        System.out.println(simpleName);
        // 父类
        Class<?> superclass = aClass.getSuperclass();
        String simpleName1 = superclass.getSimpleName();
        System.out.println(simpleName1);
        // 接口
        Class<?>[] interfaces = aClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }

        // 属性
        // 获得类中所有的属性
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        // 获得类中所有方法
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

        // 构造方法
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        // 先反射构造方法，再通过构造方法创建对象
        Class<Student> studentClass = Student.class;
        try {
            Constructor<Student> constructor = studentClass.getConstructor(String.class, String.class, int.class);
            Student eee = constructor.newInstance("12", "eee", 11);
            System.out.println(eee);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
