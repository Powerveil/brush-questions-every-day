package com.power._2022.study_2022_12.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author power
 * @Date 2022/12/15 21:46
 */
public class Testaaa {
    static final Pattern reUnicode = Pattern.compile("\\\\u([0-9a-zA-Z]{4})");

    public static String decode1(String s) {
        Matcher m = reUnicode.matcher(s);
        StringBuffer sb = new StringBuffer(s.length());
        while (m.find()) {
            m.appendReplacement(sb,
                    Character.toString((char) Integer.parseInt(m.group(1), 16)));
        }
        m.appendTail(sb);
        return sb.toString();
    }




    public static void main(String[] args) {
        System.out.println(decode1("\\u5806\\u6392\\u5e8f\\u662f\\u4e00\\u79cd\\u901a\\u8fc7\\u6784\\u5efa\\u5806\\u6765\\u6392\\u5e8f\\u7684\\u7b97\\u6cd5\\u3002\\u5728\\u5806\\u6392\\u5e8f\\u4e2d\\uff0c\\u6211\\u4eec\\u9996\\u5148\\u9700\\u8981\\u6784\\u5efa\\u4e00\\u4e2a\\u5806\\uff0c\\u7136\\u540e\\u5c06\\u5806\\u9876\\u5143\\u7d20\\uff08\\u6700\\u5927\\u503c\\uff09\\u4e0e\\u5806\\u7684\\u6700\\u540e\\u4e00\\u4e2a\\u5143\\u7d20\\u4ea4\\u6362\\u4f4d\\u7f6e\\uff0c\\u7136\\u540e\\u5bf9\\u5269\\u4f59\\u7684\\u5143\\u7d20\\u91cd\\u65b0\\u6784\\u5efa\\u5806\\u3002\\u91cd\\u590d\\u4e0a\\u8ff0\\u6b65\\u9aa4\\uff0c\\u76f4\\u5230\\u5806\\u4e2d\\u53ea\\u5269\\u4e0b\\u4e00\\u4e2a\\u5143\\u7d20\\u4e3a\\u6b62\\u3002\\n\\n\\u4e0b\\u9762\\u662f\\u4e00\\u4e2a\\u4f7f\\u7528Java\\u8bed\\u8a00\\u5b9e\\u73b0\\u5806\\u6392\\u5e8f\\u7684\\u7b80\\u5355\\u793a\\u4f8b\\uff1a\\n\\n```\\nimport\n" +
                "java.util.Arrays;\\n\\npublic class HeapSort {\\n\\n public static void sort(int[]\n" +
                "arr) {\\n // \\u6784\\u5efa\\u5806\\n for (int i = arr.length / 2 - 1; i >= 0; i--)\n" +
                "{\\n heapify(arr, arr.length, i);\\n }\\n\\n // \\u5806\\u6392\\u5e8f\\n for (int i =\n" +
                "arr.length - 1; i >= 0; i--) {\\n //\n" +
                "\\u5c06\\u5806\\u9876\\u5143\\u7d20\\u4e0e\\u6700\\u540e\\u4e00\\u4e2a\\u5143\\u7d20\\u4ea4\\u6362\\u4f4d\\u7f6e\\n\n" +
                "int temp = arr[0];\\n arr[0] = arr[i];\\n arr[i] = temp;\\n\\n //\n" +
                "\\u91cd\\u65b0\\u6784\\u5efa\\u5806\\n heapify(arr, i, 0);\\n }\\n }\\n\\n //\n" +
                "\\u6784\\u5efa\\u5806\\n private static void heapify(int[] arr, int n, int i) {\\n\n" +
                "int largest = i;\\n int left = 2 * i + 1;\\n int right = 2 * i + 2;\\n\\n //\n" +
                "\\u5982\\u679c\\u5de6\\u5b50\\u8282\\u70b9\\u6bd4\\u6839\\u8282\\u70b9\\u5927\\uff0c\\u5219\\u5c06\\u6700\\u5927\\u503c\\u66f4\\u65b0\\u4e3a\\u5de6\\u5b50\\u8282\\u70b9\\n\n" +
                "if (left < n && arr[left] > arr[largest]) {\\n largest = left;\\n }\\n\\n //\n" +
                "\\u5982\\u679c\\u53f3\\u5b50\\u8282\\u70b9\\u6bd4\\u6839\\u8282\\u70b9\\u5927\\uff0c\\u5219\\u5c06\\u6700\\u5927\\u503c\\u66f4\\u65b0\\u4e3a\\u53f3\\u5b50\\u8282\\u70b9\\n\n" +
                "if (right < n && arr[right] > arr[largest]) {\\n largest = right;\\n }\\n\\n //\n" +
                "\\u5982\\u679c\\u6700\\u5927\\u503c\\u4e0d\\u662f\\u6839\\u8282\\u70b9\\uff0c\\u5219\\u5c06\\u6839\\u8282\\u70b9\\u4e0e\\u6700\\u5927\\u503c\\u4ea4\\u6362\\u4f4d\""));
    }
}
