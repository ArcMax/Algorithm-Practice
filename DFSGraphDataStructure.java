package com.basics.algorithm.archana.algorithmbasics.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by archana on 6/19/2018.
 */

public class DFSGraphDataStructure {

    //list of nodes or vertices for matrix
    public ArrayList<GraphNodeAdjMatrix> nodes = new ArrayList<>();

    public static void main(String[] args){
        DFSGraphDataStructure dfsGraphDataStructure = new DFSGraphDataStructure();

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

        System.out.println("DEPTH_FIRST_TRAVERSAL_GRAPHS_ADJACENCY_LIST");
        dfsGraphDataStructure.dfs(node40);

        matrixMain(dfsGraphDataStructure);
    }

    private static void matrixMain(DFSGraphDataStructure dfsGraphDataStructure) {

        GraphNodeAdjMatrix node40 =new GraphNodeAdjMatrix(40);
        GraphNodeAdjMatrix node10 =new GraphNodeAdjMatrix(10);
        GraphNodeAdjMatrix node20 =new GraphNodeAdjMatrix(20);
        GraphNodeAdjMatrix node30 =new GraphNodeAdjMatrix(30);
        GraphNodeAdjMatrix node60 =new GraphNodeAdjMatrix(60);
        GraphNodeAdjMatrix node50 =new GraphNodeAdjMatrix(50);
        GraphNodeAdjMatrix node70 =new GraphNodeAdjMatrix(70);

        dfsGraphDataStructure.nodes.add(node40);
        dfsGraphDataStructure.nodes.add(node10);
        dfsGraphDataStructure.nodes.add(node20);
        dfsGraphDataStructure.nodes.add(node30);
        dfsGraphDataStructure.nodes.add(node60);
        dfsGraphDataStructure.nodes.add(node50);
        dfsGraphDataStructure.nodes.add(node70);

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
        System.out.println("DFS WITH MATRIX RECURSION");
        dfsGraphDataStructure.dfsRecursiveMatrix(adjacency_matrix,node40);
    }

    //DFS
    //Its same as bfs only difference is we are using stack
    public void dfs(GraphNodeAdjList node){
        Stack<GraphNodeAdjList> stack = new Stack<GraphNodeAdjList>();
        stack.add(node);
        node.visited = true;

        while(!stack.isEmpty()){
            GraphNodeAdjList element = stack.pop();
            System.out.print(element.data+",");

            List<GraphNodeAdjList> neighbour = element.getNeighbours();
            for (int i =0; i< neighbour.size();i++){
                GraphNodeAdjList n = neighbour.get(i);
                if (n!=null && !n.visited){
                    stack.push(n);
                    n.visited = true;
                }
            }
        }
    }

    //DFS WITH MATRIX
    findNeighbours findNeighbours = new findNeighbours();
    //DFS recursive on matrix
    public void dfsRecursiveMatrix(int adjMatrix[][],GraphNodeAdjMatrix node){
        System.out.print(node.data+",");
        ArrayList<GraphNodeAdjMatrix> findNeighbours = com.basics.algorithm.archana.algorithmbasics.heaps.findNeighbours.findNeighbours(adjMatrix,node,nodes);
        node.visited = true;
        for (int i = 0 ; i < findNeighbours.size() ; i++){
            GraphNodeAdjMatrix n = findNeighbours.get(i);
            if(n!=null && !n.visited){
                dfsRecursiveMatrix(adjMatrix,n);
            }
        }
    }

    //same as adjacency list
    public void dfsIterativeMatrix(int adjMatrix[][],GraphNodeAdjMatrix node){

    }
}
