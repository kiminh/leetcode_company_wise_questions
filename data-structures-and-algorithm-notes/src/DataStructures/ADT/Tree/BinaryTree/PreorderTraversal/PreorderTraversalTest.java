package DataStructures.ADT.Tree.BinaryTree.PreorderTraversal;

import DataStructures.ADT.Tree.BinaryTree.BinaryNode;
import DataStructures.ADT.Tree.BinaryTree.BinaryTreeFactory;

/**
 * Created with IDEA
 * Author: MaYuzhe
 * Date: 2018/6/15
 * Time: 14:45
 *
 * 测试先序遍历
 */
public class PreorderTraversalTest {
    public static void main(String[] args) {
        BinaryNode binaryTree = BinaryTreeFactory.createBinaryTree();
        PreorderTraversal preorderTraversal = new PreorderTraversal();
        preorderTraversal.printTreeByPreorderTraversal(binaryTree);
        System.out.println();
        preorderTraversal.printTreeByPreorderTraversalStack(binaryTree);
    }
}
