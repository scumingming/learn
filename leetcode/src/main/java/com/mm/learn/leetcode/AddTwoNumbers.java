package com.mm.learn.leetcode;

/**
 * Created by wangmingming on 2019/3/19.
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode result = new AddTwoNumbers().addTwoNumbers(new ListNode(5), new ListNode(5));
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
        ListNode p,q,current = ret;
        p = l1;
        q = l2;
        int carry = 0;
        while(p!=null || q!=null || carry > 0) {
            int x = p!=null ? p.val : 0;
            int y = q!=null ? q.val : 0;
            int val = (carry + x + y)%10;
            carry = (carry + x + y)/10;
            current.next = new ListNode(val);
            current = current.next;
            p =  p!=null ? p.next : null;
            q =  q!=null ? q.next : null;
        }

        return ret.next;
    }

}


