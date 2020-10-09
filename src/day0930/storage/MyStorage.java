package day0930.storage;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王旻爽
 * 2020/9/30
 * @ClassName MyStorage.java
 */
public class MyStorage {

    // 定义一个仓库
    List<Integer> myStorage = new ArrayList<>(10);

    // 将货物存进仓库
    public synchronized void add(Integer data){

        // 如果仓库已满则等待
        while (myStorage.size() >= 10) {
            try {
                System.out.println(Thread.currentThread().getName()+ "在等待中。。");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 如果仓库未满则存入货物
        myStorage.add(data);
        System.out.println( Thread.currentThread().getName() + " 存了数据:" + data + "后仓库容量: " + myStorage.size());
        notify();
    }

    // 将货物取出仓库
    public synchronized void get(){

        // 如果仓库为空则等待
        while (myStorage.size() <= 0) {
            try {
                System.out.println(Thread.currentThread().getName()+ "在等待中。。");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 如果仓库不空则取出货物
        Integer remove = myStorage.remove(0);
        System.out.println( Thread.currentThread().getName() + " 取了数据:" + remove + "后仓库容量: " + myStorage.size());
        notify();

    }
}
