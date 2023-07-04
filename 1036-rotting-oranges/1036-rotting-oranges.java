class Pair{
    int row;
    int col;

    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count_fresh=0;

        Queue<Pair> q = new LinkedList<>();     
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j));
                } else if (grid[i][j]==1) 
                    count_fresh++;
            }
        }
        if(count_fresh==0) return 0;

        int count=0;
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0; i<len; i++){
                Pair p = q.poll();
                int r = p.row;
                int c = p.col;
                

                for(int j=0; j<4; j++){
                    int nr = r + drow[j];
                    int nc = c + dcol[j];

                    //the check
                    if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1){
                        q.offer(new Pair(nr,nc));
                        grid[nr][nc] = 2;
                        count_fresh--;
                        
                    }
                }
            }
            count++;
        }

        return count_fresh ==0 ? count-1 : -1;
    }
}