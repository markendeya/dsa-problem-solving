import java.util.HashMap;

public class MaximumNumberofBalloons {

    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> charCount = new HashMap<>();

        for (char c : text.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        int minCount = Integer.MAX_VALUE;
        minCount = Math.min(minCount, charCount.getOrDefault('b', 0));
        minCount = Math.min(minCount, charCount.getOrDefault('a', 0));
        minCount = Math.min(minCount, charCount.getOrDefault('l', 0) / 2);
        minCount = Math.min(minCount, charCount.getOrDefault('o', 0) / 2);
        minCount = Math.min(minCount, charCount.getOrDefault('n', 0));

        return minCount;
    }
}
