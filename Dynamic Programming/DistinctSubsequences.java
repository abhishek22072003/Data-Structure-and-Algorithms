import java.util.Arrays;

public class DistinctSubsequences {
    static int solve(int indx, int indx2, String s, String t, int [][] dp){
        if(indx2==t.length())
            return 1;
        if(indx==s.length())        
            return 0;      
        if(dp[indx][indx2]!=-1)
            return dp[indx][indx2];
        if(s.charAt(indx)==t.charAt(indx2))
            return  dp[indx][indx2] = solve(indx+1, indx2+1, s, t, dp) + solve(indx+1, indx2, s, t, dp);        
        else
            return dp[indx][indx2] = solve(indx+1, indx2, s, t, dp);
             
    }
    static public int numDistinct(String s, String t) {
        int [][] dp = new int[s.length()][t.length()];   
        for(int [] d: dp)
            Arrays.fill(d, -1);     
        int ans = solve(0, 0, s, t, dp);
        return ans;
    }
    public static void main(String[] args) {
        String first = "babgbag";
        String second = "bag";
        System.out.println(numDistinct(first, second));
    }
}
