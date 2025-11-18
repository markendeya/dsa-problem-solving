import java.util.Stack;

public class Pattern132 {
    public boolean find132pattern(int[] nums) {
        int third = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<Integer>();
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]<third) return true;
            while(!st.isEmpty() && st.peek()< nums[i]){
                third = st.pop();
            }
            st.push(nums[i]);
        }
        return false;
    }
}
