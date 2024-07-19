import java.util.*;
class Solution {
    int solve(int i, int buy, int cap, int [] prices, int [][][] dp){
        if(i==prices.length) return 0;
        if(cap==0) return 0;
        if(dp[i][buy][cap]!=-1)
            return dp[i][buy][cap];
        if(buy==1){
            return dp[i][buy][cap] = Math.max(-prices[i] + solve(i+1, 0, cap, prices,dp), 
                            0+solve(i+1, 1, cap, prices,dp));
        }else{
            return dp[i][buy][cap] = Math.max(prices[i] + solve(i+1, 1, cap-1, prices,dp), 
                            0+solve(i+1, 0, cap, prices,dp));
        }
    }
    public int BuyAndSellFour(int k, int[] prices) {
        int [][][] dp = new int[prices.length][2][k+1];
        for(int [][] dd: dp)
            for(int [] d: dd)
                Arrays.fill(d, -1);
        return solve(0, 1, k, prices, dp);
    }
}