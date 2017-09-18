


// Definition for singly-linked list.
  
 
public class Solution {
	static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
     ListNode finalNode = null;
     ListNode temp = null;
     ListNode prev = null;
     int x = 0;
     int y =0;
     int ans = 0;
     int carry = 0;
     int rem = 0;
     int cnt = 0;
     
     while(l1 != null || l2 != null){
         if(l1 != null )
             x = l1.val;
        else x = 0;
        
         if(l2 != null )
             y = l2.val;
        else y = 0;
        
        ans = carry + x +y; 
        
        rem = ans % 10;
        
        carry = ans / 10;
        
        temp = new ListNode(rem);
        
        if(finalNode == null){
            finalNode = temp;
        }
        else{
            prev.next = temp;
            //finalNode.next.next = null;
        }
        prev = temp;
        
        if (l1 != null) {
        	l1 = l1.next;
        }
        if (l2 != null) {
        	l2 = l2.next;
        }
        
     }
       
        return finalNode;
    }
     void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println("");
    }
    public static void main(String[] args){
        Solution s = new Solution();
        
        
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(9);
        s.printList(l1);
        
        ListNode l2 = new ListNode(10);
        l2.next = new ListNode(10);
        l2.next.next = new ListNode(2);
        s.printList(l2);
        
        ListNode ls = s.addTwoNumbers(l1, l2);
        s.printList(ls);
        
        
        
    }
}