package DataStructures.ADT.Tree.BinaryTree.PreorderTraversal;

import DataStructures.ADT.Tree.BinaryTree.BinaryNode;

import java.util.Stack;

/**
 * Created with IDEA
 * Author: MaYuzhe
 * Date: 2018/6/15
 * Time: 14:41
 */
public class PreorderTraversal {

    /**
     * 先序遍历打印二叉树（递归）
     *
     * @param rootNode
     */
    public void printTreeByPreorderTraversal(BinaryNode rootNode) {
        // 先输出根节点
        System.out.print(rootNode.getElement().toString() + " ");
        if (rootNode.getLeft() != null) {
            // 访问左节点
            printTreeByPreorderTraversal(rootNode.getLeft());
        }
        if (rootNode.getRight() != null) {
            // 再访问右节点
            printTreeByPreorderTraversal(rootNode.getRight());
        }
    }

    /**
     * 先序遍历打印二叉树（堆栈）
     *
     * @param rootNode
     */
    public void printTreeByPreorderTraversalStack(BinaryNode rootNode) {
        Stack<BinaryNode> stack = new Stack<>();
        while (rootNode != null || stack.size() > 0) {
            if (rootNode != null) {
                stack.push(rootNode);
                System.out.print(rootNode.getElement().toString() + " ");
                rootNode = rootNode.getLeft();
            } else {
                rootNode = stack.pop();
                rootNode = rootNode.getRight();
            }
        }
    }
}
