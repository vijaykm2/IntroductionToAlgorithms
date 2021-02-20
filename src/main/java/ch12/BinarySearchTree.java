package ch12;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
public class BinarySearchTree {
    TreeNode root;
    int length;

    private TreeNode addRecursive(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }
        if (value < current.val) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.val) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }
        return current;
    }
    private void doInOrderTraversal(TreeNode root, List result){
        if(root.left != null){
            doInOrderTraversal(root.left, result);
        }
        result.add(root.val);
        if(root.right != null){
            doInOrderTraversal(root.right, result);
        }

    }

    public int[] doInOrderTraversal(){
        List<Integer> rs = new ArrayList<>();
        int[] result = new int[length];
        doInOrderTraversal(root, rs);
        result = rs.stream().mapToInt(i -> i).toArray();
        return result;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    public TreeNode findParent(TreeNode current, TreeNode parent, int val){
        if(current.val == val){
            return parent;
        }
        if(val < current.val){
            return findParent(current.left, current, val);
        } else{
            return findParent(current.right, current, val);
        }
    }

    public TreeNode add(int[] values) {
        length = values.length;
        for (int value : values) {
            add(value);
        }
        return root;

    }

    public TreeNode search(TreeNode node, int val){

        if(node == null || node.val == val){
            return node;
        }else if(val < node.val){
            return search(node.left, val);
        }else{
            return search(node.right, val);
        }
    }

    public TreeNode search(int val){
        TreeNode node = this.root;

        return this.search(node, val);
    }
    public TreeNode treeMinimum(TreeNode treeNode){
        TreeNode node ;
        if(treeNode == null){
            node = this.root;
        } else{
            node = treeNode;
        }

        while (node.left != null){
            node = node.left;
        }
        return node;
    }
    public TreeNode treeMaximum(TreeNode treeNode){
       TreeNode node;
        if(treeNode == null){
            node = this.root;
        } else{
            node = treeNode;
        }
        while(node.right != null){
            node = node.right;
        }
        return node;
    }
}
