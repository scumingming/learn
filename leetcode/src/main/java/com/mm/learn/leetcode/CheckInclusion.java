package com.mm.learn.leetcode;

import java.util.Arrays;

/**
 * Created by wangmingming on 2019/4/3.
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 */
public class CheckInclusion {

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab","casba"));

    }


    public static boolean checkInclusion(String s1, String s2) {

        int[] s1Array = new int[26];
        for(int i=0; i< s1.length(); i++) {
            s1Array[s1.charAt(i) - 'a']++;
        }
        System.out.println(Arrays.toString(s1Array));
        int[] s2Array;
        for(int i=0; i< s2.length() - s1.length() + 1; i++) {
            s2Array = new int[26];
            for(int j=i; j< i + s1.length(); j++) {
                s2Array[s2.charAt(j) - 'a']++;
            }
            System.out.println(Arrays.toString(s2Array));

            if(Arrays.equals(s1Array,s2Array)) return true;

        }
        return  false;

    }
}
