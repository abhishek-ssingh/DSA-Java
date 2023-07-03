class Solution {
    public void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;

        for(int i: adj.get(node)){
            if(!vis[i]) dfs(i, vis, adj);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        //no of components
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        //1 based ind
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        } 

        //converting matrix into adj list
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i+1).add(j+1);
                    // adj.get(j).add(i);
                }
            }
        }

        //call dfs to count components
        boolean[] vis = new boolean[n+1];
        int count=0;
        for(int i=1; i<=n; i++){
            if(!vis[i]) {
                dfs(i, vis, adj);
                count++;
            }
        }

        return count;


    }
}
