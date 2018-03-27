package com.song.ads.unit3.graph;

import java.util.List;

/**
 * Created by 001844 on 2018/3/27.
 */
public class Graph {
    private List<Vertex> vertices;
    private List<Edge> edges;

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }
}
