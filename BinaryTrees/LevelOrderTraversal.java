/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        if(root==null) return res;
        
        q.offer(root);
        
        while(!q.isEmpty()){
            List<Integer> wrapList = new ArrayList<>();
            int size = q.size();
            
            for(int i =0; i<size;i++){
                
                //add in wrapList
                
                
                // pop the added one from q            
                // q.poll();
                
                //check if it has some childrens then enqueue them as well
                if(q.peek().left!=null) q.offer(q.peek().left);
                if(q.peek().right!=null) q.offer(q.peek().right);
                
                wrapList.add(q.poll().val);
                
            }
            
            res.add(wrapList);
        }
        
        return res;
    }
}
