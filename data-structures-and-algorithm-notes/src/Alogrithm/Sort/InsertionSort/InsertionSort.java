package Alogrithm.Sort.InsertionSort;

import Alogrithm.Sort.BaseSort;

/**
 * Created with IDEA
 * Author: MaYuzhe
 * Date: 2018/7/1
 * Time: 13:51
 * <p>
 * 插入排序类
 */
public class InsertionSort extends BaseSort {

    /**
     * InsertionSort 插入排序
     *
     * @param arr 被排序的数组
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void insertionSort(T[] arr) {
        int p;
        for (int i = 1; i < arr.length; i++) {
            // 储存当前访问的节点值
            T tmp = arr[i];
            for (p = i; p > 0 && tmp.compareTo(arr[p - 1]) < 0; p--) {
                // 如果tmp小于arr[p - 1]的值，则后移一位
                arr[p] = arr[p - 1];
            }
            // 将tmp替换p位置的值（上面的for已经将原来的p后移了）
            arr[p] = tmp;
        }
    }

    /**
     * InsertionSort 插入排序
     *
     * @param arr 被排序的数组
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void insertionSort(T[] arr, int l, int r) {
        int p;
        for (int i = l + 1; i <= r; i++) {
            // 储存当前访问的节点值
            T tmp = arr[i];
            for (p = i; p > l && tmp.compareTo(arr[p - 1]) < 0; p--) {
                // 如果tmp小于arr[p - 1]的值，则后移一位
                arr[p] = arr[p - 1];
            }
            // 将tmp替换p位置的值（上面的for已经将原来的p后移了）
            arr[p] = tmp;
        }
    }

    @Override
    public <T extends Comparable<? super T>> void sort(T[] array) {
        insertionSort(array);
    }
}
