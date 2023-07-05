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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution
{   
    
    private void dfs(int r, int c, int newColor, int orgColor, boolean[][] vis, int[][] image){
        vis[r][c] = true;
        image[r][c] = newColor;
        
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        
        for(int i=0; i<4; i++){
            int nr = r + drow[i];
            int nc = c + dcol[i];
            
            if(nr>=0 && nr<image.length && nc>=0 && nc<image[0].length && !vis[nr][nc] && image[nr][nc]==orgColor){
                dfs(nr,nc, newColor, orgColor, vis, image);
            }
        }
        
    }
    
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here
        int m = image.length;
        int n = image[0].length;
        
        //take a vis
        boolean[][] vis  = new boolean[m][n];
        
        //call dfs only 1 connected component
        dfs(sr,sc, newColor, image[sr][sc], vis, image);
        
        return image;
        
    }
}