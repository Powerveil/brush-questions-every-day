package com.power.september_21;

import java.util.*;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo11 {
//    public static int[] sortEvenOdd(int[] nums) {
//        int count1 = 0;
//        int count2 = 0;
//        for (int num : nums) {
//            if ((num & 1) == 1) {
//                count1++;//奇数
//            } else {
//                count2++;//偶数
//            }
//        }
//
//        Integer[][] arr1 = new Integer[count1][2];
//        Integer[][] arr2 = new Integer[count2][2];
//        int j = 0;
//        int k = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            if ((nums[i] & 1) == 1) {
//                arr1[j][0] = nums[i];
//                arr1[j++][1] = i;
//            } else {
//                arr2[k][0] = nums[i];
//                arr2[k++][1] = i;
//            }
//        }
//        Arrays.sort(arr1, new Comparator<Integer[]>() {
//            @Override
//            public int compare(Integer[] o1, Integer[] o2) {
//                return o2[0] - o1[0];
//            }
//        });
//        Arrays.sort(arr2, new Comparator<Integer[]>() {
//            @Override
//            public int compare(Integer[] o1, Integer[] o2) {
//                return o1[0] - o2[0];
//            }
//        });
//        for (Integer[] num : arr1) {
//            nums[num[1]] = num[0];
//        }
//        for (Integer[] num : arr1) {
//            nums[num[1]] = num[0];
//        }
//
//        return nums;
//    }

//    public static int[] sortEvenOdd1(int[] nums) {
//        int ww = nums.length / 2;
//        int ee = nums.length % 2;
//        Integer[] arr1 = new Integer[ww];//奇数
//        Integer[] arr2 = new Integer[ww + ee];//偶数
//        int j = 0;
//        int k = 0;
//        for (int i =  0; i < nums.length; i++) {
//            if (i % 2 == 1) {
//                arr1[j++] = nums[i];
//            } else {
//                arr2[k++] = nums[i];
//            }
//        }
//
//        Arrays.sort(arr1, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;//奇数逆序
//            }
//        });
//        Arrays.sort(arr2, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;//偶数正序
//            }
//        });
//
//        j = 0;
//        k = 0;
//        for (int i =  0; i < nums.length; i++) {
//            if (i % 2 == 1) {
//                nums[i] = arr1[j++];
//            } else {
//                nums[i] = arr2[k++];
//            }
//        }
//        return nums;
//    }


//    public int[] sortEvenOdd2(int[] nums) {
//        List<Integer> even=new ArrayList<>();
//        List<Integer> odd=new ArrayList<>();
//        for(int i=0;i<nums.length;i++){
//            if((i&1)==1){odd.add(nums[i]);}
//            else{even.add(nums[i]);}
//        }
//        Collections.sort(even);
//        Collections.sort(odd,(a,b)->b-a);
//        for(int i=0;i<even.size();i++){nums[2*i]=even.get(i);}
//        for(int i=0;i<odd.size();i++){nums[2*i+1]=odd.get(i);}
//        return nums;
//    }


    public int[] sortEvenOdd3(int[] nums) {
        final int n = nums.length;
        for (int k = 1; k < n; k += 2) {
            int max = k;
            for (int i = k + 2; i < n; i += 2) {
                if (nums[i] > nums[max]) max = i;
            }
            int t = nums[k];
            nums[k] = nums[max];
            nums[max] = t;
        }
        int e = n;
        if (e % 2 != 0) e -= 1;
        else e -= 2;
        for (int k = 0; k < n; k += 2) {
            boolean swap = false;
            for (int i = e; i - 2 >= k; i -= 2) {
                if (nums[i] < nums[i - 2]) {
                    int t = nums[i];
                    nums[i] = nums[i - 2];
                    nums[i - 2] = t;
                    swap = true;
                }
            }
            if (!swap) break;
        }
        return nums;

    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(sortEvenOdd(new int[] {4,1,2,3})));
    }
}
