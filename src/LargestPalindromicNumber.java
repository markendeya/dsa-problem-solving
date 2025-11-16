public class LargestPalindromicNumber {

    public String largestPalindromic(String num) {
        int[] digits = new int[10];
        StringBuilder left = new StringBuilder();
        int middle =-1;
        for(char ch: num.toCharArray()){
            digits[ch-'0']++;
        }
        for(int i=9;i>=0;i--){
            int count = digits[i];
            while(count>=2){
                if(i == 0 && left.isEmpty()) break;
                left.append(i);
                count-=2;
            }
            if(count == 1 && middle ==-1){
                middle=i;
            }
        }
        String right = new StringBuilder(left).reverse().toString();
        if(middle!=-1){
            return left.toString()+middle+right;
        }else{
            return left.isEmpty() ? "0":left.toString()+right;
        }

    }
}
