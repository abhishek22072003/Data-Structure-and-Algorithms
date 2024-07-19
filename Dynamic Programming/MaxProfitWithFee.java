import java.lang.reflect.Array;
import java.util.Arrays;

public class MaxProfitWithFee {
    static int solve(int i, int buy, int fee, int [] prices, int [][] dp){
        if(i==prices.length)
            return 0;
        if(dp[i][buy]!=-1)
            return dp[i][buy];
        if(buy==1){
            return dp[i][buy]=Math.max(-prices[i] + solve(i+1, 0, fee, prices, dp),
                            0+solve(i+1, 1, fee, prices, dp));
        }
        else{
            return dp[i][buy]=Math.max((prices[i]-fee)+solve(i+1, 1, fee, prices,dp),
                            0+ solve(i+1, 0, fee, prices,dp) );
        }

    }
    public static int maxProfit(int[] prices, int fee) {
        int [][] dp = new int[prices.length][2];
        for(int [] d: dp)
            Arrays.fill(d,-1);
        return solve(0, 1, fee, prices, dp);
    }
    public static void main(String[] args) {
        int [] arr =    {1,3,2,8,4,9};
        System.out.println(maxProfit(arr, 2));
    }
}
