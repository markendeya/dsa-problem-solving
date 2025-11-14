import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        HashSet<Character> present = new HashSet<>();
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        for(char c : s.toCharArray()){
            if(!present.contains(c)){
                while(!st.isEmpty() && c < st.peek() && hm.get(st.peek())>0){
                    present.remove(st.pop());
                }
                st.push(c);
                present.add(c);
            }
            hm.put(c,hm.get(c)-1);
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : st ){
            sb.append(ch);
        }
        return sb.toString();
    }
}
