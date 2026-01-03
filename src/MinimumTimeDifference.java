import java.util.Arrays;
import java.util.List;
/*Input: timePoints = ["23:59","00:00"]
Output: 1
 */
public class MinimumTimeDifference {
        public int findMinDifference(List<String> timePoints) {

            int n = timePoints.size();
            int[] minutes = new int[n];

            // Step 1: Convert time to minutes
            for (int i = 0; i < n; i++) {
                String[] parts = timePoints.get(i).split(":");
                int hour = Integer.parseInt(parts[0]);
                int min = Integer.parseInt(parts[1]);
                minutes[i] = hour * 60 + min;
            }

            // Step 2: Sort
            Arrays.sort(minutes);

            // Step 3: Find min difference between adjacent times
            int minDiff = Integer.MAX_VALUE;
            for (int i = 1; i < n; i++) {
                minDiff = Math.min(minDiff, minutes[i] - minutes[i - 1]);
            }

            // Step 4: Circular difference
            int wrapDiff = 1440 - minutes[n - 1] + minutes[0];
            minDiff = Math.min(minDiff, wrapDiff);

            return minDiff;
        }
}
