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
