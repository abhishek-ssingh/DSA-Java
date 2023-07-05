class Triple{
    int row;
    int col;
    int dist;
    
    Triple(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        
        
        //logic is we know 1 pos will be 0 so lets put all 1 in q, find its 
        //neigh 0s and put the dist as +1 and push to q
        //now this will fill all the neighb 0 with 1 but what about the 0 that 
        //are not connected as neigh, well the 0s with updated dist will look for 
        //neighbour 0s and put their dist+1 and the same will continue till
        //we exhaust every available 0
        
        Queue<Triple> q = new LinkedList<>();
        
        int m = grid.length;
        int n = grid[0].length;
        
        //result matrix
        int[][] distMatrix = new int[m][n];
        for(int[] i: distMatrix){
            Arrays.fill(i,-1);
        }
        
        //push all 1 to q
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1) {
                    q.offer(new Triple(i,j,0));
                    distMatrix[i][j]=0;
                }
            }
        }
        
        // for(int[] i: distMatrix){
        //     System.out.println(i);
        // }
        
        //no 1 found
        if(q.size()==0) return grid;
        
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        
        //calculate new dist
        while(!q.isEmpty()){
            Triple t = q.poll();
            int row = t.row;
            int col = t.col;
            int dist = t.dist;
            
            
            for(int i=0; i<4; i++){
                int nr = row + drow[i];
                int nc = col + dcol[i];
                
                if(nr>=0 && nr<m && nc>=0 && nc<n && distMatrix[nr][nc]==-1 && grid[nr][nc]==0){
                    //push to q with dist + 1
                    q.offer(new Triple(nr,nc,dist+1));
                    
                    //mark it as dist in new distMatrix
                    distMatrix[nr][nc]=dist+1;
                }
            }
            
        }
        
        return distMatrix;
    }
}
