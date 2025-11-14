public class ReverseWordsinaString {
    //Input: ["h","e","l","l","o"," ","w","o","r","l","d"]
   // Expected Output: ["w","o","r","l","d"," ","h","e","l","l","o"]
    public char[] reverseWords(char[] s) {
        reverse(0,s.length-1,s);
        int start =0;
        for(int i=0;i<=s.length;i++){
            if( i==s.length || s[i] == ' '){
                reverse(start,i-1,s);
                start=i+1;
            }
        }
        return s;
    }
    private void reverse(int start,int end,char[] s){
        while(start<end) {
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }
    public static void main(String[] args) {
        ReverseWordsinaString solution = new ReverseWordsinaString();
        // Example 1
        char[] example1 = {'h','e','l','l','o',' ','w','o','r','l','d'};
        solution.reverseWords(example1);
        System.out.println(example1);

        // Example 2 (Revised)
        char[] example2 = {'m','o','r','n','i','n','g',' ','s','k','y',' ','i','s',' ','b','r','i','g','h','t'};
        solution.reverseWords(example2);
        System.out.println(example2);

        // Example 3
        char[] example3 = {'a','l','o','n','e'};
        solution.reverseWords(example3);
        System.out.println(example3);
    }
}
