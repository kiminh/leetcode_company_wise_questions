package DataStructures.ADT.List.MyArrayList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements Iterable<T> {
    // 默认容量
    private static final int DEFAULT_CAPACITY = 10;

    // 列表元素个数
    private int theSize;
    // 列表元素
    private T[] theItems;

    public MyArrayList() {
        clear();
    }

    /**
     * 清空列表，创建默认长度List
     */
    public void clear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    /**
     * 返回当前列表元素个数
     *
     * @return
     */
    public int size() {
        return theSize;
    }

    /**
     * 判断列表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 将列表容量裁剪成跟元素个数一致
     */
    public void trimToSize() {
        ensureCapacity(size());
    }

    /**
     * 列表长度
     *
     * @return
     */
    public int length() {
        return theItems.length;
    }

    /**
     * 扩容
     *
     * @param newCapacity 容量大小
     */
    public void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) {
            return;
        }
        T[] old = theItems;
        theItems = (T[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            theItems[i] = old[i];
        }
    }

    /**
     * 根据索引获取列表值
     *
     * @param index 索引值
     * @return 该索引下的元素
     */
    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[index];
    }

    /**
     * 替换索引所在位置的元素
     *
     * @param index 索引值
     * @param t     新元素
     * @return 旧元素
     */
    public T set(int index, T t) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T old = theItems[index];
        theItems[index] = t;
        return old;
    }

    /**
     * 添加元素到索引位置
     *
     * @param index 索引值
     * @param t     新元素
     */
    public void add(int index, T t) {
        if (theItems.length == size()) {
            // "+1是用来处理size()为0时的情况
            ensureCapacity(size() * 2 + 1);
        }
        // 索引后的元素依次后移一位
        for (int i = size(); i > index; i--) {
            theItems[i] = theItems[i - 1];
        }
        theItems[index] = t;
        theSize++;
    }

    /**
     * 添加元素到列表末位
     *
     * @param t 新元素
     */
    public void add(T t) {
        add(size(), t);
    }

    /**
     * 移除索引所在位置元素
     *
     * @param index 索引值
     * @return 被移除的元素
     */
    public T remove(int index) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T rmT = theItems[index];
        // 索引后的所有元素前移一位
        for (int i = index; i < size() - 1; i++) {
            theItems[i] = theItems[i + 1];
        }
        theSize--;
        return rmT;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < size(); i++) {
            if (theItems[i] != null) {
                str += theItems[i].toString() + "\n";
            } else {
                str += "null\n";
            }
        }
        return str;
    }

    /**
     * 获得该列表的迭代器
     *
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    /**
     * 内部类,迭代器
     */
    private class ArrayListIterator implements Iterator<T> {

        // 记录当前索引，默认为0
        private int current = 0;

        /**
         * 判断元素是否存在
         *
         * @return
         */
        @Override
        public boolean hasNext() {
            return current < size();
        }

        /**
         * 获取当前迭代器迭代的元素
         *
         * @return 当前迭代器迭代的元素
         */
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            // 获取后，current值+1
            return theItems[current++];
        }

        /**
         * 移除元素
         */
        @Override
        public void remove() {
            // 移除元素实际上是调用next()方法后，再remove。而next()后，current值被加1，是为了下次迭代做准备。
            // 所以如果想删除next()方法返回的元素，需要删除current值-1后的索引所在的元素。
            // 又因为移除元素后，后面的元素位置发生了变化，所以current必须的值必须-1。所以使用--。
            MyArrayList.this.remove(--current);
        }
    }
}
