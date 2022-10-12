package com.power.september_21;

import java.util.*;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo18 {
//    public static void main(String[] args) {
//        String s = "1234";
//        char[] chars = s.toCharArray();
//        Arrays.sort(chars);
//        String s1 = new String(chars);
//        System.out.println(Arrays.toString(chars));
//        System.out.println(s1);
//        System.out.println(chars.toString());
//    }


//    public List<String> removeAnagrams(String[] words) {
//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < words.length; i++) {
//            char[] chars = words[i].toCharArray();
//            Arrays.sort(chars);
//            words[i] = new String(chars);
//            if (list.isEmpty() || !words[i].equals(list.get(list.size() - 1))) {
//                list.add(words[i]);
//            }
//        }
//        return list;
//    }


//    public static List<String> removeAnagrams(String[] words) {
//        List<String> list = new ArrayList<>();
//        if (words.length == 0) return list;
//
//        list.add(words[0]);
//        for (int i = 1; i < words.length; i++) {
//            if (ww(words[i - 1], words[i])) {
//                list.add(words[i]);
//            }
//        }
//        return list;
//    }
//
//    public static boolean ww(String s1, String s2) {
//        if (s1.length() != s2.length()) return true;
//        char[] chars1 = s1.toCharArray();
//        Arrays.sort(chars1);
//        char[] chars2 = s2.toCharArray();
//        Arrays.sort(chars2);
//
//        return !Arrays.equals(chars1,chars2);
//    }

    public static List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        String pre = " ";
        for (int i = 0; i < words.length; ++i) {
            char[] cs = words[i].toCharArray();
            Arrays.sort(cs);
            String s = String.valueOf(cs);
            if (i >= 1 && s.equals(pre)) continue;
            ans.add(words[i]);
            pre = s;
        }
        return ans;
    }


//    public int minimumOperations(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            if (num > 0) {
//                set.add(num);
//            }
//        }
//        return set.size();
//    }


//    public int minimumOperations(int[] nums) {
//        int ans = 0;
//        int n = nums.length;
//
//        Arrays.sort(nums);
//        int k = 0;
//        while (!check(nums, n)) {
//            for (int j = k; j < n; j++) {
//                if (nums[j] != 0) {
//                    int temp = nums[j];
//                    nums[j] -= temp;
//                    j++;
//                    k = j;
//                    while (j < n && nums[j] != 0) {
//                        nums[j] -= temp;
//                        j++;
//                    }
//                }
//            }
//            ans++;
//        }
//
//        return ans;
//    }
//
//    private boolean check(int[] nums, int n) {
//        for (int i = 0; i < n; i++) {
//            if (nums[i] != 0) {
//                return false;
//            }
//        }
//        return true;
//    }


    public int minimumOperations(int[] nums) {
        /*
        找出除0之外有多少个数
         */
        int[] cntMap = new int[101];
        int res = 0;
        for (int num : nums) {
            if (num != 0 && ++cntMap[num] == 1) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(removeAnagrams(new String[] {"abba","baba","bbaa","cd","cd"}));
    }
}
