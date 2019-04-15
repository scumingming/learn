package com.mm.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangmingming on 2019/4/3.
 */
public class RestoreIpAddresses {

    private static List<String> ans2 = new ArrayList<>();

    public static void main(String[] args) {

        List<String> ans = restoreIpAddresses("010010");
        ans.forEach(item ->
            System.out.println("ip:" + item + "\n")
        );

    }



    public static List<String> restoreIpAddresses(String s) {

        List<String> ans = new ArrayList<>();

        if(s.length() < 4 || s.length() > 12) return ans;

        dfs(ans, s, "", 0);
//        dfs2(s, "", 0);

        return ans;
    }

    private static void dfs(List<String> ans,String s, String ip, int deep) {

        if(deep == 4){
            if(0 == s.length()) ans.add(ip);
            return;
        }
        for(int i = 0; i <=2 ; i++) {
            if (s.length() < i+1) break;
            String subStr = s.substring(0, i+1);
            int numStr = Integer.parseInt(subStr);
            if(numStr > 255 || i>0 && subStr.charAt(0) == '0') break;
            String newIp = deep == 3 ? ip + subStr : ip + subStr + ".";
            String newStr = s.substring(i+1);
            dfs(ans, newStr,newIp, deep + 1);

        }
    }


    private static void dfs2(String s, String t, int n) {
        if (n == 4) {
            if (s.length() == 0) ans2.add(t);
            return;
        }
        for (int i = 1; i < 4; i++) {
            if (s.length() < i) break;
            String str = s.substring(0, i);
            int num = Integer.parseInt(str);
            if (num > 255 || i > 1 && str.charAt(0) == '0') break;
            dfs2(s.substring(i), t + str + (n == 3 ? "" : "."), n + 1);
        }
    }


}
