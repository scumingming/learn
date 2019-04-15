package com.mm.learn.leetcode;

/**
 * Created by wangmingming on 2019/4/3.
 * 最长公共子串
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }


    public static String longestCommonPrefix(String[] strs) {

        if(null == strs || strs.length == 0) {
            return "";
        }

        if(strs.length == 1) {
            return strs[0];
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i ++) {
            while (prefix.length() > 0) {
                if(strs[i].startsWith(prefix))
                    break;
                else
                    prefix = prefix.substring(0, prefix.length() - 1);
            }
            if(prefix.length() == 0) return "";
        }

        return prefix;
    }
}
