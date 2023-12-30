package com.power.study_2023_4;

import java.io.*;
import java.util.*;

public class BookManager {
//    private static final String FILE_NAME = "books.ser";
    // 数据存放的位置
    private static final String FILE_NAME = "D:/books.ser";

    private Vector<Book> books;

    public BookManager() {
        // Load data from file or create a new Vector if file doesn't exist
        try {
            FileInputStream fis = new FileInputStream(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            books = (Vector<Book>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            books = new Vector<Book>();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookManager manager = new BookManager();

        System.out.println("欢迎来到图书管理员！");
        boolean running = true;

        while (running) {
            System.out.println("请选择一个选项：");
            System.out.println("1. 打印书单");
            System.out.println("2. 添加一本新书");
            System.out.println("3. 搜索一本书");
            System.out.println("4. 删除一本书");
            System.out.println("5. 退出");
            System.out.print("请输入你的选择：");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    manager.printBookList();
                    break;
                case 2:
                    manager.addBook(scanner);
                    break;
                case 3:
                    manager.searchBook(scanner);
                    break;
                case 4:
                    manager.deleteBook(scanner);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("无效选择！");
            }
            System.out.println("==================================================");
        }

        // Save data to file
        try {
            FileOutputStream fos = new FileOutputStream(FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(manager.getBooks());
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("再见！");
    }

    public void printBookList() {
        System.out.println("书单：");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void addBook(Scanner scanner) {
        System.out.println("输入书籍详细信息：");
        System.out.print("书号：");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("作者姓名：");
        String author = scanner.nextLine();
        System.out.print("标题：");
        String title = scanner.nextLine();
        System.out.print("出版商：");
        String publisher = scanner.nextLine();
        System.out.print("价格：");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        Book book = new Book(id, author, title, publisher, price);
        books.add(book);
        System.out.println("图书添加成功！");
    }

    public void searchBook(Scanner scanner) {
        System.out.print("输入书号搜索：");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        for (Book book : books) {
            if (book.getId() == id) {
                System.out.println("找到的书：");
                System.out.println(book);
                return;
            }
        }

        System.out.println("找不到书！");
    }

    public void deleteBook(Scanner scanner) {
        System.out.print("输入要删除的图书 ID：");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
                System.out.println("图书删除成功！");
                return;
            }
        }

        System.out.println("找不到书！");
    }

    public Vector<Book> getBooks() {
        return books;
    }
}

class Book implements Serializable {
    private int id;
    private String author;
    private String title;
    private String publisher;
    private double price;

    public Book(int id, String author, String title, String publisher, double price) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                '}';
    }
}