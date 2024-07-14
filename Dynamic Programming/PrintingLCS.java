import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
public class PrintingLCS{    
    public  static List<String> all_longest_common_subsequences(String s, String t) {
        int [][] dp = new int[s.length()+1][t.length()+1];
        for(int i = 1; i<=s.length(); i++)
            for(int j = 1; j<=t.length(); j++)
                if(s.charAt(i-1)==t.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        int max = dp[s.length()][t.length()];      
        HashSet<String> ans = new HashSet<>();
        for(int [] d: dp)
            System.out.println(Arrays.toString(d));
        for(int i = 1; i<=s.length(); i++){
            for(int j = 1; j<=t.length(); j++){          
                if(dp[i][j]==max){
                    int first = i;
                    int second = j;
                    char [] ch = new char[max];
                    int index = max-1;
                    while(first>0 && second>0){
                        if(s.charAt(first-1)==t.charAt(second-1)){
                            ch[index] = s.charAt(first-1);
                            index--;
                            first--;
                            second--;
                        }
                        else if(dp[first-1][second]>dp[first][second-1]){
                            first--;
                        }else{
                            second--;
                        }
                    }
                    ans.add(new String(ch));
                }               
            }
        }
        System.out.println(ans);
        return null;   
    }
    public static void main(String[] args) {
       System.out.println(all_longest_common_subsequences("abaaa", "baabaca"));
    }
}   