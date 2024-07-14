public class MinCost {
    static int solve(int i, int j, int m, int n, int [] horizontalCut, int [] verticalCut, int [][] dp){
        if(i>=m && j>=n){
            return 0;
        }
        if(dp[i][j]!=-1)
            return dp[i][j];
        int horizontal = Integer.MAX_VALUE;
        int vertical = Integer.MAX_VALUE;
        if(i < m)
             horizontal = ((j+1)*horizontalCut[i]) + solve(i+1, j, m, n, horizontalCut, verticalCut, dp);
        if(j < n)
             vertical = (i+1)*verticalCut[j] + solve(i, j+1, m, n, horizontalCut, verticalCut, dp);
        return dp[i][j]= Math.min(horizontal, vertical);
    }
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        System.out.println(solve(0, 0, m, n, horizontalCut, verticalCut));
    }
}
