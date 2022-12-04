package com.power.september_21;

import java.util.*;
import java.util.Arrays;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo19 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String str1 = scanner.nextLine();
//        String str2 = scanner.nextLine();
//        int count = 0;
//        for (int i = 0; i < str1.length(); i++) {
//            StringBuilder sb = new StringBuilder(str1);
//            sb.insert(i, str2);
//            if (Ishuiwen(sb.toString())) count++;
//        }
//        System.out.println(count);
//
//    }
//
//    public static boolean Ishuiwen(String str) {
//        int left = 0;
//        int right = str.length() - 1;
//        while (left < right) {
//            if (str.charAt(left) != str.charAt(right)) return false;
//            left++;
//            right--;
//        }
//        return true;
//    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = scanner.nextInt();
//        }
//
//        int left = 0;
//        int right = n - 1;
//        while (left < n && nums[left] <= 0) left++;
//        while (right >= 0 && nums[right] <= 0) right--;
//
//        int max = nums[0];
//        for (int i = 0; i < n; i++) {
//            if (nums[i] > max) {
//                max = nums[i];
//            }
//        }
//        for (int i = left; i <= right; i++) {
//            int sum = 0;
//            for (int j = i; j <= right; j++) {
//                sum += nums[j];
//                if (sum > max) {
//                    max = sum;
//                }
//            }
//        }
//        System.out.println(max);
//    }

    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

//    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
//        List<List<Integer>> list = new ArrayList<>();
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int[] nums : items1) {
//            map.put(nums[0], map.getOrDefault(nums[0], 0) + nums[1]);
//        }
//
//        for (int[] nums : items2) {
//            map.put(nums[0], map.getOrDefault(nums[0], 0) + nums[1]);
//        }
//
//        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
//
//        int[][] ww = new int[map.size()][2];
//        int i = 0;
//        for (Map.Entry<Integer, Integer> entry : entries) {
//            ww[i][0] = entry.getKey();
//            ww[i++][1] = entry.getValue();
//        }
//
//        java.util.Arrays.sort(ww, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] - o2[0];
//            }
//        });
//
//        for (int[] ints : ww) {
//            ArrayList<Integer> arrayList = new ArrayList<>();
//            arrayList.add(ints[0]);
//            arrayList.add(ints[1]);
//            list.add(arrayList);
//        }
//        return list;
//    }


    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> res = new ArrayList<>();
        int[] cntMap = new int[1001];
        for (int[] p : items1) {
            cntMap[p[0]] += p[1];
        }
        for (int[] p : items2) {
            cntMap[p[0]] += p[1];
        }
        for (int i = 0; i <= 1000; i++) {
            if (cntMap[i] != 0) res.add(java.util.Arrays.asList(i, cntMap[i]));
        }
        return res;
    }



//    public int[] answerQueries(int[] nums, int[] queries) {
//        int[] answer = new int[queries.length];
//        java.util.Arrays.sort(nums);
//        int sumS = 0;
//        for (int i = 0; i < nums.length; i++) sumS += nums[i];
//
//        for (int i = 0; i < queries.length; i++) {
//            int len = 0;
//            int sum = sumS;
//            for (int j = nums.length - 1; j >= 0; j--) {
//                if (sum <= queries[i]) {
//                    len = j + 1;
//                    break;
//                }
//                sum -= nums[j];
//            }
//            answer[i] = len;
//        }
//        return answer;
//    }


    public static int[] answerQueries(int[] nums, int[] queries) {
        int[] answer = new int[queries.length];
        java.util.Arrays.sort(nums);
        int[] arr = new int[nums.length];
        for (int i = 0; i < arr.length; i++) arr[i] = nums[i];
        for (int i = 1; i < arr.length; i++) arr[i] += arr[i - 1];
        for (int i = 0; i < queries.length; i++) {
            int len = 0;

            int left = 0;
            int right = nums.length - 1;
            int mid = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                if (queries[i] < arr[mid]) {
                    right = mid - 1;
                } else if (queries[i] > arr[mid]){
                    left = mid + 1;
                } else {
                    len = mid + 1;
                    break;
                }
            }
            if (left > right) len = left;

            answer[i] = len;
        }
        return answer;
    }

    public static void main(String[] args) {
//        System.out.println(java.util.Arrays.toString(answerQueries(new int[] {4,5,2,1}, new int[] {3,10,21})));
        System.out.println(Arrays.toString(answerQueries(new int[] {1000000}, new int[] {1000000})));
    }
}
