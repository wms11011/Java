package homework0927;

import java.io.*;

/**
 * @author 王旻爽
 * 2020/9/27
 * @ClassName copyTest.java
 */
public class copyTest {

    public static void main(String[] args) {

        // 创建一个输入流对象
        FileInputStream fis = null;
        // 创建一个输出流对象
        FileOutputStream fos = null;

        try {
            // 创建输入流
            fis = new FileInputStream("C:\\Users\\wangl\\Desktop\\2020Java视频学习路线图纯源码版\\01-JavaSE基础阶段\\02-老杜2020版Java零基础进阶368集（视频采用JDK13录制）\\文档\\day23数组拷贝内存图.png");
            // 创建输出流
            fos = new FileOutputStream("E:\\ws10\\数组拷贝内存图.png",true);
            // 对文件进行复制
            byte[] bytes = new byte[1024*1024];
            int readCount = 0;
            while((readCount = fis.read(bytes)) != -1) {
                fos.write(bytes,0,readCount);
            }
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
