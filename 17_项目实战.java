// =============================================
// 第 17 课：项目实战 - 图书管理系统
// =============================================
// 上节课我们学了开发实战入门。
// 这节课我们要做一个完整的项目——图书管理系统。
// 这个项目会综合运用：类和对象、继承和多态、集合框架、异常处理、文件操作。
//
// 生活类比：
//   项目实战就像盖房子——
//   先画图纸（需求分析），再打地基（搭建框架），
//   然后砌墙（实现功能），最后装修（测试优化）。
//   每一步都不能少，但只要你按部就班，就能盖出一栋好房子！

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

class LibrarySystem {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("图书管理系统");
        System.out.println("========================================");

        // 创建图书馆
        Library library = new Library();
        library.load();  // 加载数据

        Scanner scanner = new Scanner(System.in);

        // 主循环
        while (true) {
            // 显示菜单
            System.out.println("\n================================");
            System.out.println("图书管理系统");
            System.out.println("================================");
            System.out.println("1. 添加图书");
            System.out.println("2. 查看所有图书");
            System.out.println("3. 查找图书");
            System.out.println("4. 借阅图书");
            System.out.println("5. 归还图书");
            System.out.println("6. 退出");
            System.out.println("================================");

            System.out.print("请选择(1-6): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    // 添加图书
                    System.out.print("书名: ");
                    String title = scanner.nextLine();
                    System.out.print("作者: ");
                    String author = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    library.addBook(new Book(title, author, isbn));
                    break;

                case "2":
                    // 查看所有
                    library.showAll();
                    break;

                case "3":
                    // 查找
                    System.out.print("请输入书名或作者: ");
                    String keyword = scanner.nextLine();
                    library.searchBook(keyword);
                    break;

                case "4":
                    // 借阅
                    System.out.print("请输入ISBN: ");
                    String borrowIsbn = scanner.nextLine();
                    library.borrowBook(borrowIsbn);
                    break;

                case "5":
                    // 归还
                    System.out.print("请输入ISBN: ");
                    String returnIsbn = scanner.nextLine();
                    library.returnBook(returnIsbn);
                    break;

                case "6":
                    // 退出
                    library.save();
                    System.out.println("感谢使用，再见！");
                    scanner.close();
                    return;

                default:
                    System.out.println("无效选择，请重试！");
            }
        }
    }
}

// =============================================
// Book 类（图书）
// =============================================

class Book {
    /*
     * 图书类
     *
     * 【属性】
     * - title: 书名
     * - author: 作者
     * - isbn: ISBN号
     * - borrowed: 是否被借出
     *
     * 【方法】
     * - getter/setter
     * - borrow(): 借阅
     * - returnBook(): 归还
     * - toString(): 转为字符串
     */

    private String title;
    private String author;
    private String isbn;
    private boolean borrowed;

    /**
     * 构造方法
     *
     * @param title  字符串，书名
     * @param author 字符串，作者
     * @param isbn   字符串，ISBN号
     */
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.borrowed = false;
    }

    // getter 方法
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isBorrowed() { return borrowed; }

    /**
     * 借阅图书
     *
     * @return true 成功，false 已被借出
     */
    public boolean borrow() {
        if (borrowed) {
            return false;
        }
        borrowed = true;
        return true;
    }

    /**
     * 归还图书
     */
    public void returnBook() {
        borrowed = false;
    }

    @Override
    public String toString() {
        String status = borrowed ? "[已借出]" : "[可借]";
        return String.format("%s %s - %s %s", status, title, author, isbn);
    }
}

// =============================================
// Library 类（图书馆）
// =============================================

class Library {
    /*
     * 图书馆类
     *
     * 【属性】
     * - books: ArrayList，存储所有图书
     * - filename: 保存文件名
     *
     * 【方法】
     * - addBook(book): 添加图书
     * - showAll(): 显示所有图书
     * - searchBook(keyword): 查找图书
     * - borrowBook(isbn): 借阅图书
     * - returnBook(isbn): 归还图书
     * - save(): 保存到文件
     * - load(): 从文件加载
     */

    private ArrayList<Book> books;
    private String filename = "library.txt";

    public Library() {
        this.books = new ArrayList<>();
    }

    /**
     * 添加图书
     *
     * @param book Book 对象
     */
    public void addBook(Book book) {
        books.add(book);
        System.out.println("✓ 已添加: " + book.getTitle());
        save();
    }

    /**
     * 显示所有图书
     */
    public void showAll() {
        if (books.isEmpty()) {
            System.out.println("暂无图书！");
            return;
        }

        System.out.println("\n" + "=".repeat(60));
        System.out.printf("%-6s%-20s%-15s%-15s%-10s%n", "序号", "书名", "作者", "ISBN", "状态");
        System.out.println("=".repeat(60));

        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            String status = b.isBorrowed() ? "已借出" : "可借";
            System.out.printf("%-6d%-20s%-15s%-15s%-10s%n",
                i + 1, b.getTitle(), b.getAuthor(), b.getIsbn(), status);
        }

        System.out.println("=".repeat(60));
    }

    /**
     * 查找图书
     *
     * @param keyword 关键词（书名或作者）
     */
    public void searchBook(String keyword) {
        System.out.println("\n查找结果:");
        boolean found = false;

        for (Book b : books) {
            if (b.getTitle().contains(keyword) || b.getAuthor().contains(keyword)) {
                System.out.println("  " + b);
                found = true;
            }
        }

        if (!found) {
            System.out.println("  未找到相关图书");
        }
    }

    /**
     * 借阅图书
     *
     * @param isbn 字符串，ISBN号
     */
    public void borrowBook(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                if (b.borrow()) {
                    System.out.println("✓ 借阅成功: " + b.getTitle());
                    save();
                } else {
                    System.out.println("✗ 该书已被借出");
                }
                return;
            }
        }
        System.out.println("✗ 未找到该图书");
    }

    /**
     * 归还图书
     *
     * @param isbn 字符串，ISBN号
     */
    public void returnBook(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                b.returnBook();
                System.out.println("✓ 归还成功: " + b.getTitle());
                save();
                return;
            }
        }
        System.out.println("✗ 未找到该图书");
    }

    /**
     * 保存到文件
     */
    public void save() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Book b : books) {
                writer.println(b.getTitle() + "," + b.getAuthor() + "," +
                    b.getIsbn() + "," + b.isBorrowed());
            }
        } catch (IOException e) {
            System.out.println("保存失败: " + e.getMessage());
        }
    }

    /**
     * 从文件加载
     */
    public void load() {
        File file = new File(filename);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    Book book = new Book(parts[0], parts[1], parts[2]);
                    if (Boolean.parseBoolean(parts[3])) {
                        book.borrow();
                    }
                    books.add(book);
                }
            }
            System.out.println("已加载 " + books.size() + " 本图书");
        } catch (IOException e) {
            System.out.println("加载失败: " + e.getMessage());
        }
    }
}

// =============================================
// 课程总结
// =============================================
/*
 * 核心收获：
 * - 完整项目的开发流程：需求 → 设计 → 实现 → 测试
 * - 类的设计要遵循单一职责原则
 * - 数据持久化通过文件读写实现
 *
 * 常见陷阱：
 * - 不先设计就开始写，导致频繁重构
 * - 文件操作不做异常处理
 * - 不做数据验证，用户输入可能导致程序崩溃
 *
 * 你现在已经可以独立开发简单的 Java 程序了！
 * 继续练习，编程之路才刚刚开始。
 */

// =============================================
// 恭喜完成
// =============================================
// 恭喜你完成了第 17 课：项目实战！
// 你现在已经可以独立开发简单的 Java 程序了！

// =============================================
// 恭喜完成
// =============================================
class CourseComplete {
    public static void main(String[] args) {
        System.out.println("\n恭喜你完成了全部 Java 基础课程！");
        System.out.println("你已经掌握了：");
        System.out.println("  ✓ 变量、运算符、条件、循环");
        System.out.println("  ✓ 数组、方法、字符串");
        System.out.println("  ✓ 面向对象（类、继承、多态）");
        System.out.println("  ✓ 异常处理、集合框架");
        System.out.println("  ✓ 泛型、接口、文件操作");
        System.out.println("  ✓ Lambda、Stream、多线程");
        System.out.println("\n接下来你可以：");
        System.out.println("1. 学习 Spring Boot 框架");
        System.out.println("2. 学习 MySQL 数据库");
        System.out.println("3. 学习 Maven/Gradle 构建工具");
        System.out.println("4. 参与开源项目");
    }
}
