package com.mm.learn.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangmingming on 2019/3/19.
 */
public class LengthOfLongestSubString {

    public static void main(String[] args) {
        int max = new LengthOfLongestSubString().lengthOfLongestSubstring4("abcaaaexd");
        System.out.println(max);
    }

    public int lengthOfLongestSubstring4(String s) {
        int i,j;
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        for(i=0,j=0; j < s.length(); j++) {
            if(map.containsKey(s.charAt(j))) {
                i = i > map.get(s.charAt(j)) + 1 ? i : map.get(s.charAt(j)) + 1;
            }
            result = result > j-i+1 ? result : j-i+1;
            map.put(s.charAt(j), j);
        }

        return result;

    }

    public int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstring(String s) {

        int max = 0;
        char[] chs = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < chs.length; i++) {
            set.clear();
            set.add(chs[i]);
            for(int j = i + 1; j < chs.length; j ++) {
                if(set.contains(chs[j])) {
                    max = set.size() > max ? set.size() : max;
                    break;
                } else {
                    set.add(chs[j]);
                }
                max = set.size() > max ? set.size() : max;
            }

        }

        return set.size() > max ? set.size() : max ;
    }
}
