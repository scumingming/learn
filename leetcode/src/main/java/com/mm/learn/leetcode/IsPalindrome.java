package com.mm.learn.leetcode;

/**
 * Created by wangmingming on 2019/4/2.
 * 是否为回文数
 */
public class IsPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }

    public static boolean isPalindrome(int x) {

        if(x == 0) return true;
        if(x < 0) return false;
        int tmp = x;
        int reverse = 0;
        while (tmp > 0) {
            reverse = reverse*10 + tmp%10;
            tmp = tmp/10;
        }
//        System.out.println(reverse);

        return x == reverse;
    }
}
