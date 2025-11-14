import java.util.ArrayList;

public class MaxSumNonAdj {

    public static void main(String [] args){
        houseRobber(new int[] {2, 1, 4, 9});
    }

    public static int houseRobber(int[] money) {
        int n= money.length;
        int[] dp = new int[n];
        dp[0]=0;
        dp[1]=money[0];
        for(int i=2;i<n;i++){
            int pick=0;
            if(i>1){
                pick=money[i]+dp[i-2];
            }
            int notpick = dp[i-1];
            dp[i] = Math.max(pick,notpick);
        }
        return dp[n-1];
    }
    private static void combinational(ArrayList<ArrayList<Integer>> ans, int[] arr, int k, ArrayList<Integer> ls, int i, int n){

        if(ls.size() == k){
            ans.add(new ArrayList<>(ls));
            return;
        }
        if(i==n) return;
        ls.add(arr[i]);
        combinational(ans,arr,k,ls,i+1,n);
        ls.remove(ls.size()-1);
        combinational(ans,arr,k,ls,i+1,n);
    }

    private static void binary( ArrayList<String> ans,int n,String sb){
        if(sb.length() == n ){
            ans.add(sb);
            return;
        }

        binary(ans,n,sb+"0");
        binary(ans,n,sb+"1");
    }
}
