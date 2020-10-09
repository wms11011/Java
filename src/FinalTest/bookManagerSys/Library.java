package FinalTest.bookManagerSys;

import day0919.Bird.BlackBird;

import java.io.*;
import java.util.*;

/**
 * @author 王旻爽
 * 2020/10/5
 * @ClassName Library.java
 */
class Library implements Serializable {
    private static final long serialVersionUID = -6729157889476419735L;

    // 图书信息
   private static List<Book> bookList = new ArrayList<>();

    // 读者信息
    static List<Reader> readerList = new ArrayList<>();

    // 借阅信息
    static Map<String,List<Book>> borrowInfo = new HashMap<>();

    // 显示系统初始界面
    static void showMainPage(){
        System.out.println("===========================图书管理系统==============================");
        System.out.print("1 图书查询\n2 读者登录\n3 管理员登录\n4 退出\n请输入你的操作：");
    }

    // 显示图书查询界面
    static void searchBookInfoPage(){
        System.out.println("----------------------图书查询------------------------");
        System.out.println("1 按图书编号查询                2 按图书名查询\n请输入你的操作：");
    }

    // 显示读者操作界面
    static void readerControlPage(){
        System.out.println("******************读者操作界面*******************");
        System.out.println("1 查看个人信息\n2 查看借阅信息\n3 修改密码\n4 借书\n5 还书\n6 退出\n请输入你的操作：  ");
    }

    // 显示管理员操作界面
    static void administratorControlPage(){
        System.out.println("****************管理员操作界面*******************");
        System.out.println("1 添加读者信息\n2 删除读者信息\n3 查询读者信息\n4 添加图书信息\n5 删除图书信息\n6 退出\n请输入你的操作：");
    }

    // 读者登录验证
    static boolean readerSignIn(Reader reader){
        for (Reader reader1 : readerList) {
            if(reader.getUserLicenses().equals(reader1.getUserLicenses())){
                return true;
            }
        }
        return false;
    }

    // 管理员登录
    static boolean adminSignIn(String adminUser, String adminPassWd){
        Admin admin = new Admin();
        return new Admin(adminUser, adminPassWd).equals(admin);
    }

    // 添加图书
    static boolean insterBook(Book book){
        if(bookList.contains(book)){
            return false;
        }
        bookList.add(book);
        return true;
    }

    // 删除图书
    static boolean deleteBook(Book book){
        if(!bookList.contains(book)){
            return false;
        }
        bookList.remove(book);
        return true;
    }

    // 借书
    static boolean borrrowBook(Book book, Reader reader){
        if(readerSignIn(reader)){
            if(!borrowInfo.containsKey(reader.getUserLicenses())){
                List<Book> bookList = new ArrayList<>();
                borrowInfo.put(reader.getUserLicenses(),bookList);
            }
            for (Map.Entry<String, List<Book>> entry : Library.borrowInfo.entrySet()) {
                if(entry.getValue().contains(book)){
                    return false;
                }
            }
            if(bookList.contains(book)){
                borrowInfo.get(reader.getUserLicenses()).add(book);
                return true;
                } else {
                return false;
                }
            }
        return false;
        }

    // 还书
    static boolean returnBook(Book book,Reader reader){
        if(readerSignIn(reader)){
            if(borrowInfo.containsKey(reader.getUserLicenses())){
                borrowInfo.get(reader.getUserLicenses()).remove(book);
                return true;
            }
        }
        return false;
    }

    // 添加读者信息
    static boolean insertReaderInfo(Reader reader){
        if (!readerSignIn(reader)){
            readerList.add(reader);
            return true;
        }
        return false;
    }

    // 删除读者信息
    static boolean deleteReaderInfo(Reader reader){
        if (!readerSignIn(reader)){
            return false;
        }
        readerList.remove(reader);
        return true;
    }

    // 按图书编号查询
    static Book searchByISBN(String isbn){

        for (Book book1 : bookList) {
            if(book1.getIsbnNum().equals(isbn)){
                return book1;
            }
        }
        return null;
    }

    // 按图书名查询
    static List<Book> searchByBookName(String s){
        String content = s.trim();
        List<Book> list = new ArrayList<>();
        for (Book book : bookList) {
            if(book.getBookName().contains(content)){
                list.add(book);
            }
        }
        return list;
    }

    // 保存系统信息
    static void saveSysInfo(){
        try (ObjectOutputStream oos_book = new ObjectOutputStream(new FileOutputStream("save//log_book.txt"));
             ObjectOutputStream oos_reader = new ObjectOutputStream(new FileOutputStream("save//log_reader.txt"));
             ObjectOutputStream oos_borrowInfo = new ObjectOutputStream(new FileOutputStream("save//log_borrowInfo.txt"))
        ){
            oos_book.writeObject(bookList);
            oos_reader.writeObject(readerList);
            oos_borrowInfo.writeObject(borrowInfo);
            oos_book.flush();
            oos_reader.flush();
            oos_borrowInfo.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 系统信息初始化
    static void initializeSysInfo(){
        try(ObjectInputStream ois_book = new ObjectInputStream(new FileInputStream("save//log_book.txt"));
            ObjectInputStream ois_reader = new ObjectInputStream(new FileInputStream("save//log_reader.txt"));
            ObjectInputStream ois_borrowInfo = new ObjectInputStream(new FileInputStream("save//log_borrowInfo.txt"))
        ) {
            bookList = (List<Book>) ois_book.readObject();
            readerList = (List<Reader>) ois_reader.readObject();
            borrowInfo = (Map<String, List<Book>>) ois_borrowInfo.readObject();
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("未找到初始化文件");;
        }
    }
}
