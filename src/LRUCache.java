import java.util.HashMap;

public class LRUCache {

	int capacity = 0;
	int count = 0;
	Node head;
	Node end;
	HashMap<Integer, Node> map = new HashMap<Integer, Node>();

	class Node {
		int val;
		int key;
		Node prev = null;
		Node next = null;

		public Node(int k, int v) {
			this.key = k;
			this.val = v;
		}
	}

	public LRUCache(int c) {
		this.capacity = c;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node n = map.get(key);
			delete(n);
			push(n);
			return n.val;
		} else
			return -1;
	}

	public void set(int key, int value) {
		if (!map.containsKey(key)) {
			Node n = new Node(key, value);
			if (this.count == this.capacity) {
				map.remove(head.key);
				delete(head);				
			} else {
				count++;
			}
			push(n);
			map.put(key, n);
		} else {
			Node n = map.get(key);
			n.val = value;
			delete(n);
			push(n);
		}
	}

	public void push(Node n) {
		if (this.head == null && end == null) {
			head = n;
			end = n;
			return;
		}
		this.end.next = n;
		n.next = null;
		n.prev = this.end;
		this.end = n;
	}

	public void delete(Node n) {
		if (n == null)
			return;
		if (n == end && n == head) {
			end = head = null;
		} else if (n == head) {
			n.next.prev = null;
			head = n.next;
		} else if (n == end) {
			n.prev.next = null;
			end = n.prev;
		} else {
			n.prev.next = n.next;
			n.next.prev = n.prev;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache test = new LRUCache(1);
		test.set(2, 1);
		test.get(2);
		test.set(3, 2);
		test.get(2);
		test.get(3);
	}

}
