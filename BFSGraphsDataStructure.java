package com.basics.algorithm.archana.algorithmbasics.heaps;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by archana on 6/19/2018.
 * <p>
 * Graphs are represented in two ways
 * Adjacency List
 * Adjacency Matrix
 * <p>
 * Two types of traversal in graphs
 * Depth-first-Traversal
 * Breadth-first-traversal
 */

public class BFSGraphsDataStructure {

    private Queue<GraphNodeAdjList> queue = new LinkedList<GraphNodeAdjList>();


    public static void main(String[] args) {
        GraphNodeAdjList node40 = new GraphNodeAdjList(40);
        GraphNodeAdjList node10 = new GraphNodeAdjList(10);
        GraphNodeAdjList node20 = new GraphNodeAdjList(20);
        GraphNodeAdjList node30 = new GraphNodeAdjList(30);
        GraphNodeAdjList node60 = new GraphNodeAdjList(60);
        GraphNodeAdjList node50 = new GraphNodeAdjList(50);
        GraphNodeAdjList node70 = new GraphNodeAdjList(70);

        node40.addneighbours(node10);
        node40.addneighbours(node20);
        node10.addneighbours(node30);
        node20.addneighbours(node10);
        node20.addneighbours(node30);
        node20.addneighbours(node60);
        node20.addneighbours(node50);
        node30.addneighbours(node60);
        node60.addneighbours(node70);
        node50.addneighbours(node70);

        BFSGraphsDataStructure graphsDataStructure = new BFSGraphsDataStructure();
        System.out.println("BREADTH_FIRST_TRAVERSAL_GRAPHS_ADJACENCY_LIST");
        graphsDataStructure.bfs(node40);

    }

    //BFS method
    public void bfs(GraphNodeAdjList node) {
        //add to queue first node and mark as visited
        queue.add(node);
        node.visited = true;

        // check is queue is  not empty
        while (!queue.isEmpty()) {
            //poll from queue & print
            GraphNodeAdjList element = queue.poll();
            System.out.print(element.data + ",");

            //get all neighbours of polled queue
            List<GraphNodeAdjList> neighbourList = element.getNeighbours();
            //loop through each element
            for (int i = 0; i < neighbourList.size(); i++) {
                GraphNodeAdjList n = neighbourList.get(i);
                //check if visited before
                // else add to queue & mark visite
                if (n != null && !n.visited) {
                    queue.add(n);
                    n.visited = true;
                }
            }
            //do untill all nodes are marked visted
        }
    }
}
