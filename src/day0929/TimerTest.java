package day0929;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author 王旻爽
 * 2020/9/29
 * @ClassName TimerTest.java
 */
public class TimerTest {

    public static void main(String[] args) throws ParseException {

        Timer timer = new Timer();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = sdf.parse("2020-09-29 20:31:00");

        timer.schedule(new logTimer(),parse,1000*10);
    }
}

class logTimer extends TimerTask {

    @Override
    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        System.out.println(format+"完成了一次数据备份！！");
    }
}
