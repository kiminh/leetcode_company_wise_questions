package DataStructures.ADT.Tree.BinarySearchTree;

/**
 * Created with IDEA
 * Author: MaYuzhe
 * Date: 2018/6/17
 * Time: 15:42
 *
 * BinarySearchTreeTest 二叉查找树测试类
 */
public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        // 测试insert，并用中序遍历打印树
        binarySearchTree.insert(10);
        binarySearchTree.insert(5);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(8);
        binarySearchTree.insert(6);
        binarySearchTree.insert(9);
        binarySearchTree.insert(7);
        binarySearchTree.insert(17);
        binarySearchTree.insert(16);
        binarySearchTree.insert(18);
        binarySearchTree.printTree();

        // 测试remove
        binarySearchTree.remove(5);
        binarySearchTree.printTree();

        // 测试isEmpty方法
        System.out.println("树是否为空：" + binarySearchTree.isEmpty());

        // 测试contains
        System.out.println("树是否包含16:" + binarySearchTree.contais(16));
        System.out.println("树是否包含100:" + binarySearchTree.contais(100));

        // 测试findMin、findMax
        System.out.println("树的最小数据为:" + binarySearchTree.findMin());
        System.out.println("树的最大数据为:" + binarySearchTree.findMax());

        // 测试makeEmpty
        binarySearchTree.makeEmpty();
        System.out.println("树是否为空：" + binarySearchTree.isEmpty());

    }
}
