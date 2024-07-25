import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class SortByFreq {
    static class Pair implements Comparable<Pair>{
        int number;
        int freq;
        public Pair(int number, int freq){
            this.number = number;
            this.freq = freq;
        }
        @Override
        public int compareTo(Pair o) {
           if(this.freq==o.freq){
                return o.number - this.number;
           }else{
            return this.freq-o.freq;
           }
        }
        
    }
    public static int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a: nums)
            map.put(a, map.getOrDefault(a, 0)+1);
        ArrayList<Pair> list = new ArrayList<>();
        for(int k: map.keySet())
            list.add(new Pair(k, map.get(k)));
        Collections.sort(list);
        int [] ans  = new int[nums.length];
        int index = 0;
        for(Pair p: list){
            int f = p.freq;
            while(f-->0){
                ans[index] = p.number;
                index++;
            }
        }
        return ans;

    }
    public static void main(String[] args) {
        int [] arr  = {-1,1,-6,4,5,-6,1,4,1};
        System.out.println(Arrays.toString(frequencySort(arr)));
    }
}
