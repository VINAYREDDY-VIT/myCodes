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
class Node {

    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BST {

    public boolean isNodeExist(Node node, int data) {
        if (node == null) {
            return false;
        }
        if (data > node.data) {
            return isNodeExist(node.right, data);
        } else if (data < node.data) {
            return isNodeExist(node.left, data);
        } else {
            return true;
        }
    }

    public Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }
        return node;
    }

    public Node delete(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (data < node.data) {
            node.left = delete(node.left, data);
        } else if (data > node.data) {
            node.right = delete(node.right, data);
        } else {
            if (node.left == null || node.right == null) {
                Node temp = node.left == null ? node.right : node.left;
                if (temp == null) {
                    return null;
                } else {
                    return temp;
                }
            } else {
                Node successor = getSuccessor(node);
                node.data = successor.data;
                node.right = delete(node.right, node.data);
            }
        }
        return node;
    }

    public Node getSuccessor(Node node) {
        if (node == null) {
            return null;
        }
        Node temp = node.right;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    public void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    public void postorder(Node node) {
        if (node != null) {
            inorder(node.left);
            inorder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public void preorder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            inorder(node.left);
            inorder(node.right);
        }
    }

    public Node ParentNode(Node node, int data) {
        if (node == null) {
            return null;
        }
        Node parent = null;
        while (node != null) {
            if (node.data > data) {
                node = node.left;
            } else if (node.data < data) {
                node = node.right;
            } else {
                return parent;
            }
            parent = node;
        }
        return parent;
    }
}

public class BSTApp {

    public static void main(String[] sai) {
        BST tree = new BST();
        Node root = null;
        System.out.println("Enter the number of elements to be entered : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            root = tree.insert(root, sc.nextInt());
        }
        //search for a element
        System.out.println("Enter the number to be searched : ");
        int search = sc.nextInt();
        boolean present = tree.isNodeExist(root, search);
        if (present) {
            System.out.println(search + " found.");
        } else {
            System.out.println(search + " not found.");
        }
        //delete
        System.out.println("Enter the number to be deleted : ");
        int ele = sc.nextInt();
        if (tree.isNodeExist(root, ele)) {
            System.out.println(ele + " deleted.");
            root = tree.delete(root, ele);
        } else {
            System.out.println(ele + " not found.");
        }

        //inorder
        System.out.print("Inorder traversal ");
        tree.inorder(root);
        System.out.println();

        //postorder
        System.out.print("Postorder traversal ");
        tree.postorder(root);
        System.out.println();

        //preorder
        System.out.print("Preorder traversal ");
        tree.preorder(root);
        System.out.println();

        //parentnode
        System.out.println("Enter the number to get parent node : ");
        ele = sc.nextInt();
        if (tree.isNodeExist(root, ele)) {
            Node getparent = tree.ParentNode(root, ele);
            if (getparent != null) {
                System.out.println(getparent.data + " is the parent of " + ele);
            } else {
                System.out.println("Parent doesn't exist for " + ele);
            }
        } else {
            System.out.println(ele + " not found.");
        }
        
    }
}
