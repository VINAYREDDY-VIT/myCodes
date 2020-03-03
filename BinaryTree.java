/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.util.Scanner;

/**
 *
 * @author reddy
 */
public class BinaryTree {
    static Node root;
    public void addNode(int key) {
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
        }
        else {
            Node focusNode = root;
            Node parent;
            while (true) {
                parent = focusNode;
                if (key < focusNode.key) {
                    focusNode = focusNode.leftChild;
                    if (focusNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else {
                    focusNode = focusNode.rightChild;
                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        return; 
                    }
                }
            }
        }
    }
    public static void inOrderTraverseTree(Node focusNode) {
    	if (focusNode != null) {
            inOrderTraverseTree(focusNode.leftChild);
            System.out.println(focusNode.key);
            inOrderTraverseTree(focusNode.rightChild);
	}
    }
    static int maxDepth(Node node){ 
        if (node == null) 
            return 0; 
        else {
            int lDepth = maxDepth(node.leftChild); 
            int rDepth = maxDepth(node.rightChild);
            if (lDepth > rDepth) 
                return (lDepth + 1); 
             else 
                return (rDepth + 1); 
        } 
    }
    public static void main(String[] args) {
        BinaryTree theTree = new BinaryTree();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-->0){
            int num = sc.nextInt();
            theTree.addNode(num);   
        }
        inOrderTraverseTree(theTree.root);
        System.out.println(maxDepth(theTree.root));
    }
}

class Node {
    int key;
    Node leftChild;
    Node rightChild;
    Node(int key) {
    	this.key = key;
    }
}
