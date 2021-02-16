package com.company.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /** 1st Test Case **/
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);

        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);
//        ListNode listNode = new ListNode(0);

//        ListNode listNode2 = new ListNode(0);


        System.out.println(addTwoNumbers(listNode, listNode2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        int carry = 0;

        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            result = new ListNode(sum % 10, result);
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode leftOver = null;
        if(l1 != null){
            leftOver = l1;
        }

        if(l2 != null){
            leftOver = l2;
        }

        if(leftOver == null && carry != 0){
            result = new ListNode(carry,result);
        }

        while(leftOver != null){
            result = new ListNode(leftOver.val + carry, result);
            carry = 0;
            leftOver = leftOver.next;
        }

        return result;
    }
}
