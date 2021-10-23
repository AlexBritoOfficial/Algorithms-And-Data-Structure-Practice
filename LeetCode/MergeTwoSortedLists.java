package LeetCode;

public class MergeTwoSortedLists {

    // Merge two sorted linked lists and return it as a sorted list.
    // The list should be made by splicing together the nodes of the first
    // two lists.

    public static void main(String[] args) {

        // Test Case # 2

        // List 1
        // [1,2,4]
        //ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(4)));

        // List 2
        // [1,3,4]
        //ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        // Test Case # 2

        // List 1
        // [5]
        // ListNode listNode1 = new ListNode(5);

        // List 2
        // [1,2,4]
       // ListNode listNode2 = new ListNode(1, new ListNode(2, new ListNode(4)));

        // Test Case # 3

        // List 1 [-9, 3]
        ListNode listNode1 = new ListNode(-9, new ListNode(3));

        // List 2
        // [5,7]
        ListNode listNode2 = new ListNode(5, new ListNode(7));

        // List 1 [1]
        // ListNode listNode1 = new ListNode(1);

        // List 2
        // [1]
        // ListNode listNode2 = new ListNode(1);

        // Test Case # 3

        // List 1
        // ListNode listNode1 = [-10,-10,-9,-4,1,6,6]

        //ListNode listNode1 = new ListNode(-10, new ListNode(-10, new ListNode(-9, new ListNode(-4, new ListNode(1, new ListNode(6, new ListNode(6)))))));

        // List 2
        // [-7]
        //ListNode listNode2 = new ListNode(-7);


        // Test Case 4
        // [-2,5]

        //ListNode listNode1 = new ListNode(-2, new ListNode(5));

        // [-9,-6,-3,-1,1,6]
        //ListNode listNode2 = new ListNode(-9, new ListNode(-6, new ListNode(-3, new ListNode(-1, new ListNode(1, new ListNode(6))))));

        //ListNode listNode1 = new ListNode(2);
        //ListNode listNode2 = new ListNode(1);

        ListNode mergedList = mergeTwoLists(listNode1, listNode2);
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }

    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return mergeTwoLists(l1, l2, new ListNode(0));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2, ListNode mergedList) {
        if(l1 == null){
            return returnLastNodeInChain(mergedList).next = l2;
        }

        else if (l2 == null){
            return returnLastNodeInChain(mergedList).next = l1;
        }

        if (l1.val > l2.val) {
            returnLastNodeInChain(mergedList).next = new ListNode(l2.val);
            mergeTwoLists(l1, l2.next, mergedList);
        }

        else if (l1.val <= l2.val) {
            returnLastNodeInChain(mergedList).next = new ListNode(l1.val);
            mergeTwoLists(l1.next, l2, mergedList);
        }
        return mergedList.next;
    }

    public static ListNode returnLastNodeInChain(ListNode listNode) {
        while (listNode.next != null) {
            listNode = listNode.next;
        }
        return listNode;
    }

//    public static ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
//        return mergeTwoSortedLists(l1, l2, new ListNode(0));
//    }

//    public static ListNode mergeTwoSortedLists(ListNode l1, ListNode l2, ListNode mergedList) {
//        ListNode mergedListNode = mergedList;
//
//        while (l1.next != null && l2.next != null) {
//
//            if (l1.val == l2.val) {
//                returnLastNodeInChain(mergedListNode).next = new ListNode(l1.val, new ListNode(l2.val));
//                l1 = l1.next;
//                l2 = l2.next;
//                continue;
//            }
//
//            if (l1.val < l2.val) {
//                returnLastNodeInChain(mergedListNode).next = new ListNode(l1.val);
//                l1 = l1.next;
//                continue;
//            } else if (l1.val > l2.val) {
//                returnLastNodeInChain(mergedListNode).next = new ListNode(l2.val);
//                l2 = l2.next;
//                continue;
//            }
//
//        }
//
//        if (l1.val == l2.val) {
//            returnLastNodeInChain(mergedListNode).next = new ListNode(l1.val, new ListNode(l2.val));
//        } else if (l1.val < l2.val) {
//            returnLastNodeInChain(mergedListNode).next = new ListNode(l1.val);
//            returnLastNodeInChain(mergedListNode).next = l2;
//        } else if (l1.val > l2.val) {
//            returnLastNodeInChain(mergedListNode).next = l2;
//            returnLastNodeInChain(mergedListNode).next = new ListNode(l1.val);
//        }
//
//        return mergedList.next;
//    }

    public static class ListNode {

        // Member Types
        int val;
        ListNode prev;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }


    }
}
