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
    public boolean isPalindrome(ListNode head) {
        
        
        ListNode slow = head, fast = head;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
//         reversing the second half
        slow = reverse(slow);
        
        while(head!=null && slow!=null){
            
            if(head.val!=slow.val){
                return false;
            }
            
            head = head.next;
            slow = slow.next;
        }
        
        return true;
        }
    
    
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head!=null){
            ListNode nextt = head.next;
            head.next = prev;
            prev = head;
            head = nextt;
        }
        
        return prev;
        
        
    }
}
