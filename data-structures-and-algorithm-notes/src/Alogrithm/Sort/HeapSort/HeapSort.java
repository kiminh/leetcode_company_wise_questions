package Alogrithm.Sort.HeapSort;

import Alogrithm.Sort.BaseSort;

/**
 * Created with IDEA
 * Author: MaYuzhe
 * Date: 2018/7/14
 * Time: 16:40
 * <p>
 * 堆排序
 */
public class HeapSort extends BaseSort {
    public static <T extends Comparable<? super T>> void heapSort(T[] array) {
        // 创建堆
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            // 下滤
            percolateDown(array, i, array.length);
        }

        // 排序
        for (int i = array.length - 1; i > 0; i--) {
            // 将最大元素(第0位元素)与第i位元素置换
            swapReferences(array, 0, i);
            // 下滤
            percolateDown(array, 0, i);
        }
    }

    /**
     * 获取索引为i的节点的左节点索引
     *
     * @param i i节点的索引
     * @return 左节点的索引
     */
    private static int getLeftChildIndex(int i) {
        return i * 2 + 1;
    }

    /**
     * 下滤
     *
     * @param array 原数组
     * @param i     当前节点索引
     * @param n     元素个数
     * @param <T>
     */
    private static <T extends Comparable<? super T>> void percolateDown(T[] array, int i, int n) {
        int child;
        T tmp = array[i];
        for (; getLeftChildIndex(i) < n; i = child) {
            child = getLeftChildIndex(i);
            if (child != n - 1 && array[child].compareTo(array[child + 1]) < 0) {
                child++;
            }
            if (tmp.compareTo(array[child]) < 0) {
                array[i] = array[child];
            } else {
                break;
            }
        }
        array[i] = tmp;
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
        heapSort(array);
    }
}
