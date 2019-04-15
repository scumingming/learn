package com.mm.learn.leetcode;



/**
 * Created by wangmingming on 2019/4/15.
 * 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 */
public class SearchInsert {

    public static void main(String[] args) {

        int[] nums = new int[]{1,3,5,6};

        System.out.println(new SearchInsert().searchInsert(nums, 5) == 2);
        System.out.println(new SearchInsert().searchInsert(nums, 2) == 1);
        System.out.println(new SearchInsert().searchInsert(nums, 7) == 4);
        System.out.println(new SearchInsert().searchInsert(nums, 0) == 0);

        int[] nums2 = new int[]{1,3};
        System.out.println(new SearchInsert().searchInsert(nums2, 4) == 2);
        System.out.println(new SearchInsert().searchInsert(nums2, 2) == 1);
        System.out.println(new SearchInsert().searchInsert(nums2, 0) == 0);

        int[] nums3 = new int[]{1,3, 5};
        System.out.println(new SearchInsert().searchInsert(nums3, 4) == 2);

        int[] nums4 = new int[]{1,3,5,7,9,11,13,15,17,19,21};
        System.out.println(new SearchInsert().searchInsert(nums4, 6) == 3);

        int[] nums5 = new int[]{1,2,4,6,7};
        System.out.println(new SearchInsert().searchInsert(nums5, 3) == 2);
    }


    public int searchInsert(int[] nums, int target) {

//        if(null == nums || nums.length == 0) return 0;
//        if(target > nums[nums.length -1]) return nums.length;
//        if(target < nums[0]) return 0;

        int l = 0;
        int r = nums.length - 1;
        int m = (nums.length - 1)/2;
        while (target != nums[m]) {
            if(l == m || r == m) {
                if(target > nums[r]) return r + 1;
                if(target < nums[l]) return l;
            }

            if(nums[m] > target) {
                r = m - 1;
                m = (l + m -1)/2;
            } else {
                l = m + 1;
                m = (m + 1 + r)/2;
            }
        }

        return m;
    }
}
