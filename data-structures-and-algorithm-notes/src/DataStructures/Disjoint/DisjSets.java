package DataStructures.Disjoint;

/**
 * 不相交集类
 *
 * @author Yuzhe Ma
 * @date 2018/12/8
 */
public class DisjSets {

    private int[] s;
    private final int DEFALUT_VALUE = -1;

    /**
     * 初始化
     *
     * @param numElements 数组长度
     */
    public DisjSets(int numElements) {
        s = new int[numElements];
        for (Integer item : s) {
            item = DEFALUT_VALUE;
        }
    }

    /**
     * 寻找元素所在集
     * @param index 元素所在索引
     * @return
     */
    public int find(int index) {
        if (s[index] == DEFALUT_VALUE) {
            return index;
        }
        return find(s[index]);
    }
}
