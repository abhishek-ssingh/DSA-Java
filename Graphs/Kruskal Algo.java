class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for(int i=0; i<= n; i++) {
            //i<=n for 1 based indexing
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node){
        //base class
        if(node==parent.get(node)) return node;

        int ulp = findUPar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }



    public void unionByRank(int u, int v){

        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u==ulp_v) return;

        if(rank.get(ulp_u) == rank.get(ulp_v)) {
            parent.set(ulp_u,ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v,ulp_u);
        } else {
            parent.set(ulp_v,ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u,rankU+1);
        }
    }

    public void unionBySize(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u == ulp_v) return;

        if(size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u,ulp_v);
        } else {
            parent.set(ulp_v,ulp_u);
        }
    }
}


class tuple {
    int wt; int src;int dst;
    tuple(int wt, int src, int dst){
        this.wt = wt; this.src = src; this.dst = dst;
    }
}
class Pair {
    int node;
    int wt;
    
    Pair(int node, int wt){
        this.node = node; this.wt = wt;
    }
}

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here.
	    
	    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
	    
	    for(int i=0; i<V; i++){
	        adj.add(new ArrayList<Pair>());
	    }
	    
	    for(int i=0; i<edges.length; i++){
	        int n1 = edges[i][0];
	        int n2 = edges[i][1];
	        int wt = edges[i][2];
	        
	        adj.get(n1).add(new Pair(n2,wt));
	        adj.get(n2).add(new Pair(n1,wt));
	        
	    }
	    
	    
	    
	    PriorityQueue<tuple> pq = new PriorityQueue<tuple>((x,y) -> x.wt - y.wt);
	    
	    for(int i=0; i<V; i++){
	        for(Pair it: adj.get(i)){
	            pq.offer(new tuple(it.wt, i, it.node));
	        }
	    }
	    
	    
	    DisjointSet ds = new DisjointSet(V);
	    
	    int mstWt = 0;
	    
	    while(pq.size()!=0) {
	        
	        tuple it = pq.peek();
	        int wt = it.wt;
	        int n1 = it.src;
	        int n2 = it.dst;
	        pq.remove();
	        
	        if(ds.findUPar(n1) != ds.findUPar(n2)){
	            mstWt += wt;
	            ds.unionBySize(n1,n2);
	        }
	    }
	    
	    return mstWt;
	    
	}
}
