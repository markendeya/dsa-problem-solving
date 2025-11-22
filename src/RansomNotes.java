import java.util.HashMap;
//Input: Ransom Note = "hello", Magazine = "hellworld"
//Expected Output: true
//Justification: The word "hello" can be constructed from the letters in "hellworld".
public class RansomNotes {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> charCount = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            if (!charCount.containsKey(c) || charCount.get(c) == 0) {
                return false;
            }
            charCount.put(c, charCount.get(c) - 1);
        }

        return true;
    }
}