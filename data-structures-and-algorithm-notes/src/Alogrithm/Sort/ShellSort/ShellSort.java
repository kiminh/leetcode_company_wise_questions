package Alogrithm.Sort.ShellSort;

import Alogrithm.Sort.BaseSort;

/**
 * Created with IDEA
 * Author: MaYuzhe
 * Date: 2018/7/1
 * Time: 16:59
 * <p>
 * 希尔排序
 */
public class ShellSort extends BaseSort {

    /**
     * shellsort 希尔排序
     *
     * @param arr 被排序的数组
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void shellSort(T[] arr) {
        int p;
        // 增量gap，并逐步减半
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第gap个元素，对其所在的组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {
                T tmp = arr[i];
                // 同插入排序，进行移位
                for (p = i; p >= gap && tmp.compareTo(arr[p - gap]) < 0; p -= gap) {
                    arr[p] = arr[p - gap];
                }
                arr[p] = tmp;
            }
        }
    }

    @Override
    public <T extends Comparable<? super T>> void sort(T[] array) {
        shellSort(array);
    }
}
