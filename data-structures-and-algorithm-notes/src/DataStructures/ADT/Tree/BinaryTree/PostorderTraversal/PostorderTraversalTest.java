package DataStructures.ADT.Tree.BinaryTree.PostorderTraversal;

import DataStructures.ADT.Tree.BinaryTree.BinaryNode;
import DataStructures.ADT.Tree.BinaryTree.BinaryTreeFactory;
import DataStructures.ADT.Tree.BinaryTree.PreorderTraversal.PreorderTraversal;

/**
 * Created with IDEA
 * Author: MaYuzhe
 * Date: 2018/6/15
 * Time: 15:02
 *
 * 测试后序遍历
 */
public class PostorderTraversalTest {
    public static void main(String[] args) {
        BinaryNode binaryTree = BinaryTreeFactory.createBinaryTree();
        PostorderTraversal postorderTraversal = new PostorderTraversal();
        postorderTraversal.printTreeByPostorderTraversal(binaryTree);
        System.out.println();
        postorderTraversal.printTreeByPostorderTraversalWith2Stacks(binaryTree);
    }
}
