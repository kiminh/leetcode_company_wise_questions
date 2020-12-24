package DataStructures.ADT.Heap.BinaryHeap;

/**
 * Created with IDEA
 * Author: MaYuzhe
 * Date: 2018/7/7
 * Time: 18:30
 * <p>
 * 二叉堆  BinaryHeap（这里也为最小堆 min-heap）
 */
public class BinaryHeap<T extends Comparable<? super T>> {
    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        currentSize = 0;
        arr = (T[]) new Comparable[capacity + 1];
    }

    public BinaryHeap(T[] items) {
        currentSize = items.length;
        arr = (T[]) new Comparable[(currentSize + 2) * 11 / 10];

        int i = 1;
        for (T item : items) {
            arr[i++] = item;
        }
        buildHeap();
    }

    /**
     * 二叉堆的插入方法。使用上滤法。
     *
     * @param t 被插入的元素
     */
    public void insert(T t) {
        if (currentSize == arr.length - 1) {
            // 如果当前元素个数为数组长度-1，则扩容
            enlargeArray(arr.length * 2 + 1);
        }
        int hole = ++currentSize;
        // arr[0] = t初始化，最后如果循环到顶点，t.compartTo(arr[hole / 2])即arr[0]为0，循环结束
        for (arr[0] = t; t.compareTo(arr[hole / 2]) < 0; hole /= 2) {
            // 根节点的值赋值到子节点
            arr[hole] = arr[hole / 2];
        }
        // 根节点(或树叶节点)赋值为t
        arr[hole] = t;
    }

    /**
     * 寻找堆内最小值。索引1处的元素最小。
     *
     * @return
     */
    public T findMin() {
        if (isEmpty()) {
            // 这里如果堆为空，可以抛出异常。
            // throw new UnderflowException( );
        }
        // 第1位的元素最小
        return arr[1];
    }

    public T deleteMin() {
        if (isEmpty()) {
            // 这里如果堆为空，可以抛出异常。
            // throw new UnderflowException( );
        }
        T minItem = findMin();
        // 将最后一个节点赋值到根节点
        arr[1] = arr[currentSize--];
        // 从根节点执行下滤
        percolateDown(1);
        return minItem;
    }

    /**
     * 判断堆是否为空
     *
     * @return 为空返回true；否则返回false
     */
    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * 堆置空
     */
    public void makeEmpty() {
        currentSize = 0;
    }

    /**
     * 打印堆
     */
    public void print(){
        System.out.print("堆为:");
        for (int i = 1;arr[i] != null;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static final int DEFAULT_CAPACITY = 10;

    private int currentSize;
    private T[] arr;

    /**
     * 下滤
     *
     * @param hole 下滤其实的节点的索引
     */
    private void percolateDown(int hole) {
        int child;
        T tmp = arr[hole];

        for (; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;
            if (child != currentSize && arr[child + 1].compareTo(arr[child]) < 0) {
                // 做子节点不为左后一个节点（说明有右节点）且右节点比做节点小，索引改为右节点节点
                child++;
            }
            if (arr[child].compareTo(tmp) < 0) {
                // 如果遍历到的这个节点比最后一个元素小
                arr[hole] = arr[child];
            } else {
                break;
            }
        }
        // 将最后一个元素补到前面的空位
        arr[hole] = tmp;
    }

    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--) {
            percolateDown(i);
        }
    }

    /**
     * 扩容
     * @param newSize 新数组的大小
     */
    private void enlargeArray(int newSize) {
        T[] old = arr;
        arr = (T[]) new Comparable[newSize];
        for (int i = 0; i < old.length; i++) {
            arr[i] = old[i];
        }
    }
}
