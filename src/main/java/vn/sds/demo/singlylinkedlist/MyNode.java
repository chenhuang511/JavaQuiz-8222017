package vn.sds.demo.singlylinkedlist;

/**
 * Created by chen on 8/22/17.
 */
public class MyNode {
    private int value;
    private MyNode next;

    public MyNode() {
        this.value = 0;
        this.next = null;
    }

    public MyNode(int value, MyNode next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public MyNode getNext() {
        return next;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }
}
