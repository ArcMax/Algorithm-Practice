package com.basics.algorithm.archana.algorithmbasics.heaps;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by archana on 6/16/2018.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class OperationsOfTrees {
    public static void main(String[] args) {
        OperationsOfTrees ofTrees = new OperationsOfTrees();
        ofTrees.mainFunction();
    }

    void mainFunction() {

        TreeNode root = new TreeNode(50);
        insertNode(root, 10);
        insertNode(root, 9);
        insertNode(root, 15);
        insertNode(root, 11);
        insertNode(root, 18);
        insertNode(root, 80);
//        insertNode(root,11);

        //delete node in BST
        //deleteNode(root, 10);

        System.out.print("Inorder" + inOrderTraversal(root));
        System.out.println();
        System.out.print("PreOrder" + preOrderTraversal(root));
        System.out.println();
        System.out.println("PostOrder" + postOrderTraversal(root));

        //search value in BST
        System.out.println("search value" + searchValue(root, 60));

        //Level order traversal
        System.out.println("Level order traversal"+levelOrderTraversal(root));
    }

    //INORDER TRAVERSAL RECURSION
    public TreeNode inOrderTraversal(TreeNode root) {
        if (root == null)
            return root;
        inOrderTraversal(root.left);
        System.out.print(root.val + ",");
        inOrderTraversal(root.right);
        return root;
    }

    //PREORDER TRAVERSAL RECURSION
    public TreeNode preOrderTraversal(TreeNode root) {
        if (root == null)
            return root;
        System.out.print(root.val + ",");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
        return root;
    }

    //POSTORDER TRAVERSAL RECURSION
    public TreeNode postOrderTraversal(TreeNode root) {
        if (root == null)
            return root;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + ",");
        return root;
    }

    //INSERT NODE IN BST
    public TreeNode insertNode(TreeNode root, int val) {

        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        if (val <= root.val) {
            root.left = insertNode(root.left, val);
        } else if (val > root.val) {
            root.right = insertNode(root.right, val);
        }
        return root;
    }

    //DELETE A NODE IN A BST
    public TreeNode deleteNode(TreeNode root, int data) {

        //Base case if root is null;
        if (root == null)
            return root;
        /*if node to be deleted is leaf node, return null to parent*/
        //otherwise recurse down the tree
        if (data < root.val) {
            root.left = deleteNode(root.left, data);
        } else if (data > root.val) {
            root.right = deleteNode(root.right, data);
        }

        /*if node to be deleted has one child, copy child to node & delete child*/
        //when data is same as root node, then this is the node to be deleted
        else {
            //GraphNodeAdjList with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            /*if node to be deleted has 2 child nodes, copy inorder successor to node and delete inorder successor*/

            //copy successor to node with minValue of right subtree
            root.val = minValue(root.right);

            //Delete the successor
            root.right = deleteNode(root.right, root.val);

            return root;
        }
        return root;
    }

    //FIND NEXT SUCCESSOR
    int minValue(TreeNode root) {
        //initialize minimum val in right subtree
        int minVal = root.val;
        while (root.left != null) {
            minVal = root.left.val;
            root = root.left;
        }
        return minVal;
    }

    //SEARCH GIVEN VALUE IN BST
    public TreeNode searchValue(TreeNode root, int key) {
        //if given key is the value in root or if root is null,return root
        if (root == null || root.val == key)
            return root;
        //else if value is greater than root, check right subtree
        if (key > root.val) { // if key is greater than the root ,search in right subtree
            return searchValue(root.right, key);
        } else if (key <= root.val) { //else check left subtree
            return searchValue(root.left, key);
        }
        return root;
    }

    //Iterative InOrderTraversal
    public List<Integer> inOrderIterative(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        //rename root node to iterate inside this function as it doesn't affect original node
        TreeNode current = root;

        while (current != null || stack.isEmpty()) {
            //check again for current is null or not,  if is not, add to stack move to left
            while (current != null) {
                stack.add(current);
                current = current.left;
            }

            //after printing all left node into stack, pop from stack & add to list
            //then recurse right
            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }
        return list;
    }

    //Iterative PreOrderTraversal
    public List<Integer> preOrderIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        //base case if root is null
        if (root == null) return list;
        //push to stack
        stack.push(root);
        //if stack not empty
        while (!stack.isEmpty()) {
            //pop from stack
            TreeNode current = stack.pop();
            //add to output
            list.add(current.val);
            //push to stack right first and left, so when it pops out puts left to output
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }

        return list;
    }

    //Iterative PostOrderTraversal
    public List<Integer> postOrderIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        //Base case if root is null
        if (root == null) return list;
        //push to stack
        stack.push(root);
        //if stack is not empty
        while (!stack.isEmpty()) {
            //peek to stack
            TreeNode current = stack.peek();
            //check if current left & right are null, if yes pop from stack and print
            if (current.right == null && current.left == null) {
                TreeNode popNode = stack.pop();
                list.add(popNode.val);
            } else {
                //push right first to stack and make node null
                if (current.right != null) {
                    stack.push(current.right);
                    current.right = null;
                }
                // push left to stack & make node null
                if (current.left != null) {
                    stack.push(current.left);
                    current.left = null;
                }
            }
        }
        return list;
    }

    //LEVEL-ORDER-TRAVERSAL
    List<List<Integer>> levelOrderTraversal(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();

        if(root == null) return list;

        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()){
            root = nodeQueue.poll();
            level.add(root.val);

            if(nodeQueue.isEmpty()){
                list.add(level);
                level = new ArrayList<>();
            }
            if(root.left != null){
                nodeQueue.add(root.left);
            }
            if (root.right != null){
                nodeQueue.add(root.right);
            }

        }
        return list;
    }
}


