package homework0928;

import java.io.*;

/**
 * @author 王旻爽
 * 2020/9/28
 * @ClassName copyFolder.java
 */
public class copyFolder {

    public static void main(String[] args) {

        // 源文件路径
        String folderPathFrom = "C:\\Users\\wangl\\Desktop\\2020Java视频学习路线图纯源码版\\01-JavaSE基础阶段\\02-老杜2020版Java零基础进阶368集（视频采用JDK13录制）\\代码";
        // 目标文件路径
        String folderPathTo = "E:\\a\\b\\c";
        // 生成源文件对象
        File srcFile = new File(folderPathFrom);
        // 生成目标文件对象
        File destFile = new File(folderPathTo);
        // 拷贝文件
        folderCopy(srcFile,destFile);
    }

    private static void folderCopy(File from,File to) {

        // 递归结束的条件
        if(from.isFile()){
            // 创建输入流
            FileInputStream fis = null;
            // 创建输出流
            FileOutputStream fos = null;

            try {
                fis = new FileInputStream(from);
                String destFilePath = null;
                if(to.getAbsolutePath().endsWith("\\")){
                    destFilePath = to.getAbsolutePath() + from.getAbsolutePath().substring(3);
                } else {
                    destFilePath = to.getAbsolutePath() + from.getAbsolutePath().substring(2);
                }
                fos = new FileOutputStream(destFilePath);
                byte[] bytes = new byte[1024*1024];
                int readCount = 0;
                while ((readCount = fis.read(bytes)) != -1) {
                    fos.write(bytes,0,readCount);
                }
                fos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return;
        }

        File[] files = from.listFiles();
        assert files != null;
        for (File file : files) {
            if(file.isDirectory()){
                String srcDir = file.getAbsolutePath();
                //System.out.println(srcDir);
                String destDir = null;
                if(to.getAbsolutePath().endsWith("\\")){
                    destDir = to.getAbsolutePath()+srcDir.substring(3);
                } else {
                    destDir = to.getAbsolutePath()+srcDir.substring(2);
                }
                //System.out.println(destDir);
                File file1 = new File(destDir);
                if (!file1.exists()) {
                    file1.mkdirs();
                }
            }
            folderCopy(file,to);
        }

    }
}
