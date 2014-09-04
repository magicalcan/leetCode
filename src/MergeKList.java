import java.util.List;


public class MergeKList {
	
	class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) {
	         val = x;
	         next = null;
	     }
	}

    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.isEmpty()) return null;
        if (lists.size()==1) return lists.get(0);
        int i = 0;
        int j = lists.size()-1;
        while(i<j){
        	lists.set(i, mergeTwoList(lists.get(i), lists.get(j)));
        	lists.remove(j);
        	i++;
        	j--;
        }
        return mergeKLists(lists); 
    }
    
    public ListNode mergeTwoList(ListNode a, ListNode b){
    	if (a == null && b == null) return null;
    	if (a == null) return b;
    	if (b == null) return a;
    	ListNode h = a.val>=b.val ? b : a;
    	ListNode pre = null;
		ListNode tmp = null;
    	while(a != null && b != null){		
    		if (a.val>=b.val){
    			pre = b;
    			b = b.next;
    			continue;
    		}
    		if (pre != null) pre.next = a;
    		tmp = a.next;
    		a.next = b;
    		pre = a;
    		a = tmp;
    	}
    	if (b == null) pre.next = a;
    	return h;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
