package com.company.ImplementDS.MyGraph;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UnWeightedGraph<V> implements Graph<V> {

    /**
     * Vertices in the Graph
     **/
    protected List<V> vertices = new ArrayList<>();

    /**
     * Neighbors for each vertex in the graph
     **/
    protected List<List<Edge>> neighbors = new ArrayList<>();

    /**
     * Constructs an empty graph
     **/
    public UnWeightedGraph() {
    }

    /**
     * Constructs a graph with the specified edges and vertices stored in arrays.
     **/
    UnWeightedGraph(V[] vertices, int[][] edges) {
        for (int i = 0; i < vertices.length; i++) {
            addVertex(vertices[i]);
        }
        createAdjacencyLists(edges, vertices.length);
    }

    /**
     * Constructs a graph with the specified edges and vertices stored in lists.
     **/
    public UnWeightedGraph(List<V> vertices, List<Edge> neighbors) {
        for (int i = 0; i < vertices.size(); i++) {
            vertices.add(vertices.get(i));
        }
        createAdjacencyLists(neighbors, vertices.size());
    }

    /**
     * Constructs a graph with the specified edges in an array and the integer vertices 0,1,2,...,N-1
     **/
    public UnWeightedGraph(int[][] edges, int numberOfVertices) {
        for (int i = 0; i < numberOfVertices; i++) {
            addVertex((V) new Integer(i));
        }
        createAdjacencyLists(edges, numberOfVertices);
    }

    /**
     * Constructs a graph with the specified edges in a list and integer vertices 0.1,2,...,N - 1
     **/
    public UnWeightedGraph(List<Edge> edges, int numberOfVertices) {
        for (int i = 0; i < numberOfVertices; i++) {
            addVertex((V) new Integer(i));
        }
        createAdjacencyLists(edges, numberOfVertices);
    }

    private void createAdjacencyLists(int[][] edges, int numberOfVertices) {
        for (int i = 0; i < edges.length; i++) {
            addEdge(edges[i][0], edges[i][1]);
        }
    }

    private void createAdjacencyLists(List<Edge> edges, int numberOfVertices) {
        for (Edge edge : edges) {
            addEdge(edge.u, edge.v);
        }
    }

    @Override
    public int getSize() {
        return vertices.size();
    }

    @Override
    public List<V> getVertices() {
        return vertices;
    }

    @Override
    public V getVertex(int index) {
        return vertices.get(index);
    }

    @Override
    public int getIndex(V v) {
        return vertices.indexOf(v);
    }

    @Override
    public List<Integer> getNeighbors(int index) {
        List<Integer> result = new ArrayList<>();
        for (Edge e : neighbors.get(index)) {
            result.add(new Integer(e.v));
        }
        return result;
    }

    @Override
    public int getDegree(int vertex) {
        return neighbors.get(vertex).size();
    }

    @Override
    public void printEdges() {
        for (int u = 0; u < neighbors.size(); u++) {
            System.out.println("Vertex: " + getVertex(u));
            for (Edge edge : neighbors.get(u)) {
                System.out.println(" (" + edge.u + ")" + " , " + "(" + edge.v + ")");
            }
        }
        System.out.println();
    }

    @Override
    public void clear() {

    }

    @Override
    /** Add a vertex to the graph.**/
    public boolean addVertex(V vertex) {
        /** Add Vertex to Vertices List, if vertex doesn't already exist in list. **/
        if (!vertices.contains(vertex)) {
            vertices.add(vertex);
            neighbors.add(new ArrayList<Edge>());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addEdge(int u, int v) {
        return addEdge(new Edge(u, v));
    }

    @Override
    public boolean addEdge(Edge edge) {
        if (edge.u < 0 || edge.u > getSize() - 1) {
            throw new IllegalArgumentException("No such Index " + edge.u);
        }

        if (edge.v < 0 || edge.v > getSize() - 1) {
            throw new IllegalArgumentException("No such Index " + edge.v);
        }

        /** Check if {@param edge} already exists in {@link neighbors }**/
        if (!neighbors.get(edge.u).contains(edge)) {
            neighbors.get(edge.u).add(edge);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(V v) {
        return false;
    }

    @Override
    public boolean remove(int u, int v) {
        return false;
    }

    @Override
    public SearchTree dfs(int v) {
        List<Integer> searchOrder = new ArrayList<>();

        int[] parent = new int[vertices.size()];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = -1;
        }

        /** Mark visited vertices **/
        boolean[] isVisited = new boolean[vertices.size()];

        // Recursively search
        dfs(v, searchOrder, parent, isVisited);

        // Return a SearchTree
        return new SearchTree(v,parent,searchOrder);
    }

    private void dfs(int v, List<Integer> searchOrder, int [] parent, boolean[] isVisited) {
        /** Store visited vertex **/
        searchOrder.add(v);
        /** Vertex v visited **/
        isVisited[v] = true;

        for (Edge e: neighbors.get(v)) {
            if(!isVisited[e.v]){
                parent[e.v] = v;
                dfs(e.v, searchOrder, parent, isVisited);
            }
        }
    }

    @Override
    public SearchTree bfs(int v) {
        return null;
    }

    public class SearchTree {
        private int root; // The root of the tree
        private int[] parent; // Store the parent of each vertex
        private List<Integer> searchOrder;

        /**
         * Construct a tree with root, parent, and search order
         **/
        public SearchTree(int root, int[] parent, List<Integer> searchOrder) {
            this.root = root;
            this.parent = parent;
            this.searchOrder = searchOrder;
        }

        /**
         * Return the root of the tree
         **/
        public int getRoot() {
            return root;
        }

        /**
         * Return the parent of vertex v
         **/
        public int getParent(int v) {
            return parent[v];
        }

        /**
         * Return an array representing search order
         **/
        public List<Integer> getSearchOrder() {
            return searchOrder;
        }

        /**
         * Return number of vertices found
         **/
        public int getNumberOfVerticesFound() {
            return searchOrder.size();
        }

        /**
         * Return the path of vertices from a vertex to the root
         **/
        public List<V> getPath(int index) {
            ArrayList<V> path = new ArrayList<>();

            do {
                path.add(vertices.get(index));
                index = parent[index];
            } while (index != -1);

            return path;
        }

        /**
         * Print a path from the root to vertex v
         **/
        public void printPath(int index) {
            List<V> path = getPath(index);
            System.out.print("Path from " + vertices.get(root) + " to " + vertices.get(index));
            for (int i = path.size() - 1; i >= 0; i--) {
                System.out.println(path.get(i) + " ");
            }
        }

        /**
         * Print the Whole Tree
         **/
        public void printTree() {
            System.out.println("Root: " + vertices.get(root));
            System.out.print("Edges: ");
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] != -1) {
                    // Display an edge
                    System.out.print("(" + vertices.get(parent[i]) + ", " + vertices.get(i) + ")");
                }
                System.out.println();
            }
        }
    }
}
