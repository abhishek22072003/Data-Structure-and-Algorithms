public class StringAllSubsequences {
    static void print(int index, String curr, String s){
        if(index==s.length()){
            System.out.println(curr);
            return;
        }                
        curr += s.charAt(index);    
        print(index+1, curr, s);
        curr = curr.substring(0, curr.length()-1);
        print(index+1, curr, s);
    }
    public static void main(String[] args) {
        print(0, "","abhi");
    }
}
