//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends

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





















