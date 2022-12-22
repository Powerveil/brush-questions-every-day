package com.power.study_2022_12;

/**
 * @author power
 * @Date 2022/12/22 15:29
 */
public class Demo06 {
    public static void main(String[] args) {
        System.out.println(test());
    }

    private static int test() {
        int x = 1;
        try {
            return x;
        } finally {
            ++x;
            x++;
            ++x;
        }
    }
}
