package com.company.ImplementDS.MyGraph;

import java.util.List;

public interface Graph<V> {

    /**
     * Returns the number of vertices in the graph.
     **/
    public int getSize();

    /**
     * Returns the vertices in the graph
     **/
    public List<V> getVertices();

    /**
     * Returns the vertex object for the specified vertex index
     **/
    public V getVertex(int index);

    /**
     * Returns the index for the specified vertex and return -1 if {@param v} is not in the graph
     **/
    public int getIndex(V v);

    /**
     * Returns the neighbors of vertex with specified index.
     **/
    public List<Integer> getNeighbors(int index);

    /**
     * Returns the degree for a specified vertex index
     **/
    public int getDegree(int index);

    /**
     * Prints the edges
     **/
    public void printEdges();

    /**
     * Clears the graph
     **/
    public void clear();

    /**
     * Returns true if {@param v} is added to the graph. Returns false if {@param v } is already in the graph
     **/
    public boolean addVertex(V v);

    /**
     * Adds an edge from {@param u} to {@param v} to the graph.
     * Throws IllegalArgumentException if {@param u} or {@param v} is invalid.
     * Returns true if the edge is added and false if (u,v) is already in the graph.
     **/
    public boolean addEdge(int u, int v);

    /**
     * Adds an edge into the adjacency edge list
     **/
    public boolean addEdge(Edge edge);

    /**
     * Removes a vertex from the graph
     **/
    public boolean remove(V v);

    /** Removes an edge from the graph **/
    public boolean remove(int u, int v);

    /** Obtains a depth-first-search tree starting from the v **/
    public UnWeightedGraph<V>.SearchTree dfs(int v);

    /** Obtains a breadth-first-search tree starting from the v **/
    public UnWeightedGraph<V>.SearchTree bfs(int v);

}
