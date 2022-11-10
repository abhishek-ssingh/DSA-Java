/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        
       
        if(head==null || head.next==null) return head; 
        ListNode odd = head, even = head.next, evenNewNodeList = even;
        
//         we can move odd and connect it to even's next , so two odd connect
//         then we can connect even with next even by moving next.next
        
        
        while(even!=null && even.next!=null){
            
            odd.next = even.next; //now 1 connected to 2's next that is 3   1 - 3
            even.next = even.next.next;       // 2 - 4
            odd = odd.next;
            even = even.next;
        }
        
//         after this just connect odd to evenNewNodeList ehich was carrying all the even elements 
        
        odd.next = evenNewNodeList;
        
        
        return head;
    }
}
        
