import java.util.HashSet;
import java.util.Stack;

public class LinkedL {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> h=new HashSet<>();
        while(head!=null) {
        	if(h.contains(head)) return true;
        	h.add(head);
        	head=head.next;
        }
        return false;
    }
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> s=new Stack<>();
        ListNode temp=head;
        while(temp!=null) {
        	s.push(temp);
        	temp=temp.next;
        }
        while(!s.isEmpty()) {
        	if(head.val!=s.pop().val) return false;
        	head=head.next;
        }
        	
        	return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
