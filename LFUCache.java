package ladder8;

import java.util.ArrayList;
import java.util.HashMap;

public class LFUCache {
	   
    private class Node{
        int value;
        ArrayList<item> items;
        Node prev;
        Node next;
        public Node (int value ){
            this.value = value;
            this.items = new ArrayList<item> ();
            this.prev = null;
            this.next = null;
        }
    }
    private class item{
        int key;
        int value;
        Node parent ;
        public item(int key ,int value, Node parent){
             this.key = key ;
             this.value = value;
             this.parent  = parent;
        }
    }
     private HashMap<Integer, item> map;
    private  Node head,tail;
    private  int capacity;
    // @param capacity, an integer
    public LFUCache(int capacity) {
        // Write your code here
        this.capacity = capacity;
        this.map = new HashMap <Integer,item> ();
        this.head = new Node (0);
        this.tail = new Node(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
        
        
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // Write your code here
      if (map.containsKey(key)) {
          //get(key);
          map.get(key).value = value;
          return ;
      }
      if (map.size() == capacity ){
          getLFUitem();
      }
      
      Node newpar = head.next;
      if ( newpar.value != 1){
          newpar = getNewNode(1,head,newpar);
      }
        item curitem = new item(key,value,newpar);
        map.put(key,curitem);
        newpar.items.add(curitem);
        return;  
    }

    public int get(int key) {
        // Write your code here
        if (!map.containsKey(key)){
            return -1;
        }
        item cur = map.get(key);
        Node curpar = cur.parent;
        if (curpar.next.value == curpar.value + 1){
            cur.parent= curpar.next;
            cur.parent.items.add(cur);
        }else{
            Node newpar =getNewNode(curpar.value + 1,curpar,curpar.next);
            cur.parent = newpar;
            newpar.items.add(cur);
        }
         curpar.items.remove(cur);
         if(curpar.items.isEmpty()){
             deleteNode(curpar);
         }
        return cur.value;
    }
    private Node getNewNode (int value ,Node prev , Node next){
        Node temp = new Node(value);
        temp.prev = prev;
        temp.next = next;
        prev.next = temp;
        next.prev = temp;
        return temp;
    }
    private void deleteNode(Node temp){
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        return ;
    }
    private void getLFUitem(){
        Node temp = head.next;
         item LFUitem = temp.items.get(0);
        temp.items.remove(0);
        map.remove(LFUitem.key);
        if (temp.items.isEmpty()){
            deleteNode(temp);
        }
        return;
    }

    public static void main(String[] args) {
    	LFUCache test = new LFUCache(3);
    	test.set(14,4);
    	test.set(14,8);
    	test.set(83,63);
    	test.set(5,2);
    	
    	System.out.println(test.get(5));
    	test.set(4,23);
    	System.out.println(test.get(5));
    	test.set(9,6);
    	System.out.println(test.get(14));
    	System.out.print(Math.pow(2.0, 3.0));
    	//Stack <Integer> a = new  Stack<Integer> ();
    	//a.push(1);
    	//set(14,7),set(14,8),set(83,63),set(5,239),get(5),set(42,137),get(5),set(96,135),get(14)
    }
    
}
