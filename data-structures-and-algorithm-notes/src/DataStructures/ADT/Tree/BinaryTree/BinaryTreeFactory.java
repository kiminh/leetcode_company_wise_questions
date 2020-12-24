package DataStructures.ADT.Tree.BinaryTree;

/**
 * Created with IDEA
 * Author: MaYuzhe
 * Date: 2018/6/15
 * Time: 14:28
 * <p>
 * 用于创建二叉树
 */
public class BinaryTreeFactory {

    /**
     * Create a binary tree like this
     * 生成一个如下所示的二叉树
     *
     *                      10
     *              5               15
     *          3       7       13      20
     *        1   4       8   11          30
     *
     *
     * @return
     */
    public static BinaryNode createBinaryTree() {
        int[] nums = new int[]{10, 5, 15, 3, 7, 13, 20, 1, 4, 8, 11, 30};
        BinaryNode[] binaryNodes = new BinaryNode[12];
        for (int i = 0; i < binaryNodes.length; i++) {
            binaryNodes[i] = new BinaryNode();
            binaryNodes[i].setElement(nums[i]);
        }

        binaryNodes[3].setLeft(binaryNodes[7]);
        binaryNodes[3].setRight(binaryNodes[8]);

        binaryNodes[4].setRight(binaryNodes[9]);

        binaryNodes[5].setLeft(binaryNodes[10]);

        binaryNodes[6].setRight(binaryNodes[11]);

        binaryNodes[1].setLeft(binaryNodes[3]);
        binaryNodes[1].setRight(binaryNodes[4]);

        binaryNodes[2].setLeft(binaryNodes[5]);
        binaryNodes[2].setRight(binaryNodes[6]);

        binaryNodes[0].setLeft(binaryNodes[1]);
        binaryNodes[0].setRight(binaryNodes[2]);
        return binaryNodes[0];
    }
}
