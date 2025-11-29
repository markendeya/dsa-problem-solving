public class NextLetter {
    //    Input: letters = ["c","f","j"], target = "a"
//    Output: "c"
//    Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        while (left <= right) {
           int mid = (left + right) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left == letters.length ? letters[0] : letters[left];
        //return letters[start % n];
    }
}
