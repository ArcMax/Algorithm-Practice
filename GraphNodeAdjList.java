package com.basics.algorithm.archana.algorithmbasics.OnGitHub;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by archana on 6/19/2018.
 * <p>
 * //GraphNodeAdjList class for Adjacency list
 * //GraphNodeAdjList class has data and visited & its neighbours
 * //create graph by adding neighbours
 * //get neighbours for each vertex
 */

public class GraphNodeAdjList {
    int data;
    boolean visited;
    List<GraphNodeAdjList> neighbours;

    //constructor
    GraphNodeAdjList(int data) {
        this.data = data;
        this.neighbours = new ArrayList<>();
    }

    public void addneighbours(GraphNodeAdjList neighbrNode) {
        this.neighbours.add(neighbrNode);
    }

    public List<GraphNodeAdjList> getNeighbours() {
        return neighbours;
    }
}