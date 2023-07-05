class Pair{
    int node;
    int par;
    
    Pair(int node, int par){
        this.node = node;
        this.par = par;
    }
}

class Solution {
    private boolean bfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        Queue<Pair> q = new LinkedList<>();
        
        q.offer(new Pair(node, -1));
        vis[node] = true;
        
        //while q ain't emptu
        while(!q.isEmpty()){
            Pair p = q.poll();
            int curNode = p.node;
            int par = p.par;
            
            for(int it: adj.get(curNode)){
                //not vis
                if(!vis[it]) {
                    q.offer(new Pair(it, curNode));
                    vis[it] = true;
                } else {
                    if(par!=it && par!=-1) return true;
                }
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
                if(bfs(i,vis, adj)==true) return true;
            }
        }
        
        return false;
    }
}
