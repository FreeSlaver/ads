package com.song.ads.unit3.graph;

/**
 * Created by 001844 on 2018/3/27.
 * also called arces
 */
public class Edge {

    private Vertex startVertex;

    private Vertex endVertex;
    //单向v1到v2，逆向v2到v1，双向
//    private String direction;
    private boolean directed = true;

    public Vertex getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(Vertex startVertex) {
        this.startVertex = startVertex;
    }

    public Vertex getEndVertex() {
        return endVertex;
    }

    public void setEndVertex(Vertex endVertex) {
        this.endVertex = endVertex;
    }

    public boolean isDirected() {
        return directed;
    }

    public void setDirected(boolean directed) {
        this.directed = directed;
    }
}
