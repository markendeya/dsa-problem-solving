import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithSameLettersReplacement {

    public int findLength(String str, int k) {
        int left = 0, maxLength = 0, maxRepeatLetterCount = 0;
        Map<Character, Integer> letterFrequencyMap = new HashMap<>();
        for (int right = 0; right < str.length(); right++) {
            char rightChar = str.charAt(right);
            letterFrequencyMap.put(rightChar,
                    letterFrequencyMap.getOrDefault(rightChar, 0) + 1);
            maxRepeatLetterCount =
                    Math.max(maxRepeatLetterCount, letterFrequencyMap.get(rightChar));

            if (right - left + 1 - maxRepeatLetterCount > k) {
                char leftChar = str.charAt(left);
                letterFrequencyMap.put(leftChar, letterFrequencyMap.get(leftChar) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
