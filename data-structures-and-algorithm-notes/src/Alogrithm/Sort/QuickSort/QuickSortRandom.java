package Alogrithm.Sort.QuickSort;

import Alogrithm.Sort.BaseSort;

/**
 * @author Yuzhe Ma
 * @date 2019/1/19
 */
public class QuickSortRandom extends BaseSort {
    private volatile static int nums = 0;

    public static <T extends Comparable<? super T>> void quickSort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 对[l, j]的部分进行快排
     *
     * @param arr 数组
     * @param l   左端索引
     * @param r   右端索引
     * @param <T>
     */
    private static <T extends Comparable<? super T>> void quickSort(T[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    /**
     * 返回索引 p，使得 arr[l, p - 1] < arr[p] 并且 arr[p + 1, r] > arr[p]
     *
     * @param arr
     * @param l
     * @param r
     * @param <T>
     * @return
     */
    private static <T extends Comparable<? super T>> int partition(T[] arr, int l, int r) {
        // 取得数组中随机的索引，与第一位互换
        swapReferences(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        T tmp = arr[l];
        int j = l + 1;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(tmp) < 0) {
                swapReferences(arr, i, j);
                j++;
            }
        }
        swapReferences(arr, l, j - 1);
        return j - 1;
    }

    /**
     * 调换索引1和索引2两处的元素
     *
     * @param array  原数组
     * @param index1 索引1
     * @param index2 索引2
     * @param <T>
     */
    public static <T> void swapReferences(T[] array, int index1, int index2) {
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }


    @Override
    public <T extends Comparable<? super T>> void sort(T[] array) {
        quickSort(array);
    }
}
