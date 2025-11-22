import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniqueChars {
  /*  Input: str="araaci", K=2
    Output: 4
    Explanation: The longest substring with no more than '2' distinct characters is "araa".
   */
    public int findLength(String str, int k) {

        int left = 0, maxLength = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (int right = 0; right < str.length(); right++) {
            char rightChar = str.charAt(right);
            charFrequencyMap.put(rightChar,
                    charFrequencyMap.getOrDefault(rightChar, 0) + 1);
            while (charFrequencyMap.size() > k) {
                char leftChar = str.charAt(left);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
