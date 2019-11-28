import java.util.HashSet;

public class LinkedLMedium {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	int value=l1.val+l2.val;
    	int remainder=value/10;
    	ListNode l3=new ListNode(value%10);
    	ListNode temp=l3;
        while(l1.next != null || l2.next!=null) {
        	 value=remainder;
        	if(l1.next!=null) {
        		value+=l1.next.val;
        		l1=l1.next;
        	}
        	if(l2.next!=null) {
        		value+=l2.next.val;
        		l2=l2.next;
        	}
        	remainder=value/10;
        	temp.next=new ListNode(value%10);
        	temp=temp.next;
        	
        }
        return l3;
    }
    public ListNode oddEvenList(ListNode head) {
    	 if(head==null || head.next==null || head.next.next==null) return head;
    	ListNode separator=head;
    	int counter=0;
    	while(separator.next!=null) {separator=separator.next;
    	counter++;
    	}
    	System.out.println(counter);
    	ListNode n=head;
    	while(counter>0) {
    	ListNode temp=n.next;
    	n.next=n.next.next;
    	separator.next=temp;
    	temp.next=null;
    	separator=temp;
    	n=n.next;
    	counter-=2;
    	}
    	return head;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
     HashSet<ListNode> hs=new HashSet<>();
     if(headA==null || headB==null) return null;
     while(headA!=null) {
    	 hs.add(headA);
    	 headA=headA.next;
     }
     while(headB!=null) {
    	 if(hs.contains(headB)) return headB;
    	 headB=headB.next;
     }
     return null;
    }
    
	public static void main(String[] args) {
	System.out.println(26/10);

	}
}
