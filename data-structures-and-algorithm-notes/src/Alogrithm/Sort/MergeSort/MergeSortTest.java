package Alogrithm.Sort.MergeSort;

/**
 * Created with IDEA
 * Author: MaYuzhe
 * Date: 2018/7/22
 * Time: 17:13
 * <p>
 * 归并排序测试类
 */
public class MergeSortTest {
    public static void main(String[] args) {
        Integer[] arr = {46, 99, 32, 12, 14, 9, 53, 20};
        MergeSort.mergeSort(arr);
        print(arr);
    }

    private static <T> void print(T[] arr) {
        System.out.print("归并排序后的结果为: ");
        for (T item : arr) {
            System.out.print(item.toString() + " ");
        }
    }
}
