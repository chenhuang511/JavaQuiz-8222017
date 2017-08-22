package vn.sds.demo.singlylinkedlist;

import java.util.NoSuchElementException;

/**
 * Created by chen on 8/22/17.
 */
public class MySinglyLinkedList {
    private int size;
    private MyNode startNode;
    private MyNode endNode;

    public MySinglyLinkedList() {
        this.startNode = null;
        this.endNode = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return startNode == null;
    }

    public int size() {
        return size;
    }

    //Inserts the specified element at the beginning of this list.
    public void addFirst(int value) {
        MyNode newNode = new MyNode(value, null);
        if (startNode == null) {
            startNode = newNode;
            endNode = startNode;
        } else {
            newNode.setNext(startNode);
            startNode = newNode;
        }
        size++;
    }

    //Appends the specified element to the end of this list.
    public void addLast(int value) {
        MyNode newNode = new MyNode(value, null);
        if (startNode == null) {
            startNode = newNode;
            endNode = startNode;
        } else {
            endNode.setNext(newNode);
            endNode = newNode;
        }
    }

    //Inserts the specified element at the specified position in this list.
    public void add(int value, int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            addFirst(value);
        } else {
            MyNode newNode = new MyNode(value, null);
            MyNode pointer = startNode;
            index = index - 1;
            for (int i = 0; i < size; i++) {
                if (i == index) {
                    MyNode temp = pointer.getNext();
                    pointer.setNext(newNode);
                    newNode.setNext(temp);
                    break;
                }
                pointer = pointer.getNext();
            }
            size++;
        }
    }

    //Remove the tail element of this list
    public void removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        MyNode pointer = startNode;
        while (pointer != endNode) {
            pointer = pointer.getNext();
        }
        endNode = pointer;
        endNode.setNext(null);
        size--;
    }
}
