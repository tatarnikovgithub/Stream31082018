package ru.geekbrains.algjava.lesson6.online;

import java.util.List;
import java.util.TreeSet;

public class Tree {
    private TreeNode root;

    public Person find(int id) {
        TreeNode current = root;
        while (current.person.uid != id) {
            if (id < current.person.uid)
                current = current.left;
            else
                current = current.right;
            if (current == null)
                return null;
        }
        return current.person;

    }

    public void insert(Person p) {
        TreeNode node = new TreeNode(p);
        if (root == null) {
            root = node;
        } else {
            TreeNode current = root;
            TreeNode parent;
            while (true) {
                parent = current;
                if (p.uid < current.person.uid) {
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                        return;
                    }
                }
            }
        }
    }

    private void inOrderedTravers(TreeNode current){
        if (current != null){
            inOrderedTravers(current.left);
            System.out.println(current);
            inOrderedTravers(current.right);
        }
    }
    public void displayTreeToConsole(){
        inOrderedTravers(root);
    }

    public Person minId(){
        if (root == null) return null;
        TreeNode current = root;
        TreeNode last = null;
        while(current !=null){
            last = current;
            current = current.left;
        }
        return last.person;
    }

    public Person maxId(){
        if (root == null) return null;
        TreeNode current = root;
        while(current.right != null){
            current = current.right;
        }
        return current.person;
    }

    public boolean delete(int id){
        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeftChild = true;

        // search
        while(current.person.uid != id){
            parent = current;
            if (id < current.person.uid){
                current = current.left;
                isLeftChild = true;
            } else {
                current = current.right;
                isLeftChild = false;
            }

        }
        if (current == null){
            return false;
        }

        // if it is a leaf
        if (current.left == null && current.right == null){
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.left = null;
            else
                parent.right = null;
            // if only one child exist
        } else if (current.right == null){
            if (isLeftChild)
                parent.left = current.left;
            else
                parent.right =  current.left;
        } else if(current.left == null){
            if (isLeftChild)
                parent.left = current.right;
            else parent.right =  current.right;
            // if both children exist
        } else {
            TreeNode successor = getSuccessor(current);
            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.left = successor;
            else
                parent.right = successor;
            successor.left = current.left;
        }
        return true;
    }

    private TreeNode getSuccessor(TreeNode node){
        TreeNode parent = node;
        TreeNode s = node;
        TreeNode current = node.right;

        while(current != null){
            parent = s;
            s = current;
            current = current.left;
        }
        if (s!= node.right){
            parent.right = s.right;
            s.right = node.right;
        }
        return s;
    }
}
