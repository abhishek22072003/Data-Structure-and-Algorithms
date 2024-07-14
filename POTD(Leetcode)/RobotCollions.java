import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class RobotCollions {
    static class Pair{
        int index;
        int position;
        int health;
        char direction;
        public Pair(int index, int position, int health,  char direction){
            this.index = index;
            this.position = position;
            this.health = health;
            this.direction = direction;            
        }
    }
    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int [] ans = new int[10000];
        Stack<Pair> s = new Stack<>();
        ArrayList<Pair> list = new ArrayList<>();
        for(int i = 0; i<positions.length; i++){
            list.add(new Pair(i, positions[i], healths[i], directions.charAt(i)));
        }       
        Collections.sort(list, (a, b)->a.position-b.position);
       for(Pair p: list){
            if(s.isEmpty()){
                s.push(p);
            }
            else if(s.peek().direction==p.direction || s.peek().direction=='L' && p.direction=='R'){
                s.push(p);
            }
            else{
                if(s.peek().health==p.health){
                    Pair xp = s.pop();
                    ans[xp.position] = 0;
                    ans[p.position] = 0;
                }
                else if(s.peek().health < p.health){
                    Pair xp = s.pop();
                    ans[xp.position] =0;                    
                    p.health--;                    
                    s.push(p);
                }else{
                    Pair xp = s.pop();
                    xp.health--;
                    s.push(xp);
                    ans[p.position] = 0;
                }
            }
            
       } 
       while(!s.isEmpty()){
            Pair xp = s.pop();
            ans[xp.position] = xp.health;
       }
       ArrayList<Integer> curr = new ArrayList<>();
       for(int i =  0; i<positions.length; i++){
            if(ans[positions[i]]!=0)
                curr.add(ans[positions[i]]);
       }
       return curr;
    }
    public static void main(String[] args) {
        int [] positions = {3,5,2,6};
        int [] health = {10,10,15,12};
        String direction = "RLRL";
        System.out.println(survivedRobotsHealths(positions, health, direction));
    }
}
