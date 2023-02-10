import java.util.Arrays;

public class Fibonaacci {
    public static int fiboByTabO(int n, int[] dp){
        //tc -> O(N);
        //sc -> O(1);
      
        int prev = 1, prev2 = 0;
      
        for(int i=2; i<=n;i++){
            dp[i] = prev + prev2;
            prev2 = prev;
            prev = dp[i];
        }
      
        return dp[n];
    }
    public static int fiboByTab(int n, int[] dp){
        //iterative way
        //tc -> O(N)
        //sc -> O(N)
      
        dp[0]=0; dp[1] = 1;

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
      
        return dp[n];

    }

    public static int fiboByMem(int n, int[] dp){
        //tc -> O(N)
        //sc- >O(N)
        if(n<=1) return n;

        if(dp[n]!=-1) return dp[n];  //already visited
        else {
            return dp[n] = fiboByMem(n-1, dp) + fiboByMem(n-2, dp);
        }
    }
  
    public static void main(String[] args) {
        int n = 4;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        //recursive way
        System.out.println(fiboByMem(n, dp));

        //iterative way
        System.out.println(fiboByTab(n, dp));

        //iterative way with optimized space
        System.out.println(fiboByTabO(n,dp));
    }
}
