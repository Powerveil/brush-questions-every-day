package com.power._2024._1;

/**
 * @author Powerveil
 * @Date 2024/1/2 19:37
 */
public class Test01 {
    public static void main(String[] args) {
        try {
            System.out.println("Hello");
            int a = 10;
            int b = 10;
            System.out.println(a + b);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }
}
