package ladder8;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class impleStackbyTwoQueue {
	private Queue<Integer> queue1;
	private Queue<Integer> queue2;

	public impleStackbyTwoQueue() {
		queue1 = new LinkedList<Integer>();
		queue2 = new LinkedList<Integer>();

	}

	// Push a new item into the stack
	public void push(int x) {
		// Write your code here
		queue1.offer(x);
		return;
	}

	public void copy(Queue<Integer> queue1, Queue<Integer> queue2) {
		if (queue1.size() <= 1) {
			return;
		}
		while (queue1.size() != 1) {
			queue2.offer(queue1.poll());
		}
		return;
	}

	public void swap() {
		Queue<Integer> temp = this.queue1;
		this.queue1 = queue2;
		this.queue2 = temp;
		return;
	}

	// Pop the top of the stack
	public void pop() {
		// Write your code here
		copy(queue1, queue2);
		queue1.poll();
		swap();
	}

	// Return the top of the stack
	public int top() {
		// Write your code here
		copy(queue1, queue2);
		int temp = queue1.poll();
		swap();
		queue1.offer(temp);
		return temp;
	}

	// Check the stack is empty or not.
	public boolean isEmpty() {
		// Write your code here
		return queue1.size() == 0;
	}
	public static void main(String[] args){
		impleStackbyTwoQueue test = new impleStackbyTwoQueue();
		test.push(1);
		test.push(2);
		test.pop();
		System.out.println(test.top());
		 LinkedList<Integer> list = new LinkedList<Integer>();
		 list.add (1);
		 HashMap<Integer,Integer> map = new  HashMap<Integer,Integer>();
		 map.put(1,1);
		 map.put(2, 2);
		 System.out.println(map.size());
		 
		// list.add(2);
		//list.get()
		 //list.remove(list.size()- 1);
		 //list.poll();
			System.out.print( list.get(0));
			
	}

}
