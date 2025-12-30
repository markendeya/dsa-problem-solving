public class NumberofAdjEleWithSameColor {
//    input: n = 4, queries = [[0,2],[1,2],[3,1],[1,1],[2,1]]
//
//    Output: [0,1,1,0,2]
//
//    Explanation:
//
// Initially array colors = [0,0,0,0], where 0 denotes uncolored elements of the array.
// After the 1st query colors = [2,0,0,0]. The count of adjacent pairs with the same color is 0.
// After the 2nd query colors = [2,2,0,0]. The count of adjacent pairs with the same color is 1.
// After the 3rd query colors = [2,2,0,1]. The count of adjacent pairs with the same color is 1.
// After the 4th query colors = [2,1,0,1]. The count of adjacent pairs with the same color is 0.
// After the 5th query colors = [2,1,1,1]. The count of adjacent pairs with the same color is 2.
    public int[] colorTheArray(int n, int[][] queries) {
        int[] arr = new int[n];
        int[] ans = new int[queries.length];
        int count=0;
        for(int i=0;i<queries.length;i++){
            int idx = queries[i][0];
            int color = queries[i][1];
            if(arr[idx]!=0){
                if(idx > 0 && arr[idx-1] == arr[idx]) count--;
                if(idx<n-1 && arr[idx] == arr[idx+1]) count--;
            }
            arr[idx] = color;
            if(idx>0 && arr[idx-1] == arr[idx]) count++;
            if(idx<n-1 && arr[idx] == arr[idx+1]) count++;

            ans[i] = count;
        }
        return ans;
    }
}
