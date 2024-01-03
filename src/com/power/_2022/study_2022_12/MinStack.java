package com.power._2022.study_2022_12;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

// 155. 最小栈
// https://leetcode.cn/problems/min-stack/
class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        if (stack.size() == 0) {
            stack.push(val);
            minStack.push(val);
        } else {
            int temp = minStack.peek();
            if (val <= temp) {
                minStack.push(val);
            }
            stack.push(val);
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) return;
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
//        new HashSet<Integer>().size()
    }
    
    public int top() {
        if (stack.isEmpty()) return -1;
        return stack.peek();
    }
    
    public int getMin() {
        if (minStack.isEmpty()) return -1;
        return minStack.peek();
    }

    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring("dyig"));
    }

//    public static int lengthOfLongestSubstring(String s) {
//        int maxCount = 0;
//        int count = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            count = 1;
//            int[] arr = new int[127];
//            arr[c]++;
//            for (int j = i + 1; j < s.length(); j++) {
//                if (arr[s.charAt(j)] > 0) break;
//                arr[s.charAt(j)]++;
//                count++;
//            }
//            maxCount = Math.max(count,maxCount);
//            if (maxCount > s.length() - i) break;
//        }
//        return maxCount;
//    }


    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;//用于记录最大不重复子串的长度
        int left = 0;//滑动窗口左指针
        for (int i = 0; i < s.length() ; i++)
        {
            /**
             1、首先，判断当前字符是否包含在map中，如果不包含，将该字符添加到map（字符，字符在数组下标）,
             此时没有出现重复的字符，左指针不需要变化。此时不重复子串的长度为：i-left+1，与原来的maxLen比较，取最大值；

             2、如果当前字符 ch 包含在 map中，此时有2类情况：
             1）当前字符包含在当前有效的子段中，如：abca，当我们遍历到第二个a，当前有效最长子段是 abc，我们又遍历到a，
             那么此时更新 left 为 map.get(a)+1=1，当前有效子段更新为 bca；
             2）当前字符不包含在当前最长有效子段中，如：abba，我们先添加a,b进map，此时left=0，我们再添加b，发现map中包含b，
             而且b包含在最长有效子段中，就是1）的情况，我们更新 left=map.get(b)+1=2，此时子段更新为 b，而且map中仍然包含a，map.get(a)=0；
             随后，我们遍历到a，发现a包含在map中，且map.get(a)=0，如果我们像1）一样处理，就会发现 left=map.get(a)+1=1，实际上，left此时
             应该不变，left始终为2，子段变成 ba才对。

             为了处理以上2类情况，我们每次更新left，left=Math.max(left , map.get(ch)+1).
             另外，更新left后，不管原来的 s.charAt(i) 是否在最长子段中，我们都要将 s.charAt(i) 的位置更新为当前的i，
             因此此时新的 s.charAt(i) 已经进入到 当前最长的子段中！
             */
            if(map.containsKey(s.charAt(i)))
            {
                left = Math.max(left , map.get(s.charAt(i))+1);
            }
            //不管是否更新left，都要更新 s.charAt(i) 的位置！
            map.put(s.charAt(i) , i);
            maxLen = Math.max(maxLen , i-left+1);
        }

        return maxLen;
    }
}