import java.util.ArrayList;
import java.util.List;

public class intervalIntersection {
        public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

            List<int[]> merge = new ArrayList<>();
            int i=0,j=0;
            int n = firstList.length;
            int m = secondList.length;

            while(i<n && j<m){
                if((firstList[i][0] >= secondList[j][0] && firstList[i][0] <= secondList[j][1]) ||
                        (secondList[j][0] >= firstList[i][0] && secondList[j][0] <= firstList[i][1])){
                    int start = Math.max(firstList[i][0],secondList[j][0]);
                    int end = Math.min(firstList[i][1],secondList[j][1]);
                    merge.add(new int[]{start,end});
                }
                if(firstList[i][1] <secondList[j][1]){
                    i++;
                }else{
                    j++;
                }
            }
            return merge.toArray(new int[][]{});
        }
    }