package com.power.september_21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppleTest {
    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(
                new Apple("红色", 120),
                new Apple("绿色", 140),
                new Apple("黄色", 150));
        System.out.println(list);
        List<Apple> res = filterApples(list, (t) -> "红色".equals(t.getColor()));
        System.out.println(res);
    }

    /**
     * 行为参数化 多态  使用泛型进一步抽象
     *
     * @param inventory
     * @param p
     * @return
     */
    public static <T> List<T> filterApples(List<T> inventory, ApplePredicate<T> p) {
        List<T> list = new ArrayList<>();
        for (T t : inventory) {
           if (p.test(t)) {
               list.add(t);
           }
        }
        return list;
    }
}