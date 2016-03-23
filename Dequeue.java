package ladder8;

import java.util.Stack;

public class Dequeue {
	private Node head, tail;
    public Dequeue() {
        // do initialize if necessary
        head = tail = null;
    }

    public void push_front(int item) {
        // Write your code here
        if (head  == null){
            head = new Node(item);
            tail = head;
        }else{
            Node temp = head;
            head = new Node(item);
            head.next = temp;
            temp .prev = head;
        }
    }

    public void push_back(int item) {
        // Write your code here
          // Write your code here
        if (head  == null){
            head = new Node(item);
            tail = head;
        }else{
            Node temp =  new Node(item);
            tail.next = temp;
            temp .prev = tail;
            tail = temp;
        }
    }

    public int pop_front() {
        // Write your code here
        if (head == null){
            return Integer.MIN_VALUE;
        }else{
            Node temp = head;
            head = head.next;
            if(head != null){
            head.prev = null;
            }else{
            	tail = null;
            }
            return temp.val;
        }
    }

    public int pop_back() {
        // Write your code here
        if (tail == null){
            return Integer.MIN_VALUE;
        }
        Node temp = tail;
        tail = tail.prev;
        if(tail != null){
        tail.next = null;}
        else{
        	head = null;
        }
        return temp.val;
    }
    public static void main(String[] args) {
    	Dequeue test = new Dequeue();
    	test.push_front(1);
    	test.push_back(2);
    	System.out.println(test.pop_back());
    	System.out.println(test.pop_back());
    	test.push_back(3);
    	test.push_back(4);
    	System.out.print(test.pop_front());
    	System.out.print(test.pop_front());
    	
    	
    }
}
class Node {
    public int val ;
    public Node next;
    public Node prev;
    public Node(int value){
        this.val = value;
        this.prev = this.next = null;
    }
    
}
