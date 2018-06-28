package com.basics.algorithm.archana.algorithmbasics.heaps;

/**
 * Created by archana on 6/28/2018.
 * <p>
 * How many ways to reach X given score 2,3,6
 */

public class AmericanFootball {
    public static void main(String[] args) {
        int targetScore = 8;
        int[] scores = {2, 3, 6};
        System.out.println("Not dynamic scores:  " + numberOfWays(targetScore));
        System.out.println("Dynamic scores:  " + numberOfWays(targetScore, scores));
    }

    // When scores are dynamic
    static int numberOfWays(int targetScore, int[] scores) {
        //set the dp table to store values
        //dp table is 1D with target scores 0 to target scores
        int[] table = new int[targetScore + 1];
        // set table zero to 1
        table[0] = 1;

        //loop through the table with index as its length of the target score take that to consederation
        for (int i = 1; i <= targetScore; i++) {
            //than static score make it dynamic by adding scores in array or any data structure to loop through
            for (int score : scores) {
                //Main logic this is the key to dynamic programming
                //add values to table at i index
                //if index i is greater than score we do our calculations else set it to zero
                //if greater substract the ith target score with scores & sum to value
                // we are finding the last element so our answer will be sum up at last element in the table
                table[i] += ((i >= score) ? table[i - score] : 0);
            }
        }
        //return last element
        return table[targetScore];
    }

    //When scores are not dynamic
    static int numberOfWays(int targetScore) {
        //set the dp table to store values
        //dp table is 1D with target scores 0 to target scores
        //to save space can add heighest score +1 bec while looking back in table we only look for heighst value among score in table
        int[] table = new int[6 + 1];
        // set table zero to 1
        table[0] = 1;

        //loop through the table with index as its length of the target score take that to consederation
        for (int i = 1; i <= targetScore; i++) {
            //Main logic this is the key to dynamic programming
            //add values to table at i index
            //if index i is greater than score we do our calculations else set it to zero
            //if greater substract the ith target score with scores & sum to value
            // we are finding the last element so our answer will be sum up at last element in the table
            table[i%7] += ((i >= 2) ? table[(i+7-2)%7] : 0) + ((i >= 3) ? table[(i+7-3)%7] : 0) + ((i >= 6) ? table[(i+7-6)%7] : 0);
        }
        //return last element
        return table[targetScore%7];
    }
}
