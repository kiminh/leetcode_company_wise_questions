package Alogrithm.Sort.QuickSort;

import Alogrithm.Sort.BaseSort;
import Alogrithm.Sort.InsertionSort.InsertionSort;

/**
 * @author Yuzhe Ma
 * @date 2019/1/21
 */
public class QuickSort2Ways extends BaseSort {
    @Override
    public <T extends Comparable<? super T>> void sort(T[] array) {
        quickSort(array);
    }

    public static <T extends Comparable<? super T>> void quickSort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<? super T>> void quickSort(T[] arr, int l, int r) {
        if (r - l < 16) {
            InsertionSort.insertionSort(arr, l, r);
            return;
        }
        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    private static <T extends Comparable<? super T>> int partition(T[] arr, int l, int r) {
        // 取得数组中随机的索引，与第一位互换
        swapReferences(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        T tmp = arr[l];

        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= r && arr[i].compareTo(tmp) < 0) {
                i++;
            }
            while (j >= l + 1 && arr[j].compareTo(tmp) > 0) {
                j--;
            }
            if (i > j) {
                break;
            }
            swapReferences(arr, i, j);
            i++;
            j--;
        }
        swapReferences(arr, l, j);

        return j;
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
}
