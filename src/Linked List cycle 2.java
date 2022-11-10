// slow and fast pointers meet at some point ,
// now lets say l1 dist is from starting to the cycle start, l2 is that of the after cycle point,


// that means where slow and fast will collide, slow would have taken (l1 + l2) dist


//however fast moves by 2 times so there is always a possiblity that it will collide with slow after taking dsome turns , lets say turn = n, c = length of the whole cycle

// now we also know that fast is also on same path, so

// so fast = l1+l2
///....also don't forget the turns fast has to make in oder to catch slow n*c

// fast = l1 + l2 + nc

// now we can definitely say that dist cover by slow would by 2 twice of fast one

// 2slow = fast
// 2(l1+l2) = l1+l2 + nc
// l1+l2 = nc
// l1 = nc- l2


// now we know that c was the whole length of cycle and l2 was where both met , and it is equating to l1,
// so take a entry pointer at start and run l1 times or do one thing

// *take entry run by one and slow by one also, when they will meet is the starting point of the cycle *

public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        ListNode slow =head , fast = head,entry = head;
        if(head==null) return null;
        
        while (slow.next!=null && fast!=null && fast.next!=null){
            
            slow = slow.next;
            fast = fast.next.next;
            
            
            if(slow!=null && fast!=null && slow==fast){
                
                while(entry!=slow){
                    slow = slow.next;
                    entry = entry.next;
                }
                
                return entry;
            }
            
        }
        return null;
        
    }
}
