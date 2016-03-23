package ladder8;

public class rehash {
	 public ListNode[] rehashing(ListNode[] hashTable) {
	        // write your code here
	        if (hashTable == null || hashTable.length == 0){
	            return null;
	        }
	        int oldcap = hashTable.length;
	        int newcap = 2 * oldcap;
	        ListNode[] rehashing = new ListNode[newcap];
	        for(int i = 0 ; i < oldcap ; i++) {
	            if (hashTable[i] == null){
	                continue;
	            }
	            ListNode temp = hashTable[i];
	            while (temp != null){
	                int newhash = hashcode (temp.val ,newcap);
	                put(newhash,temp,rehashing);
	                temp = temp.next;
	            }
	        }
	        return rehashing;
	    }
	    private int hashcode(int key , int capacity){
	        return  (key%capacity + capacity) % capacity;
	    }
	    private void put(int key , ListNode node,ListNode[] rehashing) {
	        if (rehashing[key] == null){
	            rehashing[key] = node ;
	        }else{
	            ListNode temp = rehashing[key];
	            while(temp.next != null){
	                temp = temp.next;
	            }
	            temp.next = node;
	        }
	    }
	  
}
class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
