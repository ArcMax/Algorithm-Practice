package com.basics.algorithm.archana.algorithmbasics.heaps;

import android.app.Activity;

import java.util.ArrayList;
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

    ArrayList<GraphNodeAdjMatrix> nodes = new ArrayList<>();
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

        MatrixMain(graphsDataStructure);
    }

    private static void MatrixMain(BFSGraphsDataStructure bfsgraphsDataStructure) {

        GraphNodeAdjMatrix node40 =new GraphNodeAdjMatrix(40);
        GraphNodeAdjMatrix node10 =new GraphNodeAdjMatrix(10);
        GraphNodeAdjMatrix node20 =new GraphNodeAdjMatrix(20);
        GraphNodeAdjMatrix node30 =new GraphNodeAdjMatrix(30);
        GraphNodeAdjMatrix node60 =new GraphNodeAdjMatrix(60);
        GraphNodeAdjMatrix node50 =new GraphNodeAdjMatrix(50);
        GraphNodeAdjMatrix node70 =new GraphNodeAdjMatrix(70);

        bfsgraphsDataStructure.nodes.add(node40);
        bfsgraphsDataStructure.nodes.add(node10);
        bfsgraphsDataStructure.nodes.add(node20);
        bfsgraphsDataStructure.nodes.add(node30);
        bfsgraphsDataStructure.nodes.add(node60);
        bfsgraphsDataStructure.nodes.add(node50);
        bfsgraphsDataStructure.nodes.add(node70);

        int adjacency_matrix[][] = {
                {0,1,1,0,0,0,0},  // Node 1: 40
                {0,0,0,1,0,0,0},  // Node 2 :10
                {0,1,0,1,1,1,0},  // Node 3: 20
                {0,0,0,0,1,0,0},  // Node 4: 30
                {0,0,0,0,0,0,1},  // Node 5: 60
                {0,0,0,0,0,0,1},  // Node 6: 50
                {0,0,0,0,0,0,0},  // Node 7: 70
        };

        System.out.println();
        System.out.println("BFS WITH MATRIX ITERATIVE");
        bfsgraphsDataStructure.bfsIterativeMatrix(adjacency_matrix,node40);
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

    Queue<GraphNodeAdjMatrix> matrixQueue = new LinkedList<>();
    private void bfsIterativeMatrix(int[][] adjacency_matrix, GraphNodeAdjMatrix node) {
        matrixQueue.add(node);
        node.visited = true;

        while (!matrixQueue.isEmpty()){
            GraphNodeAdjMatrix matrixElement = matrixQueue.poll();
            System.out.print(matrixElement+",");

            List<GraphNodeAdjMatrix> adjMatrixList = findNeighbours.findNeighbours(adjacency_matrix,node,nodes);
            for (int i =0 ;i < adjMatrixList.size() ; i++){
                GraphNodeAdjMatrix nodeAdjMatrix = adjMatrixList.get(i);

                if (nodeAdjMatrix!=null && !nodeAdjMatrix.visited){
                    matrixQueue.add(nodeAdjMatrix);
                    nodeAdjMatrix.visited = true;
                }
            }

        }
    }
}
