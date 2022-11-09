class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        
        
        int start = 0;
        int end = nums.length-1;
        int res=-1;
        
        
//     searching for the first occurence by going left
        while (start<=end){
            int mid = (start+end)/2;
            
            if(nums[mid]==target) {
//                 go left to find first one
                res = mid;
                end = mid-1;
            } else if (target > nums[mid]) start = mid+1;
            else end = mid-1;
        }
        
        
        if(res==-1){
            return new int[]{-1,-1};
        }
        
//         search for the last
        start = 0;
        end = nums.length-1;
        int last = -1;
        while (start<=end){
            int mid = (start+end)/2;
            
            if(nums[mid]==target){
//                 go right to find last one
                last = mid;
                start = mid+1;
            } else if (target>nums[mid]) start = mid+1;
            else end = mid-1;
        }
        
        
        return new int[]{res,last};
    }
}
