package com.basics.algorithm.archana.algorithmbasics.OnGitHub;

import java.util.ArrayList;

/**
 * Created by archana on 6/20/2018.
 */

public class findNeighbours {

    //find neighbours of node using adjacency matrix
    //if adjMatrix[i][j] = 1, i.e i & j are connected
    public static ArrayList<GraphNodeAdjMatrix> findNeighbours(int adjMatrix[][], GraphNodeAdjMatrix x, ArrayList<GraphNodeAdjMatrix> nodes){
        int nodeIndex = -1;
        ArrayList<GraphNodeAdjMatrix> neighbours = new ArrayList<>();

        //for all vertices
        for (int i = 0; i < nodes.size() ; i++){
            if(nodes.get(i).equals(x)){
                nodeIndex = i;
                break;
            }
        }

        if(nodeIndex != -1){
            for (int j = 0 ; j < adjMatrix[nodeIndex].length ; j++){
                if(adjMatrix[nodeIndex][j] == 1){
                    neighbours.add(nodes.get(j));
                }
            }
        }

        return neighbours;
    }

}
