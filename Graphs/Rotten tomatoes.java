class Pair{
    int row;
    int col;
    int t;
    
    Pair(int row,int col,int t){
        this.row = row; this.col=col; this.t = t; 
    }
}

class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        //n row m col
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<Pair> q = new LinkedList<>();
        int cntFresh=0;

        //copying into vis matrix
        int[][] vis = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j =0; j<m;j++){
                
                //if 2 rotten
                if(grid[i][j]==2) {
                    //adding all starting nodes to q
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }
                else if(grid[i][j]==1) {
                    vis[i][j]=1;
                    cntFresh++;
                }
                else vis[i][j]=0;
            }
        }
        
        int min_time=0;
        int cntRot=0;
        
        // North East South West
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};
        
        //running bfs and emptying q
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().t;
            min_time = Math.max(t,min_time);
            //removing
            q.remove();
            //checking all 4 directions
            for(int i=0; i<4; i++){
                int nrow = r+drow[i];
                int ncol = c+dcol[i];
                //if
                    //nrow is within 0 to n
                    //ncol is within 0 to m
                    //vis[nrow][ncol]==1 that means we are at a fresh orange so it will get rotten
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==1){
                    
                    //add to queue cos got rotten
                    //increase time by 1sec coz its near the 4 adj sides and that only takes 1 sec
                    q.add(new Pair(nrow,ncol,t+1));
                    vis[nrow][ncol]=2;
                    cntRot++;
                }
            }
        }
        //if count of fresh and rotten aren't equal that means there remains someone who can't be reached
        if(cntFresh!=cntRot) return -1;
        return min_time;
    }
}
