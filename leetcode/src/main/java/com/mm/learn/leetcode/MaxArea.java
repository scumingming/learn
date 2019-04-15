package com.mm.learn.leetcode;

/**
 * Created by wangmingming on 2019/4/15.
 *
 * 盛最多水的容器
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 *
 *
 */
public class MaxArea {

    public static void main(String[] args) {
        System.out.println(new MaxArea().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(new MaxArea().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }


    public int maxArea(int[] height) {

        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;
        while (r >= l) {
            int maxTmp = Math.min(height[l], height[r]) * (r - l);
            maxArea = maxTmp > maxArea ? maxTmp : maxArea;

            if(height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }

        return maxArea;
    }
}
