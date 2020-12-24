package Alogrithm.Sort.QuickSort;

import Alogrithm.Sort.BaseSort;
import Alogrithm.Sort.InsertionSort.InsertionSort;

/**
 * @author Yuzhe Ma
 * @date 2019/1/21
 */
public class QuickSort3Ways extends BaseSort {
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

        swapReferences(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        T tmp = arr[l];

        // arr[l + 1, lt] < v
        int lt = l;
        // arr[gt, r] > v
        int gt = r + 1;
        // arr[lt + 1, i) == v
        int i = l + 1;

        while (i < gt) {
            if (arr[i].compareTo(tmp) == -1) {
                swapReferences(arr, i, lt + 1);
                lt++;
                i++;
            } else if (arr[i].compareTo(tmp) == 1) {
                swapReferences(arr, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }
        swapReferences(arr, l, lt);

        quickSort(arr, l, lt - 1);
        quickSort(arr, gt, r);
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
