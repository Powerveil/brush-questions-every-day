package com.power.test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Demo6 {
    public static void main(String[] args) throws IOException {
        // 1. 让用户输入了必要的信息
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要扫描的路径: ");
        File rootDir = new File(scanner.next());
        if (!rootDir.isDirectory()) {
            System.out.println("您输入的目录不存在!");
            return;
        }
        System.out.println("请输入要搜索的关键词: ");
        String toDelete = scanner.next();

        // 2. 遍历目录, 需要借助一个核心方法, listFiles()
        scanDir(rootDir, toDelete);
        System.out.println();
    }

    // 借助这个方法进行递归遍历
    private static void scanDir(File rootDir, String toDelete) throws IOException {
//        System.out.println("当前访问: " + rootDir.getCanonicalPath());
        File[] files = rootDir.listFiles();
        if (files == null) {
            // 说明 rootDir 是一个空的目录~~
            return;
        }
        // 如果目录非空, 则循环遍历每个元素.
        for (File f : files) {
            if (f.isDirectory()) {
                scanDir(f, toDelete);
            } else {
                // 不是目录, 普通文件, 判定文件名是否符合要求, 是否要进行删除
//                checkDelete(f, toDelete);
                checkFile(f, toDelete);
            }
        }
    }


    public static void checkFile(File f, String str) throws IOException {
        String name = f.getName();
//        System.out.println("name=" + name);
        int i = name.indexOf(".");

        if (i > 0) {
//            System.out.println("i=" + i);
            String preName = name.substring(0, i);
            if (preName.equals(str)) {
//                System.out.println("路径:>" + f.getCanonicalPath() + "\n文件名:>" + f.getName());
//                f.getCanonicalFile()
                System.out.println("符合条件的文件:>" + f.getCanonicalPath());
            }
        }
    }

    private static void checkDelete(File f, String toDelete) throws IOException {
        if (f.getName().contains(toDelete)) {
            System.out.println("该单词" + toDelete + " 被 " + f.getCanonicalPath() + " 包含了, 是否要删除? (Y/N)");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();
            if (choice.equals("Y") || choice.equals("y")) {
                f.delete();
            }
        }
    }
}