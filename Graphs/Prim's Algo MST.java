class Pair {
    int node;
    int wt;
    
    Pair(int node, int wt){
        this.node = node;
        this.wt = wt;
    }
}
// User function Template for Java

class tuple {
    int wt;
    int node;
    int parent;
    
    tuple(int wt, int node, int parent){
        this.wt = wt;
        this.node = node;
        this.parent = parent;
    }
}

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
	    
	    for(int i=0; i<V; i++){
	        adj.add(new ArrayList<Pair>());
	    }
	    
	    for(int i=0; i<edges.length; i++) {
	        int n1 = edges[i][0];
	        int n2 = edges[i][1];
	        int wt = edges[i][2];
	        
	        adj.get(n1).add(new Pair(n2,wt));
	        adj.get(n2).add(new Pair(n1,wt));
	    }
	    
	    int[] vis = new int[V];
	    
	    int sum=0;
	    
	    
	    PriorityQueue<tuple> pq = new PriorityQueue<tuple>((x,y)-> x.wt - y.wt);
	    pq.offer(new tuple(0,0,-1));
	    
	    while(pq.size()!=0) {
	        
	        tuple tp = pq.peek();
	        
	        pq.remove();
	        
	        int wt = tp.wt;
	        int node = tp.node;
	        int parent = tp.parent;
	        
	        if(vis[node]!=1){
	            vis[node]=1;
	            sum+=wt;
	            
	            for(Pair it:adj.get(node)){
	                int adj_n = it.node;
	                int adj_w = it.wt;
	                
	                
	                if(vis[adj_n]!=1) {
	                    pq.add(new tuple(adj_w, adj_n, node));
	                }
	            }
	            
	            
	        }
	        
	    }
	    
	    return sum;
	    
	    
	    
	}
}
