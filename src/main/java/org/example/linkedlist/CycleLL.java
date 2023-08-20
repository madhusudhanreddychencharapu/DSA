package org.example.linkedlist;

public class CycleLL {
    public static boolean hasCycle(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
    public static int lengthOfLLC(Node head){
        Node slow = head;
        Node fast = head;
        int count = 1;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow ){
                slow = slow.next;
                break;
            }
        }
        while(slow != fast) {
            slow = slow.next;
            count++;
        }
        return count;
    }
    public static Node  jointNode(Node head){
        int count = lengthOfLLC(head);
        Node first = head;
        Node second = head;
        while (count>0){
            second = second.next;
            count--;
        }
        while(second != first){
            first = first.next;
            second = second.next;
        }
        return first;
    }

    // Detect the number is  a Happy Number
    public boolean isHappy(int n) {
        int slow = squareSum(n);
        int fast = squareSum(squareSum(n));
        while(slow != fast){
            slow = squareSum(slow);
            System.out.println("slow pointer"+slow);
            fast = squareSum(squareSum(fast));
            System.out.println("Fast pointer"+fast);

            if(slow == 1 || fast == 1){
                return true;
            }
        }
        return false;
    }
    public static int squareSum(int n){
        int sum =0;
        while(n>0){
            int temp = n%10;
            sum = sum + temp*temp;
            n /= 10;
        }
        return sum;
    }

}
