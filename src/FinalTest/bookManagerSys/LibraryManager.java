package FinalTest.bookManagerSys;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author 王旻爽
 * 2020/10/6
 * @ClassName LibraryManager.java
 */
public class LibraryManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library.initializeSysInfo();
        while (true) {
            // 进入主界面
            Library.showMainPage();
            int functionCode = sc.nextInt();
            if(functionCode == 1){
                // 进入图书查询界面
                Library.searchBookInfoPage();
                int i = sc.nextInt();
                if(i == 1){
                    // 按图书编号查询
                    Book book = null;
                    do {
                        System.out.println("请输入图书编号：");
                        String isbn = sc.next();
                        book = Library.searchByISBN(isbn);
                        if(book == null){
                            System.out.println("查无此书，请重新输入！！");
                        }
                    }while (book == null);
                    System.out.println("图书信息：" + book);
                } else if(i == 2){
                    // 按图书名查询
                    List<Book> list = null;
                    do {
                        System.out.println("请输入图书名：");
                        String bookName = sc.next();
                        list = Library.searchByBookName(bookName);
                        if(list == null){
                            System.out.println("查无此书，请重新输入！！");
                        }
                    }while (list == null);
                    for (Book book : list) {
                        System.out.println("图书信息：" + book);
                    }
                }

            } else if(functionCode == 2){
                // 读者登录
                boolean signIn = false;
                String userName = " ";
                String passWord = " ";
                String userLicenses = " ";
                Reader reader = null;
                do {
                    System.out.println("请输入用户名：");
                    userName = sc.next();
                    System.out.println("请输入密码：");
                    passWord = sc.next();
                    System.out.println("请输入读者编号：");
                    userLicenses = sc.next();
                    reader = new Reader(userLicenses, userName, passWord);
                    signIn = Library.readerList.contains(reader);
                    if(!signIn){
                        System.out.println("登录失败！！");
                    }
                } while (!signIn);
                System.out.println("登录成功！！");
                Library.readerControlPage();
                int i = sc.nextInt();
                if(i == 1){
                    // 查看个人信息
                    System.out.println("读者信息：" + reader);
                } else if(i == 2){
                    // 查看借阅信息
                    System.out.println("编号为"+ reader.getUserLicenses() + "的读者借了");
                    for (Map.Entry<String, List<Book>> stringListEntry : Library.borrowInfo.entrySet()) {
                        if(stringListEntry.getKey().equals(reader.getUserLicenses())){
                            List<Book> value = stringListEntry.getValue();
                            for (Book book : value) {
                                Book book1 = Library.searchByISBN(book.getIsbnNum());
                                System.out.println("图书信息："+book1);
                            }
                        }
                    }
                } else if(i == 3){
                    // 修改密码
                    String next = " ";
                    boolean b = false;
                    do {
                        System.out.println("请输入您的读者编号：");
                        next = sc.next();
                        b = Library.readerSignIn(new Reader(next));
                        if(!b){
                            System.out.println("不存在的读者，请重新输入！！");
                        }
                    }while (!b);
                    System.out.println("请输入新密码:");
                    String passwd = sc.next();
                    for (Reader reader1 : Library.readerList) {
                        if (reader1.equals(new Reader(next))){
                            reader1.setPassWord(passwd);
                            System.out.println("修改成功！！");
                            break;
                        }
                    }
                } else if(i == 4){
                    // 借书
                    String bookname = " ";
                    String isbn = " ";
                    String licenses = " ";
                    boolean borrow = false;
                    do {
                        System.out.println("请输入要借的书的ISBN：");
                        isbn = sc.next();
                        System.out.println("请输入要借的书名：");
                        bookname = sc.next();
                        System.out.println("请输入您的读者编号：");
                        licenses = sc.next();
                        borrow = Library.borrrowBook(new Book(isbn, bookname), new Reader(licenses));
                        if(!borrow){
                            System.out.println("输入有误，请重新输入！！");
                        }
                    }while (!borrow);
                    System.out.println("恭喜，借书成功！！");
                } else if(i == 5){
                    // 还书
                    String bookname = " ";
                    String isbn = " ";
                    String licenses = " ";
                    boolean returnbook = false;
                    do {
                        System.out.println("请输入要还的书的ISBN：");
                        isbn = sc.next();
                        System.out.println("请输入要还的书名：");
                        bookname = sc.next();
                        System.out.println("请输入您的读者编号：");
                        licenses = sc.next();
                        returnbook = Library.returnBook(new Book(isbn,bookname),new Reader(licenses));
                        if(!returnbook){
                            System.out.println("还书失败，请重新输入！！");
                        }
                    }while (!returnbook);
                    System.out.println("还书成功！！");
                } else {
                    Library.saveSysInfo();
                    System.exit(0);
                }
            } else if(functionCode == 3){
                // 管理员登录
                String username = " ";
                String passwd = " ";
                boolean admin = false;
                do {
                    System.out.println("请输入用户名：");
                    username = sc.next();
                    System.out.println("请输入密码：");
                    passwd = sc.next();
                    admin = Library.adminSignIn(username,passwd);
                    if(!admin){
                        System.out.println("抱歉您没有管理员权限！！");
                    }
                }while (!admin);
                System.out.println("登录成功！！");
                Library.administratorControlPage();
                int i = sc.nextInt();
                if(i == 1){
                    // 添加读者信息
                    String licenses = " ";
                    String readername = " ";
                    String readerpwd = " ";
                    boolean cg = false;
                    Reader reader = null;
                    do {
                        System.out.println("请输入新读者编号：");
                        licenses = sc.next();
                        System.out.println("请输入读者用户名：");
                        readername = sc.next();
                        System.out.println("请输入读者密码：");
                        readerpwd = sc.next();
                        reader = new Reader(licenses,readername,readerpwd);
                        cg = Library.insertReaderInfo(reader);
                        if(!cg){
                            System.out.println("该读者已存在！！");
                        }
                    }while (!cg);
                    System.out.println("添加成功！！");
                } else if(i == 2){
                    // 删除读者信息
                    String licenses = " ";
                    String readername = " ";
                    String readerpwd = " ";
                    boolean cg = false;
                    Reader reader = null;
                    do {
                        System.out.println("请输入读者编号：");
                        licenses = sc.next();
                        System.out.println("请输入读者用户名：");
                        readername = sc.next();
                        System.out.println("请输入读者密码：");
                        readerpwd = sc.next();
                        reader = new Reader(licenses,readername,readerpwd);
                        cg = Library.deleteReaderInfo(reader);
                        if(!cg){
                            System.out.println("该读者不存在！！");
                        }
                    }while (!cg);
                    System.out.println("删除成功！！");
                } else if(i == 3){
                    // 查询读者信息
                    String licenses = " ";
                    boolean bool = false;
                    Reader reader;
                    do {
                        System.out.println("请输入读者编号：");
                        licenses = sc.next();
                        reader = new Reader(licenses);
                        bool = Library.readerSignIn(reader);
                        if(!bool){
                            System.out.println("该读者不存在！！");
                        }
                    }while (!bool);
                    for (Reader reader1 : Library.readerList) {
                        if(reader1.getUserLicenses().equals(reader.getUserLicenses())){
                            System.out.println("读者信息：" + reader1);
                            break;
                        }
                    }
                } else if(i == 4){
                    // 添加图书信息
                    String booklicenses = " ";
                    String bookname = " ";
                    String author = " ";
                    double price = 0;
                    boolean bool = false;
                    Book book = null;
                    do {
                        System.out.println("请输入图书ISBN码：");
                        booklicenses = sc.next();
                        System.out.println("请输入书名：");
                        bookname = sc.next();
                        System.out.println("请输入作者：");
                        author = sc.next();
                        System.out.println("请输入价格");
                        price = sc.nextDouble();
                        book = new Book(booklicenses,bookname,author,price);
                        bool = Library.insterBook(book);
                        if(!bool){
                            System.out.println("添加失败！书库中已有这本书.");
                        }
                    }while (!bool);
                    System.out.println("添加成功！！");
                } else if(i == 5){
                    // 删除图书信息
                    String booklicenses = " ";
                    String bookname = " ";
                    boolean bool = false;
                    Book book = null;
                    do {
                        System.out.println("请输入图书ISBN码：");
                        booklicenses = sc.next();
                        System.out.println("请输入书名：");
                        bookname = sc.next();
                        book = new Book(booklicenses,bookname);
                        bool = Library.deleteBook(book);
                        if(!bool){
                            System.out.println("删除失败！书库中没有这本书.");
                        }
                    }while (!bool);
                    System.out.println("删除成功！！");
                } else {
                    // 退出
                    Library.saveSysInfo();
                    System.exit(0);
                }
            } else if(functionCode == 4){
                Library.saveSysInfo();
                System.exit(0);
            }
        }
    }
}
