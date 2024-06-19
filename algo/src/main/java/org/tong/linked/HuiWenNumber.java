package org.tong.linked;

import java.util.LinkedList;

/**
 * @description:回文数的解法，使用单向链表
 * @author: yanghantong
 * @time: 2024/6/19 15:27
 */
public class HuiWenNumber {

    public static void main(String[] args) {
        OneWayLinkedNode<Character> head = new OneWayLinkedNode<>();
        OneWayLinkedNode<Character> node1 = new OneWayLinkedNode<>('a');
        OneWayLinkedNode<Character> node2 = new OneWayLinkedNode<>('b');
        OneWayLinkedNode<Character> node3 = new OneWayLinkedNode<>('a');
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
//        System.out.println(insertHead(head));
        System.out.println(fastAndSlowPointer(head));
    }

    /**
     * 介绍：头插法，创建一个新链表，一个一个比较
     * 注意：1.比较时使用的是Comparable的CompareTo方法，所以该泛型需要实现该类
     * 时间复杂度：o(n)
     * 空间复杂度：o(n)
     */
    public static<T extends Comparable> Boolean insertHead(OneWayLinkedNode<T> head) {
        OneWayLinkedNode<T> newHead = new OneWayLinkedNode<>();
        OneWayLinkedNode<T> current1 = head.next;
        while (current1 != null) {
            OneWayLinkedNode<T> temp = new OneWayLinkedNode<>(current1);
            temp.next = newHead.next;
            newHead.next = temp;
            current1 = current1.next;
        }
        current1 = head.next;
        OneWayLinkedNode<T> current2 = newHead.next;
        while (current1 != null) {
            if (current1.getData().compareTo(current2.getData()) != 0) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return true;
    }

    /**
     * 介绍：快慢指针，定位中间位置，从中间位置开始向两边遍历，比较遍历的元素
     * 注意：1.快指针一次走两步，慢指针一次走一步，当快指针走到末尾时，慢指针刚好走到中间
     * 时间复杂度: o(n)
     * 空间复杂度: o(1)
     */
    public static<T extends Comparable> Boolean fastAndSlowPointer(OneWayLinkedNode<T> head) {
        OneWayLinkedNode<T> slow = head.next, fast = head.next, prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            OneWayLinkedNode<T> next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        //奇数个节点，中间值跳过
        if (fast != null) {
            slow = slow.next;
        }
        while (prev != null) {
            if (prev.getData().compareTo(slow.getData()) != 0) {
                return false;
            }
            prev = prev.next;
            slow = slow.next;
        }
        return true;
    }
}
