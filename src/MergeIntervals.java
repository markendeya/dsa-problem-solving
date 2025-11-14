import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals,(a, b) -> Integer.compare(a[0],b[0]));
            List<int[]> ans = new LinkedList<>();
            for(int[] interval : intervals){
                if(ans.isEmpty() || ans.getLast()[1]<interval[0]){
                    ans.add(interval);
                }else{
                    ans.getLast()[1] = Math.max(ans.getLast()[1],interval[1]);
                }
            }
            return ans.toArray(new int[ans.size()][]);
        }
    }
