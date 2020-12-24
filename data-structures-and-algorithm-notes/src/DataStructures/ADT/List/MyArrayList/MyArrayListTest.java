package DataStructures.ADT.List.MyArrayList;

import java.util.Iterator;

public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<Integer> list1 = new MyArrayList<>();
        // 测试List初始化内容
        System.out.println("list1的元素个数为:" + list1.size());
        System.out.println("list1为空：" + list1.isEmpty());
        System.out.println("list1的长度为:" + list1.length());

        // 测试添加元素
        list1.add(1);
        list1.add(2);
        System.out.println("list1的第一个元素为:" + list1.get(0));

        // 测试插入元素
        list1.add(0, 100);
        System.out.println("list1的第一个元素为:" + list1.get(0));

        // 测试更新元素
        list1.set(1, 200);
        System.out.println("list1的第一个元素为:" + list1.get(1));

        // 测试移除元素
        list1.remove(2);
        System.out.println("list1的元素为:");

        // 测试list扩容
        System.out.println(list1);
        for (int i = 3; i < 15; i++) {
            list1.add(i);
        }
        System.out.println("list1的元素为:");
        System.out.println(list1);

        // 测试list长度裁剪
        System.out.println("list1的长度为:" + list1.length());
        list1.trimToSize();
        System.out.println("trimToSize后，list1的长度为:" + list1.length());

        // 测试迭代器
        Iterator itr = list1.iterator();
        System.out.println("用迭代器遍历输出list1");
        while (itr.hasNext()) {
            System.out.println(itr.next().toString());
        }

        // 测试迭代器删除元素
        itr = list1.iterator();
        while (itr.hasNext()) {
            itr.next();
            itr.remove();
        }
        System.out.println("list1为空：" + list1.isEmpty());
    }
}
