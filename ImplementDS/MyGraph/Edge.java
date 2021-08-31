package ImplementDS.MyGraph;

public class Edge {

    int u;
    int v;

    public Edge(int u, int v) {
        this.u = u;
        this.v = v;
    }

    public boolean equals(Object object){
        return u == ((Edge) object).u && v == ((Edge) object).v;
    }
}
