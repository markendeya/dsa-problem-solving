import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class BuildingsWithanOceanView {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[st.peek()] <= heights[i]) {
                st.pop();
            }
            st.push(i);

        }
        int[] ans = new int[st.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        return ans;
    }
    public int[] findBuildingsWithoutStack(int[] heights) {
        int maxheight=Integer.MIN_VALUE;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=heights.length-1;i>=0;i--){
            if(maxheight<heights[i]){
                ans.add(i);
                maxheight= heights[i];
            }
        }
        Collections.sort(ans);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
