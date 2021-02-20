package ch12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {
    @Test
    public void testBST(){
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        TreeNode node = binarySearchTree.add(new int[]{8,-1,17,89,-23,22,71,-111,98,38,28,0,9});
        System.out.println("after bst add");
        int[] sorted = binarySearchTree.doInOrderTraversal();
        System.out.println("after inorder traversol");
        TreeNode node2 = binarySearchTree.search(22);
        Assertions.assertNotNull(node2);
        System.out.println(node2.val);
        TreeNode node3 = binarySearchTree.search(-999);
        Assertions.assertNull(node3);
        node3 = binarySearchTree.treeMinimum(null);
        Assertions.assertNotNull(node3);
        System.out.println(node3.val);
        node3 = binarySearchTree.treeMaximum(null);
        Assertions.assertNotNull(node3);
        System.out.println(node3.val);
        TreeNode parent = binarySearchTree.findParent(node3);
        System.out.println("parent of "+node3.val +" is " +parent.val);

    }

}
