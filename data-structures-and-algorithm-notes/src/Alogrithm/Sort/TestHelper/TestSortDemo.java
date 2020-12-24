package Alogrithm.Sort.TestHelper;

import Alogrithm.Sort.HeapSort.HeapSort;
import Alogrithm.Sort.MergeSort.MergeSort;
import Alogrithm.Sort.QuickSort.QuickSort;
import Alogrithm.Sort.QuickSort.QuickSort2Ways;
import Alogrithm.Sort.QuickSort.QuickSort3Ways;
import Alogrithm.Sort.ShellSort.ShellSort;

/**
 * @author Yuzhe Ma
 * @date 2019/1/18
 */
public class TestSortDemo {
    public static void main(String[] args) {
        Integer[] integers1 = IntegerTestTool.getRandomArr(0, 10, 1000000);
        Integer[] integers2 = IntegerTestTool.copyArr(integers1);
        Integer[] integers3 = IntegerTestTool.copyArr(integers1);
//        Integer[] integers2 = IntegerTestTool.copyArr(integers1);
//        Integer[] integers3 = IntegerTestTool.copyArr(integers1);
//        Integer[] integers4 = IntegerTestTool.copyArr(integers1);
//        Integer[] integers5 = IntegerTestTool.copyArr(integers1);

//        TestSort.testSort("HeapSort", integers1, new HeapSort());
//        TestSort.testSort("InsertionSort", integers2, new InsertionSort());
//        TestSort.testSort("ShellSort", integers3, new ShellSort());
//        TestSort.testSort("MergeSort", integers4, new MergeSort());
//        TestSort.testSort("QuickSort", integers5, new QuickSort());

        TestSort.testSort("MergeSort", integers1, new MergeSort());
        TestSort.testSort("QuickSort2Ways", integers2, new QuickSort2Ways());
        TestSort.testSort("QuickSort3Ways", integers3, new QuickSort3Ways());
    }
}
