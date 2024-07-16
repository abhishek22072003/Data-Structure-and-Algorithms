import java.util.Arrays;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "aacabdkacaa";
        char [] ch = s.toCharArray();
        int low = 0;
        int high = ch.length-1;
        while(low < high){
            char temp = ch[low];
            ch[low] =  ch[high];
            ch[high] = temp;
            low++;
            high--;
        }
        String s2 = new String(ch);
        int [][] dp = new int[s.length()+1][s.length()+1];
        int max = 0;
        for(int i = 1; i<=s.length(); i++){
            for(int j = 1; j<=s.length(); j++){
                if(s.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+1;
                else
                    dp[i][j] = 0;
                max = Math.max(max, dp[i][j]);
            }                 
        }
        StringBuilder sb = new StringBuilder();
        outer: for(int i = 1; i<=s.length(); i++){
            for(int j = 1; j<=s.length(); j++){
                if(dp[i][j] == max){
                    int f = i;
                    int k = j;
                    while(max>0){
                        sb.append(s.charAt(f-1));
                        f--;
                        k--;
                        max--;
                    }
                    break outer;
                }
            }
        } 
        for(int [] d: dp)
            System.out.println(Arrays.toString(d));
        System.out.println(sb.toString());           
        
    }
}
