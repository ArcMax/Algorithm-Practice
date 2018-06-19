package com.basics.algorithm.archana.algorithmbasics.heaps;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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


//Node class for Adjacency list
//Node class has data and visited & its neighbours
//create graph by adding neighbours
//get neighbours for each vertex
class Node {
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

public class GraphsDataStructure {

    private Queue<Node> queue = new LinkedList<Node>();
    private Stack<Node> stack = new Stack<>();

    public static void main(String[] args) {
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

        GraphsDataStructure graphsDataStructure = new GraphsDataStructure();
        System.out.println("BREADTH_FIRST_TRAVERSAL_GRAPHS_ADJACENCY_LIST");
        graphsDataStructure.bfs(node40);
        System.out.println("DEPTH_FIRST_TRAVERSAL_GRAPHS_ADJACENCY_MATRIX");
        graphsDataStructure.dfs(node40);
    }

    //BFS method
    public void bfs(Node node) {
        //add to queue first node and mark as visited
        queue.add(node);
        node.visited = true;

        // check is queue is  not empty
        while (!queue.isEmpty()) {
            //poll from queue & print
            Node element = queue.poll();
            System.out.print(element.data + ",");

            //get all neighbours of polled queue
            List<Node> neighbourList = element.getNeighbours();
            //loop through each element
            for (int i = 0; i < neighbourList.size(); i++) {
                Node n = neighbourList.get(i);
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

    //DFS
    //Its same as bfs only difference is we are using stack
    public void dfs(Node node){
        stack.add(node);
        node.visited = true;

        while(!stack.isEmpty()){
            Node element = stack.pop();
            System.out.println(element+",");

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
