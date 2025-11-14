public class NDigit {

    public int findNthDigit(int n) {
        int digitLen = 1;
        int count = 9;
        int start =1;

        while(n>digitLen*count){
            n-=digitLen*count;
            digitLen++;
            count*=10;
            start*=10;
        }
        start+=(n-1)/digitLen;
        String finalNumber = String.valueOf(start);
        int finalDigit = Integer.parseInt(String.valueOf(finalNumber.charAt((n-1)%digitLen)));
        return finalDigit;
    }
    public static void main(String[] args) {
        NDigit solution = new NDigit();
        System.out.println(solution.findNthDigit(3)); // Example 1
        System.out.println(solution.findNthDigit(110000)); // Example 2
        System.out.println(solution.findNthDigit(15)); // Example 3
    }
}
