package com.power.test01;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo3 {
    public static void main(String[] args) {

    }

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
            if (array[mid] < value)
                begin = mid + 1;
            else if (array[mid] > value)
                end = mid - 1;
            else
                return mid;
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
}
