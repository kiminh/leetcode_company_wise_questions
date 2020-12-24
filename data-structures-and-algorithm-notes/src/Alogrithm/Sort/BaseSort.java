package Alogrithm.Sort;

/**
 * @author Yuzhe Ma
 * @date 2019/1/18
 */
public abstract class BaseSort {
    public abstract <T extends Comparable<? super T>> void sort(T[] array);
}
