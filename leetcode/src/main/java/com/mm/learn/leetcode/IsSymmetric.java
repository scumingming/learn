package com.mm.learn.leetcode;

/**
 * Created by wangmingming on 2019/4/15.
 * 给定一个二叉树，检查它是否是镜像对称的。
 *    1
     / \
    2   2
   / \ / \
  3  4 4  3
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {

        if(null == root) return true;

        return dfs(root.left, root.right);

    }

    private boolean dfs(TreeNode leftNode, TreeNode rightNode) {

        if(null == leftNode && null == rightNode) return true;
        if(null != leftNode && null == rightNode) return false;
        if(null == leftNode && null != rightNode) return false;
        if(leftNode.val != rightNode.val) return false;

        if(!dfs(leftNode.left, rightNode.right)) return false;
        if(!dfs(leftNode.right,rightNode.left)) return false;

        return true;
    }
}
