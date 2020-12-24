package DataStructures.ADT.Heap.BinaryHeap;

/**
 * Created with IDEA
 * Author: MaYuzhe
 * Date: 2018/7/7
 * Time: 19:53
 * <p>
 * 二叉堆测试类
 */
public class BinaryHeapTest {
    public static void main(String[] args) {
        BinaryHeap binaryHeap = new BinaryHeap();
        int[] nums = new int[]{78, 23, 43, 22, 0, 98, 38};
        for (Integer num : nums) {
            binaryHeap.insert(num);
        }
        binaryHeap.print();

        System.out.println("堆是否为空:" + binaryHeap.isEmpty());


        System.out.println("获取最小值:" + binaryHeap.deleteMin());

        binaryHeap.print();

    }
}
