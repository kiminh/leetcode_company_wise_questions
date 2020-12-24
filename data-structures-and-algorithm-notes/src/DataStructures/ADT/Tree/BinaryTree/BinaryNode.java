package DataStructures.ADT.Tree.BinaryTree;

/**
 * Created with IDEA
 * Author: MaYuzhe
 * Date: 2018/6/15
 * Time: 14:20
 * <p>
 * <p>
 * 二叉树节点类
 */
public class BinaryNode {
    // 节点元素
    private Object element;
    // 左节点
    private BinaryNode left;
    // 右节点
    private BinaryNode right;

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }
}
