public class MinimumWindowSort {
   /* Input: [1, 2, 5, 3, 7, 10, 9, 12]
    Output: 5
    Explanation: We need to sort only the subArray [5, 3, 7, 10, 9] to make the whole array sorted
    */

    public int sort(int[] arr) {
        int low=0;
        int n=arr.length-1;
        while(low<n && arr[low]<=arr[low+1]){
            low++;
        }
        if(low == n-1){
            return 0;
        }
        int high = n;
        while(high>0 && arr[high-1] <=arr[high]){
            high--;
        }
        int min = Integer.MAX_VALUE; int max = Integer.MIN_VALUE;
        for(int i= low;i<=high;i++){
            min=Math.min(min,arr[i]);
            max=Math.max(max,arr[i]);
        }
        while(low>0 && arr[low-1]>min){
            low--;
        }
        while(high<n && arr[high+1]<max){
            high++;
        }
        return high-low+1;
    }

    public static void main(String[] args) {
        MinimumWindowSort sol = new MinimumWindowSort();
        System.out.println(sol.sort(new int[] { 1, 2, 5, 3, 7, 10, 9, 12 }));
        System.out.println(sol.sort(new int[] { 1, 3, 2, 0, -1, 7, 10 }));
        System.out.println(sol.sort(new int[] { 1, 2, 3 }));
        System.out.println(sol.sort(new int[] { 3, 2, 1 }));
    }
}
