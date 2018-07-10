package com.basics.algorithm.archana.algorithmbasics.heaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by archana on 7/9/2018.
 */
class TrieNode {
    char c;
    HashMap<Character, TrieNode> childrens = new HashMap<>();
    boolean isLeaf;

    public TrieNode() {
    }

    public TrieNode(char c) {
        this.c = c;
    }
}

public class BasicTrieImplementation {

    private TrieNode root;

    public BasicTrieImplementation() {
        root = new TrieNode();
    }

    public static void main(String[] args){
        BasicTrieImplementation trieImplementation = new BasicTrieImplementation();
       String[] listOfWords = {"cat","bat","dog","god","man","yosi","car"};

        for (int i = 0 ;i <listOfWords.length ; i++) {
            trieImplementation.insert(listOfWords[i]);
        }

        System.out.println(trieImplementation.search("car"));

        System.out.println(trieImplementation.search("ball"));

    }

    //insert a word into trie
    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.childrens;

        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            TrieNode t;
            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                children.put(c, t);
            }
            children = t.childrens;

            //set end of word
            if (i == word.length() - 1) {
                t.isLeaf = true;
            }
        }
    }

    //Search string in an word
    public boolean search(String word){
        TrieNode search = searchWord(word);
        if (search != null && search.isLeaf){
            return true;
        }
        return false;
    }

    public boolean searchWithPrefix(String prefix){
        TrieNode withPrefix = searchWord(prefix);
        if (withPrefix == null){
            return false;
        }
        return true;
    }

    public TrieNode searchWord(String s){
        Map<Character, TrieNode> child = root.childrens;
        TrieNode t = null;
        for (int i = 0 ; i <s.length();i++){
            char c = s.charAt(i);
            if (child.containsKey(c)){
                t = child.get(c);
                child = t.childrens;
            }else{
                return  null;
            }
        }
        return t;
    }
}
