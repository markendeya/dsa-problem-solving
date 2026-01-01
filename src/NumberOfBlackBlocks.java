import java.util.HashMap;
// 2X2 subgrid
//0 black blocks → 0
//        1 black block  → 3
//        2 black blocks → 1
//        3 black blocks → 0
//        4 black blocks → 0
public class NumberOfBlackBlocks {
    public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int[] coordinate: coordinates){
            int row = coordinate[0];
            int col = coordinate[1];
            int[][] dirs ={{-1,-1},{0,-1},{-1,0},{0,0}};
            for(int[] dir: dirs){
                int topRow = row+dir[0];
                int topCol = col+dir[1];
                if(topRow>=0 && topRow<m-1 && topCol>=0 && topCol<n-1){
                    String key = topRow+","+topCol;
                    map.put(key,map.getOrDefault(key,0)+1);
                }

            }
        }
        long[] ans = new long[5];
        for(int blockCount: map.values()){
            ans[blockCount]++;
        }
        long totalCount = (long) (m-1)*(n-1);
        ans[0] = totalCount - ans[1]-ans[2]-ans[3]-ans[4];
        return ans;

    }
}
