import java.util.Arrays;

public class MaxProfitCooldown {
    static int solve(int i, int buy, int [] prices, int [][] dp){
        if(i>=prices.length) return 0;
        if(dp[i][buy]!=-1)
            return dp[i][buy];
        if(buy==1){
            return dp[i][buy] = Math.max(-prices[i] + solve(i+1, 0, prices, dp), 0+ solve(i+1, 1, prices,dp));
        }
        else{
            return dp[i][buy] = Math.max(prices[i] + solve(i+2, 1, prices,dp), 0+solve(i+1, 0, prices, dp));
        }
    }
    public static int maxProfit(int[] prices) {
        int [][] dp = new int[prices.length][2];
        for(int [] d: dp)
            Arrays.fill(d, -1);
        return solve(0, 1, prices, dp);
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,0,2};
        System.out.println(maxProfit(arr));
    }
}
