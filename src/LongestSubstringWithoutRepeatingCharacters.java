import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
   // s = "substring" ans=8 ubstring
    //concept hashmap two pointers
    public static int lengthOfLongestSubstring(String s) {
       int start =0;
       int maxLen =0;
        HashMap<Character,Integer> hm = new HashMap<>();
       for(int end =0;end<s.length();end++){
           char ch = s.charAt(end);
           hm.put(ch,hm.getOrDefault(ch,0)+1);
           while(hm.get(ch)>1){
               char startch = s.charAt(start);
               hm.put(startch, hm.getOrDefault(startch,0)-1);
               start++;
           }
           maxLen = Math.max(maxLen,end - start+1);
           System.out.println(s.substring(start,end+1));
       }
       return maxLen;
    }

    public static int lengthOfLongestSubstringOptimised(String s) {
        int start =0;
        int maxLen =0;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int end =0;end<s.length();end++){
            char ch = s.charAt(end);
            if(hm.containsKey(ch)){
                start = Math.max(start,hm.get(ch)+1);
            }
            hm.put(ch,end);
            maxLen = Math.max(maxLen,end - start+1);
            System.out.println(s.substring(start,end+1));
        }
        return maxLen;
    }
    public static void main(String[] args){
       // int len = lengthOfLongestSubstring("substring");
        int len = lengthOfLongestSubstringOptimised("substring");
        System.out.println(len);
    }
}
