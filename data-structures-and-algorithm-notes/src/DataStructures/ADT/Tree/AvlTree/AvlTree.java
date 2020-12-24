package DataStructures.ADT.Tree.AvlTree;


import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA
 * Author: MaYuzhe
 * Date: 2018/6/18
 * Time: 23:36
 * <p>
 * 平衡二叉树 Adelson-Velskii & Landis
 */
public class AvlTree<T extends Comparable<? super T>> {

    private static class AvlNode<T> {
        T element;
        AvlNode<T> left;
        AvlNode<T> right;
        int height;

        AvlNode(T element) {
            this(element, null, null);
        }

        AvlNode(T element, AvlNode<T> left, AvlNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    private static final int ALLOWED_IMBALANCE = 1;

    private AvlNode<T> root;

    public AvlTree() {
        root = null;
    }

    /**
     * 插入元素
     *
     * @param t 要被插入的元素
     */
    public void insert(T t) {
        root = insert(t, root);
    }

    /**
     * 移除元素
     *
     * @param t 要被移除的元素
     */
    public void remove(T t) {
        root = remove(t, root);
    }

    /**
     * 检查树是否平衡
     */
    public boolean checkBalance() {
        Map<String, Boolean> resultMap = new HashMap<>(1);
        resultMap.put("isBalance", true);
        checkBalance(root, resultMap);
        return resultMap.get("isBalance");
    }

    /**
     * 按照中序遍历打印树
     */
    public void printTree() {
        if (isEmpty()) {
            System.out.println("空树/Empty tree");
        } else {
            printTree(root);
        }
    }

    /**
     * 判断树是否为空
     *
     * @return 为空则返回true，否则返回false
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 判断元素是否在树中
     *
     * @param t 要被判断的元素
     * @return 存在则返回true，不存在返回false
     */
    public boolean contains(T t) {
        return contains(t, root);
    }

    /**
     * 使树置空
     */
    public void makeEmpty() {
        root = null;
    }

    /**
     * 查找最小元素
     *
     * @return 最小元素
     */
    public T findMin() {
        if (isEmpty()) {
            return null;
        }
        return findMin(root).element;
    }

    /**
     * 查找最大元素
     *
     * @return 最大元素
     */
    public T findMax() {
        if (isEmpty()) {
            return null;
        }
        return findMax(root).element;
    }

    /**
     * 获得节点的高度
     *
     * @param node 节点
     * @return 节点高度
     */
    private int height(AvlNode<T> node) {
        return node == null ? -1 : node.height;
    }


    private AvlNode<T> insert(T t, AvlNode<T> node) {
        if (node == null) {
            return new AvlNode<>(t, null, null);
        }

        int compareResult = t.compareTo(node.element);
        if (compareResult < 0) {
            node.left = insert(t, node.left);
        } else if (compareResult > 0) {
            node.right = insert(t, node.right);
        }
        return balance(node);
    }

    private AvlNode<T> remove(T t, AvlNode<T> node) {
        if (t == null) {
            return null;
        }
        int compareResult = t.compareTo(node.element);

        if (compareResult < 0) {
            node.left = remove(t, node.left);
        } else if (compareResult > 0) {
            node.right = remove(t, node.right);
        } else if (node.left != null && node.right != null) {
//            node.element = findMin(node.right).element;
//            node.right = remove(node.element, node.right);
            // 用removeRightMin方法替代上面两个操作，将两次遍历合并成一次遍历完成，提高效率
            node.right = removeRightMin(node, node.right);
        } else {
            node = node.left != null ? node.left : node.right;
        }
        return balance(node);
    }

    private AvlNode<T> removeRightMin(AvlNode<T> node, AvlNode<T> rNode) {
        if (rNode.left != null) {
            rNode.left = removeRightMin(node, rNode.left);
        } else {
            node.element = rNode.element;
            rNode = rNode.right;
        }
        return rNode;
    }

    /**
     * 平衡节点
     *
     * @param node
     * @return
     */
    private AvlNode<T> balance(AvlNode<T> node) {
        if (node == null) {
            return null;
        }

        if (height(node.left) - height(node.right) > ALLOWED_IMBALANCE) {
            if (height(node.left.left) >= height(node.left.right)) {
                // 左节点的左子节点高度大于左节点的右子节点或者左右子节点高度相等时
                node = rotateWithLeftChild(node);
            } else {
                node = doubleWithLeftChild(node);
            }
        } else if (height(node.right) - height(node.left) > ALLOWED_IMBALANCE) {
            if (height(node.right.right) >= height(node.right.left)) {
                // 右节点的右子节点高度大于右节点的左子节点或者左右子节点高度相等时
                node = rotateWithRightChild(node);
            } else {
                node = doubleWithRightChild(node);
            }
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    /**
     * 左单旋转
     *
     * @param k2
     * @return
     */
    private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2) {
        AvlNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height);
        return k1;
    }

    /**
     * 右单旋转
     *
     * @param k1
     * @return
     */
    private AvlNode<T> rotateWithRightChild(AvlNode<T> k1) {
        AvlNode<T> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.right), k1.height) + 1;
        return k2;
    }

    /**
     * 左-右双旋转
     *
     * @param k3
     * @return
     */
    private AvlNode<T> doubleWithLeftChild(AvlNode<T> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    /**
     * 右-左双旋转
     *
     * @param k1
     * @return
     */
    private AvlNode<T> doubleWithRightChild(AvlNode<T> k1) {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }

    private boolean contains(T t, AvlNode<T> node) {
        while (node != null) {
            int compareResult = t.compareTo(node.element);

            if (compareResult < 0) {
                node = node.left;
            } else if (compareResult > 0) {
                node = node.right;
            } else {
                return true;    // Match
            }
        }

        return false;   // No match
    }

    private AvlNode<T> findMin(AvlNode<T> node) {
        if (node == null) {
            return null;
        }

        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


    private AvlNode<T> findMax(AvlNode<T> node) {
        if (node == null) {
            return null;
        }

        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    private int checkBalance(AvlNode<T> node, Map<String, Boolean> resultMap) {
        if (node == null) {
            return -1;
        }
        int leftHeight = checkBalance(node.left, resultMap);
        int rightHeight = checkBalance(node.right, resultMap);
        if (Math.abs(height(node.left) - height(node.right)) > 1 ||
                height(node.left) != leftHeight || height(node.right) != rightHeight)
//            System.out.println("该树不平衡/Not balance");
            resultMap.put("isBalance", false);
        return height(node);
    }

    private void printTree(AvlNode<T> node) {
        if (node != null) {
            printTree(node.left);
            System.out.println(node.element);
            printTree(node.right);
        }
    }
}
