import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T  = in.nextInt();
        for(int tt = 0; tt<T; tt++){
            int sz = in.nextInt();
            long [] arr = new long[sz];
            for(int i = 0; i<sz; i++)
                arr[i] = in.nextLong();
            int ans = 0;
            for(int i = 1; i<arr.length; i++){
                if(arr[i]>=arr[i-1])
                    continue;
                if(arr[i]<arr[i-1]){
                    if(arr[i]==arr[i]*arr[i]){
                        ans = -1;
                        break;
                    }
                    while(arr[i]<arr[i-1]){
                        arr[i]  = arr[i] * arr[i];
                        ans++;
                    }
                        
                }
            }
            System.out.println(ans);
        }
    }
}
