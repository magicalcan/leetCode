/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class CopyRandomList {
    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    };
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        RandomListNode node = head;
        while(node != null){
            RandomListNode newNode = new RandomListNode(node.label);
            newNode.next = node.next;
            node.next = newNode;
            node = node.next.next;
        }
        node = head;
        while(node != null){
            node.next.random = (node.random==null)?null:node.random.next;
            node = node.next.next;
        }
        node = head;
        head = node.next;
        RandomListNode temp;
        while(node != null){
            temp = node.next;
            node.next = node.next.next;
            node = node.next;
            if(node!=null)temp.next = node.next;
            else temp.next = null;
        }
        return head;
    }
}
