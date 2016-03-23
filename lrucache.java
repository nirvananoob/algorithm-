package ladder8;

import java.util.HashMap;

public class lrucache {
	//for java lru can be built by using linked-hashmap structure
	    // @param capacity, an integer
	    private int capacity ;
	    private class Node {
	     private   int key;
	        int value;
	      private  Node prev;
	      private  Node next;
	        private Node(int key , int value) {
	            this.prev = null;
	            this.next = null;
	            this.key = key;
	            this.value = value;
	        }
	    }
	     private HashMap<Integer,Node> map;
	     private Node head,tail;
	    public lrucache(int capacity) {
	        // write your code here
	      map =  new HashMap<Integer,Node> ();
	        head = new Node(-1,-1);
	        tail = new Node(-1,-1);
	        head.next = tail;
	        tail.prev = head;
	      this.capacity = capacity;
	        
	    }

	    // @return an integer
	    public int get(int key) {
	        // write your code here
	        if (!map.containsKey(key)) {
	            return -1;
	        }
	        Node temp = map.get(key);
	        temp.prev.next = temp.next;
	        temp.next.prev = temp.prev;
	        moveTail(temp);
	        return temp.value;
	    }

	    // @param key, an integer
	    // @param value, an integer
	    // @return nothing
	    public void set(int key, int value) {
	        // write your code here
	        if (this.get(key) != -1) {
	            map.get(key).value = value;
	            //moveTail(map.get(key));
	            return;
	        } 
	        if (map.size() == capacity) {
	            Node temp = head.next;
	            head.next = temp.next;
	            temp.next.prev = head;
	            map.remove(temp.key);
	        }
	        Node cur = new Node(key,value);
	        map.put(key,cur);
	        moveTail(cur);
	        return;
	    }
	    private void moveTail(Node temp){
	        
	        tail.prev.next = temp;
	        temp.prev = tail.prev;
	        temp.next = tail;
	        tail.prev = temp;
	        return ;
	    }
	    public static void main(String[] args) {
	    	lrucache test  = new lrucache(10);
	    	test.set(1,2);
	    	System.out.print(test.get(1));
	    }
	}