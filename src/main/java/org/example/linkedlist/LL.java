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

    /*
    * Here we are mainly checking the two conditions whether the
    * 1.Linked list is Empty
    *   if empty then our newly adding node is the first node.
    * 2.Linked list has already some nodes
    *   already nodes exist means we should add the new node
    *   and change the  head to the new node.
    * */
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
    /*
    * Here also we are checking two conditions
    * 1.Linked list is empty
    *   if it is empty then add head,tail to node and increment size
    * 2.Already some nodes exist in the Linked list
    *   Then if tail pointer is not given we have to traverse until
    *   node.next != null then add the node change the tail if given
    *   and then increment the size
    * */
    public void addLast(int num){
        if(tail == null){
            addFirst(num);
        }else{
        Node node = new Node(num);
        tail.next = node;
        tail = node;
        size++;
        }
    }

    /*
    * Here we are checking the for first index or last index if not we check for
    *   Traverse up to the index and store the next node address and then add
    *   the newly created node at particular index  then add the
    *   node.next = the one address we have already stored
    * */
    public void addAtIndex(int num , int index){
        Node node = new Node(num);
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
            size++;
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

    /*
    * Here first we have to traverse the temp to index-1 of LL then
    * 1.store the deleting node value into some variable return after
    *   deleting it.
    * 2.temp.next = temp.next.next;
    * */
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
        System.out.println("The size of the linkedlist is : "+size);
        Node temp = head;
        while(temp != null){
            System.out.print(temp.num+"->");
            temp = temp.next;
        }
        System.out.println("END");
    }
    /*
    * Here we are deleting the first node means head always points to the first
    * node hence head = head.next before that we have store that number and return it.
    *
    * If Linked list having the only one node then if we delete it then head and tail
    * both pointing to the null.
    * */
    public int  deleteFirst(){
        int temp = head.num;
        head = head.next;
        if(head == null){
            tail = null;
        }
        return temp;
    }
    /*
    * Here we are traversing the LL because we don't know the previous node values
    * the traversal continuous up to the size-1 index
    * Then the update the tail value with the temp.next and temp.next == null;
    * */
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

    /*
    * Here we are doing simple traversing the ll up to the index and
    * returning the node.
    * we can use while alternatively like these
    *
    * int i = 0;
    * while(i++ < index){
    *   temp = temp.next;
    * }
    * return temp;
    * */
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
