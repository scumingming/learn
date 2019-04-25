package com.mm.learn.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangmingming on 2019/3/19.
 *
 *
 */
public class TwoSum {

    public static void main(String[] args) {
       int[] result = new TwoSum().twoSum(new int[]{1,2,3,4,5}, 6);
        System.out.println(Arrays.toString(result));
    }

    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> cache = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(cache.containsKey(target - nums[i])) {
                return new int[]{cache.get(target - nums[i]), i};
            }

            cache.put(nums[i], i);

        }

        return null;

    }

}



