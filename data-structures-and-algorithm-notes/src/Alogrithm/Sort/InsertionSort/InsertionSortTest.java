package Alogrithm.Sort.InsertionSort;


/**
 * Created with IDEA
 * Author: MaYuzhe
 * Date: 2018/7/1
 * Time: 14:02
 * <p>
 * 插入排序算法测试类
 */
public class InsertionSortTest {
    public static void main(String[] args) {
        Integer[] arr = {46, 34, 32, 12, 14, 9};
        InsertionSort.insertionSort(arr);
        print(arr);
    }


    private static <T> void print(T[] arr) {
        for (T t : arr) {
            System.out.print(t.toString() + " ");
        }
        System.out.println();
    }
}
