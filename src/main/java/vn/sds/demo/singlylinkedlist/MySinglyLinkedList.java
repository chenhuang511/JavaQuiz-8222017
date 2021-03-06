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
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            addFirst(value);
            return;
        }
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
            if (pointer != null)
                pointer = pointer.getNext();
        }
        size++;
    }

    //Remove the tail element of this list
    public void removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        MyNode pointer = startNode;
        while (pointer.getNext() != endNode) {
            pointer = pointer.getNext();
        }
        endNode = pointer;
        endNode.setNext(null);
        size--;
    }

    //Remove all elements that is great than a target value in this list
    public void removeGreaters(int value) {
        while (startNode != null && startNode.getValue() > value) {
            startNode = startNode.getNext();
            size--;
        }

        if (startNode == null) {
            endNode = null;
            return;
        }

        MyNode pointer = startNode.getNext();
        MyNode prev = startNode;

        while (pointer != null) {
            if (pointer.getValue() > value) {
                size--;
            } else {
                prev.setNext(pointer);
                prev = pointer;
            }
            pointer = pointer.getNext();
        }
        prev.setNext(null);
        endNode = prev;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        if (startNode.getNext() == null) {
            System.out.println(startNode.getValue());
            return;
        }
        MyNode pointer = startNode;
        System.out.print(startNode.getValue() + "->");
        pointer = pointer.getNext();
        while (pointer.getNext() != null) {
            System.out.print(pointer.getValue() + "->");
            pointer = pointer.getNext();
        }
        System.out.print(pointer.getValue() + "\n");
    }
}
