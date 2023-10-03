package org.example.linkedlist;

public class MainClass {
    //MERGE SORTED LIST
    public static LL mergeSortedList(LL first,LL second){
        Node f = first.head;
        Node s = second.head;

        LL res = new LL();

        while (f.next != null && s.next != null){
            if(f.num < s.num) {
                res.addLast(f.num);
                f = f.next;
            }
            else {
               res.addLast(s.num);
               s = s.next;
            }
        }
        while (f != null){
            res.addLast(f.num);
            f= f.next;
        }
        while (s != null){
            res.addLast(s.num);
            s = s.next;
        }
        return res;
    }
    public static void main(String[] args) {


//        CycleLL list = new CycleLL();
//        System.out.println(list.isHappy(1));




//        Detect whether the LinkedList is a cycle or not
//
//        LL list = new LL();
//        Node temp;
//        list.addLast(1);
//        list.addLast(2);
//        list.addLast(3);
//        list.addLast(4);
//        list.addLast(5);
//        list.addLast(6);
//        temp = list.tail;
//        list.addLast(7);
//        list.addLast(8);
//        list.addLast(9);
//        list.addLast(10);
//
//        list.tail.next = temp;
//        System.out.println("Testing the LL is in  cycle : "+CycleLL.hasCycle(list.head));
//        System.out.println("Length of the cycle : "+CycleLL.lengthOfLLC(list.head));
//
//        Node res = CycleLL.jointNode(list.head);
//        System.out.println(res.num);
//        LL first = new LL();
//        LL second = new LL();
//
//        first.addLast(1);
//        first.addLast(3);
//        first.addLast(5);
//
//        second.addLast(1);
//        second.addLast(2);
//        second.addLast(9);
//        second.addLast(14);
//
//        System.out.println("first LL :");
//        first.display();
//
//        System.out.println("Second LL :");
//        second.display();
//
//        System.out.println("Result LL :");
//        LL res = mergeSortedList(first , second);
//        res.display();

//        LL list = new LL(0);
//     //   list.addFirst(70);
//        list.addFirst(60);
//        list.addFirst(50);
//        list.addFirst(40);
//        list.addFirst(30);
//        list.addFirst(20);
//
////        Node res = list.middleLLfs(list.head);
//        while (res != null){
//            System.out.println(res.num+"->");
//            res = res.next;
//        }

       // list.insertRec(8,5);

       // list.addAtIndex(33,2);

       // list.display();

//        System.out.println(list.deleteLast());
//        list.display();

//        DLL dlist = new DLL();
//        dlist.addFirst(10);
//        dlist.addFirst(20);
//        dlist.addFirst(30);
//        dlist.addFirst(40);
//        dlist.addFirst(50);
//
//        dlist.addAtIndex(5,99);
//        dlist.display();
//
//        System.out.println("Display in the reverse");
//        dlist.displayReverse();


//        LL ll = new LL(0);
//        ll.addFirst(20);
//        ll.addLast(60);
//
//        ll.display();
//
//
//        ll.addAtIndex(30,1);
//
//        ll.display();
//        ll.addAtIndex(40,2);
//        ll.addAtIndex(50,3);
//
//        ll.display();
//
//        System.out.println(ll.deleteFirst());
//        ll.display();
//        System.out.println(ll.deleteLast());
//        ll.display();
    }
}