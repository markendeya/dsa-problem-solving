
import java.util.Stack;
import java.util.Arrays;

public class StackTemperature {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();  // Initialize a stack to store indices of temperatures.
        int[] res = new int[temperatures.length];  // Initialize a result array.

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // While the stack is not empty and the current temperature is higher
                // than the temperature at the index stored at the top of the stack:
                int idx = stack.pop();  // Pop the top index from the stack.
                res[idx] = i - idx;  // Calculate the number of days until warmer temperature.
            }
            stack.push(i);  // Push the current index onto the stack.
        }
        return res;
    }

    public static void main(String[] args) {
        StackTemperature solution = new StackTemperature();
        int[] temperatures1 = {70, 73, 75, 71, 69, 72, 76, 73};
        int[] temperatures2 = {73, 72, 71, 70};
        int[] temperatures3 = {70, 71, 72, 73};
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures1))); // Output: [1, 1, 4, 2, 1, 1, 0, 0]
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures2))); // Output: [0, 0, 0, 0]
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures3))); // Output: [1, 1, 1, 0]
    }
}
