package com.dsa.airtribedsa.binaytrees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {

    static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Preorder Traversal:");
        preorder(root);
        System.out.println("Inorder Traversal:");
        inorder(root);
        System.out.println("Postorder Traversal:");
        postorder(root);
        System.out.println("Depth of Binary Tree: " + depthOfBinaryTree(root));
        System.out.println("Size of Binary Tree: " + sizeOfBinaryTree(root));
        System.out.println("Level Order Traversal:");
        levelOrderTraversal(root);
        System.out.println("Nodes at each level:" + nodesAtEachLevel(root));

    }

    private static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    private static int depthOfBinaryTree(Node root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = depthOfBinaryTree(root.left);
        int rightDepth = depthOfBinaryTree(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    private static int sizeOfBinaryTree(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSize = sizeOfBinaryTree(root.left);
        int rightSize = sizeOfBinaryTree(root.right);
        return leftSize + rightSize + 1;
    }

    private static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    private static void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    private static void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        // Implement level order traversal
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    private static List<List<Integer>> nodesAtEachLevel(Node root) {

        if (root == null) {
            return null;
        }

        List<List<Integer>> result = new LinkedList<>();

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> currentLevel = new LinkedList<>();
            for (int i = 0; i < length; i++) {
                Node currentNode = queue.remove();
                currentLevel.add(currentNode.data);

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            System.out.println(currentLevel);
            result.add(currentLevel);
        }

        return result;

    }

    private static void bfs(Node root) {
        // Implement BFS


    }
}
