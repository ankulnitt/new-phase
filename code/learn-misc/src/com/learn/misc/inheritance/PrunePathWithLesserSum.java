package com.learn.misc.inheritance;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrunePathWithLesserSum {

    private TreeNode root;

    public PrunePathWithLesserSum(List<Integer> items) {
        create(items);
    }

    private void create (List<Integer> items) {   
        if (items.size() == 0) {
            root = null;
        } else {
            root = new TreeNode(items.get(0));
        }
        final Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        final int half = items.size() / 2;

        for (int i = 0; i < half; i++) {
            if (items.get(i) != null) {
                final TreeNode current = queue.poll();
                final int left = 2 * i + 1;
                final int right = 2 * i + 2;

                if (items.get(left) != null) {
                    current.left = new TreeNode(items.get(left));
                    queue.add(current.left);
                }
                if (right < items.size() && items.get(right) != null) {
                    current.right = new TreeNode(items.get(right));
                    queue.add(current.right);
                }
            }
        }
    }

    private static class TreeNode {
        private TreeNode left; 
        private int item;
        private TreeNode right;

        TreeNode(int item) {
            this.item = item;
        }
    }


    public void prune(int val) {
        if (root == null) {
            throw new IllegalStateException("The root cannot be null");
        }
        if (!recurse(root, 0, val)) {
            // if no patch exists then prune the root.
            root = null;
        }
    }


    public boolean recurse(TreeNode node, int sum, int value) {
       if (sum >= value) return true; 

       if (node == null) return false; 
       System.out.print(node.item + ">> ");

       boolean left = recurse (node.left, sum + node.item, value);
       boolean right = recurse (node.right, sum + node.item, value);

       System.out.println(" ");
       System.out.print("left " + node.item + " >> " + left);
       if (!left) {
           node.left = null;
       } 
       System.out.println(" ");
       System.out.print("right " + node.item + " >> " + right);
       if (!right) {
           node.right = null;
       }
       return left || right;
    }

    @Override
    public int hashCode() {
        return hashCompute(root, 0);
    }

    private int hashCompute (TreeNode node, int item) {
        if (node == null) return item;
        item = 31 * hashCompute (node.left, item) + node.hashCode();
        return hashCompute(node.right, item);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PrunePathWithLesserSum other = (PrunePathWithLesserSum) obj;
        return equal(root, other.root);
    }

    private  boolean equal(TreeNode node1,  TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.item != node2.item) {
            return false;
        }
        return equal(node1.left, node2.left) && equal(node1.right, node2.right);
    }
}


