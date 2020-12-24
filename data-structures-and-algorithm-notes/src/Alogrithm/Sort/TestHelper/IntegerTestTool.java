package Alogrithm.Sort.TestHelper;

/**
 * @author Yuzhe Ma
 * @date 2019/1/18
 */
public class IntegerTestTool {
    /**
     * 生成随机数组
     *
     * @param start 起始
     * @param end   结束
     * @param num   数量
     * @return
     */
    public static Integer[] getRandomArr(Integer start, Integer end, Integer num) {
        Integer[] res = new Integer[num];
        for (int i = 0; i < num; i++) {
            res[i] = (int) ((Math.random()) * end - start);
        }
        return res;
    }

    /**
     * 拷贝数组
     *
     * @param oriArr
     * @return
     */
    public static Integer[] copyArr(Integer[] oriArr) {
        return oriArr.clone();
    }

    /**
     * 获得几乎于排序的数组
     *
     * @param num       数组大小
     * @param swapTimes 调整次数
     * @return
     */
    public static Integer[] getNearlyOrderedArr(int num, int swapTimes) {
        Integer[] arr = new Integer[num];
        for (int i = 0; i < num; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < swapTimes; i++) {
            int a = (int) ((Math.random()) * num);
            int b = (int) ((Math.random()) * num);
            swap(arr, a, b);
        }
        return arr;
    }

    /**
     * 调换数组中两个元素的位置
     *
     * @param arr 数组
     * @param a   索引 a
     * @param b   索引 b
     * @return
     */
    public static Integer[] swap(Integer[] arr, int a, int b) {
        int tmp;
        tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
        return arr;
    }

    public static void printlnArr(Integer[] ints) {
        for (Integer i : ints) {
            System.out.println(i);
        }
    }

    public static void printArr(Integer[] ints) {
        for (Integer i : ints) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
