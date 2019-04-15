package com.mm.learn.leetcode;

/**
 * Created by wangmingming on 2019/4/12.
 * <p>
 * <p>
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 */
public class CanJump {


    public static void main(String[] args) {
        int[] array = new int[]{2,3,1,1,4};
        System.out.println(new CanJump().canJump(array));
        int[] array2 = new int[]{3,2,1,0,4};
        System.out.println(new CanJump().canJump(array2));
        int[] array3 = new int[]{2,0};
        System.out.println(new CanJump().canJump(array3));
        int[] array4 = new int[]{0};
        System.out.println(new CanJump().canJump(array4));
        int[] array5 = new int[]{2,5,0,0};
        System.out.println(new CanJump().canJump(array5));


    }

    public boolean canJump(int[] nums) {

        int length = nums.length;
        if(length <= 1) return true;

        int r = length - 1;
        int l = r - 1;
        while (l >= 0) {

            if(nums[l] >= r - l) {
                r = l;
            }

            l--;

        }
        System.out.println(r);

        return r == 0 ? true : false;

//        return dfs(0, nums[0], nums);
    }

    /**
     *
     * @param i
     * @param v
     * @param nums
     * @return
     */
    private boolean dfs(int i, int v, int[] nums) {

        if (i == nums.length - 1) return true;
        if (v == 0) return false;

        boolean ans = false;
        for (int j = 1; j <= v; j++) {
            ans = dfs(i + j, nums[i + j], nums);
            if (ans) break;
        }

        return ans;
    }

}
