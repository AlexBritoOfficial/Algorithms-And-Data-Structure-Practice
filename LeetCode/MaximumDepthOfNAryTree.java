package LeetCode;

import java.util.*;

public class MaximumDepthOfNAryTree {

    // Given a n-ary tree, find its maximum depth.
    //
    //The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
    //
    //Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

    //static int depth = 0;
    //static int counter = 0;
    //static List visitedNodes = new ArrayList<Node>();

    public static void main(String[] args) {

        // Test Case 1
        /**
         *              1         val: 1 , ArrayList.get(0) = 3,
         *            / | \
         *           /  |  \
         *          3   2   4
         *         /  \
         *        /    \
         *       5      6
         **/

        // Input: root = [1,null,3,2,4,null,5,6]

        //[1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]

        Node root = new Node(1, Arrays.asList(new Node(3, Arrays.asList(new Node(5), new Node(6))), new Node(2), new Node(4)));

//
//        Node root = new Node(1,
//                Arrays.asList(new Node(2),
//                        new Node(3, Arrays.asList(new Node(6), new Node(7, Arrays.asList(new Node(11, Arrays.asList(new Node(14))))))),
//                        new Node(4, Arrays.asList(new Node(8, Arrays.asList(new Node(12))))),
//                        new Node(5, Arrays.asList(new Node(9, Arrays.asList(new Node(13))), new Node(10)))));

        System.out.println(maxDepth(root));

    }


    public static int maxDepth(Node root){


        if(root.children == null) {
            return 0;
        }

        //already height is 1 if node is not null
        int height = 1;

        for(Node node : root.children) {

            //track max height.
            height = Math.max(height, 1 + maxDepth(node)); //1+maxDepth(node) will calculate depth recursively.
        }

        return height;
    }

}







