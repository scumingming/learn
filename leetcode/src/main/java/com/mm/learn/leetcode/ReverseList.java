package com.mm.learn.leetcode;

/**
 * Created by wangmingming on 2019/4/4.
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);

        a.next = b;
        b.next = c;
        c.next = d;

        ListNode x = a;
        while (x != null) {
            System.out.println(x.getVal());
            x = x.next;
        }

        reverseList(a);
        x = d;
        while (x != null) {
            System.out.println(x.getVal());
            x = x.next;
        }


    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null; //前指针节点
        ListNode curr = head; //当前指针节点
        //每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
        while (curr != null) {
            ListNode nextTemp = curr.next; //临时节点，暂存当前节点的下一节点，用于后移
            curr.next = prev; //将当前节点指向它前面的节点
            prev = curr; //前指针后移
            curr = nextTemp; //当前指针后移
        }
        return prev;
    }

}
