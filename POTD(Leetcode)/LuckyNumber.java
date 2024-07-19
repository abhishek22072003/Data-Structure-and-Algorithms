import java.util.ArrayList;
import java.util.List;

public class LuckyNumber {
    public static List<Integer> luckyNumbers (int[][] matrix) {
        int [] row = new int[matrix.length];
        int [] column = new int[matrix[0].length];
        // find each row max
        for(int i = 0; i<matrix.length; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j<matrix[0].length; j++){
                min = Math.min(min, matrix[i][j]);
            }
            row[i] = min;
        }
        // find each column max
        for(int i = 0; i<matrix[0].length; i++){
            int max = -1;
            for(int j = 0; j<matrix.length; j++){
                max = Math.max(max, matrix[j][i]);
            }
            column[i] = max;
        }        
        //find how many rows and column matches with one another
        List<Integer> ans = new ArrayList<>();
        for(int i= 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                if(row[i]==column[j]){
                    ans.add(row[i]);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int [][] matrix = {{3,7,8},{9,11,13},{15,16,17}};
        System.out.println(luckyNumbers(matrix));
    }
}
