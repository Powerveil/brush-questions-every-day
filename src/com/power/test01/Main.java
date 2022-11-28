package com.power.test01;

import java.util.*;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//        System.out.println(fun(a,b));
//
//    }
//
//    private static int fun(int a, int b) {
//        int temp = Math.abs(a);
//        if (b < 0) temp = -temp;
//        return temp;
//        LinkedList<Integer>
//
//    }

//    public static void main(String[] args) {
//        LinkedList<Integer> list = new LinkedList<>();
//        list.add(1); // add(elem): 表示尾插
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.add(6);
//        list.add(7);
//        System.out.println(list.size());
//        // foreach遍历
//        for (int e:list) {
//            System.out.print(e + " ");
//        }
//        System.out.println();
//        // 使用迭代器遍历---正向遍历
//        ListIterator<Integer> it = list.listIterator();
//        while(it.hasNext()){
//            System.out.print(it.next()+ " ");
//        }
//        System.out.println();
//        // 使用反向迭代器---反向遍历
//        ListIterator<Integer> rit = list.listIterator(list.size());
//        while (rit.hasPrevious()){
//            System.out.print(rit.previous() +" ");//1000 0000 0000 2048 + 64
//            //                                                          2112
//        }
//        System.out.println();
//    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5); // 从队尾入队列
        System.out.println(q.size());
        System.out.println(q.peek()); // 获取队头元素
        q.poll();
        System.out.println(q.poll()); // 从队头出队列，并将删除的元素返回
        if(q.isEmpty()){
            System.out.println("队列空");
        }else{
            System.out.println(q.size());
        }
    }
}
