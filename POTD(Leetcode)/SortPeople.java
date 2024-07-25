import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SortPeople {
    static class Pair implements Comparable<Pair>{
        String name;
        int heights;
        public Pair(String name, int heights){
            this.name = name;
            this.heights = heights;
        }
        @Override
        public int compareTo(Pair o) {
            return o.heights-this.heights;
        }
    }
    public String[] sortPeople(String[] names, int[] heights) {
        ArrayList<Pair> list = new ArrayList<>();
        for(int i = 0; i<names.length; i++)
            list.add(new Pair(names[i], heights[i]));
        Collections.sort(list);
        for(int i = 0; i<list.size(); i++){
            names[i] = list.get(i).name;
        }
        return names;
    }
}
