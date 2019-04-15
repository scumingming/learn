package com.mm.learn.leetcode;

import java.util.*;

/**
 * Created by wangmingming on 2019/3/19.
 */
public class ThreeSum {

    public static void main(String[] args) {

//        List<Integer> a = Arrays.asList(new Integer[]{0,1});
//        List<Integer> b = Arrays.asList(new Integer[]{0,1});
//        System.out.println(a.equals(b));


        List<List<Integer>> result = new ThreeSum().threeSum2(new int[]{-1,0,1,2,-1,-4});
//        List<List<Integer>> result = new ThreeSum().threeSum(new int[]{0,0,0,0});
        for (List<Integer> item: result
             ) {
            System.out.println(Arrays.toString(item.toArray()));
        }
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {  // 跳过可能重复的答案

                int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        ls.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < sum) {
                        while (l < r && nums[l] == nums[l + 1]) l++;   // 跳过重复值
                        l++;
                    } else {
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                    }
                }
            }
        }
        return ls;
    }

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        Set<List<Integer>> result = new HashSet<>();
        for(int i = 0; i < nums.length ; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(!set.contains(nums[i])) {
                    result.addAll(twoSum(nums, j, 0 - nums[i]));
                }
            }
            set.add(nums[i]);
        }

        return new ArrayList<>(result);
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int target) {

        List<List<Integer>> targetList = new ArrayList<>();

        Map<Integer, Integer> cache = new HashMap<>();

        for(int i = start + 1; i < nums.length; i ++) {

            if(nums[start] + nums[i] == target)
                targetList.add(Arrays.asList(new Integer[]{0 - target, target - nums[i], nums[i]}));
        }


        return targetList;
    }

}
