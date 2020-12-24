package Alogrithm.Sort.HeapSort;

/**
 * Created with IDEA
 * Author: MaYuzhe
 * Date: 2018/7/14
 * Time: 17:06
 *
 * 堆排序测试类
 */
public class HeapSortTest {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{78, 23, 43, 22, 0, 98, 38};
        HeapSort.heapSort(arr);
        print(arr);
    }

    private static void print(Integer[] arr) {
        System.out.print("堆排序后的结果为: ");
        for (Integer item : arr) {
            System.out.print(item + " ");
        }
    }
}
