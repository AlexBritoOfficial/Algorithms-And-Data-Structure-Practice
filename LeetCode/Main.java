package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /** 1st Test Case **/

        ListNode listNode = new ListNode(2, new ListNode(4, new ListNode(9)));
        ListNode listNode2 = new ListNode(5, new ListNode(6, new ListNode(1)));


        ListNode listNode3 = addTwoNumbers(listNode, listNode2);

        while (listNode3 != null) {
            System.out.print(listNode3.val + " ");
            listNode3 = listNode3.next;
        }
    }

    /**
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit.
     * Add the two numbers and return the sum as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     * Example 1:
     *
     *  LinkedList 1 : 2 -> 3 -> 4
     *  LinkedList 2 : 5 -> 6 -> 4
     *
     *  ResultList:    7 -> 0 -> 8
     **/

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null ) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
