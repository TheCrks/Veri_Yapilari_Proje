package com.example.javaproject;

import javafx.scene.control.ListView;

import java.util.ArrayList;

public class BSearchTree {
    ArrayList<TreeNode> nodes = new ArrayList<>();
    TreeNode root;
    BSearchTree(TreeNode root){
        this.root = root;
        nodes.add(root);
    }

    public void add(TreeNode node,TreeNode root){
        if (node.value <= root.value){
            if (root.left == null){
                root.left = node;
                nodes.add(node);
            }else {
                add(node, root.left);
            }
        }
        else {
            if (root.right == null){
                root.right = node;
                nodes.add(node);
            }else{
                add(node,root.right);
            }
        }
    }

    public void printToString(TreeNode root){
        if (root != null){
            printToString(root.left);
            System.out.println(root.data);
            printToString(root.right);
        }
    }

    public void inOrderAdd(ListView list , TreeNode root){
        if (root != null){
            inOrderAdd(list,root.left);
            list.getItems().add(root.data);
            inOrderAdd(list,root.right);
        }
    }

}
