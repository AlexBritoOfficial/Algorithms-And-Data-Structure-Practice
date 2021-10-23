package LeetCode;

import javax.swing.plaf.IconUIResource;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class MaximumDepthOfNAryTree {

    // Given a n-ary tree, find its maximum depth.
    //
    //The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
    //
    //Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).


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

        //Node root = new Node(1, Arrays.asList(new Node(3, Arrays.asList(new Node(5), new Node(6))), new Node(2), new Node(4)));
//        Node root = new Node(1, Arrays.asList(new Node(2),
//                new Node(3, Arrays.asList(new Node(6), new Node(7, Arrays.asList(new Node(11, Arrays.asList(new Node(14))),
//                        new Node(4, Arrays.asList(new Node(8, Arrays.asList(new Node(12))))),
//                        new Node(5, Arrays.asList(new Node(9, Arrays.asList(new Node(13))), new Node(10)))))))));

        Node root = new Node(1,
                Arrays.asList(new Node(2),
                        new Node(3 , Arrays.asList(new Node(6), new Node(7, Arrays.asList(new Node(11, Arrays.asList(new Node(14))))))),
                        new Node(4, Arrays.asList(new Node(8, Arrays.asList(new Node(12))))),
                        new Node(5, Arrays.asList(new Node(9, Arrays.asList(new Node(13))), new Node(10)))));

        maxDepth(root);

    }

    public static int maxDepth(Node root) {
        return maxDepth(root, 0).val;
    }

    public static Node maxDepth(Node root, int counter) {

        System.out.print(root.val + " ");
        Map<Node, Boolean> visitedChildrenNodes = new HashMap<>();

        if (root.children == null) {
            return root;
        }

        Node parent = root;
        Iterator<Node> iterator = root.children.iterator();

        while (iterator.hasNext()) {
            Node node = (Node) iterator.next();
            visitedChildrenNodes.put(node, true);
            maxDepth(node, counter);
        }

        return new Node(counter);
    }

    public static Node returnUnvisitedChildNode(Node node, Map<Node, Boolean> visitedChildrenNodes) {
        Iterator<Node> iterator = node.children.iterator();

        while (iterator.hasNext()) {
            Node unVisitedNode = iterator.next();
            if (visitedChildrenNodes.containsKey(unVisitedNode)) {
                continue;
            }
            return unVisitedNode;
        }

        return null;
    }
}
