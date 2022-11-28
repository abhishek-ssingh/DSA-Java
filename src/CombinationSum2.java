class Solution {
    
    private void recursion(int index, int target, int[] arr, 
                          ArrayList<Integer> ds, List<List<Integer>> res)     { 
        
        
//         do this again
        if (target==0) {
            res.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i = index; i<arr.length;i++){
            if(i>index && arr[i]==arr[i-1]) continue;
            if(arr[i]>target) break;
            
            ds.add(arr[i]);
            recursion(i+1,target-arr[i],arr,ds,res);
            ds.remove(ds.size()-1);
        }
        
    }
    
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        recursion(0,target,candidates,new ArrayList<>(),res);
        
        return res;
        
    }
}
