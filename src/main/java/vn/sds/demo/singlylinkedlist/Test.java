package vn.sds.demo.singlylinkedlist;

/**
 * Created by chen on 8/22/17.
 */
public class Test {
    public static void main(String[] args) {
        MySinglyLinkedList myList = new MySinglyLinkedList();
        myList.addFirst(1);
        myList.addLast(5);
        myList.add(4, 1);
        myList.add(3, 2);
        myList.add(10, 2);
        myList.add(7, 4);

        myList.print();

        myList.removeLast();

        myList.print();

        myList.removeGreaters(9);

        myList.print();
    }

}
