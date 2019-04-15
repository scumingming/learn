package com.mm.learn.leetcode;


/**
 * Created by wangmingming on 2019/3/19.
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String ret = new LongestPalindrome().longestPalindrome("a");
        System.out.println(ret);
    }

    public String longestPalindrome(String s) {

        String news = s.replace("", "#");
        String result = "";
        int i = 0;
        while (i < news.length()) {

            int m = i - 1, n = i + 1;
            while (m >= 0 && n < news.length()) {
                if (news.charAt(m) != news.charAt(n)) break;
                m--;
                n++;
            }
            String tmp = news.substring(++m, --n);
            if (tmp.length() > result.length()) result = tmp;

            i++;
        }

        return result.replace("#", "");

    }
}
