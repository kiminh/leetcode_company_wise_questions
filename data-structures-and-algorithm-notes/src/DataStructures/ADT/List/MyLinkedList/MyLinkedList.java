package DataStructures.ADT.List.MyLinkedList;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {
    private int theSize;
    private int modCount;
    private Node<T> beginMarker;
    private Node<T> endMarker;

    public MyLinkedList() {
        clear();
    }

    /**
     * 清空链表初始化
     */
    private void clear() {
        beginMarker = new Node<T>(null, null, null);
        endMarker = new Node<T>(null, beginMarker, null);
        beginMarker.next = endMarker;
        theSize = 0;
        modCount++;
    }

    /**
     * 返回链表长度
     *
     * @return 链表长度
     */
    public int size() {
        return theSize;
    }

    /**
     * 判断链表是否为空
     *
     * @return 空为true，非空为false
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 添加元素到末位
     *
     * @param t 要添加的节点
     * @return
     */
    public boolean add(T t) {
        add(size(), t);
        return true;
    }

    /**
     * 添加节点到指定索引处
     *
     * @param index 索引值
     * @param t     要添加的节点
     */
    public void add(int index, T t) {
        // 这里getNode第三个参数是size()的原因是，当添加节点到末位的时候，索引值为当前列表长度。
        // 如果size() - 1的话，在getNode中开会的判断中会报IndexOutOfBoundsException
        addBefore(getNode(index, 0, size()), t);
    }

    /**
     * 在给定node之前插入新node
     *
     * @param p 当前node
     * @param t 要插入的新node
     */
    private void addBefore(Node<T> p, T t) {
//        if (p == beginMarker) {
//            Node<T> newNode = new Node<>(t, beginMarker, beginMarker.next);
//            beginMarker.next.prev = p;
//            beginMarker.next = newNode;
//        }else {
//            Node<T> newNode = new Node<>(t, p.prev, p);
//            newNode.prev.next = newNode;
//            p.prev = newNode;
//        }
        Node<T> newNode = new Node<>(t, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }

    /**
     * 获取指定索引的元素
     *
     * @param index 索引值
     * @return 该索引下的元素
     */
    public T get(int index) {
        return getNode(index).data;
    }

    /**
     * 替换指定索引的元素
     *
     * @param index 索引
     * @param t     新元素
     * @return 旧元素
     */
    public T set(int index, T t) {
        Node<T> node = getNode(index);
        T oldValue = node.data;
        node.data = t;
        return oldValue;
    }


    /**
     * 删除索引所在位置的元素
     *
     * @param index 索引
     * @return 被删除的元素
     */
    public T remove(int index) {
        return remove(getNode(index));
    }

    /**
     * 删除节点
     *
     * @param p 要被删除的节点
     * @return 被删除的节点的值
     */
    private T remove(Node<T> p) {
        p.prev.next = p.next;
        p.next.prev = p.prev;
        modCount++;
        theSize--;
        return p.data;
    }

    /**
     * 根据索引获得节点
     *
     * @param index 索引
     * @return 该索引下的节点
     */
    private Node<T> getNode(int index) {
        return getNode(index, 0, size() - 1);
    }

    /**
     * 获取index索引对应的节点。根据索引位置选择从前或后开始遍历。
     *
     * @param index 索引值
     * @param lower 首位索引
     * @param upper 末位索引
     * @return 返回该索引下的节点
     */
    private Node<T> getNode(int index, int lower, int upper) {
        Node<T> p;
        if (index < lower || index > upper) {
            throw new IndexOutOfBoundsException();
        }

        // 如果索引在链表前半部分，则从前开始遍历。否则从后向前遍历。
        if (index < size() / 2) {
            p = beginMarker.next;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
        } else {
            p = endMarker;
            for (int i = size(); i > index; i--) {
                p = p.prev;
            }
        }
        return p;
    }

    @Override
    public String toString() {
        String str = "";
        Node<T> p = beginMarker;
        while (p.next != endMarker) {
            str += p.next.data.toString() + "\n";
            p = p.next;
        }
        return str;
    }


    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    /**
     * Node节点内部类
     *
     * @param <T>
     */
    private static class Node<T> {
        // 元素内容
        T data;
        // 上一个元素
        Node<T> prev;
        // 下一个元素
        Node<T> next;

        Node(T d, Node<T> p, Node<T> n) {
            data = d;
            prev = p;
            next = n;
        }
    }


    private class LinkedListIterator implements Iterator<T> {
        // 当前节点。默认是beginMarker.next，即第一个节点
        private Node<T> current = beginMarker.next;
        // 用于检测迭代期间集合被修改的情况。默认和modCount相等。
        private int expectedModCount = modCount;
        // 用于判断是否可以被删除
        private boolean okToRemove = false;

        /**
         * 判断是否有下一节点。如果当前节点为endMarker，则说明没有下一节点了。
         * @return
         */
        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        /**
         * 迭代到下一节点
         * @return
         */
        @Override
        public T next() {
            // 迭代过程中如果集合被修改，则抛出异常
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T nextItem = current.data;
            current = current.next;
            // 置为true
            okToRemove = true;
            return nextItem;
        }

        /**
         * 移除节点
         */
        @Override
        public void remove() {
            // 迭代过程中如果集合被修改，则抛出异常
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new IllegalStateException();
            }

            MyLinkedList.this.remove(current.prev);
            // modCount保持同步
            expectedModCount++;
            // 置为false
            okToRemove = false;
        }
    }
}
