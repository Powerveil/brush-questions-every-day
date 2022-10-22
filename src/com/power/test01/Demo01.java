package com.power.test01;

import java.util.*;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo01 {
    public static void main(String[] args) {
        Random random = new Random(0);
        System.out.println("nextInt():" + random.nextInt());
        System.out.println("nextInt():" + random.nextInt());
        System.out.println("nextInt(int bound):" + random.nextInt(5));
        System.out.println("nextBoolean():" + random.nextBoolean());
        System.out.println("nextDouble():" + random.nextDouble());
        System.out.println("nextFloat():" + random.nextFloat());

        byte[] bytes = new byte[4096];
        random.nextBytes(bytes);
        System.out.println("nextBytes后byte" + Arrays.toString(bytes));
        System.out.println("bytes[4095]:" + bytes[4095]);
        System.out.println("nextLong():" + random.nextLong());
        System.out.println("nextGaussian():" + random.nextGaussian());
        Collection<String> list = new ArrayList<>();
        list.add("nihao");
        list.add("nihao");
        list.add("nihao");
        System.out.println(list);
//        LinkedList
        System.out.println();
        

    }
}
