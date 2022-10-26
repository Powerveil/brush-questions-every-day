package com.power.test01;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo3 {

    int a;
    int sum;
//    public static void main(String[] args) {
//
//    }

    public void function(int len) {
        int count = 0;//1
        //       1       n + 1    n - 1
        for (int i = 0; i < len; i++) {
            count++;//n
        }
    }


    // 计算func2的时间复杂度？
    void func2(int N) {
        int count = 0;
        for (int k = 0; k < 2 * N; k++) {
            count++;
        }
        int M = 10;
        while ((M--) > 0) {
            count++;
        }
        System.out.println(count);
    }

    // 计算func3的时间复杂度？
    void func3(int N, int M) {
        int count = 0;
        for (int k = 0; k < M; k++) {
            count++;
        }
        for (int k = 0; k < N; k++) {
            count++;
        }
        System.out.println(count);
    }


    // 计算func4的时间复杂度？
    void func4(int N) {
        int count = 0;
        for (int k = 0; k < 100; k++) {
            count++;
        }
        System.out.println(count);
    }


    // 计算bubbleSort的时间复杂度？
    void bubbleSort(int[] array) {
        for (int end = array.length; end > 0; end--) {
            boolean sorted = true;
            for (int i = 1; i < end; i++) {
                if (array[i - 1] > array[i]) {
                    Swap(array, i - 1, i);
                    sorted = false;
                }
            }
            if (sorted == true) {
                break;
            }
        }
    }

    private void Swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }


    // 计算binarySearch的时间复杂度？
    int binarySearch(int[] array, int value) {
        int begin = 0;
        int end = array.length - 1;
        while (begin <= end) {
            int mid = begin + ((end - begin) / 2);
            if (array[mid] < value) begin = mid + 1;
            else if (array[mid] > value) end = mid - 1;
            else return mid;
        }
        return -1;
    }


    // 计算阶乘递归factorial的时间复杂度？
    long factorial(int N) {
        return N < 2 ? N : factorial(N - 1) * N;
    }


//    // 计算斐波那契递归fibonacci的时间复杂度？
//    int fibonacci(int N) {
//        return N < 2 ? N : fibonacci(N-1)+fibonacci(N-2);
//    }


//    // 计算bubbleSort的空间复杂度？
//    void bubbleSort(int[] array) {
//        for (int end = array.length; end > 0; end--) {
//            boolean sorted = true;
//            for (int i = 1; i < end; i++) {
//                if (array[i - 1] > array[i]) {
//                    Swap(array, i - 1, i);
//                    sorted = false;
//                }
//            }
//            if (sorted == true) {
//                break;
//            }
//        }
//    }


    // 计算fibonacci的空间复杂度？
    long[] fibonacci(int n) {
        long[] fibArray = new long[n + 1];
        fibArray[0] = 0;
        fibArray[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
        }
        return fibArray;
    }

    // 计算阶乘递归Factorial的空间复杂度？
    long factorial(long N) {
        return N < 2 ? N : factorial(N - 1) * N;
    }


//    public static void main(String[] args) {
//        // ArrayList创建，推荐写法
//        // 构造一个空的列表
//        List<Integer> list1 = new ArrayList<>();
//        // 构造一个具有10个容量的列表
//        List<Integer> list2 = new ArrayList<>(10);
//        list2.add(1);
//        list2.add(2);
//        list2.add(3);
//        // list2.add("hello"); // 编译失败，List<Integer>已经限定了，list2中只能存储整形元素
//        // list3构造好之后，与list中的元素一致
//        ArrayList<Integer> list3 = new ArrayList<>(list2);
//        // 避免省略类型，否则：任意类型的元素都可以存放，使用时将是一场灾难
//        List list4 = new ArrayList();
//        list4.add("111");
//        list4.add(100);
//    }

//    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("JavaSE");
//        list.add("JavaWeb");
//        list.add("JavaEE");
//        list.add("JVM");
//        list.add("测试课程");
//        System.out.println(list);
//        // 获取list中有效元素个数
//        System.out.println(list.size());
//        // 获取和设置index位置上的元素，注意index必须介于[0, size)间
//        System.out.println(list.get(1));
//        list.set(1, "JavaWEB");
//        System.out.println(list.get(1));
//        // 在list的index位置插入指定元素，index及后续的元素统一往后搬移一个位置
//        list.add(1, "Java数据结构");
//        System.out.println(list);
//        // 删除指定元素，找到了就删除，该元素之后的元素统一往前搬移一个位置
//        list.remove("JVM");
//        System.out.println(list);
//        // 删除list中index位置上的元素，注意index不要超过list中有效元素个数,否则会抛出下标越界异常
//        list.remove(list.size() - 1);
//        System.out.println(list);
//        // 检测list中是否包含指定元素，包含返回true，否则返回false
//        if (list.contains("测试课程")) {
//            list.add("测试课程");
//        }
//        // 查找指定元素第一次出现的位置：indexOf从前往后找，lastIndexOf从后往前找
//        list.add("JavaSE");
//        System.out.println(list.indexOf("JavaSE"));
//        System.out.println(list.lastIndexOf("JavaSE"));
//        // 使用list中[0, 4)之间的元素构成一个新的ArrayList返回
//        List<String> ret = list.subList(0, 4);
//        System.out.println(ret);
//        list.clear();
//        System.out.println(list.size());
//    }


    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("aa");
    }

    public int findMinimum(int n, int[] left, int[] right) {
        // write code here
        int sum=0;
        int leftSum=0;
        int rightSum=0;
        int leftMin=Integer.MAX_VALUE;
        int rightMin=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(left[i]*right[i]==0){//某种颜色的一只手的手套个数为0的时候，另一只手的手套数量(无法配对)
                sum=sum+left[i]+right[i];
            }else{
                leftSum+=left[i];//左手总数
                if(leftMin>left[i]){
                    leftMin=left[i];
                }
                rightSum+=right[i];//右手总数
                if(rightMin>right[i]){
                    rightMin=right[i];
                }
            }
        }
        return sum+Math.min(leftSum-leftMin+1,rightSum-rightMin+1)+1;

    }

}
