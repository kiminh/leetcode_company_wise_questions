package Alogrithm.Sort.MergeSort;

import Alogrithm.Sort.BaseSort;

/**
 * Created with IDEA
 * Author: MaYuzhe
 * Date: 2018/7/22
 * Time: 16:22
 * <p>
 * 归并排序
 */
public class MergeSort extends BaseSort {

    /**
     * 归并排序，对外暴露的方法
     * @param a 准备被排序的数组
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void mergeSort(T[] a) {
        T[] tmpArr = (T[]) new Comparable[a.length];
        mergeSort(a, tmpArr, 0, a.length - 1);
    }

    /**
     * 归并排序
     * @param a 原数组
     * @param tmpArr 临时数组
     * @param leftPos 数组第一个元素索引
     * @param rightPos 数组最后一个元素索引
     * @param <T>
     */
    private static <T extends Comparable<? super T>>
    void mergeSort(T[] a, T[] tmpArr, int leftPos, int rightPos) {
        if (leftPos < rightPos) {
            // 分
            int centerPos = (leftPos + rightPos) / 2;
            mergeSort(a, tmpArr, leftPos, centerPos);
            mergeSort(a, tmpArr, centerPos + 1, rightPos);

            // 治
            merge(a, tmpArr, leftPos, centerPos + 1, rightPos);
        }
    }

    /**
     * 合并两个数组
     * @param a 原数组
     * @param tmpArr 临时数组
     * @param leftPos 左数组第一个元素索引
     * @param rightPos 右数组第一个元素索引
     * @param rightEnd 右数组最后一个元素索引
     * @param <T>
     */
    private static <T extends Comparable<? super T>>
    void merge(T[] a, T[] tmpArr, int leftPos, int rightPos, int rightEnd) {
        // 左方数组末位元素索引
        int leftEnd = rightPos - 1;
        // 临时指针为左数组第一个元素索引
        int tmpPos = leftPos;
        // 整个数组元素个数
        int numElements = rightEnd - leftPos + 1;

        // 当两个子数组都没有遍历完前，依次对比两个数组的元素
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a[leftPos].compareTo(a[rightPos]) <= 0) {
                tmpArr[tmpPos++] = a[leftPos++];
            } else {
                tmpArr[tmpPos++] = a[rightPos++];
            }
        }

        // 将左边数组剩余元素填入tmp中
        while (leftPos <= leftEnd) {
            tmpArr[tmpPos++] = a[leftPos++];
        }

        // 将右边数组剩余元素填入tmp中
        while (rightPos <= rightEnd) {
            tmpArr[tmpPos++] = a[rightPos++];
        }

        // 将tmp中的数组拷贝回原数组
        for (int i = 0; i < numElements; i++, rightEnd--) {
            a[rightEnd] = tmpArr[rightEnd];
        }
    }

    @Override
    public <T extends Comparable<? super T>> void sort(T[] array) {
        mergeSort(array);
    }
}
