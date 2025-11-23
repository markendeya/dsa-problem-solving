public class LongestPalindromeString {

        int bestStart = 0;
        int bestLength = 0;

        public String longestPalindrome(String s) {
            if (s.length() < 2) return s;

            for (int i = 0; i < s.length(); i++) {
                expand(s, i, i);     // odd
                expand(s, i, i + 1); // even
            }

            return s.substring(bestStart, bestStart + bestLength);
        }

        private void expand(String s, int left, int right) {
            while (left >= 0 && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            int currentLength = right - left - 1; //(right-1)-(left+1)+1

            if (currentLength > bestLength) {
                bestLength = currentLength;
                bestStart = left + 1;
            }
        }

}
