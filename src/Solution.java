import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String [] args){
//      int output =   getMaxLen(new int[]{1,-2,3,4});
     // int output = largestSubmatrix(new int[][]{{1,0,1},{1,1,1},{1,0,1}});
      long output = countGood(new int[]{2,2,2,2,3},3);
      System.out.println(output);
    }
    public static int getMaxLen(int[] nums) {
        int maxCount =0;
        int count =0;
        int product = 1;
        for(int i=0;i<nums.length;i++){
            product=1;
            count =0;
            for(int j=i;j<nums.length;j++){
                product*=nums[j];
                if(product>0){
                    count++;
                }
                maxCount = Math.max(maxCount,count);
            }

        }
        return maxCount;
    }

    public static int largestSubmatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // Step 1: Convert to heights matrix
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) matrix[i][j] += matrix[i-1][j];
            }
        }

        int maxArea = 0;
        // Step 2 & 3: Sort each row and calculate max area
        for (int[] row : matrix) {
            Arrays.sort(row);
            for (int j = n - 1; j >= 0; j--) {
                int width = n - j;
                maxArea = Math.max(maxArea, row[j] * width);
            }
        }
        return maxArea;
    }

    public  static long countGood(int[] nums, int k) {

        int i=0;
        long ans =0;
        int count =0;
        int n= nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int j=0;j<nums.length;j++){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            if(map.get(nums[j]) >1){
                count+=map.get(nums[j])-1;
            }
            while(i<=j && count>=k){
                ans+= n-j;
                map.put(nums[i],map.getOrDefault(nums[i],0)-1);
                if(map.get(nums[i]) >= 1){
                    count-= map.get(nums[i]);
                }
                i++;
            }
        }
        return ans;
    }
}

