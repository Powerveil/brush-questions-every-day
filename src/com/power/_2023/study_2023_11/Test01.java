package com.power._2023.study_2023_11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Powerveil
 * @Date 2023/11/19 22:34
 */
public class Test01 {
    public static void main(String[] args) {
//        Pattern pattern = Pattern.compile("-");
//        Matcher matcher = pattern.matcher("abcd-123a-4567-hdef");

        String str = "bbb";
        String regex = "bbbbb";

        System.out.println(regex.contains(str));

        System.out.println(str.matches(regex));
    }
}
