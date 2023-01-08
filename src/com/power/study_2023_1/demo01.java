package com.power.study_2023_1;

import java.util.*;

/**
 * @author power
 * @Date 2023/1/7 15:58
 */
public class demo01 {
    public static void main(String[] args) {
//        String str1 = "通话";
//        String str2 = "重地";
//        System.out.println(String.format("str1：%d | str2：%d",  str1.hashCode(),str2.hashCode()));
//        System.out.println(str1.equals(str2));
//        System.out.println("123dSADASDA".toLowerCase());
//
//        String[] array = new String[]{"王磊","的博客"};
//        List s = Arrays.asList(array);
//
//        List<String> list = new ArrayList<String>();
//        list.add("王磊");
//        list.add("的博客");
//        list.toArray();


//        Collection
        List<String> list = new ArrayList<>();
        list.add("x");
        Collection<String> clist = Collections.unmodifiableCollection(list);
        System.out.println(clist);
        clist.add("y"); // 运行时此行报错
        System.out.println(list.size());

    }


}
