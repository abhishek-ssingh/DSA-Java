/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        
//         this is the first approach

//         we calc length of both l1 and l2
        // then we subtract the diff from the longest of l1 and l2
        // and we take 2 dummy nodes and subtract the diff from the longest length
        // and we achieve that by moving the diff times like 5 - 7 = 2, so we move dummy on 7 linkedlist length, by diff times that is 2 times
        
        
//         ListNode dummy1 = headA,dummy2 = headB, cur1 = headA,cur2 = headB;
        
        
//         int len1 = 0, len2 = 0,diff;
        
// //         calculating the length
//         while (cur1!=null){
//             cur1 = cur1.next;
//             len1++;
//         } 
//         while (cur2!=null){
//             cur2 = cur2.next;
//             len2++;
//         }
//         diff = Math.abs(len1-len2);
        
// //         moving diff on longer
//         if(len1>len2){
//             for (int i=0;i<diff;i++) dummy1 = dummy1.next;
//         } 
//         else if (len2>len1) {
//             for(int i =0;i<diff;i++) dummy2 = dummy2.next;
//         }
        
        
//         while (dummy1!=null && dummy2!=null){
            
//             if(dummy1==dummy2) return dummy1;
//             dummy1 = dummy1.next;
//             dummy2 = dummy2.next;
//         }
        
        
//         return null;
        
        
        
        
        
        //second approach
    }
}
