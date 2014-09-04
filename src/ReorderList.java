public class ReorderList {

	public static void reorderList(ListNode head) {
        if(head == null) return;
        int size = countNode(head);
        int i = 1;
        ListNode cur = head;
        while(i < size/2){
            cur = cur.next;
            i++;
        }
        merge(head, reverse(cur.next));
    }
    
    public static int countNode(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
    
    public static ListNode reverse(ListNode h){
        ListNode p = null;
        ListNode t = h;
        while(h != null){
            t = h.next;
            h.next = p;
            p = h;
            h = t;
        }
        printList(p);
        return p;
    }
    
    public static ListNode merge(ListNode f, ListNode s){
        ListNode h = f;
        while(f != null && s != null){
            ListNode t = s.next;
            s.next = f.next;
            f.next = s;
            f = s.next;
            s = t;
        }
        if (f != null) f.next = null;
        return h;
    }
    
    public static void printList(ListNode n){
    	while(n != null){
			System.out.print(n.val+" ");
			n=n.next;
		}
    	System.out.println();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n = new ListNode(1);
		ListNode h = n;
		for(int i = 2; i<=4; i++){
			n.next = new ListNode(i);
			n = n.next;
		}
		reorderList(h);
		n=h;
		printList(n);
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
