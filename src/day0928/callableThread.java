package day0928;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author 王旻爽
 * 2020/9/28
 * @ClassName callableThread.java
 */
public class callableThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> task = new FutureTask<>(new primeC());

        Thread t1 = new Thread(task);

        t1.start();

        System.out.println("子线程的返回结果是 ：" + task.get());

    }

}

class primeC implements Callable<Integer> {

    @Override
    public Integer call() {
        int num = new Random().nextInt(100);
        System.out.println("子线程的执行结果是 ：" + num);
        return num;
    }
}
