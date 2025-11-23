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
        HashMap<Character,Integer> map = new HashMap<>();
        int left=0;
        int maxLenth=0;
        for(int right=0;right<s.length();right++){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                left = Math.max(left,map.get(ch)+1);
            }
            map.put(ch,right);
            maxLenth = Math.max(maxLenth,right-left+1);
        }
        return maxLenth;
    }
    public static void main(String[] args){
       // int len = lengthOfLongestSubstring("substring");
        int len = lengthOfLongestSubstringOptimised("substring");
        System.out.println(len);
    }
}
