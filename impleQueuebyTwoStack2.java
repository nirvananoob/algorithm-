package ladder8;

public class impleQueuebyTwoStack2 {
	
	    private Node  head, tail;
	    public impleQueuebyTwoStack2() {
	        // do initialize if necessary
	        //sentinel = null;
	        head = null;
	        tail = null;
	    }

	    public void push_front(int item) {
	        // Write your code here
	        if (head == null){
	            head = new Node(item);
	            tail = head;
	            
	        }
	        else{
	            Node temp = head;
	            head = new Node(item);
	           head.next = temp;
	        }
	    }

	    public void push_back(int item) {
	        // Write your code here
	         if (head == null){
	            head = new Node(item);
	            tail = head;
	            
	        }else{
	            tail.next = new Node(item);
	            tail = tail.next;
	        }
	    }

	    public int pop_front() {
	        // Write your code here
	        if (head == null){
	            return Integer.MAX_VALUE;
	        }else{
	            Node temp = head;
	            head = head.next;
	            return temp.val;
	        }
	    }

	    public int pop_back() {
	        // Write your code here
	        if (tail == null){
	            return Integer.MIN_VALUE;
	        }else if(tail == head){
	            int temp = tail.val;
	            head = null;
	            tail = null;
	            return temp;
	        }
	        else{
	            Node temp = head;
	            while(temp.next != tail){
	                temp = temp .next;
	            }
	          
	           int res = tail.val;
	            temp .next = null;
	           tail = temp; 
	           return res;
	        }
	    }
	
}
	 class Node{
	    public int val ;
	   public Node next;
	   public Node(int value){
	       this.val = value;
	       this.next = null;
	       
	   }}
