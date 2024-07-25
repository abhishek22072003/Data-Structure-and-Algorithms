import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int tt = 0; tt<T; tt++){
            int sz  = in.nextInt(), k = in.nextInt();
             char [] ch =  in.next().toCharArray();
            int j = 0;
            while(j<sz && k>0){
                if(ch[j] == '1'){
                    ch[j]='0';
                    k--;
                }
            }
            int curr = 0;
            long ans = 0;
            for(int i = 0; i<sz; i++){
                if(ch[i]=='1')
                    curr++;
                else
                    ans += curr;
            }
            System.out.println(ans);
        }
    }
}
