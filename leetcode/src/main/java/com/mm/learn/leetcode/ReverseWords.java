package com.mm.learn.leetcode;

/**
 * Created by wangmingming on 2019/4/3.
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 无空格字符构成一个单词。
    输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
    如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class ReverseWords {

    public static void main(String[] args) {
        System.out.println(reverseWords("  the   sky is blue  "));
    }

    public static String reverseWords2(String s) {

        String[] arr = s.trim().split("\\s+");
        if (arr.length <= 0) return null;
        StringBuilder sb = new StringBuilder();
        int i=arr.length-1;
        sb.append(arr[i]);
        while(i-->0){
            if(!" ".equals(arr[i]))
                sb.append(" ").append(arr[i]);
        }
        return sb.toString();
    }

    public static String reverseWords(String s) {

        int i = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        while (i >= 0) {
            if(' ' != s.charAt(i)) {
                tmp.append(' ' != s.charAt(i) ? s.charAt(i) : "");
            } else if(tmp.length() > 0) {
                sb.append(tmp.reverse()).append(" ");
                tmp = new StringBuilder();
            }
            i--;
        }

        return sb.append(tmp.reverse()).toString().trim();
    }
}
