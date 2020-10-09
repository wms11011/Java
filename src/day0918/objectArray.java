package day0918;

/**
 * @author 王旻爽
 * 2020/9/18
 * @ClassName objectArray.java
 */

class Person{
    private String name;
    private String age;

    Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return name.equals(person.name) &&
                age.equals(person.age);
    }
}


public class objectArray {

    public static void main(String[] args) {

        // 定义对象数组
        Person[] data = new Person[10];
        int size = 0;
        data[size++] = new Person("aa","20");
        data[size++] = new Person("bb","21");
        data[size++] = new Person("cc","24");
        data[size++] = new Person("dd","45");
        data[size++] = new Person("ee","55");
        data[size++] = new Person("ff","76");

        // 遍历对象数组
        for (Person datum : data) {
            System.out.println(datum);
        }

        // 查找是否存在name=“xx” age=“22”的对象
        String name = "xx";
        String age = "22";
        if(findPerson(name="xx",age="22",data)){
            System.out.println("存在");
        } else {
            System.out.println("不存在");
        }

        // 遍历对象数组
        for (Person datum : data) {
            System.out.println(datum);
        }

        // 删除name=“aa” age="20"的对象
        if(deleteObject( "aa","20",data)){
            System.out.println("删除成功！！");
        } else {
            System.out.println("删除失败，对象不存在！！");
        }

        // 遍历对象数组
        for (Person datum : data) {
            System.out.println(datum);
        }
    }

    private static boolean deleteObject(String name, String age, Person[] data) {

        if(!findPerson("aa","20", data)){
            return false;
        }
        Person p = new Person(name,age);
        int value = 0;
        for (int i = 0; i < data.length; i++) {
            if(data[i].equals(p) ){
                value = i;
                break;
            }
        }
        System.arraycopy(data,value+1,data,value,data.length-value-1);
        data[data.length-1] = null;
        return true;
    }

    private static boolean findPerson(String name, String age, Person[] data) {

        Person p = new Person(name,age);
        for (Person datum : data) {
            if (datum != null) {
                if (datum.equals(p)) {
                    return true;
                }
            }
        }
        return false;
    }


}
