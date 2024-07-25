import java.util.HashMap;

public class MinChangesContest {    
    public int minChanges(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length/2; i++){
            int diff = Math.abs(nums[i]-nums[nums.length-i-1]);
            if(map.containsKey(diff))
                map.put(diff, map.get(diff)+1);
            else   
                map.put(diff, 1);
        }
        for(int i = 0; i<nums.length/2; i++){
            int diff =Math.abs(nums[i]-nums[nums.length-i-1]);
            int cnt = 0;
            int min = Integer.MAX_VALUE;
            for(int j = i+1; j<nums.length/2; j++){
                int currDiff = Math.abs(nums[j]-nums[nums.length-j-1]);
                if(diff==currDiff)
                    continue;
                int req = Math.abs(diff-currDiff);
                if(req<=k)
                    cnt++;
                else if(diff<=k)
                    cnt+=2;
                else
                    cnt = Integer.MAX_VALUE;
            }
            min = Math.min(cnt, min);
        }
        return min;
    }
    public static void main(String[] args) {
        

    }
}
