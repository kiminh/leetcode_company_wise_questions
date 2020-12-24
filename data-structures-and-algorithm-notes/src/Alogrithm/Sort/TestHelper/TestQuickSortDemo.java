package Alogrithm.Sort.TestHelper;

import Alogrithm.Sort.MergeSort.MergeSort;
import Alogrithm.Sort.QuickSort.QuickSortRandom;

/**
 * @author Yuzhe Ma
 * @date 2019/1/19
 */
public class TestQuickSortDemo {
    public static void main(String[] args) {
        Integer[] integers1 = IntegerTestTool.getNearlyOrderedArr(100000, 10);
        Integer[] integers2 = IntegerTestTool.copyArr(integers1);

        TestSort.testSort("MergeSort", integers1, new MergeSort());
//        TestSort.testSort("QuickSort", integers2, new QuickSort());
        TestSort.testSort("QuickSort", integers2, new QuickSortRandom());
    }
}
