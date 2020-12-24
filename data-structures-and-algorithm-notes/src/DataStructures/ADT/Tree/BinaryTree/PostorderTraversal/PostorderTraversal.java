package DataStructures.ADT.Tree.BinaryTree.PostorderTraversal;

import DataStructures.ADT.Tree.BinaryTree.BinaryNode;

import java.util.Stack;

/**
 * Created with IDEA
 * Author: MaYuzhe
 * Date: 2018/6/15
 * Time: 15:01
 */
public class PostorderTraversal {

    /**
     * 后续遍历打印二叉树（递归）
     *
     * @param rootNode
     */
    public void printTreeByPostorderTraversal(BinaryNode rootNode) {
        if (rootNode.getLeft() != null) {
            // 先访问左节点
            printTreeByPostorderTraversal(rootNode.getLeft());
        }
        if (rootNode.getRight() != null) {
            // 再访问右节点
            printTreeByPostorderTraversal(rootNode.getRight());
        }
        // 输出根节点
        System.out.print(rootNode.getElement().toString() + " ");
    }

    /**
     * 后续遍历打印二叉树（堆栈）
     * 用两个堆栈实现
     *
     * @param rootNode
     */
    public void printTreeByPostorderTraversalWith2Stacks(BinaryNode rootNode) {
        // 用于遍历
        Stack<BinaryNode> stack = new Stack<>();
        // 用于记录输出的堆栈
        Stack<BinaryNode> output = new Stack<>();
        while (rootNode != null || stack.size() > 0) {
            if (rootNode != null) {
                stack.push(rootNode);
                output.push(rootNode);
                // 先找右节点
                rootNode = rootNode.getRight();
            } else {
                rootNode = stack.pop();
                rootNode = rootNode.getLeft();
            }
        }
        while (output.size() > 0) {
            System.out.print(output.pop().getElement().toString() + " ");
        }
    }
}
