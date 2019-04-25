package com.mm.learn.leetcode;

import java.util.Arrays;

/**
 * Created by wangmingming on 2019/4/17.
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)
 * 。如果不存在，则返回  -1。
 *
 *   KMP算法
 */
public class StrStr {

    public static void main(String[] args) {

        int[] test = new StrStr().getNext("abcdabcaba".toCharArray());
        System.out.println(Arrays.toString(test));

        System.out.println(new StrStr().strStr("eghijklmnghijghijghij","ghijghij"));

    }


    public int strStr(String haystack, String needle) {
        if(needle.length()==0)
            return 0;
        int[] next=getNext(needle.toCharArray());
        System.out.println(Arrays.toString(next));
        int i=0,j=0;
        while(i<haystack.length()&&j<needle.length()){
            if(j==-1||haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }else
                j=next[j];
        }
        if(j==needle.length())
            return i-j;
        else
            return -1;
    }

    public int[] getNext(char[] pstr){
        int[] next=new int[pstr.length+1];
        int i=0,j=-1;
        next[0]=-1;
        while(i<pstr.length){
            if(j==-1||pstr[i]==pstr[j]){
                i++;
                j++;
                next[i]=j;
            }else {
                j=next[j];
            }

        }
        return next;

    }

}
