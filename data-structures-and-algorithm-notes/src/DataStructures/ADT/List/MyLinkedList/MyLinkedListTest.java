package DataStructures.ADT.List.MyLinkedList;

import java.util.Iterator;

public class MyLinkedListTest {
    public static void main(String[] args) {
        // 初始化MyLinkedList
        MyLinkedList<Integer> list = new MyLinkedList<>();
        System.out.println("list的长度为:" + list.size());
        System.out.println("list的是否为空:" + list.isEmpty());

        // 测试添加元素
        list.add(1);
        list.add(2);
        System.out.println("list的长度为:" + list.size());
        System.out.println("list的是否为空:" + list.isEmpty());
        System.out.println("list内容为:");
        System.out.println(list);

        // 测试插入元素
        list.add(0, 100);
        System.out.println("list的首位为:" + list.get(0));

        // 测试修改元素
        list.set(0, 200);
        System.out.println("list的首位为:" + list.get(0));

        // 测试删除元素
        list.remove(1);
        System.out.println("list内容为:");
        System.out.println(list);

        // 测试迭代器
        Iterator itr = list.iterator();
        System.out.println("用迭代器遍历输出list:");
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // 测试迭代器删除元素
        itr = list.iterator();
        while (itr.hasNext()) {
            itr.next();
            itr.remove();
        }
        System.out.println("list是否为空:" + list.isEmpty());
    }
}
