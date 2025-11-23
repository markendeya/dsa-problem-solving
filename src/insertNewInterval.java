import java.util.ArrayList;
import java.util.List;

class insertNewInterval {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> merge = new ArrayList<>();
            int i=0;
            int n = intervals.length;
            while(i<n && intervals[i][1] < newInterval[0]){
                merge.add(intervals[i]);
                i++;
            }
            while(i<n && intervals[i][0] <= newInterval[1]){
                newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
                i++;
            }
            merge.add(newInterval);
            while(i<n){
                merge.add(intervals[i++]);
            }
            return merge.toArray(new int[][]{});

        }
    }