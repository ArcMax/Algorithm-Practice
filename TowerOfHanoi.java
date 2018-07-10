package com.basics.algorithm.archana.algorithmbasics.OnGitHub;

/**
 * Created by archana on 6/21/2018.
 *
 * Enter number of discs: 3
 A -> C
 A -> B
 C -> B
 A -> C
 B -> A
 B -> C
 A -> C
 */

public class TowerOfHanoi {
    public static void main(String[] args){
        int numberOfNodes = 3;
        towerOfHanoiMain(numberOfNodes);
    }

    static void towerOfHanoiMain(int disks){
        towerOfHanoiRecurse(disks,'A','B','C');
    }

    static void towerOfHanoiRecurse(int n, char start,char aux,char end){
        //Base case when only one disk is left to move
        if(n ==1){
            System.out.println(start + " -> " + end);
            return;
        }
        /*When we need to move n-1 discs from the start pole to the auxiliary pole,
        the auxiliary pole becomes the end pole and the end pole becomes the auxiliary pole.
         That is why we have written
        solve(n - 1, start, end, auxiliary)
        instead of
        solve(n - 1, start, auxiliary, end)*/
        towerOfHanoiRecurse(n-1,start,end,aux);
        System.out.println(start + " -> " + end);
        towerOfHanoiRecurse(n-1,aux,start,end);
    }
}
