import java.util.HashMap;

public class longestPalindromeLength {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int max=0;
        int middle =-1;
        for(char ch: s.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        for(int count: hm.values()){
            while(count>=2){
                max+=2;
                count-=2;
            }
            if(count == 1 && middle==-1){
                middle=1;
            }
        }
        if(middle !=-1){
            return max+middle;
        }else{
            return max;
        }
    }
    public int longestPalindromeOptimised(String s) {
            int[] freq = new int[128];
            for (char c : s.toCharArray()) {
                freq[c]++;
            }

            int length = 0;
            boolean hasOdd = false;

            for (int count : freq) {
                length += (count / 2) * 2;  // add pairs
                if (count % 2 == 1) hasOdd = true;
            }

            return hasOdd ? length + 1 : length;
        }

}
