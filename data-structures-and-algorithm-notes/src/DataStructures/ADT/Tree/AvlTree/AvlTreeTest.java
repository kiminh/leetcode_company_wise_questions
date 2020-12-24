package DataStructures.ADT.Tree.AvlTree;

/**
 * Created with IDEA
 * Author: MaYuzhe
 * Date: 2018/6/19
 * Time: 18:44
 *
 * AVL测试类
 */
public class AvlTreeTest {
    public static void main(String[] args) {
        AvlTree<Integer> avlTree = new AvlTree<>();
        for (int i = 1; i <= 10; i++) {
            avlTree.insert(i);
        }
        avlTree.printTree();
        System.out.println("该树是否平衡:" + avlTree.checkBalance());

        avlTree.remove(5);
        avlTree.printTree();
        System.out.println("该树是否平衡:" + avlTree.checkBalance());
    }

}
