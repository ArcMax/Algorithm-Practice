package com.basics.algorithm.archana.algorithmbasics.heaps;

import java.util.List;
import java.util.Stack;

/**
 * Created by archana on 6/19/2018.
 */

public class DFSGraphDataStructure {
    private Stack<Node> stack = new Stack<Node>();
    public static void main(String[] args){
        DFSGraphDataStructure dfsGraphDataStructure = new DFSGraphDataStructure();

        Node node40 = new Node(40);
        Node node10 = new Node(10);
        Node node20 = new Node(20);
        Node node30 = new Node(30);
        Node node60 = new Node(60);
        Node node50 = new Node(50);
        Node node70 = new Node(70);

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

        System.out.println("DEPTH_FIRST_TRAVERSAL_GRAPHS_ADJACENCY_MATRIX");
        dfsGraphDataStructure.dfs(node40);
    }
    //DFS
    //Its same as bfs only difference is we are using stack
    public void dfs(Node node){
        stack.add(node);
        node.visited = true;

        while(!stack.isEmpty()){
            Node element = stack.pop();
            System.out.print(element.data+",");

            List<Node> neighbour = element.getNeighbours();
            for (int i =0; i< neighbour.size();i++){
                Node n = neighbour.get(i);
                if (n!=null && !n.visited){
                    stack.push(n);
                    n.visited = true;
                }
            }

        }

    }
}
