package FreeCodeAlgorithms;

import java.util.HashMap;
import java.util.Stack;

public class GraphAlgorithms {

    public static void main(String[] args) {
        HashMap<Integer, Integer> graph = new HashMap<>();
        graph.put(0,1);
        graph.put(1,2);
        graph.put(1,3);
        graph.put(2,4);
        graph.put(3,2);
        graph.put(4,5);
        graph.put(5,null);



    }

    public static void depthFirstSearch(HashMap<Integer, Integer> graph, Integer source){
        Stack<Integer> stack = new Stack<>();
        stack.push(source);

        while(stack.size() > 0){
            Integer currentNode = stack.pop();
            System.out.println(currentNode);


        }

    }
}
