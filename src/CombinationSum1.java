class Solution {
     public void recursion(int index, int[] arr, int target,
                                         ArrayList<Integer> ds, List<List<Integer>> res){
        
        
        
//         base case
        if(index==arr.length){
            if(target==0){
                res.add(new ArrayList<>(ds));
            }
            return;
        }
         
        if(arr[index]<=target){
//             pick kar liya
            ds.add(arr[index]);
            recursion(index,arr,target-arr[index],ds,res);
            
//             not pick se pehle remove karo
            ds.remove(ds.size()-1);
        } 
         
        recursion(index+1,arr,target,ds,res); 
        
        
        
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res= new ArrayList<>();
        recursion(0,candidates,target, new ArrayList<>(),res);
        
        return res;
        
    }
    
   
}
