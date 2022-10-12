package com.power.september_21;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo17 {
    public static void main(String[] args) {
        String str = "123";
        ww(str);

    }


    public static void ww(String str) {
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length - 1; i++) {
            qq(chars, chars.length - 1, i + 1);
            swap(chars, i, i + 1);
        }
    }

    public static void qq(char[] chars, int count, int i) {
        System.out.println(chars);
        if (count < i) {
            return;
        }

        swap(chars,count - 1, count);
        qq(chars, count - 1, i);
        swap(chars,count - 1, count);
    }


    public static void swap(char[] chars, int indexSource, int indexDistance) {
        char temp = chars[indexSource];
        chars[indexSource] = chars[indexDistance];
        chars[indexDistance] = temp;
    }

}
