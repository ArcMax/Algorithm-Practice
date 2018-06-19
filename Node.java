package com.basics.algorithm.archana.algorithmbasics.heaps;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by archana on 6/19/2018.
 * <p>
 * //Node class for Adjacency list
 * //Node class has data and visited & its neighbours
 * //create graph by adding neighbours
 * //get neighbours for each vertex
 */

public class Node {
    int data;
    boolean visited;
    List<Node> neighbours;

    //constructor
    Node(int data) {
        this.data = data;
        this.neighbours = new ArrayList<>();
    }

    public void addneighbours(Node neighbrNode) {
        this.neighbours.add(neighbrNode);
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }
}