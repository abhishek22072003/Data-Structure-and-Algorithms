import java.util.Arrays;
import java.util.Scanner;

public class A{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int tt = 0; tt<T; tt++){
            int sz = in.nextInt(), x = in.nextInt();
            int [] arr = new int[sz];
            for(int i = 0; i<sz; i++)
                arr[i] = in.nextInt();
            Arrays.sort(arr);
            long cnt = 0;
            long sum = 0;
            for(int i = sz-1; i>=0; i--){
                if(arr[i] > x){
                    sum += arr[i]-x;
                }
                else if(arr[i] < x){
                    int req = x-arr[i];
                    if(sum >= req){
                        sum -= req;
                    }else{
                        break;
                    }
                }
                cnt++;
            }
            System.out.println(cnt);
        }
            
    }
}