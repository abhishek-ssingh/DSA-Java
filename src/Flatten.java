class GfG
{
    Node mergeSort(Node a,Node b){
        
        Node res = new Node(0);
        Node temp = res;
        
        // idea is two pick two list from the end (lists including their child) and merge sort them trough
        //so it can be returned as two sorted list 
        // that is we chose 1 2 3 4. 5.
        // so 4 and 5 become one after merging
        // so the list remain 1 2 3 6.
        //and return it
        while(a!=null && b!=null){
            if(a.data<b.data){
                temp.bottom = a;
                temp = temp.bottom;
                a = a.bottom;
            } else{
                temp.bottom = b;
                temp = temp.bottom;
                b = b.bottom;
            }

            
        }
                    
        if(a!=null) temp.bottom = a;
        else temp.bottom = b;
        return res.bottom;
    
    }
    
    
    Node flatten(Node head)
    {
        //if at last node return
        if(head==null || head.next==null){
            return head;
        }
        
        // recursion and assigning it the value as well
        head.next = flatten(head.next);
        
        // here wee send 4 and 4.next ie. 5 to merge it returns then this process follows for entire node
        head = mergeSort(head,head.next);
	    
	    return head;
    }
    
    
}
