import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class B{
    static class Pair implements Comparable<Pair>{
        int number;
        int freq;
        public Pair(int number, int freq){
            this.number = number;
            this.freq = freq;
        }
        @Override
        public int compareTo(Pair o){
            return this.freq - o.freq;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int tt = 0; tt<T; tt++){
            int sz = in.nextInt();
            int [] arr = new int[sz];
            for(int i =0 ; i<sz; i++){
                arr[i] = in.nextInt();
            }
            HashMap<Integer, Integer> map  =  new HashMap<>();
            for(int a: arr)
                map.put(a, map.getOrDefault(a, 0)+1);
            Pair [] p = new Pair[map.size()];
            int i = 0;
            for(int key: map.keySet())
                p[i++] = new Pair(key, map.get(key));
            Arrays.sort(p);
            int max = 0;
            for(i = 0; i<p.length; i++){
                max = Math.max(max, (p.length-i)*p[i].freq);
            }
            System.out.println(max);     
        }
            
    }
}