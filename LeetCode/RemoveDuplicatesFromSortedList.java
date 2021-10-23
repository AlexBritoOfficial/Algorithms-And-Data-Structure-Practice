package LeetCode;

import org.w3c.dom.ls.LSException;

public class RemoveDuplicatesFromSortedList {

    // Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3))));
        deleteDuplicates(listNode);
    }

    public static ListNode deleteDuplicates(ListNode head) {

        if(head == null){
            return new ListNode();
        }

        ListNode current = head;

        while (current.next != null) {
            ListNode runner = current.next;

            // 1 -> 1 -> 2 -> 3

            if (current.val == runner.val) {
                current.next = runner.next;
            } else {
                current = current.next;
            }

        }

        return head;
    }
}
