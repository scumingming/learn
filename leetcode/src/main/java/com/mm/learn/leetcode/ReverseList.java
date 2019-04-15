package com.mm.learn.leetcode;

/**
 * Created by wangmingming on 2019/4/4.
 */
public class ReverseList {

    public static ListNode reverseList(ListNode head) {

        ListNode ans = null;

        ListNode cur = head;
        while (head != null) {
            ListNode next = cur.next;
            cur.next = ans;
            ans = cur;
            cur = next;
        }


        return ans;

    }

}
