public class ValidWord {

    public boolean isValid(String word) {

        if (word.length() < 3)
            return false;

        String vowels = "aeiouAEIOU";
        boolean hasVowel = false;
        boolean hasConsonant = false;

        for (char ch : word.toCharArray()) {
            if (!Character.isLetter(ch) && !Character.isDigit(ch))
                return false;

            // Check vowel or consonant
            if (Character.isLetter(ch)) {
                if (vowels.indexOf(ch) != -1) {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            }
        }

        return hasVowel && hasConsonant;
    }
}
