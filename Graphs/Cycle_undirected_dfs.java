class Solution {
    public boolean dfs(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        
        for(int it: adj.get(node)){
            //not vis
            if(!vis[it]) {
                if(dfs(it, node, vis, adj)==true) return true;
            } else {
                if(it!=parent && parent!=-1) return true; 
            }
        }
        return false;
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        boolean[] vis = new boolean[V];
        //multiple components
        
        for(int i=0; i<V; i++){
            if(!vis[i]){
                if(dfs(i, -1, vis, adj)==true) return true;
            }
        }
        
        return false;
    }
}
