package day0930.produer;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义仓库类
 * 动力节点
 * 2020/9/30
 */
public class MyStorage {
    //定义存储数据的集合
    private List list = new ArrayList<>();

    //添加数据
    public synchronized void add(Object  data){
        //当仓库已满 等待
        while ( list.size() >= 10 ){
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting...");
                this.wait();    //通过锁对象调用wait()等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //添加数据
        list.add(data);
        System.out.println(Thread.currentThread().getName() + " 添加了数据:" + data + " , 现在仓库容量:" + list.size());

        //通知消费者消费
        this.notifyAll();       //有多个消费者等待
    }

    //取数据
    public synchronized void get(){
        //仓库为空则等待
        while ( list.size() <= 0 ){
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting...");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Object removed = list.remove(0);    //取数据
        System.out.println( Thread.currentThread().getName() + " 取了数据:" + removed + "后仓库容量: " + list.size());

        //通知生产者生产
        this.notifyAll();
    }
}
