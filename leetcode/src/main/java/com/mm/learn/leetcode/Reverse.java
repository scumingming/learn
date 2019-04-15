package com.mm.learn.leetcode;

/**
 * Created by wangmingming on 2019/3/19.
 */
public class Reverse {

    public static void main(String[] args) {
        int result = new Reverse().reverse(1534236469);
        System.out.println(result);

//        System.out.println();
    }

    public int reverse(int x) {
        System.out.println(Integer.MAX_VALUE);
        long result = 0;

        while(Math.abs(x) > 0) {
            result = result * 10 + x%10;
            if(result > Integer.MAX_VALUE || result <Integer.MIN_VALUE) return 0;
            x = x/10;
        }

        return (int)result;
    }
}
