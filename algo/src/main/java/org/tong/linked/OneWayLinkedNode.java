package org.tong.linked;

/**
 * @description:
 * @author: yanghantong
 * @time: 2024/6/19 15:29
 */
public class OneWayLinkedNode <T extends Comparable>{

    private T data;

    public OneWayLinkedNode<T> next = null;


    public OneWayLinkedNode(T data) {
        this.data = data;
    }

    public OneWayLinkedNode() {

    }

    public OneWayLinkedNode(OneWayLinkedNode<T> node) {
        this.data = node.getData();
        this.next = node.next;
    }

    public OneWayLinkedNode(T data, OneWayLinkedNode<T> next) {
        this.data = data;
        this.next = next;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
