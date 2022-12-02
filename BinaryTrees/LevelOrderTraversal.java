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
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        
        if(root==null) return wrapList;
        queue.offer(root);  //added root in queue
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>;
            
            for(int i=0; i<levelNum;i++){
                if(queue.peek().left!=null) queue.offer(queue.peek().left);  //adding left
                if(queue.peek().right!=null) queue.offer(queue.peek().right);   //adding right
                subList.add(queue.poll().val);   //putting it all in separate list
            }
            
            wrapList.add(subList);   //then add list to wrapList
        }
        
        return wrapList;
        
    }
}
