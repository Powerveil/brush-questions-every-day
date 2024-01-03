package com.power._2023.study_2023_7;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Example {
    public static void main(String[] args) {
//        long loginTime = 1688262878880L;
//        long aa = 1688262683L;
//        String formattedTime = parseTime(loginTime);
//        System.out.println(formattedTime);
//        System.out.println(new Date());

        HashMap<String, String> map = new HashMap<>();

        map.put("aa", "dsa");

        map.get("dsa");

    }

    public static String parseTime(long timestamp) {
        Date date = new Date(timestamp);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
}