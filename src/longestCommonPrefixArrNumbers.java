import java.util.HashSet;
//Input: arr1 = [1,10,100], arr2 = [1000]
//Output: 3
//Explanation: There are 3 pairs (arr1[i], arr2[j]):
//        - The longest common prefix of (1, 1000) is 1.
//        - The longest common prefix of (10, 1000) is 10.
//        - The longest common prefix of (100, 1000) is 100.
//The longest common prefix is 100 with a length of 3.
public class longestCommonPrefixArrNumbers {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> prefixSet = new HashSet<>();
        // Step 1: store prefixes of arr1
        for (int num : arr1) {
            String s = String.valueOf(num);
            for (int i = 1; i <= s.length(); i++) {
                prefixSet.add(s.substring(0, i));
            }
        }
        int longest = 0;
        // Step 2: check prefixes from arr2
        for (int num : arr2) {
            String s = String.valueOf(num);
            for (int i = 1; i <= s.length(); i++) {
                String p = s.substring(0, i);
                if (prefixSet.contains(p)) {
                    longest = Math.max(longest, p.length());
                }
            }
        }
        return longest;
    }
}
