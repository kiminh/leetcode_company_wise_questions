package Alogrithm.Sort.TestHelper;

import Alogrithm.Sort.BaseSort;


/**
 * @author Yuzhe Ma
 * @date 2019/1/18
 */
public class TestSort {
    /**
     * 测试排序算法性能
     *
     * @param name     算法名称
     * @param arr      排序数组
     * @param baseSort 排序类
     */
    public static void testSort(String name, Integer[] arr, BaseSort baseSort) {
        double startTime = System.currentTimeMillis();
        baseSort.sort(arr);
        double endTime = System.currentTimeMillis();
        double dSecs = (endTime - startTime) / 1000d;
        if (assertIsOrdered(arr)) {
            System.out.println("排序算法 " + name + " 的时间为 " + dSecs + "s");
        }
    }

    /**
     * 判断数组是否为排序状态
     *
     * @param arr 数组
     * @return
     */
    private static boolean assertIsOrdered(Integer[] arr) {
        boolean b = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                System.out.println("该算法排序结果不正确");
                b = false;
                return b;
            }
        }
        return b;
    }
}
