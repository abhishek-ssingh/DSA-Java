class Solution {
    
    
    private void recursion(int index,int[] arr, ArrayList<Integer> ds, List<List<Integer>> res){
//         base case
        res.add(new ArrayList<>(ds));
        
        for(int i = index;i<arr.length;i++){
            if(i!=index && arr[i]==arr[i-1]) continue;
            
            ds.add(arr[i]);
            recursion(i+1,arr,ds,res);
            
            ds.remove(ds.size()-1);
        }

     
    }
    
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        recursion(0,nums, new ArrayList<>(),res);
        
        return res;
    }
}
