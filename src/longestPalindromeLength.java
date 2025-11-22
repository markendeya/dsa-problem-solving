import java.util.HashMap;
//Input: s = "abccccdd"
//Output: 7
//Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
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
    public int longestPalindromeOptimised3(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int length = 0;
        boolean oddFound = false;
        for (int freq : map.values()) {
            if (freq % 2 == 0) {
                length += freq;
            } else {
                length += freq - 1;
                oddFound = true;
            }
        }
        if (oddFound) length++;

        return length;
    }

}
