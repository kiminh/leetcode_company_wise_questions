package DataStructures.ADT.Tree.BinaryTree.InorderTraversal;

import DataStructures.ADT.Tree.BinaryTree.BinaryNode;
import DataStructures.ADT.Tree.BinaryTree.BinaryTreeFactory;
import DataStructures.ADT.Tree.BinaryTree.PostorderTraversal.PostorderTraversal;

/**
 * Created with IDEA
 * Author: MaYuzhe
 * Date: 2018/6/15
 * Time: 15:08
 *
 * 测试中序遍历
 */
public class InorderTraversalTest {
    public static void main(String[] args) {
        BinaryNode binaryTree = BinaryTreeFactory.createBinaryTree();
        InorderTraversal inorderTraversal = new InorderTraversal();
        inorderTraversal.printTreeByInorderTraversal(binaryTree);
        System.out.println();
        inorderTraversal.printTreeByInorderTraversalStack(binaryTree);
    }
}
