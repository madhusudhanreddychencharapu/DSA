package org.example.linkedlist;

public class DLLMainClass {
    public static void main(String[] args) {
        DLL dlist = new DLL();
        dlist.addFirst(30);
        dlist.addFirst(20);
        dlist.addFirst(10);
        dlist.addLast(40);
        dlist.addAtIndex(1,15);

        dlist.deleteFirst();
        dlist.deleteAtIndex(1);
        dlist.addLast(33);
        dlist.deleteAtIndex(2);
        System.out.println(dlist.deleteLast());
        dlist.display();
        dlist.displayReverse();


    }
}
