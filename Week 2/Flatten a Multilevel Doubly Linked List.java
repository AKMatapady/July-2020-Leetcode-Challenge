/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    
    public Node recur(Node head)
    {
        Node next = head.next;        
        if(head.child != null)
        {
            Node child = head.child;
            head.child = null;
            head.next = child;
            child.prev = head;
            //System.out.println("trying to flatten (child) " + child.val);
            head = recur(child);
        }
        if(next != null)
        {
            next.prev = head;
            head.next = next;
            //System.out.println("trying to flatten (next) " + next.val);
            head = recur(next);
        }
        //System.out.println("returning " + head.val);
        return head;
    }
    
    public Node flatten(Node head) {
        if(head == null)
            return head;
        Node last = recur(head);
        //System.out.println("got " + last.val + ", for head " + head.val);
        return head;
    }
}