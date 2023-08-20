package org.example.linkedlist;

public class LL {
    public Node head;
    public Node tail;
    private int size;
    private Node temp = head;
    public LL(int size){
        this.size = size;
    }

    public LL() {

    }

    public void addFirst(int num){
        Node node = new Node(num);
       // System.out.println(node);
        if(head == null){
            head = node;
        }
        else{
            node.next = head;
            head = node;
        }
        if(tail == null){
            tail=head;
        }
        size++;
    }

    public void addLast(int num){
        if(tail == null){
            addFirst(num);
        }else{
        Node node = new Node(num);
        tail.next = node;
        tail = node;}
    }

    public void addAtIndex(int num , int index){
        Node node = new Node(num);
        System.out.println("This is the additional node"+node);
        Node tempadd ;
        int i = 1;
        if(index == 0){
            addFirst(num);
        } else if (index == size) {
            addLast(num);
        }
        else {
            Node temp = head ;
            while(i++<index){
                temp=temp.next;
            }
            tempadd = temp.next;
            temp.next = node;
            node.next=tempadd;
        }
    }

    public void addAtIndexRecur(int index,int value ,Node temp){
        Node node = new Node(value);
        if(index == 1){
            node.next = temp.next;
            temp.next = node;
        } else if (index == 0) {
            node.next = head;
            head = node;
        } else{
            temp = temp.next;
            System.out.println("I am printing");
            addAtIndexRecur(index-1,value,temp);

        }
    }
    public Void insertRec(int val, int index){
        head = inserRec(val ,index , head);
        return null;
    }
    private Node inserRec(int val, int index,Node node){
       if(index == 0){
           Node temp = new Node(val,node);
           return temp;
       }
       node.next = inserRec(val,index-1,node.next);
       return node;
    }

    public int deleteAtIndex(int index){
        if(index<=1){
            deleteFirst();
        }
        if(index == size-1){
            deleteLast();
        }
        Node node = getNodeForIndex(index-1);
        int temp = node.next.num;
        node.next=node.next.next;
        return temp;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.num+"->");
            temp = temp.next;
        }
        System.out.println("END");
    }
    public int  deleteFirst(){
        int temp = head.num;
        head = head.next;
        if(head == null){
            tail = null;
        }
        return temp;
    }
    public int deleteLast(){
        if(size <=1){
            deleteFirst();
        }
        Node node = getNodeForIndex(size-1);
        int num = tail.num;
        tail=node;
        tail.next = null;
        return num;

    }
    public Node getNodeForIndex(int index){
        Node temp = head;
        for(int i=0;i<index;i++){
            temp = temp.next;
        }
        return temp;
    }
    // middle of the linked list
    public Node middleLL(Node head){
        Node node = head;
        int count = 0;
        while(node != null){
            node = node.next;
            count++;
        }
        System.out.println("Count :"+count);
        count = (count/2);
        while(count >0){
            head = head.next;
            count --;
        }
        return head;
    }

    //middle of the linked ll using the fast and slow pointer method
    public Node middleLLfs(Node head){
        Node slow = head;
        Node fast = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
        }while (fast != null && fast.next != null);
        return  slow;
    }

}
class Node{
    int num;
    Node next;

    public Node(int num){
        this.num = num;
    }
    public Node (int num,Node next){
        this.num = num;
        this.next=next;
    }

}
